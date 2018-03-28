/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.service;

/**
 * <p>Br41_kzqq_zfService.java</p>
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
import citic.gajy.wlcx.domain.Br40_cxqq_mx;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_zf;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back;


@Service
public class Br41_kzqq_zfService extends  AmlBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1545021508556739164L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlkz.mapper.Br41_kzqq_zfMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br41_kzqq_zf
	 *            * @return
	 */
	public List<Br41_kzqq_zf> getBr41_kzqq_zfList(Br41_kzqq_zf br41_kzqq_zf) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"ztlb:B00080:ztlb_disp","msgcheckresult:B00200:msgcheckresult_disp","status:B00084:status_disp","zxjg:B00099:zxjg_disp"}; 
		List<Br41_kzqq_zf> list = busiDao.selectList(namespace + "selectBr41_kzqq_zfByVo", br41_kzqq_zf);
       //或在DAO查询中直接转换  
        list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	
	/*
	 * 新增控制和止付主体页面显示
	 */
	public List<Br41_kzqq_zf> getBr41_kzqq_kzzfList(Br41_kzqq_zf br41_kzqq_zf) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"tasktype:B00047:tasktype_disp"};
		List<Br41_kzqq_zf> list = busiDao.selectList(namespace + "selectBr41_kzqq_kzzfByVo", br41_kzqq_zf);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	public Br41_kzqq_zf  performgetBr41_kzqq_kzzfBackMain(Br41_kzqq_zf br41_kzqq_zf) throws SQLException{ 
	String[] cdColumns = new String[] {"cxnr:B00074:cxnr_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","zzlx:Djgzjlx:zzlx_disp"}; 

	Br41_kzqq_zf  kzqq_zf = busiDao.selectOne(namespace +"selectBr41_kzqq_kzzfBackByID",br41_kzqq_zf,cdColumns);  
	if(kzqq_zf==null )
		kzqq_zf = new Br41_kzqq_zf(); 
	return kzqq_zf;  
	} 
	/*
	 * 新增控制与止付显示页面
	 */
	public Br41_kzqq_zf performgetBr41_kzqq_kzzfDisp(String qqdbs) throws SQLException{ 
		String[] cdColumns = new String[] {"status:B00089:status_disp","qqcslx:B00073:qqcslx_disp",
				"cxnr:B00074:cxnr_disp","jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp",
				"xcrzjlx:Djgzjlx:xcrzjlx_disp","zzlx:Djgzjlx:zzlx_disp","ajlx:D00010:ajlx_disp","sqjgdm:Dgacode:sqjgdm_disp" }; 

		Br41_kzqq_zf br41_kzqq_zf = busiDao.selectOne(namespace +"selectBr41_kzqq_kzzfBackByID",qqdbs,cdColumns);  
	if(br41_kzqq_zf==null )
		br41_kzqq_zf = new Br41_kzqq_zf();
	return br41_kzqq_zf;  
	} 
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 关联查询
	 * @param br41_kzqq_zf
	 *            * @return
	 */
	public List<Br41_kzqq> getBr41_kzqq_zfzxList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00079:status_disp",
				"qqcslx:B00073:qqcslx_disp","sqjgdm:Dgacode:sqjgdm_disp","zxjg:B00099:zxjg_disp"
				,"ztlb:B00080:ztlb_disp","ajlx:D00010:ajlx_disp"};
		
		if (!"".equals(br41_kzqq.getFssj_start())) {// 申请时间起
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start()+ " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 申请时间止
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_zfzx", br41_kzqq);
		// 或在DAO查询中直接转换
		
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	public List<Br41_kzqq> getBr41_kzqq_zfzx_checkList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00079:status_disp",
				"qqcslx:B00073:qqcslx_disp","sqjgdm:Dgacode:sqjgdm_disp","zxjg:B00099:zxjg_disp"
				,"ztlb:B00080:ztlb_disp","ajlx:D00010:ajlx_disp"};
		
		if (!"".equals(br41_kzqq.getFssj_start())) {//发送起始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start()+ " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送截止时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_zf_checkList", br41_kzqq);
		// 或在DAO查询中直接转换
		
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq> getBr41_kzqq_zfzxSearchList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","xcrzjlx:Djgzjlx:xcrzjlx_disp","status:B00084:status_disp",
				"qqcslx:B00073:qqcslx_disp","sqjgdm:Dgacode:sqjgdm_disp","zxjg:B00099:zxjg_disp"	,"ztlb:B00080:ztlb_disp","ajlx:D00010:ajlx_disp","hzdm:Dszhzdm:hzdm_disp"};
		if (!"".equals(br41_kzqq.getFssj_start())) {//发送起始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start()+ " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送截止时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqq_zfzx_s", br41_kzqq);
		// 或在DAO查询中直接转换
		
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}


	/**
	 * 插入单条记录
	 * 
	 * @param br41_kzqq_zf
	 *            * @return
	 */
	public int insertBr41_kzqq_zf(Br41_kzqq_zf br41_kzqq_zf) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr41_kzqq_zf", br41_kzqq_zf);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq_zf
	 *            * @return
	 */
	public int modifyBr41_kzqq_zf(Br41_kzqq_zf br41_kzqq_zf) throws Exception {
	
		int i = busiDao.update(namespace + "updateBr41_kzqq_zf",  br41_kzqq_zf);
		
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public int deleteBr41_kzqq_zf(String rwlsh) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqq_zfByID", rwlsh);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br41_kzqq_zf getBr41_kzqq_zfDisp(String rwlsh) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };

		Br41_kzqq_zf br41_kzqq_zf = busiDao.selectOne(namespace + "selectBr41_kzqq_zfByID", rwlsh, cdColumns);
		if (br41_kzqq_zf == null)
			br41_kzqq_zf = new Br41_kzqq_zf();
		return br41_kzqq_zf;
	}
	
	
	/**
	 * 查询止付反馈信息
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br41_kzqq_zf_back getBr41_kzqq_zffkDisp(Br41_kzqq_zf_back br41_kzqq_zf_back) throws SQLException {
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp","status:B00089:status_disp","qqcslx:B00073:qqcslx_disp"
				,"tasktype:B00047:tasktype_disp","ajlx:D00010:ajlx_disp","zxjg:B00099:zxjg_disp"};
		Br41_kzqq_zf_back kzqq_zf_back = busiDao.selectOne(namespace + "selectBr41_kzqq_zffkByVo", br41_kzqq_zf_back, cdColumns);
		if (kzqq_zf_back == null)
			kzqq_zf_back = new Br41_kzqq_zf_back();
		return codeService.transBean(kzqq_zf_back, cdColumns,kzqq_zf_back.getTasktype());
	}
	
	
	public int send_hx(Br41_kzqq br41_kzqq) throws Exception {
			Mc00_tast mc00_tast = new Mc00_tast();
			br41_kzqq.setStatus("1");
			int i = busiDao.update(namespace + "updateBr41_kzqqStatus", br41_kzqq);
			String cbrc_rd_hx = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_rd_hx")); // 是否发核心
			if(!cbrc_rd_hx.equals("0")){
			Br41_kzqq_zf br41_kzqq_zf = new Br41_kzqq_zf();
			br41_kzqq_zf.setTasktype(br41_kzqq.getTasktype());
			br41_kzqq_zf.setQqdbs(br41_kzqq.getQqdbs());
			br41_kzqq_zf.setMsgcheckresult("1");
				List<Br41_kzqq_zf> list =  busiDao.selectList(namespace +"selectBr41_kzqq_zfByVo",br41_kzqq_zf); 
				for(int n=0;n<list.size();n++){
					Br41_kzqq_zf zf = (Br41_kzqq_zf)list.get(n);
					if(br41_kzqq.getTasktype().equals("6")){
						mc00_tast.setBdhm(zf.getQqdbs() + "_" + zf.getRwlsh());
					}else{
						mc00_tast.setBdhm(zf.getQqdbs() + "$" + zf.getRwlsh());
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
		Br41_kzqq_zf_back br41_kzqq_zf_back = new Br41_kzqq_zf_back();
		br41_kzqq_zf_back.setTasktype(tasktype);
		br41_kzqq_zf_back.setQqdbs(br41_kzqq.getQqdbs());
		br41_kzqq_zf_back.setRwlsh(br41_kzqq.getRwlsh());
		br41_kzqq_zf_back.setStatus("2");
		br41_kzqq_zf_back.setFeedback_p(br41_kzqq.getRecipient_p());
		br41_kzqq_zf_back.setFeedback_time(DtUtils.getNowTime());
		br41_kzqq_zf_back.setLast_up_dt(DtUtils.getNowTime());
		
		String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核   
		if(cbrc_check_flag.equals("1")){
			br41_kzqq_zf_back.setStatus("5");
		}
	    int i = busiDao.update(namespace + "updatebr41_kzqq_zf_backStatus", br41_kzqq_zf_back);

	    String  sendflag="0";
	    if(tasktype.equals("6")){ //四川省公安
			int isok = busiDao.selectOne("getbr41_kzqq_zf_backCount", br41_kzqq_zf_back);
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

	
		}
		return i;
		}
	
	
	public int send_zfcheck_jg(Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
	
	
		br41_kzqq_zf_back.setStatus("2");
		br41_kzqq_zf_back.setFeedback_time(DtUtils.getNowTime());
		br41_kzqq_zf_back.setLast_up_dt(DtUtils.getNowTime());
	  
	    int i = busiDao.update(namespace + "updatebr41_kzqq_zf_backStatus", br41_kzqq_zf_back);
		
		   Mc00_tast mc00_tast = new Mc00_tast();
	    	  mc00_tast.setBdhm(br41_kzqq_zf_back.getQqdbs()+"$"+br41_kzqq_zf_back.getRwlsh());		

			  mc00_tast.setSubtaskid(br41_kzqq_zf_back.getQqcslx());
			  mc00_tast.setTasktype(br41_kzqq_zf_back.getTasktype());

			  commonService.insertMc21_task_fact3(mc00_tast,"CBRC_"+br41_kzqq_zf_back.getTasktype());		

		return i;
		}
	
	public int return_zfcheck_jg(Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
		
		br41_kzqq_zf_back.setStatus("1");
		br41_kzqq_zf_back.setFeedback_time(DtUtils.getNowTime());
		br41_kzqq_zf_back.setLast_up_dt(DtUtils.getNowTime());
	  
	    int i = busiDao.update(namespace + "updatebr41_kzqq_zf_backStatus", br41_kzqq_zf_back);
		
		return i;
		}

}
