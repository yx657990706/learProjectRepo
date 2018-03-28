/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-31] 
* =============================================
*/

package citic.shpsb.wlcx.service; 
  
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
import citic.shpsb.wlcx.domain.Br54_cxqq_mx;
  
@Service  
public class Br54_cxqq_mxService extends BaseService {
/**
	 * 
	 */
	private static final long serialVersionUID = 5455677020878234157L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.shpsb.mapper.busi.Br54_cxqq_mxMapper."; 

/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq_mx 
 * @return  
 */ 
public List<Br54_cxqq_mx> getBr54_cxqq_mxList(Br54_cxqq_mx br54_cxqq_mx) throws SQLException{ 
   // 定义转换码表  
  String[] cdColumns = new String[] { "zzlx:DwhZjlx:zzlx_disp","cljg:G00025:cljg_disp" };
  List<Br54_cxqq_mx> list =  busiDao.selectList(namespace +"selectBr54_cxqq_mxByVo",br54_cxqq_mx);  
  //或在DAO查询中直接转换  
  list = codeService.transListOfBean(list, cdColumns);
  return list;  
} 


/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq_mx * @return  
 */ 
public List<Br54_cxqq_mx> getBr54_cxqq_mx_dispList(Br54_cxqq_mx br54_cxqq_mx) throws SQLException{ 
   // 定义转换码表  
  String[] cdColumns = new String[] { "zzlx:DwhZjlx:zzlx_disp","cljg:G00025:cljg_disp" };
  List<Br54_cxqq_mx> list =  busiDao.selectList(namespace +"selectBr54_cxqq_mxByVo",br54_cxqq_mx);  
  //或在DAO查询中直接转换  
  list = codeService.transListOfBean(list, cdColumns);
  return list;  
} 
  

/** 
 *根据主键查询单条记录 
 * @param ah * @return */ 
public Br54_cxqq_mx getBr54_cxqq_mxDisp(String bdhm) throws SQLException{ 
String[] cdColumns = new String[] { "zzlx:DwhZjlx:zzlx_disp"}; 
  
Br54_cxqq_mx br54_cxqq_mx = busiDao.selectOne(namespace +"selectBr54_cxqq_mxByID",bdhm,cdColumns);  
if(br54_cxqq_mx==null ) br54_cxqq_mx = new Br54_cxqq_mx(); 
return br54_cxqq_mx;  
} 
  
}
