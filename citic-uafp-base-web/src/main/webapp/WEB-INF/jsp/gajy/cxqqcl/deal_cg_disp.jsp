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
</head>
<body>

<div class="page-content" id="page-content">
<fm:form class="form-horizontal" commandName="br40_cxqq_back"  action="save_data"  method="POST" id="myform">
            <!-- 隐藏域 -->
            <input type="hidden"  id="d_file_name"  name="d_file_name" />
		    <input type="hidden"  id="d_file_path"  name="d_file_path" />
		    <input id="r_url" name="r_url" type="hidden" value="<c:url value="/br40_cxqq_mx/deal_cg_disp?qqcslx=${br40_cxqq_back.qqcslx}&tasktype=${br40_cxqq_back.tasktype}&cxnr=${br40_cxqq_back.cxnr}" />">
		    <fm:input type="hidden" path="rwlsh"/>
            <fm:input type="hidden" path="qqdbs"/>
		    <div class="row">
				<div class="col-xs-12">
					<div class="form-group" style="float:right">
						<a href="#" onclick="excleDownload('<c:url value="/br40_cxqq_back/export?tasktype=${br40_cxqq_back.tasktype}&cxnr=${br40_cxqq_back.cxnr}"/>')"><i class="ace-icon glyphicon glyphicon-download green"></i>模板下载</a>
						&nbsp;&nbsp;<a href="#" onclick="excleUpload('<c:url value="/br40_cxqq_back/importExcle?tasktype=${br40_cxqq_back.tasktype}&qqdbs=${br40_cxqq_back.qqdbs}&rwlsh=${br40_cxqq_back.rwlsh}&qqcslx=${br40_cxqq_back.qqcslx}"/>','查询结果Excle上传')"><i class="ace-icon glyphicon glyphicon-upload red"></i>数据上传</a>
						&nbsp;&nbsp;<a href="#" onclick="_download('${br40_cxqq_back.filepath}','${br40_cxqq_back.filename}')"><i class="ace-icon glyphicon glyphicon-file blue"></i>数据下载</a>
					</div>
				</div>
			</div>
			
        <div class="row">
            <div class="col-xs-12">
                <div class="widget-box transparent">
                    <div class="widget-body">
                      	<div class="widget-main">
                      	     <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">请求单标识：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									      ${br40_cxqq_back.qqdbs }
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">任务流水号：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                           ${br40_cxqq_back.rwlsh }
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">申请机构代码：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									     ${br40_cxqq_back.sqjgdm }
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">目标机构代码：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.mbjgdm }
                                        </div>
                                    </div>
                                </div>
                            </div>
                              
                            <div class="row">
                                <div class="col-xs-12">
                                 <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">查询主体类别：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									      ${br40_cxqq_back.ztlb_disp}
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">查询内容：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.cxnr_disp }
                                        </div>
                                    </div>
                                          </div>
                                </div>
                                     <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">主体名称：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									     ${br40_cxqq_back.ztmc }
									    </div>
                                    </div>
                                     <c:if test="${br40_cxqq_back.zzhm!='' }">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">证件号码：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.zzlx_disp }      ${br40_cxqq_back.zzhm }
                                        </div>
                                    </div>
                                    </c:if>
                                </div>
                            </div>
                                 <c:if test="${br40_cxqq_back.mxqssj!='' }">
                                  <div class="row">
                                <div class="col-xs-12">
                                 <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">查询开始时间：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									      ${br40_cxqq_back.mxqssj}
									    </div>
                                    </div>
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">查询结束时间：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         ${br40_cxqq_back.mxjzsj }
                                        </div>
                                    </div>
                                          </div>
                                </div>
                                </c:if>
                                	<c:if test="${br40_cxqq_back.deal_reason!=''}">
												<div class="row">
											<div class="col-xs-12">
										
												<div class="form-group col-xs-12 col-sm-12">
													<label
														class="control-label col-xs-2 col-sm-2 no-padding-right">退回原因：</label>
													<div class="col-xs-8 col-sm-8 input-group">${br40_cxqq_back.deal_reason}</div>
												</div>
								
									
											</div>
										</div>
										</c:if>
                             <c:if test="${br40_cxqq_back.cxzh!='' }">
                                     <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right"> 查询账卡号：</label>
									    <div class=" col-xs-12 col-sm-8 ">
									     ${br40_cxqq_back.cxzh }
									    </div>
                                    </div>
    
                                    <div class="form-group col-xs-12 col-sm-6 ">
                                      <label class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
                                        <div class="col-xs-12 col-sm-8 ">
                                         <fm:input path="kh"    class="input-large" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                     
                               <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group col-xs-12 col-sm-12 ">
                                        <label class="control-label col-xs-2 col-sm-2 no-padding-right">查询结果：</label>
									    <div class=" col-xs-12 col-sm-10 ">
									       <fm:select  class="input-medium"  path="cxfkjg"  items="${cxfkjgMap}"  require="true" datatype="require"/>	
									    </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                <div class="form-group col-xs-12 col-sm-12 ">
                                     <label class="control-label col-xs-2 col-sm-2 no-padding-right">查询反馈结果原因：</label>
                                       <div class="input-group  col-xs-10 col-sm-10 input-group">
                                         <fm:textarea class="col-xs-12 col-sm-10 limited" rows="4"  path="czsbyy" maxlength="500" ></fm:textarea>
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
                            <i class="ace-icon fa fa-check bigger-110"></i> 保存
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
 				document.forms[0].action=url;
 				document.forms[0].submit();
 			} else {
 				agg.dialogAlert("验证未通过","face-smile");
 			} 
 		}
 		//Excle模板下载（文件名根据流水号生成）
 		function excleDownload(url) {
 			var orgAction = document.forms[0].action;
 			document.forms[0].action=url;
 			document.forms[0].submit();
 			document.forms[0].action= orgAction;
 		}
 		//Excle数据上传
 		function excleUpload(url,title){
 			 var r_url = $("#r_url").val();
 	      	  agg.artDialog({
 	      			title:title,
 	      			url:url,
 	      			width:'600',
 	      			height:'400',
 	      			onclose: function () {
 	      				_submit(r_url);
 	      			}
 	      		});
 		}
 		
 		 //get方式提交表单
	    function _submit_get(url){
 			 
 			   alert(url);//========
 			   
	    	   document.forms[0].method="GET";
	    	   document.forms[0].action=url;
			   document.forms[0].submit();
	    }
        </script>
</body>
</html>
