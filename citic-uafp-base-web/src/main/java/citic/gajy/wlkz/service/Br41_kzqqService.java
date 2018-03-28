/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-05-31]
 * =============================================
 */

package citic.gajy.wlkz.service;

/**
 * <p>
 * Br41_kzqqService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_hzws;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_hzws;

@SuppressWarnings("serial")
@Service
public class Br41_kzqqService extends BaseService {
	
	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.gajy.wlkz.mapper.busi.Br41_kzqqMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br41_kzqq
	 *        * @return
	 */
	public List<Br41_kzqq> getBr41_kzqqList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"jjcd:B00009:jjcd_disp", "qqcslx:B00073:qqcslx_disp", "status:B00089:status_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp",
											"mbjgdm:Djgorgan:mbjgdm_disp", "ztlb:B00080:ztlb_disp"};
		
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqqByVo", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	/**
	 * 列表查询，回执文书
	 * 
	 * @param br41_kzqq_hzws * @return
	 */
	public List<Br41_kzqq_hzws> getBr41_kzqq_hzwsList(Br41_kzqq_hzws br41_kzqq_hzws) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		List<Br41_kzqq_hzws> list = busiDao.selectList(namespace + "selectBr41_kzqq_hzwsByVo", br41_kzqq_hzws);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/*
	 * 新增全查控制和止付
	 */
	
	public List<Br41_kzqq> getBr41_kzqqzfList(Br41_kzqq br41_kzqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"jjcd:B00009:jjcd_disp", "qqcslx:B00073:qqcslx_disp", "status:B00089:status_disp", "ztlb:B00080:ztlb_disp", "ajlx:D00010:ajlx_disp",
											"sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp"};
		if (!"".equals(br41_kzqq.getFssj_start())) {// 发送开始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送结束时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end() + " 23:59:59");
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + "selectBr41_kzqqzfByVo", br41_kzqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq.getTasktype());
		return list;
	}
	
	public List<Br41_kzqq> getBr41_kzqqResponseList(Br41_kzqq br41_kzqq, String kztype) throws SQLException {
		String[] cdColumns = new String[] {"jjcd:B00009:jjcd_disp", "qqcslx:B00073:qqcslx_disp", "status:B00089:status_disp", "ztlb:B00080:ztlb_disp", "ajlx:D00010:ajlx_disp",
											"sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp","hzdm:Dszhzdm:hzdm_disp"};
		
		if (!"".equals(br41_kzqq.getFssj_start())) {// 发送开始时间
			br41_kzqq.setFssj_start(br41_kzqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br41_kzqq.getFssj_end())) {// 发送结束时间
			br41_kzqq.setFssj_end(br41_kzqq.getFssj_end() + " 23:59:59");
		}
		String sql = "selectBr41_cxqq_djResponseByVo";
		if (kztype.equals("2")) { //止付
			sql = "selectBr41_cxqq_zfResponseByVo";
		}
		List<Br41_kzqq> list = busiDao.selectList(namespace + sql, br41_kzqq);
		list = codeService.transListOfBean(list, cdColumns, br41_kzqq.getTasktype());
		return list;
	}
	
	/*
	 * 新增主页面
	 */
	public Br41_kzqq performgetBr41_kzqq_kzzfMain(Br41_kzqq br41_kzqq) throws SQLException {
		String[] cdColumns = new String[] {"status:B00089:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp",
											"xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp",
											"ztlb:B00080:ztlb_disp"};
		Br41_kzqq kzqq = busiDao.selectOne(namespace + "selectBr41_kzqq_kzzfByID", br41_kzqq, cdColumns);
		if (kzqq == null)
			kzqq = new Br41_kzqq();
		return codeService.transBean(kzqq, cdColumns, kzqq.getTasktype());
	}
	
	/*
	 * 新增控制与止付显示页面
	 */
	public Br41_kzqq performgetBr41_kzqq_kzzfDisp(String qqdbs) throws SQLException {
		String[] cdColumns = new String[] {"status:B00089:status_disp", "ztlb:B00080:ztlb_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
											"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp"};
		Br41_kzqq br41_kzqq = busiDao.selectOne(namespace + "selectBr41_kzqq_kzzfByID", qqdbs, cdColumns);
		if (br41_kzqq == null)
			br41_kzqq = new Br41_kzqq();
		return codeService.transBean(br41_kzqq, cdColumns, br41_kzqq.getTasktype());
	}
	
	/*
	 * 发送核心 提交监管
	 * public int modifyBr41_cxqqStatus(Br41_kzqq br41_kzqq,String flag) throws Exception {
	 * int i = 1;
	 * Mc00_tast mc00_tast = new Mc00_tast();
	 * if("1".equals(flag)){
	 * br41_kzqq.setStatus("1");
	 * i = busiDao.update(namespace + "updateBr40_cxqqStatus", br41_kzqq);
	 * List<Br40_cxqq_mx> list = busiDao.selectList(namespace +"selectBr40_cxqq_mxLisy",br41_kzqq);
	 * for(int n=0;n<list.size();n++){
	 * Br40_cxqq_mx mx = (Br40_cxqq_mx)list.get(n);
	 * mc00_tast.setBdhm(mx.getRwlsh()+"_"+br41_kzqq.getTasktype());
	 * mc00_tast.setSubtaskid(br41_kzqq.getQqcslx());
	 * commonService.insertMc21_task_fact2(mc00_tast,"GA");
	 * }
	 * }else{
	 * mc00_tast.setBdhm(br40_cxqq.getRwlsh()+"_"+br40_cxqq.getTasktype());
	 * mc00_tast.setSubtaskid(br40_cxqq.getQqcslx());
	 * commonService.insertMc21_task_fact3(mc00_tast,"GA");
	 * }
	 * return i;
	 * }
	 */
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs * @return
	 */
	public Br41_kzqq getBr41_kzqqDisp(String qqdbs) throws SQLException {
		String[] cdColumns = new String[] {"status:B00089:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp",
											"xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp", "ztlb:B00080:ztlb_disp",
											"mbjgdm:Djgorgan:mbjgdm_disp"};
		
		Br41_kzqq br41_kzqq = busiDao.selectOne(namespace + "selectBr41_kzqqByID", qqdbs, cdColumns);
		if (br41_kzqq == null)
			br41_kzqq = new Br41_kzqq();
		return br41_kzqq;
	}
	
	public List<Br40_cxqq> getBr40_wh_attach(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"wslx:B00076:wslx_disp"};
		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_wh_attachByqqdbs", br40_cxqq);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs * @return
	 */
	public Br41_kzqq getBr41_kzqqMain(Br41_kzqq br41_kzqq) throws SQLException {
		String[] cdColumns = new String[] {"status:B00089:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp",
											"xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "ztlb:B00080:ztlb_disp", "sqjgdm:Dgacode:sqjgdm_disp",
											"mbjgdm:Djgorgan:mbjgdm_disp"};
		
		Br41_kzqq kzqq = busiDao.selectOne(namespace + "selectBr41_kzqqByID", br41_kzqq, cdColumns);
		if (kzqq == null)
			kzqq = new Br41_kzqq();
		return codeService.transBean(kzqq, cdColumns, kzqq.getTasktype());
	}
	
	/**
	 * 插入单条记录
	 * 
	 * @param br41_kzqq
	 *        * @return
	 */
	public int insertBr41_kzqq(Br41_kzqq br41_kzqq) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr41_kzqq", br41_kzqq);
		return i;
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq
	 *        * @return
	 */
	public int modifyBr41_kzqq(Br41_kzqq br41_kzqq) throws SQLException {
		int i = busiDao.update(namespace + "updateBr41_kzqq", br41_kzqq);
		return i;
	}
	
	/**
	 * 根据主键删除
	 * 
	 * @param qqdbs
	 *        * @return
	 */
	public int deleteBr41_kzqq(String qqdbs) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqqByID", qqdbs);
		return i;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 *        * @return
	 */
	/*
	 * public Br41_kzqq getBr41_kzqqDisp(String qqdbs) throws SQLException {
	 * String[] cdColumns = new String[] { "flag:S00002:flag_disp" };
	 * Br41_kzqq br41_kzqq = busiDao.selectOne(namespace + "selectBr41_kzqqByID", qqdbs, cdColumns);
	 * if (br41_kzqq == null)
	 * br41_kzqq = new Br41_kzqq();
	 * return br41_kzqq;
	 * }
	 */
	
}
