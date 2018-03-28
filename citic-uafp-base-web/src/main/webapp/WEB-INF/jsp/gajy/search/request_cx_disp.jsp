<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>请求单信息</title>
		<jsp:include page="../../fragments/base_css.jsp"/>
	</head>
	<body>
		<div class="page-content">
			<fm:form class="form-horizontal"  commandName="br40_cxqq"  action="request_cx_disp"  method="POST">
				    <input type="hidden"  id="d_file_name"  name="d_file_name"/>
		           	<input type="hidden"  name="d_file_path"   id="d_file_path" />
							<div class="row">
								<div class="col-xs-12">


									<!-- PAGE CONTENT BEGINS -->

									<div class=" widget-color-blue agg_widgetbox">

										<div class="widget-body">
											<div class="widget-main no-padding">
                                                <h4 class="header blue bolder smaller">查询请求基本数据项</h4>
                                                <div class="agg_GridDetail">
                                                    <table>
                                                        <tr>
                                                            <td width="25%">请求单标识：</td>
                                                            <td width="25%">${br40_cxqq.qqdbs }</td>
                                                            <td width="25%">请求措施类型：</td>
                                                            <td width="25%">${br40_cxqq.qqcslx_disp }</td>
                                                        </tr>
                                                        <tr>
                                                            <td>申请机构代码：</td>
                                                            <td>${br40_cxqq.sqjgdm_disp }</td>
                                                            <td>目标机构代码：</td>
                                                            <td>${br40_cxqq.mbjgdm_disp }</td>

                                                        </tr>
                                                        <tr>
                                                            <td>查询主体类别：</td>
                                                            <td>${br40_cxqq.ztlb_disp}</td>
                                                            <td>案件类型：</td>
                                                            <td>${br40_cxqq.ajlx}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>发送时间：</td>
                                                            <td>${br40_cxqq.fssj}</td>
                                                            <td>紧急程度：</td>
                                                            <td>${br40_cxqq.jjcd_disp}</td>
                                                        </tr>

                                                        <tr>
                                                            <td>备注：</td>
                                                            <td colspan="3">${br40_cxqq.beiz}</td>
                                                        </tr>

                                                    </table>
                                                </div>


                                                

                                                <h4 class="header blue bolder smaller">查询人数据项</h4>
                                                <div class="agg_GridDetail">
                                                    <table>
                                                        <tr>
                                                            <td width="25%">请求人姓名：</td>
                                                            <td width="25%">${br40_cxqq.qqrxm}</td>
                                                            <td width="25%">请求人证件类型：</td>
                                                            <td width="25%">${br40_cxqq.qqrzjlx_disp}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>请求人证件号码：</td>
                                                            <td>${br40_cxqq.qqrzjhm}</td>
                                                            <td>请求人手机号：</td>
                                                            <td>${br40_cxqq.qqrsjh}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>请求人单位名称：</td>
                                                            <td colspan="3">${br40_cxqq.qqrdwmc}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>协查人姓名：</td>
                                                            <td>${br40_cxqq.xcrxm}</td>
                                                            <td>协查人证件类型：</td>
                                                            <td>${br40_cxqq.xcrzjlx_disp}</td>
                                                        </tr>

                                                        <tr>
                                                            <td>协查人证件号码：</td>
                                                            <td>${br40_cxqq.xcrzjhm}</td>
                                                        </tr>


                                                    </table>
                                                </div>
											</div>
										</div>
									</div>

                                    <!--附件-->
                                    <div class="Ar_other">
                                        <h5><i class="fa fa-paperclip"></i>附件</h5>
                                        <c:forEach  items="${br40_wh_attachList}" var="attachList">
                                        
       &nbsp; &nbsp; &nbsp; &nbsp;<span>
        <a href='#' onclick="_download('${attachList.filepath}','${attachList.wjmc}.${attachList.wjlx}')"> 
       ${attachList.wjmc}.${attachList.wjlx }<i class="ace-icon fa fa-file-pdf-o bigger-110 light-red"></i>&nbsp;&nbsp;
       </a></span><br />
                                        
                                        </c:forEach>
                                       
                                    </div>

									<!-- PAGE CONTENT ENDS -->

								</div><!-- /.col -->
							</div><!-- /.row -->
           </fm:form>
				</div>
			</div>

	<!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	

	</body>
</html>