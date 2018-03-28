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
				<fm:form class="form-horizontal" commandName="br51_cxqq"
					action="list" method="POST">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								反馈信息查询
								<!--前面的图标可加可不加，这种表格就是widget-box-->
							</h5>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">报文批次号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:hidden path="packetkey" />
												<fm:input type="text" path="msgseq" class="input-large" />
											</div>
										</div>
											<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>

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
												class="control-label col-xs-12 col-sm-4 no-padding-right">反馈状态：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:select path="status" class=" input-medium" 
													items="${statusMap}" />
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">查询类型：</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
												<fm:select path="qrymode" class=" input-medium"
													items="${qrymodeMap}" />&nbsp;
														<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('list?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
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
											<th>数据包名称</th>
											<th>查询类型</th>
											<th>反馈状态</th>
											<th>查询日期</th>
											<th>公安操作时间</th>
											<th>总记录数</th>
											<th>归属机构</th>
											<th>银行代码</th>
											<th>接收时间</th>
											<th>反馈时间</th>
											<th>最后修改时间</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="cxqqList" items="${br51_cxqqList}">
											<tr class="text-center">
												<td nowrap><a href="request_main?party_class_cd=${cxqqList.party_class_cd}&qrymode=${cxqqList.qrymode}&msgseq=${cxqqList.msgseq }&packetkey=${cxqqList.packetkey }">${cxqqList.msgseq }</a></td>
												<td nowrap>${cxqqList.packetkey }</td>
												<td nowrap>${cxqqList.qrymode_disp }</td>
												<td nowrap>
												<c:if test="${cxqqList.status=='0'}">
												<span class="label label-info arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												
												<c:if test="${cxqqList.status=='1'}">
												 <span class="label label-info arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												<c:if test="${cxqqList.status=='2'}">
												 <span class="label label-info arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												<c:if test="${cxqqList.status=='3'}">
												<span class="label label-success arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												
												<c:if test="${cxqqList.status=='4'}">
												 <span class="label label-danger arrowed-in arrowed-in-right">${cxqqList.status_disp }</span>
												</c:if>
												
												</td>
												<td nowrap>${cxqqList.qrydt }</td>
												<td nowrap>${cxqqList.czsj }</td>
												<td nowrap>${cxqqList.count }</td>
												<td nowrap>${cxqqList.orgkey_disp }</td>
												<td nowrap>${cxqqList.yhdm }</td>
												<td nowrap>${cxqqList.recipient_time }</td>
												<td nowrap>${cxqqList.feedback_time }</td>
												<td nowrap>${cxqqList.last_up_dt }</td>
												
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
	<script type="text/javascript">
   var tasktype=$("#taskId").val();
	function _OpenXLarge(url,title){ //弹出大窗口
		agg.artDialog({
			title:title,
			url:url,
			width:'980',
			height:'550',
			onclose: function () {
				//_submit("hzws_list?isNewSearch=1&tasktype="+tasktype);
				$(this).dialog("close");
			}
		});
	}

	
	
	</script>
</body>
</html>