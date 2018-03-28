/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-06-06] 
* =============================================
*/

package citic.gajy.wlcx.service; 
  
/**
* <p>Br40_cxqq_hzwsService.java</p>
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
import citic.gajy.wlcx.domain.Br40_cxqq_hzws; 
import citic.gajy.wlcx.domain.Br40_cxqq_hzws_m;
  
@Service  
public class Br40_cxqq_hzwsService extends AmlBaseService {
  
/** 日志记录器 */ 
private Logger logger = LoggerFactory.getLogger(this.getClass()); 
  
/** map命名空间 */ 
private String  namespace ="citic.gajy.wlcx.mapper.busi.Br40_cxqq_hzwsMapper."; 
/** 
 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中  
 * @param br40_cxqq_hzws * @return  
 */ 
public List<Br40_cxqq_hzws> getBr40_cxqq_hzwsList(Br40_cxqq_hzws br40_cxqq_hzws) throws SQLException{ 
// 定义转换码表 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
        List<Br40_cxqq_hzws> list =  busiDao.selectList(namespace +"selectBr40_cxqq_hzwsByVo",br40_cxqq_hzws);  
//或在DAO查询中直接转换  
list = codeService.transListOfBean(list, cdColumns);return list;  
} 
  
/** 
 * 插入单条记录 
 * @param br40_cxqq_hzws * @return */ 
public int insertBr40_cxqq_hzws (Br40_cxqq_hzws br40_cxqq_hzws) throws SQLException{ 
int i = busiDao.insert(namespace +"insertBr40_cxqq_hzws",br40_cxqq_hzws);  
return i; 
} 
  
/** 
 * 执行更新操作 
 * @param br40_cxqq_hzws * @return */ 
public int modifyBr40_cxqq_hzws (Br40_cxqq_hzws br40_cxqq_hzws) throws SQLException{ 
int i = busiDao.update(namespace +"updateBr40_cxqq_hzws",br40_cxqq_hzws);  
return i; 
} 
  
/** 
 * 根据主键删除 
 * @param wskey * @return */ 
public int deleteBr40_cxqq_hzws (String wskey) throws SQLException{ 
int i = busiDao.delete(namespace +"deleteBr40_cxqq_hzwsByID",wskey);  
return i; 
} 
  
/** 
 *根据主键查询单条记录 
 * @param wskey * @return */ 
public Br40_cxqq_hzws getBr40_cxqq_hzwsDisp(Br40_cxqq_hzws br40_cxqq_hzws) throws SQLException{ 
String[] cdColumns = new String[] { "flag:S00002:flag_disp" }; 
  
Br40_cxqq_hzws cxqq_hzws = busiDao.selectOne(namespace +"selectBr40_cxqq_hzwsByID",br40_cxqq_hzws,cdColumns);  
if(cxqq_hzws==null ) cxqq_hzws = new Br40_cxqq_hzws(); 
return cxqq_hzws;  
} 
  
