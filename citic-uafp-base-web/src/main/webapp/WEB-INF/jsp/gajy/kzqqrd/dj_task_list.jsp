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

				<fm:form class="form-horizontal"  commandName="br41_kzqq_dj"  action="dj_task_list"  method="POST">
				
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
											
										     <th>任务流水号</th>
											<th>原任务流水号</th>
											<th>冻结账户户主</th>
											<th>证件类型代码</th>
											<th>证件号码</th>
											<th>冻结账卡号</th>
											<th>账户序号</th>
											<th>冻结方式</th>
											<th>金额</th>
											<th>币种</th>
											<th>开始时间</th>
											<th>结束时间</th>
                                         <!-- <th>是否行内客户</th> -->
										</tr>
									</thead>

									<tbody>

										<c:forEach var="kzqq_djList"  items="${br41_kzqq_djList}" >
											<tr class="text-center">
											   <td  nowrap="nowrap">  
											   <%-- <a href="#" onclick="_OpenXLarge('<c:url value="/br41_kzqq_dj_back/kzdj_fk_disp?qqdbs=${kzqq_djList.qqdbs}&rwlsh=${kzqq_djList.rwlsh}&tasktype=${kzqq_djList.tasktype}"/>','冻结反馈信息')">
                                                      ${kzqq_djList.rwlsh}
                                                     </a> --%>
                                                    ${kzqq_djList.rwlsh}  </td>
												<td nowrap="nowrap">${kzqq_djList.yrwlsh}</td>
												<td nowrap="nowrap"> ${kzqq_djList.djzhhz}</td>
												<td nowrap="nowrap"> ${kzqq_djList.zzlxdm_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.zzhm}</td>
									        	<td nowrap="nowrap"> ${kzqq_djList.zh} </td>
									        	<td nowrap="nowrap"> ${kzqq_djList.zhxh} </td>
									        	<td nowrap="nowrap"> ${kzqq_djList.djfs_disp} </td>
									        	<td nowrap="nowrap"> ${kzqq_djList.je} </td>
									        	<td nowrap="nowrap"> ${kzqq_djList.bz_disp}</td>
									        	<td nowrap="nowrap"> ${kzqq_djList.kssj} </td>
									        	<td nowrap="nowrap"> ${kzqq_djList.jssj}</td>
									       <%--  	<td nowrap="nowrap"> ${kzqq_djList.msgcheckresult_disp}</td> --%>
											
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