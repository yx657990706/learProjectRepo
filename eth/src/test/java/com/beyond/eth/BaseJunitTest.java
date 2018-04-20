package com.beyond.eth;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit测试基础类，其他测试类继承该类即可
 * @author yinxiong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置文件在WBE-INF下
//@ContextConfiguration(locations = { "file:\\Users\\yinxiong\\shunshine\\wks/sinosigbox3.0\\WebRoot\\WEB-INF\\applicationContext.xml" })
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml" } )
public class BaseJunitTest {
	

}
