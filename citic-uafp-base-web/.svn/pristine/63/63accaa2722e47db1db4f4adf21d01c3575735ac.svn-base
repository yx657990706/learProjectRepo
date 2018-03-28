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
<!-- 右侧内容 -->
<div class="row">
<div class="col-xs-12">

<!-- PAGE CONTENT BEGINS -->
  <fm:form class="form-horizontal"  commandName="br54_cxqq_back"  action="response_list"  method="POST">
  <div class="widget-box">
    <div class="widget-header widget-header-flat">
        <h5 class="widget-title lighter">
            <span class="glyphicon glyphicon-play-circle orange" ></span>
             核心反馈信息<!--前面的图标可加可不加，这种表格就是widget-box-->
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
                     <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >报文批次号：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:input type="text" path="msgseq" class="input-large" />
                            </div>
                        </div>
                           <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >核心反馈结果：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:select path="cljg" class=" input-medium"  items="${cljgMap }"/>
                            </div>
                        </div>
                      
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                  
                        <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >案号：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:input type="text" path="ah" class="input-large" />
                            </div>
                        </div>
                       <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" >查询类型：</label>
                            <div class="input-group col-xs-12 col-sm-8">
                                <fm:select path="qrymode" class=" input-medium"  items="${qrymodeMap }"/>
                            </div>
                        </div>
                    </div>
                </div>

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
                        <div class="form-group col-xs-12 col-sm-6">
                            <label class="control-label col-xs-12 col-sm-4 no-padding-right" ></label>
                            <div class="col-xs-12 col-sm-8 no-padding-left">
                                <button class="btn btn-info btn-mini" type="button" onclick="_submit('response_list?isNewSearch=1')">
                                    <i class="glyphicon glyphicon-search"></i>
                                 		   查询
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
 	    </div>
	</div>
		<!-- /.widget-main -->
	</div>
	<!-- /.widget-body -->
<!-- PAGE CONTENT BEGINS -->
<div class="widget-box widget-color-blue agg_widgetbox">
    <div class="widget-body">
        <div class="widget-main no-padding">
            <table class="table table-striped table-bordered table-hover"  id="gs">
                <thead class="thin-border-bottom">
                <tr>
                    <th>请求单号</th>
                    <th>案号</th>
                    <th>报文批次号</th>
                    <th>查询类型</th>
                    <th>核心反馈结果</th> 
                    <th>核心反馈说明</th>
                 <!--    <th>核心处理状态</th>  -->
                    <th>查询日期</th>
                    <th>归属机构</th>
                   <th>最后修改时间</th>
                </tr>
                </thead>
                <tbody>
				<c:forEach var="cxqqList"  items="${br54_cxqq_backList}" >
                <tr class="text-center">
                    <td nowrap><a href="response_main?bdhm=${cxqqList.bdhm }&party_class_cd=${cxqqList.party_class_cd }&qrymode=${cxqqList.qrymode }&msgseq=${cxqqList.msgseq } "> ${cxqqList.bdhm}</a></td>
                    <td nowrap>${cxqqList.ah }</td>
                    <td nowrap>${cxqqList.msgseq }</td>
                    <td nowrap>${cxqqList.qrymode_disp } </td>
                    <td nowrap> 
                    <c:if test="${cxqqList.cljg=='0'}">
						<span class="label label-success arrowed-in arrowed-in-right"> 成功</span>
						</c:if>
						<c:if test="${cxqqList.cljg=='1'}">
						<span class="label label-danger arrowed-in arrowed-in-right"> 失败</span>
						</c:if>
                    </td>
                    <td nowrap>${cxqqList.czsbyy }</td>
                   <%--  <td nowrap> ${cxqqList.status_disp} </td> --%>
                    <td nowrap>${cxqqList.qrydt }</td>
                    <td nowrap>${cxqqList.orgkey_disp }</td>
                    <td nowrap>${cxqqList.last_up_dt }</td>
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