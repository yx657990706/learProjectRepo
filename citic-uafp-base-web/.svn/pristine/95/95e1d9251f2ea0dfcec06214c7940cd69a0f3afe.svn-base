<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="citic.aml.system.domain.Mp02_module" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />

<link href="<c:url value='/resources/js/lib/bootstrap/3.3.1/css/bootstrap.min.css?nocache=agghome'  />" 	rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/font-awesome.min.css?nocache=agghome'  />" 	rel="stylesheet" type="text/css" />
<!-- ace styles -->
<link rel="stylesheet" 	href="<c:url value='/resources/css/ace.min.css?nocache=agghome'  />" 	class="ace-main-stylesheet" id="main-ace-style" />
<!--[if lte IE 9]>
	<link rel="stylesheet" href="<c:url value='/resources/css/ace-part2.min.css?nocache=agghome'  />" class="ace-main-stylesheet" />
<![endif]-->
<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<c:url value='/resources/css/ace-ie.min.css?nocache=agghome'  />" />
<![endif]-->
<link rel="stylesheet" href="<c:url value='/resources/css/agg.home.css?nocache=agghome'  />" />
<script src="<c:url value='/resources/js/agg/ace-extra.min.js'  />"></script>
<!--[if lte IE 8]>
	<script src="<c:url value='/resources/js/agg/html5shiv.min.js'  />"></script>
	<script src="<c:url value='/resources/js/agg/respond.min.js'  />"></script>
<![endif]-->
</head>

<body class="no-skin">

