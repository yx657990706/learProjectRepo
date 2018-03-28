/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.service;

/**
 * <p>Br41_kzqq_djService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.aml.system.domain.Mc00_tast;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_dj;
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back;
import citic.gajy.wlkz.domain.Br41_kzqq_hzws;

@Service
public class Br41_kzqq_djService extends  AmlBaseService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1314161761676705040L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlkz.mapper.Br41_kzqq_djMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br41_kzqq_dj
	 *            * @return
	 */
	public List<Br41_kzqq_dj> getBr41_kzqq_djList(Br41_kzqq_dj br41_kzqq_dj) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"djfs:B00071:djfs_disp","zzlxdm:Djgzjlx:zzlxdm_disp","bz:Dcrtpd:bz_disp","ztlb:B00080:ztlb_disp","msgcheckresult:B00200:msgcheckresult_disp" }; 		
		List<Br41_kzqq_dj> list = busiDao.selectList(namespace + "selectBr41_kzqq_djByVo", br41_kzqq_dj);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq_dj.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq_dj_back> getBr41_kzqq_djfkList(Br41_kzqq_dj_back  br41_kzqq_dj_back) throws SQLException {
		String[] cdColumns = new String[] {"djfs:B00071:djfs_disp","status:B00084:status_disp","zxjg:B00099:zxjg_disp","zzlxdm:Djgzjlx:zzlxdm_disp","ztlb:B00080:ztlb_disp","msgcheckresult:B00200:msgcheckresult_disp" }; 		
		List<Br41_kzqq_dj_back> kzqq_dj_backList = busiDao.selectList(namespace + "selectBr41_kzqq_djfkByVo", br41_kzqq_dj_back);
		kzqq_dj_backList = codeService.transListOfBean(kzqq_dj_backList, cdColumns,br41_kzqq_dj_back.getTasktype());
		return kzqq_dj_backList;
	}

	
	public List<Br41_kzqq> getBr41_kzqq_kzdjList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00089:status_disp","qqcslx:B00073:qqcslx_disp"
				,"ajlx:D00010:ajlx_disp", "zxjg:B00099:zxjg_disp","zzlxdm:Djgzjlx:zzlxdm_disp","ztlb:B00080:ztlb_disp","djfs:B00053:djfs_disp","sqjgdm:Dgacode:sqjgdm_disp"};
		if (!"".equals(br41_kzqq.getFssj_start())) {// 发送开始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start()+" 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送结束时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_kzdj", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq> getBr41_kzqq_kzdj_checkList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00089:status_disp","qqcslx:B00073:qqcslx_disp"
				,"ajlx:D00010:ajlx_disp", "zxjg:B00099:zxjg_disp","zzlxdm:Djgzjlx:zzlxdm_disp","ztlb:B00080:ztlb_disp","djfs:B00053:djfs_disp","sqjgdm:Dgacode:sqjgdm_disp"};
		if (!"".equals(br41_kzqq.getFssj_start())) {// 发送开始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start()+" 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送结束时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_kzdj_checkList", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq> getBr41_kzqq_kzdjSearchList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00084:status_disp","qqcslx:B00073:qqcslx_disp"
				,"ajlx:D00010:ajlx_disp", "zxjg:B00099:zxjg_disp","zzlxdm:Djgzjlx:zzlxdm_disp","organkey:Dorgan:organkey_disp","ztlb:B00080:ztlb_disp","djfs:B00053:djfs_disp","sqjgdm:Dgacode:sqjgdm_disp"};
		// 处理日期 数据库中19位，页面传的是10位
		if (!"".equals(br41_kzqq.getFssj_start())) {// 发送开始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送截止时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_kzdj_s", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq> getBr41_kzqq_dj_List(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp",
				"xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00089:status_disp","qqcslx:B00073:qqcslx_disp"
				,"tasktype:B00047:tasktype_disp","ajlx:D00010:ajlx_disp"};
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_kzdj", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	/**
	 * 查询冻结反馈信息
	 * 
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br41_kzqq_dj_back getBr41_kzqq_djfkDisp(Br41_kzqq_dj_back  br41_kzqq_dj_back) throws SQLException {
		String[] cdColumns = new String[] {"status:B00079:status_disp","zxjg:B00099:zxjg_disp","ajlx:D00010:ajlx_disp","djfs:B00053:djfs_disp"};
		Br41_kzqq_dj_back kzqq_dj_back = busiDao.selectOne(namespace + "selectBr41_kzqq_djfkByVo", br41_kzqq_dj_back, cdColumns);
		if (kzqq_dj_back == null)
			kzqq_dj_back = new Br41_kzqq_dj_back();
		return kzqq_dj_back;
	}
	

	
	
	public Br41_kzqq_dj_back getModifyBr41_kzqq_djfkDisp(Br41_kzqq_dj_back  br41_kzqq_dj_back) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };

		Br41_kzqq_dj_back kzqq_dj_back = busiDao.selectOne(namespace + "modifyBr41_kzqq_dj_back", br41_kzqq_dj_back, cdColumns);
		if (kzqq_dj_back == null)
			kzqq_dj_back = new Br41_kzqq_dj_back();
		return kzqq_dj_back;
	}
	/**
	 * 插入单条记录
	 * 
	 * @param br41_kzqq_dj
	 *            * @return
	 */
	public int insertBr41_kzqq_dj(Br41_kzqq_dj br41_kzqq_dj) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr41_kzqq_dj", br41_kzqq_dj);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq_dj
	 *            * @return
	 */
	public int modifyBr41_kzqq_dj(Br41_kzqq_dj br41_kzqq_dj) throws SQLException {
		int i = busiDao.update(namespace + "updateBr41_kzqq_dj", br41_kzqq_dj);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public int deleteBr41_kzqq_dj(String rwlsh) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqq_djByID", rwlsh);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br41_kzqq_dj getBr41_kzqq_djDisp(String rwlsh) throws SQLException {
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00089:status_disp","qqcslx:B00073:qqcslx_disp"
				,"tasktype:B00047:tasktype_disp","ajlx:D00010:ajlx_disp"};
		Br41_kzqq_dj br41_kzqq_dj = busiDao.selectOne(namespace + "selectBr41_kzqq_djfkByVo", rwlsh, cdColumns);
		if (br41_kzqq_dj == null)
			br41_kzqq_dj = new Br41_kzqq_dj();
		//这里涉及到证件类型的转码，各个监管证件类型不一致，加了映射处理
		return codeService.transBean(br41_kzqq_dj, cdColumns, br41_kzqq_dj.getTasktype());
	}
	
	public int send_hx(Br41_kzqq br41_kzqq) throws Exception {
		Mc00_tast mc00_tast = new Mc00_tast();
		br41_kzqq.setStatus("1");
		int i = busiDao.update(namespace + "updateBr41_kzqqStatus", br41_kzqq);
		String cbrc_rd_hx = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_rd_hx")); // 是否发核心
		if(!cbrc_rd_hx.equals("0")){
		Br41_kzqq_dj br41_kzqq_dj = new Br41_kzqq_dj();
		br41_kzqq_dj.setTasktype(br41_kzqq.getTasktype());
		br41_kzqq_dj.setQqdbs(br41_kzqq.getQqdbs());
		br41_kzqq_dj.setMsgcheckresult("1");
			List<Br41_kzqq_dj> list =  busiDao.selectList(namespace +"selectBr41_kzqq_djByVo",br41_kzqq_dj); 
			for(int n=0;n<list.size();n++){
				Br41_kzqq_dj dj = (Br41_kzqq_dj)list.get(n);
				if(br41_kzqq.getTasktype().equals("6")){
					mc00_tast.setBdhm(dj.getQqdbs() + "_" + dj.getRwlsh());
				}else{
					mc00_tast.setBdhm(dj.getQqdbs() + "$" + dj.getRwlsh());
				}
				mc00_tast.setTasktype(br41_kzqq.getTasktype());
			mc00_tast.setSubtaskid(br41_kzqq.getQqcslx());
			commonService.insertMc21_task_fact2(mc00_tast,"CBRC_"+br41_kzqq.getTasktype());
			}
		}
		return i;
		}

