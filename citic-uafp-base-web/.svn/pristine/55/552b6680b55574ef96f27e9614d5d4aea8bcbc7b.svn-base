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
				<fm:form class="form-horizontal"  commandName="br40_cxqq"  action="query_cg_list"  method="POST">
					<fm:hidden path="tasktype"/>
                      <input type="hidden" name="backurl"  value="../br40_cxqq_mx/query_cg_list?tasktype=${br40_cxqq.tasktype}">
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
						<div class="widget-body">
							<div class="widget-main">
						     <div class="row">
									<div class="col-xs-12">
									    <rm:input label="任务流水号：" path="rwlsh" class="input-large" />
										<rm:input label="证照号码：" path="zzhm" class="input-large" />
									</div>
								</div> 
								<div class="row">
									<div class="col-xs-12">
		                                <rm:input label="主体名称："  class="input-large"  path="ztmc" />
		                                <rm:input label="账卡号："  class="input-large"  path="cxzh" />
									</div>
								</div>	
								<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">主体类别：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
										    <fm:select label="主体类别："  class="input-medium"  items="${ztlbMap }" path="ztlb"></fm:select>
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
										 	<fm:select label="紧急程度：" class="input-medium"   items="${jjcdMap }" path="jjcd"/>
											</div>
										</div>
								</div>
								</div>	
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">核心反馈结果：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
										 			<fm:select label="反馈结果："  class="input-medium"  items="${cxfkjgMap }" path="cxfkjg"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">查询内容：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
										 	<fm:select label="查询内容："  class="input-medium"  items="${cxnrMap }" path="cxnr"/>
											</div>
										</div>
									</div>
								</div>	
									<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">发送时间：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:input class="form-control date-picker"  path="fssj_start"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                  <i class="fa fa-arrows-h"></i>
                                                    </span>
                                                 	<fm:input class="form-control date-picker"  path="fssj_end"  data-date-format="yyyy-mm-dd" />				
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>
											</div>
										</div>
									   			<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											<div class="input-group col-xs-12 col-sm-8 ">
										
											<button class="btn btn-info btn-mini" type="button"  onclick="_submit('query_cg_list?isNewSearch=1') ">
												<i class="glyphicon glyphicon-search"></i> 查询
											</button>
											</div>
											
										</div>
									</div>
								</div>
								</div>
								</div>
								<!-- /.widget-main -->
							</div>

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
										    <th>任务流水号</th>
										    <th>主体类别</th>
										    <th>账卡号</th>
											<th>核心反馈结果</th>
											<th>核心反馈状态</th>
											 <th>反馈结果原因</th>
										    <th>证照类型</th>
											<th>主体名称</th>
											<th>证照号码</th>
											<th>查询内容</th>
											<th>明细起始时间</th>
											<th>明细截止时间</th>
						                    <th>申请机构</th>					                  
						                    <th>案件类型</th>
						                    <th>紧急程度</th>
						                    <th>发送时间</th>
						                    <th>查询结束时间</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqq_mx"  items="${cxqq_mxList}" >
											<tr class="text-center">
                                    	        <td  nowrap="nowrap">
                                    	         <a href="#"   onclick="_submit('<c:url value="/br40_cxqq/search_cgdt_main?isNewSearch=1&qqdbss=${cxqq_mx.qqdbs}&rwlshs=${cxqq_mx.rwlsh}&qqcslxs=${cxqq_mx.qqcslx}&tasktypes=${cxqq_mx.tasktype}&cxnr=${cxqq_mx.cxnr}" />')"> 
                                                    ${cxqq_mx.rwlsh}
                                                           </a>
                                    	        </td>
                                    	        <td nowrap="nowrap"> ${cxqq_mx.ztlb_disp}</td>
                                    	        <td nowrap="nowrap"> ${cxqq_mx.cxzh}</td>
                                    	        <td nowrap="nowrap"> ${cxqq_mx.cxfkjg_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mx.status_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mx.czsbyy} </td>
												<td nowrap="nowrap">${cxqq_mx.zzlx_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mx.ztmc}</td>
												<td nowrap="nowrap"> ${cxqq_mx.zzhm}</td>
									        	<td nowrap="nowrap"> ${cxqq_mx.cxnr_disp} </td>
									        	<td nowrap="nowrap"> ${cxqq_mx.mxqssj} </td>
									        	<td nowrap="nowrap"> ${cxqq_mx.mxjzsj} </td>
									        	<td nowrap="nowrap"> ${cxqq_mx.sqjgdm_disp} </td>
									        	<td nowrap="nowrap"> ${cxqq_mx.ajlx_disp}</td>
									        	<td nowrap="nowrap"> ${cxqq_mx.jjcd_disp}</td>
									        	<td nowrap="nowrap"> ${cxqq_mx.fssj}</td>
									        	<td nowrap="nowrap"> ${cxqq_mx.cxjssj}</td>
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