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
								<c:if test="${br54_cxqq_back.qrymode=='grjymxcx' }">个人交易明细信息</c:if>
								<c:if test="${br54_cxqq_back.qrymode=='dwjymxcx' }">单位交易明细信息</c:if>
								<!--前面的图标可加可不加，这种表格就是widget-box-->
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
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">报文批次号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="msgseq" class="input-large" />
													&nbsp;<button class="btn btn-info btn-mini" type="button"
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
											<th>资金往来序号</th>
											<th>账卡号</th>
											<th>交易日期</th>
											<th>交易时间</th>
											<th>对方账号</th>
											<th>对方行名</th>
											<th>对方户名</th>
											<th>币种</th>
											<th>交易金额</th>
											<th>借贷标记</th>
											<th>交易渠道</th>
											<th>交易网点</th>
											<th>IP地址</th>
											<th>MAC地址</th>
											<th>备注</th>
											<th>交易关联号</th>
											<th>交易金额</th>
											<th>传票号</th>
											<th>交易对手证照类型</th>
											<th>交易对手证照号码</th>
											<th>系统交易流水号</th>
											<th>查询日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqqList" items="${br54_cxqq_back_transList}">
											<tr class="text-center">
												<td nowrap>${cxqqList.msgseq }</td>
												<td nowrap>${cxqqList.transseq}</td>
												<td nowrap>${cxqqList.zh}</td>
												<td nowrap>${cxqqList.jyrq }</td>
												<td nowrap>${cxqqList.jysj }</td>
												<td nowrap>${cxqqList.dfzh}</td>
												<td nowrap>${cxqqList.dfhm }</td>
												<td nowrap>${cxqqList.dfmc}</td>
												<td nowrap>${cxqqList.bz_disp }</td>
												<td nowrap>${cxqqList.jyje }</td>
												<td nowrap>${cxqqList.jdbz_disp }</td>
												<td nowrap>${cxqqList.jyqd}</td>
												<td nowrap>${cxqqList.jywd}</td>
												<td nowrap>${cxqqList.ip}</td>
												<td nowrap>${cxqqList.mac}</td>
												<td nowrap>${cxqqList.beiz}</td>
												<td nowrap>${cxqqList.jyglh}</td>
												<td nowrap>${cxqqList.jyye}</td>
												<td nowrap>${cxqqList.cph}</td>
												<td nowrap>${cxqqList.dfzzlx_disp}</td>
												<td nowrap>${cxqqList.zfzzhm}</td>
												<td nowrap>${cxqqList.jylsh}</td>
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