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
<!-- 右侧内容 -->
	<fm:form class="form-horizontal" commandName="br51_cxqq_back_party"  action="save_data"  method="POST" id="myform">
      <div class="widget-box transparent" >
	
		<div class="widget-body">
			<div class="widget-main no-padding">
				<div class="space-8"></div>
					<div class="agg_GridDetail">
						<table>
						 <tr>
                      	        <td>报文批次号：</td>
                      	        <td>  ${br51_cxqq_back_party.msgseq }</td>
                      	        <td>请求单号：</td>
                      	         <td> ${br51_cxqq_back_party.bdhm }</td>
                      	     </tr>
                      	      <tr>
                      	     
                      	        <td>单位电话：</td>
                      	        <td> ${br51_cxqq_back_party.dwdh }</td>
                      	        <td>单位地址：</td>
                      	        <td> ${br51_cxqq_back_party.dwdz }</td>
                      	     </tr>
                      	      <tr>
                      	     
                      	        <td>联系人：</td>
                      	        <td>${br51_cxqq_back_party.lxr }</td>
                      	        <td>E-mail地址：</td>
                      	         <td>${br51_cxqq_back_party.email }</td>
                      	     </tr>
                      	      <tr>
                      	     
                      	        <td>法人代表：</td>
                      	        <td>${br51_cxqq_back_party.frdb }</td>
                      	        <td>法人代表证件类型：</td>
                      	        <td>${br51_cxqq_back_party.frdbzjlx_disp }</td>
                      	     </tr>
                      	      <tr>
                      	     
                      	        <td>法人代表证件号码：</td>
                      	        <td> ${br51_cxqq_back_party.frdbzjhm }</td>
                      	        <td>工商营业执照：</td>
                      	         <td> ${br51_cxqq_back_party.gsyyzzh }</td>
                      	     </tr>
                      	     <tr>
                      	     
                      	        <td>国税纳税号：</td>
                      	        <td>${br51_cxqq_back_party.gsnsh }</td>
                      	        <td>地税纳税号：</td>
                      	        <td>${br51_cxqq_back_party.dsnsh }</td>
                      	     </tr>
                      	     <tr>
                      	     
                      	        <td>开户网点：</td>
                      	        <td>${br51_cxqq_back_party.khwd }</td>
                      	        <td>开户网点代码：</td>
                      	         <td>${br51_cxqq_back_party.khwddm}</td>
                      	     </tr>
                      	     <tr>
                      	     
                      	        <td>代办人姓名：</td>
                      	        <td>  ${br51_cxqq_back_party.dbrxm }</td>
                      	        <td>代办人证照类型：</td>
                      	        <td>${br51_cxqq_back_party.dbrzzlx_disp }</td>
                      	     </tr>
                      	     
                      	     <tr>
                      	     
                      	        <td>代办人证照号码：</td>
                      	        <td> ${br51_cxqq_back_party.dbrzzh }</td>
                      	        <td>查询日期：</td>
                      	        <td>${br51_cxqq_back_party.qrydt }</td>
                      	     </tr>
                      	     <tr>
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