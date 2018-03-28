<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../fragments/base_css.jsp" />

<link
	href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />" rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content"  id="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">
				<fm:form id="myform" class="form-horizontal" commandName="cgb_face_data" 	action="query_list" method="POST">
				<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								信息查询
								<!--前面的图标可加可不加，这种表格就是widget-box-->
							</h5>
							<div class="widget-toolbar">
									<a href="#"  onclick="_submit('export_list?isNewSearch=1')"> <i
									class="ace-icon fa fa-file-excel-o green"></i>&nbsp;导出Excel
								</a>  
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
											class="control-label col-xs-12 col-sm-4 no-padding-right">被冒用人姓名：</label>
										<div class="col-xs-12 col-sm-8 no-padding-left">
											<fm:input type="text" path="victim_name" class="input-large" require="true" datatype="limit_max" max="64"/>
										</div>
									</div>

									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">被冒用人证件号码：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:input type="text" path="victim_card_num" class="input-large" require="true" datatype="limit_max" max="18"/>
										</div>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-6 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">业务办理日期：</label>

											<div class="input-group  col-xs-12 col-sm-8  ">
												<fm:input class="form-control date-picker"
													path="busi_time_start" data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker" path="busi_time_end"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>

									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">业务办理柜员号：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:input type="text" path="busi_teller_num"
												class="input-large" require="true" datatype="limit_max" max="8"/>
										</div>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">业务办理网点：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:input path="busi_website" class="input-medium" require="true" datatype="limit_max" max="6"/>
										</div>
									</div>

									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">业务办理类型：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:input path="busi_type" class=" input-medium" require="true" datatype="limit_max" max="6"/>
										</div>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-6 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">风险类型：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:select path="risk_type" class=" input-medium"
												items="${risk_typeMap }" />
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">名单建库渠道：</label>
										<div class="input-group col-xs-12 col-sm-8">
										<fm:select path="md_channel" class=" input-medium"
												items="${md_channelMap}" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-6 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">审核结果：</label>
										<div class="input-group col-xs-12 col-sm-8">
											<fm:select path="check_result" class=" input-medium"
												items="${check_resultMap}" />
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
										<div class="input-group col-xs-12 col-sm-8">
											<button class="btn btn-info btn-mini" type="button"
												id="submitForm" onclick="vSubmit('query_list?isNewSearch=1','myform')">
												<i class="glyphicon glyphicon-search"></i> 查询
											</button>
											&nbsp;&nbsp;
											<button class="btn btn-info btn-mini" type="button"
												 onclick="myreset();re_do('myform');">
												<i class="ace-icon fa fa-undo bigger-110"></i> 重置
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
									<!-- <th>
									<div class="checkbox agg_GridCheckAll">
											<label>
											 <input type="checkbox" class="ace" />
											  <span 	class="lbl"></span></label>
										</div></th> -->
									<th>组号</th>
									<!-- <th>嫌疑人图像ID</th>
									<th>证件核查图像ID</th>-->
									<th>被冒用人证件名称</th>
									<th>被冒用人证件类型</th>
									<th>被冒用人证件号码</th>
									<th>被冒用人证件有效期</th>
									<th>风险类型</th>
									<th>业务办理网点</th>
									<th>业务办理柜员号</th>
									<th>业务办理时间</th>
									<th>业务办理类型</th>
									<th>业务办理渠道</th>
									<th>联系电话</th>
									<th>联系地址</th>
									<th>名单建库渠道</th>
									<th>审核人员</th>
									<th>审核结果</th>
									<th>出库操作人员</th>
									<th>出库审核人员</th>
									<th>出库审核时间</th>
									<th>其他说明</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cgb_face_dataList}" var="checkList">
								    <c:choose>
								       <c:when test="${checkList.rm_flag == '2'}">
								         <tr class="text-center" style="color:red">
								       </c:when>
								       <c:otherwise>
								          <tr class="text-center">
								       </c:otherwise>
								    </c:choose>
										<td class="align-middle" nowrap><a href="#"
											onclick="_OpenXLarge('<c:url value="/cgb_face_data/group_query_list?group_id=${checkList.group_id}&bzw=2" />','查看本组信息')">
												${checkList. group_id}</a></td>
										<td class="align-middle" nowrap>${checkList.victim_name}</td>
										<td class="align-middle" nowrap>${checkList.victim_card_type_disp}</td>
										<td class="align-middle" nowrap>${checkList.victim_card_num}</td>
										<td class="align-middle" nowrap>${checkList.victim_card_validity}</td>
										<td class="align-middle" nowrap>${checkList.risk_type_disp}</td>
										<td class="align-middle" nowrap>${checkList.busi_website}-${checkList.busi_website_disp}</td>
										<td class="align-middle" nowrap>${checkList.busi_teller_num}</td>
										<td class="align-middle" nowrap>${checkList.busi_time}</td>
										<td class="align-middle" nowrap>${checkList.busi_type}</td>
										<td class="align-middle" nowrap>${checkList.busi_way_disp}</td>
										<td class="align-middle" nowrap>${checkList.telephone}</td>
										<td class="align-middle" nowrap>${checkList.address}</td>
										<td class="align-middle" nowrap>${checkList.md_channel_disp}</td>
										<td class="align-middle" nowrap>${checkList.check_user_id}</td>
										<td class="align-middle" nowrap>
										    <c:choose>
										      <c:when test="${checkList.rm_flag =='2'}">
										                 出库通过
										      </c:when>
										      <c:when test="${checkList.rm_flag =='3'}">
										                 出库未通过
										      </c:when>
										      <c:when test="${checkList.check_result =='3'}">
										                 未通过
										      </c:when>
										      <c:otherwise>
						   				                 通过
										      </c:otherwise>
										   </c:choose>
										</td>
										<td class="align-middle" nowrap>${checkList.rm_user_id}</td>
										<td class="align-middle" nowrap>${checkList.rm_check_user_id}</td>
										<td class="align-middle" nowrap>${checkList.rm_check_time}</td>
										<td class="align-middle" nowrap>
										   <c:choose>
										      <c:when test="${fn:length(checkList.remark)>10}">
										         <a href="#" onclick="_tips(this,'${checkList.remark}')">${fn:substring(checkList.remark,0,5)}...</a>
										      </c:when>
										      <c:otherwise>
						   				         ${checkList.remark}
										      </c:otherwise>
										   </c:choose>
										</td>
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
<jsp:include page="../fragments/base_js.jsp"/>
    <script src="<c:url value='/resources/js/cgb/cgb.jquery.validator.js' />"></script>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器--></script>
	<script type="text/javascript">
	$('#myform').validateAll();
	//封装的一个JQuery小插件
    jQuery.fn.rowspan = function(colIdx) {
	return this.each(function(){
		var that;
		$('tr', this).each(function(row) {
			$('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {
				if (that!=null && $(this).html() == $(that).html()) {
					rowspan = $(that).attr("rowSpan");
					if (rowspan == undefined) {
						$(that).attr("rowSpan",1);
						rowspan = $(that).attr("rowSpan");
					}
					rowspan = Number(rowspan)+1;
					$(that).attr("rowSpan",rowspan);
					$(this).hide();
				} else {
					that = this;
				}
			});
		});
	});
}
    /**
     *初始化要合并的列
     */
  	   $(function() { 
  	     $("#gs").rowspan(0);
  	   }); 
    
  	
 	//重写的弹出大窗口
		function _OpenXLarge(url, title) {
			var w =  window.screen.availWidth-40;//屏幕可用工作区宽度-40
			var h =  window.screen.availHeight-80;//图片全显示高度-80
			agg.artDialog({
				title : title,
				url : url,
				width : w,
				height : h,
				onclose : function() {
					window.close();
				}
			});
		}
 	
 	//清空输入框的值
 	 function myreset(){
 		$("#victim_name").val("");
 		$("#victim_card_num").val("");
 		$("#busi_time_start").val("");
 		$("#busi_time_end").val("");
 		$("#busi_teller_num").val("");
 		$("#busi_website").val("");
 		$("#busi_type").val("");
 		$("#risk_type").val("");
 		$("#check_result").val("");
 		$("#md_channel").val("");
 	 }
 	
 	function _tips(obj, content) {
		agg.artDialogTips({
			content : content,
			width : 500,
			follow : obj,
			align : 'bottom left',
			quickClose : true
		})
	}
 	/** 验证提交
	 * @param url
	 * @param formname
	 */
	function vSubmit(url, formname) {
		var iframe = $("#" + formname);
		if (jQuery(iframe).isValid()) {
			document.forms[0].action = url;
			document.forms[0].submit();
		} else {
			return false;
		}
	}
	</script>
</body>
</html>