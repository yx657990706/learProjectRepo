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

<div class="page-content"  id="page-content">
	 <fm:form class="form-horizontal" commandName="ct_yjmd_public"  action="publiclist"  method="POST"  id="myform">	
		<!-- 右侧内容 -->
		<div class="row">
			<div class="col-xs-12">
			
				<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange" ></span>
								单位银监黑名单
							</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse">
									<i class="ace-icon fa fa-chevron-up"></i>								</a>							</div>
							</div>
			
							<div class="widget-body">
								<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">客户代号：</label>
											<div class=" col-xs-12 col-sm-8 input-group">
												<fm:input type="text" class="input-large" path="card_code"/>
											</div>
										</div>
									
									<div class="form-group col-xs-12 col-sm-6">
										<label
											class="control-label col-xs-12 col-sm-4 no-padding-right">客户姓名：</label>
										<div class=" col-xs-12 col-sm-8 input-group">
										<fm:input type="text" class="input-large" path="cust_name" />&nbsp;
											<button class="btn btn-info btn-mini" type="button"
												id="submitForm" onclick="_submit('publiclist?isNewSearch=1')">
												<i class="ace-icon glyphicon glyphicon-upload"></i> 查询
											</button>
										</div>
									</div>
								</div>
                              </div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div>
				
								<!-- PAGE CONTENT BEGINS -->

				<div class="widget-box widget-color-blue agg_widgetbox">

					<div class="widget-body">
						<div class="widget-main no-padding">
							<table class="table table-striped table-bordered table-hover"
								id="gs">
								<thead class="thin-border-bottom">
									<tr>
										<th>编码</th>
										<th>客户代号</th>
										<th>客户姓名</th>
										<th>法人注册地</th>
										<th>违约类型</th>
										<th>违约天数</th>
										<th>所属地区</th>
										<th>数据时点</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${ct_yjmd_publicList}" var="publicList" >
										<tr class="text-center">
									   <td nowrap="nowrap">${publicList.serialno}</td>
									   <td nowrap="nowrap">${publicList.card_code}</td>
									   <td nowrap="nowrap">${publicList.cust_name}</td>
									   <td nowrap="nowrap">${publicList.cust_reg_addr}</td>
									   <td nowrap="nowrap">${publicList.deflt_type} </td>
									   <td nowrap="nowrap">${publicList.deflt_day}</td>
									   <td nowrap="nowrap">${publicList.cust_zone_disp}</td>
									   <td nowrap="nowrap">${publicList.data_month}</td>
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
			</div><!-- /.col -->
		</div><!-- /.row -->
		 </fm:form>
		</div>
        <!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
		
</body>
</html>
