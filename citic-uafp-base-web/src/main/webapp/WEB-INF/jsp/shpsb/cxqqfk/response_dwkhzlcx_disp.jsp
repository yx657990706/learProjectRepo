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
	<fm:form class="form-horizontal" commandName="br54_cxqq_back"  action="save_data"  method="POST" id="myform">
      <div class="widget-box">
        <div class="widget-header widget-header-flat">
        <h5 class="widget-title lighter">
            <span class="glyphicon glyphicon-play-circle orange" ></span>
             单位开户资料信息<!--前面的图标可加可不加，这种表格就是widget-box-->
        </h5>
    </div>
       </div>
      <div class="widget-box transparent" >
	
		<div class="widget-body">
			<div class="widget-main no-padding">
				<div class="space-8"></div>
					<div class="agg_GridDetail">
						<table>
						    <tr>
                      	        <td>报文批次号：</td>
                      	        <td>  ${br54_cxqq_back_party.msgseq }</td>
                      	        <td>地址：</td>
                      	         <td>${br54_cxqq_back_party.lxdz }</td>
                      	     </tr>
                      	     <tr>
                      	        <td>电话：</td>
                      	        <td>  ${br54_cxqq_back_party.lxdh }</td>
                      	        <td>联系人：</td>
                      	         <td>${br54_cxqq_back_party.lxr }</td>
                      	     </tr>
                      	      <tr>
                      	        <td>法人代表：</td>
                      	        <td>  ${br54_cxqq_back_party.frdb }</td>
                      	        <td>法人代表证件类型：</td>
                      	         <td> ${br54_cxqq_back_party.frdbzjlx_disp }</td>
                      	     </tr>
                      	      <tr>
                      	        <td>法人代表证件号码：</td>
                      	        <td> ${br54_cxqq_back_party.frdbzjhm }</td>
                      	     </tr>
                      	      <tr>
                      	        <td>E-mail：</td>
                      	        <td> ${br54_cxqq_back_party.email }</td>
                      	        <td>代办人姓名：</td>
                      	        <td> ${br54_cxqq_back_party.dbrxm }</td>
                      	     </tr>
                      	      <tr>
                      	        <td>代办人证照类型：</td>
                      	        <td>${br54_cxqq_back_party.dbrzzlx_dizp }</td>
                      	        <td>代办人证照号码：</td>
                      	         <td>${br54_cxqq_back_party.dbrzzh }</td>
                      	     </tr>
                      	      <tr>
                      	        <td>统一社会信用代码：</td>
                      	        <td>${br54_cxqq_back_party.shxydm }</td>
                      	        <td>查询日期：</td>
                      	        <td>${br54_cxqq_back_party.qrydt }</td>
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