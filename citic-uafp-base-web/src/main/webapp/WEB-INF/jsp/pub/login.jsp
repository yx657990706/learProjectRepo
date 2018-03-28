<%@ page language="java" contentType="text/html; charset=UTF-8"  	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="zh_cn">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<title>金融网络查控统一管理平台</title>
<link href="<c:url value='/resources/css/metro_ui.css'  />" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/lib/jquery/jquery-1.7.2.min.js'  />"></script>
<script src="<c:url value='/resources/js/nivo-slider3.2/jquery.nivo.slider.pack.js'  />"></script>


<script type="text/javascript">
$(function(){
	 $('#slider').nivoSlider({ directionNav:false });//详细参数设置请见jquery.nivo.slider.pack.js
})
</script>
<script type="text/javascript">
	$(function(){
		$(document).keydown(function(event){
			if(event.keyCode==13){
			$("#loginbutton").click();
			}
		});

		$("#loginbutton").click(function(){
			dosubmit("cas_login");
			 //openFullWin("logindo", "citic") ;
		});
	});

	function openFullWin(url, win_name) {
		var iwidth = screen.availWidth  ;
		var iheight = screen.availHeight - 30;
		var loginname=document.forms[0].loginname.value;
		var password=document.forms[0].password.value;
		url=url+"?loginname="+loginname+"&password="+password;
		var openwin = window.open(url,win_name, "scrollbars=yes,toolbar=no,status=yes,resizable=yes,MenuBar=no,location=no,top=0,left=0,width=" + iwidth + " ,height=" + iheight);
		if (openwin) {
			openwin.focus();
	    }
	    return openwin;
	}
	function checkit(o){
		if(!o) return
		var c=(o.className).replace(/[ ]/g,''),state='_on',newc=c.indexOf(state)<0?c+'_on':c.replace(state,'');
		o.className=newc;
	}

	function dosubmit(theUrl){
		document.forms[0].action=theUrl;
		document.forms[0].submit();
	}
</script>
<script type="text/javascript">
    if(window!=top){
    	top.location.href=location.href;
    }
</script>
</head>
<body class="loginbody">

<fm:form  commandName="mp02_user"  method="POST">
      <input type="hidden"  id="d_file_name"  name="d_file_name"/>
	  <input type="hidden"  name="d_file_path"   id="d_file_path" />

	<div class="metro_log">
		<div class="log_img">
			<!--幻灯片-->
			<div id="slider" class="nivoSlider">
				<img  class="log_img"    src="<c:url value="/resources/img/metro_ui/login/img/02.jpg" />"  />
				<img  class="log_img"  src="<c:url value="/resources/img/metro_ui/login/img/03.jpg" />" />
				<img  class="log_img"  src="<c:url value="/resources/img/metro_ui/login/img/04.jpg" />" />
			</div>
			<!--幻灯片end-->
		</div>
		<div class="log_name"></div>
		<div class="log_area">
			<div class="log_logo"></div>

			        <fm:input   cssClass="log_text" path="loginname"/> 
			           <fm:password cssClass="log_pass" path="password"/>
			
			 <%-- 
			<a href="#" class="log_checkbox" onclick="checkit(this);"></a>
			--%>
			<input type="button"   id="loginbutton"   class="log_button" />
			<!-- <input type="button"   id="loginbutton"   class="log_button" onclick="openFullWin('logindo','citic')"/> 
		   <a href='#'  onclick="_download( '/firefox/Firefox.zip','Firefox.zip')"  class="log_xiazai"  ><img src="<c:url value="/resources/img/metro_ui/login/ico_03.gif" />"/> 火狐下载</a>-->
		   <c:if test="${errorMsg!='' }">
		   	<a href='#' class="errormsg">${errorMsg}</a>
		   	</c:if>
		</div>
	</div>


</fm:form>

	 <script type="text/javascript">
	 function _download(file_path, file_name) { 
		$("#d_file_path").val(file_path);
		$("#d_file_name").val(file_name);  
		document.forms[0].action="download";
		document.forms[0].submit();
	}

	 </script>
</body>
</html>