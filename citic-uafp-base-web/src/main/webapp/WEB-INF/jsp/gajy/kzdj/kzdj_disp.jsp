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
<link	href="<c:url value='/resources/js/lib/bootstrap/datepickermin/bootstrap-datetimepicker.min.css ' />"  rel="stylesheet" type="text/css" />
<link  href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"   rel="stylesheet" type="text/css" />
</head>

<body>
<div class="page-content">
<div class="row">
	<div class="col-sm-12">
				<fm:form class="form-horizontal" commandName="br41_kzqq_dj_back"
					action="kzdj_save" method="POST" id="myform">
					
							<fm:input  type="hidden"  class="input-large" path="qqdbs"/> 
						<fm:input  type="hidden"  class="input-large" path="rwlsh"/> 
					<fm:input  type="hidden"  class="input-large" path="tasktype"/> 
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
													<div class="col-xs-8 col-sm-8 input-group">${br41_kzqq_dj_back.qqdbs}</div>
												</div>
												<div class="form-group col-xs-6 col-sm-6">
													<label
														class="control-label col-xs-4 col-sm-4 no-padding-right">任务流水号：</label>
													<div class="col-xs-8 col-sm-8 input-group">${br41_kzqq_dj_back.rwlsh}</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_dj_back.zh}</div>
												</div>
															<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">冻结方式：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_dj_back.djfs_disp}</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
										
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">申请冻结金额：</label>
													<div class="col-xs-12 col-sm-8 input-group">${br41_kzqq_dj_back.sqdjxe}</div>
												</div>
								
												
													<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input  path="kh"  class="input-large"  /> 
												   </div>
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

													<fm:select label="执行结果："  class="input-medium" path="zxjg" items="${zxjgMap }" require="true" datatype="require"/> 
													</div>
												</div>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">执行冻结金额：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input label="执行冻结金额：" type="text"  path="sdje"  class="input-large" require="true" datatype="require"/> 
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">账户余额：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input label="账户余额：" type="text"  class="input-large" path="ye" require="true" datatype="require"/> 
													</div>
												</div>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">账户可用金额：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input label="账户可用金额："  type="text"   path="zhkyye"  class="input-large" require="true" datatype="require"/> 
													</div>
												</div>
											</div>
										</div>
										
										  <div class="row">
                                        <div class="col-xs-12">
                                           <div class="form-group col-xs-12 col-sm-6">
													<label class="control-label col-xs-12 col-sm-4 no-padding-right" >执行起始时间：</label>							
													<div class="input-group col-xs-12 col-sm-6">					
                                                    	 <fm:input class="form-control date-picker"   path="zxqssj"  data-date-format="yyyy-mm-dd" />
                                                   <span class="input-group-addon">
                                                 <i class="fa fa-calendar bigger-110"></i>
                                                   </span>										
													</div>
												</div>
												  <div class="form-group col-xs-12 col-sm-6">
													<label class="control-label col-xs-12 col-sm-4 no-padding-right" >执行结束日期：</label>							
													<div class="input-group col-xs-12 col-sm-6">					
                                                    	 <fm:input class="form-control date-picker"   path="djjsrq" data-date-format="yyyy-mm-dd"  />
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
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">在先冻结机关：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input  class="input-large" path="djjg" /> 
													</div>
												</div>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">在先冻结金额：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input  path="djje"  class="input-large" /> 
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-xs-12">
									
												   <rm:singleDate label="在先冻结到期日：" path="djjzrq"></rm:singleDate>
												<div class="form-group col-xs-12 col-sm-6">
													<label
														class="control-label col-xs-12 col-sm-4 no-padding-right">未冻结金额：</label>
													<div class="col-xs-12 col-sm-8 input-group">
													<fm:input label="未冻结金额："  type="text"   path="wdjje"  class="input-large" /> 
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-12">
													<label
														class="control-label col-xs-2 col-sm-2 no-padding-right">未能冻结原因：</label>
													<div class="input-group  col-xs-10 col-sm-5 input-group">
														<fm:textarea class="col-xs-12 col-sm-10 limited" rows="4"
															path="wndjyy" maxlength="500"></fm:textarea>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group col-xs-12 col-sm-12">
													<label
														class="control-label col-xs-2 col-sm-2 no-padding-right">备注：</label>
													<div class="input-group  col-xs-10 col-sm-5 input-group">
														<fm:textarea class="col-xs-12 col-sm-10 limited" rows="4"
															path="beiz" maxlength="500" ></fm:textarea>
													</div>
												</div>
											</div>
										</div>
										
										
									</div>
									<div class="clearfix form-actions text-center">
										<button class="btn btn-info btn-sm" type="button" id="subform"
											onclick="vSubmit('kzdj_save','myform')">
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
					<!-- /.row -->
				</fm:form>
			</div>

		</div>
	</div>
	 <!-- basic scripts -->
        <jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>

		<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"> </script>
		<script	src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"><!-- 文本域输入计数 --></script>
	    <script	src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"><!-- 文本域自适应高度 --></script>
<!-- 	   <script type="text/javascript">
    $(".datetimepicker").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss'});
</script>  -->
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
 		var 	zxjg=$("#zxjg").val();
 		if(zxjg==""){
 			agg.dialogAlert("执行结果不能为空","face-smile");
 			return false;
 		}
 		if(zxjg=="0"){
 			if(jQuery(iframe).isValid()) {
 			} else {
 				agg.dialogAlert("验证未通过","face-smile");
 				return false;
 			} 
 		}else{
 			var 	wndjyy=$("#wndjyy").val();
 	 		if(wndjyy==""){
 	 			agg.dialogAlert("未能冻结原因不能为空","face-smile");
 	 			return false;
 	 		}
 		}
 		     document.forms[0].action=url;
			document.forms[0].submit();
 		}
        </script>
</body>
</html>