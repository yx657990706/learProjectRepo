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
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal" commandName="br50_cxqq_mx"
					action="account_tran" method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询账户交易流水
							</h5>
							<div class="widget-toolbar">

								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">协作编号：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:input label="协作编号：" type="text" class="input-large"
													path="docno" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">案件编号：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:input label="案件名称：" type="text" class="input-large"
													path="caseno" />
											</div>
										</div>
											<%-- <div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">户名：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input label="户名：" type="text" class="input-large"
													path="accname" />
											</div>
										</div> --%>

									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询反馈结果：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:select label="反馈结果：" class="input-medium" path="cxfkjg"
													items="${cxfkjgMap}" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">状态:</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:select label="状态：" class="input-medium" path="status" items="${statusMap }"   />
											</div>
										</div>


									</div>
								</div>


								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>

											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input class="form-control date-picker"
													path="qrydt_start" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="qrydt_end"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>

											</div>

										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>

											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:input label="账号：" type="text" path="account"
													class="input-large" />
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('account_tran?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>

											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.widget-main -->
						</div>
						<!-- /.widget-body -->
					</div>
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover">
									<thead class="thin-border-bottom">
										<tr>
											<th>唯一标识</th>
											<th>案件编号</th>
											<th>协作编号</th>
											<th>案件名称</th>
											<th>侦办单位名称</th>
											<th>账号</th>
											<!-- <th>账户类型</th> -->
											<th>户名</th>
											<th>类型</th>
											<th>查询反馈结果</th>
											<th>状态</th>
											<th>证件类型</th>
											<th>证件号码</th>
											<th>交易开始日期</th>
											<th>交易结束日期</th>
											<th>查询日期</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="transList" items="${br50_cxqq_mxList}">
											<tr class="text-center">

												<td nowrap="nowrap"><a href="#"
													onclick="_submit('<c:url value="/br50_cxqq/account_tran_back?isNewSearch=1&docno=${transList.docno}&caseno=${transList.caseno}&uniqueid=${transList.uniqueid }" />')">${transList.uniqueid}</a></td>
												<td nowrap="nowrap">${transList.caseno}</td>
												<td nowrap="nowrap">${transList.docno}</td>
												<td nowrap="nowrap">${transList.casename}</td>
												<td nowrap="nowrap">${transList.exeunit}</td>
												<td nowrap="nowrap">${transList.account}</td>
												<%--<td nowrap="nowrap"> ${transList.acctype} </td> --%>
												<td nowrap="nowrap">${transList.accname}</td>
												<td nowrap="nowrap">${transList.type_disp}</td>
												<td nowrap="nowrap">
												 <c:if test="${transList.cxfkjg=='01'}">
							                    <span class="label label-success arrowed-in arrowed-in-right">	${transList.cxfkjg_disp}</span>
							                    </c:if>
							                    <c:if test="${transList.cxfkjg=='02'}">
							                  <span class="label label-danger arrowed-in arrowed-in-right">${transList.cxfkjg_disp}</span>
							                    </c:if>
												</td>
												<td nowrap="nowrap">${transList.status_disp}</td>
												<td nowrap="nowrap">${transList.idtype_disp}</td>
												<td nowrap="nowrap">${transList.id}</td>
												<td nowrap="nowrap">${transList.startdate}</td>
												<td nowrap="nowrap">${transList.enddate}</td>
												<td nowrap="nowrap">${transList.qrydt}</td>

											</tr>

										</c:forEach>

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

	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>

</body>
</html>