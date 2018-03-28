<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
	xmlns:x="urn:schemas-microsoft-com:office:excel"
	xmlns="http://www.w3.org/TR/REC-html40">
<%
	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	String nowdate = formater.format(new java.util.Date());
	String downloadname = "电信诈骗风险事件" + nowdate;
	downloadname= new String(downloadname.getBytes("gbk"),"ISO-8859-1").trim();
	response.setHeader("Content-disposition", "attachment; filename=" + downloadname + ".xls");
%>
<head>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 14">
<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:.75in .7in .75in .7in;
	mso-header-margin:.3in;
	mso-footer-margin:.3in;}
	
	tr
	{mso-height-source:auto;
	mso-ruby-visibility:none;}
col
	{mso-width-source:auto;
	mso-ruby-visibility:none;}
br
	{mso-data-placement:same-cell;}
ruby
	{ruby-align:left;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:black;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	border:none;
	mso-protection:locked visible;
	mso-style-name:常规;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl65
	{mso-style-parent:style0;
	color:#393939;
	font-size:10.0pt;
	font-weight:700;
	font-family:微软雅黑, sans-serif;
	mso-font-charset:134;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:white;
	mso-pattern:black none;
	white-space:normal;}
.xl66
	{mso-style-parent:style0;
	font-size:12.0pt;
	font-weight:700;
	font-family:微软雅黑, sans-serif;
	mso-font-charset:134;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
.xl67
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
.xl68
	{mso-style-parent:style0;
	mso-number-format:"\@";
	vertical-align:middle;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl69
	{mso-style-parent:style0;
	border-top:.5pt solid windowtext;
	border-right:none;
	border-bottom:none;
	border-left:none;}
.xl70
	{mso-style-parent:style0;
	border-top:.5pt solid windowtext;
	border-right:none;
	border-bottom:none;
	border-left:none;
	white-space:normal;}
.xl71
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	white-space:normal;}
	
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-char-type:none;
	display:none;}
-->
</style>
</head>
<body link=blue vlink=purple>
<table border=0 cellpadding=0 cellspacing=0 width=1190 style='border-collapse:
 collapse;table-layout:fixed;width:895pt'>
 <col width=85 style='mso-width-source:userset;mso-width-alt:2720;width:64pt'>
 <col width=102 style='mso-width-source:userset;mso-width-alt:3264;width:77pt'>
 <col width=85 span=2 style='mso-width-source:userset;mso-width-alt:2720;
 width:64pt'>
 <col width=83 style='mso-width-source:userset;mso-width-alt:2656;width:62pt'>
 <col width=72 style='width:54pt'>
 <col width=97 style='mso-width-source:userset;mso-width-alt:3104;width:73pt'>
 <col width=98 style='mso-width-source:userset;mso-width-alt:3136;width:74pt'>
 <col width=178 style='mso-width-source:userset;mso-width-alt:5696;width:134pt'>
 <col width=103 style='mso-width-source:userset;mso-width-alt:3296;width:77pt'>
 <col width=86 style='mso-width-source:userset;mso-width-alt:2752;width:65pt'>
 <col width=116 style='mso-width-source:userset;mso-width-alt:3712;width:87pt'>
 <tr height=45 style='mso-height-source:userset;height:33.75pt'>
  <td colspan=12 height=45 class=xl66 width=1190 style='height:33.75pt;
  width:895pt'>电信诈骗风险事件填报表</td>
 </tr>
 <tr height=36 style='mso-height-source:userset;height:27.0pt'>
  <td height=36 class=xl65 width=85 style='height:27.0pt;border-top:none;
  width:64pt'>
  <form id="cgb_risk_case" class=form-horizontal method=POST action=list>
  机构名称</td>
  <td class=xl65 width=102 style='border-top:none;border-left:none;width:77pt'>部门/支行</td>
  <td class=xl65 width=85 style='border-top:none;border-left:none;width:64pt'>涉案账户名</td>
  <td class=xl65 width=85 style='border-top:none;border-left:none;width:64pt'>涉案账户</td>
  <td class=xl65 width=83 style='border-top:none;border-left:none;width:62pt'>证照号码</td>
  <td class=xl65 width=72 style='border-top:none;border-left:none;width:54pt'>涉案金额</td>
  <td class=xl65 width=97 style='border-top:none;border-left:none;width:73pt'>诈骗信息来源</td>
  <td class=xl65 width=98 style='border-top:none;border-left:none;width:74pt'>事件发生日期</td>
  <td class=xl65 width=178 style='border-top:none;border-left:none;width:134pt'>事件简述</td>
  <td class=xl65 width=103 style='border-top:none;border-left:none;width:77pt'>信息来源渠道</td>
  <td class=xl65 width=86 style='border-top:none;border-left:none;width:65pt'>是否已报案</td>
  <td class=xl65 width=116 style='border-top:none;border-left:none;width:87pt'>受理报案机关
  </form>
  </td>
 </tr>
 <c:forEach items="${cgb_risk_caseList}" var="cases" varStatus="s">
 <tr height=27 style='mso-height-source:userset;height:auto'>
  <td height=27 class=xl68 width=85 style='height:auto;border-top:none;
  width:64pt'>${cases.organkey_disp}</td>
  <td class=xl68 width=102 style='border-top:none;border-left:none;width:77pt'>${cases.suborgankey_disp}</td>
  <td class=xl71 width=85 style='border-top:none;border-left:none;width:64pt'>${cases.accountname}</td>
  <td class=xl68 width=85 style='border-top:none;border-left:none;width:64pt'>${cases.account}</td>
  <td class=xl68 width=83 style='border-top:none;border-left:none;width:62pt'>${cases.cardnumber}</td>
  <td class=xl68 width=72 style='border-top:none;border-left:none;width:54pt'>${cases.je}</td>
  <td class=xl68 width=97 style='border-top:none;border-left:none;width:73pt'>${cases.infosource_disp}</td>
  <td class=xl68 width=98 style='border-top:none;border-left:none;width:74pt'>${cases.happendate}</td>
  <td class=xl68 width=178 style='border-top:none;border-left:none;width:134pt'>${cases.casedesc}</td>
  <td class=xl68 width=103 style='border-top:none;border-left:none;width:77pt'>${cases.channeldesc}</td>
  <td class=xl71 width=86 style='border-top:none;border-left:none;width:65pt'>${cases.isreport_disp}</td>
  <td class=xl68 width=116 style='border-top:none;border-left:none;width:87pt'>${cases.dealorgan}</td>
 </tr>
  </c:forEach>
 <tr height=198 style='mso-height-source:userset;height:148.5pt'>
  <td colspan=12 height=198 class=xl70 width=1190 style='height:148.5pt;
  width:895pt'>填写说明：<br>
    1、涉案户名、涉案账户：有权机关、监管单位提供的，或受害人报案和业务部门通过其他渠道获得的涉嫌电信诈骗的账户和姓名。<br>
    2、诈骗信息来源：包括但不限于诈骗电话、诈骗短信、虚假网站网址或QQ号、微信号等等。<br>
   
  3、事件简述：***年***月***日，在****地方，因被害人收到（QQ信息、短信、钓鱼网站链接等）导致受害人通过****（ATM、柜面、网银或其他渠道）业务被电信诈骗，涉案金额****元。<br>
    4、信息来源渠道：公安机关、人民银行、银监局（请具体到当地）、网点报案或其他渠道。<br>
    5、受理报案机关：填写受理客户案件的当地公安机关名称，没有则填无。<br>
    <br>
    <span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp; </span>填报人：<span
  style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>审批人员（部门领导/支行负责人）：<span
  style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span>保卫部：<br>
    </td>
 </tr>
</table>
</body>
</html>