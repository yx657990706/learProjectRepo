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
     <link href="<c:url value='/resources/js/lib/ztree/3.5/zTreeStyle.css'  />"  rel="stylesheet"  type="text/css" />  
<!--page plugin:datepicker日期选择器-->
<link
	href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css'/>"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-content"   id="page-content">
		<!-- 右侧内容 -->
			<div class="row">
			<div class="col-xs-12">
				<fm:form class="form-horizontal" commandName="br40_cxqq_back_trans" action="deal_acct_trans_info" method="POST">
						<fm:hidden path="seq"/>
						<fm:hidden path="qqcslx"/>
						<fm:hidden path="qqdbs"/>
						<fm:hidden path="rwlsh"/>
					   <fm:hidden path="tasktype"/>
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								账户交易流水信息
							</h5>
						</div>
							<div class="widget-body">
						<div class="widget-main">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">交易时间：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input class="form-control date-picker" path="jysj_start" type="text" data-date-format="yyyy-mm-dd" />
								                                     <span class="input-group-addon">
									                                   <i class="fa fa-arrows-h"></i>
								                                      </span>
											<fm:input class="form-control date-picker" path="jysj_end" type="text" data-date-format="yyyy-mm-dd" />
								                                     <span class="input-group-addon">
									                                  <i class="fa fa-calendar bigger-110"></i>
								                                     </span>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right" >查询卡号：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input type="text" path="cxkh"  class="input-large"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">交易金额：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input type="text" path="je_start"  class="col-xs-12 col-sm-5"/>
											<label class="control-label col-xs-12 col-sm-2">—</label>
											<fm:input type="text" path="je_end"   class="col-xs-12 col-sm-5"/>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right">查询账号：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:input type="text" path="zh"  class="input-large"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right" >查询反馈结果：</label>
										<div class="col-xs-12 col-sm-8 input-group">
											<fm:select  path="cxfkjg"  class=" input-medium"  items="${cxfkjgMap }"/>
										</div>
									</div>
									<div class="form-group col-xs-12 col-sm-6">
										<label class="control-label col-xs-12 col-sm-4 no-padding-right" ></label>
										<div class="col-xs-12 col-sm-8 input-group">
											<button class="btn btn-info btn-mini" type="button" id="submitForm" onclick="_submit('deal_acct_trans_info?isNewSearch=1')" >
												<i class="glyphicon glyphicon-search"></i>
												查询
											</button>
										</div>
									</div>
								</div>
							</div>
						</div><!-- /.widget-main -->
					</div><!-- /.widget-body -->
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
                                      <th>查询账号</th>
                                     <th>查询卡号</th>
                                     <th>交易类型</th>
                                      <th>交易金额</th>
                                       <th>交易时间</th>
                                     <th>查询反馈结果</th>
                                     <th>查询反馈结果原因</th>
                                     <th>借贷标志</th>
                                     <th>币种</th>
                                     <th>交易余额</th>
                                      <th>交易序号</th>
                                      <th>交易网点名称</th>
                                     <th>交易流水号</th>
                                     <th>交易对方名称</th>
                                     <th>交易对方账号</th>
                                     <th>交易对方卡号</th>
                                     <th>交易对方证件号码</th>
                                     <th>交易对方余额</th>
                                     <th>交易对方账号开户行</th>
                                     <th>交易摘要</th>
                                     <th>交易网点名称</th>
                                     <th>日志号</th>
                                     <th>传票号</th>
                                     <th>凭证种类</th>
                                     <th>凭证号</th>
                                     <th>现金标志</th>
                                     <th>终端号</th>
                                     <th>交易是否成功</th>
                                     <th>交易发生地</th>
                                     <th>商户名称</th>
                                     <th>商户号</th>
                                     <th>IP地址</th>
                                     <th>MAC地址</th>
                                     <th>交易柜员号</th>
                                     <th>备注</th>
                                     <!-- 根据tasktye判断 8 深证公安 -->
                                     <c:if test="${br40_cxqq_back_trans.tasktype=='8'}">
                                     <th>证照类型代码</th>
                                     <th>证照号码</th>
                                     <th>客户名称</th>
                                     <th>交易对方通讯地址</th>
                                     <th>交易对方联系电话</th>
                                     </c:if>
                                     <!-- 根据tasktye判断 4 国家安全机构 -->
                                     <c:if test="${br40_cxqq_back_trans.tasktype=='4'}">
                                     <th>交易手续费币种</th>
                                     <th>交易手续费金额</th>
                                     <th>交易手续费摘要</th>
                                     <th>交易流水号</th>
                                     <th>登录用户名</th>
                                     <th>代办人姓名</th>
                                     <th>代办人证件类型</th>
                                     <th>代办人证件号码</th>
                                     <th>代办人联系电话</th>
                                     </c:if>
									</tr>
										</thead>
										<tbody>
											<c:forEach var="infolist" items="${br40_cxqq_back_transList}">
												<tr class="text-center">
                                                    <td nowrap="nowrap">${infolist.rwlsh     }</td>
                                                     <td nowrap="nowrap">${infolist.zh        }</td>
                                                    <td nowrap="nowrap">${infolist.cxkh      }</td>
                                                    <td nowrap="nowrap">${infolist.jylx}</td>
                                                     <td nowrap="nowrap">${infolist.je        }</td>
                                                    <td nowrap="nowrap">${infolist.jysj      }</td>
                                                    <td nowrap="nowrap">${infolist.cxfkjg_disp    }</td>
                                                    <td nowrap="nowrap">${infolist.cxfkjgyy  }</td>
                                                    <td nowrap="nowrap">${infolist.jdbz      }</td>
                                                    <td nowrap="nowrap">${infolist.bz_disp        }</td>
                                                    <td nowrap="nowrap">${infolist.ye        }</td>
                                                    <td nowrap="nowrap">${infolist.transseq  }</td>
                                                    <td nowrap="nowrap">${infolist.jywdmc    }</td>
                                                    <td nowrap="nowrap">${infolist.jylsh     }</td>
                                                    <td nowrap="nowrap">${infolist.jydfxm    }</td>
                                                    <td nowrap="nowrap">${infolist.jydfzh    }</td>
                                                    <td nowrap="nowrap">${infolist.jydfkh    }</td>
                                                    <td nowrap="nowrap">${infolist.jydfzjhm  }</td>
                                                    <td nowrap="nowrap">${infolist.jydsye    }</td>
                                                    <td nowrap="nowrap">${infolist.jydfzhkhh }</td>
                                                    <td nowrap="nowrap">${infolist.jyzy      }</td>
                                                    <td nowrap="nowrap">${infolist.jywdmc    }</td>
                                                    <td nowrap="nowrap">${infolist.rzh       }</td>
                                                    <td nowrap="nowrap">${infolist.cph       }</td>
                                                    <td nowrap="nowrap">${infolist.pzzl      }</td>
                                                    <td nowrap="nowrap">${infolist.pzh       }</td>
                                                    <td nowrap="nowrap">${infolist.xjbz_disp      }</td>
                                                    <td nowrap="nowrap">${infolist.zdh       }</td>
                                                    <td nowrap="nowrap">${infolist.jysfcg_disp    }</td>
                                                    <td nowrap="nowrap">${infolist.jyfsd     }</td>
                                                    <td nowrap="nowrap">${infolist.shmc      }</td>
                                                    <td nowrap="nowrap">${infolist.shh       }</td>
                                                    <td nowrap="nowrap">${infolist.ip        }</td>
                                                    <td nowrap="nowrap">${infolist.mac       }</td>
                                                    <td nowrap="nowrap">${infolist.jygyh     }</td>
                                                    <td nowrap="nowrap">${infolist.beiz      }</td>
                                                   <c:if test="${br40_cxqq_back_trans.tasktype=='8'}">
                                                    <td nowrap="nowrap">${infolist.zzlx_disp       }</td>
                                                    <td nowrap="nowrap">${infolist.zzhm        }</td>
                                                    <td nowrap="nowrap">${infolist.khmc       }</td>
                                                    <td nowrap="nowrap">${infolist.jydftxdz     }</td>
                                                    <td nowrap="nowrap">${infolist.jydflxdh      }</td>
                                                   </c:if>
                                                    <c:if test="${br40_cxqq_back_trans.tasktype=='4'}">
                                                    <td nowrap="nowrap">${infolist.jysxfbz   }</td>
                                                    <td nowrap="nowrap">${infolist.jysxfje   }</td>
                                                    <td nowrap="nowrap">${infolist.jysxfzy   }</td>
                                                    <td nowrap="nowrap">${infolist.jylsh   }</td>
                                                    <td nowrap="nowrap">${infolist.dlyhm     }</td>
                                                    <td nowrap="nowrap">${infolist.dbrxm     }</td>
                                                    <td nowrap="nowrap">${infolist.dbrzjlx   }</td>
                                                    <td nowrap="nowrap">${infolist.dbrzjhm   }</td>
                                                    <td nowrap="nowrap">${infolist.dbrlxdh   }</td>
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
		src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"></script>
		<script src="<c:url value='/resources/js/lib/ztree/3.5/jquery.ztree.all-3.5.min.js' />"> </script><!--树-->
	<!-- 根据页面实际情况增删js -->
</body>
</html>