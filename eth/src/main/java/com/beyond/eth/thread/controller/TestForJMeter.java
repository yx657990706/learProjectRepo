package com.beyond.eth.thread.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 线程同步性能测试<br>
 * 利用Jmeter起线程进行测试
 * 
 * @author yinxiong
 *
 */
@Controller
@RequestMapping(value = "/jmeter")
public class TestForJMeter {

	// 引入日志
	private Logger logger = LoggerFactory.getLogger(TestForJMeter.class);

	private volatile int NUM = 0;
	private Lock lock = new ReentrantLock();//同步锁
	
	@RequestMapping(value = "bf", method = RequestMethod.GET)
	@ResponseBody
	public String bf(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer bf = new StringBuffer();
//		lock.lock();
		try {
			synchronized (this) {
				long x = System.currentTimeMillis();
				// 执行操作01
				logger.info("====01===");
				bf.append("\"msg1\":\"a----01---\"" + x + "");
				// 生产随机休眠数,执行操作02
				int m = (int) (Math.random() * 5);
				Thread.sleep(m * 1000);
				logger.info("====02===");
				bf.append("\"msg2\":\"b----02---\"" + x + "");
				NUM++;
				bf.append("\"num\":" + NUM + "---\"" + x + "");
				// 模拟业务执行1s,休眠一秒,执行操作3
				Thread.sleep(1000);
				logger.info("====03===");
				bf.append("\"msg3\":\"c----03---\"" + x + "");
				// logger.info(bf.toString());
			}
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}finally{
//            lock.unlock();
        }
		
		return bf.toString();

	}

	@RequestMapping(value = "bf02", method = RequestMethod.GET)
	public String bf02(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer bf = new StringBuffer();
		try {
			long x = System.currentTimeMillis();
			// 执行操作01
			logger.info("22====01===");
			bf.append("\"msg1\":\"a----01---\"" + x + "");
			// 生产随机休眠数,执行操作02
			int m = (int) (Math.random() * 5);
			Thread.sleep(m * 1000);
			logger.info("22====02===");
			bf.append("\"msg2\":\"b----02---\"" + x + "");
			NUM++;
			bf.append("\"num\":" + NUM + "---\"" + x + "");
			// 模拟业务执行1s,休眠一秒,执行操作3
			Thread.sleep(1000);
			logger.info("22====03===");
			bf.append("\"msg3\":\"c----03---\"" + x + "");

		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		return bf.toString();
	}

}
