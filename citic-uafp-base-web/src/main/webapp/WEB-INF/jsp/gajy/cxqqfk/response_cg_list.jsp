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
				<fm:form class="form-horizontal"  commandName="br40_cxqq_mx"  action="response_mx_list"  method="POST">
					<fm:hidden path="tasktype"/>
					<fm:hidden path="qqdbs"/>
					<fm:hidden path="qqcslx"/>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
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
										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">主体名称：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input type="text" class="input-large"  path="ztmc" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">账卡号：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
											<fm:input type="text" class="input-large"  path="cxzh" />&nbsp;
											</div>
										</div>
									</div>
								</div>	
								<div class="row">
									<div class="col-xs-12">
										<rm:select label="反馈结果：" items="B00092" path="cxfkjg"></rm:select>
										<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">查询内容：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
												<fm:select class=" input-medium" path="cxnr" items="${cxnrMap}" />
												&nbsp;<button class="btn btn-info btn-mini" type="button"
												onclick="_submit('response_mx_list?isNewSearch=1') ">
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
								<table class="table table-striped table-bordered table-hover" >
									<thead class="thin-border-bottom">
										<tr>
											 <th>任务流水号</th>
											 <c:if test="${br40_cxqq_mx.tasktype=='8' }">
											  <th>查询方式</th>
											 </c:if>
										     <th>证照类型代码</th>
											<th>证照号码</th>
											<th>账卡号</th>
											<th>主体名称</th>
											<th>查询内容</th>
											<th>核心反馈结果</th>
											<th>主体类别</th>
											<th>核心反馈状态</th>
											<th>明细时段类型</th>
											<th>明细起始时间</th>
											<th>明细截止时间</th>
										<!-- 	<th>是否行内客户</th> -->
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqq_mxList"  items="${br40_cxqq_mxList}" >
											<tr class="text-center">
                                    	        <td  nowrap="nowrap">
                                    	         <a href="#"  onclick="_OpenXLarge('<c:url value="/br40_cxqq/search_cgdt_main?isNewSearch=1&qqdbss=${cxqq_mxList.qqdbs}&rwlshs=${cxqq_mxList.rwlsh}&qqcslxs=${br40_cxqq_mx.qqcslx}&tasktypes=${br40_cxqq_mx.tasktype }&cxnr=${cxqq_mxList.cxnr}" />','反馈信息')"> 
                                                    ${cxqq_mxList.rwlsh}
                                                     </a>
                                    	        </td>
                                    	         <c:if test="${br40_cxqq_mx.tasktype=='8' }">
                                    	        <td nowrap="nowrap">${cxqq_mxList.cxfs_disp}</td>
                                    	        </c:if>
												<td nowrap="nowrap">${cxqq_mxList.zzlx_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.zzhm}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.cxzh}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.ztmc}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.cxnr_disp} </td>
												<td nowrap="nowrap"> ${cxqq_mxList.cxfkjg_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.ztlb_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.status_disp}</td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxsdlx_disp} </td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxqssj} </td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxjzsj} </td>
									        	<%-- <td nowrap="nowrap"> ${cxqq_mxList.msgcheckresult_disp} </td> --%>
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