<div id="navbar" class="navbar navbar-default navbar-fixed-top">
	<script type="text/javascript">
		//try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>
		</button>
		<!-- logo -->
		<div class="navbar-header pull-left">
			<img src="<c:url value='/resources/img/agg/logo.png'  />"/>
		</div>
		<!-- 头部右侧工具 -->
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
			
		<%-- 			<c:forEach var="upsystem"  items="${systemList}" >
				  <c:if test="${upsystem.upsystemkey!='7'&&upsystem.upsystemkey!='8'&&upsystem.upsystemkey!='${mp02_system.upsystemkey}'}">
					<li class="red">
					<a href="${upsystem.homepage}" >
						<i class="ace-icon fa fa-area-chart"></i>${upsystem.upsystemname}
					</a>
					</li>
					 <c:if test="${upsystem.upsystemkey!=mp02_system.upsystemkey}">
					
					${upsystem.img}
					</c:if>
					</c:if>
						</c:forEach>
							<!-- 建模工具系统切换 -->
				
					<li class="red"   onclick="_click()">
						<a href="#" >
						<i class="ace-icon fa fa-desktop" title="${mp02_system.upsystemname}" ></i>${mp02_system.upsystemname}
					</a>
				</li> --%>
				<li class="blue" id="agg_changesys">
			<% LinkedHashMap systemMap=(LinkedHashMap) request.getAttribute("systemMap");
				 if(systemMap.containsKey("5")){
				%>
					<a href="#">
						<i class="ace-icon fa fa-cube" title="建模管理工具" ></i>模型实验室
					</a>

					<%} %>

				
				</li>
				
				

				<!-- 查询工具栏 -->
			<%
			LinkedHashMap moduleMap=(LinkedHashMap)request.getAttribute("moduleMap");
			LinkedHashMap map6=new LinkedHashMap();
			%>
			 <%
			 if(systemMap.containsKey("9")){
					map6=(LinkedHashMap)moduleMap.get("9");
					Mp02_module sysmodule9=(Mp02_module)systemMap.get("9");


	%>
	
	<li class="red">
		<a data-toggle="dropdown" href="#" class="dropdown-toggle">
			<i class="ace-icon fa fa-filter" ></i><%=sysmodule9.getSystemname() %>
		</a>
		<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
		<%

		 Iterator item=map6.keySet().iterator();
		while(item.hasNext()){
			String upmodulekey=(String)item.next();
			LinkedHashMap submap9=(LinkedHashMap)map6.get(upmodulekey);
			Mp02_module module9=(Mp02_module)submap9.get(upmodulekey);
		    String url=module9.getUrl();
            url=url+"&modulekey="+module9.getModulekey();
             
		%>
			<% 	 if(module9.getModulekey().equals("101103")){%>
			<li class="dropdown-submenu">
						<a tabindex="-1" href="#" >
								<%=module9.getImg() %>&nbsp;
							<%=module9.getModulename() %>
						</a>
						<!-- 判断当是名单发送时，才有二级菜单     start -->
						<ul class="dropdown-menu">
							   <% 	 Iterator subitem9=submap9.keySet().iterator();
							   int n=0;
					                      while(subitem9.hasNext()){
						                             String modulekey=(String)subitem9.next();
						                         Mp02_module  submodule9=(Mp02_module)submap9.get(modulekey);
						                 
						                         String url9=submodule9.getUrl();
						                         url9=url9+"&modulekey="+modulekey;
						                         String img=submodule9.getModulekey();
						                        if(!modulekey.equals(upmodulekey)){
						                                 if(n!=0){
					                %>
					                	<li class="divider"></li>
					                	<%}
						                             n++;
						                  %>
								<li>
							<a tabindex="-1" href="#"  onClick="creatTab(this,'<%=url9%>','<%=submodule9.getModulekey() %>')" >
											<%=submodule9.getImg() %>
										<%=submodule9.getModulename() %>
									</a>	
								</li>
							<%}
					               	} %>

							</ul>
							<!-- 判断当是名单发送时，才有二级菜单     end -->
		     </li>
	<%} else {%>
		<li class="dropdown-submenu">
						<a tabindex="-1" href="#"  onClick="creatTab(this,'<%=url%>','<%=module9.getModulekey() %>')" >
								<%=module9.getImg() %>&nbsp;
							<%=module9.getModulename() %>
						</a>
						<!-- 判断当是名单发送时，才有二级菜单     start -->
						<%-- <ul class="dropdown-menu">
							   <% 	 Iterator subitem9=submap9.keySet().iterator();
							   int n=0;
					                      while(subitem9.hasNext()){
						                             String modulekey=(String)subitem9.next();
						                         Mp02_module  submodule9=(Mp02_module)submap9.get(modulekey);
						                 
						                         String url9=submodule9.getUrl();
						                         url9=url9+"&modulekey="+modulekey;
						                         String img=submodule9.getModulekey();
						                        if(!modulekey.equals(upmodulekey)){
						                                 if(n!=0){
					                %>
					                	<li class="divider"></li>
					                	<%}
						                             n++;
						                  %>
								<li>
							<a tabindex="-1" href="#"  onClick="creatTab(this,'<%=url9%>','<%=submodule9.getModulekey() %>')" >
											<%=submodule9.getImg() %>
										<%=submodule9.getModulename() %>
									</a>	
								</li>
							<%}
					               	} %>

							</ul> --%>
							<!-- 判断当是名单发送时，才有二级菜单     end -->
		     </li>
		
	<%}%>
		<%} %>
		</ul>

	</li>
	<%  } %>
			<%
				 if(systemMap.containsKey("6")){
								map6=(LinkedHashMap)moduleMap.get("6");
								Mp02_module sysmodule6=(Mp02_module)systemMap.get("6");
				%>
				<li class="light-orange">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<i class="ace-icon fa fa-filter" ></i><%=sysmodule6.getSystemname() %>
					</a>
					<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
					<%

					 Iterator item=map6.keySet().iterator();
					while(item.hasNext()){
						String upmodulekey=(String)item.next();
						LinkedHashMap submap6=(LinkedHashMap)map6.get(upmodulekey);
						Mp02_module module6=(Mp02_module)submap6.get(upmodulekey);

					%>

						<li class="dropdown-submenu">

							<a tabindex="-1" href="#">
							<%=module6.getImg() %>&nbsp;<%=module6.getModulename() %>
							</a>

							<ul class="dropdown-menu">
							   <% 	 Iterator subitem6=submap6.keySet().iterator();
							   int n=0;
					                      while(subitem6.hasNext()){
						                             String modulekey=(String)subitem6.next();

						                         Mp02_module  submodule6=(Mp02_module)submap6.get(modulekey);
						                         String url=submodule6.getUrl();
						                         url=url+"&modulekey="+modulekey;
						                         String img=submodule6.getModulekey();
						                        if(!modulekey.equals(upmodulekey)){
						                                 if(n!=0){
					                %>
					                	<li class="divider"></li>
					                	<%}
						                             n++;
						                  %>
								<li>
									<a tabindex="-1" href="#"  onClick="creatTab(this,'<%=url%>','<%=submodule6.getModulekey() %>')" >
											<%=submodule6.getImg() %>
										<%=submodule6.getModulename() %>
									</a>
								</li>
							<%}
							} %>

							</ul>
						</li>


					<%} %>
					</ul>

				</li>
				<%} 
				%>
			<!-- 	<li class="red">
					<a href="#" onClick="creatTab(this,'partyview/party_view_main','kehushitu')">
						<i class="ace-icon fa fa-area-chart"></i>客户视图
					</a>
				</li> -->
				<!-- 消息 -->
				<li class="green">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
						<span class="badge badge-success">${fn:length(noticeList)}</span>							</a>
					<!-- 消息内容 -->
					<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header">
							<i class="ace-icon fa fa-envelope-o"></i>
							${fn:length(noticeList)} Messages								</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar">
							    <c:forEach items="${noticeList}" var="notice" varStatus="s">
							       <li>
									<a href="#" class="clearfix"  onclick="_Open('<c:url value="/notice/view_disp?ni_no=${notice.ni_no}" />','公告详情')">
										<img src="resources/img/avatars/avatar.png" class="msg-photo" />
												<span class="msg-body">
													<span class="msg-title">
														<%-- <span class="blue">Alex:</span>--%>
														${notice.title}
													</span>
													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>${notice.create_dt}</span>
													</span>
												 </span>											
										</a>										
									 </li>
							     </c:forEach>
								
							</ul>
						</li>

						<li class="dropdown-footer">
							<a href="#" onClick="creatTab(this,'<c:url value="/notice/list_view?isNewSearch=1" />' ,'400108','公告信息查看')">
								查看更多。。。
								<i class="ace-icon fa fa-arrow-right"></i>									</a>								</li>
					</ul>
				</li>
				<!-- 欢迎 -->
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="<c:url value='/resources/img/agg/user.jpg'/>" />
							<%						
							String  realname=(String)request.getAttribute("realname");
							%>
								<span class="user-info" title="<%=realname%>">
									<%
										int leng = realname.length();
										String realname_begin="";
										String realname_end="";
										if(leng > 4 ){
											realname_begin=realname.substring(0, 4);
											realname_end   =realname.substring(4);
									%>
											<small>欢迎：<%=realname_begin %></small>
											<%=realname_end %>
									<% 
										}else {
											realname_begin = realname;
									%>
											<small>欢迎：</small>
											<%=realname_begin %>
									<%
										}
									 %>
								</span>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>
					<!-- 欢迎内容 -->
					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#" onclick="modifyMm('<c:url value="/mp02_user/modify_mm')" />">
								<i class="ace-icon fa fa-cog"></i>
								密码修改
							</a>
						</li>

					

						<li class="divider"></li>

						<li>
							<a href="loginOut" >
								<i class="ace-icon fa fa-power-off"></i>
								退出
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div><!-- /.navbar-container -->
</div>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		//try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>

	<div id="sidebar" class="sidebar responsive sidebar-fixed">
		<script type="text/javascript">
			//try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
		</script>

		<div class="agg-sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large fixed pull-left" id="sidebar-shortcuts-large">
			<%
			Iterator systemItem=systemMap.keySet().iterator();
			while (systemItem.hasNext()){
				String systemkey=(String)systemItem.next();
				Mp02_module module=(Mp02_module)systemMap.get(systemkey);
				if(!systemkey.equals("5")&&!systemkey.equals("6")&&!systemkey.equals("9")){

			%>
			   <%=module.getSysimg() %>
			<% }} %>
			</div>
		</div>



		<!-- 左侧菜单 -->
		<%
	     	Iterator sysItem=systemMap.keySet().iterator();
		   int k=0;
		    while (sysItem.hasNext()){
		    	String systemkey=(String)sysItem.next();
		    	if(!systemkey.equals("6")){
				Mp02_module module=(Mp02_module)systemMap.get(systemkey);
				String systemname=module.getSystemname();


		       if(k==0){
		    %>
		         <ul class="nav nav-list">
			<%}else{    if(systemkey.equals("5") ) {%> 
				<div class="agg_sys_B hide">
						<ul class="nav">
				<%}else{%>
				   <div class="agg_sys_A hide">
				   <ul class="nav hide">
				<%} %>

		  <%} %>
			<li class="active">
				<a href="#">
					<i class="menu-icon fa fa-tachometer"></i>
					<span class="menu-text"> <%=systemname %></span>
				</a>

				<b class="arrow"></b>
			</li>
			<%
			    LinkedHashMap submap=(LinkedHashMap)moduleMap.get(systemkey);
			    Iterator subitem=submap.keySet().iterator();
				while(subitem.hasNext()){
					String upmodulekey=(String)subitem.next();
					LinkedHashMap subsubmap=(LinkedHashMap)submap.get(upmodulekey);
					Mp02_module  submodule=(Mp02_module)subsubmap.get(upmodulekey);
			 %>
			<li>
				<a href="#" class="dropdown-toggle">
					<%=submodule.getImg() %>
					<span class="menu-text"><%=submodule.getModulename() %> </span>

					<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>
				<ul class="submenu">
				  <% 	 Iterator subsubitem=subsubmap.keySet().iterator();
					                      while(subsubitem.hasNext()){
						                             String modulekey=(String)subsubitem.next();
						                         Mp02_module  subsubmodule=(Mp02_module)subsubmap.get(modulekey);
						                         String url=subsubmodule.getUrl();
						                         if(url.indexOf("?")!=-1){
						                        	 url=url+"&modulekey="+modulekey;
						                         }else{
						                        	 url=url+"?modulekey="+modulekey;
						                         }
						                         String img=subsubmodule.getImg();
						                     if(!modulekey.equals(upmodulekey)){
					  %>
					    <li>
								<a href="#" onClick="creatTab(this,'<%=url%>','<%=modulekey%>')">
									<%=img %>
									<%=subsubmodule.getModulename() %>
								</a>
								<b class="arrow"></b>
							</li>

                          <%
						                     }   }%>
				</ul>

			</li>
			<%} %>

		</ul><!-- /.nav-list -->
		<% if(k!=0) {%>
		</div>
		<%
		   }
			k++;
			
		    	}
		    }
		%>


		<!-- 左侧菜单收缩展开按钮 -->
		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>

		<script type="text/javascript">
			//try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
		</script>
	</div>
	<!-- 右侧内容 -->
	<div class="main-content">
		<div class="main-content-inner">
			<!-- 选项卡 -->
			<div id="Tab-wrap" class="autoTabheight"><!-- Tab-wrap -->

				<div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
					<script type="text/javascript">
						//	try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<!--选项卡菜单-->
					<div class="tabarea" oncontextmenu="return(false)">
						<div id="home" class="home activetab"><b>首页</b></div>
						<div id="Tab-menu" class="showBar">
							<ul></ul>
						</div>
					</div>
				</div><!-- /.breadcrumb -->
				<!--[if lte IE 8]>
				<div style="height:40px;"></div>
				<![endif]-->
				<!--选项卡内容-->
				<div id="home_c" class="Tab-content" style="overflow:hidden; height:2000px">
					<iframe frameborder="0" scrolling="auto" allowtransparency="true" width="100%" height="100%" src="<c:url value="/${loginname}/main"/>"></iframe>
				</div>

			</div><!-- /.Tab-wrap -->

			<!--<div class="page-content">-->
			<!-- 右侧浮动设置快捷菜单
            <div class="ace-settings-container" id="ace-settings-container">
                <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                    <i class="ace-icon fa fa-cog bigger-130"></i>
                </div>

                <div class="ace-settings-box clearfix" id="ace-settings-box">
                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <div class="pull-left">
                                <select id="skin-colorpicker" class="hide">
                                    <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                    <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                    <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                    <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                </select>
                            </div>
                            <span>&nbsp; 选择皮肤</span>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                            <label class="lbl" for="ace-settings-navbar"> 固定导航栏 </label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                            <label class="lbl" for="ace-settings-sidebar"> 固定侧边栏</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                            <label class="lbl" for="ace-settings-breadcrumbs"> 固定面包屑</label>
                        </div>
                        <!--
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                            <label class="lbl" for="ace-settings-rtl"> 切换到左边 </label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                            <label class="lbl" for="ace-settings-add-container">
                                Inside
                                <b>.container</b>
                            </label>
                        </div>-->
			<!--</div> /.pull-left -->

			<!-- <div class="pull-left width-50">
                <div class="ace-settings-item">
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
                    <label class="lbl" for="ace-settings-hover"> 子菜单上悬停</label>
                </div>

                <div class="ace-settings-item">
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
                    <label class="lbl" for="ace-settings-compact"> 紧凑的侧边栏</label>
                </div>

                <div class="ace-settings-item">
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
                    <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                </div>
            </div>/.pull-left -->
			<!--</div> /.ace-settings-box -->
			<!--</div> /.ace-settings-container -->


			<!--</div> /.page-content -->
		</div>
	</div><!-- /.main-content -->


	<!-- 返回顶部按钮 -->
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110" style="padding-right: 15px; padding-left: 5px;"></i>
		
				</a>		</div><!-- /.main-container -->

