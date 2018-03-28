/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-22] 
 * =============================================
 */

package citic.gajy.wlcx.service;

/**
 * <p>Br40_cxqqService.java</p>
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
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz_attach;
import citic.gajy.wlcx.domain.Br40_cxqq_mx;

@Service
public class Br40_cxqqService extends AmlBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9146627651536464402L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlcx.mapper.busi.Br40_cxqqMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br40_cxqq
	 *            * @return
	 */
	public List<Br40_cxqq> getBr40_cxqqList(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "status:B00089:status_disp", "qqcslx:B00073:qqcslx_disp", "jjcd:B00009:jjcd_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp",
				"xcrzjlx:Djgzjlx:xcrzjlx_disp", "ztlb:B00080:ztlb_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp" };
		if (!"".equals(br40_cxqq.getFssj_start())) {// 发送开始时间
			br40_cxqq.setFssj_start(br40_cxqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br40_cxqq.getFssj_end())) {// 发送结束时间
			br40_cxqq.setFssj_end(br40_cxqq.getFssj_end() + " 23:59:59");
		}
		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_cxqqByVo", br40_cxqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq.getTasktype());
		return list;
	}

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中 公安查询统计分析
	 * 
	 * @param br40_cxqq
	 *            * @return
	 */
	public List<Br40_cxqq> getBr40_cxqq_cxList(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "status:B00089:status_disp", "qqcslx:B00073:qqcslx_disp", "jjcd:B00009:jjcd_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp",
				"xcrzjlx:Djgzjlx:xcrzjlx_disp", "ztlb:B00080:ztlb_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp" };
		if (!"".equals(br40_cxqq.getFssj_start())) {// 发送开始时间
			br40_cxqq.setFssj_start(br40_cxqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br40_cxqq.getFssj_end())) {// 发送结束时间
			br40_cxqq.setFssj_end(br40_cxqq.getFssj_end() + " 23:59:59");
		}

		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_cxqq_tjByVo", br40_cxqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq.getTasktype());
		return list;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public Br40_cxqq performgetBr40_cxqqMain(Br40_cxqq br40_cxqq) throws SQLException {
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp", "ztlb:B00080:ztlb_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp" };

		Br40_cxqq cxqq = busiDao.selectOne(namespace + "selectBr40_cxqqBackByID", br40_cxqq, cdColumns);
		if (cxqq == null)
			cxqq = new Br40_cxqq();
		return codeService.transBean(cxqq, cdColumns, cxqq.getTasktype());
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 * @return
	 */
	public Br40_cxqq performGetBr41_kzqqDisp(String qqdbs) throws SQLException {
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "sqjgdm:Dgacode:sqjgdm_disp",
				"mbjgdm:Djgorgan:mbjgdm_disp" };

		Br40_cxqq br40_cxqq = busiDao.selectOne(namespace + "selectBr40_cxqqBackByID", qqdbs, cdColumns);
		if (br40_cxqq == null)
			br40_cxqq = new Br40_cxqq();
		//涉及到各个监管的证件类型，有冲突，所以做映射处理
		return codeService.transBean(br40_cxqq, cdColumns, br40_cxqq.getTasktype());
	}

	public List<Br40_cxqq> getBr40_cxqqdealList(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "ztlb:B00080:ztlb_disp",
				"sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp", "cxfkjg:B00092:cxfkjg_disp" };

		if (!"".equals(br40_cxqq.getFssj_start())) {// 发送开始时间
			br40_cxqq.setFssj_start(br40_cxqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br40_cxqq.getFssj_end())) {// 发送结束时间
			br40_cxqq.setFssj_end(br40_cxqq.getFssj_end() + " 23:59:59");
		}
		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_cxqqDealByVo", br40_cxqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq.getTasktype());
		return list;
	}
	public List<Br40_cxqq> getBr40_cxqqdeal_checkList(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "ztlb:B00080:ztlb_disp",
				"sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp", "cxfkjg:B00092:cxfkjg_disp" };

		if (!"".equals(br40_cxqq.getFssj_start())) {// 发送开始时间
			br40_cxqq.setFssj_start(br40_cxqq.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br40_cxqq.getFssj_end())) {// 发送结束时间
			br40_cxqq.setFssj_end(br40_cxqq.getFssj_end() + " 23:59:59");
		}
		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_cxqqDeal_checkByVo", br40_cxqq);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq.getTasktype());
		return list;
	}

	public List<Br40_cxqq> getBr40_cxqqResponseList(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "jjcd:B00009:jjcd_disp", "qqcslx:B00073:qqcslx_disp", "status:B00089:status_disp", "ztlb:B00080:ztlb_disp", "ajlx:D00010:ajlx_disp",
		                                    "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp","hzdm:Dszhzdm:hzdm_disp" };

		/*
		 * List<Br40_cxqq> allList=busiDao.selectList(namespace +"selectBr40_allMap", br40_cxqq.getTasktype()); List<Br40_cxqq> finshList=busiDao.selectList(namespace
		 * +"selectBr40_finshMap", br40_cxqq.getTasktype()); List<Br40_cxqq> ufinshList=busiDao.selectList(namespace +"selectBr40_unfinshMap", br40_cxqq.getTasktype());
		 * List<Br40_cxqq> list = busiDao.selectList(namespace +"selectBr40_cxqqResponseByVo",br40_cxqq); list = codeService.transListOfBean(list,
		 * cdColumns,br40_cxqq.getTasktype()); List<Br40_cxqq> newlist = new ArrayList<Br40_cxqq>(); for(int i =0;i<list.size();i++){ Br40_cxqq cxqq = (Br40_cxqq)list.get(i);
		 * 
		 * for(int j=0;j<allList.size();j++){ Br40_cxqq sall = (Br40_cxqq)allList.get(j); if(StringUtils.equals(cxqq.getQqdbs(),sall.getQqdbs())){ cxqq.setScount(sall.getScount());
		 * } }
		 * 
		 * for(int n=0;n<finshList.size();n++){ Br40_cxqq fnished= (Br40_cxqq)finshList.get(n); if(StringUtils.equals( cxqq.getQqdbs(), fnished.getQqdbs())){
		 * cxqq.setFcount(fnished.getFcount()); int unfinish = NumberUtils.toInt(cxqq.getScount()) - NumberUtils.toInt(fnished.getFcount()) ; cxqq.setUcount(unfinish+""); } }
		 * 
		 * for(int m=0;m<ufinshList.size();m++){ Br40_cxqq unfnished= (Br40_cxqq)ufinshList.get(m); if(StringUtils.equals(cxqq.getQqdbs(), unfnished.getQqdbs())){
		 * cxqq.setUcount(unfnished.getUcount()); int fcount = NumberUtils.toInt(cxqq.getScount()) - NumberUtils.toInt(cxqq.getUcount()) ; cxqq.setFcount(fcount+""); } }
		 * newlist.add(cxqq); }
		 */

		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_cxqqResponseByVo", br40_cxqq);
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq.getTasktype());

		return list;
	}

	public List<Br40_cxqq> getBr40_wh_attach(Br40_cxqq br40_cxqq) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "wslx:B00076:wslx_disp" };
		List<Br40_cxqq> list = busiDao.selectList(namespace + "selectBr40_wh_attachByqqdbs", br40_cxqq);
		String filepath = "";
		for (Br40_cxqq ws : list) {
			filepath = ws.getWjmc();
			if (filepath != null && filepath.length() > 0) {
				filepath.replaceAll("\\\\", "/");
				ws.setWjmc(filepath);
			}

		}
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}

	/**
	 * 插入单条记录
	 * 
	 * @param br40_cxqq
	 *            * @return
	 */
	public int insertBr40_cxqq(Br40_cxqq br40_cxqq) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr40_cxqq", br40_cxqq);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br40_cxqq
	 *            * @return
	 */
	public int modifyBr40_cxqq(Br40_cxqq br40_cxqq) throws SQLException {
		int i = busiDao.update(namespace + "updateBr40_cxqq", br40_cxqq);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public int deleteBr40_cxqq(String qqdbs) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr40_cxqqByID", qqdbs);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public Br40_cxqq getBr40_cxqqDisp(String qqdbs) throws SQLException {
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ajlx:D00010:ajlx_disp", "ztlb:B00080:ztlb_disp" };

		Br40_cxqq br40_cxqq = busiDao.selectOne(namespace + "selectBr40_cxqqByID", qqdbs, cdColumns);
		if (br40_cxqq == null)
			br40_cxqq = new Br40_cxqq();
		//涉及到各个监管的证件类型，有冲突，所以做映射处理
		return codeService.transBean(br40_cxqq, cdColumns, br40_cxqq.getTasktype());
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param qqdbs
	 *            * @return
	 */
	public Br40_cxqq getBr40_cxqqMain(Br40_cxqq br40_cxqq) throws SQLException {
		String[] cdColumns = new String[] { "status:B00026:status_disp", "qqcslx:B00073:qqcslx_disp", "cxnr:B00074:cxnr_disp", "jjcd:B00009:jjcd_disp",
				"qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjlx:Djgzjlx:xcrzjlx_disp", "qqrzjlx:Djgzjlx:qqrzjlx_disp", "xcrzjhm:Djgzjlx:xcrzjhm_disp", "ajlx:D00010:ajlx_disp",
				"ztlb:B00080:ztlb_disp", "sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp" };
		Br40_cxqq cxqq = busiDao.selectOne(namespace + "selectBr40_cxqqByID", br40_cxqq, cdColumns);
		if (cxqq == null)
			cxqq = new Br40_cxqq();
		//涉及到各个监管的证件类型，有冲突，所以做映射处理
		return codeService.transBean(cxqq, cdColumns,cxqq.getTasktype());
	}

	public int modifyBr40_cxqqStatus(Br40_cxqq br40_cxqq, String flag,String seq) throws Exception {
		int i = 1;
		Mc00_tast mc00_tast = new Mc00_tast();
		Br40_cxqq_back br40_cxqq_back = new Br40_cxqq_back();
		br40_cxqq_back.setTasktype(br40_cxqq.getTasktype());
		br40_cxqq_back.setQqdbs(br40_cxqq.getQqdbs());
		br40_cxqq_back.setRwlsh(br40_cxqq.getRwlsh());
		br40_cxqq_back.setSeq(seq);
		if ("1".equals(flag)) {
			String cbrc_rd_hx = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_rd_hx")); // 是否发核心
			br40_cxqq.setStatus("1");
			i = busiDao.update(namespace + "updateBr40_cxqqStatus", br40_cxqq);
			String qqcslx = br40_cxqq.getQqcslx();
			if (!cbrc_rd_hx.equals("0") || qqcslx.equals("02") || qqcslx.equals("03")) { // 动态查询时走task2
				List<Br40_cxqq_mx> list = busiDao.selectList(namespace + "selectBr40_cxqq_mxLisy", br40_cxqq);
				for (int n = 0; n < list.size(); n++) {
					Br40_cxqq_mx mx = (Br40_cxqq_mx) list.get(n);
					if (br40_cxqq.getTasktype().equals("6")) {
						mc00_tast.setBdhm(mx.getQqdbs() + "_" + mx.getRwlsh());
					} else {
						mc00_tast.setBdhm(mx.getQqdbs() + "$" + mx.getRwlsh());
					}
					mc00_tast.setTasktype(br40_cxqq.getTasktype());
					mc00_tast.setSubtaskid(qqcslx);
					commonService.insertMc21_task_fact2(mc00_tast, "CBRC_" + br40_cxqq.getTasktype());
				}

			}
		} else {
			String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核
			br40_cxqq_back.setStatus("2");
			if (cbrc_check_flag.equals("1")) {   //需要走复核时将其状态改成5
				br40_cxqq_back.setStatus("5");
			}
			br40_cxqq_back.setDealing_p(br40_cxqq.getRecipient_p());
			br40_cxqq_back.setDealing_time(DtUtils.getNowTime());
			br40_cxqq_back.setLast_up_dt(DtUtils.getNowTime());

			busiDao.update(namespace + "updateBr40_cxqq_backStatus", br40_cxqq_back);
			String sendflag = "0";
			if (br40_cxqq.getTasktype().equals("6")) {
				int isok = busiDao.selectOne("getBr40_cxqq_backCount", br40_cxqq_back);
				if (isok == 0) {
					mc00_tast.setBdhm(br40_cxqq.getQqdbs());
					sendflag = "1";
				}
			} else {
				mc00_tast.setBdhm(br40_cxqq.getQqdbs() + "$" + br40_cxqq.getRwlsh());
				sendflag = "1";
			}
			if (sendflag.equals("1")) {
				String qqcslx=br40_cxqq.getQqcslx();
				mc00_tast.setSubtaskid(br40_cxqq.getQqcslx());
				mc00_tast.setTasktype(br40_cxqq.getTasktype());
				if(qqcslx.equals("02")||qqcslx.equals("03")){
					mc00_tast.setTgroupid(br40_cxqq_back.getSeq());
				}
				if (!cbrc_check_flag.equals("1")) {
					commonService.insertMc21_task_fact3(mc00_tast, "CBRC_" + br40_cxqq.getTasktype());
				}

				// br40_cxqq.setStatus("2"); //待发送
				// busiDao.update(namespace + "updateBr40_cxqqStatus", br40_cxqq);
			}
		}

		return i;
	}
	
	public  void  modifyBr40_cxqqCheckStatus(Br40_cxqq_back br40_cxqq_back,String flag) throws Exception {

		Mc00_tast mc00_tast = new Mc00_tast();
            String qqcslx=br40_cxqq_back.getQqcslx();
		
			busiDao.update(namespace + "updateBr40_cxqq_backStatus", br40_cxqq_back);
			if(flag.equals("1")){
				mc00_tast.setBdhm(br40_cxqq_back.getQqdbs() + "$" + br40_cxqq_back.getRwlsh());
				mc00_tast.setSubtaskid(br40_cxqq_back.getQqcslx());
				mc00_tast.setTasktype(br40_cxqq_back.getTasktype());
				if(qqcslx.equals("02")||qqcslx.equals("03")){
					mc00_tast.setTgroupid(br40_cxqq_back.getSeq());
				}
			commonService.insertMc21_task_fact3(mc00_tast, "CBRC_" + br40_cxqq_back.getTasktype());
			}

	}

	/**
	 * 查询凭证图像
	 * 
	 * @param br40_cxqq_back_pz
	 * @return
	 */
	public List<Br40_cxqq_back_pz> getBr40_cxqq_back_pzList(Br40_cxqq_back_pz br40_cxqq_back_pz) {
		// 定义转换码表
		String[] cdColumns = new String[] { "cxfkjg:B00099:cxfkjg_disp", "status:B00089:status_disp", "jjcd:B00009:jjcd_disp", "pztxlx:B00113:pztxlx_disp" };
		if (!"".equals(br40_cxqq_back_pz.getFssj_start())) {// 发送开始时间
			br40_cxqq_back_pz.setFssj_start(br40_cxqq_back_pz.getFssj_start() + " 00:00:00");
		}
		if (!"".equals(br40_cxqq_back_pz.getFssj_end())) {// 发送结束时间
			br40_cxqq_back_pz.setFssj_end(br40_cxqq_back_pz.getFssj_end() + " 23:59:59");
		}
		List<Br40_cxqq_back_pz> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_pzList", br40_cxqq_back_pz, cdColumns);
		return list;
	}

	/**
	 * 根据主键查询凭证图像信息
	 * 
	 * @param br40_cxqq_back_pz
	 * @return
	 */
	public Br40_cxqq_back_pz getBr40_cxqq_back_pz(Br40_cxqq_back_pz br40_cxqq_back_pz) {
		// 定义转换码表
		String[] cdColumns = new String[] { "pztxlx:B00113:pztxlx_disp", "cxfkjg:B00077:cxfkjg_disp" };
		Br40_cxqq_back_pz back_pz = busiDao.selectOne(namespace + "selectBr40_cxqq_back_pzByID", br40_cxqq_back_pz, cdColumns);
		if (back_pz == null)
			back_pz = new Br40_cxqq_back_pz();
		return back_pz;
	}

	/**
	 * 更新凭证图像信息
	 * 
	 * @param br40_cxqq_back_pz
	 */
	public void modifyBr40_cxqq_back_pz(Br40_cxqq_back_pz br40_cxqq_back_pz) {

		busiDao.update(namespace + "updateBr40_cxqq_back_pz", br40_cxqq_back_pz);
	}

	/**
	 * 查询凭证图像附件
	 * 
	 * @param br40_cxqq_back_pz_attach
	 * @return
	 * @throws SQLException
	 */
	public List<Br40_cxqq_back_pz_attach> getBr40_cxqq_back_pz_attach(Br40_cxqq_back_pz br40_cxqq_back_pz) throws SQLException {

		List<Br40_cxqq_back_pz_attach> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_pz_attachByVo", br40_cxqq_back_pz);

		return list;
	}

	/**
	 * 插入凭证图像附件
	 * 
	 * @param br40_cxqq_back_pz
	 */
	public void insertBr40_cxqq_back_pz_attach(Br40_cxqq_back_pz_attach br40_cxqq_back_pz_attach) {

		busiDao.insert(namespace + "insertBr40_cxqq_back_pz_attach", br40_cxqq_back_pz_attach);
	}

	/**
	 * 删除凭证图像附件
	 * 
	 * @param br40_cxqq_back_pz_attach
	 */
	public void deleteBr40_cxqq_back_pz_attach(Br40_cxqq_back_pz_attach br40_cxqq_back_pz_attach) {
		busiDao.delete(namespace + "deleteBr40_cxqq_back_pz_attach", br40_cxqq_back_pz_attach);
	}

	/**
	 * 取指定qqdbs下的最大凭证图像序号
	 * 
	 * @param br40_cxqq_back_pz
	 */
	public int getMaxPztxxhByVo(Br40_cxqq_back_pz br40_cxqq_back_pz) {
		int num = busiDao.selectOne(namespace + "selectMaxPztxxhByVo", br40_cxqq_back_pz);
		return num;
	}


	/**
	 * 凭证图像处理---发送监管
	 * @param br40_cxqq_back_pz
	 */
	@BusiTx
	public void modifyStatusAndInsertTask3(Br40_cxqq_back_pz br40_cxqq_back_pz) throws Exception{
		//修改状态
		busiDao.update(namespace + "updateBr40_cxqq_back_pzByStatus", br40_cxqq_back_pz);
		//向task3插入一条任务
		Mc00_tast mc00_tast = new Mc00_tast();
		mc00_tast.setBdhm(br40_cxqq_back_pz.getQqdbs() + "$" + br40_cxqq_back_pz.getRwlsh());
		mc00_tast.setSubtaskid("10");
		mc00_tast.setTasktype(br40_cxqq_back_pz.getTasktype());
		commonService.insertMc21_task_fact3(mc00_tast, "CBRC_" + br40_cxqq_back_pz.getTasktype());
	}
	
	public void updateBr40_cxqq_backDStatus() throws Exception{
		//修改状态
		String currdate=DtUtils.getNowDate();
		busiDao.update(namespace + "updateBr41_cxqq_back_dStatus", currdate);
	}

}
