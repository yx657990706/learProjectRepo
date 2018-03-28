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
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal"  commandName="br50_cxqq_back_acct"  action="response_account"  method="POST">
					<fm:hidden path="docno"/>
					<fm:hidden path="caseno"/>
					<fm:hidden path="uniqueid"/>
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询账户反馈信息
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
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
											<fm:input type="text" label="账号：" class="input-large" path="account" />
											</div>
										</div>
										 <div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
											<div class="input-group col-xs-12 col-sm-8 ">
										          <fm:input type="text" label="卡号：" class="input-large" path="cardno"/>
											</div>
										</div>
									</div>
								</div> 
								
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">数据类型：</label>
												<div class="input-group col-xs-12 col-sm-8 ">
											 <fm:select label="数据类型：" path="datatype"  class="input-medium"  items="${datatypeMap}" />
                                                     </div>
											</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
												<div class="input-group col-xs-12 col-sm-8 ">
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('<c:url value="/br50_cxqq/response_account?isNewSearch=1"/>')">
															<i class="glyphicon glyphicon-search"></i>
															查询
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
								<table class="table table-striped table-bordered table-hover" 	>
									<thead class="thin-border-bottom">
										<tr>
											<th>唯一标识</th>
											<!-- <th>案件编号</th>
										     <th>协作编号</th> -->
											<th>开户行代码</th>
											<th>开户行名称</th>
											<th>户名</th>
											<th>卡号</th>
											<th>卡状态</th>
											<!-- <th>账户类型</th> -->
											<th>账号</th>
											<th>账户状态标识</th>
											<th>数据类型</th>
											<th>余额</th>
											<th>币种</th>
											<th>汇钞类型</th>
											<th>开户日期</th>
											<th>最后交易日期</th>
											<th>开户网点编号</th>
											<th>开户网点名称</th>
											<th>开户网点电话</th>
											<th>开户网点地址</th>
											<th>账户联系人地址</th>
											<th>账户联系人地址</th>
											<th>账户状态</th>
											<th>销户日期</th>
											<th>销户网点编号</th>
											<th>销户网点名称</th>
											<th>主机查询时间</th>
											<th>子账号</th>
											
										</tr>
									</thead>

									<tbody>

										<c:forEach var="accountList"  items="${br50_cxqqAccountList}" >
											<tr class="text-center">
                                                <td nowrap="nowrap"> ${accountList.uniqueid}</td>
                                             <%--    <td nowrap="nowrap">${accountList.caseno}</td>
                                    	        <td nowrap="nowrap"> ${accountList.docno}</td> --%>
												<td nowrap="nowrap"> ${accountList.bankcode}</td>
												<td nowrap="nowrap">${accountList.bankname}</td>
									        	<td nowrap="nowrap"> ${accountList.accname} </td>
									        	<td nowrap="nowrap"> ${accountList.cardno} </td>
									        	<td nowrap="nowrap"> ${accountList.cardstatus_disp} </td>
									        	<%-- <td nowrap="nowrap"> ${accountList.acctype}</td> --%>
									        	<td nowrap="nowrap"> ${accountList.account}</td>
									        	<td nowrap="nowrap"> ${accountList.statusflag}</td>
									        	<td nowrap="nowrap"> ${accountList.datatype_disp}</td>
									        	<td nowrap="nowrap"> ${accountList.banlance}</td>
									        	<td nowrap="nowrap"> ${accountList.currency_disp}</td>
									        	<td nowrap="nowrap"> ${accountList.exchangetype_disp}</td>
									        	<td nowrap="nowrap"> ${accountList.opendate}</td>
									        	<td nowrap="nowrap"> ${accountList.tradedate}</td>
									        	<td nowrap="nowrap"> ${accountList.openbranchno}</td>
									        	<td nowrap="nowrap"> ${accountList.bankcode}</td>
									        	<td nowrap="nowrap"> ${accountList.openbranchtel}</td>
									        	<td nowrap="nowrap"> ${accountList.openbranchaddr}</td>
									        	<td nowrap="nowrap"> ${accountList.addr}</td>
									        	<td nowrap="nowrap"> ${accountList.tel}</td>
									        	<td nowrap="nowrap"> ${accountList.status}</td>
									        	<td nowrap="nowrap"> ${accountList.closedate}</td>
									        	<td nowrap="nowrap"> ${accountList.closebranchno}</td>
									        	<td nowrap="nowrap"> ${accountList.closebranchname}</td>
									        	<td nowrap="nowrap"> ${accountList.querytime}</td>
									        	<td nowrap="nowrap"> ${accountList.subaccount}</td>
									        	
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

<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	
</body>
</html>