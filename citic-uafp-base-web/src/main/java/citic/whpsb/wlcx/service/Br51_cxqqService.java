package citic.whpsb.wlcx.service; 
  
/**
* <p>Br51_cxqqService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.whpsb.wlcx.domain.Br51_attach;
import citic.whpsb.wlcx.domain.Br51_cxqq;
  
@Service  
public class Br51_cxqqService extends BaseService {
  
	/**
	 * 
	 */
private static final long serialVersionUID = 5962956142395230260L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.whpsb.mapper.busi.Br51_cxqqMapper."; 

/** 
 * 列表查询，查询文书证件信息  
 * @param br51_cxqq * @return  
 */ 
public List<Br51_attach> getBr51_cxqqAttachList(Br51_attach br51_attach) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] {"status:G00022:status_disp" }; 

   List<Br51_attach> list =  busiDao.selectList(namespace +"selectBr51_attchByVo",br51_attach);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);

return list;  
}


/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq * @return  
 */ 
public List<Br51_cxqq> getBr51_cxqqList(Br51_cxqq br51_cxqq) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "party_class_cd:G00023:party_class_cd_disp","qrymode:G00024:qrymode_disp","orgkey:Dorgan:orgkey_disp","status:G00022:status_disp"  }; 
  
if(!"".equals(br51_cxqq.getCzsj_start())){
	br51_cxqq.setCzsj_start(br51_cxqq.getCzsj_start()+" 00:00:00"); 
  }
if(!"".equals(br51_cxqq.getCzsj_end())){
	br51_cxqq.setCzsj_end(br51_cxqq.getCzsj_end()+" 23:59:59");
}
        List<Br51_cxqq> list =  busiDao.selectList(namespace +"selectBr51_cxqqByVo",br51_cxqq);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
}
  
/** 
 * 插入单条记录 
 * @param br51_cxqq * @return */ 
public int insertBr51_cxqq (Br51_cxqq br51_cxqq) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr51_cxqq",br51_cxqq);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br51_cxqq * @return */ 
public int modifyBr51_cxqq (Br51_cxqq br51_cxqq) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr51_cxqq",br51_cxqq);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param msgseq * @return */ 
public int deleteBr51_cxqq (String msgseq) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr51_cxqqByID",msgseq);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param msgseq * @return */ 
public Br51_cxqq getBr51_cxqqDisp(String msgseq) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br51_cxqq br51_cxqq = busiDao.selectOne(namespace +"selectBr51_cxqqByID",msgseq,cdColumns);  
if(br51_cxqq==null ) br51_cxqq = new Br51_cxqq(); 
return br51_cxqq;  
} 
  
}
