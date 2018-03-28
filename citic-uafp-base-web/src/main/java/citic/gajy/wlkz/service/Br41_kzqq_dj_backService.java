/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.service;

/**
 * <p>Br41_kzqq_dj_backService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back;
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back_mx;

@Service
public class Br41_kzqq_dj_backService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5498553987426116339L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gajy.wlkz.mapper.Br41_kzqq_dj_backMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br41_kzqq_dj_back
	 * @return
	 */
	public List<Br41_kzqq_dj_back> getBr41_kzqq_dj_backList(Br41_kzqq_dj_back br41_kzqq_dj_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"status:B00079:status_disp","tasktype:B00047:tasktype_disp"};
		List<Br41_kzqq_dj_back> list = busiDao.selectList(namespace + "selectBr41_kzqq_dj_backByVo", br41_kzqq_dj_back);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询反馈明细信息
	 * @param br41_kzqq_dj_back_mx
	 * @return
	 */
	public List<Br41_kzqq_dj_back_mx> getKzdj_fk_mx_list(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"zxjg:B00099:zxjg_disp","bz:Dcrtpd:bz_disp"};
		if( !"".equals(br41_kzqq_dj_back_mx.getDjkssj_start())){
			br41_kzqq_dj_back_mx.setDjkssj_start(br41_kzqq_dj_back_mx.getDjkssj_start()+" 00:00:00");//冻结开始时间
		}
		if(!"".equals(br41_kzqq_dj_back_mx.getDjkssj_end())){
			br41_kzqq_dj_back_mx.setDjkssj_end(br41_kzqq_dj_back_mx.getDjkssj_end()+" 23:59:59");//冻结开始时间
		}
		if( !"".equals(br41_kzqq_dj_back_mx.getDjjssj_start())){
			br41_kzqq_dj_back_mx.setDjjssj_start(br41_kzqq_dj_back_mx.getDjjssj_start()+" 00:00:00");//冻结结束时间
		}
		if( !"".equals(br41_kzqq_dj_back_mx.getDjjssj_end())){
			br41_kzqq_dj_back_mx.setDjjssj_end(br41_kzqq_dj_back_mx.getDjjssj_end()+" 23:59:59");//冻结结束时间
		}
		List<Br41_kzqq_dj_back_mx> list = busiDao.selectList(namespace + "selectBr41_kzqq_dj_back_mxByVo", br41_kzqq_dj_back_mx);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns,br41_kzqq_dj_back_mx.getTasktype());
		return list;
	}
	
	
	public Br41_kzqq_dj_back getBr41_kzqq_dj_fkList(Br41_kzqq_dj_back br41_kzqq_dj_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"status:B00084:status_disp","zxjg:B00099:zxjg_disp"};
		Br41_kzqq_dj_back kzqq_dj_back = busiDao.selectOne(namespace + "selectBr41_kzqq_dj_fkByVo", br41_kzqq_dj_back,cdColumns);
		// 或在DAO查询中直接转换
		if (kzqq_dj_back == null)
			kzqq_dj_back = new Br41_kzqq_dj_back();
		return kzqq_dj_back;
	}

	/**
	 * 插入单条记录
	 * 
	 * @param br41_kzqq_dj_back
	 * @return
	 */
	public int insertBr41_kzqq_dj_back_mx(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {

		int i = busiDao.insert(namespace + "insertBr41_kzqq_dj_back_mx", br41_kzqq_dj_back_mx);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq_dj_back
	 * @return
	 */
	public int modifyBr41_kzqq_dj_back_mx(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {
	
		int i = busiDao.update(namespace + "updateBr41_kzqq_dj_back_mx", br41_kzqq_dj_back_mx);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param rwlsh
	 * @return
	 */
	public int deleteBr41_kzqq_dj_back(String rwlsh) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqq_dj_backByID", rwlsh);
		return i;
	}
	
	
	/**
	 * 根据联合主键删除数据
	 * 
	 * @param br41_kzqq_dj_back_mx
	 * @return
	 */
	public int deleteBr41_kzqq_dj_back_mx(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr41_kzqq_dj_back_mxByUnitKey", br41_kzqq_dj_back_mx);
		return i;
	}
	
	
	/**
	 * 根据联合主键查询单条记录
	 * @param br41_kzqq_dj_back_mx
	 * @return
	 */
	public Br41_kzqq_dj_back_mx getBr41_kzqq_dj_back_mxDisp(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {
		Br41_kzqq_dj_back_mx  kzqq_dj_back_mx = busiDao.selectOne(namespace + "selectBr41_kzqq_dj_back_mxByUnitkey", br41_kzqq_dj_back_mx);
		if (kzqq_dj_back_mx == null)
			kzqq_dj_back_mx = new Br41_kzqq_dj_back_mx();
		return kzqq_dj_back_mx;
	}

	
	/**
	 * 根据联合主键查询总条数
	 * @param br41_kzqq_dj_back_mx
	 * @return
	 */
	public int getBr41_kzqq_dj_back_mxCountDisp(Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws SQLException {
	Integer i= busiDao.selectOne(namespace + "selectBr41_kzqq_dj_back_mxByUnitkeyCount", br41_kzqq_dj_back_mx);
	return i;	
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param br41_kzqq_dj_back
	 *            * @return
	 */
	public int modifyBr41_kzqq_dj_back(Br41_kzqq_dj_back br41_kzqq_dj_back) throws SQLException {
		int i = busiDao.update(namespace + "modifyBr41_kzqq_dj_back", br41_kzqq_dj_back);
		return i;
	}

}
