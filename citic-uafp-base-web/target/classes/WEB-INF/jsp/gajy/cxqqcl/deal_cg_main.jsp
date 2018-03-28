<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>反馈基本数据项</title>
		<jsp:include page="../../fragments/base_css.jsp"/>
	</head>
<body>
     <div class="widget-box transparent">
		<div class="widget-body">
			<div class="widget-main no-padding"><!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
			</div><!-- /.widget-main -->
		</div><!-- /.widget-body -->
		</div>
	<div class="space-8"></div>
				
	<div class="page-content">
		<fm:form  class="form-horizontal"  commandName="br40_cxqq"  action="deal_cg_main"  id="modifyfrozenbackform"  method="POST">

			<div class="row">
				<div class="col-sm-12">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-16" id="myTab3">
							<li class="active" id="li1">
								<a data-toggle="tab" href="#trans1"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_cg_disp?qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}&cxnr=${cxnr}"/>','0901')" >
									<i class="green ace-icon fa fa-home bigger-120"></i>反馈基本数据项
								</a>
							</li>
							<c:if test="${cxnr!='02'}">
							<li id="li2">
								<a data-toggle="tab"  href="#trans2"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_cust_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0902')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>客户信息
								</a>
							</li> 
							<li id="li2">
								<a data-toggle="tab"  href="#trans3"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_acct_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0903')">
 
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>账户信息
								</a>
							</li> 
							<li id="li4">
								<a data-toggle="tab"  href="#trans4"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_qzcs_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0904')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>强制措施
								</a>
							</li> 
							<li id="li5">
								<a data-toggle="tab"  href="#trans5"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_ql_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0905')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>共有权/优先权
								</a>
							</li> 
							<li id="li6">
								<a data-toggle="tab"  href="#trans6"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_sub_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0906')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>关联子账户
								</a>
							</li> 
							</c:if>
						   <c:if test="${cxnr=='02' || cxnr=='03'}">
							<li id="li7">
								<a data-toggle="tab"  href="#trans6"  onclick="_changeIframe('<c:url value="/br40_cxqq_mx/deal_acct_trans_info?isNewSearch=1&qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}"/>','0906')">
									<i class="green ace-icon fa fa-cloud orange bigger-120"></i>账户交易流水
								</a>
							</li> 
						    </c:if>
						    
							<c:if test="${resource=='2'}">
							<div class="widget-toolbar" style="line-height: 34px">
								<a href="#"  onclick="_submit('<%=request.getContextPath() %>/br40_cxqq/gajy_send?tasktype=${tasktype}&qqdbs=${qqdbs}&rwlsh=${rwlsh}&flag=2') "  >
                                		<i class="ace-icon glyphicon glyphicon-repeat orange"></i>
                                		<c:if test="${cbrc_check_flag=='1' }">提交</c:if>
                                			<c:if test="${cbrc_check_flag!='1' }">发送监管机构</c:if>
                                </a>&nbsp;&nbsp;
								<a href="<c:url value="/br40_cxqq/deal_list?isNewSearch=1&tasktype=${tasktype}"/>"	>
									<i class="ace-icon fa fa fa-arrow-circle-left green"></i> 返回
								</a> 
								
							</div>
							</c:if>
						</ul>

						<div class="tab-content">
							<div id="trans1" class="tab-pane fade in active">
								<iframe src="<c:url value="/br40_cxqq_mx/deal_cg_disp?qqdbs=${qqdbs}&qqcslx=${qqcslx}&rwlsh=${rwlsh}&tasktype=${tasktype}&cxnr=${cxnr}"/>"  width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>
							</div>

							<div id="trans2" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0902"></iframe>
							</div>
							<div id="trans3" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0903"></iframe>
							</div>
							<div id="trans4" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0904"></iframe>
							</div>
							
							<div id="trans5" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0905"></iframe>
							</div>
							<div id="trans6" class="tab-pane fade">
								<iframe src="#" width="100%" height="500" scrolling="auto" frameborder="0"  id="0906"></iframe>
							</div>
							
						    </div>
						
						
					</div>
				</div>
			</div>
		</fm:form>
	</div>

	<!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	
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