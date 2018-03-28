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
		<div class="row">
			<div class="col-xs-12">

				<fm:form class="form-horizontal"  commandName="br40_cxqq_back_pz"  action="proof_list"  method="POST">
					 <fm:input type="hidden" path="tasktype"  class="input-large"  />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								凭证图像处理
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
												class="control-label col-xs-12 col-sm-4 no-padding-right">任务流水号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
					
										         <fm:input path="rwlsh"  class="input-large" />
											</div>
										</div>
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">发送时间：</label>

											<div class="input-group col-xs-12 col-sm-8 ">

												<fm:input class="form-control date-picker"
													path="fssj_start" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker"
													path="fssj_end" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-calendar bigger-110"></i>
												</span>
											</div>
										</div>
									   
										
									</div>
								</div> 
								
								<div class="row">
									<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">查询账号：</label>
											<div class="col-xs-12 col-sm-8 input-group">
										        <fm:input label="查询账号：" path="cxzh"  class="input-large"  />
											</div>
										</div>
										
										<div class="form-group col-xs-12 col-sm-6">
											   <label class="control-label col-xs-12 col-sm-4 no-padding-right">紧急程度：</label>
											   
										    <div class="input-group  col-xs-12 col-sm-8  ">
										     <fm:select label="紧急程度：" class=" input-medium" path="jjcd"
													items="${jjcdMap}" />
												<button class="btn btn-info btn-mini" type="button"  onclick="_submit('proof_list?isNewSearch=1')">
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
								<table class="table table-striped table-bordered table-hover" 			>
									<thead class="thin-border-bottom">
										<tr>
											<th>操作</th>
											<th>请求单标识</th>
											<th>任务流水号</th>
											<th>查询反馈结果</th>
											<th>查询反馈结果原因</th>
											<th>紧急程度</th>
											<th>发送时间</th>
											<th>交易流水号</th>	
											<th>凭证图像类型</th>	
											<th>图像文件名</th>
											<th>查询账号</th>
											<th>查询卡号</th>	
											<th>备注</th>	
										</tr>
									</thead>

									<tbody>

										<c:forEach var="cxqqList"  items="${br40_cxqq_back_pzList}" >
											<tr class="text-center">
												 <td  nowrap="nowrap">
                                                    <a href="proof_modify?tasktype=${cxqqList.tasktype}&qqdbs=${cxqqList.qqdbs}&rwlsh=${cxqqList.rwlsh}">
                                                         <i class="ace-icon fa fa-pencil green" title="处理"></i>
                                                     </a>
                                                </td>
                                    	        <td  nowrap="nowrap"><a href="#" onclick="_OpenXLarge('<c:url value="/br40_cxqq/request_disp?tasktype=${cxqqList.tasktype}&qqdbs=${cxqqList.qqdbs}"/>','请求单信息')">${cxqqList.qqdbs}</a> </td>
												<td nowrap="nowrap">${cxqqList.rwlsh}</td>
												<td nowrap="nowrap">${cxqqList.cxfkjg_disp}</td>
									        	<td nowrap="nowrap">${cxqqList.cxfkjgyy}</td>
									        	<td nowrap="nowrap">${cxqqList.jjcd_disp}</td>
									        	<td nowrap="nowrap">${cxqqList.fssj}</td>
									        	<td nowrap="nowrap">${cxqqList.jylsh}</td>
									        	<td nowrap="nowrap">${cxqqList.pztxlx_disp}</td>
												<td nowrap="nowrap">${cxqqList.pztxmc}</td>
												<td nowrap="nowrap">${cxqqList.cxzh}</td>
												<td nowrap="nowrap">${cxqqList.cxkh}</td>
												<td nowrap="nowrap">${cxqqList.beiz}</td>
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
	<script type="text/javascript">
 var qqcslx=$("#qqcslxs").val();
	function _OpenXLarge(url,title){ //弹出大窗口
		agg.artDialog({
			title:title,
			url:url,
			width:'1000',
			height:'550',
			onclose: function () {
				 window.close();
			}
		});
	}
	</script>
	
	
</body>
</html>