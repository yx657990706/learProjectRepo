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
		<fm:form id="myform" commandName="cgb_face_data" class="form-horizontal"  method="POST"   >
			<div>
                <div class="col-xs-12">
                                        <ul class="ace-thumbnails clearfix">
                                            <c:choose>
                                            <c:when test="${face_data.rm_flag == '1'}">
                                                <li style="border: 3px solid blue">
                                            </c:when>
                                              <c:when test="${face_data.rm_flag == '2'}">
                                                <li style="border: 3px solid red">
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                            </c:otherwise>
                                         </c:choose>
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
                                          <c:choose>
                                            <c:when test="${data.rm_flag == '1'}">
                                                <li style="border: 3px solid blue">
                                            </c:when>
                                              <c:when test="${data.rm_flag == '2'}">
                                                <li style="border: 3px solid red">
                                            </c:when>
                                            <c:otherwise>
                                                <li>
                                            </c:otherwise>
                                         </c:choose>
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

</body>
</html>