public int send_jg(Br41_kzqq br41_kzqq) throws Exception {
	String tasktype=br41_kzqq.getTasktype();
	Mc00_tast mc00_tast = new Mc00_tast();
	Br41_kzqq_dj_back br41_kzqq_dj_back = new Br41_kzqq_dj_back();
	br41_kzqq_dj_back.setTasktype(tasktype);
	br41_kzqq_dj_back.setQqdbs(br41_kzqq.getQqdbs());
	br41_kzqq_dj_back.setRwlsh(br41_kzqq.getRwlsh());
	br41_kzqq_dj_back.setStatus("2");
	br41_kzqq_dj_back.setFeedback_p(br41_kzqq.getRecipient_p());
	br41_kzqq_dj_back.setFeedback_time(DtUtils.getNowTime());
	br41_kzqq_dj_back.setLast_up_dt(DtUtils.getNowTime());
	String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核   
	if(cbrc_check_flag.equals("1")){
		br41_kzqq_dj_back.setStatus("5");
	}
    int i = busiDao.update(namespace + "updatebr41_kzqq_dj_backStatus", br41_kzqq_dj_back);
    

    String  sendflag="0";
    if(tasktype.equals("6")){ //四川省公安
    	int isok = busiDao.selectOne("getbr41_kzqq_dj_backCount", br41_kzqq_dj_back);
    	if (isok == 0) {
    		  mc00_tast.setBdhm(br41_kzqq.getQqdbs());		
    		  sendflag="1"; 
    	}
    }else{//cbrc
    	  sendflag="1";
    	  mc00_tast.setBdhm(br41_kzqq.getQqdbs()+"$"+br41_kzqq.getRwlsh());		
    }
	if(sendflag.equals("1")){
    mc00_tast.setSubtaskid(br41_kzqq.getQqcslx());
	  mc00_tast.setTasktype(br41_kzqq.getTasktype());
	  if(!cbrc_check_flag.equals("1")){
	  commonService.insertMc21_task_fact3(mc00_tast,"CBRC_"+br41_kzqq.getTasktype());
	  }
//	  Br41_kzqq br41_kzqq_d =new Br41_kzqq();
//	  br41_kzqq_d.setStatus("2");
//	  br41_kzqq_d.setTasktype(br41_kzqq.getTasktype());
//	  br41_kzqq_d.setQqdbs(br41_kzqq.getQqdbs());
//	  busiDao.update(namespace + "updateBr41_kzqqStatus", br41_kzqq_d);
	}
	  
	return i;
	}


