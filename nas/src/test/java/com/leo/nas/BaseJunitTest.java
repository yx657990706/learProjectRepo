package com.leo.nas;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

/**
 * junit测试基础类，其他测试类继承该类即可
 * 
 * @author yinxiong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。  
//@WebAppConfiguration
public class BaseJunitTest {

}
