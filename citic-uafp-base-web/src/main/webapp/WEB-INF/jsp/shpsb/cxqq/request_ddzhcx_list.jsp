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
<div class="row">
                    <div class="col-xs-12">
<!-- 右侧内容 -->
<fm:form class="form-horizontal"  commandName="br54_cxqq_mx"  action="request_mx_list"  method="POST">
<!-- PAGE CONTENT BEGINS -->
<fm:hidden path="party_class_cd"/>
     <fm:hidden path="qrymode"/>
      <fm:hidden path="msgseq"/>
<div class="widget-box">
    <div class="widget-header widget-header-flat">
        <h5 class="widget-title lighter">
            <span class="glyphicon glyphicon-play-circle orange" ></span>
             <c:if test="${br54_cxqq_mx.qrymode=='dwddzhcx' }">单位对端账号查询</c:if>
            <c:if test="${br54_cxqq_mx.qrymode=='grddzhcx' }">个人对端账号查询</c:if>
        </h5>
        <div class="widget-toolbar">
            <a href="#" data-action="collapse">
                <i class="ace-icon fa fa-chevron-up"></i> </a> 
                 <a href='<c:url value="/br54_cxqq/list"/>'>
                <i class="ace-icon fa fa fa-arrow-circle-left green"></i>
                返回
            </a>
                </div>
    </div>
    <div class="widget-body">
        <div class="widget-main">
             <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >请求单号：</label>

                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:input type="text" path="bdhm" class="input-large" />
                            </div>
                        </div>

                        <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >案号：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:input type="text" path="ah" class="input-large" />
                                 &nbsp;
                                <button class="btn btn-info btn-mini" type="button" onclick="_submit('request_mx_list?isNewSearch=1')">
                                    <i class="glyphicon glyphicon-search"></i>
                                    查询
                                </button>
                            </div>
                        </div>

                    </div>
                </div>
   </div>
    </div>
	<!-- /.col -->
</div><!-- /.row -->    
<!-- PAGE CONTENT BEGINS -->
<div class="widget-box widget-color-blue agg_widgetbox">
    <div class="widget-body">
        <div class="widget-main no-padding">
            <table class="table table-striped table-bordered table-hover"  id="gs">
                <thead class="thin-border-bottom">
                <tr>
                    <th>请求单号</th>
                    <th>案号</th>
                    <th>承办人单位</th>
                    <th>承办人1</th>
                    <th>承办人2</th>
                    <th>交易关联号</th>
                </tr>
                </thead>
                <tbody>
				<c:forEach var="mxList"  items="${br54_cxqq_mxList}" >
                <tr class="text-center">
                    <td nowrap>${mxList.bdhm }</td> 
                    <td nowrap>${mxList.ah }</td>    
                    <td nowrap>${mxList.cbdw }</td>
                    <td nowrap>${mxList.cbr1 }</td>
                    <td nowrap>${mxList.cbr2 }</td>
                    <td nowrap>${mxList.jyglh }</td>
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
</div>
		</div>

<jsp:include page="../../fragments/base_js.jsp"/>

<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
</body>
</html>