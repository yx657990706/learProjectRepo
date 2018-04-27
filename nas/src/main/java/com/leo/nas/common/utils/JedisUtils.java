package com.leo.nas.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description: JedisUtils.java
 *
 * @author yinxiong
 * @date 2018-04-24 23:32:11
 */
@Component
public class JedisUtils {

	private static Logger logger = LoggerFactory.getLogger(JedisUtils.class);

	@Autowired
	private JedisPool jedisPool;

	/**
	 *@Title: getValue
	 *@Description: 根据key获取value
	 *
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		Jedis jedis = jedisPool.getResource();
		String str = "";
		try {
			str = jedis.get(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return str;
	}

	/**
	 * 
	 *@Title: setValue
	 *@Description: 设置key-value缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public String setValue(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String str = "";
		try {
			str = jedis.set(key, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return str;
	}

	/**
	 * 
	 *@Title: setex
	 *@Description: 设置有效期的key-value缓存
	 *
	 * @param key
	 * @param value
	 * @param seconds 单位:秒
	 * @return
	 */
	public String setValueByExpireTime(String key, String value, int seconds) {
		Jedis jedis = jedisPool.getResource();
		String str = "";
		try {
			str = jedis.setex(key, seconds, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return str;
	}
}
