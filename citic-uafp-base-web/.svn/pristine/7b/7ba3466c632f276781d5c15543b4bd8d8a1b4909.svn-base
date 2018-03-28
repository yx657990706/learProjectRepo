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
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="page-content">
		<fm:form class="form-horizontal" commandName="br40_cxqq_back_pz"
			id="myform" action="proof_modify_disp"
			method="POST">

			<!-- 隐藏区域 -->
			<fm:hidden path="tasktype" />
			<fm:hidden path="qqdbs" />
			<fm:hidden path="rwlsh" />
			<fm:hidden path="pztxlx" />
			<input type="hidden" id="d_file_name" name="d_file_name" />
			<input type="hidden" id="d_file_path" name="d_file_path" />
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="agg_GridDetail">
						<table>
							<tr>
								<td>任务流水号:</td>
								<td>${br40_cxqq_back_pz.rwlsh}</td>
								<td>账号：</td>
								<td>${br40_cxqq_back_pz.cxzh}</td>
							</tr>
							<tr>
								<td>卡号：</td>
								<td>${br40_cxqq_back_pz.cxkh}</td>
								<td>交易流水号：</td>
								<td>${br40_cxqq_back_pz.jylsh}</td>
							</tr>

							<tr>
								<td>卡凭证图像类型：</td>
								<td>${br40_cxqq_back_pz.pztxlx_disp}</td>
								<td>执行结果：</td>
								<td>${br40_cxqq_back_pz.status_disp}</td>
							</tr>
							<tr>
								<td>备注：</td>
								<td colspan="3">${br40_cxqq_back_pz.beiz}</td>
							</tr>
							<tr>
								<td>失败原因：</td>
								<td colspan="3">${br40_cxqq_back_pz.cxfkjgyy}</td>

							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group col-xs-12 col-sm-12">
						<label class="control-label col-xs-2 col-sm-2 no-padding-right">附件：</label>
						<div class="col-xs-10 col-sm-10 ">
							<div class="widget-box widget-color-blue agg_widgetbox">
								<div class="widget-body">
									<div class="widget-main no-padding">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>图像凭证名称</th>
													<th>上传路径</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody id="fujian1">
												<c:forEach items="${attachList}" var="law" varStatus="s">
													<tr>
														<td align="center"><c:out value="${law.filename}" /></td>
														<td align="center"><c:out value="${law.filepath}" /></td>
														<td align="center"><a href="#"
															onclick="_download('${law.filepath}','${law.filename}')">
																<span class="glyphicon glyphicon-download-alt red"></span>
														</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
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