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

				<fm:form class="form-horizontal"  commandName="br40_city_no"  action="list"  method="POST">
					  <input type="hidden"  id="url"  name="url" />
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								城市代号管理
							</h5>
							<div class="widget-toolbar">
							 <a href="javaScript:void(0)" onclick="testResport('<c:url value="/br40_acct_rule/resport_rule?type=3"/>')">
					              <i class="ace-icon fa fa-paper-plane green"></i>
					               		 上报	</a>&nbsp;
					           <a href="add" >
					                <i class="ace-icon fa fa-plus-circle orange"></i>
					               		 添加	</a>
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
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right">城市名称：</label>
                             <div class="input-group col-xs-12 col-sm-8">
                               <fm:input type="text" path="cityname" class="input-large" />
                            </div>
                        </div>
                       <div class="form-group col-xs-12 col-sm-6">
											<label
												class="control-label col-xs-12 col-sm-4 no-padding-right">最后修改时间：</label>

											<div class="input-group col-xs-6 col-sm-6 ">

												<fm:input class="form-control date-picker"
													path="lastts_start" type="text"
													data-date-format="yyyy-mm-dd" />
												<span class="input-group-addon"> <i
													class="fa fa-arrows-h"></i>
												</span>
												<fm:input class="form-control date-picker"
													path="lastts_end" type="text"
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
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >城市代号：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                               <fm:input type="text" path="cityno" class="input-large" />
                            </div>
                        </div>

                        <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >最后修改人：</label>
                            <div class="col-xs-12 col-sm-8 no-padding-left">
                                  <fm:input type="text" path="lastuser" class="input-large" />&nbsp;
                                <button class="btn btn-info btn-mini" type="button" onclick="_submit('list?isNewSearch=1')">
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
								<table class="table table-striped table-bordered table-hover">
									<thead class="thin-border-bottom">
										<tr>
											<th>操作</th>
											<th>唯一标识</th>
											<th>城市代号</th>
											<th>城市名称</th>
											<th>对应银行名称</th>
											<th>最后修改人</th>
											<th>最后修改时间</th>
											<th>标记</th>
											<th>备注</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="noList"  items="${br40_city_noList}" >
											<tr class="text-center">
												<td nowrap="nowrap">
												<a href="${noList.uniqueid}/modify?uniqueid=${noList.uniqueid}" ><i class="ace-icon fa fa-pencil green" title="编辑"></i></a>&nbsp;
												<a href="#" id="deleteId" onclick="testCancel('${noList.uniqueid}/delete?uniqueid=${noList.uniqueid}')"> <i class="ace-icon fa fa-trash-o red" title="删除"></i></a>
												</td>
                                    	        <td nowrap="nowrap"> ${noList.uniqueid}</td>
												<td nowrap="nowrap">${noList.cityno}</td>
												<td nowrap="nowrap"> ${noList.cityname}</td>
												<td nowrap="nowrap"> ${noList.other_organ_disp}</td>
												<td nowrap="nowrap"> ${noList.lastuser}</td>
												<td nowrap="nowrap"> ${noList.lastts}</td>
												<td nowrap="nowrap"> 
									        	<c:if test="${noList.flag=='0'}">
									        	<span class="label label-inverse arrowed">
												<c:out value="${noList.flag_disp}" /></span>
												</c:if>
												<c:if test="${noList.flag == '1' }">
												<span class="label label-info arrowed-in arrowed-in-right">
												<c:out value="${noList.flag_disp}" /></span>
												</c:if>
									        	<c:if test="${noList.flag == '2' }">
												 <span class="label label-danger arrowed-in arrowed-in-right">
												<c:out value="${noList.flag_disp}" /></span>
												</c:if>
									        	 </td>
												<td nowrap="nowrap"> ${noList.remark}</td>
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
<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
	<script type="text/javascript">
	 //get方式提交表单
    function _submit_get(url){
    	   document.forms[0].method="POST";
    	   document.forms[0].action=url;
		   document.forms[0].submit();
    }
	function testCancel(url){
		 $("#url").val(url);
		 agg.dialogConfirm("您确定要删除吗?", okDo, closeDo);  
	}
	//上报确认
	function testResport(url){
		$("#url").val(url);
		agg.dialogConfirm("您确定要上报吗?", okDo, closeDo);  
		
	}
	 function closeDo() {
		}
	 function okDo(){
		 _submit_get($("#url").val());  
	    	}
	</script>
</body>
</html>