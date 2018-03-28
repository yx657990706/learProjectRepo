<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="page-content">
			<fm:form class="form-horizontal"  commandName="br41_kzqq_dj_back_mx"  action="kzdj_main"  method="POST">
			<div class="row">
				<div class="col-sm-12">
					<div class="tabbable">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active" id="li1"><a data-toggle="tab" href="#trans1"
								onclick="_changeIframe('<c:url value="/br41_kzqq_dj_back/kzdj_fk_disp?qqdbs=${br41_kzqq_dj_back_mx.qqdbs }&tasktype=${br41_kzqq_dj_back_mx.tasktype }&rwlsh=${br41_kzqq_dj_back_mx.rwlsh }" />','0901')">
									<i class=" ace-icon fa fa-users red bigger-120"></i>冻结反馈结果信息
							</a></li>
							<!-- 判断是公安 查询反馈明细信息 -->
							<c:if test="${br41_kzqq_dj_back_mx.tasktype=='3' }">
							<li id="li2"><a data-toggle="tab" href="#trans2"
								onclick="_changeIframe('<c:url value="/br41_kzqq_dj_back/kzdj_fk_mx_list?isNewSearch=1&qqdbs=${br41_kzqq_dj_back_mx.qqdbs }&tasktype=${br41_kzqq_dj_back_mx.tasktype }&rwlsh=${br41_kzqq_dj_back_mx.rwlsh }"/>','0902')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>冻结反馈明细信息
							 </a>
							</li>
							</c:if>
							
								<c:if test="${backurl!=''}">
											<div class="widget-toolbar" style="line-height: 34px">
		
								<a href="#"  onclick="_submit('${backurl}')">
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> 
							</div>
							</c:if>
						</ul>
			
					
					

					<div class="tab-content">
						<div id="trans1" class="tab-pane fade in active">
							<iframe src="<c:url value="/br41_kzqq_dj_back/kzdj_fk_disp?qqdbs=${br41_kzqq_dj_back_mx.qqdbs }&tasktype=${br41_kzqq_dj_back_mx.tasktype }&rwlsh=${br41_kzqq_dj_back_mx.rwlsh }" />"
								width="100%" height="500" scrolling="auto" frameborder="0" id="0901"></iframe>
						</div>
						<!-- 判断是公安 查询反馈明细信息 -->
						<c:if test="${br41_kzqq_dj_back_mx.tasktype=='3' }">
						<div id="trans2" class="tab-pane fade">
						<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0" id="0902"></iframe>
						</div>
						</c:if>
					</div>
					
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>

</body>
</html>
