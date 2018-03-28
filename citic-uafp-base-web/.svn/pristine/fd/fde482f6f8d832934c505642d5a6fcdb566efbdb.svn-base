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

	<fm:form class="form-horizontal"  commandName="br41_kzqq"  action="request_zf_main"  method="POST">
			<div class="row">
				<div class="col-sm-12">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-16" id="myTab3">
							<li class="active" id="li1">
								<a data-toggle="tab" href="#trans1"  onclick="_changeIframe('<c:url value="/br41_kzqq/request_zf_disp?qqdbs=${qqdbs}&tasktype=${tasktype}"/>','0901')" >
									<i class="green ace-icon fa fa-home bigger-120"></i>请求单信息
								</a>
							</li>
							<li id="li2">
								<a data-toggle="tab"  href="#trans2"  onclick="_changeIframe('<c:url value="/br41_kzqq_zf/request_zt_list?isNewSearch=1&qqdbs=${qqdbs}&tasktype=${tasktype}"/>','0902')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>请求控制主体信息
								</a>
							</li> 
							<c:if test="${resource=='2' }">
							<div class="widget-toolbar" style="line-height: 34px">
								<a href="#"  onclick="_submit('<%=request.getContextPath() %>/br41_kzqq_zf/gajy_send_hx?qqdbs=${qqdbs}&tasktype=${tasktype}') "  >
                                		<i class="ace-icon glyphicon glyphicon-repeat orange"></i>提交
                                </a>&nbsp;&nbsp;
								<a href="<c:url value="/br41_kzqq/request_zf_list?tasktype=${tasktype}"/>"	>
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> 
							</div>
							</c:if>
						</ul>

						<div class="tab-content">
							<div id="trans1" class="tab-pane fade in active">
								<iframe src="<c:url value="/br41_kzqq/request_zf_disp?qqdbs=${qqdbs}&tasktype=${tasktype}"/>"  width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>
							</div>

							<div id="trans2" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0902"></iframe>
							</div>
						    </div>
						
						
					</div>
				</div>
			</div>
		</fm:form >
	</div>

	<!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	
	</body>
</html>