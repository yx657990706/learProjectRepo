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
<title></title>
<jsp:include page="../../fragments/base_css.jsp"></jsp:include>
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="page-content" id="page-content">
		<fm:form class="form-horizontal" commandName="cgb_risk_case"
			action="query_list" method="POST">
			<!-- 右侧内容 -->
			<div class="row">
				<div class="col-xs-12">

					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								电信诈骗风险事件信息查询
							</h5>
							<div class="widget-toolbar">
								<a href="#" onclick="_submit('export?featurecodetype=3')"> <i
									class="ace-icon fa fa-file-excel-o green"></i>&nbsp;导出
								</a> &nbsp;&nbsp; <a href="#" data-action="collapse"> <i
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
												class="control-label col-xs-4 col-sm-4 no-padding-right">部门/支行：</label>
											<div class=" col-xs-8 col-sm-8 input-group">
												<fm:input type="hidden" path="suborgankey" />
												<fm:input path="suborgankey_disp" class="input-large"
													onchange="_changeOrganId('suborgankey_disp','suborgankey')" />
												<a href="#"
													onclick="selectTreeByName('suborgankey_disp','selectOrgan');"
													title="选择交易机构"> <i class="glyphicon glyphicon-search "></i>
												</a>

											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">发生日期：</label>

											<div class="input-group col-xs-12 col-sm-8">
												<div class=" input-group col-xs-12 col-sm-9">
													<fm:input class="form-control date-picker"
														path="happendate_q" type="text"
														data-date-format="yyyy-mm-dd" />
													<span class="input-group-addon"> <i
														class="fa fa-arrows-h"></i>
													</span>
													<fm:input class="form-control date-picker"
														path="happendate_z" type="text"
														data-date-format="yyyy-mm-dd" />
													<span class="input-group-addon"> <i
														class="fa fa-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">涉案户名：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="accountname" class="input-large" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">涉案账户：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="account" class="input-medium" />
											</div>
										</div>


									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">证照号码：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="cardnumber" class="input-medium" />
												&nbsp;
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
											<div class="input-group col-xs-12 col-sm-8">
												<button class="btn btn-info btn-mini" type="button"
													id="submitForm"
													onclick="_submit('query_list?isNewSearch=1')">
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
											<th>机构名称</th>
											<th>部门/支行</th>
											<th>涉案账户名</th>
											<th>涉案账户</th>
											<th>证照号码</th>
											<th>涉案金额</th>
											<th>诈骗信息来源</th>
											<th>事件发生日期</th>
											<th>事件简述</th>
											<th>信息来源渠道</th>
											<th>是否已报案</th>
											<th>受理报案机关</th>
											<th>状态</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${cgb_risk_caseList}" var="cases"
											varStatus="s">
											<tr class="text-center">
												<td class="align-middle" nowrap="nowrap">${cases.organkey_disp}</td>
												<td class="align-middle" nowrap="nowrap">${cases.suborgankey_disp}</td>
												<td class="align-middle" nowrap="nowrap">${cases.accountname}</td>
												<td class="align-middle" nowrap="nowrap">${cases.account}</td>
												<td class="align-middle" nowrap="nowrap">${cases.cardnumber}</td>
												<td class="align-middle" nowrap="nowrap">${cases.je}</td>
												<td class="align-middle" nowrap="nowrap">${cases.infosource_disp}</td>
												<td class="align-middle" nowrap="nowrap">${cases.happendate}</td>
												<td class="align-middle" nowrap="nowrap"><a href="#"
													onclick="_tips(this,'${cases.casedesc}')">${cases.casedesc_disp}</a>
												</td>
												<td class="align-middle" nowrap="nowrap">${cases.channeldesc}</td>
												<td class="align-middle" nowrap="nowrap">${cases.isreport_disp}</td>
												<td class="align-middle" nowrap="nowrap">${cases.dealorgan}</td>
												<td class="align-middle" nowrap="nowrap"><span
													class="label label-success arrowed-in arrowed-in-right">${cases.status_cd_disp}</span></td>
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
					<!-- PAGE CONTENT ENDS -->
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
	<script
		src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />">
		
	</script>
	<!--树-->
	<script
		src="<c:url value='/resources/js/lib/artDialog/6.0.4/dist/dialog-plus.js' />">
		
	</script>
	<script src="<c:url value='/resources/js/agg/agg.js' />">
		
	</script>

	<script type="text/javascript">
		//提交审核
		function do_tj(url, title) {
			var num = 0;
			$("input[type='checkbox']").each(function() {
				if (this.checked) {
					if ($(this).val() != 'on') {
						num++;
					}
				}
			});
			if (num < 1) {
				agg.dialogAlert("请至少选择一条记录！", "face-smile");
				return false;
			}
			$("#url").val(url);
			agg.dialogConfirm(title, okDo, closeDo);
		}

		function closeDo() {
		}
		function okDo() {
			_submit($("#url").val());
		}
		function to_open(url, title) {//弹出大窗
			var re_url = $("#re_url").val();
			agg.artDialog({
				title : title,
				url : url,
				width : '980',
				height : '550',
				onclose : function() {
					_submit(re_url);
				}
			});
		}

		//删除
		function to_delete(url, title) {
			$("#url").val(url);
			agg.dialogConfirm(title, okDo, closeDo);
		}

		function _tips(obj, content) {
			agg.artDialogTips({
				//                 title:'跟随',
				content : content,
				//                 icon:'warning',
				//                 onclose:closeme,//自定义函数closeme
				width : 500,
				follow : obj,
				align : 'bottom left',
				quickClose : true
			})
		}
	</script>
</body>
</html>
