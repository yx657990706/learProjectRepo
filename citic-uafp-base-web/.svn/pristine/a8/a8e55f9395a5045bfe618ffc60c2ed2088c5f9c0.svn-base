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
<title></title>
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
			<div class="row">
				<div class="col-xs-12">

					<div class=" widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<div class="agg_GridDetail">
									<table>
										<tr>
											<td width="25%">任务流水号：</td>
											<td width="25%">${br40_cxqq_back.rwlsh }</td>
											<td width="25%">反馈手机号码：</td>
											<td width="25%">${br40_cxqq_back.fksjhm }</td>
										</tr>
										<tr>
											<td width="25%">账号：</td>
											<td width="25%">${br40_cxqq_back.zh }</td>
											<td width="25%">卡号：</td>
											<td width="25%">${br40_cxqq_back.kh}</td>
										</tr>
										<tr>
											<td width="25%">执行起始时间：</td>
											<td width="25%">${br40_cxqq_back.zxqssj }</td>
											<td width="25%">执行结束时间：</td>
											<td width="25%">${br40_cxqq_back.jssj }</td>
										</tr>
										<tr>
											<td width="25%">执行时间区间：</td>
											<td width="25%">${br40_cxqq_back.mxsdlx_disp}</td>
											<td width="25%">执行结果：</td>
											<td width="25%">${br40_cxqq_back.cxfkjg_disp}</td>
										</tr>
										<tr>
											<td width="25%">失败原因：</td>
											<td colspan="3">${br40_cxqq_back.czsbyy}</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
</body>
</html>
