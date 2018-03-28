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
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
											 <th>任务流水号</th>
										     <th>查询账卡号</th>
										     <th>查询内容</th>
										     <th>查询种类</th>
										     <th>交易流水号</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqq_mxList"  items="${br40_cxqq_mxList}" >
											<tr class="text-center">
                                    	        <td  nowrap="nowrap">
                                    	         <a href="#"  onclick="_OpenXLarge('<c:url value="/br40_cxqq/proof_modify_disp?qqdbs=${cxqq_mxList.qqdbs}&rwlsh=${cxqq_mxList.rwlsh}&tasktype=${br40_cxqq_mx.tasktype }" />','反馈信息')"> 
                                               ${cxqq_mxList.rwlsh}
                                                           </a>
                                    	        </td>
                                    	        <td nowrap="nowrap">${cxqq_mxList.cxzh}</td>
                                    	        <td nowrap="nowrap"> ${cxqq_mxList.cxnr_disp} </td>
                                    	        <td nowrap="nowrap"> ${cxqq_mxList.cxzl} </td>
                                    	        <td nowrap="nowrap">${cxqq_mxList.jylsh}</td>
											</tr>
										</c:forEach>
										</tbody>
								</table>
							</div>
						</div>
					</div>
					<%-- <c:out value="${pageInfoStr}" escapeXml="false"></c:out> --%>
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