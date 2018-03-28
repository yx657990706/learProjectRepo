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
				<fm:form class="form-horizontal" commandName="br40_cxqq_back_acct" action="deal_acct_info" method="POST">
					    <fm:input type="hidden" path="qqcslx" class="input-large" /> 
											    <fm:input  type="hidden" path="qqdbs" class="input-large" />
											    <fm:input  type="hidden" path="rwlsh" class="input-large" /> 
											     <fm:input  type="hidden" path="tasktype" class="input-large" />  
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								账户信息
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
    								<!-- <th>请求单流水号</th> -->
                                  <th>任务流水号</th>
                                  <th>卡号</th>
                                  <th>账号</th>
                                  <!-- 根据tasktype判断5 表示 最高人民检察院 -->
                                  <c:if test="${br40_cxqq_back_acct.tasktype=='5' }">
                                  <th>网银账户名称</th>
                                  <th>最后登录IP</th>
                                  <th>最后登录时间</th>
                                  </c:if>
                                  <th>账户类别</th>
                                  <th>账户状态</th>
                                  <th>开户网点的名称</th>
                                  <th>开户网点代码</th>
                                  <th>开户日期</th>
                                  <th>销户日期</th>
                                  <th>销户网点名称</th>
                                  <th>币种</th>
                                  <th>钞汇标志</th>
                                  <th>账户余额</th>
                                  <th>可用余额</th>
                                  <th>最后交易时间</th>
                                  <th>备注</th>
                                  <!-- 根据tasktype判断4 表示 国家安全机构 -->
                                  <c:if test="${br40_cxqq_back_acct.tasktype=='4' }">
                                  <th>开户网点所在地</th>
                                  <th>销户网点代码</th>
                                  <th>销户网点所在地</th>
                                  <th>有效期</th>
                                  <th>银行卡签约电话</th>
                                  <th>银行卡签约时间</th>
                                  <th>银行卡签约网点</th>
                                  <th>销户网点代硏</th>
                                <!--   <th>销户网点所在地</th> -->
                                  <th>银行卡终止签约时间</th>
                                  <th>账号等级</th>
                                  <th>账号类型</th>
                                  <th>支持外币类型</th>
                                  <th>补卡时间</th>
                                  <th>补卡网点</th>
                                  <th>补卡网点代码</th>
                                  <th>补卡网点所在地</th>
                                  <th>银行卡终止签约时间</th>
                                  </c:if>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="infolist" items="${br40_cxqq_back_acctList}">
												<tr class="text-center">
													<!-- <td><a class="green" href="acct_add.html" title="编辑"  >
                                                     <i class="ace-icon fa fa-pencil "></i></a>&nbsp;
                                              <a href="#"> <i class="ace-icon fa fa-trash-o red" title="删除"></i>
                                      						</a>
                                                    </td> -->
                                                   <%--  <td nowrap="nowrap">${infolist.qqdbs}</td> --%>
                                                     <td nowrap="nowrap">${infolist.rwlsh}</td>
                                                     <td nowrap="nowrap">${infolist.kh}</td>
                                                     <td nowrap="nowrap">${infolist.zh}</td>
                                                      <!-- 根据tasktype判断5 表示 最高人民检察院 -->
                                                    <c:if test="${br40_cxqq_back_acct.tasktype=='5' }">
                                                      <td nowrap="nowrap">${infolist.wyzhmc}</td>
                                                      <td nowrap="nowrap">${infolist.zhdlip}</td>
                                                      <td nowrap="nowrap">${infolist.zhdlsj}</td>
                                                    </c:if>
                                                     <td nowrap="nowrap">${infolist.zhlb}</td>
                                                     <td nowrap="nowrap">${infolist.zhzt}</td>
                                                     <td nowrap="nowrap">${infolist.khwd}</td>
                                                     <td nowrap="nowrap">${infolist.khwddm}</td>
                                                     <td nowrap="nowrap">${infolist.khrq}</td>
                                                     <td nowrap="nowrap">${infolist.xhrq}</td>
                                                     <td nowrap="nowrap">${infolist.xhwd}</td>
                                                     <td nowrap="nowrap">${infolist.bz_disp}</td>
                                                     <td nowrap="nowrap">${infolist.chbz}</td>
                                                     <td nowrap="nowrap">${infolist.zhye}</td>
                                                     <td nowrap="nowrap">${infolist.kyye}</td>
                                                     <td nowrap="nowrap">${infolist.zhjysj}</td>
                                                     <td nowrap="nowrap">${infolist.beiz}</td>
                                                       <!-- 根据tasktype判断4 表示 国家安全机构 -->
                                                    <c:if test="${br40_cxqq_back_acct.tasktype=='4' }">
                                                     <td nowrap="nowrap">${infolist.khwdszd}</td>
                                                     <td nowrap="nowrap">${infolist.xhwddm}</td>
                                                     <td nowrap="nowrap">${infolist.xhwdszd}</td>
                                                     <td nowrap="nowrap">${infolist.yxq}</td>
                                                     <td nowrap="nowrap">${infolist.yhkqydh}</td>
                                                     <td nowrap="nowrap">${infolist.yhkqysj}</td>
                                                     <td nowrap="nowrap">${infolist.yhkqywd}</td>
                                                     <td nowrap="nowrap">${infolist.bkwddm}</td>
                                                     <td nowrap="nowrap">${infolist.syblrq}</td>
                                                     <td nowrap="nowrap">${infolist.zhdj}</td>
                                                     <td nowrap="nowrap">${infolist.zhlx}</td>
                                                     <td nowrap="nowrap">${infolist.zcwblx}</td>
                                                     <td nowrap="nowrap">${infolist.bksj}</td>
                                                     <td nowrap="nowrap">${infolist.bkwd}</td>
                                                     <td nowrap="nowrap">${infolist.bkwddm}</td>
                                                     <td nowrap="nowrap">${infolist.bkwdszd}</td>
                                                    <td nowrap="nowrap">${infolist.byblrq}</td>
													 </c:if>
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