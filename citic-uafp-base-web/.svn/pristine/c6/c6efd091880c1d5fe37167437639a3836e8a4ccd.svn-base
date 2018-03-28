/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-31] 
* =============================================
*/

package citic.whpsb.wlcx.service; 
  
/**
* <p>Br51_cxqq_mxService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.whpsb.wlcx.domain.Br51_cxqq_mx;
  
@Service  
public class Br51_cxqq_mxService extends BaseService {
  
/**
	 * 
	 */
	private static final long serialVersionUID = -901440756240876028L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.whpsb.mapper.busi.Br51_cxqq_mxMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq_mx * @return  
 */ 
public List<Br51_cxqq_mx> getBr51_cxqq_mxList(Br51_cxqq_mx br51_cxqq_mx) throws SQLException{ 
    // 定义转换码表  
	///I:对私 C:对公 
	String[] cdColumns = new String[] { "zzlx:DwhZjlx:zzlx_disp","cljg:G00025:cljg_disp" };
	
 
  List<Br51_cxqq_mx> list =  busiDao.selectList(namespace +"selectBr51_cxqq_mxByVo",br51_cxqq_mx);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br51_cxqq_mx * @return */ 
public int insertBr51_cxqq_mx (Br51_cxqq_mx br51_cxqq_mx) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr51_cxqq_mx",br51_cxqq_mx);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br51_cxqq_mx * @return */ 
public int modifyBr51_cxqq_mx (Br51_cxqq_mx br51_cxqq_mx) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr51_cxqq_mx",br51_cxqq_mx);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param ah * @return */ 
public int deleteBr51_cxqq_mx (String ah) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr51_cxqq_mxByID",ah);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param ah * @return */ 
public Br51_cxqq_mx getBr51_cxqq_mxDisp(String bdhm) throws SQLException{ 
String[] cdColumns = new String[] { "zzlx:DwhZjlx:zzlx_disp"}; 
  
Br51_cxqq_mx br51_cxqq_mx = busiDao.selectOne(namespace +"selectBr51_cxqq_mxByID",bdhm,cdColumns);  
if(br51_cxqq_mx==null ) br51_cxqq_mx = new Br51_cxqq_mx(); 
return br51_cxqq_mx;  
} 
  
}
