/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-22] 
 * =============================================
 */

package citic.gajy.wlcx.service;

/**
 * <p>Br40_cxqq_mxService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_ql;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_qzcs;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_sub;
import citic.gajy.wlcx.domain.Br40_cxqq_back_party;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz;
import citic.gajy.wlcx.domain.Br40_cxqq_back_trans;
import citic.gajy.wlcx.domain.Br40_cxqq_mx;

@Service
public class Br40_cxqq_mxService extends AmlBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1667177150464205656L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlcx.mapper.busi.Br40_cxqq_mxMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br40_cxqq_mx
	 *            * @return
	 */
	public List<Br40_cxqq_mx> getBr40_cxqq_mxList(Br40_cxqq_mx br40_cxqq_mx) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "mxsdlx:B00075:mxsdlx_disp", "zzlx:Djgzjlx:zzlx_disp", "ztlb:B00080:ztlb_disp", "cxnr:B00074:cxnr_disp", "status:B00084:status_disp",
				"cxfkjg:B00092:cxfkjg_disp", "msgcheckresult:B00200:msgcheckresult_disp" };
		List<Br40_cxqq_mx> list = null;
		if("10".equals(br40_cxqq_mx.getQqcslx())){//凭证图像查询
			cdColumns = new String[] {"status:B00079:status_disp","cxfkjg:B00092:cxfkjg_disp","pztxlx:B00113:pztxlx_disp"};
			list = busiDao.selectList(namespace + "selectBr40_cxqq_back_pzByVo", br40_cxqq_mx,cdColumns);
		}else{
			list = busiDao.selectList(namespace + "selectBr40_cxqq_mxByVo", br40_cxqq_mx,cdColumns);
		}
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list,cdColumns,br40_cxqq_mx.getTasktype());
		return list;
	}

	/**
	 * 账户凭证图像信息列表
	 * 
	 * @param br40_cxqq_mx
	 * @return
	 */
	public List<Br40_cxqq_back_pz> getBr40_cxqq_back_pz_List(Br40_cxqq_mx br40_cxqq_mx) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "cxfkjg:B00077:cxfkjg_disp" };
		List<Br40_cxqq_back_pz> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_pz_ByVo", br40_cxqq_mx);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}

	/**
	 * 插入单条记录
	 * 
	 * @param br40_cxqq_mx
	 *            * @return
	 */
	public int insertBr40_cxqq_mx(Br40_cxqq_mx br40_cxqq_mx) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr40_cxqq_mx", br40_cxqq_mx);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br40_cxqq_mx
	 *            * @return
	 */
	public int modifyBr40_cxqq_mx(Br40_cxqq_mx br40_cxqq_mx) throws SQLException {
		int i = busiDao.update(namespace + "updateBr40_cxqq_mx", br40_cxqq_mx);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public int deleteBr40_cxqq_mx(String rwlsh) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr40_cxqq_mxByID", rwlsh);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br40_cxqq_back
	 *            * @return
	 */
	public int modifyBr40_cxqq_back(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		int i = busiDao.update(namespace + "updateBr40_cxqq_backByRwlshAndQqdbs", br40_cxqq_back);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br40_cxqq_mx getBr40_cxqq_mxDisp(String rwlsh) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp", "zzlx:Djgzjlx:zzlx_disp", "cxzl:B00081:cxzl_disp", "cxlx:B00082:cxlx_disp" };

		Br40_cxqq_mx br40_cxqq_mx = busiDao.selectOne(namespace + "selectBr40_cxqq_mxByID", rwlsh);
		if (br40_cxqq_mx == null)
			br40_cxqq_mx = new Br40_cxqq_mx();
		return codeService.transBean(br40_cxqq_mx, cdColumns, br40_cxqq_mx.getTasktype());
	}

	/**
	 * 根据请求单标识，任务流水号查询记录条数
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public int getBr40_cxqq_backDispCount(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] { "zhzt:B00013:zhzt_disp", "mxsdlx:B00075:mxsdlx_disp", "cxfkjg:B00077:cxfkjg_disp" };

		Integer count = busiDao.selectOne(namespace + "selectBr40_cxqq_backByqqdbsCount", br40_cxqq_back, cdColumns);
		return count.intValue();
	}

	/**
	 * 根据请求单标识，任务流水号查询记录
	 * 
	 * @param rwlsh
	 * @return
	 */
	public Br40_cxqq_back getBr40_cxqq_backDisp(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] {"sfxd:G00010:sfxd_disp","msgcheckresult:B00200:msgcheckresult_disp" ,
				"sqjgdm:Dgacode:sqjgdm_disp", "mbjgdm:Djgorgan:mbjgdm_disp", "ztlb:B00080:ztlb_disp","status:B00084:status_disp","zzlx:Djgzjlx:zzlx_disp","cxnr:B00074:cxnr_disp" };

		Br40_cxqq_back cxqq_back = busiDao.selectOne(namespace + "selectBr40_cxqq_backByqqdbsAndjylsh", br40_cxqq_back, cdColumns);
		if (cxqq_back == null)
			cxqq_back = new Br40_cxqq_back();
		return codeService.transBean(cxqq_back, cdColumns, cxqq_back.getTasktype());
	}

	/**
	 * 根据请求单标识，任务流水号查询动态list
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public List<Br40_cxqq_back> getBr40_cxqq_backDtList(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] { "mxsdlx:B00075:mxsdlx_disp", "cxfkjg:B00077:cxfkjg_disp", "status:B00084:status_disp" };

		// 查询时间处理［10位转19位］
		String date_q = br40_cxqq_back.getZxqssj_s();
		String date_z = br40_cxqq_back.getZxqssj_e();
	  if (!StringUtils.equals("", date_q)) {//执行开始时间
			br40_cxqq_back.setZxqssj_s(date_q + " 00:00:00");
		}
		if (!StringUtils.equals("", date_z)) {
			br40_cxqq_back.setZxqssj_e(date_z + " 23:59:59");
		}
		List<Br40_cxqq_back> list = busiDao.selectList(namespace + "selectBr40_cxqq_backByqqdbsAndjylshList", br40_cxqq_back);
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}

	/**
	 * 根据请求单标识，任务流水号查询动态
	 * 
	 * @param rwlsh
	 *            * @return
	 */
	public Br40_cxqq_back getBr40_cxqq_backDtjcDisp(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] { "mxsdlx:B00075:mxsdlx_disp", "cxfkjg:B00099:cxfkjg_disp" };

		Br40_cxqq_back cxqq_back = busiDao.selectOne(namespace + "selectBr40_cxqq_backByqqdbsAndjylshList", br40_cxqq_back, cdColumns);
		if (cxqq_back == null)
			cxqq_back = new Br40_cxqq_back();
		return cxqq_back;
	}

	/**
	 * 根据主键查询明细：客户信息
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public Br40_cxqq_back_party getBr40_cxqq_back_partyDisp(Br40_cxqq_back_party br40_cxqq_back_party) throws SQLException {

		// 定义转换码表
		String[] cdColumns = new String[] { "zzlx:Djgzjlx:zzlx_disp", "cxfkjg:B00092:cxfkjg_disp","frdbzjlx:Djgzjlx:frdbzjlx_disp","dbrzjlx:Djgzjlx:dbrzjlx_disp"  };
		Br40_cxqq_back_party _br40_cxqq_back_party = busiDao.selectOne(namespace + "selectBr40_cxqq_back_partyByVo", br40_cxqq_back_party, cdColumns);
		if (_br40_cxqq_back_party == null) {
			_br40_cxqq_back_party = new Br40_cxqq_back_party();
		}
		return codeService.transBean(_br40_cxqq_back_party, cdColumns, _br40_cxqq_back_party.getTasktype());
	}

	/**
	 * 账户信息
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public List<Br40_cxqq_back_acct> getBr40_cxqq_back_acctList(Br40_cxqq_back_acct br40_cxqq_back_acct) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "bz:Dcrtpd:bz_disp" };
		List<Br40_cxqq_back_acct> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_acct_ByVo", br40_cxqq_back_acct);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq_back_acct.getTasktype());
		return list;
	}

	/**
	 * 强制措施信息
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public List<Br40_cxqq_back_acct_qzcs> getBr40_cxqq_back_acct_qzcsList(Br40_cxqq_back_acct_qzcs br40_cxqq_back_acct_qzcs) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "djcslx:S00062:djcslx_disp","djjgmc:Dgacode:djjgmc_disp" };
		List<Br40_cxqq_back_acct_qzcs> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_acct_qzcs_ByVo", br40_cxqq_back_acct_qzcs);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br40_cxqq_back_acct_qzcs.getTasktype());
		return list;
	}

	/**
	 * 共享权优先权信息
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public List<Br40_cxqq_back_acct_ql> getBr40_cxqq_back_acct_qlList(Br40_cxqq_back_acct_ql br40_cxqq_back_acct_ql) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "qllx:S00060:qllx_disp", "zzlxdm:Djgzjlx:zzlxdm_disp" };
		List<Br40_cxqq_back_acct_ql> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_acct_ql_ByVo", br40_cxqq_back_acct_ql);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br40_cxqq_back_acct_ql.getTasktype());
		return list;
	}

	/**
	 * 关联子账号关联信息
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public List<Br40_cxqq_back_acct_sub> getBr40_cxqq_back_acct_subList(Br40_cxqq_back_acct_sub br40_cxqq_back_acct_sub) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "bz:Dcrtpd:bz_disp" };
		List<Br40_cxqq_back_acct_sub> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_acct_sub_ByVo", br40_cxqq_back_acct_sub);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns, br40_cxqq_back_acct_sub.getTasktype());
		return list;
	}

	/**
	 * 账户交易明细
	 * 
	 * @param br40_cxqq_back_party
	 *            * @return
	 */
	public List<Br40_cxqq_back_trans> getBr40_cxqq_back_transList(Br40_cxqq_back_trans br40_cxqq_back_trans) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "cxfkjg:B00092:cxfkjg_disp", "bz:Dcrtpd:bz_disp", "zzlx:Djgzjlx:zzlx_disp", "dbrzjlx:Djgzjlx:dbrzjlx_disp", "xjbz:B00019:xjbz_disp",
				"jysfcg:B00092:jysfcg_disp" };
		// 处理日期 数据库中19位，页面传的是10位
		if (!StringUtils.equals("",br40_cxqq_back_trans.getJysj_start())) {// 交易开始时间
			br40_cxqq_back_trans.setJysj_start(br40_cxqq_back_trans.getJysj_start() + " 00:00:00");
		}
		if (!StringUtils.equals("",br40_cxqq_back_trans.getJysj_end())) {// 交易截止时间
			br40_cxqq_back_trans.setJysj_end(br40_cxqq_back_trans.getJysj_end() + " 23:59:59");
		}
		List<Br40_cxqq_back_trans> list = busiDao.selectList(namespace + "selectBr40_cxqq_back_trans_ByVo", br40_cxqq_back_trans);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br40_cxqq_back_trans.getTasktype());
		return list;
	}

	/**
	 * 根据条件删除br40_cxqq_back记录
	 * 
	 * @param br40_cxqq_back
	 * @return
	 * @throws SQLException
	 */
	public int deleteBr40_cxqq_backByKeys(Br40_cxqq_back br40_cxqq_back) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr40_cxqq_backByKeys", br40_cxqq_back);
		return i;
	}
	
	public List<Br40_cxqq> getBr40_cxqq_queryRgList(Br40_cxqq br40_cxqq) throws SQLException{ 
		// 定义转换码表 
			String[] cdColumns = new String[] {"qqcslx:B00073:qqcslx_disp","cxnr:B00074:cxnr_disp",
					"jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","status:B00084:status_disp","zzlx:Djgzjlx:zzlx_disp",
					"ajlx:D00010:ajlx_disp","ztlb:B00080:ztlb_disp","sqjgdm:Dgacode:sqjgdm_disp","mbjgdm:Djgorgan:mbjgdm_disp","cxfkjg:B00092:cxfkjg_disp" }; 
			
			// 处理日期 数据库中19位，页面传的是10位
			if (!"".equals(br40_cxqq.getFssj_start())) {// 交易开始时间
				br40_cxqq.setFssj_start(br40_cxqq.getFssj_start() + " 00:00:00");
			}
			if (!"".equals(br40_cxqq.getFssj_end())) {// 交易截止时间
				br40_cxqq.setFssj_end(br40_cxqq.getFssj_end() + " 23:59:59");
			}
		 List<Br40_cxqq> list =  busiDao.selectList(namespace +"selectBr40_cxqq_cg_queryByVo",br40_cxqq);  
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns,br40_cxqq.getTasktype());
		return list;  
		} 
	
	public List<Br40_cxqq> getBr40_cxqq_queryDtList(Br40_cxqq br40_cxqq) throws SQLException{ 
		// 定义转换码表 
			String[] cdColumns = new String[] {"qqcslx:B00073:qqcslx_disp",
					"jjcd:B00009:jjcd_disp","qqrzjlx:Djgzjlx:qqrzjlx_disp","status:B00084:status_disp","zzlx:Djgzjlx:zzlx_disp",
					"ajlx:D00010:ajlx_disp","ztlb:B00080:ztlb_disp","sqjgdm:Dgacode:sqjgdm_disp","mbjgdm:Djgorgan:mbjgdm_disp","cxfkjg:B00077:cxfkjg_disp" }; 
			
		 List<Br40_cxqq> list =  busiDao.selectList(namespace +"selectBr40_cxqq_dt_queryByVo",br40_cxqq);  
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns,br40_cxqq.getTasktype());
		return list;  
		} 

}
