/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-06-06] 
* =============================================
*/

package citic.gajy.wlkz.service; 
  
/**
* <p>Br41_kzqq_hzwsService.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.sql.SQLException; 
import java.util.List; 

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Service;  

import citic.aml.base.AmlBaseService;
import citic.base.BaseService;  
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.fyck.wlkz.domain.Br31_kzqq_hzws;
import citic.fyck.wlkz.domain.Br31_kzqq_hzws_m;
import citic.gajy.wlkz.domain.Br41_kzqq_hzws; 
import citic.gajy.wlkz.domain.Br41_kzqq_hzws_m;
  
@Service  
public class Br41_kzqq_hzwsService extends AmlBaseService {
  
/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlkz.mapper.busi.Br41_kzqq_hzwsMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br41_kzqq_hzws * @return  
 */ 
public List<Br41_kzqq_hzws> getBr41_kzqq_hzwsList(Br41_kzqq_hzws br41_kzqq_hzws) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
        List<Br41_kzqq_hzws> list =  busiDao.selectList(namespace +"selectBr41_kzqq_hzwsByVo",br41_kzqq_hzws);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br41_kzqq_hzws * @return */ 
public int insertBr41_kzqq_hzws (Br41_kzqq_hzws br41_kzqq_hzws) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr41_kzqq_hzws",br41_kzqq_hzws);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br41_kzqq_hzws * @return */ 
public int modifyBr41_kzqq_hzws (Br41_kzqq_hzws br41_kzqq_hzws) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr41_kzqq_hzws",br41_kzqq_hzws);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param wskey * @return */ 
public int deleteBr41_kzqq_hzws (String wskey) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr41_kzqq_hzwsByID",wskey);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param wskey * @return */ 
public Br41_kzqq_hzws getBr41_kzqq_hzwsDisp(Br41_kzqq_hzws br41_kzqq_hzws) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br41_kzqq_hzws kzqq_hzws = busiDao.selectOne(namespace +"selectBr41_kzqq_hzwsByID",br41_kzqq_hzws,cdColumns);  
if(kzqq_hzws==null ) kzqq_hzws = new Br41_kzqq_hzws(); 
return kzqq_hzws;  
} 
  
// 查询回执文书内容
public Br41_kzqq_hzws getBr41_kzqq_hzws_m(Br41_kzqq_hzws br41_kzqq_hzws) throws Exception {

	String str = "";
	List<Br41_kzqq_hzws_m> list = busiDao.selectList(namespace + "selectBr41_kzqq_hzws_mById", br41_kzqq_hzws);
	for (Br41_kzqq_hzws_m br41_kzqq_hzws_m : list) {
		String sqlStr = br41_kzqq_hzws_m.getSqlstr();
		str = str + sqlStr;
	}
	br41_kzqq_hzws.setSqlstr(str);
	return br41_kzqq_hzws;
}

public String ReplaceHtmlStr(String str) {
	for (int i = 1; i < 6; i++) {
		str = this.strReplace(str, "h" + i);
	}
	return str;
}
public String strReplace(String s, String str) {
	if (s == null || s.length() == 0)
		return s;

	String replacestr = "<" + str + " align=";
	String sql = s;
	while (sql.indexOf(replacestr, 0) != -1) {
		int index = sql.indexOf(replacestr, 0);
		String bf1 = sql.substring(0, index);
		int strlength = replacestr.length();
		String bf2 = sql.substring(index + strlength);
		int index1 = 0;
		if (bf2.indexOf(">", 0) != -1) {
			index1 = bf2.indexOf(">", 0);
		}
		String classStr = bf2.substring(0, index1 + 1);
		int index2 = 0;
		if (bf2.indexOf("</" + str + ">", 0) != -1) {
			index2 = bf2.indexOf("</" + str + ">", 0);
		}
		String rnStr = bf2.substring(index1 + 1, index2);
		int endlength = index + strlength + classStr.length() + rnStr.length() + 5;
		sql = bf1 + "<div align=" + classStr + "<" + str + ">" + rnStr + "</" + str + "></div>" + sql.substring(endlength);
	}

	return sql;
}

public void dealSql(Br41_kzqq_hzws br41_kzqq_hzws, String sqlstr) throws Exception {

	String wskey = br41_kzqq_hzws.getWskey();
	//String xh = br31_kzqq_hzws.getXh();
	// sqlstr=SqlStrUtils.clearSql(sqlstr);
	// 删除文书id下的sql
	busiDao.delete(namespace + "deleteBr41_kzqq_hzws_m", br41_kzqq_hzws);

	Br41_kzqq_hzws_m br41_kzqq_hzws_m = new Br41_kzqq_hzws_m();
	br41_kzqq_hzws_m.setWskey(wskey);
	br41_kzqq_hzws_m.setWjnrseq(1);
	br41_kzqq_hzws_m.setQrydt(DtUtils.getNowDate());
	// 对于长度超过800的sql，进行分割
	String[] tmp_event_sql = StrUtils.Split(sqlstr, 800);
	for (int i = 0; i < tmp_event_sql.length; i++) {
		br41_kzqq_hzws_m.setSqlseq(i + 1);
		br41_kzqq_hzws_m.setSqlstr(tmp_event_sql[i]);
		busiDao.insert(namespace + "insertBr41_kzqq_hzws_m", br41_kzqq_hzws_m);
	}

}

public int updateBr41_kzqq_hzws(Br41_kzqq_hzws br41_kzqq_hzws) throws Exception {
	br41_kzqq_hzws.setWjlx("pdf");
	br41_kzqq_hzws.setDjrq(DtUtils.getNowTime());
	String root = codeService.getCodeValue("Dpara", "1");
	String outputPath = "/gajy/hzws";
	String wjmc =br41_kzqq_hzws.getQqdbs()+br41_kzqq_hzws.getWslx()+ ".pdf";
	br41_kzqq_hzws.setWjlx("pdf");
	// 生成pdf
	if (br41_kzqq_hzws.getFlag().equals("1")) {
		String wjpath = outputPath + "/" + wjmc;
		String htmlStr = br41_kzqq_hzws.getHtmlstr();
		htmlStr = this.ReplaceHtmlStr(htmlStr); // 特殊处理字符串
		commonService.exportPdfFile(htmlStr, root + outputPath, wjmc);
		br41_kzqq_hzws.setWjpath(wjpath);
	}

	int i = busiDao.update(namespace + "updateBr41_kzqq_hzws_disp", br41_kzqq_hzws);
	// 插入明细sql
	this.dealSql(br41_kzqq_hzws, br41_kzqq_hzws.getHtmlstr());

	return i;
}


}
