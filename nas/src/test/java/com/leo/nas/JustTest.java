package com.leo.nas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leo.nas.common.utils.JedisUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志级别测试
 * @author yinxiong
 *
 */
@Slf4j
public class JustTest extends BaseJunitTest{

	//private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JedisUtils jedisUtils;
	@Test
	public void outLogger() {
		
         String a = jedisUtils.setValue("key001","qwer0001中文");
         log.info("======a:{}======",a);
         String b = jedisUtils.getValue("key001");
         log.info("======b:{}======",b);
         String c = jedisUtils.setValueByExpireTime("key002","qqqq0002中文",10);
         log.info("======c:{}======",c);
         String d1 = jedisUtils.getValue("key002");
         log.info("======d1:{}======",d1);
         try {
			Thread.sleep(11*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         String d2 = jedisUtils.getValue("key002");
         log.info("======d2:{}======",d2);
		//级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
		log.trace("======TRACE======");
		log.debug("======debug======");
		log.info("======info======");
		log.warn("======warn======");
		log.error("======error======");
		System.out.println("Hello \u001b[1;31mred\u001b[0m world!");
	}
}
