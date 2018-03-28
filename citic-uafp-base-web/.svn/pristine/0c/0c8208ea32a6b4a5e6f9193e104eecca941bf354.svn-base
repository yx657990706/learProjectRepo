<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<title></title>
	<jsp:include page="../../fragments/base_css.jsp"/>
	    <!--page plugin:summernote富文本编辑器-->
    <link rel="stylesheet" href="<c:url value='/resources/js/lib/summernote/summernote.css'  />" />

</head>

<body>
<div class="page-content">

	<fm:form class="form-horizontal" commandName="br41_kzqq_hzws"   id="myForm">
	 <fm:hidden path="wskey"/>
	  <fm:hidden path="qqdbs"/>
	  <fm:hidden path="rwlsh"/>
	  <fm:hidden path="tasktype"/>
	  <fm:hidden path="htmlstr"/>
	<div class="widget-box transparent">
		<div class="widget-header widget-header-flat">
			<h4 class="widget-title">
				<i class="ace-icon fa fa-star orange"></i>
				修改回执文书
			</h4>

			<div class="widget-toolbar">
				<a href="#"  onclick="_submit('hzws_list?tasktype=${br41_kzqq_hzws.tasktype}&rwlsh=${br41_kzqq_hzws.rwlsh}&qqdbs=${br41_kzqq_hzws.qqdbs}')">
					<i class="ace-icon fa fa-arrow-circle-left blue"></i>&nbsp;返回
				</a>
				<a href="#" data-action="collapse">
					<i class="ace-icon fa fa-chevron-up"></i>
				</a>
			</div>
		</div>
		<div class="widget-body">
			<div class="widget-main no-padding">
				<div class="space-8"></div>
		<div class="row">
					<div class="col-xs-12">

						<div class="form-group col-xs-12 col-sm-12">
							<label class="control-label col-xs-12 col-sm-2 no-padding-right" > 文件名：</label>

							<div class="col-xs-12 col-sm-4">
								<fm:input type="text"  class="input-medium"  path="wjmc"  />

							</div>
							<%-- <label class="control-label col-xs-12 col-sm-2 no-padding-right">关联文书:</label>

							<div class="col-xs-12 col-sm-4">
								<fm:select class=" input-medium"   path="wsbh" items="${wjMap}"  />
							</div> --%>
						</div>

					</div>
				</div>

			    <div class="summernote" id="summernote" >
			        ${br41_kzqq_hzws.sqlstr}
                       </div>
				
				<div class=" form-actions text-center">

					<button class="btn btn-info btn-sm" type="button"  onclick="_vsubmit('modify?flag=0')">
						<i class="ace-icon fa fa-check bigger-110"></i>
						保存					</button>
					&nbsp; &nbsp; &nbsp;
					  <button class="btn btn-sm" type="button" onclick="_vsubmit('modify?flag=1')">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        保存并生成pdf
                    </button>
					

				</div>


			</div><!-- /.widget-main -->
		</div><!-- /.widget-body -->
		</div>

	</fm:form>

</div>


	<jsp:include page="../../fragments/base_js.jsp"/>
	<script src="<c:url value='/resources/js/lib/summernote/summernote.min.js' />"></script>
	<script src="<c:url value='/resources/js/lib/summernote/summernote-zh-CN.js' />"></script>

		<script type="text/javascript">
		   function _vsubmit(url){
			    if($("#wsmc").val()==""){
			    	agg.dialogAlert("文件名称不能为空！", "face-smile");	
			    	return false;
			    }
		        var sHTML = $('.summernote').code();
		          $("#htmlstr").val(sHTML);
		        _submit(url);
		    }


	
		
		</script>


</body>
</html>