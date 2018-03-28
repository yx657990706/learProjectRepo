<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://com.citic.rmt/tags" prefix="rm"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title></title>	
		<jsp:include page="../../fragments/base_css.jsp"></jsp:include>
     
</head>
<body>
 <div class="page-content">
  <fm:form class="form-horizontal" commandName="br41_kzqq_zf_back"  action="kzzf_fk_disp"  method="POST" id="myform">
        <div class="row">
            <div class="col-xs-12">
              <div class="widget-box transparent">
                        <div class="widget-body">
                            <div class="widget-main no-padding">
                                <div class="agg_GridDetail">
                                    <table>
                                        <tr>
                                            <td width="25%">任务流水号：</td>
                                            <td width="25%">${br41_kzqq_zf_back.rwlsh }</td>
                                            <td width="25%">请求单标识：</td>
                                            <td width="25%">${br41_kzqq_zf_back.qqdbs }</td>
                                        </tr>
                                        <tr>
                                            <td>账号：</td>
                                            <td>${br41_kzqq_zf_back.zh}</td>
                                            <td>卡号：</td>
                                            <td>${br41_kzqq_zf_back.kh}</td>
                                        </tr>
                                        <tr>
                                            <td>查询日期：</td>
                                            <td>${br41_kzqq_zf_back.qrydt}</td>
                                            <td>执行起始时间：</td>
                                            <td>${br41_kzqq_zf_back.zxqssj }</td>
                                        </tr>
                                        <tr>
                                            <td>核心反馈结果：</td>
                                            <td>${br41_kzqq_zf_back.zxjg_disp }</td>
                                            <td>核心反馈状态：</td>
                                            <td>${br41_kzqq_zf_back.status_disp}</td>
                                        </tr>
                                         <tr>
                                         <!-- 判断是公安的添加账户序号 -->
                                         <c:if test="${br41_kzqq_zf_back.tasktype=='3'}">
                                            <td>账户序号：</td>
                                            <td>${br41_kzqq_zf_back.zhxh }</td>
                                         </c:if>
                                            <td>失败原因：</td>
                                            <td>${br41_kzqq_zf_back.sbyy}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </fm:form>
</div>
        <!-- basic scripts -->
		<jsp:include page="../../fragments/base_js.jsp"></jsp:include>
</body>
</html>