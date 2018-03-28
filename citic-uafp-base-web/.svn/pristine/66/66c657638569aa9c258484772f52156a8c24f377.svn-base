<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../../fragments/base_css.jsp"/>
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-content">
	<fm:form class="form-horizontal" commandName="br54_cxqq_mx"  action="save_data"  method="POST" id="myform">
            <!-- 隐藏域 -->
        <div class="widget-box transparent" >
	
		<div class="widget-body">
			<div class="widget-main no-padding">
				<div class="space-8"></div>
					<div class="agg_GridDetail">
						<table>
						<tr>
                      	        <td width="5%">请求单号：</td>
                      	        <td> ${br54_cxqq_mx.bdhm }</td>
                      	        <td width="5%">报文批次号：</td>
                      	        <td>${br54_cxqq_mx.msgseq }</td>
                      	     </tr>
                      	     <tr>
                      	        <td width="5%">案号：</td>
                      	        <td> ${br54_cxqq_mx.ah }</td>
                      	        <td width="5%">承办单位：</td>
                      	        <td>${br54_cxqq_mx.cbdw }</td>
                      	     </tr>
                      	     <tr>
                      	        <td>承办人1：</td>
                      	        <td>${br54_cxqq_mx.cbr1 }</td>
                      	        <td>承办人2：</td>
                      	        <td>${br51_cxqq_mx.cbr2 }</td>
                      	     </tr>
								<tr>
                      	        <td>账卡号：</td>
                      	        <td>${br54_cxqq_mx.zh }</td>
                      	        <td></td>
                      	        <td></td>
                      	     </tr>	    
                     
						</table>
					</div>
			</div><!-- /.widget-main -->
		</div><!-- /.widget-body -->
		</div>

    </fm:form>
<!-- PAGE CONTENT ENDS -->
</div>
<jsp:include page="../../fragments/base_js.jsp"/>

<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>