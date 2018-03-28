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
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal" commandName="br50_cxqq_back_trans" 	action="response_trans" method="POST">
					<fm:hidden path="docno" />
					<fm:hidden path="caseno" />
					<fm:hidden path="uniqueid" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询交易流水反馈信息
							</h5>
							<div class="widget-toolbar">
								<a href='<c:url value="/br50_cxqq_mx/response_list"/>'>
					                <i class="ace-icon fa fa fa-arrow-circle-left green"></i>
					                返回
					            </a>&nbsp;
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
												<fm:input type="text" path="cardno" class="input-large" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">交易时间：</label>

											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input class="form-control date-picker"
													path="transtime_start" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"><i
													class="fa fa-arrows-h"></i> </span>
												<fm:input class="form-control date-picker"
													path="transtime_end" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"><i
													class="fa fa-calendar bigger-110"></i> </span>
											</div>

										</div>
										
										
										
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="account" class="input-large" />
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>

											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input class="form-control date-picker"
													path="qrydt_start" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"><i
													class="fa fa-arrows-h"></i> </span>
												<fm:input class="form-control date-picker" path="qrydt_end"
													type="text" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"><i
													class="fa fa-calendar bigger-110"></i> </span>
											</div>

										</div>
										
										
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
											<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">户名：</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
											<fm:input type="text" class="input-large" path="accname" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
										
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('response_trans?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- PAGE CONTENT BEGINS -->

					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover">
									<thead class="thin-border-bottom">
										<tr class="text-center">
											    <th>唯一标识</th>
										<!-- 	<th>案件编号</th>
											<th>协作编号</th> -->
											   <th>账号<h>
												<th>交易流水号</th>
												<th>户名</th>
												<th>卡号</th>
												<th>账户类型</th>
												<th>查询日期</th>
												<th>子账号</th>
												<th>汇钞类型</th>
												<th>交易时间</th>
												<th>支出</th>
												<th>存入</th>
												<th>余额</th>
												<th>币种</th>
												<th>交易类型</th>
												<th>交易地址</th>
												<th>交易地址编号</th>
												<th>交易国家或区域</th>
												<th>交易备注</th>
												<th>交易联系电话</th>
												<th>交易渠道</th>
												<th>交易柜员号</th>
												<th>交易终端IP</th>
												<th>对方账号</th>
												<th>对方户名</th>
												<th>对方机构号</th>
												<th>对方机构名</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="transList"
											items="${br50_cxqqAccountTransList}">
											<tr class="text-center">
												<td nowrap="nowrap">${transList.uniqueid}</td>
												<%-- <td nowrap="nowrap">${transList.caseno}</td>
												<td nowrap="nowrap">${transList.docno}</td> --%>
												<td nowrap="nowrap">${transList.account}</td>
												<td nowrap="nowrap">${transList.transseq}</td>
												<td nowrap="nowrap">${transList.accname}</td>
												<td nowrap="nowrap">${transList.cardno}</td>
												<td nowrap="nowrap">${transList.acctype}</td>
												<td nowrap="nowrap">${transList.qrydt}</td>
												<td nowrap="nowrap">${transList.subaccount}</td>
												<td nowrap="nowrap">${transList.exchangetype_disp}</td>
												<td nowrap="nowrap">${transList.transtime}</td>
												<td nowrap="nowrap">${transList.expense}</td>
												<td nowrap="nowrap">${transList.income}</td>
												<td nowrap="nowrap">${transList.banlance}</td>
												<td nowrap="nowrap">${transList.currency_disp}</td>
												<td nowrap="nowrap">${transList.transtype}</td>
												<td nowrap="nowrap">${transList.transaddr}</td>
												<td nowrap="nowrap">${transList.transaddrno}</td>
												<td nowrap="nowrap">${transList.transcountry}</td>
												<td nowrap="nowrap">${transList.transremark}</td>
												<td nowrap="nowrap">${transList.transtel}</td>
												<td nowrap="nowrap">${transList.transchannel}</td>
												<td nowrap="nowrap">${transList.transtelle}</td>
												<td nowrap="nowrap">${transList.transtermi}</td>
												<td nowrap="nowrap">${transList.matchaccou}</td>
												<td nowrap="nowrap">${transList.matchaccna}</td>
												<td nowrap="nowrap">${transList.matchbankn}</td>
												<td nowrap="nowrap">${transList.matchbankname}</td>
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