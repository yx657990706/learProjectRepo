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

				<fm:form class="form-horizontal"  commandName="br41_kzqq"  action="request_dj_list" method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								冻结类请求认定
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">请求措施类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
											 <fm:select label="请求措施类型："  path="qqcslx"  items="${qqcslxMap}"  class=" input-medium"/>
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">发送时间：</label>

											<div class="input-group col-xs-12 col-sm-8 ">

												<fm:input class="form-control date-picker"
													path="fssj_start" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker"
													path="fssj_end" type="text"
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										      		 <fm:select label="紧急程度：" class=" input-medium" path="jjcd" items="${jjcdMap}" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											   
										    <div class="input-group  col-xs-12 col-sm-8  ">
					
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('request_dj_list?isNewSearch=1&tasktype=${br41_kzqq.tasktype}')">
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
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
										<!-- 	<th><div class="checkbox agg_GridCheckAll">
													<label><input type="checkbox" class="ace" /><span class="lbl"></span></label>
											</div></th> -->	
											 <th>操作</th>
										     <th>请求单标识</th>
											<th>请求措施类型</th>
											<th>查询主体类别</th>
											<th>案件类型</th>
											<th>紧急程度</th>
											<th>备注</th>
										
											<th>发送时间</th>
											<th>申请机构代码</th>
											<th>目标机构代码</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="kzqqList"  items="${br41_kzqqList}" >
											<tr class="text-center">
												 <td  nowrap="nowrap">
                                                    <a href="#" onclick="_submit('<c:url value="/br41_kzqq_dj/request_dj_main?qqdbss=${kzqqList.qqdbs}&tasktypes=${kzqqList.tasktype}&resource=2" />')">
                                                         <i class="ace-icon fa fa-pencil green" title="处理"></i>
                                                           </a>
                                                </td>
                                    	        <td  nowrap="nowrap"> ${kzqqList.qqdbs}</td>
												<td nowrap="nowrap">${kzqqList.qqcslx_disp}</td>
												<td nowrap="nowrap">${kzqqList.ztlb_disp}</td>
									        	<td nowrap="nowrap"> ${kzqqList.ajlx_disp} </td>
									        	<td nowrap="nowrap"> ${kzqqList.jjcd_disp} </td>
									        	<td nowrap="nowrap"> ${kzqqList.beiz} </td>
									      
									        	<td nowrap="nowrap"> ${kzqqList.fssj}</td>
									        	<td nowrap="nowrap"> ${kzqqList.sqjgdm_disp}</td>
												<td nowrap="nowrap"> ${kzqqList.mbjgdm_disp}</td>
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