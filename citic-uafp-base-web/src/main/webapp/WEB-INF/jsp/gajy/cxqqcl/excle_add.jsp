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
        <link href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"	rel="stylesheet" type="text/css" />
        <link href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"  rel="stylesheet"  type="text/css" />  
</head>
<body>
<div class="page-content">
			<fm:form class="form-horizontal" commandName="br40_cxqq_excle"   id="myform"   action="importExcle"  method="POST" enctype="multipart/form-data">
			<rm:token />
			<!-- 隐藏域 -->
			<fm:input path="tasktype"  type="hidden"/>
			<fm:input path="qqdbs"  type="hidden"/>
            <fm:input path="rwlsh"  type="hidden"/>
            <fm:input path="qqcslx"  type="hidden"/>
            
			<div class="space-3"></div>
			<div class="widget-body">
				<div class="widget-main no-padding">
						<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label	class="control-label col-xs-4 col-sm-4 no-padding-right"></label>

											<div class="col-xs-8 col-sm-8 input-group">
												<fm:input type="file" class="input-xlarge" path="file" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label	class="control-label col-xs-4 col-sm-4 no-padding-right"></label>
											<div class=" col-xs-8 col-sm-8 input-group">
												<button class="btn btn-info btn-mini" type="button" id="submitForm" onclick="up_load('importExcle')" >
															<i class="ace-icon glyphicon glyphicon-upload"></i>
															导入
														</button>
											</div>
										</div>
									</div>
								</div>
					
				</div><!-- /.widget-main -->
			</div><!-- /.widget-body -->
	</fm:form>
	</div>
	
        <!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
		<script type="text/javascript">
		function  up_load(url){
			  var rwlsh = $("#rwlsh").val();
			  var tasktype = $("#tasktype").val();
	    	  var ex_file = $("#file").val();
	    	  var filename = ex_file;
	    	  if(ex_file==''){
	    		  agg.dialogAlert("Excle附件不能为空，请选择要上传的附件！","face-smile");
	    		  return false;
	    	  }else{
	    		  ex_file = ex_file.replace(/\\/g, "/");
	    		  var index = ex_file.lastIndexOf("/");
	    		  if(index!=-1){
	    			  filename = ex_file.substring(index+1);
	    		  }
	    		  var ok_name = tasktype+"_"+rwlsh+".xls";
	    		  if(ok_name!=filename){
	    			  agg.dialogAlert("请确认附件格式是xls并且任务流水号是该任务的！","face-smile");
		    		  return false;
	    		  }
	    	  }
	    	  
	    	  _submit(url);
	      }
	      
		</script>
		
</body>
</html>
