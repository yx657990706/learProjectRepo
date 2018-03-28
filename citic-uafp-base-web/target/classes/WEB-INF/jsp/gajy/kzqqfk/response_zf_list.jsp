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
<jsp:include page="../../fragments/base_css.jsp"/>
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
	<link	href="<c:url value='/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.min.css ' />"  rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br41_kzqq" action="response_kzzf_list" method="POST">
					 <fm:hidden path="tasktype" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								止付反馈信息查询
							</h5>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<rm:input label="请求单标识：" path="qqdbs" class="input-large" />
										<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">发送时间：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:input class="form-control date-picker"	  path="fssj_start"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                  <i class="fa fa-arrows-h"></i>
                                                    </span>
                                                    	<fm:input class="form-control date-picker"	  path="fssj_end"  data-date-format="yyyy-mm-dd" />				
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>
											</div>
										</div>
									</div>
								</div>
						     <div class="row">
									<div class="col-xs-12">
									   <rm:select  label="反馈状态：" class=" input-medium" path="status" items="B00089" />
											<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">查询日期：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:input class="form-control date-picker"	path="qrydt_start" type="text" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i class="fa fa-arrows-h"></i></span>
												<fm:input class="form-control date-picker" path="qrydt_end" type="text" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">请求措施类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:select class=" input-medium" path="qqcslx"
													items="${qqcslxMap}"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
												<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:select class=" input-medium" path="jjcd"
													items="${jjcdMap}" />
											<button class="btn btn-info btn-mini" type="button"
												onclick="_submit('response_kzzf_list?isNewSearch=1') ">
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
							<!-- /.widget-body -->
						<div class="widget-box widget-color-blue agg_widgetbox">
							<div class="widget-body">
								<div class="widget-main no-padding">
									<table class="table table-striped table-bordered table-hover">
										<thead class="thin-border-bottom">
											  <tr>
							                    <th rowspan="2">查看</th>
							                    <th rowspan="2">请求单标识</th>
												<th colspan="3">完成情况</th>
							                    <th rowspan="2">请求措施类型</th>
							                    <th rowspan="2">反馈状态</th>
							                    <th rowspan="2">回执说明</th>
							                    <th rowspan="2">查询日期</th>
							                    <th rowspan="2">案件类型</th>
							                    <th rowspan="2">紧急程度</th>
							                     <th rowspan="2">发送时间</th>
												<th rowspan="2">申请机构</th>
							                    <th rowspan="2">目标机构</th>
							                </tr>
											 <tr>
											 	<th>总数</th>
												<th>未完成</th>
												<th>已完成</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="br41_kzqq" items="${br41_kzqqList}">
												<tr class="text-center">
												  <td>
				                             <a href="#" onclick="_submit('<c:url value="/br41_kzqq/request_kz_main?qqdbs=${br41_kzqq.qqdbs}&qqcslx=${br41_kzqq.qqcslx }&isdync=1" />')">
                                                         <i class="ace-icon glyphicon glyphicon-search green" title="查看"></i>
                                                        </a>
                                   				 </td>
											 	<td nowrap>${br41_kzqq.qqdbs}</td>
												<td nowrap>${br41_kzqq.scount}</td> 
												<td nowrap>${br41_kzqq.ucount}</td> 
												<td nowrap>${br41_kzqq.fcount}</td> 
							                    <td nowrap>${br41_kzqq.qqcslx_disp}</td>
							                    <td nowrap>${br41_kzqq.status_disp}</td>
							                    <td nowrap> 
													<c:if test="${br41_kzqq.hzdm=='99999' }">
													     ${br41_kzqq.hzsm }
													</c:if>
													<c:if test="${br41_kzqq.hzdm!='99999' }">
													    ${br41_kzqq.hzdm_disp }
													</c:if>
												</td>
							                    <td nowrap>${br41_kzqq.qrydt}</td>
							                    <td nowrap>${br41_kzqq.ajlx_disp}</td>
							                    <td nowrap>${br41_kzqq.jjcd_disp}</td>
							                    <td nowrap>${br41_kzqq.fssj}</td>
							                    <td nowrap>${br41_kzqq.sqjgdm_disp}</td>
												<td nowrap>${br41_kzqq.mbjgdm_disp}</td>	
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
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
	<!-- <script type="text/javascript">
    $(".datetimepicker").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
</script> 
	 -->
</body>
</html>