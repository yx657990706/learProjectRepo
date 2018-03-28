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
					<fm:hidden path="qqcslx" />
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 	>
									<thead class="thin-border-bottom">
										<tr>
											<th>任务流水号</th>
											<!-- 只有继续动态、解除动态才有原任务流水号 -->
											<c:if test="${qqcslx=='03' || qqcslx=='04' }">
												<th>原任务流水号</th>
											</c:if>
											<th>账卡号</th>
											<th>主体类别</th>
										    <th>核心反馈结果</th>
											<th>核心反馈状态</th>
											<th>开始时间</th>
											<th>执行时间区间</th>
										    <th>结束时间</th>
										      <!--  <th>是否行内客户</th> -->
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqq_mxList"  items="${br40_cxqq_mxList}" >
											<tr class="text-center">
                                    	        <td  nowrap="nowrap">
                                        <a href="deal_dtjx_list?isNewSearch=1&qqdbs=${cxqq_mxList.qqdbs}&rwlsh=${cxqq_mxList.rwlsh}&qqcslx=${qqcslx}&tasktype=${br40_cxqq_mx.tasktype }&cxnr=${cxqq_mxList.cxnr}"> 
                                                    ${cxqq_mxList.rwlsh}
                                                           </a>
                                    	        </td>
                                    	        	<!-- 只有继续动态、解除动态才有原任务流水号 -->
											<c:if test="${qqcslx=='03' || qqcslx=='04' }">
												<td nowrap="nowrap">${cxqq_mxList.yrwlsh}</td>
											</c:if>
												<td nowrap="nowrap">${cxqq_mxList.cxzh}</td>
												  <td nowrap="nowrap"> ${cxqq_mxList.ztlb_disp}</td>
												<td nowrap="nowrap"> 
												<!-- 由于常规查询和动态查询公用的码值是01,02表示，与这里不相符，所以做处理 -->
												<c:if test="${cxqq_mxList.cxfkjg=='0'}">成功</c:if>
												<c:if test="${cxqq_mxList.cxfkjg=='1'}">失败</c:if>
												</td>	
											     <td nowrap="nowrap"> ${cxqq_mxList.status_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.mxqssj}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.mxsdlx_disp} </td>
												<td nowrap="nowrap"> ${cxqq_mxList.mxjzsj} </td>
											<%-- 	<td nowrap="nowrap"> ${cxqq_mxList.msgcheckresult_disp} </td> --%>
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