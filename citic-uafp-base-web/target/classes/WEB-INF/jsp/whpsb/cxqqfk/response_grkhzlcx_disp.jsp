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
<!-- PAGE CONTENT BEGINS -->
	<fm:form class="form-horizontal" commandName="br51_cxqq_back_party"  action="save_data"  method="POST" id="myform">
            <!-- 隐藏域 -->
        <div class="widget-box transparent" >
	
		<div class="widget-body">
			<div class="widget-main no-padding">
				<div class="space-8"></div>
					<div class="agg_GridDetail">
						<table>
                      	     <tr>
                      	     
                      	        <td>报文批次号：</td>
                      	        <td> ${br51_cxqq_back_party.msgseq }</td>
                      	        <td>请求单号：</td>
                      	         <td> ${br51_cxqq_back_party.bdhm }</td>
                      	     </tr>
									    
                               <tr>
                                    <td>住宅地址：</td>
									<td>${br51_cxqq_back_party.zzdz }</td>
									<td> 住宅电话：</td>
									<td>${br51_cxqq_back_party.zzdh }</td>
							  </tr>
                                 
                                   <tr>
                                    <td>工作单位：</td>
									<td> ${br51_cxqq_back_party.gzdw }</td>
									<td> 单位地址：</td>
									<td> ${br51_cxqq_back_party.dwdz }</td>
							  </tr>
							    <tr>
                                    <td>单位电话：</td>
									<td> ${br51_cxqq_back_party.dwdh }</td>
									<td>代办人证照号码：</td>
									<td>  ${br51_cxqq_back_party.dbrzzh }</td>
							  </tr>
							    <tr>
                                    <td>联系地址：</td>
									<td>  ${br51_cxqq_back_party.lxdz }</td>
									<td> 联系电话：</td>
									<td> ${br51_cxqq_back_party.lxsj }</td>
							  </tr>   
                                  <tr>
                                    <td>E-mail地址：</td>
									<td> ${br51_cxqq_back_party.email }</td>
									<td> 开户网点：</td>
									<td> ${br51_cxqq_back_party.khwd}</td>
							  </tr>   
                                       
                                <tr>
                                    <td>开户网点代码：</td>
									<td> ${br51_cxqq_back_party.khwddm }</td>
									<td> 开户网点：</td>
									<td> ${br51_cxqq_back_party.khwd}</td>
							  </tr> 
							  <tr>
                                    <td>邮政编码：</td>
									<td> ${br51_cxqq_back_party.yzbm }</td>
									<td> 通讯地址：</td>
									<td> ${br51_cxqq_back_party.txdz }</td>
							  </tr> 
							  <tr>
                                    <td>代办人姓名：</td>
									<td>  ${br51_cxqq_back_party.dbrxm }</td>
									<td> 代办人证照类型：</td>
									<td> ${br51_cxqq_back_party.dbrzzlx_disp }</td>
							  </tr>  
                                 <tr>
                                    <td>查询日期：</td>
									<td> ${br51_cxqq_back_party.qrydt }</td>
									<td> </td>
									<td> </td>
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