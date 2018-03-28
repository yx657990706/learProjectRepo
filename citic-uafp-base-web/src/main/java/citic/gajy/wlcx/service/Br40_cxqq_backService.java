/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-23] 
 * =============================================
 */

package citic.gajy.wlcx.service;

/**
 * <p>Br40_cxqq_backService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import citic.aml.base.AmlBaseService;
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_ql;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_qzcs;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_sub;
import citic.gajy.wlcx.domain.Br40_cxqq_back_party;
import citic.gajy.wlcx.domain.Br40_cxqq_back_trans;
import citic.gajy.wlcx.domain.Br40_cxqq_excle;

@Service
public class Br40_cxqq_backService extends AmlBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6990025713535767247L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlcx.mapper.busi.Br40_cxqq_backMapper.";


	/**
	 * 上传的excle存放的路径
	 */
	private String EXCLE_PATH = File.separator + "attach" + File.separator + "excle";
	/**
	 * 以下定义需要和excle模板中的sheet名字保持一直
	 */
	private final String PARTY_SHEET = "客户基本数据项";// 客户sheet名
	private final String ACCT_SHEET = "账户基本数据项";// 账户sheet名
	private final String ACCT_QZCS_SHEET = "强制措施信息";// 强制措施sheet名
	private final String ACCT_QL_SHEET = "共有权或优先权信息";// 共有权／优先权sheet名
	private final String ACCT_SUB_SHEET = "关联子账户信息";// 关联子账户sheet名
	private final String TRANS_SHEET = "交易明细";// 交易明细sheet名
	private final String DT_TRANS_SHEET = "动态查询交易明细";// 动态查询交易明细sheet名
	
	private final String R_NEED = "R01";// 非空校验
	private final String R_LEN = "R02";// 长度校验
	private final String R_DATE_10 = "R03";// 日期校验10
	private final String R_DATE_19 = "R04";// 日期校验19
	private final String R_MONEY = "R05";// 金额校验
	private final String R_INT = "R06";// 整数校验
	
	private final String CGCX = "01";//常规查询

	private StringBuffer errMsg;
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br40_cxqq_back
	 *            * @return
	 */
	public List<Br40_cxqq_back> getBr40_cxqq_backList(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp", "ztlb:B00080:ztlb_disp", "status:B00084:status_disp",
				"cxfkjg:B00077:cxfkjg_disp", "mxsdlx:B00075:mxsdlx_disp" };
		List<Br40_cxqq_back> list = busiDao.selectList(namespace + "selectBr40_cxqq_backByVo", br40_cxqq_back);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq_back.getTasktype());
		return list;
	}

	/**
	 * 插入单条记录
	 * 
	 * @param br40_cxqq_back
	 *            * @return
	 */
	public int insertBr40_cxqq_back(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr40_cxqq_back", br40_cxqq_back);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br40_cxqq_back
	 *            * @return
	 */
	public int modifyBr40_cxqq_back(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		int i = busiDao.update(namespace + "updateBr40_cxqq_back", br40_cxqq_back);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br40_cxqq_back
	 *            * @return
	 */
	public int modifyBr40_cxqq_backStatus(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		int i = busiDao.update(namespace + "updateBr40_cxqq_backStatus", br40_cxqq_back);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public int deleteBr40_cxqq_back(String qqdbs) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr40_cxqq_backByID", qqdbs);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public Br40_cxqq_back getBr40_cxqq_backDisp(String qqdbs) throws SQLException {
		String[] cdColumns = new String[] { "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp", "ztlb:B00080:ztlb_disp", "status:B00084:status_disp",
				"cxfkjg:B00077:cxfkjg_disp", "mxsdlx:B00075:mxsdlx_disp" };
		Br40_cxqq_back br40_cxqq_back = busiDao.selectOne(namespace + "selectBr40_cxqq_backByID", qqdbs);
		if (br40_cxqq_back == null)
			br40_cxqq_back = new Br40_cxqq_back();
		return codeService.transBean(br40_cxqq_back, cdColumns, br40_cxqq_back.getTasktype());
	}

	/**
	 * 反馈信息的excle导入
	 * 
	 * @param br40_cxqq_excle
	 * @return
	 */
	public String readExcle(Br40_cxqq_excle br40_cxqq_excle) {
		String msg = "";
		try {
			String qqcslx = br40_cxqq_excle.getQqcslx();
			MultipartFile attachfile = br40_cxqq_excle.getFile();
			Br40_cxqq_back br40_cxqq_back = new Br40_cxqq_back();
			br40_cxqq_back.setQqdbs(br40_cxqq_excle.getQqdbs());
			br40_cxqq_back.setRwlsh(br40_cxqq_excle.getRwlsh());
			br40_cxqq_back.setTasktype(br40_cxqq_excle.getTasktype());
			br40_cxqq_back.setFilename(attachfile.getOriginalFilename());// 附件名称
			br40_cxqq_back.setFilepath(EXCLE_PATH + File.separator + DtUtils.getNowDate("yyyyMMdd") + File.separator + attachfile.getOriginalFilename());
			br40_cxqq_back.setDealing_time(DtUtils.getNowTime());// 上传时间
			br40_cxqq_back.setDealing_p(br40_cxqq_excle.getCreate_user());
			// 附件上传
			String newfilepath = commonService.uploadFile(attachfile, EXCLE_PATH + File.separator + DtUtils.getNowDate("yyyyMMdd"));
			//动态查询时获取序号
			if(!CGCX.equals(qqcslx)){
				String maxseq = busiDao.selectOne(namespace + "selectMaxseqByKeys", br40_cxqq_back);// 取当前最大序号+1
				br40_cxqq_back.setMaxseq(maxseq);
				br40_cxqq_excle.setRwlsh(br40_cxqq_excle.getRwlsh()+"_"+maxseq);//动态查询的交易的任务流水号特殊处理
			}
			// 附件解析
			msg = this.analyExcel(newfilepath, br40_cxqq_excle);
			// 解析正常，则更新附件信息
			if ("".equals(msg)) {
				br40_cxqq_back.setCxfkjg("01");// 01:成功 02:失败
				br40_cxqq_back.setCzsbyy("成功");
				if (CGCX.equals(qqcslx)) {// 常规查询
					busiDao.update(namespace + "updateBr40_cxqq_backByKeys", br40_cxqq_back);
				} else {// 动态查询
					br40_cxqq_back.setZxqssj(br40_cxqq_excle.getZxqssj());//Excle解析完成才能获取
					br40_cxqq_back.setJssj(br40_cxqq_excle.getJssj());
					busiDao.insert(namespace + "insertBr40_cxqq_backByKeys", br40_cxqq_back);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}

		return msg;
	}

	/**
	 * EXCLE解析 <br>
	 * 将excle转换为map<String,list<object>> <br>
	 * 将解析后的数据（map）插入数据库
	 * 
	 * @param filepath
	 * @return
	 */
	@BusiTx
	private String analyExcel(String filepath, Br40_cxqq_excle br40_cxqq_excle) throws Exception {

		errMsg = new StringBuffer();
		try {
			// 将excle转化为java对象,此过程产生的异常将写入errMsg中
			Map<String, Object> dataMap = this.ExcelReader(filepath, br40_cxqq_excle);
			// 无异常消息，数据转换正常，且存在有效数据，则入库
			if ("".equals(errMsg.toString()) && dataMap != null) {
				int size = dataMap.size();// sheet的个数
				// 按照excle模板，账户信息5个sheet，交易信息1个sheet，账户和交易6个sheet
				if (size == 1) {
					busiDao.delete(namespace + "deleteBr40_cxqq_back_transByKeys", br40_cxqq_excle);
                    if(dataMap.get("trans_sheet")!=null){
                    	busiDao.insert(namespace + "batchInsertBr40_cxqq_back_trans", dataMap.get("trans_sheet"));
                    }
				} else if (size == 5) {
					busiDao.delete(namespace + "deleteBr40_cxqq_back_partyByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acctByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_subByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_qzcsByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_qlByKeys", br40_cxqq_excle);
                    if(dataMap.get("party_sheet")!=null){
                    	busiDao.insert(namespace + "batchInsertBr40_cxqq_back_party", dataMap.get("party_sheet"));
                    } 
                    if(dataMap.get("acct_sheet")!=null){
                    	busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct", dataMap.get("acct_sheet"));
                    }
					if(dataMap.get("acct_sub_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_sub", dataMap.get("acct_sub_sheet"));
					}
					if(dataMap.get("acct_qzcs_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_qzcs", dataMap.get("acct_qzcs_sheet"));
					}
					if(dataMap.get("acct_ql_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_ql", dataMap.get("acct_ql_sheet"));
					}
				} else {
					// 先删除，后插入
					busiDao.delete(namespace + "deleteBr40_cxqq_back_partyByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acctByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_subByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_qzcsByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_acct_qlByKeys", br40_cxqq_excle);
					busiDao.delete(namespace + "deleteBr40_cxqq_back_transByKeys", br40_cxqq_excle);

					if(dataMap.get("party_sheet")!=null){
                    	busiDao.insert(namespace + "batchInsertBr40_cxqq_back_party", dataMap.get("party_sheet"));// 客户基本信息
                    } 
                    if(dataMap.get("acct_sheet")!=null){
                    	busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct", dataMap.get("acct_sheet"));// 账户基本信息
                    }
					if(dataMap.get("acct_sub_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_sub", dataMap.get("acct_sub_sheet"));// 关联账户信息
					}
					if(dataMap.get("acct_qzcs_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_qzcs", dataMap.get("acct_qzcs_sheet"));// 强制措施信息
					}
					if(dataMap.get("acct_ql_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_acct_ql", dataMap.get("acct_ql_sheet"));// 共有权／优先权信息
					}
					if(dataMap.get("trans_sheet")!=null){
						busiDao.insert(namespace + "batchInsertBr40_cxqq_back_trans", dataMap.get("trans_sheet"));// 交易明细
					}
				}
			}
		} catch (Exception e) {
			errMsg.append("SQL插入异常：" + e.getMessage());
			logger.error(e.getMessage(),e);
		}

		return errMsg.toString();
	}

	/**
	 * EXCLE数据提取 <br>
	 * 将excle的每个页签转换为相应的list，整个excle读取完成后封装为map
	 * 
	 * @param filepath
	 *            文件的相对路径即名称
	 * @return
	 * @throws FileNotFoundException
	 */
	private Map<String, Object> ExcelReader(String filepath, Br40_cxqq_excle br40_cxqq_excle) {
		Map<String, Object> map = null;
		try {
			String root = codeService.getCodeValue("Dpara", "1");// 文件存放根目录
			filepath = root + filepath;// 文件的绝对路径
			String tasktype = br40_cxqq_excle.getTasktype();// 监管类别
			String qqdbs = br40_cxqq_excle.getQqdbs();// 请求标识单号
			String rwlsh = br40_cxqq_excle.getRwlsh();// 任务流水号

			InputStream in = new FileInputStream(filepath);// 将文件转换为输入流
			// ========================================================
			// 考虑到银行软件版本问题，此处用2003版（低版本的xls格式）的excle解析，
			// 若需要解析2007版（高版本的xlsx格式）的excle，需要改造此处
			// =========================================================
			HSSFWorkbook workbook = new HSSFWorkbook(in);// 整个excle
			int num = workbook.getNumberOfSheets(); // sheet的个数

			if (num == 1 || num == 5 || num == 6) {// 按照excle模板，账户信息5个sheet，交易信息1个sheet，账户和交易6个sheet
				map = new HashMap<String, Object>();
				// 循环处理每个sheet
				for (int i = 0; i < num; i++) {
					HSSFSheet sheet = workbook.getSheetAt(i);
					String sheetName = sheet.getSheetName().trim();// sheet名称
					if (PARTY_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_party> list = dealSheetByParty(sheet, tasktype, qqdbs, rwlsh);
						map.put("party_sheet", list);
					} else if (ACCT_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_acct> list = dealSheetByAcct(sheet, tasktype, qqdbs, rwlsh);
						map.put("acct_sheet", list);
					} else if (ACCT_QZCS_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_acct_qzcs> list = dealSheetByQzcs(sheet, tasktype, qqdbs, rwlsh);
						map.put("acct_qzcs_sheet", list);
					} else if (ACCT_QL_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_acct_ql> list = dealSheetByQl(sheet, tasktype, qqdbs, rwlsh);
						map.put("acct_ql_sheet", list);
					} else if (ACCT_SUB_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_acct_sub> list = dealSheetBySub(sheet, tasktype, qqdbs, rwlsh);
						map.put("acct_sub_sheet", list);
					} else if (TRANS_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_trans> list = dealSheetByTrans(sheet, tasktype, qqdbs, rwlsh);
						map.put("trans_sheet", list);
					} else if (DT_TRANS_SHEET.equals(sheetName)) {
						List<Br40_cxqq_back_trans> list = dealSheetByTransDt(sheet, tasktype, qqdbs, rwlsh);
						map.put("trans_sheet", list);
						// 获取执行开始时间和结束时间
						this.toSetTime(list, br40_cxqq_excle);
					}
				}
			} else {
				logger.info("模板异常");
			}

		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}

		return map;
	}

	/**
	 * 客户基本数据项sheet处理
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_party> dealSheetByParty(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_party> list = null;

		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_party>(lastRowNum);
			Map<String, String> cardTypeMap = codeService.getCodeMap("Dry006");// 证件类型
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段

			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_party party = new Br40_cxqq_back_party();
					party.setTasktype(tasktype);// 监管类别
					party.setQqdbs(qqdbs);// 请求单标识
					party.setRwlsh(rwlsh);// 任务流水号
					party.setCxfkjg("01");// 查询反馈结果 01成功 02失败
					party.setCxfkjgyy("成功");// 查询反馈结果原因
					party.setZzlx(this.getStrValue(row.getCell(0), sheetname, i + 1, "zzlx", 1, columnMap, changeValue(row.getCell(0), cardTypeMap)));// 证照类型代码
					party.setZzhm(this.getStrValue(row.getCell(1), sheetname, i + 1, "zzhm", 2, columnMap, null));// 证照号码
					party.setKhmc(this.getStrValue(row.getCell(2), sheetname, i + 1, "khmc", 3, columnMap, null));// 客户名称
					party.setLxdh(this.getStrValue(row.getCell(3), sheetname, i + 1, "lxdh", 4, columnMap, null));// 联系电话
					party.setLxsj(this.getStrValue(row.getCell(4), sheetname, i + 1, "lxsj", 5, columnMap, null));// 联系手机
					party.setDbrxm(this.getStrValue(row.getCell(5), sheetname, i + 1, "dbrxm", 6, columnMap, null));// 代办人姓名
					party.setDbrzjlx(this.getStrValue(row.getCell(6), sheetname, i + 1, "dbrzjlx", 7, columnMap, changeValue(row.getCell(6), cardTypeMap)));// 代办人证件类型
					party.setDbrzjhm(this.getStrValue(row.getCell(7), sheetname, i + 1, "dbrzjhm", 8, columnMap, null));// 代办人证件号码
					party.setZzdz(this.getStrValue(row.getCell(8), sheetname, i + 1, "zzdz", 9, columnMap, null));// 住宅地址
					party.setZzdh(this.getStrValue(row.getCell(9), sheetname, i + 1, "zzdh", 10, columnMap, null));// 住宅电话
					party.setGzdw(this.getStrValue(row.getCell(10), sheetname, i + 1, "gzdw", 11, columnMap, null));// 工作单位
					party.setDwdz(this.getStrValue(row.getCell(11), sheetname, i + 1, "dwdz", 12, columnMap, null));// 单位地址
					party.setDwdh(this.getStrValue(row.getCell(12), sheetname, i + 1, "dwdh", 13, columnMap, null));// 单位电话
					party.setYxdz(this.getStrValue(row.getCell(13), sheetname, i + 1, "yxdz", 14, columnMap, null));// 邮箱地址
					party.setFrdb(this.getStrValue(row.getCell(14), sheetname, i + 1, "frdb", 15, columnMap, null));// 法人代表
					party.setFrdbzjlx(this.getStrValue(row.getCell(15), sheetname, i + 1, "frdbzjlx", 16, columnMap, changeValue(row.getCell(15), cardTypeMap)));// 法人代表证件类型
					party.setFrdbzjhm(this.getStrValue(row.getCell(16), sheetname, i + 1, "frdbzjhm", 17, columnMap, null));// 法人代表证件号码
					party.setKhgszzhm(this.getStrValue(row.getCell(17), sheetname, i + 1, "khgszzhm", 18, columnMap, null));// 客户工商执照号码
					party.setGsnsh(this.getStrValue(row.getCell(18), sheetname, i + 1, "gsnsh", 19, columnMap, null));// 国税纳税号
					party.setDsnsh(this.getStrValue(row.getCell(19), sheetname, i + 1, "dsnsh", 20, columnMap, null));// 地税纳税号
					party.setQrydt(DtUtils.getNowDate());

					list.add(party);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.info(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 账户基本数据项sheet处理
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_acct> dealSheetByAcct(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_acct> list = null;
	
		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_acct>(lastRowNum);
			Map<String, String> currMap = codeService.getCodeMap("Dry007");// 币种
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段
			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_acct acct = new Br40_cxqq_back_acct();
					acct.setTasktype(tasktype);// 监管类别
					acct.setQqdbs(qqdbs);// 请求单标识
					acct.setRwlsh(rwlsh);// 任务流水号
					acct.setKh(this.getStrValue(row.getCell(0), sheetname, i + 1, "kh", 1, columnMap, null));// 卡号
					acct.setZh(this.getStrValue(row.getCell(1), sheetname, i + 1, "zh", 2, columnMap, null));// 账号
					acct.setZhlb(this.getStrValue(row.getCell(2), sheetname, i + 1, "zhlb", 3, columnMap, null));// 账户类别
					acct.setZhzt(this.getStrValue(row.getCell(3), sheetname, i + 1, "zhzt", 4, columnMap, null));// 账户状态
					acct.setZhjysj(this.getStrValue(row.getCell(4), sheetname, i + 1, "zhjysj", 5, columnMap, null));// 最后交易时间
					acct.setKhwd(this.getStrValue(row.getCell(5), sheetname, i + 1, "khwd", 6, columnMap, null));// 开户网点
					acct.setKhwddm(this.getStrValue(row.getCell(6), sheetname, i + 1, "khwddm", 7, columnMap, null));// 开户网点代码
					acct.setKhrq(this.getStrValue(row.getCell(7), sheetname, i + 1, "khrq", 8, columnMap, null));// 开户日期
					acct.setXhrq(this.getStrValue(row.getCell(8), sheetname, i + 1, "xhrq", 9, columnMap, null));// 销户日期
					acct.setXhwd(this.getStrValue(row.getCell(9), sheetname, i + 1, "xhwd", 10, columnMap, null));// 销户网点
					acct.setBz(this.getStrValue(row.getCell(10), sheetname, i + 1, "bz", 11, columnMap,  changeValue(row.getCell(10), currMap)));// 币种
					acct.setChbz(this.getStrValue(row.getCell(11), sheetname, i + 1, "chbz", 12, columnMap, null));// 钞汇标志
					acct.setZhye(this.getStrValue(row.getCell(12), sheetname, i + 1, "zhye", 13, columnMap, null));// 账户余额
					acct.setKyye(this.getStrValue(row.getCell(13), sheetname, i + 1, "kyye", 14, columnMap, null));// 可用余额
					acct.setBeiz(this.getStrValue(row.getCell(14)));// 备注
					acct.setQrydt(DtUtils.getNowDate());

					list.add(acct);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.info(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 强制措施sheet处理
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_acct_qzcs> dealSheetByQzcs(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_acct_qzcs> list = null;
		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_acct_qzcs>(lastRowNum);
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段
			Map<String, String> djcslxMap = codeService.getCodeMap("Dry001");// 冻结措施类型-ry
			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_acct_qzcs qzcs = new Br40_cxqq_back_acct_qzcs();
					qzcs.setTasktype(tasktype);// 监管类别
					qzcs.setQqdbs(qqdbs);// 请求单标识
					qzcs.setRwlsh(rwlsh);// 任务流水号
					qzcs.setZh(this.getStrValue(row.getCell(0), sheetname, i + 1, "zh", 1, columnMap, null));// 账号
					qzcs.setCsxh(this.getStrValue(row.getCell(1), sheetname, i + 1, "csxh", 2, columnMap, null));// 措施序号
					qzcs.setDjksrq(this.getStrValue(row.getCell(2), sheetname, i + 1, "djksrq", 3, columnMap, null));// 冻结开始日
					qzcs.setDjjzrq(this.getStrValue(row.getCell(3), sheetname, i + 1, "djjzrq", 4, columnMap, null));// 冻结截止日
					qzcs.setDjjgmc(this.getStrValue(row.getCell(4), sheetname, i + 1, "djjgmc", 5, columnMap, null));// 冻结机关名称
					qzcs.setDjje(this.getStrValue(row.getCell(5), sheetname, i + 1, "djje", 6, columnMap, null));// 冻结金额
					qzcs.setBeiz(this.getStrValue(row.getCell(6)));// 备注
					qzcs.setDjcslx(this.getStrValue(row.getCell(7), sheetname, i + 1, "djcslx", 8, columnMap, changeValue(row.getCell(7), djcslxMap)));// 冻结措施类型（01-半封、02-全封、03-金额冻结）
					qzcs.setQrydt(DtUtils.getNowDate());

					list.add(qzcs);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.info(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 共有权或优先权信息sheet处理
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_acct_ql> dealSheetByQl(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_acct_ql> list = null;
		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_acct_ql>(lastRowNum);
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段
			Map<String, String> cardTypeMap = codeService.getCodeMap("Dry006");// 证件类型
			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_acct_ql ql = new Br40_cxqq_back_acct_ql();
					ql.setTasktype(tasktype);// 监管类别
					ql.setQqdbs(qqdbs);// 请求单标识
					ql.setRwlsh(rwlsh);// 任务流水号
					ql.setZh(this.getStrValue(row.getCell(0), sheetname, i + 1, "zh", 1, columnMap, null));// 账号
					ql.setXh(this.getStrValue(row.getCell(1), sheetname, i + 1, "xh", 2, columnMap, null));// 权利序号
					ql.setQllx(this.getStrValue(row.getCell(2), sheetname, i + 1, "qllx", 3, columnMap, null));// 权利类型
					ql.setZzlxdm(this.getStrValue(row.getCell(3), sheetname, i + 1, "zzlxdm", 4, columnMap, changeValue(row.getCell(3), cardTypeMap)));// 证件类型代码
					ql.setZzhm(this.getStrValue(row.getCell(4), sheetname, i + 1, "zzhm", 5, columnMap, null));// 证件号码
					ql.setQlrxm(this.getStrValue(row.getCell(5), sheetname, i + 1, "qlrxm", 6, columnMap, null));// 权利人姓名
					ql.setQlje(this.getStrValue(row.getCell(6), sheetname, i + 1, "qlje", 7, columnMap, null));// 权利金额
					ql.setQlrdz(this.getStrValue(row.getCell(7), sheetname, i + 1, "qlrdz", 8, columnMap, null));// 权利人通讯地址
					ql.setQlrlxfs(this.getStrValue(row.getCell(8), sheetname, i + 1, "qlrlxfs", 9, columnMap, null));// 权利人联系方式
					ql.setQrydt(DtUtils.getNowDate());

					list.add(ql);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.info(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 关联子账户信息sheet处理
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_acct_sub> dealSheetBySub(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_acct_sub> list = null;
		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_acct_sub>(lastRowNum);
			Map<String, String> currMap = codeService.getCodeMap("Dry007");// 币种
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段
			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_acct_sub sub = new Br40_cxqq_back_acct_sub();
					sub.setTasktype(tasktype);// 监管类别
					sub.setQqdbs(qqdbs);// 请求单标识
					sub.setRwlsh(rwlsh);// 任务流水号
					sub.setZh(this.getStrValue(row.getCell(0), sheetname, i + 1, "zh", 1, columnMap, null));// 账卡号
					sub.setZzhxh(this.getStrValue(row.getCell(1), sheetname, i + 1, "zzhxh", 2, columnMap, null));// 子账户序号
					sub.setZzhlb(this.getStrValue(row.getCell(2), sheetname, i + 1, "zzhlb", 3, columnMap, null));// 子账户类别
					sub.setZzhzh(this.getStrValue(row.getCell(3), sheetname, i + 1, "zzhzh", 4, columnMap, null));// 子账户账号
					sub.setBz(this.getStrValue(row.getCell(4), sheetname, i + 1, "bz", 5, columnMap, changeValue(row.getCell(4), currMap)));// 币种
					sub.setChbz(this.getStrValue(row.getCell(5), sheetname, i + 1, "chbz", 6, columnMap, null));// /钞汇标志
					sub.setZhye(this.getStrValue(row.getCell(6), sheetname, i + 1, "zhye", 7, columnMap, null));// 账户余额
					sub.setZhzt(this.getStrValue(row.getCell(7), sheetname, i + 1, "zhzt", 8, columnMap, null));// 账户状态
					sub.setKyye(this.getStrValue(row.getCell(8), sheetname, i + 1, "kyye", 9, columnMap, null));// 可用余额

					list.add(sub);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}
		} else {
			logger.info(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 交易明细sheet处理 <br>
	 * 对必输字段和金额以及日期进行校验 <br>
	 * 对下拉框的值进行转码
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_trans> dealSheetByTrans(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_trans> list = null;

		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_trans>(lastRowNum);
			Map<String, String> jysfcgMap = codeService.getCodeMap("Dry002");// 交易是否成功-ry
			Map<String, String> xjbzMap = codeService.getCodeMap("Dry003");// 现金标志-ry'
			Map<String, String> zkhlxMap = codeService.getCodeMap("Dry004");// 帐卡号类型-ry
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段-ry
			Map<String, String> bzMap = codeService.getCodeMap("Dry007");// 币种

			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_trans trans = new Br40_cxqq_back_trans();
					trans.setTasktype(tasktype);// 监管类别
					trans.setQqdbs(qqdbs);// 请求单标识
					trans.setRwlsh(rwlsh);// 任务流水号
					trans.setTransseq(i + "");// 交易序号
					trans.setCxfkjg("01");
					trans.setCxfkjgyy("成功");
					trans.setZh(this.getStrValue(row.getCell(0), sheetname, i + 1, "zh", 1, columnMap, null));// 查询账号
					trans.setCxkh(this.getStrValue(row.getCell(1), sheetname, i + 1, "cxkh", 2, columnMap, null));// 查询卡号
					trans.setJylx(this.getStrValue(row.getCell(2), sheetname, i + 1, "jylx", 3, columnMap, null));// 交易类型
					trans.setJdbz(this.getStrValue(row.getCell(3), sheetname, i + 1, "jdbz", 4, columnMap, null));// 借贷标志 用进(即借，入账)、出(贷，出账)表示
					trans.setBz(this.getStrValue(row.getCell(4), sheetname, i + 1, "bz", 5, columnMap, changeValue(row.getCell(4), bzMap)));// 币种
					trans.setJe(this.getStrValue(row.getCell(5), sheetname, i + 1, "je", 6, columnMap, null));// 交易金额
					trans.setYe(this.getStrValue(row.getCell(6), sheetname, i + 1, "ye", 7, columnMap, null));// 交易余额
					trans.setJysj(this.getStrValue(row.getCell(7), sheetname, i + 1, "jysj", 8, columnMap, null));// 交易时间14位
					trans.setJylsh(this.getStrValue(row.getCell(8), sheetname, i + 1, "jylsh", 9, columnMap, null));// 交易流水号
					trans.setJywdmc(this.getStrValue(row.getCell(9), sheetname, i + 1, "jywdmc", 10, columnMap, null));// 交易网点名称
					trans.setJywddm(this.getStrValue(row.getCell(10), sheetname, i + 1, "jywddm", 11, columnMap, null));// 交易网点代码
					trans.setXjbz(this.getStrValue(row.getCell(11), sheetname, i + 1, "xjbz", 12, columnMap, changeValue(row.getCell(11), xjbzMap)));// 现金标志 00表示其它，01表示现金交易
					trans.setJysfcg(this.getStrValue(row.getCell(12), sheetname, i + 1, "jysfcg", 13, columnMap, changeValue(row.getCell(12), jysfcgMap)));// 交易是否成功 01标识成功；02表示失败
					trans.setJydfxm(this.getStrValue(row.getCell(13), sheetname, i + 1, "jydfxm", 14, columnMap, null));// 交易对方名称
					// 表中设计为帐号和卡号2个字段，此处，对应后台，均赋值给对方账号
					trans.setJydfzh(this.getStrValue(row.getCell(14), sheetname, i + 1, "jydfzkh", 15, columnMap, null));// 交易对方账卡号
					trans.setJydfzkhlx(this.getStrValue(row.getCell(15), sheetname, i + 1, "jydfzkhlx", 16, columnMap, changeValue(row.getCell(15), zkhlxMap)));// 交易对方帐卡号类型
																																								// 0为账号、1为卡号、2为未知
					trans.setJydfzjhm(this.getStrValue(row.getCell(16), sheetname, i + 1, "jydfzjhm", 17, columnMap, null));// 交易对方证件号码
					trans.setJydsye(this.getStrValue(row.getCell(17), sheetname, i + 1, "jydsye", 18, columnMap, null));// 交易对手余额
					trans.setJydfzhkhh(this.getStrValue(row.getCell(18), sheetname, i + 1, "jydfzhkhh", 19, columnMap, null));// 交易对方账号开户行
					trans.setJyzy(this.getStrValue(row.getCell(19), sheetname, i + 1, "jyzy", 20, columnMap, null));// 交易摘要
					trans.setRzh(this.getStrValue(row.getCell(20), sheetname, i + 1, "rzh", 21, columnMap, null));// 日志号
					trans.setCph(this.getStrValue(row.getCell(21), sheetname, i + 1, "cph", 22, columnMap, null));// 传票号
					trans.setPzzl(this.getStrValue(row.getCell(22), sheetname, i + 1, "pzzl", 23, columnMap, null));// 凭证种类
					trans.setPzh(this.getStrValue(row.getCell(23), sheetname, i + 1, "pzh", 24, columnMap, null));// 凭证号
					trans.setZdh(this.getStrValue(row.getCell(24), sheetname, i + 1, "zdh", 25, columnMap, null));// 终端号
					trans.setJyfsd(this.getStrValue(row.getCell(25), sheetname, i + 1, "jyfsd", 26, columnMap, null));// 交易发生地
					trans.setShmc(this.getStrValue(row.getCell(26), sheetname, i + 1, "shmc", 27, columnMap, null));// 商户名称
					trans.setShh(this.getStrValue(row.getCell(27), sheetname, i + 1, "shh", 28, columnMap, null));// 商户号
					trans.setIp(this.getStrValue(row.getCell(28), sheetname, i + 1, "ip", 29, columnMap, null));// IP地址
					trans.setMac(this.getStrValue(row.getCell(29), sheetname, i + 1, "mac", 30, columnMap, null));// MAC地址
					trans.setJygyh(this.getStrValue(row.getCell(30), sheetname, i + 1, "jygyh", 31, columnMap, null));// 交易柜员号
					trans.setBeiz(this.getStrValue(row.getCell(31)));// 备注
					trans.setQrydt(DtUtils.getNowDate());
					list.add(trans);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.warn(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 动态查询交易明细sheet处理 <br>
	 * 对必输字段和金额以及日期进行校验 <br>
	 * 对下拉框的值进行转码
	 * 
	 * @param sheet
	 * @param tasktype
	 * @param qqdbs
	 * @param rwlsh
	 * @return
	 */
	private List<Br40_cxqq_back_trans> dealSheetByTransDt(HSSFSheet sheet, String tasktype, String qqdbs, String rwlsh) {
		List<Br40_cxqq_back_trans> list = null;

		String sheetname = sheet.getSheetName();
		int lastRowNum = sheet.getLastRowNum();// sheet最后一行的行数
		if (lastRowNum > 0) {// 存在数据，则继续解析
			list = new ArrayList<Br40_cxqq_back_trans>(lastRowNum);
			Map<String, String> xjbzMap = codeService.getCodeMap("Dry003");// 现金标志-ry'
			Map<String, String> zkhlxMap = codeService.getCodeMap("Dry004");// 帐卡号类型-ry
			Map<String, String> columnMap = codeService.getCodeMap("Dry005");// 校验字段-ry
			Map<String, String> bzMap = codeService.getCodeMap("Dry007");// 币种
			Map<String, String> cardTypeMap = codeService.getCodeMap("Dry006");// 证件类型

			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);// 获取该数据行
				if (row != null) {
					Br40_cxqq_back_trans dt_trans = new Br40_cxqq_back_trans();
					dt_trans.setTasktype(tasktype);// 监管类别
					dt_trans.setQqdbs(qqdbs);// 请求单标识
					dt_trans.setRwlsh(rwlsh);// 任务流水号
					dt_trans.setTransseq(i + "");// 交易序号
					dt_trans.setCxfkjg("01");
					dt_trans.setCxfkjgyy("成功");
					dt_trans.setZh(this.getStrValue(row.getCell(0), sheetname, i + 1, "zh", 1, columnMap, null));// 查询账号
					dt_trans.setCxkh(this.getStrValue(row.getCell(1), sheetname, i + 1, "cxkh", 2, columnMap, null));// 查询卡号
					dt_trans.setKhmc(this.getStrValue(row.getCell(2), sheetname, i + 1, "khmc", 3, columnMap, null));// 客户名称
					dt_trans.setZzlx(this.getStrValue(row.getCell(3), sheetname, i + 1, "khzjlx", 4, columnMap, changeValue(row.getCell(3), cardTypeMap)));// 客户证件类型
					dt_trans.setZzhm(this.getStrValue(row.getCell(4), sheetname, i + 1, "khzjhm", 5, columnMap, null));// 客户证件号码
					dt_trans.setJywdmc(this.getStrValue(row.getCell(5), sheetname, i + 1, "jywdmc", 6, columnMap, null));// 交易网点名称
					dt_trans.setJylx(this.getStrValue(row.getCell(6), sheetname, i + 1, "jylx", 7, columnMap, null));// 交易类型
					dt_trans.setJysj(this.getStrValue(row.getCell(7), sheetname, i + 1, "jysj", 8, columnMap, null));// 交易时间
					dt_trans.setXjbz(this.getStrValue(row.getCell(8), sheetname, i + 1, "xjbz", 9, columnMap, changeValue(row.getCell(8), xjbzMap)));// 现金标志 00表示其它，01表示现金交易
					dt_trans.setJe(this.getStrValue(row.getCell(9), sheetname, i + 1, "je", 10, columnMap, null));// 交易金额
					dt_trans.setBz(this.getStrValue(row.getCell(10), sheetname, i + 1, "bz", 11, columnMap, changeValue(row.getCell(10), bzMap)));// 币种
					// 表中设计为帐号和卡号2个字段，此处，对应后台，均赋值给对方账号
					dt_trans.setJydfzh(this.getStrValue(row.getCell(11), sheetname, i + 1, "jydfzkh", 12, columnMap, null));// 交易对方账卡号
					dt_trans.setJydfzkhlx(this.getStrValue(row.getCell(12), sheetname, i + 1, "jydfzkhlx", 13, columnMap, changeValue(row.getCell(12), zkhlxMap)));// 交易对方帐卡号类型0为账号、1为卡号、2为未知
					dt_trans.setJydfxm(this.getStrValue(row.getCell(13), sheetname, i + 1, "jydfxm", 14, columnMap, null));// 交易对方姓名
					dt_trans.setPzzl(this.getStrValue(row.getCell(14), sheetname, i + 1, "pzzl", 15, columnMap, null));// 凭证种类
					dt_trans.setPzh(this.getStrValue(row.getCell(15), sheetname, i + 1, "pzh", 16, columnMap, null));// 凭证号
					dt_trans.setZdh(this.getStrValue(row.getCell(16), sheetname, i + 1, "zdh", 17, columnMap, null));// 终端号
					dt_trans.setShh(this.getStrValue(row.getCell(17), sheetname, i + 1, "shh", 18, columnMap, null));// 商户号
					dt_trans.setShmc(this.getStrValue(row.getCell(18), sheetname, i + 1, "shmc", 19, columnMap, null));// 商户名称
					dt_trans.setJygyh(this.getStrValue(row.getCell(19), sheetname, i + 1, "jygyh", 20, columnMap, null));// 交易柜员号
					dt_trans.setQrydt(DtUtils.getNowDate());
					list.add(dt_trans);
				} else {
					errMsg.append("[").append(sheetname).append("]sheet的第").append(i + 1).append("行：插入了空行<br>");
				}
			}

		} else {
			logger.warn(sheet.getSheetName() + "sheet没有数据");
		}

		return list;
	}

	/**
	 * 校验器
	 * 
	 * @param cell
	 *            单元格
	 * @param sheetname
	 *            sheet名称
	 * @param rownum
	 *            数据行
	 * @param colName
	 *            excle中列在数据库中的字段名
	 * @param colnum
	 *            excle中的列号（从1开始算）
	 * @param ruleMap
	 *            规则map
	 * @param c_val
	 *            转码后的值
	 * @return
	 */
	private String getStrValue(HSSFCell cell, String sheetname, int rownum, String colName, int colnum, Map<String, String> ruleMap, String c_val) {
		String val = "";
		String name = "";// 列名（中文）
		String len = "";// 最大长度
		try {
			// 获取命中规则
			// ==========================================================================
			// ruleMap组成为<字段,字段中文名|长度|规则a,规则b...>
			// 即 rules的组成是 字段中文名|长度|规则a,规则b...，前两个字段必须有，规则根据需要配置
			// 规则定义参见br40_cxqq_rule表的说明
			// ==========================================================================
			String rules = ruleMap.get(colName);// 获取字段对应的规则
			String[] col = rules.split("\\|");
			name = col[0];
			len = col[1];
			if (col.length > 2) {
				String[] rul = col[2].split(",");
				for (int i = 0; i < rul.length; i++) {
					if (R_NEED.equals(rul[i])) {
						val = getStrValueByNeed(cell, c_val);
					} else if (R_LEN.equals(rul[i])) {
						val = getStrValueByLen(cell, len, c_val);
					} else if (R_DATE_10.equals(rul[i])) {
						val = getStrValueByDate_10(cell);
					} else if (R_DATE_19.equals(rul[i])) {
						val = getStrValueByDate_19(cell);
					} else if (R_MONEY.equals(rul[i])) {
						val = getStrValueByMoney(cell);
					} else if (R_INT.equals(rul[i])) {
						val = getStrValueByInt(cell);
					}
				}
			} else {
				val = cell == null ? "" : cell.getStringCellValue().trim();
			}
		} catch (Exception e) {
			errMsg.append("[").append(sheetname).append("]sheet的第").append(rownum).append("行,").append("第").append(colnum).append("列【").append(name).append("】：");
			errMsg.append(e.getMessage()).append("<br>");
		}
		return val;
	}

	/**
	 * 无值处理
	 * 
	 * @return
	 */
	private String getStrValue(HSSFCell cell) {
		return cell == null ? "" : cell.getStringCellValue().trim();
	}

	/**
	 * 必填处理
	 * 
	 * @param cell
	 * @param index
	 *            单元格所在列
	 * @return
	 * @throws Exception
	 */
	private String getStrValueByNeed(HSSFCell cell, String c_val) throws Exception {
		if (cell != null) {
			return c_val == null ? cell.getStringCellValue().trim() : c_val;
		} else {
			throw new Exception("值不能为空");
		}
	}

	/**
	 * 日期时间处理 <Br>
	 * 将时间转换为19位yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param cell
	 * @param index
	 * @return
	 * @throws Exception
	 */
	private String getStrValueByDate_19(HSSFCell cell) throws Exception {
		String value = "";
		if (cell != null) {
			String cellVal = cell.getStringCellValue().trim();
			int len = cellVal.length();
			if (len == 8 || len == 10 || len == 14 || len == 19) {
				value = DtUtils.FormatDate(DtUtils.toDate(cellVal), "yyyy-MM-dd HH:mm:ss");
			} else {
				throw new Exception("时间格式异常,建议为14位的yyyyMMddHHmmss格式。实际值：" + cellVal);
			}
		}
		return value;
	}

	/**
	 * 日期时间处理 <Br>
	 * 将时间转换为10位yyyy-MM-dd格式
	 * 
	 * @param cell
	 * @param index
	 * @return
	 * @throws Exception
	 */
	private String getStrValueByDate_10(HSSFCell cell) throws Exception {
		String value = "";
		if (cell != null) {
			String cellVal = cell.getStringCellValue().trim();
			int len = cellVal.length();
			if (len == 8 || len == 10 || len == 14 || len == 19) {
				value = DtUtils.FormatDate(DtUtils.toDate(cellVal), "yyyy-MM-dd");
			} else {
				throw new Exception("时间格式异常,建议为14位的yyyyMMdd格式。实际值：" + cellVal);
			}
		}
		return value;
	}

	/**
	 * 金额处理
	 * 
	 * @param cell
	 * @return
	 */
	private String getStrValueByMoney(HSSFCell cell) throws Exception {
		String value = "";
		if (cell != null) {
			String cellVal = cell.getStringCellValue().trim();
			if (NumberUtils.isNumber(cellVal)) {// 是有效数字
				value = this.getDoubleString_2(cellVal);
			} else {
				throw new Exception("第" + (cell.getColumnIndex() + 1) + "列的金额不是有效数字，实际值：" + cellVal);
			}
		}
		return value;
	}

	/**
	 * 整数校验
	 * 
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	private String getStrValueByInt(HSSFCell cell) throws Exception {
		String value = "";
		if (cell != null) {
			String cellVal = cell.getStringCellValue().trim();
			if (NumberUtils.isNumber(cellVal)) {// 是有效数字
				value = cellVal;
			} else {
				throw new Exception("不是有效整数，实际值：" + cellVal);
			}
		}
		return value;
	}

	/**
	 * 长度校验
	 * 
	 * @param cell
	 * @param length
	 *            最大长度
	 * @param length
	 *            转码后的值
	 * @return
	 * @throws Exception
	 */
	private String getStrValueByLen(HSSFCell cell, String length, String c_val) throws Exception {
		String value = "";
		int len = 0;
		if (cell != null) {
			String cellVal = c_val == null ? cell.getStringCellValue().trim() : c_val;
			len = StrUtils.length(cellVal);
			if (len <= Integer.parseInt(length)) {
				value = cellVal;
			} else {
				throw new Exception("字段超长，当前长度：" + len);
			}
		}
		return value;
	}

	/**
	 * 获取含两位小数的string
	 * 
	 * <br>
	 * %.2f %. 表示 小数点前任意位数 2 表示两位小数 格式后的结果为f 表示浮点型
	 * 
	 * @param str
	 * @return
	 */
	private String getDoubleString_2(String str) {
		if ("".equals(str)) {
			str = "0";
		}
		return String.format("%.2f", Double.parseDouble(str));
	}

	/**
	 * 码值转换
	 * 
	 * @param cell
	 *            单元格
	 * @param map
	 *            码值map
	 * @return
	 */
	private String changeValue(HSSFCell cell, Map<String, String> map) {
		return cell == null ? null : map.get(cell.getStringCellValue().trim());
	}

	/**
	 * 设置同一批次交易中的最大交易时间和最小交易时间
	 * 
	 * @param list
	 * @param br40_cxqq_excle
	 */
	private void toSetTime(List<Br40_cxqq_back_trans> list, Br40_cxqq_excle br40_cxqq_excle) {
		String[] times = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			times[i] = list.get(i).getJysj();
		}
		Arrays.sort(times);
		br40_cxqq_excle.setZxqssj(times[0]);
		br40_cxqq_excle.setJssj(times[times.length - 1]);
	}
}
