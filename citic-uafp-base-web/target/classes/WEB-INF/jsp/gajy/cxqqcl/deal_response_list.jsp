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

				<fm:form class="form-horizontal"  commandName="br40_cxqq"  action="request_list"  method="POST">
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询请求认定
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
											     <fm:input type="hidden" path="tasktype"  class="input-large"  />
										         <fm:select  itmes="${cslxMap }"  label="请求措施类型：" path="qqcslx"  class=" input-medium"/>
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">请求单标识：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										        <fm:input label="请求单标识：" path="qqdbs"  class="input-large"  />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
											   
										    <div class="input-group  col-xs-12 col-sm-8  ">
										     <fm:select label="紧急程度：" class=" input-medium" path="jjcd"
													items="${jjcdMap}" />
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('deal_response_list?isNewSearch=1&tasktype=${searchObj.tasktype}')">
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
											<th>申请机构代码</th>
											<th>目标机构代码</th>
											<th>查询主体类别</th>
											<th>案件类型</th>
											<th>紧急程度</th>
											<th>备注</th>
											<th>状态</th>
											<th>发送时间</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqqList"  items="${br40_cxqqList}" >
											<tr class="text-center">
											<!-- 	<td nowrap="nowrap">
														<div class="checkbox">
															<label>
																<input type="checkbox"   class="ace" /><span class="lbl"></span>																																
															</label>
															
													</div>	
												</td>-->
												 <td  nowrap="nowrap">
                                                      <a href="#" onclick="_submit('<c:url value="/br40_cxqq/hzws_list?qqdbss=${cxqqList.qqdbs}&rwlshs=${cxqqList.rwlsh}&tasktypes=${cxqqList.tasktype}&isNewSearch=1"/>')">
        												<i class="ace-icon fa fa-pencil green" title="处理"></i>
                                                       
                                                     </a>                                                </td>
                                    	        <td  nowrap="nowrap"> ${cxqqList.qqdbs}</td>
												<td nowrap="nowrap">${cxqqList.qqcslx_disp}</td>
												<td nowrap="nowrap"> ${cxqqList.sqjgdm}</td>
												<td nowrap="nowrap"> ${cxqqList.mbjgdm}</td>
												<td nowrap="nowrap">${cxqqList.ztlb_disp}</td>
									        	<td nowrap="nowrap"> ${cxqqList.ajlx_disp} </td>
									        	<td nowrap="nowrap"> ${cxqqList.jjcd_disp} </td>
									        	<td nowrap="nowrap"> ${cxqqList.beiz} </td>
									        	<td nowrap="nowrap"> ${cxqqList.status_disp} </td>
									        	<td nowrap="nowrap"> ${cxqqList.fssj}</td>
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