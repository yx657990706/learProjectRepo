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

<div class="page-content" id="page-content">
<fm:form class="form-horizontal" commandName="br40_cxqq_back"  action="save_data"  method="POST" id="myform">
            <!-- 隐藏域 -->
        <div class="row">
            <div class="col-xs-12">
                <div class="widget-box transparent">
                    <div class="widget-body">
                      	<div class="widget-main">
                      	     <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">任务流水号：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                           ${br40_cxqq_back.rwlsh }
                                        </div>
                                    </div>
                                      <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">反馈手机号码：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									      ${br40_cxqq_back.fksjhm }
									    </div>
                                    </div>
                                </div>
                            </div>
                             <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									     ${br40_cxqq_back.zh }
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.kh }
                                        </div>
                                    </div>
                                </div>
                            </div>
                               <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">执行起始时间：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									     ${br40_cxqq_back.zxqssj }
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">执行结束时间：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.jssj }
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-12 ">
                                      <label class="control-label col-xs-2 col-sm-2 no-padding-right">执行时间区间：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                        ${br40_cxqq_back.mxsdlx_disp}
                                        </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									       <fm:select  class="input-medium"  path="cxfkjg"  items="${cxfkjgMap}"  require="true" datatype="require"/>	
									    </div>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                <div class="form-group col-xs-12 col-sm-12 ">
                                     <label class="control-label col-xs-2 col-sm-2 no-padding-right">失败原因：</label>
                                       <div class="input-group  col-xs-10 col-sm-10 input-group">
                                         <fm:textarea class="col-xs-12 col-sm-10 limited" rows="4"  path="czsbyy" maxlength="500" require="true" datatype="require"></fm:textarea>
                                         <fm:input type="hidden" path="rwlsh"/>
                                          <fm:input type="hidden" path="qqdbs"/>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div> 
                          
                            <!-- /.widget-main -->
                        </div>
                        <!-- /.widget-body -->
                    </div>
                  
                    <div class="clearfix form-actions text-center">
                        <button class="btn btn-info btn-sm" type="submit"  onclick="vSubmit('<c:url value="/br40_cxqq_mx/save_data"/>','myform')">
                            <i class="ace-icon fa fa-check bigger-110"></i> 提交
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-sm" type="button"   onclick="reset();re_do('myform');">
                            <i class="ace-icon fa fa-undo bigger-110"></i>  重置
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </fm:form>
</div>
        <!-- basic scripts -->
		
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
		<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"><!--page plugin:datepicker日期选择器--></script>
		<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"> </script>
		<script	src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
	    <script	src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"><!-- 文本域自适应高度 --></script>
	    <script src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />"> </script><!--树-->
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
 				document.forms[0].action=url;
 				document.forms[0].submit();
 			} else {
 				agg.dialogAlert("验证未通过","face-smile");
 			} 
 		}
        </script>
</body>
</html>
