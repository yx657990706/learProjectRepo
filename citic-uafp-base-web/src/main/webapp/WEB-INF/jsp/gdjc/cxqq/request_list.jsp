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
<link
	href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div  class="page-content" id="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal" commandName="br50_cxqq" action="list" method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								反馈信息查询
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
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:input label="协作编号：" class="input-large" path="docno" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">数据来源：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:select label="数据来源：" class="input-medium"
													path="datasource" items="${datasourceMap}" />
											</div>
										</div>
										
										</div>
									</div>
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">案件编号：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:input label="案件编号：" class="input-large" path="caseno" />
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">反馈状态：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:select label="反馈状态：" class="input-medium" path="status"
													items="${statusMap }" />
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
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
												class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('list?isNewSearch=1')">
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
										    <th>协作编号</th>
											<th>案件编号</th>
											<th>案件名称</th>
											<th>数据来源</th>
											<th>反馈状态</th>
											<th>查询日期</th>
											<th>侦办单位名称</th>
											<th>归属机构</th>
											<th>接收人</th>
											<th>接收时间</th>
											<th>最后修改时间</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqqList" items="${br50_cxqqList}">
											<tr class="text-center">

												<td nowrap="nowrap">
												<a href="#"
													onclick="_submit('<c:url value="/br50_cxqq_mx/list?isNewSearch=1&docnos=${cxqqList.docno}&casenos=${cxqqList.caseno}" />')">${cxqqList.docno}</a>
												</td>
												<td nowrap="nowrap">${cxqqList.caseno}</td>
												<td nowrap="nowrap">${cxqqList.casename}</td>
												<td nowrap="nowrap">${cxqqList.datasource_disp}</td>
												
												<td nowrap="nowrap">
												<c:if test="${cxqqList.status=='0'}">
												<span class="label label-info arrowed-in arrowed-in-right">${cxqqList.status_disp}</span>
												</c:if>
												
												<c:if test="${cxqqList.status=='1'}">
												 <span class="label label-info arrowed-in arrowed-in-right">${cxqqList.status_disp}</span>
												</c:if>
												<c:if test="${cxqqList.status=='3'}">
												<span class="label label-success arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												<c:if test="${cxqqList.status=='4'}">
												 <span class="label label-danger arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												</td>
												<td nowrap="nowrap">${cxqqList.qrydt}</td>
												<td nowrap="nowrap">${cxqqList.exeunit}</td>
												<td nowrap="nowrap">${cxqqList.orgkey_disp}</td>
												<td nowrap="nowrap">${cxqqList.recipient_p}</td>
												<td nowrap="nowrap">${cxqqList.recipient_time}</td>
												<td nowrap="nowrap">${cxqqList.last_up_dt}</td>
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
	<script
		src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />"> </script>
	<!--树-->
</body>
</html>