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
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css'/>"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br40_cxqq_back_acct_qzcs" action="deal_qzcs_info" method="POST">
					    <fm:input  type="hidden" path="qqdbs" class="input-large" />
						<fm:input  type="hidden" path="rwlsh" class="input-large" /> 
						<fm:input  type="hidden" path="tasktype" class="input-large" /> 
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								强制措施信息
							</h5>
						</div> 
						</div>
						<div class="widget-box widget-color-blue agg_widgetbox">
							<div class="widget-body">
								<div class="widget-infolist no-padding">
									<table class="table table-striped table-bordered table-hover">
										<thead class="thin-border-bottom">
											<tr>
    								<!-- <th>操作</th> -->
    								<th>请求单流水号</th>
                                    <th>任务流水号</th>
                                    <th>账号</th>
                                    <th>措施序号</th>
                                    <th>冻结开始日</th>
                                    <th>冻结截止日</th>
                                    <th>冻结机关名称</th>
                                    <th>冻结金额</th>
                                    <th>备注</th>
                                    <th>冻结措施类型</th>
								</tr>
										</thead>
										<tbody>
											<c:forEach var="infolist" items="${br40_cxqq_back_acct_qzcsList}">
												<tr class="text-center">
                                                    <td nowrap="nowrap">${infolist.qqdbs }</td>
                                                    <td nowrap="nowrap">${infolist.rwlsh }</td>
                                                    <td nowrap="nowrap">${infolist.zh}</td>
                                                    <td nowrap="nowrap">${infolist.csxh  }</td>
                                                    <td nowrap="nowrap">${infolist.djksrq}</td>
                                                    <td nowrap="nowrap">${infolist.djjzrq}</td>
                                                    <td nowrap="nowrap">${infolist.djjgmc_disp}</td>
                                                    <td nowrap="nowrap">${infolist.djje  }</td>
                                                    <td nowrap="nowrap">${infolist.beiz  }</td>
                                                    <td nowrap="nowrap">${infolist.djcslx_disp}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
                        <!-- PAGE CONTENT BEGINS -->
						<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
					    <!-- PAGE CONTENT ENDS -->
				</fm:form>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<jsp:include page="../../fragments/base_js.jsp" />
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>