<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>请求单信息</title>
		<jsp:include page="../../fragments/base_css.jsp"/>
	</head>
<body>
     <div class="widget-box transparent">
		<div class="widget-body">
			<div class="widget-main no-padding"><!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
			</div><!-- /.widget-main -->
		</div><!-- /.widget-body -->
		</div>
	<div class="space-8"></div>
				
	<div class="page-content">
		<form  class="form-horizontal"  commandName="br40_cxqq"  action="response_main"  id="modifyfrozenbackform"  method="POST">

			<div class="row">
				<div class="col-sm-12">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-16" id="myTab3">
							<li class="active" id="li1">
							<a data-toggle="tab"  href="#trans1"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/response_mx_list?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&tasktype=${tasktype}"/>','0901')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>请求查询主体信息
								</a>
							
							</li>
							<li id="li2">
									<a data-toggle="tab" href="#trans2"  onclick="_changeIframe('<c:url value="/br40_cxqq/request_disp?qqdbs=${qqdbs}&qqcslx=${qqcslx}&tasktype=${tasktype}"/>','0902')" >
									<i class="green ace-icon fa fa-home bigger-120"></i>请求单信息
								</a>
							</li>
							<!-- 判断只有四川省公安厅的才有回执文书 -->
							<c:if test="${tasktype=='6'}">
							<li id="li3">
								<a data-toggle="tab" href="#trans3"  onclick="_changeIframe('<c:url value="/br40_cxqq/hzws_list?qqdbs=${qqdbs }&rwlsh=${rwlsh}&tasktype=${tasktype}&isNewSearch=1"/>','0903')" >
									<i class="green ace-icon fa fa-home bigger-120"></i>回执文书
								</a>
							</li>
							</c:if> 
							
							<div class="widget-toolbar" style="line-height: 34px">
								
								<a href="<c:url value="/br40_cxqq/response_list?tasktype=${tasktype}"/>"	>
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> 
							</div>
						</ul>

						<div class="tab-content">
							<div id="trans1" class="tab-pane fade in active">
								<iframe src="<c:url value="/br40_cxqq_mx/response_mx_list?isNewSearch=1&qqdbs=${qqdbs }&qqcslx=${qqcslx}&tasktype=${tasktype}"/>"  width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>
							</div>

							<div id="trans2" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0902"></iframe>
							</div>
							<!-- 判断只有四川省公安厅的才有回执文书 -->
							<c:if test="${tasktype=='6'}">
							<div id="trans3" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0903"></iframe>
							</div>
							 </c:if>
						
						    </div>
						  
						
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"></script><!--page plugin:datepicker日期选择器-->
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"></script>
	<script src="<c:url value='/resources/js/lib/chosen/chosen.jquery.min.js' />"></script><!--page plugin:select下拉菜单/自动完成-->
	<script src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"></script><!-- 文本域输入计数 -->
	<script src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"></script><!-- 文本域自适应高度 -->
	

	</body>
</html>