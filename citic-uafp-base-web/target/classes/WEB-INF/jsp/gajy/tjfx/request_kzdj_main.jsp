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
<title>请求单信息</title>
<jsp:include page="../../fragments/base_css.jsp" />
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabbable">
					<fm:input type="hidden" path="tasktype" />
					<ul class="nav nav-tabs padding-16" id="myTab3">
						<li id="li1" class="active"><a data-toggle="tab"
							href="#trans1"
							onclick="_changeIframe('<c:url value="/br41_kzqq_dj/request_djfk_list?isNewSearch=1&qqdbs=${qqdbs}&tasktype=${tasktype}&rwlsh=${rwlsh}&qqcslx=${qqcslx }"/>','0901')">
								<i class="green ace-icon fa fa-home bigger-120"></i>请求查询主体信息
						</a></li>
							<li  id="li2">
								<a data-toggle="tab" href="#trans2"  onclick="_changeIframe('<c:url value="/br41_kzqq/request_kzzf_disp?qqdbs=${qqdbs}&tasktype=${tasktype}&qqcslx=${qqcslx }" />','0902')" >
									<i class="green ace-icon fa fa-home bigger-120"></i>请求单信息
								</a>
							</li>

						<c:if test="${resource=='2' }">
							<div class="widget-toolbar" style="line-height: 34px">
								
								&nbsp; <a
									href="<c:url value="/br41_kzqq/request_kzdj_list?tasktype=${tasktype}"/>">
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a>
							</div>
						</c:if>
					</ul>

					<div class="tab-content">
						<div id="trans1" class="tab-pane fade in active">
							<iframe
								src="<c:url value="/br41_kzqq_dj/request_djfk_list?isNewSearch=1&qqdbs=${qqdbs}&tasktype=${tasktype}&rwlsh=${rwlsh}&qqcslx=${qqcslx }"/>"
								width="100%" height="500" scrolling="auto" frameborder="0"
								id="0901"></iframe>
								<iframe
								
								width="100%" height="500" scrolling="auto" frameborder="0"
								id="0901"></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"></script>
	<!--page plugin:datepicker日期选择器-->
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"></script>
	<script
		src="<c:url value='/resources/js/lib/chosen/chosen.jquery.min.js' />"></script>
	<!--page plugin:select下拉菜单/自动完成-->
	<script
		src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"></script>
	<!-- 文本域输入计数 -->
	<script
		src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"></script>
	<!-- 文本域自适应高度 -->

</body>
</html>