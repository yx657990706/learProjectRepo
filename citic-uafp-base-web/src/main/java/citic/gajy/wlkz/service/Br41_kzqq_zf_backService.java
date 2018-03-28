/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.service;


/**
 * <p>Br41_kzqq_zf_backService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back_mx;

@Service
public class Br41_kzqq_zf_backService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlkz.mapper.Br41_kzqq_zf_backMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br41_kzqq_zf_back
	 *            * @return
	 */
	public List<Br41_kzqq_zf_back> getBr41_kzqq_zf_backList(Br41_kzqq_zf_back br41_kzqq_zf_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"status:B00079:status_disp","tasktype:B00047:tasktype_disp"};
		List<Br41_kzqq_zf_back> list = busiDao.selectList(namespace + "selectBr41_kzqq_zf_backByVo", br41_kzqq_zf_back);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}

	/**
	 * 查询反馈明细信息
	 * 
	 * @param br41_kzqq_zf_back_mx
	 * @return
	 */
	public List<Br41_kzqq_zf_back_mx> getBr41_kzqq_zf_back_mxList(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "zxjg:B00099:zxjg_disp", "bz:Dcrtpd:bz_disp"};
		// 处理日期 数据库中19位，页面传的是10位
		if (!"".equals(br41_kzqq_zf_back_mx.getZfjssj_start())) {// 止付结束时间
			br41_kzqq_zf_back_mx.setZfjssj_start(br41_kzqq_zf_back_mx.getZfjssj_start()+ " 00:00:00");
		}
		if (!"".equals(br41_kzqq_zf_back_mx.getZfjssj_end())) {// 止付结束时间
			br41_kzqq_zf_back_mx.setZfjssj_end(br41_kzqq_zf_back_mx.getZfjssj_end()+ " 23:59:59");
		}
		if (!"".equals(br41_kzqq_zf_back_mx.getZfkssj_start())) {// 止付开始时间
			br41_kzqq_zf_back_mx.setZfkssj_start(br41_kzqq_zf_back_mx.getZfkssj_start()+ " 00:00:00");
		}
		if (!"".equals(br41_kzqq_zf_back_mx.getZfkssj_end())) {// 止付开始时间
			br41_kzqq_zf_back_mx.setZfkssj_end(br41_kzqq_zf_back_mx.getZfkssj_end()+ " 23:59:59");
		}
		List<Br41_kzqq_zf_back_mx> list = busiDao.selectList(namespace + "selectBr41_kzqq_zf_back_mxByVo", br41_kzqq_zf_back_mx);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq_zf_back_mx.getTasktype());
		return list;
	}

	
	public Br41_kzqq_zf_back getBr41_kzqq_zf_fkDisp(Br41_kzqq_zf_back br41_kzqq_zf_back) throws SQLException {
		String[] cdColumns = new String[] {"status:B00084:status_disp","tasktype:B00047:tasktype_disp","zxjg:B00099:zxjg_disp","organkey:Dorgan:organkey_disp"};

		Br41_kzqq_zf_back kzqq_zf_back = busiDao.selectOne(namespace + "selectBr41_kzqq_zf_fkByVo",br41_kzqq_zf_back, cdColumns);
		if (kzqq_zf_back == null)
			kzqq_zf_back = new Br41_kzqq_zf_back();
		return codeService.transBean(kzqq_zf_back, cdColumns, kzqq_zf_back.getTasktype());
	}
   /**
    * 查询单条明细信息
    * @param br41_kzqq_zf_back_mx
    * @return int i
    * @throws SQLException
    */
	public int getBr41_kzqq_zf_back_mxDisp(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {
		int i= busiDao.selectOne(namespace + "selectBr41_kzqq_zf_back_mxByRwlsh",br41_kzqq_zf_back_mx,null);
		return i;
	}
	   /**
	    * 查询单条明细信息
	    * @param br41_kzqq_zf_back_mx
	    * @return zf_back_mx
	    * @throws SQLException
	    */
		public Br41_kzqq_zf_back_mx getBr41_kzqq_zf_back_mxDoDisp(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {
			Br41_kzqq_zf_back_mx  zf_back_mx= busiDao.selectOne(namespace + "selectBr41_kzqq_zf_back_mxByUnitKey",br41_kzqq_zf_back_mx,null);
			if (zf_back_mx == null)
				zf_back_mx = new  Br41_kzqq_zf_back_mx();
			return zf_back_mx;
		}
	/**
	 * 插入单条记录
	 * 止付明细信息
	 * @param br41_kzqq_zf_back
	 * @return
	 */
	public int insertBr41_kzqq_zf_back_mx(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {

		int i = busiDao.insert(namespace + "insertBr41_kzqq_zf_back_mx", br41_kzqq_zf_back_mx);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq_zf_back
	 *  @return
	 */
	public int modifyBr41_kzqq_zf_back_mx(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {
	
		int i = busiDao.update(namespace + "updateBr41_kzqq_zf_back_mx", br41_kzqq_zf_back_mx);
		return i;
	}
	
	public int modifyBr41_kzqq_zf_back_disp(Br41_kzqq_zf_back br41_kzqq_zf_back) throws SQLException {
		int i = busiDao.update(namespace + "modifyBr41_kzqq_zf_back", br41_kzqq_zf_back);
		return i;
	}

	/**
	 * 根据主键删除支付明细信息
	 * @param rwlsh
	 * @return
	 */
	public int deleteBr41_kzqq_zf_back_mx(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqq_zf_back_mxByID", br41_kzqq_zf_back_mx);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param rwlsh
	 * @return
	 */
	public Br41_kzqq_zf_back getBr41_kzqq_zf_backDisp(String rwlsh) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };

		Br41_kzqq_zf_back br41_kzqq_zf_back = busiDao.selectOne(namespace + "selectBr41_kzqq_zf_backByID", rwlsh);
		if (br41_kzqq_zf_back == null)
			br41_kzqq_zf_back = new Br41_kzqq_zf_back();
		return br41_kzqq_zf_back;
	}

}
