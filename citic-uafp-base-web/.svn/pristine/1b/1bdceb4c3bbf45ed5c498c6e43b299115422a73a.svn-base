/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2015-03-23]
 * =============================================
 */

package citic.aml.system.service;

/**
 * <p>UserService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.aml.system.domain.Mp02_user;
import citic.base.annotations.BusiTx;

@Service
public class UserService extends AmlBaseService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4859838858686870054L;
	/** map命名空间 */
	private String namespace = "citic.aml.system.mapper.busi.UserMapper.";

	/**
	 * 新增单条记录
	 * 
	 * @param mp02_user
	 * @return
	 * @throws Exception
	 */
	@BusiTx
	public int insertValidM002_user(Mp02_user user) throws Exception {
		int i = busiDao.insert(namespace + "insertValidUser", user);
		return i;
	}

	/**
	 * 查询单条用户信息
	 * @param loginname
	 * @return
	 * @throws Exception
	 */
	public Mp02_user getMp02_userDispByLoginName(String loginname) throws Exception {

		Mp02_user mp02_user = null;
		try {
			mp02_user = busiDao.selectOne(namespace + "userbyLoginName", loginname);
		} catch (Exception e) {
			throw e;
		}

		if (mp02_user == null)
			mp02_user = new Mp02_user();
		return mp02_user;
	}
}
