/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-24] 
* =============================================
*/

package citic.gajy.wlcx.service; 
  
/**
* <p>Br40_city_noService.java</p>
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
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_city_no;
  
@Service  
public class Br40_city_noService extends AmlBaseService {
  
/**
	 * 
	 */
private static final long serialVersionUID = -8191303866247042998L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlcx.mapper.busi.Br40_city_noMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br40_city_no * @return  
 */ 
public List<Br40_city_no> getBr40_city_noList(Br40_city_no br40_city_no) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "flag:S00002:flag_disp","other_organ:Dfhorgan:other_organ_disp" }; 
//处理日期 数据库中19位，页面传的是10位
if (!"".equals(br40_city_no.getLastts_start())) {// 申请时间起
	br40_city_no.setLastts_start(br40_city_no.getLastts_start() + " 00:00:00");
	}
if (!"".equals(br40_city_no.getLastts_end())) {// 申请时间止
	br40_city_no.setLastts_end(br40_city_no.getLastts_end() + " 23:59:59");
   }
  List<Br40_city_no> list =  busiDao.selectList(namespace +"selectBr40_city_noByVo",br40_city_no);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);
return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br40_city_no * @return */ 
@BusiTx
public int insertBr40_city_no (Br40_city_no br40_city_no,HttpServletRequest request) throws Exception{ 
//获取当前用户
String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
br40_city_no.setUniqueid("CSDH_"+this.getSequenceValus("SEQ_BRANK_RESPORT"));//主键从序列中获取
br40_city_no.setLastts(DtUtils.getNowTime());
br40_city_no.setLastuser(loginname);
br40_city_no.setFlag("1");
int i = busiDao.insert(namespace +"insertBr40_city_no",br40_city_no);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br40_city_no * @return */ 
public int modifyBr40_city_no (Br40_city_no br40_city_no) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr40_city_no",br40_city_no);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param uniqueid * @return */ 
public int deleteBr40_city_no (String uniqueid) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr40_city_noByID",uniqueid);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param uniqueid * @return */ 
public Br40_city_no getBr40_city_noDisp(String uniqueid) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br40_city_no br40_city_no = busiDao.selectOne(namespace +"selectBr40_city_noByID",uniqueid,cdColumns);  
if(br40_city_no==null ) br40_city_no = new Br40_city_no(); 
return br40_city_no;  
} 

/** 
 *根据主键查询单条记录 
 * @param uniqueid * @return */ 
public int getBr40_city_noCount(String uniqueid) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Integer count= busiDao.selectOne(namespace +"selectBr40_city_noCountById",uniqueid,cdColumns);  

return count.intValue();  
} 
  
}
