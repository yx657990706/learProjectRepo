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
	String downloadname = "电信诈骗业务统计_" + nowdate;
	downloadname= new String(downloadname.getBytes("gbk"),"ISO-8859-1").trim();
	response.setHeader("Content-disposition", "attachment; filename=" + downloadname + ".xls");
%>
<head>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 14">
<style>
table
mso-number-format:General;
text-align:general;
vertical-align:middle;
white-space:nowrap;
mso-rotate:0;
mso-background-source:auto;
mso-pattern:auto;
color:windowtext;
font-size:12.0pt;
font-weight:400;
font-style:normal;
text-decoration:none;
font-family:宋体;
mso-generic-font-family:auto;
mso-font-charset:134;
border:none;
mso-protection:locked visible;
mso-style-name:常规;
mso-style-id:0;
table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
.font56530
	{color:windowtext;
	font-size:9.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;}
.xl656530
	{padding-top:1px;
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
	mso-number-format:"\@";
	text-align:general;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl666530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:general;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl676530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl686530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl696530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:14.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl706530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:14.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl716530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:14.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl726530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl736530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl746530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl756530
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:12.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:宋体;
	mso-generic-font-family:auto;
	mso-font-charset:134;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
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
	mso-char-type:none;}
</style>
</head>
<body link=blue vlink=purple>
<table border=0 cellpadding=0 cellspacing=0 width=1188 style='border-collapse:
 collapse;table-layout:fixed;width:891pt'>
 <col class=xl656530 width=271 style='mso-width-source:userset;mso-width-alt:
 8672;width:203pt'>
 <col class=xl656530 width=131 style='mso-width-source:userset;mso-width-alt:
 4192;width:98pt'>
 <col class=xl656530 width=152 style='mso-width-source:userset;mso-width-alt:
 4864;width:114pt'>
 <col class=xl656530 width=189 style='mso-width-source:userset;mso-width-alt:
 6048;width:142pt'>
 <col class=xl656530 width=256 style='mso-width-source:userset;mso-width-alt:
 8192;width:192pt'>
 <col class=xl656530 width=189 style='mso-width-source:userset;mso-width-alt:
 6048;width:142pt'>
 <tr height=40 style='mso-height-source:userset;height:30.0pt'>
  <td colspan=5 height=40 class=xl696530 width=999 style='border-right:.5pt solid black;
  height:30.0pt;width:749pt'>电信诈骗业务统计</td>
  <td class=xl666530 width=189 style='width:142pt'></td>
 </tr>
 <tr class=xl656530 height=45 style='mso-height-source:userset;height:33.75pt'>
  <td height=45 class=xl676530 style='height:33.75pt'>所属分行</td>
  <td class=xl686530>业务种类</td>
  <td class=xl746530 width=152 style='border-left:none;width:114pt'>业务笔数<br/>
    （单位：笔）</td>
  <td class=xl746530 width=189 style='border-left:none;width:142pt'>账户数量<br/>
    （单位：个）</td>
  <td class=xl746530 width=256 style='border-left:none;width:192pt'>金额<br/>
    （单位：元）</td>
 </tr>
 <c:forEach items="${dx_trade_countList}" var="countList" varStatus="s">
  <tr class=xl656530 height=21 style='mso-height-source:userset;height:15.95pt'>
  <td height=21 class=xl726530 style='height:15.95pt;border-top:none'>${countList.city_disp}</td>
  <td class=xl726530 style='border-top:none;border-left:none'>${countList.business_kind}</td>
  <td class=xl726530 style='border-top:none;border-left:none'>${countList.business_num}</td>
  <td class=xl726530 style='border-top:none;border-left:none'>${countList.accountnumber}</td>
  <td class=xl736530 style='border-top:none;border-left:none'>${countList.money}</td>
 </tr>
  </c:forEach>
</table>
</body>
</html>