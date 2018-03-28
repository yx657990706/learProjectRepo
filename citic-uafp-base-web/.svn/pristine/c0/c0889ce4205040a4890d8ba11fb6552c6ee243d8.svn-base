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
<jsp:include page="../fragments/base_css.jsp" />
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="cgb_face_data"
					action="add_list" method="POST">
					<input type="hidden"  id="url"  name="url" />
					<input type="hidden"  id="delurl"  name="delurl" />
					<input type="hidden" id="re_url" name="re_url"
						value="<c:url value="/cgb_face_data/add_list?isNewSearch=1"/>" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								名单新增
							</h5>
							<div class="widget-toolbar">
								<a href="add"> <i class="ace-icon fa fa-plus-circle orange"></i>
									添加
								</a> <a href="#" onclick="do_tj('<c:url value="/cgb_face_data/person_add" />','确认提交该组数据?');"> <i
									class="ace-icon fa fa-plus-circle orange"></i> 组提交
								</a> <a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i></a>
							</div>
						</div>
						<!-- /.widget-body -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<ul class="ace-thumbnails clearfix">
									<c:forEach items="${cgb_face_dataList}" var="dataList">
										<li><a href="#" data-rel="colorbox"> <img width="240"
												height="240" alt="240x240" src="${dataList.img_base64}" />
												<div class="text">
													<div class="inner">
														<div style="text-align: left">被冒用人证件类型：${dataList.victim_card_type_disp}</div>
														<div style="text-align: left">被冒用人证件号码：${dataList.victim_card_num}</div>
														<div style="text-align: left">被冒用人姓名：${dataList.victim_name}</div>
														<div style="text-align: left">被冒用人证件有效期：${dataList.victim_card_validity }</div>
														<div style="text-align: left">风险类型：${dataList.risk_type_disp}</div>
														<div style="text-align: left">办理网点：${dataList.busi_website}</div>
														<div style="text-align: left">办理柜员：${dataList.busi_teller_num}</div>
														<div style="text-align: left">办理时间：${dataList.busi_time}</div>
														<div style="text-align: left">办理类型：${dataList.busi_type}</div>
													</div>
												</div>
												<div class="tags">
													<span class="label-holder">
														<div class="checkbox">
															<label><input type="checkbox" class="ace" name="keys" value="${dataList.suspect_img_id}" /><span
																class="lbl"></span> </label>
														</div>
													</span>
												</div>
												<div class="tools tools-top">
													<a href="#"
														onclick="to_open('<c:url value="/cgb_face_data/${dataList.suspect_img_id}/modify" />','修改名单信息')">
														<i class="ace-icon fa fa-pencil"></i>
													</a> <a href="#"
														onclick="_delSubmit('<c:url value="/cgb_face_data/${dataList.suspect_img_id}/delete" />')">
														<i class="ace-icon fa fa-times red"></i>
													</a>
												</div>
										</a></li>
									</c:forEach>
								</ul>
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

	<jsp:include page="../fragments/base_js.jsp" />
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	<script type="text/javascript">

	function myOkDo() {
		_submit($("#url").val());
	}
		function to_open(url, title) {//弹出大窗
			var re_url = $("#re_url").val();
			var w =  window.screen.availWidth-80;//屏幕可用工作区宽度-80
			agg.artDialog({
				title : title,
				url : url,
				width : w,
				height : '550',
				onclose : function() {
					_submit(re_url);
				}
			});
		}
		//弹出大窗口
		function _OpenXLarge(url, title) {
			agg.artDialog({
				title : title,
				url : url,
				width : '980',
				height : '550',
				onclose : function() {
					window.close();
				}
			});
		}
		
		//提交
		function do_tj(url,title) {
			var num = 0;
			$("input[type='checkbox']").each(function() {
				if(this.checked) {
					if($(this).val() != 'on') {
						num++;
					}
				}
			});
			 if(num<1){
	                agg.dialogAlert("请至少选择1条记录！", "face-smile");
	                return false;
	            }
			 if(num>5){
	                agg.dialogAlert("一组至多选择5条记录！", "face-smile");
	                return false;
	            }
			 $("#url").val(url);
        	 agg.dialogConfirm(title,myOkDo,closeDo);
		}
	</script>


</body>
</html>