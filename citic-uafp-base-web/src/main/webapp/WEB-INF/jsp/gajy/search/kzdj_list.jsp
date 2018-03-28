<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="zh-cn">
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
		<!-- 查询请求认定-->
		<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal"  commandName="br41_kzqq_dj_back"  action="request_djfk_list"  method="POST">
					<fm:hidden path="tasktype"/>
					<fm:hidden path="qqcslx"/>
					<fm:hidden path="qqdbs"/>
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								<c:if test="${br41_kzqq_dj_back.qqcslx=='05' }">冻结</c:if>
									<c:if test="${br41_kzqq_dj_back.qqcslx=='06' }">继续冻结</c:if>
										<c:if test="${br41_kzqq_dj_back.qqcslx=='07' }">解除冻结</c:if>
							</h5>
							<div class="widget-toolbar">
							<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								 <div class="row">
									<div class="col-xs-12">
									 <div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">冻结账户户主：</label>
											<div class="col-xs-12 col-sm-8 input-group">
											 <fm:input label="冻结账户户主："  path="djzhhz"    class="input-large" />
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">冻结账号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
											 <fm:input label="冻结账号："  path="zh"    class="input-large" />
											</div>
										</div>
									</div>
								</div> 
								
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">证照号码：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										      		 <fm:input label="证照号码："  path="zzhm"    class="input-large" />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right"></label>
										    <div class="input-group  col-xs-12 col-sm-8  ">
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('request_djfk_list?isNewSearch=1')">
															<i class="glyphicon glyphicon-search"></i>
															查询
														</button>
											</div>
										</div> 
									</div>
								</div>
							</div>
							<!-- /.widget-main -->
						</div>
						<!-- /.widget-body -->
					</div>
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box widget-color-blue agg_widgetbox">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover" >
									<thead class="thin-border-bottom">
										<tr>	
											<th>任务流水号</th>
											<th>冻结账户户主</th>
											<th>证照类型</th>
											<th>证照号码</th>
											<th>冻结账号</th>
											<th>核心反馈结果</th>
											<th>核心反馈状态</th>
											<th>账户序号</th>
											<th>主体类别</th>
											<th>冻结方式</th>
											<th>冻结金额</th>
											<th>余额</th>
											<th>开始时间</th>
											<th>结束时间</th>
											<!-- 只有继续冻结、解除冻结才有原任务流水号 -->
											<c:if test="${br41_kzqq_dj_back.qqcslx=='06' || br41_kzqq_dj_back.qqcslx=='07'}">
											<th>原任务流水号</th>
											</c:if>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="kzqq_djList"  items="${br41_kzqq_djbackList}" >
											<tr class="text-center">
												 <td  nowrap="nowrap">
                                                    <a href="#" onclick="_OpenXLarge('<c:url value="/br41_kzqq_dj_back/kzdj_fk_main?qqdbs=${kzqq_djList.qqdbs}&rwlsh=${kzqq_djList.rwlsh}&tasktype=${kzqq_djList.tasktype}"/>','冻结反馈信息')">
                                                      ${kzqq_djList.rwlsh}
                                                     </a>
                                                </td>
												<td nowrap="nowrap">${kzqq_djList.djzhhz}</td>
												<td nowrap="nowrap">${kzqq_djList.zzlxdm_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.zzhm}</td>
												<td nowrap="nowrap">${kzqq_djList.zh}</td>
												<td nowrap="nowrap">${kzqq_djList.zxjg_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.status_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.zhxh}</td>
												<td nowrap="nowrap">${kzqq_djList.ztlb_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.djfs_disp}</td>
												<td nowrap="nowrap">${kzqq_djList.sdje}</td>
												<td nowrap="nowrap">${kzqq_djList.ye}</td>
												<td nowrap="nowrap">${kzqq_djList.zxqssj}</td>
												<td nowrap="nowrap">${kzqq_djList.djjsrq}</td>
												<!-- 只有继续冻结、解除冻结才有原任务流水号 -->
												<c:if test="${br41_kzqq_dj_back.qqcslx=='06' || br41_kzqq_dj_back.qqcslx=='07'}">
													<td nowrap="nowrap">${kzqq_djList.yrwlsh}</td>
												</c:if>
											</tr>
										</c:forEach>
										</tbody>
								</table>
							</div>
						</div>
					</div>
				<c:out value="${pageInfoStr}" escapeXml="false"></c:out>	
				</fm:form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>

<jsp:include page="../../fragments/base_js.jsp"/>

<script
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
		
	</script>
	
</body>
</html>