public  void send_djcheck_jg(Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {


	br41_kzqq_dj_back.setStatus("2");
	br41_kzqq_dj_back.setFeedback_time(DtUtils.getNowTime());
	br41_kzqq_dj_back.setLast_up_dt(DtUtils.getNowTime());
	
    int i = busiDao.update(namespace + "updatebr41_kzqq_dj_backStatus", br41_kzqq_dj_back);
	Mc00_tast mc00_tast = new Mc00_tast();
    mc00_tast.setSubtaskid(br41_kzqq_dj_back.getQqcslx());
	  mc00_tast.setTasktype(br41_kzqq_dj_back.getTasktype());
	  mc00_tast.setBdhm(br41_kzqq_dj_back.getQqdbs()+"$"+br41_kzqq_dj_back.getRwlsh());		
	  commonService.insertMc21_task_fact3(mc00_tast,"CBRC_"+br41_kzqq_dj_back.getTasktype());

	}

public  void return_djcheck_jg(Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {

	br41_kzqq_dj_back.setStatus("1");
	br41_kzqq_dj_back.setFeedback_time(DtUtils.getNowTime());
	br41_kzqq_dj_back.setLast_up_dt(DtUtils.getNowTime());
	
    int i = busiDao.update(namespace + "updatebr41_kzqq_dj_backStatus", br41_kzqq_dj_back);

	}

/**
 * 回执文书信息
 * 
 * @param br40_cxqq_back_party
 *            * @return
 */
public List<Br41_kzqq_hzws> getBr41_kzqq_hzwsList(Br41_kzqq_dj br41_kzqq_dj) throws SQLException {

	List<Br41_kzqq_hzws> list = busiDao.selectList(namespace + "selectBr41_kzqq_hzwsList", br41_kzqq_dj);

	return list;
}

}
