/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-24] 
* =============================================
*/

package citic.gajy.wlcx.service; 
  
/**
* <p>Br40_branch_regService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException; 
import java.util.List; 
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service;  
import citic.base.BaseService;  
import citic.base.annotations.MngTx;  
import citic.gajy.wlcx.domain.Br40_branch_reg; 
  
@Service  
public class Br40_branch_regService extends BaseService {
  
/**
	 * 
	 */
private static final long serialVersionUID = 871508790897829406L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlcx.mapper.busi.Br40_branch_regMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br40_branch_reg * @return  
 */ 
public List<Br40_branch_reg> getBr40_branch_regList(Br40_branch_reg br40_branch_reg) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "outletstype:G00018:outletstype_disp","flag:G00019:flag_disp" }; 
        List<Br40_branch_reg> list =  busiDao.selectList(namespace +"selectBr40_branch_regByVo",br40_branch_reg);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br40_branch_reg * @return */ 
public int insertBr40_branch_reg (Br40_branch_reg br40_branch_reg) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr40_branch_reg",br40_branch_reg);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br40_branch_reg * @return */ 
public int modifyBr40_branch_reg (Br40_branch_reg br40_branch_reg) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr40_branch_reg",br40_branch_reg);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param uniqueid * @return */ 
public int deleteBr40_branch_reg (String uniqueid) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr40_branch_regByID",uniqueid);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param uniqueid * @return */ 
public Br40_branch_reg getBr40_branch_regDisp(String uniqueid) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br40_branch_reg br40_branch_reg = busiDao.selectOne(namespace +"selectBr40_branch_regByID",uniqueid,cdColumns);  
if(br40_branch_reg==null ) br40_branch_reg = new Br40_branch_reg(); 
return br40_branch_reg;  
} 
  
}
