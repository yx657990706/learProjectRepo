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
				<fm:form class="form-horizontal" commandName="br54_cxqq_mx" action="list" method="POST">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查询请求信息
								<!--前面的图标可加可不加，这种表格就是widget-box-->
							</h5>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">请求单号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text" path="bdhm" class="input-large" />
											</div>
										</div>

										<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">条件类别：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:select path="tjlb" class=" input-medium" 	items="${tjlbMap}"  onchange="selectChange()"/>
											</div>
										</div>
									</div>
								</div>

								<div class="row" id="card1">
									<div class="col-xs-12">
										<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">查询开始日期：</label>
											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input class="form-control date-picker"
													path="cxkssj_start" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="cxkssj_end"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>

									<div class="form-group col-xs-6 col-sm-6">
											<label class="control-label col-xs-4 col-sm-4 no-padding-right">查询结束日期：</label>
											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input class="form-control date-picker" path="cxjssj_start" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i	class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="cxjssj_end"
													data-date-format="yyyy-mm-dd" /><span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								
									<div class="row" id="card2">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">账（卡）号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text"  path="zh" class="input-large"	 />
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">查询截止日期</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('request_mx_list?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="trade"  style="display:none">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">账（卡）号：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="text"  path="zh" class="input-large"	 />
											</div>
										</div>

										<div class="form-group col-xs-12 col-sm-6">
											<label class="control-label col-xs-12 col-sm-4 no-padding-right">查询截止日期</label>
											<div class="col-xs-12 col-sm-8 no-padding-left">
												<button class="btn btn-info btn-mini" type="button"
													onclick="_submit('request_mx_list?isNewSearch=1')">
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
										  <!--   <th>操作</th> -->
											<th>请求单号</th>
											<th>案号</th>
											<th>证照类型</th>
											<th>证照号码</th>
											<th>张（卡）号</th>
											<th>条件类别</th>
											<!-- 判断当按照交易流水查询的时候，才显示 -->
											<c:if test="${br54_cxqq_mx.tjlb='2' }">
											<th>交易流水号</th>
											<th>交易关联号</th>
											</c:if>
											<th>承办人1</th>
											<th>承办人2</th>
											<th>涉案对象名称</th>
											<th>查询起始时间</th>
											<th>查询结束时间</th>
											<th>查询日期</th>
											<th>归属机构</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cxqqList" items="${br54_cxqqList}">
											<tr class="text-center">
												<%-- <td nowrap><a href="request_disp?party_class_cd=${cxqqList.party_class_cd}&qrymode=${cxqqList.qrymode}&msgseq=${cxqqList.msgseq }&packetkey=${cxqqList.packetkey }">${cxqqList.msgseq }</a></td> --%>
												<td nowrap>${cxqqList.bdhm }</td>
												<td nowrap>${cxqqList.ah }</td>
												<td nowrap>${cxqqList.zjlx_disp}</td>
												<td nowrap>${cxqqList.zzhm}</td>
												<td nowrap>${cxqqList.zh}</td>
												<td nowrap>${cxqqList.tjlb}</td>
												<!-- 判断当按照交易流水查询的时候，才显示 -->
											   <c:if test="${br54_cxqq_mx.tjlb='2' }">
											   <td nowrap>${cxqqList.jylsh}</td>
											    <td nowrap>${cxqqList.jyglh}</td>
											   </c:if>
												<td nowrap>${cxqqList.cbr1 }</td>
												<td nowrap>${cxqqList.cbr2 }</td>
												<td nowrap>${cxqqList.mc }</td>
												<td nowrap>${cxqqList.cxkssj }</td>
												<td nowrap>${cxqqList.cxjssj }</td>
												<td nowrap>${cxqqList.qrydt }</td>
												<td nowrap>${cxqqList.orgkey_disp }</td> 
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
	
	function selectChange(){
	 var tjlb=$("#tjlb").val();
	 //tjlb   1 按账卡号查询   2 按交易流水号查询
	if(tjlb="1"){
		$("#trade").hide();
		$("#card1").show();
		$("#card2").show();
	}else{
		$("#card1").hide();
		$("#card2").hide();
		$("#trade").show();
	}
	}
	
	
	</script>
</body>
</html>