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
		<fm:form class="form-horizontal" commandName="br41_kzqq_dj_back"
			action="kzdj_fk_disp" method="POST" id="myform">
			<div class="row">
				<div class="col-xs-12">
					<div class="widget-box transparent">
						<div class="widget-body">
							<div class="widget-main no-padding">
								<div class="agg_GridDetail">
									<table>
										<tr>
											<td width="25%">任务流水号：</td>
											<td width="25%">${br41_kzqq_dj_back.rwlsh }</td>
											<td width="25%">请求单标识：</td>
											<td width="25%">${br41_kzqq_dj_back.qqdbs }</td>
										</tr>
										<tr>
											<td>账号：</td>
											<td>${br41_kzqq_dj_back.zh }</td>
											<td>卡号：</td>
											<td>${br41_kzqq_dj_back.kh }</td>
										</tr>
										<tr>
											<td>申请冻结限额：</td>
											<td>${br41_kzqq_dj_back.sqdjxe }</td>
											<td>执行冻结金额：</td>
											<td>${br41_kzqq_dj_back.sdje }</td>
										</tr>
										<tr>
											<td>账户余额：</td>
											<td>${br41_kzqq_dj_back.ye}</td>
											<td>账户可用余额：</td>
											<td>${br41_kzqq_dj_back.zhkyye}</td>
										</tr>
											<tr>
											<td>在先冻结金额：</td>
											<td>${br41_kzqq_dj_back.djje}</td>
											<td>未冻结金额：</td>
											<td>${br41_kzqq_dj_back.wdjje}</td>
										</tr>
										<tr>
											<td>执行起始时间：</td>
											<td>${br41_kzqq_dj_back.zxqssj }</td>
											<td>执行结束时间：</td>
											<td>${br41_kzqq_dj_back.djjsrq }</td>
										</tr>
										<tr>
											<td>在先冻结到期日：</td>
											<td>${br41_kzqq_dj_back.djjzrq}</td>
											<td>在先冻结机关：</td>
											<td>${br41_kzqq_dj_back.djjg}</td>
										</tr>
										<tr>
											<td>核心反馈状态：</td>
											<td >${br41_kzqq_dj_back.status_disp}</td>
											<td>核心反馈结果：</td>
											<td>${br41_kzqq_dj_back.zxjg_disp}</td>
										</tr>
										<tr>
											<td>未能冻结原因：</td>
											<td colspan="3">${br41_kzqq_dj_back.wndjyy}</td>
										</tr>
										<tr>
											<td>备注：</td>
											<td colspan="3">${br41_kzqq_dj_back.beiz}</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fm:form>
	</div>
	<!-- basic scripts -->

	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>


</body>
</html>
