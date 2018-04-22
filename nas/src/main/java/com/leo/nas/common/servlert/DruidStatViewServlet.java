package com.leo.nas.common.servlert;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/** 
 * druid数据源状态监控<br> 
 * 访问方式 127.0.0.1:8080/nas/druid
 */  
@WebServlet(  
        urlPatterns= {"/druid/*"},  
        initParams= {  
        	        @WebInitParam(name = "allow", value = "192.168.16.110,127.0.0.1"), // IP白名单// (没有配置或者为空，则允许所有访问)  
        	        @WebInitParam(name = "deny", value = "192.168.1.111"), // IP黑名单// (存在共同时，deny优先于allow)  
                @WebInitParam(name="loginUsername",value="root"),  
                @WebInitParam(name="loginPassword",value="root"),  
                @WebInitParam(name="resetEnable",value="true")// 允许HTML页面上的“Reset All”功能  
                  
        }  
        )  
public class DruidStatViewServlet extends StatViewServlet implements Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3917228010382976962L;
	

}
