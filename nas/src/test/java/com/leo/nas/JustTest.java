package com.leo.nas;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志级别测试
 * @author yinxiong
 *
 */
public class JustTest extends BaseJunitTest{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void outLogger() {
		//级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
		logger.trace("======TRACE======");
		logger.debug("======debug======");
		logger.info("======info======");
		logger.warn("======warn======");
		logger.error("======error======");
	}
}
