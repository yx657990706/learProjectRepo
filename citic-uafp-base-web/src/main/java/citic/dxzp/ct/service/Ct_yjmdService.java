/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-02-29]
 * =============================================
 */

package citic.dxzp.ct.service;

/**
 * <p>
 * Cgb_risk_caseService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import citic.aml.base.AmlBaseService;
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.base.utils.FileUtils;
import citic.base.utils.ZipUtil;
import citic.dxzp.ct.domain.Ct_request_log;
import citic.dxzp.ct.domain.Ct_yjmd;
import citic.dxzp.ct.domain.Ct_yjmd_private;
import citic.dxzp.ct.domain.Ct_yjmd_public;
import citic.dxzp.ct.domain.Ct_yjmd_request;
import citic.dxzp.ct.domain.Ct_yjmd_response;

import com.csvreader.CsvReader;
import com.google.common.collect.Lists;

@Service
public class Ct_yjmdService extends AmlBaseService {
	
	private final int BATCH_NUM = 1000;// 批处理最大数量
	private final String TEMPPATH = "webtemp";//文件上传临时目录
	
	@Autowired
	@Qualifier("busi")
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8659828683150141199L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/** map命名空间 */
	private String namespace = "citic.dxzp.ct.mapper.busi.Ct_yjmdMapper.";
	
	/** 客户类型 01：个人客户 02：企业客户 */
	private final String PERSON = "01";
	private final String UNIT = "02";
	
	/**
	 * 名单上传文件查询
	 * 
	 * @param ct_yjmd
	 * @return
	 */
	public List<Ct_yjmd> getCt_yjmd_fileList(Ct_yjmd ct_yjmd) {
		// 定义转换码表
		String[] cdColumns = new String[] {"md_type:G00004:md_type_disp", "status_cd:G00005:status_cd_disp"};
		List<Ct_yjmd> list = busiDao.selectList(namespace + "selectCt_yjmd_fileByVo", ct_yjmd);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		
		return list;
	}
	
	public void uploadMdFile(Ct_yjmd ct_yjmd) throws Exception {
		MultipartFile file = ct_yjmd.getMd_file();
		String file_name = file.getOriginalFilename();
		String file_path = "";//设置路径
		String file_size = file.getSize() / 1024 + "K";//文件大小kb
		file_path = codeService.getCodeValue("Dpara", "1") + File.separatorChar + TEMPPATH + File.separatorChar
					+ DtUtils.getNowDate("yyyyMMdd");
		ct_yjmd.setFile_path(file_path);//文件绝对路径
		ct_yjmd.setCreate_dt(DtUtils.getNowTime());//上传时间
		ct_yjmd.setFile_code(UUID.randomUUID().toString().replaceAll("-", ""));//uuid做主键
		ct_yjmd.setFile_name(file_name);//文件名称
		ct_yjmd.setFile_size(file_size);
		ct_yjmd.setStatus_cd("0");//0:待处理  1：处理成功 2：处理失败
		
		//上传附件
		FileUtils.uploadFile(file.getInputStream(), file_path, file_name);
		//插入记录
		busiDao.insert(namespace + "insertCt_yjmd_file", ct_yjmd);
	}
	
	/**
	 * 解析上传的名单文件
	 * 定时任务
	 * 1.查询待处理的zip文件，逐个解析
	 * 2.对于每个zip，解析出来的CSV按单个同名文件处理
	 * 3.对于每个CSV，数据用list接收，X条记录一次提交，写入临时表中
	 * 3.1数据分为对公对私2种，设计为2个表，因此2个临时表，2个数据表
	 * 4.所有excle处理完成后，将临时表数据处理到数据表中，采用merge方式。
	 * 5.更新名单文件的处理状态和时间，以及说明【成功写入名单文件处理完成，失败写原因】
	 * 6.清空临时表
	 */
	public void unZipFile() {
		
		//1.查询待解析zip包
		List<Ct_yjmd> list = busiDao.selectList(namespace + "selectCt_yjmd_fileByStatus", null);
		//2.//根据路劲解析zip
		if (list != null && list.size() > 0) {
			int m = 0;//统计个人更新数据条数
			int n = 0;//统计单位更新数据条数
			for (int i = 0; i < list.size(); i++) {
				Ct_yjmd file = list.get(i);
				try {
					//插入数据前，清空临时表
					if (PERSON.equals(file.getMd_type())) {
						busiDao.update(namespace + "updateTmp_ct_yjmd_private", null);//发生异常后，清空临时表
					} else {
						busiDao.update(namespace + "updateTmp_ct_yjmd_public", null);
					}
					//以CSV文件为单位插入数据，正常则errMsg为空
					String errMsg = insertFileDate(file.getFile_path(), file.getFile_name(), file.getMd_type());
					//修改文件处理状态
					file.setInstructions(errMsg);
					file.setDeal_dt(DtUtils.getNowTime());
					if (StringUtils.isBlank(errMsg)) {
						file.setStatus_cd("1");//0：待处理 1：处理成功 2：处理失败
					} else {
						file.setStatus_cd("2");
					}
					long a = System.currentTimeMillis();//用于任务计时
					//将临时表数据以merge方式更新到正式表中
					if (PERSON.equals(file.getMd_type())) {//个人黑名单
						m += busiDao.update(namespace + "updateCt_yjmd_private", null);
						logger.info("个人更新耗时：" + (System.currentTimeMillis() - a) + "毫秒");
					} else if (UNIT.equals(file.getMd_type())) {//单位黑名单
						n += busiDao.update(namespace + "updateCt_yjmd_public", null);
						logger.info("单位更新耗时：" + (System.currentTimeMillis() - a) + "毫秒");
					}
				} catch (Exception e) {
					file.setInstructions("可能原因：1.cvs文件内容未按约定生成；2.文件过大，导致更新超时");//设置失败原因
					file.setStatus_cd("2");//设置文件为处理失败
					logger.error(e.getMessage(),e);
				}
				//更新文件处理状态
				busiDao.update(namespace + "updateCt_yjmd_upload", file);
			}
			logger.info("定时任务执行结果：已经处理" + list.size() + "个zip数据包。其中更新个人数据：" + m + "条；单位数据：" + n + "条");
		} else {
			logger.info("定时任务执行结果：没有待处理的zip数据包");
		}
		
	}
	
	/**
	 * 解压文件，将数据入库
	 * 
	 * @param file_path 文件路径
	 * @param file_name 文件名
	 * @return
	 * @throws Exception
	 */
	private String insertFileDate(String file_path, String file_name, String md_type) {
		String errMsg = "";
		String fullFileName = file_path + File.separatorChar + file_name;//文件绝对路劲
		InputStreamReader read = null;
		CsvReader r = null;
		
		try {
			//解压文件到同一目录下
			ZipUtil.unZip(fullFileName, file_path);
			String filname = fullFileName.replace(".zip", ".csv");
			if (!filname.endsWith(".csv")) {
				return "文件格式区分大小写，请确认压缩文件为.zip格式";
			}
			File file = new File(filname);
			read = new InputStreamReader(new FileInputStream(file), "GBK");
			r = new CsvReader(read);
			r.readHeaders();//读取头部
			//数据插入处理
			if (PERSON.equals(md_type)) {
				dealDataByPrivate(r);
			} else {
				dealDataByPublic(r);
			}
		} catch (UnsupportedEncodingException e) {
			errMsg = "CSV文件UTF-8编码格式处理异常";
			logger.error("CSV文件读取时转码失败：{}", e.getMessage(), e);
		} catch (FileNotFoundException e) {
			errMsg = "未找到解压的CSV文件,请检查zip包名和CSV文件名是否一致";
			logger.error("未找到解压的CSV文件,请检查zip包名和CSV文件名是否一致：{}", e.getMessage(), e);
		} catch (IOException e) {
			errMsg = "CSV文件读取IO异常,请检查CSV文件内容";
			logger.error("CSV文件读取IO异常：{}", e.getMessage(), e);
		} catch (Exception e) {
			errMsg = "CSV数据插入异常,1.请检查文件类型和上传的文件是否一致2.个人文件时,请确认证件类型是代码而不是中文";
			logger.error("CSV数据插入异常：{}", e.getMessage(), e);
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				}
			}
			if (r != null) {
				try {
					r.close();
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}
		}
		return errMsg;
	}
	
	/**
	 * 个人CSV文件解析处理 <br>
	 * 编号 证件种类 证件代码 客户姓名 客户地址 违约类型 违约天数 所属地区 数据时点 <br>
	 * serialno,cert_type,cert_num,cust_name,cust_addr,deflt_type,deflt_day,cust_zone,data_month,
	 * valid_date
	 * 
	 * @param r
	 * @throws Exception
	 * @author yinxiong
	 * @date 2016年10月25日 下午9:19:46
	 */
	@BusiTx
	private void dealDataByPrivate(CsvReader r) throws Exception {
		int count = 0;// 待处理数据总数
		int n = 0;// 待处理数据总数／BATCH_NUM 后的余数
		List<Ct_yjmd_private> list = Lists.newArrayList();
		while (r.readRecord()) {
			String[] rs = r.getValues();//获取当前行的数据并转换为数组
			if (rs != null && rs.length > 0) {
				count++;
				n = count % BATCH_NUM;
				Ct_yjmd_private t = new Ct_yjmd_private();
				t.setSerialno(rs[0].trim());// 文件编码
				t.setCert_type(rs[1].trim());// 文件名
				t.setCert_num(rs[2].trim());
				t.setCust_name(rs[3].trim());
				t.setCust_addr(rs[4].trim());
				t.setDeflt_type(rs[5].trim());
				t.setDeflt_day(StringUtils.isBlank(rs[6]) ? "999999" : rs[6].trim());
				t.setCust_zone(rs[7].trim());
				t.setData_month(rs[8].trim());
				String valid_date = getValid_date(rs[8].trim());//计算有效期
				t.setValid_date(valid_date);
				list.add(t);
				//1000条数据做一次提交
				if (n == 0) {
					doBatchSqlByPrivate(list);// 批量处理
					list.clear();//清空list，节省资源
				}
			}
		}
		if (!r.readRecord() && list != null && list.size() > 0) {// 文件最后一次读取，不满足BATCH_NUM的条数
			doBatchSqlByPrivate(list);// 批量处理
			list.clear();
		}
		logger.info("当前个人银监黑名单CSV文件记录总数：" + count);
	}
	
	/**
	 * 单位CSV文件解析处理 <br>
	 * 编号 客户代码 客户名称 法人注册地 违约类型 违约天数 所属地区数据时点 <br>
	 * serialno,card_code,cust_name,cust_reg_addr,deflt_type,deflt_day,cust_zone,data_month
	 * valid_date
	 * 
	 * @param r
	 * @throws Exception
	 * @author yinxiong
	 * @date 2016年10月25日 下午9:20:14
	 */
	@BusiTx
	private void dealDataByPublic(CsvReader r) throws Exception {
		int count = 0;// 待处理数据总数
		int n = 0;// 待处理数据总数／BATCH_NUM 后的余数
		List<Ct_yjmd_public> list = Lists.newArrayList();
		while (r.readRecord()) {
			String[] rs = r.getValues();
			if (rs != null && rs.length > 0) {
				count++;
				n = count % BATCH_NUM;
				Ct_yjmd_public t = new Ct_yjmd_public();
				t.setSerialno(rs[0].trim());
				t.setCard_code(rs[1].trim());
				t.setCust_name(rs[2].trim());
				t.setCust_reg_addr(rs[3].trim());
				t.setDeflt_type(rs[4].trim());
				t.setDeflt_day(StringUtils.isBlank(rs[5]) ? "999999" : rs[5].trim());
				t.setCust_zone(rs[6].trim());
				t.setData_month(rs[7].trim());
				String valid_date = getValid_date(rs[7].trim());//计算有效期
				t.setValid_date(valid_date);
				list.add(t);
				//1000条数据做一次提交
				if (n == 0) {
					doBatchSqlByPublic(list);// 批量处理
					list.clear();//清空list，节省资源
				}
			}
		}
		if (!r.readRecord() && list != null && list.size() > 0) {// 文件最后一次读取，不满足BATCH_NUM的条数
			doBatchSqlByPublic(list);// 批量处理
			list.clear();
		}
		logger.info("当前单位银监黑名单CSV文件记录总数：" + count);
	}
	
	/**
	 * 批量提交对私
	 * 
	 * @param list
	 * @author yinxiong
	 * @date 2016年10月25日 下午8:33:41
	 */
	private void doBatchSqlByPrivate(List<Ct_yjmd_private> list) {
		List<Object[]> batch_data = new ArrayList<Object[]>(list.size());// 插入数据表
		String sql_data = "";
		for (Ct_yjmd_private val : list) {
			Object[] values_data = new Object[] {val.getSerialno(), val.getCert_type(), val.getCert_num(), val.getCust_name(), val.getCust_addr(), val.getDeflt_type(),
													val.getDeflt_day(), val.getCust_zone(), val.getData_month(), val.getValid_date()};
			batch_data.add(values_data);
		}
		sql_data = "insert into tmp_ct_yjmd_private(serialno,cert_type,cert_num,cust_name,cust_addr,deflt_type,deflt_day,cust_zone,data_month,valid_date)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql_data, batch_data);
		batch_data.clear();
	}
	
	/**
	 * 批量提交对公
	 * 
	 * @param list
	 * @author yinxiong
	 * @date 2016年10月25日 下午8:34:00
	 */
	private void doBatchSqlByPublic(List<Ct_yjmd_public> list) {
		List<Object[]> batch_data = new ArrayList<Object[]>(list.size());// 插入数据表
		String sql_data = "";
		for (Ct_yjmd_public val : list) {
			Object[] values_data = new Object[] {val.getSerialno(), val.getCard_code(), val.getCust_name(), val.getCust_reg_addr(), val.getDeflt_type(), val.getDeflt_day(),
													val.getCust_zone(), val.getData_month(), val.getValid_date()};
			batch_data.add(values_data);
		}
		sql_data = "insert into tmp_ct_yjmd_public(serialno,card_code,cust_name,cust_reg_addr,deflt_type,deflt_day,cust_zone,data_month,valid_date)" + " values(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql_data, batch_data);
		batch_data.clear();
	}
	
	/**
	 * 查询个人名单信息
	 * 
	 * @param cgb_risk_case
	 * @return
	 * @date 2016年10月18日 上午10:21:36
	 */
	public List<Ct_yjmd_private> getCt_yjmd_privateList(Ct_yjmd_private t_yjmd_private) {
		// 定义转换码表
		String[] cdColumns = new String[] {"cert_type:G00007:cert_type_disp", "cust_zone:Darea:cust_zone_disp"};
		List<Ct_yjmd_private> list = busiDao.selectList(namespace + "selectCt_yjmd_privateByVo", t_yjmd_private);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询单位名单信息
	 * 
	 * @param cgb_risk_case
	 * @return
	 * @date 2016年10月18日 上午10:21:36
	 */
	public List<Ct_yjmd_public> getCt_yjmd_publicList(Ct_yjmd_public ct_yjmd_public) {
		String[] cdColumns = new String[] {"cust_zone:Darea:cust_zone_disp"};
		List<Ct_yjmd_public> list = busiDao.selectList(namespace + "selectCt_yjmd_publicByVo", ct_yjmd_public);
		//或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 根据主键查询名单[个人接口]
	 * 
	 * @param t_yjmd_private
	 * @return
	 * @author yinxiong
	 * @date 2016年10月19日 上午9:40:14
	 */
	public Ct_yjmd_response getCt_yjmd_responseByPerson(Ct_yjmd_request request) {
		Ct_yjmd_response response = busiDao.selectOne(namespace + "selectCt_yjmd_responseByPerson", request);
		if (response == null) {
			response = new Ct_yjmd_response();
		}
		return response;
	}
	
	/**
	 * 根据主键查询名单[企业接口]
	 * 
	 * @param t_yjmd_private
	 * @return
	 * @author yinxiong
	 * @date 2016年10月19日 上午9:40:14
	 */
	public Ct_yjmd_response getCt_yjmd_responseByUnit(Ct_yjmd_request request) {
		Ct_yjmd_response response = busiDao.selectOne(namespace + "selectCt_yjmd_responseByUnit", request);
		if (response == null) {
			response = new Ct_yjmd_response();
		}
		return response;
	}
	
	/**
	 * 插入银监黑名单接口（AFP002）访问日志
	 * 
	 * @param log
	 * @author yinxiong
	 * @date 2016年10月24日 下午5:59:15
	 */
	public void insertCt_request_log(Ct_request_log log) {
		busiDao.insert(namespace + "insertCt_request_log", log);
	}
	
	/**
	 * 获取有效期
	 * 
	 * @param data_month 数据时点
	 * @return
	 * @author yinxiong
	 * @date 2016年10月25日 上午9:48:13
	 */
	private String getValid_date(String data_month) {
		String valid_date = "";
		try {
			//data_month是yyyyMM格式，valid_date是yyyyMMdd格式，valid_date = data_month拼接"01"后增加24个月
			//得到的日期为计算后的年月的最后一天（eg:20161025-->20181031）
			if (!StringUtils.isBlank(data_month)) {
				data_month = data_month + "01";
			} else {
				data_month = DtUtils.getNowDate("yyyyMMdd");
			}
			valid_date = DtUtils.add(data_month, 8, 24);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
		
		return valid_date;
	}
}
