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

				<fm:form class="form-horizontal"  commandName="br40_cxqq_mx"  action="search_cg_list"  method="POST">
				
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
											 <th>任务流水号</th>
										     <th>证照类型代码</th>
											<th>证照号码</th>
											<th>主体名称</th>
											<th>查询内容</th>
											<th>明细时段类型</th>
											<th>明细起始时间</th>
											<th>明细截止时间</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqq_mxList"  items="${br40_cxqq_mxList}" >
											<tr class="text-center">
                                    	        <td  nowrap="nowrap"> 
                                    	        <a href="#"  onclick="_OpenXLarge('<c:url value="/br40_cxqq/search_cgdt_main?isNewSearch=1&qqdbss=${cxqq_mxList.qqdbs}&rwlshs=${cxqq_mxList.rwlsh}&qqcslxs=${qqcslx}&cxnr=${cxqq_mxList.cxnr}" />','反馈信息')"> 
                                                    ${cxqq_mxList.rwlsh}
                                                           </a>
                                    	      </td>
												<td nowrap="nowrap">${cxqq_mxList.zzlx_disp}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.zzhm}</td>
												<td nowrap="nowrap"> ${cxqq_mxList.ztmc}</td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.cxnr_disp} </td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxsdlx_disp} </td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxqssj} </td>
									        	<td nowrap="nowrap"> ${cxqq_mxList.mxjzsj} </td>
											</tr>

										</c:forEach>

										</tbody>
								</table>
							</div>
						</div>
					</div>
				<%-- 	<c:out value="${pageInfoStr}" escapeXml="false"></c:out> --%>
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