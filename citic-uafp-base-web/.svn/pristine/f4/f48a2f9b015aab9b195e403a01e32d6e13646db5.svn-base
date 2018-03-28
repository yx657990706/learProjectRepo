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
<link	href="<c:url value='/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.min.css ' />"  rel="stylesheet" type="text/css" />
	
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">
		
				<fm:form class="form-horizontal"  commandName="br41_kzqq"  action="query_kzzf_list"  method="POST">
							<input type="hidden"  name="backurl" value="../br41_kzqq_zf/query_kzzf_list?tasktype=${br41_kzqq.tasktype }">
					<div class="widget-box">
					<fm:input type="hidden" path="tasktype"/>
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								止付类查询
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">请求单标识：</label>
											<div class="input-group  col-xs-12 col-sm-8">
											  <fm:input label="请求单标识：" type="text" path="qqdbs_s"  class="input-large"  />
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">发送时间：</label>

										<div class="input-group col-xs-12 col-sm-8 ">
														 <fm:input class="form-control date-picker"    path="fssj_start"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                  <i class="fa fa-arrows-h"></i>
                                                    </span>
                                                     <fm:input class="form-control date-picker"   path="fssj_end"  data-date-format="yyyy-mm-dd" />				
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>
											</div>
										</div>
									</div>
								</div> 
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">请求措施类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										         <fm:select label="请求措施类型：" class="input-medium" path="qqcslx" items="${qqcslxMap }" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
										    <div class="input-group  col-xs-12 col-sm-8  ">
										     <fm:select label="紧急程度：" class="input-medium" path="jjcd" items="${jjcdMap }" />
											</div>
										</div> 
									</div>
								</div> 
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">帐卡号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										       <fm:input label="帐卡号：" type="text" path="zh"  class="input-large"  />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
							 <label class="control-label col-xs-12 col-sm-4 no-padding-right">主体类别：</label>
										    	<div class="input-group  col-xs-12 col-sm-8  ">
										    	<fm:select class="input-medium" path="ztlb" items="${ztlbMap }" />
										     &nbsp;
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('query_kzzf_list?isNewSearch=1')">
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
											 <th>查看</th>
											     <th>请求单标识</th>
											  <th>请求措施类型</th>
											  <th>主体类别</th>
											 <th>账卡号</th>
											 <th>核心反馈结果</th>
											 <th>核心反馈状态</th>
											 <th>失败原因</th>
											 <th>紧急程度</th>
											 <th>发送时间</th>
											 <th>执行起始时间</th>
											 <th>案件类型</th>
											 <th>申请机构</th>
											<th>任务流水号</th>
											<th>原任务流水号</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="kzqq_zfList"  items="${br41_kzqq_zfList}" >
											<tr class="text-center">
										
												 <td  nowrap="nowrap">
                                                    <a href="#" onclick=" _submit('<c:url value="/br41_kzqq_zf_back/response_zf_main?qqdbs=${kzqq_zfList.qqdbs}&rwlsh=${kzqq_zfList.rwlsh}" />')">
                                                         <i class="ace-icon glyphicon glyphicon-search green" title="查看"></i>
                                                           </a>
                                                </td>
                                                 <td nowrap="nowrap"> ${kzqq_zfList.qqdbs}</td>
                                                 <td nowrap="nowrap"> ${kzqq_zfList.qqcslx_disp}</td>
                                                  <td nowrap="nowrap"> ${kzqq_zfList.ztlb_disp}</td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.zh} </td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.zxjg_disp}</td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.status_disp} </td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.sbyy} </td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.jjcd_disp}</td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.fssj} </td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.zxqssj}</td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.ajlx_disp} </td>
                                                <td nowrap="nowrap"> ${kzqq_zfList.sqjgdm_disp} </td>
												<td nowrap="nowrap">${kzqq_zfList.rwlsh}</td>
												<td nowrap="nowrap"> ${kzqq_zfList.yrwlsh}</td>
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

<!-- <script 	src="/aml/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.js">	</script>
	<script 	src="/aml/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.fr.js"">	</script>
	<script type="text/javascript">
    $(".datetimepicker").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
</script>  -->
	
</body>
</html>