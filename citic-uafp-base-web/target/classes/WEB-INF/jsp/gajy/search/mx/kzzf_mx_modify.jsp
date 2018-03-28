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
<jsp:include page="../../../fragments/base_css.jsp" />

<link	href="<c:url value='/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.min.css ' />"  rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="page-content" class="page-content">
		<fm:form class="form-horizontal" commandName="br41_kzqq_zf_back_mx" id="myForm" action="save_modify" method="POST">
			<fm:hidden path="rwlsh" />
			<fm:hidden path="qqdbs" />
			<fm:hidden path="zh" />
			<fm:hidden path="tasktype" />
			<fm:hidden path="zzhxh" />
			<fm:hidden path="organkey" />
			<rm:token />
			<span class="red"> <fm:errors /></span>
			<div class="widget-box transparent">
				<div class="widget-header widget-header-flat">
					<h4 class="widget-title">
						<i class="ace-icon fa fa-star orange"></i> 修改止付明细信息
					</h4>
						<div class="widget-toolbar">
						<a
							href="#"  onclick="_submit('zf_mx_list')">
							<i class="ace-icon fa fa-arrow-circle-left blue"></i>&nbsp;返回
						</a>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main no-padding">
						<div class="space-8"></div>
						<div class="row">
							<div class="col-xs-12">
					
									<div class="form-group col-xs-12 col-sm-6">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">账户子账号：</label>
									<div class="col-xs-12 col-sm-8 input-group">
										<fm:input type="text" class="input-large" path="zhzzh"   require="true" 	datatype="require" />
									</div>
								</div>
											<div class="form-group col-xs-12 col-sm-6">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">子账号余额：</label>
									<div class="col-xs-12 col-sm-8 input-group">
										<fm:input type="text" class="input-large" path="zzhye"
											require="true" datatype="require|double" />
									</div>
								</div>
							</div>
						</div>

					
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group col-xs-12 col-sm-6">
								<label class="control-label col-xs-12 col-sm-4 no-padding-right">钞汇标志：</label>
								<div class="col-xs-12 col-sm-8 input-group">
									<fm:input type="text" class="input-large" path="chbz"/>
								</div>
							</div>
							<div class="form-group col-xs-12 col-sm-6">
								<label class="control-label col-xs-12 col-sm-4 no-padding-right">核心止付编号：</label>
								<div class="col-xs-12 col-sm-8 input-group">
									<fm:input path="hxappid" class="input-large"  />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12">
							<div class="form-group col-xs-12 col-sm-6">
								<label class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
								<div class="col-xs-12 col-sm-8 input-group">
									<fm:select path="zxjg" class="input-medium" items="${zxjgMap }"
										require="true" datatype="require" msg="请输入" />
								</div>
							</div>
							  <div class="form-group col-xs-12 col-sm-6">
													<label class="control-label col-xs-12 col-sm-4 no-padding-right" >止付开始时间：</label>							
													<div class="input-group col-xs-12 col-sm-6">					
                                                 	<fm:input class="form-control date-picker"	  path="zfkssj"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>										
													</div>
												</div>
						
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group col-xs-12 col-sm-6">
								<label class="control-label col-xs-12 col-sm-4 no-padding-right">币种：</label>
								<div class="col-xs-12 col-sm-8 input-group">
									<fm:select path="bz" class="input-medium" items="${bzMap }"
										require="true" datatype="require|english" />
								</div>
							</div>
									  <div class="form-group col-xs-12 col-sm-6">
													<label class="control-label col-xs-12 col-sm-4 no-padding-right" >止付结束时间：</label>							
													<div class="input-group col-xs-12 col-sm-6">					
                                                    	<fm:input class="form-control date-picker"	 path="zfjssj"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>										
													</div>
												</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group col-xs-12 col-sm-12">
								<label class="control-label col-xs-12 col-sm-2 no-padding-right">执行失败原因：</label>
								<div class="col-xs-12 col-sm-8 input-group">
									<fm:textarea path="zxjgyy" class="col-xs-10 col-sm-10 limited"
										rows="3" maxlength="100" />
								</div>
							</div>
						</div>
					</div>
						<div class=" form-actions text-center">
							<button class="btn btn-info btn-sm" type="button"
								onclick="vSubmit('<c:url value="/br41_kzqq_zf_back/save_modify"/>','myForm')">
								<i class="ace-icon fa fa-check bigger-110"></i> 提交
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn btn-sm" type="button"
								onclick="reset();re_do('myForm');">
								<i class="ace-icon fa fa-undo bigger-110"></i> 重置
							</button>
						</div>
					</div>
				</div>
			</div>
		</fm:form>
	</div>

<!-- basic scripts -->
		<jsp:include page="../../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"> </script>
	<script
		src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
	<script
		src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"><!-- 文本域自适应高度 --></script>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
	<!--    <script type="text/javascript">
    $(".datetimepicker").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
</script> -->
	<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery('#myForm').validateAll();
		});
		function _changebur(para){
			var obj=$('#'+para);

			obj.blur();
		}

		/**
		 * 验证提交
		 * @param url
		 * @param formname
		 */
/* 		function vSubmit(url, formname) {
			var iframe = $("#" + formname);
			if (jQuery(iframe).isValid()) {
				document.forms[0].action = url;
				document.forms[0].submit();
			} else {
				agg.dialogAlert("验证未通过", "face-smile");
				return false;
			}
		} */
		
		function vSubmit(url, formname) {
			var iframe = $("#" + formname);  
	     var result=$("#zxjg").val();
	     if(result==""){
	    	 agg.dialogAlert("执行结果不能为空", "face-smile");
	    	 return false;
	     }
		 if(result=="0"){   //成功
			if (jQuery(iframe).isValid()) {
				document.forms[0].action = url;
				document.forms[0].submit();
			} else {
				agg.dialogAlert("验证未通过", "face-smile");
				return false;
			}
		 }else{
				var reason=$("#zxjgyy").val();
			    	if(reason==""){
			    		agg.dialogAlert("失败原因不能为空","face-smile");
			    		return false;
			    	}
					document.forms[0].action = url;
					document.forms[0].submit();
		 }
		}
	</script>

</body>
</html>