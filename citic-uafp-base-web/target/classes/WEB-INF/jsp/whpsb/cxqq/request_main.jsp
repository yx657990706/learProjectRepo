<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
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
   <fm:form class="form-horizontal"  commandName="br51_cxqq_mx"  action="list"  method="POST">
<div class="row">
<div class="col-sm-12">
<div class="tabbable">
    <ul class="nav nav-tabs" id="myTab">
        <li class="active">
            <a data-toggle="tab" href="#home" onclick="_changeIframe('<c:url value="/br51_cxqq_mx/list?isNewSearch=1&party_class_cd=${br51_cxqq.party_class_cd }&qrymode=${br51_cxqq.qrymode }&msgseq=${br51_cxqq.msgseq }"/>','0901')"><i class="green ace-icon fa fa-home bigger-120"></i>请求单信息</a>
        </li>

       <li>
            <a data-toggle="tab" href="#profile" onclick="_changeIframe('<c:url value="/br51_cxqq/attach_list?isNewSearch=1&packetkey=${br51_cxqq.packetkey}"/>','0902'"><i class="ace-icon fa fa-user blue bigger-120"></i>请求文书信息</a>
        </li>  
        
         <li>
            <a data-toggle="tab" href="#file" onclick="_changeIframe('<c:url value="/br51_cxqq_back/response_ws_list?isNewSearch=1&msgseq=${br51_cxqq.msgseq }"/>','0903'"><i class="ace-icon fa fa-user blue bigger-120"></i>反馈文件信息</a>
        </li>
        <div class="widget-toolbar"  style="line-height: 34px">
         <!--  <a href="#" onclick="window.history.back()">
                                <i class="ace-icon fa fa-check red"></i>
                                提交核心
              </a>&nbsp;&nbsp; -->
            <a href='<c:url value="/br51_cxqq/list"/>'>
                <i class="ace-icon fa fa fa-arrow-circle-left green"></i>
                返回
            </a>

        </div>
    </ul>
</div>

<div class="tab-content">

<div id="home" class="tab-pane fade in active">

    <iframe src="<c:url value="/br51_cxqq_mx/list?isNewSearch=1&party_class_cd=${br51_cxqq.party_class_cd }&qrymode=${br51_cxqq.qrymode }&msgseq=${br51_cxqq.msgseq }"/>" width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>

</div>
 <div id="profile" class="tab-pane fade">

    <iframe src="<c:url value="/br51_cxqq/attach_list?isNewSearch=1&packetkey=${br51_cxqq.packetkey}"/>" width="100%" height="500" scrolling="auto" frameborder="0"  id="0902"></iframe>

</div> 
 <div id="file" class="tab-pane fade">

    <iframe src="<c:url value="/br51_cxqq_back/response_ws_list?isNewSearch=1&msgseq=${br51_cxqq.msgseq }"/>" width="100%" height="500" scrolling="auto" frameborder="0"  id="0903"></iframe>

</div> 
</div>
</div><!-- /.col -->
</div><!-- /.row -->
	</fm:form>
 </div><!-- /.widget-main -->

<jsp:include page="../../fragments/base_js.jsp"/>

<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>