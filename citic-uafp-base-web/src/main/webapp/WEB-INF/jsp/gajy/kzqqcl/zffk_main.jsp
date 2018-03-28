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
<link  href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"   rel="stylesheet" type="text/css" />
</head>
<body>
  <div class="page-content">
  		<form  class="form-horizontal"  commandName="br41_kzqq_zf"  action="zffk_main"  id="form"  method="POST">
      <div class="row">
			<div class="col-sm-12">
				<div class="tabbable">
						 <ul class="nav nav-tabs padding-16" id="myTab">			
						<li class="active" id="li1">
						<a data-toggle="tab" href="#trans1" onclick="_changeIframe('<c:url value="/br41_kzqq_zf/zffk_disp?qqdbs=${br41_kzqq.qqdbs }&tasktype=${br41_kzqq.tasktype }&rwlsh=${br41_kzqq.rwlsh }" />','0901')">
						<i  class=" ace-icon fa fa-users red bigger-120"></i>反馈止付结果信息</a>
						</li>
							<!--判断如果是公安  添加反馈明细信息  -->
							<c:if test="${br41_kzqq.tasktype=='3'}">
						<li id="li2">
								<a data-toggle="tab"  href="#trans2"  onclick="_changeIframe('<c:url value="/br41_kzqq_zf_back/zf_mx_list?isNewSearch=1&qqdbs=${br41_kzqq.qqdbs}&rwlsh=${br41_kzqq.rwlsh}&tasktype=${br41_kzqq.tasktype}&zh=${br41_kzqq.zh}"/>','0902')" >
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>止付结果明细信息
								</a>
							</li> 
						</c:if>
				<div class="widget-toolbar" style="line-height: 34px">
						<button class="btn btn-info btn-sm" style="height: 33px" type="button"
									onclick="_OpenXLarge('<c:url value="/br41_kzqq/request_zf_disp?qqdbs=${br41_kzqq.qqdbs }&qqcslxs=${br41_kzqq.qqcslx }&tasktypes=${br41_kzqq.tasktype }"/>','请求信息')">
									<i class="ace-icon fa fa-folder-open"></i> 请求信息
								</button>&nbsp; 
						
						 	
								<a href="#"    onclick="_submit('<%=request.getContextPath() %>/br41_kzqq_zf/gajy_send_jg?qqdbs=${br41_kzqq.qqdbs }&rwlsh=${br41_kzqq.rwlsh }&tasktype=${br41_kzqq.tasktype}') "  >
		                                <i class="ace-icon glyphicon glyphicon-repeat orange"></i>
		                             <c:if test="${cbrc_check_flag=='1' }">提交</c:if>   
		                                   <c:if test="${cbrc_check_flag!='1' }">发送监管机构</c:if>     
		                        </a>&nbsp;&nbsp;
                        	
						<a href="<c:url value="/br41_kzqq_zf/deal_list?isNewSearch=1&tasktype=${br41_kzqq.tasktype }" />">
								<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
						</a>
						</div>
					</ul>
				</div>

				<div class="tab-content">
					<div id="trans1" class="tab-pane fade in active">
						<iframe src="<c:url value="/br41_kzqq_zf/zffk_disp?qqdbs=${br41_kzqq.qqdbs }&tasktype=${br41_kzqq.tasktype }&rwlsh=${br41_kzqq.rwlsh }" />" width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>
					</div>
							<!--判断如果是公安  添加反馈明细信息  -->
							<c:if test="${br41_kzqq.tasktype=='3'}">
							<div id="trans2" class="tab-pane fade">
								<iframe src="#" width="100%" height="500"     scrolling="auto" frameborder="0"  id="0902"></iframe>
							</div> 
							</c:if>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		</form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"></script><!--page plugin:datepicker日期选择器-->
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"></script>
	<script src="<c:url value='/resources/js/lib/chosen/chosen.jquery.min.js' />"></script><!--page plugin:select下拉菜单/自动完成-->
	<script src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"></script><!-- 文本域输入计数 -->
	<script src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"></script><!-- 文本域自适应高度 -->
	<script>
	 jQuery(document).ready(function(){
		 jQuery(document.forms[0]).validateAll();
		 _onchange();
	  });
     
	  function _onchange(){
			var msgtpe=$("#result option:selected").val();
			if(msgtpe=="0000"){
				$("#success").show();
				$("#fail").hide();
			}else{
				$("#fail").show();
				$("#success").hide();
			}
		}

		/**
		 * 验证提交
		 * @param url
		 * @param formname
		 */
		function vSubmit(url, formname) {
			var iframe = $("#" + formname);
			if (jQuery(iframe).isValid()) {
				$("#result").attr("disabled",false);
				document.forms[0].action = url;
				document.forms[0].submit();
			} else {
				agg.dialogAlert("验证未通过", "face-smile");
			}
		}


	</script>
</body>
</html>
