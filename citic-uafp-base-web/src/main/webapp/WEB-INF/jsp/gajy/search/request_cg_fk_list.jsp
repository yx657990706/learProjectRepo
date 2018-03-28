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

				<fm:form class="form-horizontal"  commandName="br40_cxqq_back"  action="list" method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								常规查询
							</h5>
							<div class="widget-toolbar">
							
							<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
					</div>
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
											 <th>任务流水号</th>
										     <th>请求单标识</th>
											<th>申请机构代码</th>
											<th>目标机构代码</th>
											<th>查询主体类别</th>
											<th>查询结束时间</th>
											<th>账号</th>
											<th>卡号</th>
											<th>查询反馈结果</th>
											<th>操作失败原因</th>
											<th>状态</th>
											<th>查询日期</th>
											<th>反馈手机号码</th>
											<th>执行起始时间</th>
											<th>执行结束时间</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqqList"  items="${br40_cxqq_backList}" >
											<tr class="text-center">
											<!-- 	<td nowrap="nowrap">
														<div class="checkbox">
															<label>
																<input type="checkbox"   class="ace" /><span class="lbl"></span>																																
															</label>
															
													</div>	
												</td>-->
												 <td  nowrap="nowrap"> ${cxqqList.rwlsh}</td>
                                    	        <td  nowrap="nowrap"> ${cxqqList.qqdbs}</td>
												<td nowrap="nowrap"> ${cxqqList.sqjgdm}</td>
												<td nowrap="nowrap"> ${cxqqList.mbjgdm}</td>
												<td nowrap="nowrap">${cxqqList.ztlb_disp}</td>
												<td nowrap="nowrap"> ${cxqqList.cxjssj} </td>
									        	<td nowrap="nowrap"> ${cxqqList.zh} </td>
									        	<td nowrap="nowrap"> ${cxqqList.kh} </td>
									        	<td nowrap="nowrap"> ${cxqqList.cxfkjg_disp} </td>
									        	<td nowrap="nowrap"> ${cxqqList.czsbyy}</td>
									        	<td nowrap="nowrap"> ${cxqqList.status_disp}</td>
									        	<td nowrap="nowrap"> ${cxqqList.qrydt} </td>
									        	<td nowrap="nowrap"> ${cxqqList.fksjhm} </td>
									        	<td nowrap="nowrap"> ${cxqqList.zxqssj}</td>
									        	<td nowrap="nowrap"> ${cxqqList.jssj}</td>
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

<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	
</body>
</html>