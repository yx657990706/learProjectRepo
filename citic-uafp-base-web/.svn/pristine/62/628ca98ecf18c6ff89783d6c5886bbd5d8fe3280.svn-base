<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<jsp:include page="../fragments/base_css.jsp" />

</head>
<body>
	<div class="page-content" id="page-content">
		<fm:form id="myform" commandName="cgb_face_data" class="form-horizontal" action="modify" method="POST"   >
		<input type="hidden"  id="url"  name="url" />
		<input type="hidden"  id="delurl"  name="delurl" />
		<input type="hidden" name="gID" value="${face_data.group_id}&${face_data.data_source}"/>
			<div>
			    <div class="widget-toolbar">
								<a href="#" onclick="do_tj('<c:url value="/cgb_face_data/check_do_inner?identify_result=0" />','确定不通过')"> <i
									class="ace-icon glyphicon glyphicon-remove red"></i> 不通过
								</a>&nbsp;&nbsp; <a href="#" onclick="do_tj('<c:url value="/cgb_face_data/check_do_inner?identify_result=2" />','确定灰名单')"> <i
									class="ace-icon fa fa-plus-circle grey"></i> 灰名单
								</a>&nbsp;&nbsp; <a href="#" onclick="do_tj('<c:url value="/cgb_face_data/check_do_inner?identify_result=1" />','确定黑名单')"> <i
									class="ace-icon fa fa-paper-plane infobox-black"></i> 黑名单
								</a>&nbsp;&nbsp; <a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i></a>
							</div>
                <div class="col-xs-12">
                                        <ul class="ace-thumbnails clearfix">
                                            <li>
                                                <a href="#" data-rel="colorbox">
                                                    <img width="220" height="230"alt="220x230" src="${face_data.suspect_img}" title="嫌疑人图像"/>

                                                   <div class="text">
													<div class="inner">
														<div style="text-align: left">被冒用人证件类型：${face_data.victim_card_type_disp}</div>
														<div style="text-align: left">被冒用人证件号码：${face_data.victim_card_num}</div>
														<div style="text-align: left">被冒用人姓名：${face_data.victim_name}</div>
														<div style="text-align: left">证件有效期：${face_data.victim_card_validity}</div>
														<div style="text-align: left">风险类型：${face_data.risk_type_disp}</div>
														<div style="text-align: left">办理网点：${face_data.busi_website}</div>
														<div style="text-align: left">办理柜员：${face_data.busi_teller_num}</div>
														<div style="text-align: left">办理时间：${face_data.busi_time}</div>
														<div style="text-align: left">办理类型：${face_data.busi_type}</div>
													</div>
												</div>
												<div class="tools tools-top">
													<a href="#"
														onclick="_OpenXLarge('<c:url value="/cgb_face_data/${face_data.suspect_img_id}/modify" />','修改名单信息')">
														<i class="ace-icon fa fa-pencil"></i>
													</a> 
												</div>
                                                </a>
                                            </li>
                                            <li>
                                                    <img width="220" height="230"alt="220x230" src="${face_data.victim_img}" title="受害人图像" />
                                            </li>
                                            <c:if test="${face_data.assist_img_1 != ''}">
                                            <li>
                                                    <img width="220" height="230"alt="220x230" src="${face_data.assist_img_1}" title="辅助证件图像1"  />
                                            </li>
                                            </c:if>
                                            <c:if test="${face_data.assist_img_2 != ''}">
                                            <li>
                                                    <img width="220" height="230"alt="220x230" src="${face_data.assist_img_2}" title="辅助证件图像2"  />
                                            </li>
                                            </c:if>
                                            <c:if test="${face_data.assist_img_3 != ''}">
                                            <li>
                                                    <img width="220" height="230"alt="220x230" src="${face_data.assist_img_3}" title="辅助证件图像3"  />
                                            </li>
                                            </c:if>
                                            
                                        </ul>
                                    </div>
                                    <c:if test="${cgb_face_dataList != null}">
                                     <div class="col-xs-12">
									<ul class="ace-thumbnails clearfix">
                                         <c:forEach items="${cgb_face_dataList}" var="data">
                                          <li>
                                         <a href="#" data-rel="colorbox">
                                                    <img width="220" height="230"alt="220x230" src="${data.suspect_img}" />
                                                    <div class="text">
													<div class="inner">
														<div style="text-align: left">被冒用人证件类型：${data.victim_card_type_disp}</div>
														<div style="text-align: left">被冒用人证件号码：${data.victim_card_num}</div>
														<div style="text-align: left">被冒用人姓名：${data.victim_name}</div>
														<div style="text-align: left">证件有效期：${data.victim_card_validity}</div>
														<div style="text-align: left">风险类型：${data.risk_type_disp}</div>
														<div style="text-align: left">办理网点：${data.busi_website}</div>
														<div style="text-align: left">办理柜员：${data.busi_teller_num}</div>
														<div style="text-align: left">办理时间：${data.busi_time}</div>
														<div style="text-align: left">办理类型：${data.busi_type}</div>
													</div>
												</div>
												<div class="tools tools-top">
													<a href="#"
														onclick="_delSubmit('<c:url value="/cgb_face_data/check_delete?suspect_img_id=${data.suspect_img_id}&group_id=${data.group_id}" />')">
														<i class="ace-icon fa fa-times red"></i>
													</a>
												</div>
												  </a></li>
                                         </c:forEach>
                                         	</ul>
							  </div>	
                                    </c:if>
                             
									 <c:if test="${cgb_face_dataList != null}">
                                     <div class="col-xs-12">
									<ul class="ace-thumbnails clearfix">
                                         <c:forEach items="${cgb_face_dataList}" var="lwhc">
                                          <li>
                                         <a href="#" data-rel="colorbox">
                                                    <img width="220" height="230"alt="220x230" src="${lwhc.victim_img}" title="联网核查图像"/>
												  </a></li>
                                         </c:forEach>
                                         	</ul>
							  </div>	
                                    </c:if>  
									       
			</div>
			
		</fm:form>
	</div>
	<jsp:include page="../fragments/base_js.jsp"></jsp:include>

	<script type="text/javascript">

	function myOkDo() {
		_submit($("#url").val());
	}
	function do_tj(url,title) {
		 $("#url").val(url);
    	 agg.dialogConfirm(title,myOkDo,closeDo);
	}
		
	//弹出大窗口
	function _OpenXLarge(url, title) {
		agg.artDialog({
			title : title,
			url : url,
			width : '1000',
			height : '550',
			onclose : function() {
				window.close();
			}
		});
	}
	
	</script>
</body>
</html>