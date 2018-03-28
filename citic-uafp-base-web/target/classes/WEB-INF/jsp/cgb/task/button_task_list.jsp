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
		<fm:form class="form-horizontal" commandName="button_task" action="list" method="POST">
            <!-- 隐藏域 -->
			<input type="hidden"  id="r_url" name="r_url"  value="<c:url value="/button_task/list?isNewSearch=1" />">
            <input type="hidden"  id="url"  name="url" />
            <input type="hidden"  id="massege"  name="massege" value="${massege}"/>
            
			<!-- 右侧内容 -->
			<div class="row">
				<div class="col-xs-12">

					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-box">
						<div class="widget-header widget-header-flat">
							<h5 class="widget-title lighter">
								<span class="glyphicon glyphicon-play-circle orange"></span>
								按钮任务监控
							</h5>

						</div>

						<div class="widget-body">
							<div class="widget-main no-padding">
								<table class="table table-striped table-bordered table-hover"
									id="gs">
									<thead class="thin-border-bottom">
										<tr>
											<th width="5%">序号</th>
											<th width="15%">操作</th>
											<th width="80%">描述</th>
										</tr>
									</thead>

									<tbody>
										<tr class="text-center">
											<td>01</td>
											<td class="align-middle" nowrap="nowrap">
												<button class="btn btn-info btn-mini" type="button" onclick="myOnclick('<c:url value="/button_task/GF_recal" />',false)"
													id="submitForm">GF重发</button>
											</td>
											<td class="align-left">高法task3返回监管了，但是由于网络等原因造成结果是fail的数据，需要重发</td>
										</tr>
										<tr class="text-center">
											<td>02</td>
											<td class="align-middle" nowrap="nowrap">
													<label >
													    <c:choose>
													       <c:when test="${gfkg=='1'}">
													         <input class="ace ace-switch ace-switch-7" id = "02" type="checkbox" checked="checked" onchange="mySwitch('<c:url value="/button_task/GF_setpz?vals=${gfkg}" />','02',true)"/>
													       </c:when>
													       <c:otherwise>
													         <input class="ace ace-switch ace-switch-7" id = "02" type="checkbox" onchange="mySwitch('<c:url value="/button_task/GF_setpz?vals=${gfkg}" />','02',false)"/>
													       </c:otherwise>
													    </c:choose>
														<span class="lbl middle"></span>
													</label>
													
											</td>
											<td class="align-left">最高法外联轮询服务是否获取控制请求</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.widget-body -->
					</div>


				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</fm:form>
	</div>
	<!-- basic scripts -->
	<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script type="text/javascript">
	jQuery(document).ready(function() {
		var massege = $("#massege").val();
		if(massege != ""){
			var msg = massege.split("@");
			agg.dialogAlert(msg[0]+"任务执行"+(msg[1]=="true"?"成功":"失败"),"face-smile");
		}
	});
   /**
    *按钮事件
    */
	function myOnclick(url,flag) {
		 $("#url").val(url);
		 //是否刷新页面
		 if(flag){
			 agg.dialogConfirm("确认要执行吗?",okDoA,closeDo);	
		 }else{
			 agg.dialogConfirm("确认要执行吗?",okDoB,closeDo);	
		 }
	}
	
    //开关事件（需要刷新页面）
    function mySwitch(url,id,flag){
    	$("#url").val(url);
    	agg.dialogConfirm("确认要执行吗?",okDoA,myCloseDo(id,flag));	
    }
   
    /**
    *ajax提交并刷新页面
    */
	function okDoA() {
  	  $.ajax({
				type : "post",
				url  : $("#url").val(),
				data :$("#myform").serialize(),
				async: false,//同步加载
				success : function(res) {
				   if(res!=null && res!=""){
					   var url = $("#r_url").val()+"&msg="+res;
					   _submit(url);
				   }
				}
			});
	}
    
	/**
	 *ajax提交并刷新页面
	 */
	function okDoB() {
    	  $.ajax({
				type : "post",
				url  : $("#url").val(),
				data :$("#myform").serialize(),
				async: false,//同步加载
				success : function(res) {
				   if(res!=null && res!=""){
					   var msg = res.split("@");
					   agg.dialogAlert(msg[0]+"任务执行"+(msg[1]=="true"?"成功":"失败"),"face-smile");
				   } 
				}
			});
	}

	   //get方式提交表单
    function _submit_get(url){
    	   document.forms[0].method="GET";
    	   document.forms[0].action=url;
		   document.forms[0].submit();
    }
    function myCloseDo(id,flag){
		var val = $("#"+id).prop("checked",flag);
    }
    </script>
</body>
</html>
