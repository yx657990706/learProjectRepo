<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>反馈基本数据</title>
<jsp:include page="../../fragments/base_css.jsp"></jsp:include>
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content" id="page-content">
		<fm:form class="form-horizontal" commandName="br40_cxqq_back"
			action="save_data" method="POST" id="myform">
			<!-- 隐藏域 -->
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="agg_GridDetail">
						<table>
							<tr>
								<td>请求单标识：</td>
								<td>${br40_cxqq_back.qqdbs }</td>
								<td>任务流水号：</td>
								<td>${br40_cxqq_back.rwlsh}</td>
								
							</tr>
							<tr>
								<td>申请机构代码：</td>
								<td>${br40_cxqq_back.sqjgdm_disp }</td>
								<td>目标机构代码：</td>
								<td>${br40_cxqq_back.mbjgdm_disp }</td>
							</tr>
								<tr>
								<td>查询主体类别：</td>
								<td>${br40_cxqq_back.ztlb_disp }</td>
								<td>查询内容：</td>
								<td>${br40_cxqq_back.cxnr_disp }</td>
							</tr>
								<tr>
								<td>主体名称：</td>
								<td>${br40_cxqq_back.ztmc }</td>
								<td>证件号码：</td>
								<td> ${br40_cxqq_back.zzhm }</td>
							</tr>
							<tr>
								<td>查询开始时间：</td>
								<td>${br40_cxqq_back.mxqssj }</td>
								<td>查询结束时间：</td>
								<td>${br40_cxqq_back.mxjzsj }</td>
							</tr>
							<tr>
								<td>查询账号：</td>
								<td>${br40_cxqq_back.cxzh }</td>
								<td>证件类型：</td>
								<td>${br40_cxqq_back.zzlx_disp } </td>
							</tr>
							<tr>
							<td>卡号:</td>
								<td>${br40_cxqq_back.kh }</td>
								<td>核心反馈状态：</td>
								<td>${br40_cxqq_back.status_disp}</td>
							</tr>
							<tr>
	 							<td>核心反馈结果：</td>
								<td>
							    <c:if test="${br40_cxqq_back.cxfkjg=='0'}">成功</c:if>
								<c:if test="${br40_cxqq_back.cxfkjg=='01'}">成功</c:if>
								<c:if test="${br40_cxqq_back.cxfkjg=='1'}">失败</c:if>
								<c:if test="${br40_cxqq_back.cxfkjg=='02'}">失败</c:if>
								</td>
								<td>操作原因：</td>
								<td colspan="3">${br40_cxqq_back.czsbyy}</td>
							</tr>
							<c:if test="${br40_cxqq_back.tasktype=='8'}">
								<tr>
									<td>银行主机数据时间：</td>
									<td>${br40_cxqq_back.yhzjsjsj}</td>
									<td>是否修订：</td>
									<td>${br40_cxqq_back.sfxd_disp}</td>
								</tr>
							</c:if>
					
						</table>
					</div>
				</div>
			</div>
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
</body>
</html>
