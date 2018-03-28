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
	String downloadname = "人脸识别黑名单统计_" + nowdate;
	downloadname = new String(downloadname.getBytes("gbk"), "ISO-8859-1").trim();
	response.setHeader("Content-disposition", "attachment; filename=" + downloadname + ".xls");
%>
<head>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 14">
<style>
<!--
table {
	mso-displayed-decimal-separator: "\.";
	mso-displayed-thousand-separator: "\,";
}

.font524743 {
	color: windowtext;
	font-size: 9.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
}

.xl6524743 {
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 18.0pt;
	font-weight: 700;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	mso-number-format: "\@";
	text-align: center;
	vertical-align: middle;
	border: .5pt solid windowtext;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}

.xl6624743 {
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 12.0pt;
	font-weight: 700;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	mso-number-format: "\@";
	text-align: center;
	vertical-align: middle;
	border: .5pt solid windowtext;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}

.xl6724743 {
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 11.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	mso-number-format: "\@";
	text-align: center;
	vertical-align: middle;
	border: .5pt solid windowtext;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}

.xl6824743 {
	padding-top: 1px;
	padding-right: 1px;
	padding-left: 1px;
	mso-ignore: padding;
	color: black;
	font-size: 11.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	mso-number-format: "\@";
	text-align: center;
	vertical-align: middle;
	mso-background-source: auto;
	mso-pattern: auto;
	white-space: nowrap;
}

ruby {
	ruby-align: left;
}

rt {
	color: windowtext;
	font-size: 9.0pt;
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	font-family: 宋体;
	mso-generic-font-family: auto;
	mso-font-charset: 134;
	mso-char-type: none;
}
-->
</style>
</head>
<body>
	<!--[if !excel]>　　<![endif]-->
	<!--下列信息由 Microsoft Excel 的发布为网页向导生成。-->
	<!--如果同一条目从 Excel 中重新发布，则所有位于 DIV 标记之间的信息均将被替换。-->
	<!----------------------------->
	<!--“从 EXCEL 发布网页”向导开始-->
	<!----------------------------->

	<div id="人脸识别黑名单统计_24743" align=center x:publishsource="Excel">

		<table border=0 cellpadding=0 cellspacing=0 width=2135
			style='border-collapse: collapse; table-layout: fixed; width: 1607pt'>
			<col class=xl6824743 width=93 style='width: 70pt'>
			<col class=xl6824743 width=164
				style='mso-width-source: userset; mso-width-alt: 5248; width: 123pt'>
			<col class=xl6824743 width=164
				style='mso-width-source: userset; mso-width-alt: 5248; width: 123pt'>
			<col class=xl6824743 width=164
				style='mso-width-source: userset; mso-width-alt: 5248; width: 123pt'>
			<col class=xl6824743 width=164
				style='mso-width-source: userset; mso-width-alt: 5248; width: 123pt'>
			<col class=xl6824743 width=74
				style='mso-width-source: userset; mso-width-alt: 2368; width: 56pt'>
			<col class=xl6824743 width=315
				style='mso-width-source: userset; mso-width-alt: 10080; width: 236pt'>
			<col class=xl6824743 width=123
				style='mso-width-source: userset; mso-width-alt: 3936; width: 92pt'>
			<col class=xl6824743 width=106 span=3
				style='mso-width-source: userset; mso-width-alt: 3392; width: 80pt'>
			<col class=xl6824743 width=106
				style='mso-width-source: userset; mso-width-alt: 3392; width: 80pt'>
			<col class=xl6824743 width=164
				style='mso-width-source: userset; mso-width-alt: 5248; width: 123pt'>
			<col class=xl6824743 width=74 span=3
				style='mso-width-source: userset; mso-width-alt: 2368; width: 60pt'>
			<col class=xl6824743 width=106
				style='mso-width-source: userset; mso-width-alt: 3392; width: 80pt'>
			<col class=xl6824743 width=106
				style='mso-width-source: userset; mso-width-alt: 3392; width: 80pt'>	
			<col class=xl6824743 width=123
				style='mso-width-source: userset; mso-width-alt: 3936; width: 92pt'>	
			<tr height=47 style='mso-height-source: userset; height: 35.25pt'>
				<td colspan=19 height=47 class=xl6524743 width=2135
					style='height: 35.25pt; width: 1607pt'>人脸识别名单信息</td>
			</tr>
			<tr height=26 style='mso-height-source: userset; height: 20.1pt'>
				<td height=26 class=xl6624743
					style='height: 20.1pt; border-top: none'>组号</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>被冒用人证件名称</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>被冒用人证件类型</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>被冒用人证件号码</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>被冒用人证件有效期</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>风险类型</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>业务办理网点</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>业务办理柜员号</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>业务办理时间</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>业务办理类型</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>业务办理渠道</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>联系电话</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>联系地址</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>名单建库渠道</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>审核人员</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>审核结果</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>出库操作人员</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>出库审核人员</td>
				<td class=xl6624743 style='border-top: none; border-left: none'>出库审核时间</td>
			</tr>
			<c:forEach items="${cgb_face_dataList}" var="checkList" varStatus="s">
				<tr height=21 style='mso-height-source: userset; height: 15.95pt'>
					<td height=21 class=xl6724743
						style='height: 15.95pt; border-top: none'>${checkList. group_id}</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.victim_name}</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.victim_card_type_disp}</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.victim_card_num}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.victim_card_validity}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.risk_type_disp}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.busi_website}-${checkList.busi_website_disp}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.busi_teller_num}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.busi_time}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.busi_type}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.busi_way_disp}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.telephone}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.address}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.md_channel_disp}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.check_user_id}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'><c:choose>
										      <c:when test="${checkList.rm_flag =='2'}">
										                 出库通过
										      </c:when>
										      <c:when test="${checkList.rm_flag =='3'}">
										                 出库未通过
										      </c:when>
										      <c:when test="${checkList.check_result =='3'}">
										                 未通过
										      </c:when>
										      <c:otherwise>
						   				                 通过
										      </c:otherwise>
										   </c:choose>
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.rm_user_id}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.rm_check_user_id}
					</td>
					<td class=xl6724743 style='border-top: none; border-left: none'>${checkList.rm_check_time}
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>


	<!----------------------------->
	<!--“从 EXCEL 发布网页”向导结束-->
	<!----------------------------->
</body>

</html>