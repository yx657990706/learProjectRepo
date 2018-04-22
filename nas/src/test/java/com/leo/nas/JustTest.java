package com.leo.nas;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志级别测试
 * @author yinxiong
 *
 */
@Slf4j
public class JustTest extends BaseJunitTest{

	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void outLogger() {
		//级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
		log.trace("======TRACE======");
		log.debug("======debug======");
		log.info("======info======");
		log.warn("======warn======");
		log.error("======error======");
		System.out.println("Hello \u001b[1;31mred\u001b[0m world!");
	}
}
