/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-06-06] 
* =============================================
*/

package citic.gajy.wlkz.service; 
  
/**
* <p>Br40_cxqq_hzws_mService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException; 
import java.util.HashMap;
import java.util.List; 

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service;  

import citic.base.BaseService;  
import citic.base.annotations.MngTx;  
import citic.fyck.wlkz.domain.Br31_ws;
import citic.gajy.wlcx.domain.Br40_cxqq_hzws_m; 
  
@Service  
public class Br41_kzqq_hzws_mService extends BaseService {
  
/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlcx.mapper.busi.Br40_cxqq_hzws_mMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br40_cxqq_hzws_m * @return  
 */ 
public List<Br40_cxqq_hzws_m> getBr40_cxqq_hzws_mList(Br40_cxqq_hzws_m br40_cxqq_hzws_m) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
        List<Br40_cxqq_hzws_m> list =  busiDao.selectList(namespace +"selectBr40_cxqq_hzws_mByVo",br40_cxqq_hzws_m);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br40_cxqq_hzws_m * @return */ 
public int insertBr40_cxqq_hzws_m (Br40_cxqq_hzws_m br40_cxqq_hzws_m) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr40_cxqq_hzws_m",br40_cxqq_hzws_m);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br40_cxqq_hzws_m * @return */ 
public int modifyBr40_cxqq_hzws_m (Br40_cxqq_hzws_m br40_cxqq_hzws_m) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr40_cxqq_hzws_m",br40_cxqq_hzws_m);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param wskey * @return */ 
public int deleteBr40_cxqq_hzws_m (String wskey) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr40_cxqq_hzws_mByID",wskey);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param wskey * @return */ 
public Br40_cxqq_hzws_m getBr40_cxqq_hzws_mDisp(String wskey) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br40_cxqq_hzws_m br40_cxqq_hzws_m = busiDao.selectOne(namespace +"selectBr40_cxqq_hzws_mByID",wskey,cdColumns);  
if(br40_cxqq_hzws_m==null ) br40_cxqq_hzws_m = new Br40_cxqq_hzws_m(); 
return br40_cxqq_hzws_m;  
} 


//查询关联通知文书下拉框
	public HashMap<String, String> getBr31_ws(String bdhm) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		List<Br31_ws> list = busiDao.selectList(namespace + "selectBr31_wsByBdhm", bdhm);
		map.put("", "——请选择——");
		for (Br31_ws br31_ws : list) {
			String wjmc = br31_ws.getWjmc();
			String xh = br31_ws.getXh();
			map.put(bdhm + xh, wjmc);
		}
		return map;
	}
  
}
