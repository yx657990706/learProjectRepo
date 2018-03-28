package citic.shpsb.wlcx.service; 
  
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
import citic.shpsb.wlcx.domain.Br54_cxqq;
import citic.shpsb.wlcx.domain.Br54_cxqq_mx;
  
@Service  
public class Br54_cxqqService extends BaseService {
/**
	 * 
	 */
	private static final long serialVersionUID = 1273952729537396816L;

/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.shpsb.mapper.busi.Br54_cxqqMapper."; 

/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq 
 * @return  list
 */ 
public List<Br54_cxqq> getBr54_cxqqList(Br54_cxqq br54_cxqq) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "party_class_cd:G00037:party_class_cd_disp","qrymode:G00030:qrymode_disp","orgkey:Dorgan:orgkey_disp","status:G00036:status_disp",
     "yhdm:Dshyhdm:yhdm_disp"}; 
  List<Br54_cxqq> list =  busiDao.selectList(namespace +"selectBr54_cxqqByVo",br54_cxqq);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);
return list;  
}

/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br51_cxqq 
 * @return  list
 */ 
public List<Br54_cxqq_mx> getBr54_cxqq_mxList(Br54_cxqq_mx br54_cxqq_mx) throws SQLException{ 
// 定义转换码表 
	String[] cdColumns ={};
	if(br54_cxqq_mx.getQrymode().contains("dw")){
	 cdColumns = new String[] { "party_class_cd:G00023:party_class_cd_disp","qrymode:G00030:qrymode_disp","orgkey:Dorgan:orgkey_disp","zzlx:Dshqyzjlx:zzlx_disp",
        "tjlb:G00040:tjlb_disp"}; 
	}else{
		 cdColumns = new String[] { "party_class_cd:G00023:party_class_cd_disp","qrymode:G00030:qrymode_disp","orgkey:Dorgan:orgkey_disp","zzlx:Dshgrzjlx:zzlx_disp",
        "tjlb:G00040:tjlb_disp"}; 
	}

  List<Br54_cxqq_mx> list =  busiDao.selectList(namespace +"selectBr54_cxqq_mxByVo",br54_cxqq_mx);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);
return list;  
}
 
/** 
 *根据主键查询单条记录 
 * @param msgseq * @return */ 
public Br54_cxqq_mx getBr54_cxqq_mxDisp(String msgseq,String qrymode) throws SQLException{ 
// 定义转换码表 
	String[] cdColumns = new String[] {};  
	if(qrymode.contains("dw")){
		 cdColumns = new String[] { "tjlb:G00040:tjlb_disp","zzlx:Dshqyzjlx:zzlx_disp" };  
	}else{
		 cdColumns = new String[] { "tjlb:G00040:tjlb_disp","zzlx:Dshgrzjlx:zzlx_disp" };  
	}

Br54_cxqq_mx br54_cxqq_mx = busiDao.selectOne(namespace +"selectBr54_cxqq_mxByID",msgseq,cdColumns);  
if(br54_cxqq_mx==null ) br54_cxqq_mx = new Br54_cxqq_mx(); 
return br54_cxqq_mx;  
} 
  
}
