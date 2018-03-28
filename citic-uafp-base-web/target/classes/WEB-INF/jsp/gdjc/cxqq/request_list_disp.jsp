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

				<fm:form class="form-horizontal" commandName="br50_cxqq_mx" action="list" method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询请求信息
							</h5>
							<div class="widget-toolbar">
								 <a href='<c:url value="/br50_cxqq/list"/>'>
						                <i class="ace-icon fa fa fa-arrow-circle-left green"></i>
						                返回
						            </a>&nbsp;
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">唯一标识：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input type="text" label="唯一标识：" class="input-large" path="uniqueid" />
											</div>
										</div>
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
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">账(卡)号：</label>
											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:input type="text" label="账卡号：" class="input-large" path="account"/>
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">类型：</label>

											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:select label="类型：" class="input-medium" path="type" items="${typeMap}" />
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
										<!--     <th>协作编号</th>
											<th>案件编号</th> -->
											<th>唯一标识</th>
											<th>类型</th>
											<th>查询方式</th>
											<th>账(卡)号</th>
											<th>查询日期</th>
											<th>名称</th>
											<th>证件类型</th>
											<th>证件号码</th>
											<th>账户类型</th>
											<th>组织机构代码</th>
											<th>工商营业执照</th>
											<th>三证合一号码</th>
											<th>注册地名称</th>
											<th>开始日期</th>
											<th>结束日期</th>
											<th>归属机构</th>
											
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqqList" items="${br50_cxqq_mxList}">
											<tr class="text-center">
											<%-- 	<td nowrap="nowrap">${cxqqList.docno}</td>
												<td nowrap="nowrap">${cxqqList.caseno}</td> --%>
												<td nowrap="nowrap">${cxqqList.uniqueid}</td>
												<td nowrap="nowrap">${cxqqList.type_disp}</td>
												<td nowrap="nowrap">${cxqqList.querymode_disp}</td>
												<td nowrap="nowrap">${cxqqList.account}</td>
												<td nowrap="nowrap">${cxqqList.qrydt}</td>
												<td nowrap="nowrap">${cxqqList.name}</td>
												<td nowrap="nowrap">${cxqqList.idtype_disp}</td>
												<td nowrap="nowrap">${cxqqList.id}</td>
												<td nowrap="nowrap">${cxqqList.acctype}</td>
												<td nowrap="nowrap">${cxqqList.orgcode}</td>
												<td nowrap="nowrap">${cxqqList.buslicense}</td>
												<td nowrap="nowrap">${cxqqList.threeinone}</td>
												<td nowrap="nowrap">${cxqqList.location}</td>
												<td nowrap="nowrap">${cxqqList.startdate}</td>
												<td nowrap="nowrap">${cxqqList.enddate}</td>
												<td nowrap="nowrap">${cxqqList.orgkey_disp}</td>
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