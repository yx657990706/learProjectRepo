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
<link href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal"  commandName="br41_kzqq_zf"  action="request_kzzt_list"  method="POST">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" >
									<thead class="thin-border-bottom">
										<tr><th>任务流水号</th>
											<!-- <th>请求单标识</th> -->
											<!-- 解除冻结时才有原任务流水号 -->
											<c:if test="${br41_kzqq_zf.qqcslx=='09' }">
											<th>原任务流水号</th>
											</c:if>
											<th>账卡号</th>
											<th>主体类别</th>
											<th>核心反馈结果</th>
										   <th> 核心反馈状态</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="kzqq_zfList"  items="${br41_kzqq_zfList}">
											 <tr class="text-center">
											    <td  nowrap="nowrap"> 
											     <a href="#" onclick="_OpenXLarge('<c:url value="/br41_kzqq_zf_back/response_zf_main?qqdbs=${kzqq_zfList.qqdbs}&rwlsh=${kzqq_zfList.rwlsh}&tasktype=${kzqq_zfList.tasktype}"/>','止付反馈信息')">
                                                      ${kzqq_zfList.rwlsh}
                                                     </a>
											   </td>
												<%-- <td  nowrap="nowrap"> ${kzqq_zfList.qqdbs}</td> --%>
												<c:if test="${br41_kzqq_zf.qqcslx=='09' }">
												<td nowrap="nowrap">${kzqq_zfList.yrwlsh}</td>
												</c:if>
												<td nowrap="nowrap">${kzqq_zfList.zh}</td>
												<td nowrap="nowrap">${kzqq_zfList.ztlb_disp}</td>
												<td nowrap="nowrap">${kzqq_zfList.zxjg_disp}</td>
												<td nowrap="nowrap">${kzqq_zfList.status_disp}</td>
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