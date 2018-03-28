<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp" />
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal" commandName="br40_cxqq_mx"
					action="list" method="POST">
					<fm:hidden path="qqdbs" />
					<fm:hidden path="qqcslx" />
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover">
									<thead class="thin-border-bottom">
										<c:choose>
											<c:when test="${br40_cxqq_mx.tasktype=='4'}">
												<tr>
													<th>请求单标识</th>
													<th>任务流水号</th>
													<th>交易流水号</th>
													<th>凭证图像类型</th>
													<th>查询账号</th>
													<th>查询卡号</th>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<th>请求单标识</th>
													<th>任务流水号</th>
													<th>查询账卡号</th>
													<th>查询内容</th>
													<th>查询种类</th>
													<th>查询交易流水号</th>
												</tr>
											</c:otherwise>
										</c:choose>

									</thead>

									<tbody>
										<c:choose>
											<c:when test="${br40_cxqq_mx.tasktype=='3'}">
												<c:forEach var="cxqq_mxList" items="${br40_cxqq_mxList}">
													<tr class="text-center">
														<td nowrap="nowrap">${cxqq_mxList.qqdbs}</td>
														<td nowrap="nowrap">${cxqq_mxList.rwlsh}</td>
														<td nowrap="nowrap">${cxqq_mxList.jylsh}</td>
														<td nowrap="nowrap">${cxqq_mxList.pztxlx_disp}</td>
														<td nowrap="nowrap">${cxqq_mxList.cxzh}</td>
														<td nowrap="nowrap">${cxqq_mxList.cxkh}</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<c:forEach var="cxqq_mxList" items="${br40_cxqq_mxList}">
													<tr class="text-center">
														<td nowrap="nowrap">${cxqq_mxList.qqdbs}</td>
														<td nowrap="nowrap">${cxqq_mxList.rwlsh}</td>
														<td nowrap="nowrap">${cxqq_mxList.cxzh}</td>
														<td nowrap="nowrap">${cxqq_mxList.cxnr}</td>
														<td nowrap="nowrap">${cxqq_mxList.cxzl}</td>
														<td nowrap="nowrap">${cxqq_mxList.jylsh}</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
				</fm:form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>

	<jsp:include page="../../fragments/base_js.jsp" />

</body>
</html>