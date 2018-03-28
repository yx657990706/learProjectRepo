<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp"/>
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal"  commandName="br41_kzqq_dj_back_mx"  action="kzdj_fk_mx_list"  method="POST">
					<div class="widget-box">
					<fm:input type="hidden" path="tasktype"/>
					<fm:input type="hidden" path="qqdbs"/>
					<fm:input type="hidden" path="rwlsh"/>
						<div class="widget-header widget-header-flat">
							<!-- <h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								冻结明细信息
							</h5> -->
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
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										         <fm:input type="text" label="账号：" class="input-large" path="zh" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
											   
										    <div class="input-group  col-xs-12 col-sm-8  ">
										     <fm:select label="执行结果：" class="input-medium" path="zxjg" items="${zxjgMap }" />
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('kzdj_fk_mx_list?isNewSearch=1')">
															<i class="glyphicon glyphicon-search"></i>
															查询
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
								<table class="table table-striped table-bordered table-hover" >
									<thead class="thin-border-bottom">
										<tr>
											 <th>任务流水号</th>
											<th>账号</th>
											<th>账号子账号</th>
											<th>子账号序号</th>
											<th>子账号余额</th>
											<th>执行结果</th>
											<th>执行失败原因</th>
											<th>在先冻结机关</th>
											<th>在先冻结金额</th>
											<th>在先冻结到期日</th>
											<th>冻结金额</th>
										    <th>冻结开始时间</th>
											<th>未冻结金额</th>
											<th>冻结结束时间</th>
											<th>币种</th>
											<th>钞汇标志</th>
											
										</tr>
									</thead>

									<tbody>
										<c:forEach var="mxList"  items="${br41_kzqq_dj_back_mxList}" >
											<tr class="text-center">
												<td nowrap="nowrap">${mxList.rwlsh}</td>
												<td nowrap="nowrap">${mxList.zh}</td>
												<td nowrap="nowrap">${mxList.zhzzh}</td>
												<td nowrap="nowrap">${mxList.zzhxh}</td>
												<td nowrap="nowrap">${mxList.zzhye}</td>
												<td nowrap="nowrap">${mxList.zxjg_disp}</td>
												<td nowrap="nowrap">${mxList.zxjgyy}</td>
												<td nowrap="nowrap">${mxList.djjg}</td>
												<td nowrap="nowrap">${mxList.zxdjje}</td>
												<td nowrap="nowrap">${mxList.djjzrq}</td>
												<td nowrap="nowrap">${mxList.djje}</td>
												<td nowrap="nowrap">${mxList.djkssj}</td>
												<td nowrap="nowrap">${mxList.wdjje}</td>
												<td nowrap="nowrap">${mxList.djjssj}</td>
												<td nowrap="nowrap">${mxList.bz_disp}</td>
												<td nowrap="nowrap">${mxList.chbz}</td>
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
<jsp:include page="../../fragments/base_js.jsp"/>
<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>