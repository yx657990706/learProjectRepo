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
<div class="widget-box transparent">
		<div class="widget-body">
			<div class="widget-main no-padding"><!--no-padding 这里去掉了此div的内边距，如果不去掉就会跟easygrid的查询一样-->
			</div><!-- /.widget-main -->
		</div><!-- /.widget-body -->
		</div>
<div class="space-8"></div>
<div class="page-content">
<fm:form class="form-horizontal"  commandName="br54_cxqq_back"  action="main_list"  method="POST">
  <div class="row">
	<div class="col-sm-12">
   <div class="tabbable">
     <ul class="nav nav-tabs padding-16" id="myTab3">
        <li class="active">
            <a data-toggle="tab" href="#home" onclick="_changeIframe('<c:url value="/br54_cxqq_back/response_mx_list?isNewSearch=1&bdhm=${br54_cxqq_back.bdhm }&qrymode=${br54_cxqq_back.qrymode }&party_class_cd=${br54_cxqq_back.party_class_cd }"/>','0901')"><i class="green ace-icon fa fa-home bigger-120"></i>核心反馈信息</a>
        </li>
        <li>
            <a data-toggle="tab" href="#profile" onclick="_changeIframe('<c:url value="/br54_cxqq_back/response_msg_list?isNewSearch=1&msgseq=${br54_cxqq_back.msgseq }"/>','0902')"><i class="ace-icon fa fa-user blue bigger-120"></i>反馈文件信息</a>
        </li> 
        <div class="widget-toolbar"  style="line-height: 34px">
     <button class="btn btn-info btn-sm" style="line-height: 20px"
		type="button" onclick="_OpenXLarge('<c:url value="/br54_cxqq/request_disp?bdhm=${br54_cxqq_back.bdhm }&qrymode=${br54_cxqq_back.qrymode }"/>','请求单信息')">
		<i class="ace-icon fa fa-folder-open"></i> 请求单信息</button>&nbsp;
            <a href='<c:url value="/br54_cxqq_back/response_list"/>'>
                <i class="ace-icon fa fa fa-arrow-circle-left green"></i>
                返回
            </a>
        </div>
    </ul>
<div class="tab-content">
<div id="home" class="tab-pane fade in active">
    <iframe src="<c:url value="/br54_cxqq_back/response_mx_list?isNewSearch=1&bdhm=${br54_cxqq_back.bdhm }&qrymode=${br54_cxqq_back.qrymode }&party_class_cd=${br54_cxqq_back.party_class_cd }"/>" width="100%" height="500" scrolling="auto" frameborder="0"  id="0901"></iframe>
</div>
 <div id="profile" class="tab-pane fade">
    <iframe src="<c:url value="/br54_cxqq_back/response_msg_list?isNewSearch=1&msgseq=${br54_cxqq_back.msgseq }"/>" width="100%" height="500" scrolling="auto" frameborder="0"  id="0902"></iframe>
</div>  
        </div>
    </div>
  </div>
</div>
	</fm:form>
 </div><!-- /.widget-main -->

<jsp:include page="../../fragments/base_js.jsp"/>
<script src="<c:url value='/resources/js/agg/jquery.autosize.min.js' />"></script><!-- 文本域自适应高度 -->
<script src="<c:url value='/resources/js/lib/bootstrap/datepicker/bootstrap-datepicker.min.js' />">
	<!--page plugin:datepicker日期选择器-->
	</script>
	<script type="text/javascript">
 var qqcslx=$("#qqcslxs").val();
	function _OpenXLarge(url,title){ //弹出大窗口
		agg.artDialog({
			title:title,
			url:url,
			width:'980',
			height:'550',
			onclose: function () {
			//_submit("deal_cg_main?qqcslxs="+qqcslx);
				 window.close();
			}
		});
	}	
	</script>
</body>
</html>