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
<jsp:include page="../../fragments/base_css.jsp" />
</head>
<body>
<div class="page-content">
    <div class="row">
			<div class="col-sm-12">
				<fm:form class="form-horizontal" commandName="br41_kzqq_zf_back" action="zffk_save" method="POST" id="myform" >
					<!-- 右侧内容 -->
					<div class="row">
						<div class="col-sm-12">
							<div class="widget-box transparent">
								<div class="widget-body">
									<div class="widget-main no-padding">
										<!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-6 col-sm-6">
													<label
														class="control-label col-xs-4 col-sm-4 no-padding-right">请求单标识：</label>
													<div class="col-xs-8 col-sm-8 input-group">${br41_kzqq_zf_back.qqdbs}</div>
												</div>
												<div class="form-group col-xs-6 col-sm-6">
													<label
														class="control-label col-xs-4 col-sm-4 no-padding-right">任务流水号：</label>
													<div class="col-xs-8 col-sm-8 input-group">${br41_kzqq_zf_back.rwlsh}</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_zf_back.zh}</div>
												</div>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_zf_back.kh}</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">执行措施的时间：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_zf_back.zxqssj}</div>
												</div>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">状态：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_zf_back.status_disp}</div>
												</div>
											</div>
										</div>
											<c:if test="${br41_kzqq_dj_back.deal_reason!=''}">
												<div class="row">
											<div class="col-xs-12">
										
												<div class="form-group col-xs-12 col-sm-12">
													<label
														class="control-label col-xs-2 col-sm-2 no-padding-right">退回原因：</label>
													<div class="col-xs-8 col-sm-8 input-group">${br41_kzqq_dj_back.deal_reason}</div>
												</div>
								
									
											</div>
										</div>
										</c:if>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
													<div class="col-xs-12 col-sm-8 input-group">
														<fm:input type="hidden" class="input-large" path="qqdbs" />
														<fm:input type="hidden" class="input-large" path="rwlsh" />
														<fm:input type="hidden" class="input-large" path="tasktype" />
														<fm:select label="执行结果：" type="text" class="input-medium"
															path="zxjg" items="${zxjgMap }" require="true" datatype="require" />
													</div>
												</div>

											</div>
										</div>

										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-12">
													<label
														class="control-label col-xs-2 col-sm-2 no-padding-right">失败原因：</label>
													<div class="input-group  col-xs-10 col-sm-5 input-group">
														<fm:textarea class="col-xs-12 col-sm-10 limited" rows="4"
															path="sbyy" maxlength="500"></fm:textarea>
													</div>
												</div>
											</div>
										</div>


									</div>
									<div class="clearfix form-actions text-center">
										<button class="btn btn-info btn-sm" type="button" id="subform"
											onclick="vSubmit('zffk_save','myform')">
											<i class="ace-icon fa fa-check bigger-110"></i> 保存
										</button>
										&nbsp; &nbsp; &nbsp;
										<button class="btn btn-sm" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> 重置
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</fm:form>
			</div>

		</div>
	</div>
	 <!-- basic scripts -->
        <jsp:include page="../../fragments/base_js.jsp"></jsp:include>
		<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"><!--page plugin:datepicker日期选择器--></script>
		<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"> </script>
		<script	src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
	    <script	src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"><!-- 文本域自适应高度 --></script>
	<script>
          jQuery(document).ready(function(){
             jQuery('#myform').validateAll();
           }); 
 		/**
 		 * 验证提交
 		 * @param url
 		 * @param formname
 		 */
 		function  vSubmit(url,formname)  {
 			var iframe =$("#"+formname);
 			if(jQuery(iframe).isValid()) {
 				    var result=$("#zxjg").val();
 				    if(result=="1"){
 				    	var reason=$("#sbyy").val();
 				    	if(reason==""){
 				    		agg.dialogAlert("失败原因不能为空","face-smile");
 				    		return false;
 				    	}
 				    }
 				document.forms[0].action=url;
 				document.forms[0].submit();
 			} else {
 			agg.dialogAlert("验证未通过","face-smile");
 			} 
 		}
        </script>
        
     <!--  <script type="text/javascript"> 
  $(function() { 
  $('#subform').click(function() { 
    $('#myform').submit(); 
    $('div:has(iframe)', parent.document).hide(); 
    parent.window.location.reload(); 
  }); 
}) 
</script> -->
</body>
</html>