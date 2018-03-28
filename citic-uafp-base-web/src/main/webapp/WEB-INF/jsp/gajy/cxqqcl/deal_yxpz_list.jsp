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
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="page-content">
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br40_cxqq_mx" action="deal_yxpz_list" method="POST">
						<fm:input type="hidden" path="qqdbs" class="input-large" />
						<fm:input type="hidden" path="rwlsh" class="input-large" />
						<div class="widget-box widget-color-blue agg_widgetbox">
							<div class="widget-body">
								<div class="widget-main no-padding">
									<table class="table table-striped table-bordered table-hover">
										<thead class="thin-border-bottom">
											  <tr>
							                    <th nowrap="nowrap">任务流水号</th>
							                    <th nowrap="nowrap">交易流水号</th>
												<th nowrap="nowrap">查询反馈结果</th>
							                    <th nowrap="nowrap">查询反馈结果原因</th>
							                    <th nowrap="nowrap">查询账号</th>
							                    <th nowrap="nowrap">查询种类</th>
							                    <th nowrap="nowrap">凭证图像类型</th>
							                    <th nowrap="nowrap">凭证图像序号</th>
							                    <th nowrap="nowrap">凭证图像名称</th>
												<th nowrap="nowrap">备注</th>
							                </tr>
										</thead>

										<tbody>

											<c:forEach var="back_pzList" items="${br40_cxqq_back_pzList}">
												<tr class="text-center">
												 <%--  <td>
				                                        <a href="#" onclick="_submit('<c:url value="/br40_cxqq/response_main?qqdbs=${br40_cxqq.qqdbs}&qqcslx=${br40_cxqq.qqcslx}&tasktype=${tasktype}" />')">
				                                            <i class="ace-icon fa fa-pencil green" title="处理"></i>
				                                        </a>
				            
                                   				 </td> --%>
											 	<td nowrap>${back_pzList.rwlsh}</td>
												<td nowrap>${back_pzList.jylsh}</td> 
												<td nowrap>${back_pzList.cxfkjg_disp}</td> 
												<td nowrap>${back_pzList.czsbyy}</td> 
							                    <td nowrap>${back_pzList.cxzh}</td> 
							                    <td nowrap>${back_pzList.cxzl}</td>
												<td nowrap>${back_pzList.pztxlx}</td>	
							                    <td nowrap>${back_pzList.pztxxh}</td>
							                    <td nowrap>${back_pzList.pztxmc}</td>
							                    <td nowrap>${back_pzList.beiz}</td>
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
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	

</body>
</html>