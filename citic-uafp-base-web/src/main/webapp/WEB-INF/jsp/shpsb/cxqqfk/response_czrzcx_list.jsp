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
<link href="<c:url value='/resources/js/lib/bootstrap/datepicker/datepicker.min.css ' />"
	rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-content">
<!-- 右侧内容 -->
<div class="row">
<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
  <fm:form class="form-horizontal"  commandName="br54_cxqq_back"  action="response_mx_list"  method="POST">
  <fm:hidden path="bdhm" />
  <div class="widget-box">
    <div class="widget-header widget-header-flat">
        <h5 class="widget-title lighter">
            <span class="glyphicon glyphicon-play-circle orange" ></span>
            <!--前面的图标可加可不加，这种表格就是widget-box-->
            <c:if test="${br54_cxqq_back.qrymode=='dwczrzcx' }">单位操作日志信息</c:if>
            <c:if test="${br54_cxqq_back.qrymode=='grczrzcx' }">个人操作日志信息</c:if>
        </h5>
        <div class="widget-toolbar">
            <a href="#" data-action="collapse">
                <i class="ace-icon fa fa-chevron-up"></i>
            </a> 
         </div>
    </div>
	</div>
	<!-- /.widget-body -->
<!-- PAGE CONTENT BEGINS -->
<div class="widget-box widget-color-blue agg_widgetbox">
    <div class="widget-body">
        <div class="widget-main no-padding">
            <table class="table table-striped table-bordered table-hover"  id="gs">
                <thead class="thin-border-bottom">
                <tr>
                    <th>报文批次号</th>
                    <th>IP地址</th>
                    <th>MAC地址</th>
                    <th>造作类型</th>
                    <th>操作网点</th>
                    <th>操作开始时间</th>
                    <th>操作结束时间</th>
                    <th>经度</th>
                   <th>纬度</th>
                </tr>
                </thead>
                <tbody>
				<c:forEach var="cxqqList"  items="${br54_cxqq_back_czrzList}" >
                <tr class="text-center">
                    <td nowrap>${cxqqList.msgseq}</td>
                    <td nowrap>${cxqqList.ip}</td>
                    <td nowrap>${cxqqList.mac}</td>
                    <td nowrap>${cxqqList.czlx}</td>
                    <td nowrap>${cxqqList.zzwd }</td> 
                    <td nowrap>${cxqqList.czkssj} </td>
                    <td nowrap>${cxqqList.czjssj }</td>
                    <td nowrap>${cxqqList.lng }</td>
                    <td nowrap>${cxqqList.lat }</td>
                </tr>
                </c:forEach>
	               </tbody>
				</table>
		</div>
	   </div>
 </div>
		<c:out value="${pageInfoStr}" escapeXml="false"></c:out>
	</fm:form>
	 </div><!-- /.widget-main -->
    </div><!-- /.widget-body -->
</div>
<jsp:include page="../../fragments/base_js.jsp"/>
<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>