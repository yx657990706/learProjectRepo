package com.leo.nas.common.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 *@Description: druid连接池的过滤器
 *
 * @author yinxiong
 * @date 2018-04-22 23:38:49
 */
@WebFilter(  
        filterName="druidWebStatFilter",  
        urlPatterns= {"/*"},  
        initParams= {  
                @WebInitParam(name="exclusions",value="*.js,*.jpg,*.png,*.gif,*.ico,*.css,/druid/*")//配置本过滤器放行的请求后缀  
        }  
)  
public class DruidStatFilter extends WebStatFilter{

}
