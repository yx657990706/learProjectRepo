<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp"/>
<!--page plugin:select下拉菜单/自动完成-->
		<link rel="stylesheet" href="<c:url value='/resources/js/lib/chosen/chosen.min.css' />" />
		<!--page plugin:select下拉菜单-复选框/查询/多选-->
		<link rel="stylesheet" href="<c:url value='/resources/js/lib/bootstrap/multiselect/bootstrap-multiselect.min.css' />" />
		<jsp:include page="../../fragments/base_css.jsp"></jsp:include>
		<link href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"  rel="stylesheet"  type="text/css" />
		<link href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"	rel="stylesheet" type="text/css" />
	</head>
<body>
<div id="page-content" class="page-content">
<fm:form class="form-horizontal" commandName="br40_city_no"   id="myForm"   action="modify"  method="POST">
	<rm:token />
	<span class="red"> <fm:errors  /></span>
	<div class="widget-box transparent">
		<div class="widget-header widget-header-flat">
			<h4 class="widget-title">
				<i class="ace-icon fa fa-star orange"></i>
				新增城市代号
			</h4>

			<div class="widget-toolbar">
				<a href="list">
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
							<label class="control-label col-xs-12 col-sm-4 no-padding-right" >对应银行：</label>
								<div class=" input-group col-xs-12 col-sm-8">
                            	<fm:select   path="other_organ" class="input-large"  items="${organMap}" require="true" datatype="require" />
								 </div>
								</div>
					        </div>
				    </div>
		      <div class="row">
					<div class="col-xs-12">

						<div class="form-group col-xs-12 col-sm-6">
							<label class="control-label col-xs-12 col-sm-4 no-padding-right" >城市代号：</label>
                       		
							<div class=" input-group col-xs-12 col-sm-8">
								<fm:input type="text" class="input-large"  path="cityno"   require="true" datatype="require|number" />

							</div>
							</div>
						<div class="form-group col-xs-12 col-sm-6">
							<label class="control-label col-xs-12 col-sm-4 no-padding-right">城市名称：</label>

							<div class="col-xs-12 col-sm-8">
								<fm:input type="text"  class="input-large"  path="cityname"   require="true" datatype="require|chinese" />
							</div>
						</div>

					</div>
				</div>

						<div class="row">
					<div class="col-xs-12">
						<div class="form-group col-xs-12 col-sm-12">
							<label class="control-label col-xs-12 col-sm-2 no-padding-right" >备注：</label>
								<div class=" input-group col-xs-12 col-sm-10">
                                <fm:textarea path="remark"   class="col-xs-10 col-sm-10 limited"  rows="3"  maxlength="100"/>
								 </div>
								</div>
					        </div>
				    </div>
				<div class=" form-actions text-center">
					<button class="btn btn-info btn-sm" type="button"  onclick="vSubmit('add','myForm')">
						<i class="ace-icon fa fa-check bigger-110"></i>
						提交						</button>
					&nbsp; &nbsp; &nbsp;
					<button class="btn btn-sm" type="button"   onclick="reset();re_do('myForm');">
						<i class="ace-icon fa fa-undo bigger-110"></i>
						重置					</button>
				</div>
		</div>
   </div>
    </div>
	</fm:form>
</div>
<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
		<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"><!--page plugin:datepicker日期选择器--></script>
		<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"> </script>
		<script src="<c:url value='/resources/js/lib/chosen/chosen.jquery.min.js' />"><!--page plugin:select下拉菜单/自动完成--></script>
		<script src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />"> </script><!--树-->
	<script	src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
		<script type="text/javascript">
		jQuery(document).ready(function(){
			 jQuery('#myForm').validateAll();
		 });
		/**
		 * 验证提交
		 * @param url
		 * @param formname
		 */
		function  vSubmit(url,formname)  {  
			var iframe =$("#"+formname); 
			if(jQuery(iframe).isValid()) {
		     	document.forms[0].action=url;
		    	 document.forms[0].submit();
			}else{
				agg.dialogAlert("验证未通过","face-smile");
				return false;
			}	
		}
		</script>
</body>
</html>