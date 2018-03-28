/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-24] 
* =============================================
*/

package citic.gajy.wlcx.service; 
  
/**
* <p>Br40_acct_ruleService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.aml.system.domain.Mc00_tast;
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_acct_rule;
  
@Service  
public class Br40_acct_ruleService extends AmlBaseService{
  
/**
	 * 
	 */
private static final long serialVersionUID = -6424898514902756475L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlcx.mapper.busi.Br40_acct_ruleMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br40_acct_rule * @return  
 */ 
public List<Br40_acct_rule> getBr40_acct_ruleList(Br40_acct_rule br40_acct_rule) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
        List<Br40_acct_rule> list =  busiDao.selectList(namespace +"selectBr40_acct_ruleByVo",br40_acct_rule);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br40_acct_rule * @return 
 * @throws Exception */ 
@BusiTx
public int insertBr40_acct_rule (Br40_acct_rule br40_acct_rule,HttpServletRequest request) throws Exception{ 
	//获取当前用户
   String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
   br40_acct_rule.setUniqueid("ZHGZ_"+this.getSequenceValus("SEQ_BRANK_RESPORT"));//从序列中获取
   br40_acct_rule.setLastuser(loginname);
   br40_acct_rule.setLastts(DtUtils.getNowTime());
   br40_acct_rule.setFlag("1");
int i = busiDao.insert(namespace +"insertBr40_acct_rule",br40_acct_rule);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br40_acct_rule * @return */ 
public int modifyBr40_acct_rule (Br40_acct_rule br40_acct_rule) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr40_acct_rule",br40_acct_rule);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param uniqueid * @return */ 
public int deleteBr40_acct_rule (String uniqueid) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr40_acct_ruleByID",uniqueid);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param uniqueid * @return */ 
public Br40_acct_rule getBr40_acct_ruleDisp(String uniqueid) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br40_acct_rule br40_acct_rule = busiDao.selectOne(namespace +"selectBr40_acct_ruleByID",uniqueid,cdColumns);  
if(br40_acct_rule==null ) br40_acct_rule = new Br40_acct_rule(); 
return br40_acct_rule;  
} 

/** 
 *根据主键查询单条记录 
 * @param uniqueid * @return */ 
public int getBr40_acct_ruleCount(String uniqueid) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Integer count = busiDao.selectOne(namespace +"selectBr40_acct_ruleCountById",uniqueid,cdColumns);  
return count.intValue();  
}

/** 
 *查询账户规则
 * @param uniqueid * @return */ 
public List<Mc00_tast> getBr40_acct_ruleByTx_code(String tx_code) throws SQLException{ 
	//String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
	List<Mc00_tast> list =  busiDao.selectList(namespace +"selectmc21_task_relaByTxcode",tx_code,null);  
return list;  
}
  
}