// 查询回执文书内容
public Br40_cxqq_hzws getBr40_cxqq_hzws_m(Br40_cxqq_hzws br40_cxqq_hzws) throws Exception {

	String str = "";
	List<Br40_cxqq_hzws_m> list = busiDao.selectList(namespace + "selectBr40_kzqq_hzws_mById", br40_cxqq_hzws);
	for (Br40_cxqq_hzws_m br40_kzqq_hzws_m : list) {
		String sqlStr = br40_kzqq_hzws_m.getSqlstr();
		str = str + sqlStr;
	}
	br40_cxqq_hzws.setSqlstr(str);
	return br40_cxqq_hzws;
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

public void dealSql(Br40_cxqq_hzws br40_cxqq_hzws, String sqlstr) throws Exception {

	String wskey = br40_cxqq_hzws.getWskey();
	//String xh = br31_kzqq_hzws.getXh();
	// sqlstr=SqlStrUtils.clearSql(sqlstr);
	// 删除文书id下的sql
	busiDao.delete(namespace + "deleteBr40_cxqq_hzws_m", br40_cxqq_hzws);

	Br40_cxqq_hzws_m br40_cxqq_hzws_m = new Br40_cxqq_hzws_m();
	br40_cxqq_hzws_m.setWskey(wskey);
	br40_cxqq_hzws_m.setWjnrseq(1);
	br40_cxqq_hzws_m.setQrydt(DtUtils.getNowDate());
	// 对于长度超过800的sql，进行分割
	String[] tmp_event_sql = StrUtils.Split(sqlstr, 800);
	for (int i = 0; i < tmp_event_sql.length; i++) {
		br40_cxqq_hzws_m.setSqlseq(i + 1);
		br40_cxqq_hzws_m.setSqlstr(tmp_event_sql[i]);
		busiDao.insert(namespace + "insertBr40_cxqq_hzws_m", br40_cxqq_hzws_m);
	}

}

public int modifyBr40_kzqq_hzws(Br40_cxqq_hzws br40_cxqq_hzws) throws Exception {
	br40_cxqq_hzws.setWjlx("pdf");
	br40_cxqq_hzws.setDjrq(DtUtils.getNowTime());
	String root = codeService.getCodeValue("Dpara", "1");
	String outputPath = "/gajy/hzws";
	String wjmc =br40_cxqq_hzws.getQqdbs()+br40_cxqq_hzws.getWslx()+ ".pdf";
	br40_cxqq_hzws.setWjlx("pdf");
	// 生成pdf
	if (br40_cxqq_hzws.getFlag().equals("1")) {
		String wjpath = outputPath + "/" + wjmc;
		String htmlStr = br40_cxqq_hzws.getHtmlstr();
		htmlStr = this.ReplaceHtmlStr(htmlStr); // 特殊处理字符串
		commonService.exportPdfFile(htmlStr, root + outputPath, wjmc);
		br40_cxqq_hzws.setWjpath(wjpath);
	}

	int i = busiDao.update(namespace + "updateBr40_cxqq_hzws_disp", br40_cxqq_hzws);
	// 插入明细sql
	this.dealSql(br40_cxqq_hzws, br40_cxqq_hzws.getHtmlstr());

	return i;
}

public Br40_cxqq_hzws InsertStr(String kzcs, Br40_cxqq_hzws br31_kzqq_hzws, String djStr, String zdjStr) throws Exception {
	String fymc ="";
	int xh = 0;
	String headStr = "<h2 align=\"center\">" + fymc + " </h2>";
	headStr = headStr + "<h3 align=\"center\">协助冻结/解除冻结财产</h3>";
	headStr = headStr + "<h3 align=\"center\">（回执）</h3>";
	// headStr=headStr+"<h3>&nbsp;</h3>";
	headStr = headStr + "<h3  align=\"right\">" + fymc + "：</h3>";
	headStr = headStr + "<h4>&nbsp;&nbsp;你院（20X X ) X 法执X 字第X X号执行裁定书、（20X X )" + "法执X 字第X号协助执行通知书收悉，</h4><h4>我行处理结果如下：</h4><h4>";
	String enddt = DtUtils.getNowTime();
	String endStr = "</h4><h4 align=\"right\">" + enddt.substring(0, 4) + "年" + enddt.substring(5, 7) + "月" + enddt.substring(8, 10) + "日" + enddt.substring(11, 13) + "时"
			+ enddt.substring(14, 16) + "分 " + "</h4>";
	br31_kzqq_hzws.setWjmc(codeService.getCodeValue("B00002", kzcs) + "协助执行通知书");
	String insertStr = headStr;
	// 插入文书
	if (!djStr.equals("")) {
		insertStr = insertStr + djStr + endStr;
		xh = xh + 1;
//		br31_kzqq_hzws.setXh(xh + "");
//		br31_kzqq_hzws.setKzcs(kzcs);
//		br31_kzqq_hzws.setKzlx("1");
//		this.insertBr31_kzqq_hzws(br31_kzqq_hzws);
		this.dealSql(br31_kzqq_hzws, insertStr);
	}
	if (!zdjStr.equals("")) {
		insertStr = insertStr + zdjStr + endStr;
		xh = xh + 1;
//		br31_kzqq_hzws.setXh(xh + "");
//		br31_kzqq_hzws.setKzcs(kzcs);
//		br31_kzqq_hzws.setKzlx("1");
//		this.insertBr31_kzqq_hzws(br31_kzqq_hzws);
		this.dealSql(br31_kzqq_hzws, insertStr);
	}
	return br31_kzqq_hzws;
}

public void dealSql(Br31_kzqq_hzws br31_kzqq_hzws, String sqlstr) throws Exception {

	String bdhm = br31_kzqq_hzws.getBdhm();
	String xh = br31_kzqq_hzws.getXh();
	// sqlstr=SqlStrUtils.clearSql(sqlstr);
	// 删除文书id下的sql
	busiDao.delete(namespace + "deleteBr31_kzqq_hzws_m", br31_kzqq_hzws);

	Br31_kzqq_hzws_m br31_kzqq_hzws_m = new Br31_kzqq_hzws_m();
	br31_kzqq_hzws_m.setBdhm(bdhm);
	br31_kzqq_hzws_m.setXh(xh);
	br31_kzqq_hzws_m.setWjnrseq("1");

	// 对于长度超过800的sql，进行分割
	String[] tmp_event_sql = StrUtils.Split(sqlstr, 800);
	for (int i = 0; i < tmp_event_sql.length; i++) {
		br31_kzqq_hzws_m.setSqlseq(i + 1 + "");
		br31_kzqq_hzws_m.setSqlstr(tmp_event_sql[i]);
		busiDao.insert(namespace + "insertBr31_kzqq_hzws_m", br31_kzqq_hzws_m);
	}

}


}
