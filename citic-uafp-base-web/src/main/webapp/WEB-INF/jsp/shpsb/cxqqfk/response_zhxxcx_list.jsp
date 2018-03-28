<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp" />
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<fm:form class="form-horizontal" commandName="br54_cxqq_back" action="response_mx_list" method="POST">
					<fm:hidden path="bdhm" />
					<fm:hidden path="qrymode" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								<!--前面的图标可加可不加，这种表格就是widget-box-->
								<c:if test="${br54_cxqq_back.qrymode=='dwzhxxcx' }">单位账户信息</c:if>
								<c:if test="${br54_cxqq_back.qrymode=='grzhxxcx' }">个人账户信息</c:if>
							</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i></a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input class="form-control date-picker"
													path="qrydt_start" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="qrydt_end"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"><i
													class="fa fa-calendar bigger-110"></i> </span> 
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">报文批次号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="msgseq" class="input-large" />
												&nbsp;
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('response_mx_list?isNewSearch=1')">
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
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
										<tr>
											<th>报文批次号</th>
											<th>账户序号</th>
											<th>开户账号</th>
											<th>核心源账号</th>
											<th>账户类别</th>
											<th>账户状态</th>
											<th>开户银行名称</th>
											<th>开户日期</th>
											<th>销户日期</th>
											<th>查询时间</th>
											<th>币种</th>
											<th>账户余额</th>
											<th>账户可用余额</th>
											<th>查询日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqqList" items="${br54_cxqq_back_acctList}">
											<tr class="text-center">
												<td nowrap>${cxqqList.msgseq}</td>
												<td nowrap>${cxqqList.zhxh}</td>
												<td nowrap>${cxqqList.zh }</td>
												<td nowrap>${cxqqList.ctac}</td>
												<td nowrap>${cxqqList.zhlb }</td>
												<td nowrap>${cxqqList.zhzt_disp }</td>
												<td nowrap>${cxqqList.yhmc }</td>
												<td nowrap>${cxqqList.khrq }</td>
												<td nowrap>${cxqqList.xhrq }</td>
												<td nowrap>${cxqqList.cxsj}</td>
												<td nowrap>${cxqqList.hbzl_disp }</td>
												<td nowrap>${cxqqList.zhye}</td>
												<td nowrap>${cxqqList.kyye}</td>
												<td nowrap>${cxqqList.qrydt}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
				</fm:form>
			</div>
			<!-- /.widget-main -->
		</div>
		<!-- /.widget-body -->
	</div>
	<jsp:include page="../../fragments/base_js.jsp" />
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>