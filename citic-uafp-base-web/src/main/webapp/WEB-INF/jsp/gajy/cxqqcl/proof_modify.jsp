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
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="page-content">
		<fm:form class="form-horizontal" commandName="br40_cxqq_back_pz"
			id="myform" enctype="multipart/form-data" action="proof_modify" method="POST">
			
			<!-- 隐藏区域 -->
			<fm:hidden path="tasktype"/>
			<fm:hidden path="qqdbs"/>
			<fm:hidden path="rwlsh"/>
			<fm:hidden path="pztxlx"/>
			<input type="hidden"  id="d_file_name"  name="d_file_name" />
		    <input type="hidden"  id="d_file_path"  name="d_file_path" />
			
			<!-- 导航 -->
			<div class="widget-box transparent">
				<div class="widget-header widget-header-flat">
					<h4 class="widget-title">
						<i class="ace-icon fa fa-star orange"></i>凭证图像上传
					</h4>
					<div class="widget-toolbar" style="line-height: 34px">
					     	<a href="#" onclick="_submit('<c:url value="/br40_cxqq/send_jg"/>')">
                                		<i class="ace-icon glyphicon glyphicon-repeat orange"></i>发送监管机构
                                </a>&nbsp;&nbsp;
								<a href="<c:url value="/br40_cxqq/proof_list?isNewSearch=1&tasktype=${tasktype}"/>"	>
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> 
						<a href="#" data-action="collapse"> <i
							class="ace-icon fa fa-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main no-padding">
						<!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->

						<div class="space-10"></div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">任务流水号：</label>
									<div class=" col-xs-12 col-sm-8 ">${br40_cxqq_back_pz.rwlsh}
									</div>
								</div>
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">账号：</label>
									<div class="col-xs-12 col-sm-8 ">${br40_cxqq_back_pz.cxzh}
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">卡号：</label>
									<div class=" col-xs-12 col-sm-8 ">${br40_cxqq_back_pz.cxkh}
									</div>
								</div>
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">交易流水号：</label>
									<div class="col-xs-12 col-sm-8 ">${br40_cxqq_back_pz.jylsh}
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">卡凭证图像类型：</label>
									<div class=" col-xs-12 col-sm-8 ">${br40_cxqq_back_pz.pztxlx_disp}
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">执行结果：</label>
									<div class=" col-xs-12 col-sm-8 ">
                                         <fm:select path="cxfkjg" items="${cxfkjgMap}" require="true" datatype="require"></fm:select>
									</div>
								</div>
								<div class="form-group col-xs-12 col-sm-6 ">
									<label
										class="control-label col-xs-12 col-sm-4 no-padding-right">备注：</label>
									<div class="col-xs-12 col-sm-8 ">
									    <fm:input path="beiz" class="input-large" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<div class="form-group col-xs-12 col-sm-12">
									<label class="control-label col-xs-2 col-sm-2 no-padding-right">失败原因：</label>
									<div class="col-xs-10 col-sm-10 ">
										<fm:textarea class="col-xs-10 col-sm-10 limited" rows="2"
											path="cxfkjgyy" maxlength="100"></fm:textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">

								<div class="form-group col-xs-12 col-sm-12">
									<label class="control-label col-xs-2 col-sm-2 no-padding-right">附件：</label>
									<div class="col-xs-10 col-sm-10 ">
										<div class="text-right">
											<a href="#" onClick="addhtml();"> <i
												class="ace-icon fa fa-plus-circle orange"></i>
												添加&nbsp;&nbsp;
											</a>
										</div>
										<div class="widget-box widget-color-blue agg_widgetbox">
											<div class="widget-body">
												<div class="widget-main no-padding">
													<table
														class="table table-striped table-bordered table-hover">
														<thead>
															<tr>
																<th>图像凭证名称</th>
																<th>上传路径</th>
																<th>操作</th>
															</tr>
														</thead>
														<tbody id="fujian1">
															<c:forEach items="${attachList}" var="law" varStatus="s">
																<tr>
																	<td align="center"><c:out value="${law.filename}" /></td>
																	<td align="center"><c:out value="${law.filepath}" /></td>
																	<td align="center"><a
																		href="#" onclick="_download('${law.filepath}','${law.filename}')"> <span
																			class="glyphicon glyphicon-download-alt red"></span>
																	</a> &nbsp;&nbsp; <a href="#"
																		onclick="_delfile(this,'${law.seq}' ,'${law.filepath}' )">
																			<span class="glyphicon glyphicon-remove blue" id="d"></span>
																	</a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
				<div class=" form-actions text-center">
					<button class="btn btn-info btn-sm" type="button"
						onclick="_submit('proof_modify');">
						<i class="ace-icon fa fa-check bigger-110"></i> 保存
					</button>
				</div>
				<!-- /.widget-main -->
			</div>
			<!-- /.widget-body -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />">
	</script>
	<!-- page plugin -->
	<script
		src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />">
	<!-- 文本域输入计数 -->
	</script>
	<script
		src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />">
	<!-- 文本域自适应高度 -->
	</script>


	<script type="text/javascript">

	$(document).ready(function() {
        $('#myform').validateAll();
    });
		function opendemo(url) {
			agg.artDialog({
				title : '添加附件',
				url : url,
				width : '600',
				height : '500',
				onclose : function() {
					if (this.returnValue) {//对话框返回值
						addTr('fujian1', -1, this.returnValue);
					}
				}
			});
		}

		function _delfile(nowTr, seq, _filepath) {
			 var tasktype = $("#tasktype").val();
			 var qqdbs = $("#qqdbs").val();
			 var rwlsh = $("#rwlsh").val();
			$.ajax({
				type : "POST",
				url : "deletefile",
				data : {
					tasktype:tasktype,
					qqdbs:qqdbs,
					rwlsh:rwlsh,
					seq:seq,
					filepath:_filepath
				},
				cache : false,
				dataType : "json",
				// async: false,//同步
				success : function(data) {
					if (data.success) {
						alert("删除成功！");
					} else {
						alert("删除失败！");
					}
				}
			});

			//删除tr
			$(nowTr).parent().parent().remove();
		}
		
		
		
		function chgVal(nowTr) {
			 var path = $(nowTr).val(); 
			 var flag = path.lastIndexOf('\\');
			 var filename = "";
			 if(flag!=-1){
				 filename = path.substring(flag+1);
			 }else{
				 filename = path;
			 }
			 var index = filename.lastIndexOf('.');
			 if(index>0){
				 var filehz=filename.substr(index+1);  
				 if(filehz=="JPG"||filehz=="PDF"||filehz=="jpg"||filehz=="pdf"){
					 
				 }else{
					 alert("文件名称错误！");
					 $(nowTr).val("");
					 return;
				 }
			 }
			
			 var obj = $(nowTr).parent().prev().children();
			 $(obj).val(filename);
		   }
	</script>
</body>
</html>