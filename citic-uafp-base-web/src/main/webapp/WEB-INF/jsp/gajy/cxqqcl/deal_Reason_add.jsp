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
		<title> 原因 </title> 
		<jsp:include page="../../fragments/base_css.jsp"></jsp:include>

</head>
<body>
    <div class="page-content">
    		
	<!-- 导航 -->
<fm:form id="myform" class="form-horizontal"  commandName="br40_cxqq_back"  >
			<rm:token />
   <!-- 隐藏属性 -->
   <fm:hidden path="qqdbs"  />
      <fm:hidden path="rwlsh"  />
      <fm:hidden path="tasktype"  />
            <fm:hidden path="seq"  />
	<!-- 右侧内容 -->
	<div class="row">
		<div class="col-xs-12">

			<!-- PAGE CONTENT BEGINS -->
			
				<div class="form-group">
					<label class="col-xs-1 col-sm-1 control-label text-right no-padding-right" ></label>
					<div class="col-xs-9 col-sm-9">
						  <fm:textarea path="deal_reason" class="col-xs-11 col-sm-11 limited" rows="6"  maxlength="100"/>
					</div>
				</div>
				
				
			

				<div class=" form-actions text-center">

					<button class="btn btn-info btn-sm" type="button" id="submitForm" >
						<i class="ace-icon fa fa-check bigger-110"></i>
						提交						</button>

				</div>
		
			<!-- PAGE CONTENT ENDS -->

		</div><!-- /.col -->
	</div><!-- /.row -->
	</fm:form>
</div>
 <!-- basic scripts -->
 <jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script  src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"></script>
 <script type="text/javascript">
	$(function(){
	 $('#submitForm').on('click',function(){ 
	 var namestr= $('#deal_reason').val();
	 if (namestr == "") {
			agg.dialogAlert("处理原因不能为空！ ");
			return false;
		}	
	 
	 document.forms[0].action ="gajy_check_returnBack";
		document.forms[0].submit();
	 });
    })
	</script>
</body>
</html>