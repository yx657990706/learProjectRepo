<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div class="page-content" id="page-content">
		<fm:form class="form-horizontal" commandName="bb11_data_task"
			action="list" method="POST">
			
			<input type="hidden" id="url" name="url" />
			
			<!-- 右侧内容 -->
			<div class="row">
				<div class="col-xs-12">

					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								本地任务监控
							</h5>

						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">

										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-4 col-sm-4 no-padding-right">任务ID：</label>
											<div class=" col-xs-8 col-sm-8 input-group">
												<fm:input type="text" path="task_id" class="input-large" />
											</div>
										</div>
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">任务状态：</label>
											<div class="input-group col-xs-12 col-sm-8">
												<fm:select path="task_status" items="${statusMap}"></fm:select>
												&nbsp;
												<button class="btn btn-info btn-mini" type="button"
													id="submitForm" onclick="_submit('list?isNewSearch=1')">
													<i class="glyphicon glyphicon-search"></i> 查询
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
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
										<tr>
											<th>操作</th>
											<th>任务ID</th>
											<th>任务日期</th>
											<th>任务时间</th>
											<th>任务状态</th>
											<th>备注</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${bb11_data_taskList}" var="task"
											varStatus="s">
											<tr class="text-center">
												<td class="align-middle" nowrap="nowrap"><a
													class="green" href="#"
													onclick="do_recal('<c:url value="/bb11_data_task/${task.task_id}/recal"/>','请确认需要重算？')">
														<i class="ace-icon glyphicon glyphicon-repeat red"></i>
												</a></td>
												<td class="align-middle" nowrap="nowrap">${task.task_id}</td>
												<td class="align-middle" nowrap="nowrap">${task.task_date}</td>
												<td class="align-middle" nowrap="nowrap">${task.task_date_time}</td>
												<td class="align-middle" nowrap="nowrap">${task.task_status_disp}</td>
												<td class="align-middle" nowrap="nowrap">${task.remark}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<!-- PAGE PageChange BEGINS -->
					<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
					<!-- PAGE PageChange End -->
					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
    <script type="text/javascript">
  //提交
	function do_recal(url,title) {
		 $("#url").val(url);
    	 agg.dialogConfirm(title,okDo,closeDo);
	}
  
	function closeDo() {
	}
	function okDo() {
		_submit($("#url").val());
	}
    </script>
</body>
</html>
