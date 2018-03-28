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
		<!-- 右侧内容 -->
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
                                                            <td width="25%">${br41_kzqq.qqdbs }</td>
                                                            <td width="25%">请求措施类型：</td>
                                                            <td width="25%">${br41_kzqq.qqcslx_disp }</td>
                                                        </tr>
                                                        <tr>
                                                            <td>申请机构代码：</td>
                                                            <td>${br41_kzqq.sqjgdm_disp }</td>
                                                            <td>目标机构代码：</td>
                                                            <td>${br41_kzqq.mbjgdm_disp }</td>

                                                        </tr>
                                                        <tr>
                                                            <td>查询主体类别：</td>
                                                            <td>${br41_kzqq.ztlb_disp}</td>
                                                            <td>案件类型：</td>
                                                            <td>${br41_kzqq.ajlx_disp}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>发送时间：</td>
                                                            <td>${br41_kzqq.fssj}</td>
                                                            <td>紧急程度：</td>
                                                            <td>${br41_kzqq.jjcd_disp}</td>
                                                        </tr>

                                                        <tr>
                                                            <td>备注：</td>
                                                            <td colspan="3">${br41_kzqq.beiz}</td>
                                                        </tr>

                                                    </table>
                                                </div>


                                                

                                                <h4 class="header blue bolder smaller">查询人数据项</h4>
                                                <div class="agg_GridDetail">
                                                    <table>
                                                        <tr>
                                                            <td width="25%">请求人姓名：</td>
                                                            <td width="25%">${br41_kzqq.qqrxm}</td>
                                                            <td width="25%">请求人证件类型：</td>
                                                            <td width="25%">${br41_kzqq.qqrzjlx_disp}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>请求人证件号码：</td>
                                                            <td>${br41_kzqq.qqrzjhm}</td>
                                                            <td>请求人手机号：</td>
                                                            <td>${br41_kzqq.qqrsjh}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>请求人单位名称：</td>
                                                            <td colspan="3">${br41_kzqq.qqrdwmc}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>协查人姓名：</td>
                                                            <td>${br41_kzqq.xcrxm}</td>
                                                            <td>协查人证件类型：</td>
                                                            <td>${br41_kzqq.xcrzjlx_disp}</td>
                                                        </tr>

                                                        <tr>
                                                            <td>协查人证件号码：</td>
                                                            <td>${br41_kzqq.xcrzjhm}</td>
                                                        </tr>


                                                    </table>
                                                </div>
											</div>
										</div>
									</div>

                                    <!--附件-->
                                    <div class="Ar_other">
                                        <h5><i class="fa fa-paperclip"></i>附件</h5>
                                        <c:forEach  items="${br40_wh_attachList }" var="attachList">
                                        
       &nbsp; &nbsp; &nbsp; &nbsp;<span>${attachList.wjmc }:<i class="ace-icon fa fa-file-pdf-o bigger-110 light-red"></i>&nbsp;&nbsp;<a href="${attachList.filepath }" class="editable editable-click" target="_blank">${attachList.wjlx }</a></span><br />
                                        
                                        </c:forEach>
                                       
                                    </div>

									<!-- PAGE CONTENT ENDS -->

								</div><!-- /.col -->
							</div><!-- /.row -->

				</div>
			</div><!-- /.col -->

	<!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
	<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />"></script><!--page plugin:datepicker日期选择器-->
	<script src="<c:url value='/resources/js/agg/jquery.validator.js' />"></script>
	<script src="<c:url value='/resources/js/lib/chosen/chosen.jquery.min.js' />"></script><!--page plugin:select下拉菜单/自动完成-->
	<script src="<c:url value='/resources/js/agg/jquery.inputlimiter.1.3.1.min.js' />"></script><!-- 文本域输入计数 -->
	<script src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"></script><!-- 文本域自适应高度 -->
	<script type="text/javascript">
			jQuery(function($) {

				$('#accordion-style').on('click', function(ev){
					var target = $('input', ev.target);
					var which = parseInt(target.val());
					if(which == 2) $('#accordion').addClass('accordion-style2');
					 else $('#accordion').removeClass('accordion-style2');
				});
				});

		</script>

	</body>
</html>