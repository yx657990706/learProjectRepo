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
<div class="page-content" id="page-content">
<!-- 右侧内容 -->
<div class="row">
<div class="col-xs-12">
  <fm:form class="form-horizontal"  commandName="br51_attach"  action="attach_list"  method="POST">
<!-- PAGE CONTENT BEGINS -->
<input  type="hidden" id="d_file_name" name="d_file_name"/>
<input type="hidden" id="d_file_path" name="d_file_path"/>
<div class="widget-box">
    <div class="widget-header widget-header-flat">
        <h5 class="widget-title lighter">
            <span class="glyphicon glyphicon-play-circle orange" ></span>
              查询文书证件信息<!--前面的图标可加可不加，这种表格就是widget-box-->
        </h5>
        <div class="widget-toolbar">

            <a href="#" data-action="collapse">
                <i class="ace-icon fa fa-chevron-up"></i></a> 
         </div>
    </div>

    <div class="widget-body">
        <div class="widget-main">

         

                <div class="row">
                    <div class="col-xs-12">
                       
                       
                        <div class="form-group col-xs-6 col-sm-6">
                            <label class="control-label col-xs-4 col-sm-4 no-padding-right">查询日期：</label>

                            <div class="col-xs-8 col-sm-8 input-group" >
                                <fm:input class="form-control date-picker" path="qrydt_start" data-date-format="yyyy-mm-dd" />
                                                                     <span class="input-group-addon">
                                                                       <i class="fa fa-arrows-h"></i>
                                                                      </span>
                                <fm:input class="form-control date-picker" path="qrydt_end" data-date-format="yyyy-mm-dd" />
                                                                     <span class="input-group-addon">
                                                                      <i class="fa fa-calendar bigger-110"></i>
                                                                     </span>

                            </div>

                        </div>
                        
                         <div class="form-group col-xs-6 col-sm-6">
                            <label class="control-label col-xs-4 col-sm-4 no-padding-right">文件名称：</label>

                             <div class="col-xs-12 col-sm-8 no-padding-left">
                                <fm:input type="text" path="wjmc" class="input-large"/>
                                 &nbsp;
                                <button class="btn btn-info btn-mini" type="button" onclick="_submit('attach_list?isNewSearch=1')">
                                <i class="glyphicon glyphicon-search"></i>
                                 		   查询
                                </button>
                            </div>

                        </div>

                    </div>
                </div>
                
</div>
	<!-- /.col -->
</div>
<!-- /.row -->
</div>
       
<!-- PAGE CONTENT BEGINS -->
<div class="widget-box widget-color-blue agg_widgetbox">
    <div class="widget-body">
        <div class="widget-main no-padding">
            <table class="table table-striped table-bordered table-hover" >
                <thead class="thin-border-bottom">
                <tr>
                    <th>数据包名称</th>
                    <th>序号</th>
                    <th>文件名称</th>
                    <th>文书类型</th>
                 <!-- <th>文书地址</th>  -->
                    <th>查询日期</th>
                    <th>下载</th>
                </tr>
                </thead>

                <tbody>
				<c:forEach var="attachList"  items="${br51_attachList}" >
                <tr class="text-center">
                    <td nowrap> ${attachList.packetkey }</td>
                    <td nowrap>${attachList.xh }</td>
                   <td> 
                     ${attachList.wjmc}
                    </td>
                   <%--  <td nowrap>${attachList.wjmc }</td>  --%>
                    <td nowrap>${attachList.wjlx } </td>
                    <%--  <td nowrap>${attachList.wspath } </td> --%>
                    <td nowrap>${attachList.qrydt }</td>
                    <td>
                     <c:if test="${attachList.wspath!=''}">
                     <a href='#' onclick="_download('${attachList.wspath}','${attachList.wjmc}')"> 
                      <i class="glyphicon glyphicon-download-alt  blue"></i> </a>                
                     </c:if>
                     </td>    
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
</body>
</html>