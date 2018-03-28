<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp" />
</head>
<body>
	<div class="page-content">

		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="deal_hzws_list"
					action="hzws_list" method="POST">
					<input type="hidden" id="d_file_name" name="d_file_name" />
					<input type="hidden" name="d_file_path" id="d_file_path" />
					<input type="hidden" path="tasktype" id="taskId" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								查看回执文书
							</h5>
							<div class="widget-toolbar">

								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<table class="table table-striped table-bordered table-hover">
									<thead class="thin-border-bottom">
										<tr>

											<th>操作</th>
											<th>文件名称</th>
											<th>文件类型</th>
											<th>文书类型</th>
											<th>创建日期</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="hzws" items="${br41_kzqq_hzwsList}">
											<tr class="text-center">

												<td nowrap><a
													href="<c:url value="hzws_modify?wskey=${hzws.wskey}&qqdbs=${hzws.qqdbs}&tasktype=${hzws.tasktype}"/>"
													title="编辑"> <i class="ace-icon fa fa-pencil  green">
													</i>
												</a> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <c:if
														test="${hzws.wjpath!=''}">
														<a href='#'
															onclick="_download('${hzws.wjpath}','${hzws.wjmc}.${hzws.wjlx}')">
															<i class="glyphicon glyphicon-download-alt  blue"></i>
														</a>
													</c:if></td>
												<td><c:choose>
														<c:when test="${hzws.wjpath!=''}">
															<a href='#'
																onclick="_download( '${hzws.wjpath}','${hzws.wjmc}.${hzws.wjlx}')">
																${hzws.wjmc} </a>
														</c:when>
														<c:otherwise>
									         	      ${hzws.wjmc} 
									         	     </c:otherwise>
													</c:choose></td>
												<td>${hzws.wjlx}</td>
												<td>${hzws.wslx_disp}</td>
												<td>${hzws.qrydt}</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>

					</div>
				</fm:form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>

	<jsp:include page="../../fragments/base_js.jsp" />

	<script>
function  _Open(url,title){
	agg.artDialog({
		title:title,
		url:url,
		width:'500',
		height:'400',
		onclose: function () {
		document.forms[0].action="wlkz_hzws_list";
	    document.forms[0].submit();
		}
	});
}
</script>
	<script type="text/javascript">
   var tasktype=$("#taskId").val();
	function _OpenXLarge(url,title){ //弹出大窗口
		agg.artDialog({
			title:title,
			url:url,
			width:'980',
			height:'550',
			onclose: function () {
				_submit("hzws_list?isNewSearch=1&tasktype="+tasktype);
			}
		});
	}

	
	
	</script>

</body>
</html>