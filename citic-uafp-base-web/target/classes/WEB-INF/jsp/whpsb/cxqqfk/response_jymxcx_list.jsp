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
		<div class="row">
			<div class="col-xs-12">
				<!-- 右侧内容 -->
				<fm:form class="form-horizontal" commandName="br51_cxqq_back" action="main_list" method="POST">
					<!-- PAGE CONTENT BEGINS -->
					<fm:hidden path="bdhm" />
					<fm:hidden path="msgseq" />
					<fm:hidden path="party_class_cd" />
					<fm:hidden path="qrymode" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								${title }
							</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">账（卡）号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="zh" class="input-large" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">查询日期：</label>
											<div class="col-xs-8 col-sm-8 input-group">
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
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">对方户名：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="matchaccna" class="input-large" />
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">借贷标志：</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
												<fm:select path="debit_credit" class=" input-medium"
													items="${debit_creditMap }" />
												&nbsp;
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('main_list?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>
											</div>
										</div>
									</div>
								</div>

							</div>
							<!-- /.row -->
						</div>
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
										<tr>
											<th>报文批次号</th>
											<th>请求单号</th>
											<th>资金往来序号</th>
											<th>账（卡）号</th>
											<th>查询日期</th>
											<th>交易日期</th>
											<th>交易时间</th>
											<th>对方账号</th>
											<th>币种</th>
											<th>交易金额</th>
											<th>借贷标记</th>
											<th>交易种类</th>
											<th>交易网点</th>
											<th>账户余额</th>
											<th>传票号</th>
											<th>交易流水号</th>
											<th>对方行名</th>
											<th>对方户名</th>
											<th>对方科目名称</th>
											<th>核心源账号</th>
											<th>MAC地址</th>
											<th>IP地址</th>
											<th>交易备注</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="transList" items="${br51_cxqq_back_transList}">
											<tr class="text-center">
												<td nowrap>${transList.msgseq }</td>
												<td nowrap>${transList.bdhm }</td>
												<td nowrap>${transList.transseq }</td>
												<td nowrap>${transList.zh }</td>
												<td nowrap>${transList.qrydt }</td>
												<td nowrap>${transList.transdata }</td>
												<td nowrap>${transList.transtime }</td>
												<td nowrap>${transList.matchaccou }</td>
												<td nowrap>${transList.currency_disp }</td>
												<td nowrap>${transList.amt }</td>
												<td nowrap>${transList.debit_credit_disp }</td>
												<td nowrap>${transList.transtype }</td>
												<td nowrap>${transList.organname_disp }</td>
												<td nowrap>${transList.banlance }</td>
												<td nowrap>${transList.voucher_no }</td>
												<td nowrap>${transList.transnum }</td>
												<td nowrap>${transList.matchbankname }</td>
												<td nowrap>${transList.matchaccna }</td>
												<td nowrap>${transList.oppkm }</td>
												<td nowrap>${transList.ctac }</td>
												<td nowrap>${transList.mac }</td>
												<td nowrap>${transList.ip }</td>
												<td nowrap>${transList.transremark }</td>
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
	<jsp:include page="../../fragments/base_js.jsp" />
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>