<jsp:include page="fragments/base_js.jsp"/>
<script src="<c:url value='/resources/js/agg/agg.tab.js' />"> </script>

<script>
    var menubar=$('#sidebar-shortcuts'), sidebar=$('#sidebar'),firstnav=sidebar.find('.nav-list'), menutext=[firstnav.html()],
            nav=$('.agg_sys_A').find('.nav').each(function(){ menutext.push($(this).html()); }),lis=nav.find('li'),navscoll=firstnav.parent().next().find('.scroll-track');

    $(function(){
        //for ie
        var rightcontent=$('.main-content');
        $('#sidebar-collapse').on('click',function(){
            var l=$(this).find('.fa-angle-double-left').length==0?190:43;
            rightcontent.css('margin-left',l);
        });

        nav.on('click','li',function(event){

            var tt=this, t=$(tt),tp=t.parent();
            if(tp.hasClass('nav-list')){
                t.removeClass('active open');
            }else{
                lis.each(function(){ if(tt===this){t.addClass('active').closest('.open').addClass('active'); }else{ $(this).removeClass('active'); } });
                event.stopPropagation();
            }

        });

        menubar.on('click','.btn',function(){
            firstnav.html(menutext[$(this).index()]);
            navscoll.hide();
        });
        //头部控制左侧菜单切换
        var menutext2=$('.agg_sys_B').find('.nav').html();
        $('#agg_changesys').on('click','a',function(){
            var o=$(this);
            if(o.index()==0){
              //  o.addClass('hide').next().removeClass('hide');
                firstnav.html(menutext2);
                menubar.addClass('hidden');
            }else{
              //  o.addClass('hide').prev().removeClass('hide');
                firstnav.html(menutext[0]);
                menubar.removeClass('hidden');
            }
        });

     /*   $('.systemChg').on('click','a',function(){ alert("1");

                //  o.addClass('hide').prev().removeClass('hide');
                firstnav.html(menutext[0]);
                menubar.removeClass('hidden');

        });
*/

    });
    function _click(){
        firstnav.html(menutext[0]);
        menubar.removeClass('hidden');
    }
    //tab
    function creatTab(o,url,curId,title){
        var configs={url:url,id:curId,colors:true,autoheight:true };
        if(title){
            configs.title=title;
        }
        $(o).creatTab(configs);
    }

    function modifyMm(url){
        agg.artDialog({
            title:'重置密码',
            url:url,
            width:'500',
            height:'300'

        });
    }

    function _Open(url,title){ //弹出大窗口
        agg.artDialog({
            title:title,
            url:url,
            width:'980',
            height:'550'

        });
    }
</script>

</body>
</html>
