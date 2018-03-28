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
	href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />" rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content" id="page-content">
		<fm:form id="myform" commandName="cgb_face_data" class="form-horizontal" action="modify" method="POST"   >
			<div class="row">
				<div class="col-xs-12">
					<div class="widget-box transparent">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
								<div class="space-10"></div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												被冒用人姓名：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input path="victim_name" class="input-large"
													require="true" datatype="require" type="text" maxlength="32"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												被冒用人证件类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:select path="victim_card_type" class="input-medium" items="${victim_card_typeMap}"
													require="true" datatype="require" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												被冒用人证件号码：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input type="text" path="victim_card_num" 
													class="input-large" require="true" datatype="require|safeString|idCard" maxlength="18"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												风险类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:select path="risk_type" class="input-medium"  items="${risk_typeMap}"
													require="true" datatype="require" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">
												业务办理网点：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<div class=" input-group col-xs-12 col-sm-10">
													<fm:input path="busi_website_disp" class=" input-large" 
														onchange="_changeOrganId('busi_website_disp','busi_website');_changebur('busi_website')" />
													<a href="#"
														onclick="selectTreeByCode('busi_website_disp', '../selectOrganByCode')"
														title="选择网点"> <i class="glyphicon glyphicon-search "></i>
													</a>
													<fm:hidden path="busi_website"  require="true" datatype="require|numLen" maxlength="6" para="办理网点" />
												</div>
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
											被冒用人证件有效期：</label>
											<div class="input-group  col-xs-12 col-sm-8 ">
													<fm:input  type="text"  class="input-medium"  path="victim_card_validity" require="true" datatype="require|date_8" maxlength="8"/>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												业务办理柜员号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input path="busi_teller_num" class="input-medium" type="text" require="true" datatype="require|numLen" maxlength="8" para="柜员号"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">
												业务办理时间：</label>
											<div class="input-group  col-xs-12 col-sm-8 ">
												<fm:input type="text"  class="input-medium" path="busi_time" require="true" datatype="require|date_8" maxlength="8"/>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">联系地址：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input path="address" class=" input-large"  type="text" maxlength="64"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6"
											id="channeldesc_id2">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">业务办理渠道：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:select path="busi_way" class=" input-medium"  items="${busi_wayMap}"/>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">联系电话：</label>
											<div class="col-xs-12 col-sm-8 input-group">
												<fm:input path="telephone" class=" input-large" require="true" datatype="mobile"
													type="text" maxlength="11"/>
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">业务办理类型：</label>
											<div class="col-xs-12 col-sm-8 input-group">
											    <fm:input path="busi_type" class="input-medium" type="text" require="true" datatype="limit_max" max="6"/>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label
												class="control-label col-xs-2 col-sm-2 no-padding-right">其他说明：</label>
											<div class="col-xs-10 col-sm-10 ">
												<fm:textarea rows="3" class="col-xs-10 col-sm-10 limited"
													path="remark" maxlength="128"></fm:textarea>
											</div>
										</div>
									</div>
								</div>
							
								<!-- /.widget-main -->
							</div>
							<!-- /.widget-body -->
						</div>
						<div class="clearfix form-actions text-center">
							<button class="btn btn-info btn-sm" type="button"
								onclick="vSubmit('<c:url value="/cgb_face_data/modify?suspect_img_id=${cgb_face_data.suspect_img_id}"/>','myform')">
								<i class="ace-icon fa fa-check bigger-110"></i> 保存
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn btn-sm" type="button"
								onclick="reset();re_do('myform');">
								<i class="ace-icon fa fa-undo bigger-110"></i> 重置
							</button>
						</div>
					</div>
				</div>
			</div>
		</fm:form>
	</div>
	<jsp:include page="../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器--></script>
	<script src="<c:url value='/resources/js/cgb/cgb.jquery.validator.js' />"></script>
	<script src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />"></script>
	<script
		src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
	<script
		src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"><!-- 文本域自适应高度 --></script>
	<script type="text/javascript">
	jQuery(document).ready(function(){
		$('#myform').validateAll();

		//屏蔽backspace返回上一页
		document.getElementsByTagName("body")[0].onkeydown=function(){
			if(event.keyCode==8){//判断按键为backSpace键
				var elem = event.srcElement||event.currentTarget;//获取光标指向的element
			    var t = elem.type||elem.getAttribute('type');//获取事件类型
			    if(t==null){
			    	return false;
			    }else{
			    	 //判断是否需要阻止按下键盘的事件默认传递
				    if(t.toUpperCase()!="TEXT"&&t.toUpperCase() != "TEXTAREA"){
				    	return false;
				    }
			    }
			}
		}
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
		
		function _changebur(para){
			var obj=$('#'+para);
			obj.blur();
		}
		
	</script>
</body>
</html>