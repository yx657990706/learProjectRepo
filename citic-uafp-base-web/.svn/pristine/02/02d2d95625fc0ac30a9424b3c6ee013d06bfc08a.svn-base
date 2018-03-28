<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title></title>
<jsp:include page="../../fragments/base_css.jsp"></jsp:include>
<link href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content" id="page-content">
		<fm:form class="form-horizontal" commandName="dx_trade_count"  action="list"  method="POST"  id="myForm">
			<!-- 右侧内容 -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								电信诈骗统计分析
							</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>&nbsp; 
							<a href="#"  onclick="_submit('export_excel?isNewSearch=1')"> <i
									class="ace-icon fa fa-file-excel-o green"></i>&nbsp;导出
								</a>  
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
							<div class="row">
									<div class="col-xs-12">
											<div class="form-group col-xs-12 col-sm-6">
											<label	class="control-label col-xs-12 col-sm-4 no-padding-right">查询日期：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<div class=" input-group col-xs-12 col-sm-9">
												<fm:input class="form-control date-picker" path="qrydt_start" type="text"
														data-date-format="yyyy-mm-dd" />	<span class="input-group-addon"> <i
														class="fa fa-arrows-h"></i>
													</span>
													<fm:input class="form-control date-picker" path="qrydt_end" type="text"
														data-date-format="yyyy-mm-dd" /><span class="input-group-addon"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											<div class="input-group col-xs-12 col-sm-8">
												<button class="btn btn-info btn-mini" type="button"
													id="submitForm" onclick="_submit('list?isNewSearch=1')">
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
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
									<tr>
										    <th>所属分行</th>
										    <th>业务种类</th>
										    <th>业务笔数<br/>(单位：笔)</th>
											<th>账户数量<br/>(单位：个)</th>
											<th>金额<br/>(单位：元)</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${br24_q_mainList}" var="main" varStatus="s">
											<tr class="text-center">
											   <td class="align-middle" nowrap="nowrap">${main.city_disp}</td>
												<td class="align-middle" nowrap="nowrap">${main.business_kind}</td>
												<td class="align-middle" nowrap="nowrap">${main.business_num}</td>
												<td class="align-middle" nowrap="nowrap">${main.accountnumber}</td>
												<td class="align-middle" nowrap="nowrap">${main.money}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- PAGE PageChange BEGINS -->
					<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
					<!-- PAGE PageChange End -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
	<script type="text/javascript">
	jQuery(document).ready(function() {
			jQuery('#myForm').validateAll();
			
		});
		/**
		 * 验证提交
		 * @param url
		 * @param formname
		 */
		function vSubmit(url, formname) {
			var iframe = $("#" + formname);
			if (jQuery(iframe).isValid()) {
				document.forms[0].action = url;
				document.forms[0].submit();
			} else {
				agg.dialogAlert("验证未通过", "face-smile");
				return false;
			}
		}
	</script>
</body>
</html>
