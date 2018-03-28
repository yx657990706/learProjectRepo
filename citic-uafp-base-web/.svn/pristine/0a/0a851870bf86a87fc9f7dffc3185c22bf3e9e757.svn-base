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
	href="<c:url value='/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.min.css ' />"
	rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="page-content">
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br40_cxqq_back"	action="deal_dtjx_query_list" method="POST">
					<fm:hidden path="qqdbs" />
					<fm:hidden path="tasktype" />
					<fm:hidden path="rwlsh" />
				<%-- 	<fm:hidden path="qqcslx" /> --%>
					<fm:hidden path="backurl"  value="deal_dtjx_query_list" /> 
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								<c:if test="${br40_cxqq_back.qqcslx=='02' }">	动态查询</c:if>
								<c:if test="${br40_cxqq_back.qqcslx=='03' }">	继续动态查询</c:if>
								<c:if test="${br40_cxqq_back.qqcslx=='04' }">  解除动态查询</c:if>
							</h5>
							<div class="widget-toolbar">
								<a href="#" onclick="_submit('query_dt_list')"> <i
									class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> &nbsp; <a href="#" data-action="collapse"> <i
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">执行起始时间：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input class="form-control date-picker" path="zxqssj_s"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="zxqssj_e"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:select path="cxfkjg" items="${cxfkjgMap}"></fm:select>
												&nbsp;
												<button class="btn btn-info btn-mini" type="button"
													id="submitForm"
													onclick="_submit('deal_dtjx_query_list?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>
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
												<th nowrap="nowrap">流水号</th>
												<th nowrap="nowrap">序号</th>
												<th nowrap="nowrap">账号</th>
												<th nowrap="nowrap">卡号</th>
												<th nowrap="nowrap">状态</th>
												<th nowrap="nowrap">执行结果</th>
												<th nowrap="nowrap">失败原因</th>
												<th nowrap="nowrap">反馈手机号码</th>
												<th nowrap="nowrap">执行起始时间</th>
												<th nowrap="nowrap">结束时间</th>
												<th nowrap="nowrap">执行时间区间</th>
												<!-- 根据tasktype==8判断是深圳公安   请求措施类型 为02时是动态查询 -->
												<c:if
													test="${br40_cxqq_back.qqcslx=='02' && br40_cxqq_back.tasktype=='8' }">
													<th nowrap="nowrap">银行主机数据时间</th>
												</c:if>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="backList" items="${br40_cxqq_backList}">
												<tr class="text-center">
													<td nowrap>${backList.rwlsh}</td>
													<td nowrap><c:choose>
															<c:when test="${backList.seq=='0'}">	${backList.seq}</c:when>
															<c:otherwise>
																<a href="#"
																	onclick="_submit('deal_acct_dt_trans_list?isNewSearch=1&seq=${backList.seq}&status=2')">
																	${backList.seq} </a>
															</c:otherwise>
														</c:choose></td>
													<td nowrap>${backList.zh}</td>
													<td nowrap>${backList.kh}</td>
													<td nowrap>${backList.status_disp}</td>
													<td nowrap><c:if test="${backList.cxfkjg=='0'}">成功</c:if>
														<c:if test="${backList.cxfkjg=='1'}">失败</c:if></td>
													<td nowrap>${backList.czsbyy}</td>
													<td nowrap>${backList.fksjhm}</td>
													<td nowrap>${backList.zxqssj}</td>
													<td nowrap>${backList.jssj}</td>
													<td nowrap>${backList.mxsdlx_disp}</td>
													<c:if
														test="${br40_cxqq_back.qqcslx=='02' && br40_cxqq_back.tasktype=='8' }">
														<td nowrap>${backList.yhzjsjsj}</td>
													</c:if>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
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
	</script>
</body>
</html>