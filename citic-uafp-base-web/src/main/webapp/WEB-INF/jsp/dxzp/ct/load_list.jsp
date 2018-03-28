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
		<fm:form class="form-horizontal" commandName="ct_yjmd"
			action="file_list" method="POST" enctype="multipart/form-data"
			id="myform">
			<!-- 右侧内容 -->
			<div class="row">
				<div class="col-xs-12">

					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								银监黑名单导入
							</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right"><span
												style="color: red">*</span>名单类型：</label>
											<div class=" col-xs-8 col-sm-8 input-group">
												<fm:select path="md_type" items="${md_typeMap}"></fm:select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right"><span
												style="color: red">*</span>名单附件：</label>

											<div class="input-group col-xs-12 col-sm-8">
												<fm:input type="file" class="input-xlarge" path="md_file" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-12">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right"></label>
											<div class=" col-xs-8 col-sm-8 input-group">
												<button class="btn btn-info btn-mini" type="button"
													id="submitForm" onclick="up_load('file_upload')">
													<i class="ace-icon glyphicon glyphicon-upload"></i> 导入
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.widget-main -->
						</div>
						<!-- /.widget-body -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
										<tr>
											<th>文件名称</th>
											<th>名单类型</th>
											<th>上传人</th>
											<th>上传时间</th>
											<th>状态</th>
											<th>说明</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ct_yjmdList}" var="file" varStatus="s">
											<tr class="text-center">
												<td nowrap="nowrap">${file.file_name}</td>
												<td nowrap="nowrap">${file.md_type_disp}</td>
												<td nowrap="nowrap">${file.create_user}</td>
												<td nowrap="nowrap">${file.create_dt}</td>
												<td nowrap="nowrap"><c:choose>
														<c:when test="${file.status_cd=='0'}">
															<span
																class="label label-info arrowed-in arrowed-in-right">${file.status_cd_disp}</span>
														</c:when>
														<c:when test="${file.status_cd=='1'}">
															<span
																class="label label-success arrowed-in arrowed-in-right">${file.status_cd_disp}</span>
														</c:when>
														<c:otherwise>
															<span
																class="label label-danger arrowed-in arrowed-in-right">${file.status_cd_disp}</span>
														</c:otherwise>
													</c:choose></td>
												<td>${file.instructions}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- PAGE PageChange BEGINS -->
					<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
					<!-- PAGE PageChange End -->
					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script type="text/javascript">
		function up_load(url) {
			var md_type = $("#md_type").val();//01:个人名单 02：企业名单
			var md_file = $("#md_file").val();
			if (md_type == '') {
				agg.dialogAlert("名单类型不能为空，请选择！", "face-smile");
				return false;
			}
			if (md_file == '') {
				agg.dialogAlert("名单附件不能为空，请选择要上传的附件！", "face-smile");
				return false;
			} else {
				var index = md_file.lastIndexOf("\\");
				var filename = md_file;//文件全称
				var type = "";//文件格式
				if (index != -1) {
					filename = md_file.substring(index + 1);
				}
				//防止文件名超长
				if (getBytesLength(filename) > 128) {
					agg.dialogAlert("名单附件名称太长，请重新命名！", "face-smile");
					return false;
				} else {
					var index_2 = filename.lastIndexOf(".");
					if (index_2 != -1) {
						//文件格式校验
						type = filename.substring(index_2 + 1);
						if (type.toLowerCase() != "zip") {
							agg.dialogAlert("名单附件格式错误，格式应该是zip！", "face-smile");
							return false;
						}
						//文件类型校验---根据需要调整
						if (md_type == '01') {
							if (filename.toLowerCase().indexOf("gr") == -1) {
								agg.dialogAlert("请确认上传的文件是个人黑名单zip文件！",
										"face-smile");
								return false;
							}
						} else {
							if (filename.toLowerCase().indexOf("dw") == -1) {
								agg.dialogAlert("请确认上传的文件是单位黑名单zip文件！",
										"face-smile");
								return false;
							}
						}
					} else {
						agg.dialogAlert("名单附件无格式，请上传zip格式的正确文件！", "face-smile");
						return false;
					}
				}
			}
			_submit(url);
		}
		//中文替换为2个字节后的字符串长度
		function getBytesLength(str) {
			return str.replace(/[^\x00-\xff]/g, 'xx').length;
		}
	</script>
</body>
</html>
