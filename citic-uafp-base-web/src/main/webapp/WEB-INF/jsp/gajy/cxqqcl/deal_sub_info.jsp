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
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css'/>"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content">
		<!-- 右侧内容 -->
			<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br40_cxqq_back_acct_sub" action="deal_sub_info" method="POST">
 <fm:input type="hidden" path="qqcslx" class="input-large" /> 
											    <fm:input  type="hidden" path="qqdbs" class="input-large" />
											    <fm:input  type="hidden" path="rwlsh" class="input-large" />
											    <fm:input  type="hidden" path="tasktype" class="input-large" />  

					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								关联子账户信息
							</h5>
						</div> 
                         
						
						</div>

			
						<div class="widget-box widget-color-blue agg_widgetbox">

							<div class="widget-body">
								<div class="widget-infolist no-padding">
									<table class="table table-striped table-bordered table-hover">
										<thead class="thin-border-bottom">
											<tr>
    								<!-- <th>操作</th> -->
                                    <th>任务流水号</th>
                                    <th>账卡号</th>
                                    <th>子账户序号</th>
                                    <th>子类账户类别</th>
                                    <th>子账户账号</th>
                                    <th>币种</th>
                                    <th>钞汇标志</th>
                                    <th>账户余额</th>
                                    <th>账户状态</th>
                                    <th>可用余额</th>
                                 
											</tr>
										</thead>
										<tbody>
											<c:forEach var="infolist" items="${br40_cxqq_back_acct_subList}">
												<tr class="text-center">
													<!-- <td><a class="green" href="acct_add.html" title="编辑"  >
                                                     <i class="ace-icon fa fa-pencil "></i></a>&nbsp;
                                              <a href="#"> <i class="ace-icon fa fa-trash-o red" title="删除"></i>
                                      						</a>
                                                    </td> -->
                                                  <td nowrap="nowrap">${infolist.rwlsh}</td>
                                                  <td nowrap="nowrap">${infolist.zh   }</td>
                                                  <td nowrap="nowrap">${infolist.zzhxh}</td>
                                                  <td nowrap="nowrap">${infolist.zzhlb}</td>
                                                  <td nowrap="nowrap">${infolist.zzhzh}</td>
                                                  <td nowrap="nowrap">${infolist.bz_disp   }</td>
                                                  <td nowrap="nowrap">${infolist.chbz }</td>
                                                  <td nowrap="nowrap">${infolist.zhye }</td>
                                                  <td nowrap="nowrap">${infolist.zhzt}</td>
                                                  <td nowrap="nowrap">${infolist.kyye }</td>
                                                
												</tr>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
                        <!-- PAGE CONTENT BEGINS -->
						<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
					    <!-- PAGE CONTENT ENDS -->
				</fm:form>
				
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>

	<jsp:include page="../../fragments/base_js.jsp" />
	<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	

</body>
</html>