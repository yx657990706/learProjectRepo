<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>客户信息</title>
<jsp:include page="../../fragments/base_css.jsp" />

</head>

<body>
	<div class="page-content">
<form id="adduserform" class="form-horizontal" action="add"
										method="POST">
									
<!-- 								 <div class="widget-header widget-header-flat"> -->
<!--                     <h5 class="widget-title lighter"><span class="glyphicon glyphicon-play-circle orange"></span> -->
<!--                         客户信息</h5> -->
<!--                 </div> -->
				
										 <div class="widget-body">
									<div class="widget-main no-padding">
										<div class="agg_GridDetail">
											<table>
								<tr>
                                  <%--   <td>请求单流水号:</td><td>${br40_cxqq_back_party.qqdbs}</td> --%>
                                    <td>任务流水号:</td>  <td>${br40_cxqq_back_party.rwlsh}</td>
                                    <td>查询反馈结果:</td><td>${br40_cxqq_back_party.cxfkjg_disp}</td>
                                    </tr>
                                    <tr>
                                    <td>证件类型代码:</td><td>${br40_cxqq_back_party.zzlx_disp}</td>
                                    <td>证件号码:</td> <td>${br40_cxqq_back_party.zzhm}</td>
                                    </tr>
                                    <tr>
                                    <td>客户名称:</td><td>${br40_cxqq_back_party.khmc}</td>
                                    <td>联系电话:</td> <td>${br40_cxqq_back_party.lxdh}</td>
                                    </tr>
                                    <tr>
                                    <td>联系手机:</td> <td>${br40_cxqq_back_party.lxsj}</td>
                                    <td>代办人姓名:</td>  <td>${br40_cxqq_back_party.dbrxm}</td>
                                    </tr>
                                    <tr>
                                    <td>代办人证件类型:</td> <td>${br40_cxqq_back_party.dbrzjlx_disp}</td>
                                    <td>代办人证件号码:</td> <td>${br40_cxqq_back_party.dbrzjhm}</td>
                                    </tr>
                                    <tr>
                                    <td>住宅地址:</td> <td>${br40_cxqq_back_party.zzdz}</td>
                                    <td>住宅电话:</td> <td>${br40_cxqq_back_party.zzdh}</td>
                                    </tr>
                                    <tr>
                                    <td>工作单位:</td> <td>${br40_cxqq_back_party.gzdw}</td>
                                    <td>单位地址:</td> <td>${br40_cxqq_back_party.dwdz}</td>
                                    </tr>
                                    <tr>
                                    <td>单位电话:</td> <td>${br40_cxqq_back_party.dwdh}</td>
                                    <td>邮箱地址:</td> <td>${br40_cxqq_back_party.yxdz}</td>
                                    </tr>
                                    <tr>
                                    <td>法人代表:</td><td>${br40_cxqq_back_party.frdb}</td>
                                    <td>法人代表证件类型:</td>  <td>${br40_cxqq_back_party.frdbzjlx_disp}</td>
                                    </tr>
                                    <tr>
                                    <td>法人代表证件号码:</td>  <td>${br40_cxqq_back_party.frdbzjhm}</td>
                                    <td>客户工商执照号码:</td>  <td>${br40_cxqq_back_party.khgszzhm}</td>
                                    </tr>
                                    <tr>
                                    <td>国税纳税号:</td>  <td>${br40_cxqq_back_party.gsnsh}</td>
                                    <td>地税纳税号:</td>  <td>${br40_cxqq_back_party.dsnsh}</td>
                                    </tr>
                                     <!-- 根据tasktype判断 4表示 国家安全机构 -->
                                     <c:if test="${br40_cxqq_back_party.tasktype=='5' }">
                                        <tr>
                                    <td>账单地址:</td> <td >${br40_cxqq_back_party.zddz}</td>
                                    </tr>
                                     </c:if>
                                     <tr>
                                    <td>对该查询反馈结果的原因的描述:</td> <td colspan="3">${br40_cxqq_back_party.cxfkjgyy}</td>
                                    </tr>
                                    
                                    <!-- 根据tasktype判断 4表示 国家安全机构 -->
                                    <c:if test="${br40_cxqq_back_party.tasktype=='4' }">
                                  <tr>
                                    <td>代办人联系电话:</td> <td>${br40_cxqq_back_party.dbrlxdh}</td>
                                    <td>网银账户名:</td>  <td>${br40_cxqq_back_party.wyzhm}</td>
                                    </tr>
                                    <tr>
                                    <td>网银办理曰期:</td><td>${br40_cxqq_back_party.wyblrq}</td>
                                    <td>网银开户网点:</td><td>${br40_cxqq_back_party.wykhwd}</td>
                                    </tr>
                                    <tr>
                                    <td>网银开户网点代码:</td>  <td>${br40_cxqq_back_party.wykhwddm}</td>
                                    <td>网银开户网点所在地:</td><td>${br40_cxqq_back_party.wykhwdszd}</td>
                                    </tr>
                                    <tr>
                                    <td>手机银行账户名:</td> <td>${br40_cxqq_back_party.sjyhzhm}</td>
                                    <td>手机银行办理曰期:</td>  <td>${br40_cxqq_back_party.sjyhblrq}</td>
                                    </tr>
                                    <tr>
                                    <td>手机银行开户网点:</td>  <td>${br40_cxqq_back_party.sjyhkhwd}</td>
                                    <td>手机银行开户网点代码:</td> <td>${br40_cxqq_back_party.sjyhkhwddm}</td>
                                    </tr>
                                    <tr>
                                    <td>手机银行开户网点所在地:</td>  <td>${br40_cxqq_back_party.sjyhkhwdszd}</td>
                                    <td></td>  <td></td>
                                    </tr> 
                                    </c:if>
                                  
								 
							</table>
						</div>

                          
                           </div>
					<!-- /.widget-main -->
				</div>
					</form>
				<!-- /.widget-body -->
			</div>

	<jsp:include page="../../fragments/base_js.jsp" />
</body>
</html>