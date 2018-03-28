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
   <fm:form class="form-horizontal" commandName="cgb_risk_case"  action="modify"  method="POST"  id="myform">
     <fm:hidden path="caseid"/>
     <div class="row">
     <div class="col-xs-12">
    <div class="widget-box transparent">
    <!--  
        <div class="widget-header widget-header-flat">
            <h4 class="widget-title">
                <i class="ace-icon fa fa-star orange"></i>
                电信诈骗风险事件信息添加
            </h4>

            <div class="widget-toolbar">
                <a href="#" data-action="collapse">
                    <i class="ace-icon fa fa-chevron-up"></i>
                </a>
            </div>
        </div>
-->
        <div class="widget-body">
            <div class="widget-main no-padding"><!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
             
                <div class="space-10"></div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-4 col-sm-4 no-padding-right"><span style="color: red">*</span>机构名称：</label>
									    <div class=" col-xs-8 col-sm-8 input-group">
									           <fm:input type="hidden"  path="organkey"/>
										      	<fm:input   path="organkey_disp"  class="input-large"  onchange="_changeOrganId('organkey_disp','organkey')"  />
								             	<a href="#"  onclick="selectTreeByName('organkey_disp','selectOrgan');"   title="选择机构">
												<i class="glyphicon glyphicon-search "></i>
											</a>
								             
									    </div>
									</div>
							<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-4 col-sm-4 no-padding-right"><span style="color: red">*</span>部门/支行：</label>
									    <div class=" col-xs-8 col-sm-8 input-group">
									           <fm:input type="hidden"  path="suborgankey"/>
										      	<fm:input   path="suborgankey_disp"  class="input-large"  onchange="_changeOrganId('suborgankey_disp','suborgankey')" />
								             	<a href="#"  onclick="selectTreeByName('suborgankey_disp','selectOrgan');"   title="选择机构">
												<i class="glyphicon glyphicon-search "></i>
											</a>
								             
									    </div>
									</div>		
                    </div>
                </div>
                <div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">涉案账户名：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input type="text"   path="accountname" class=" input-large" require="true" datatype="require" />
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">涉案账户：</label>
                                        <div class="col-xs-12 col-sm-8 input-group">
                                                <fm:input type="text"   path="account" class=" input-large" require="true" datatype="require" />
                                        </div>
                                    </div>
								</div>
							</div>
                         <div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">证照号码：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input type="text"   path="cardnumber" class=" input-large"  require="true" datatype="require"/>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">涉案金额：</label>
                                        <div class="col-xs-12 col-sm-8 input-group">
                                                <fm:input type="text"   path="je" class=" input-large" require="true" datatype="require"/>
                                        </div>
                                    </div>
								</div>
							</div>
                <div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">诈骗信息来源：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:select path="infosource" items="${infosourceMap}" class=" input-medium" require="true" datatype="require"></fm:select>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">事件发生日期：</label>
                                        <div class="col-xs-12 col-sm-8 input-group">
                                                <fm:input class="date-picker col-xs-6 col-sm-6"  path="happendate" type="text" data-date-format="yyyy-mm-dd" require="true" datatype="require"/>
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
                            <label class="control-label col-xs-2 col-sm-2 no-padding-right" ></label>
                              <div class="col-xs-10 col-sm-10 ">
                               <span style="font-size: 11px">【***年***月***日，在****地方，因被害人收到（QQ信息、短信、钓鱼网站链接等）导致受害人通过****（ATM、柜面、网银或其他渠道）业务被电信诈骗，涉案金额****元。】</span>
                              </div>
                               <label class="control-label col-xs-2 col-sm-2 no-padding-right" >事件简述：</label>
                            <div class="col-xs-10 col-sm-10 ">
                                <fm:textarea rows="3" class="col-xs-10 col-sm-10 limited" path="casedesc" maxlength="128" require="true" datatype="require" placeholder="填写格式如上所示。。。"></fm:textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">信息来源渠道：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:select path="infochannel" items="${infochannelMap}" class=" input-medium"  onchange="do_show()" require="true" datatype="require"></fm:select>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6" id="channeldesc_id">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">渠道描述：</label>
                                        <div class="col-xs-12 col-sm-8 input-group">
                                                <fm:input type="text"   path="channeldesc" class=" input-large"  placeholder="请具体到当地"  maxlength="64"/>
                                        </div>
                                    </div>
								</div>
							</div>
                <div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">是否已报案：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:select path="isreport" items="${isreportMap}" class=" input-medium" require="true" datatype="require"></fm:select>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
                                        <label class="control-label col-xs-12 col-sm-4 no-padding-right">受理报案机关：</label>
                                        <div class="col-xs-12 col-sm-8 input-group">
                                                <fm:input type="text"   path="dealorgan" class=" input-large" maxlength="64" placeholder="请具体到当地公安机关"/>
                                        </div>
                                    </div>
								</div>
							</div>
                
                <!-- /.widget-main -->
            </div>
            <!-- /.widget-body -->
        </div>
               <div class="clearfix form-actions text-center">
                        <button class="btn btn-info btn-sm" type="button" onclick="vSubmit('<c:url value="/risk_case/modify"/>','myform')">
                            <i class="ace-icon fa fa-check bigger-110"></i>
                            保存
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-sm" type="button"   onclick="reset();re_do('myform');">
                            <i class="ace-icon fa fa-undo bigger-110"></i>
                            重置
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
		<script type="text/javascript">
		$(document).ready(function() {
			 $('#myform').validateAll();
		 });
		
		/**
 		 * 验证提交
 		 * @param url
 		 * @param formname
 		 */
 		function  vSubmit(url,formname)  {
 			var iframe =$("#"+formname);
 			re_do('myform');
 			if(jQuery(iframe).isValid()) {
 				var organkey =  $("#organkey").val().trim();
 				var suborgankey =  $("#suborgankey").val().trim();
 				var channelDesc =  $("#channeldesc").val().trim();
 				if(organkey==''){
 					agg.dialogAlert("请选择机构名称!","face-smile");
					return false;
 				}
 				if(suborgankey==''){
 					agg.dialogAlert("请选择部门/支行!","face-smile");
 					return false;
 				}
  				if(channelDesc==''){
  					agg.dialogAlert("渠道描述应具体到当地，不能为空!","face-smile");
  					return false;
  				}
 				document.forms[0].action=url;
 				document.forms[0].submit();  
 			} else {
 				agg.dialogAlert("验证未通过","face-smile");
 			}
 		}
		
      function do_show(){
    	  var key = $("#infochannel").val();
    	  if(key=='4'){
    		  $("#channeldesc").val("网点报案");
    		  $("#channeldesc_id").hide();
    	  }else  if(key=='5'){
    		  $("#channeldesc").val("其他渠道");
    		  $("#channeldesc_id").hide();
    	  }else if(key==''){
    		  $("#channeldesc").val("");
    		  $("#channeldesc_id").hide();
    	  }else{
    		  $("#channeldesc").val("");
    		  $("#channeldesc_id").show();
    	  }
      }

		</script>
</body>
</html>
