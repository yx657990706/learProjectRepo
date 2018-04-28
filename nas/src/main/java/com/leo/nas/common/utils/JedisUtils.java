package com.leo.nas.common.utils;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description: jedis工具类,用自动注入的方式使用
 *
 * @author yinxiong
 * @date 2018-04-24 23:32:11
 */
@Component
public class JedisUtils {

	private Logger logger = LoggerFactory.getLogger(JedisUtils.class);

	@Autowired
	private JedisPool jedisPool;

	/**
	 * 
	 * @Title: getValue
	 * @Description: prefix+"#"+key拼接成键
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public String getValue(String prefix, String key) {
		return this.getValue(prefix + "#" + key);
	}

	/**
	 * @Title: getValue
	 * @Description: 根据key获取value
	 *
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		Jedis jedis = jedisPool.getResource();
		String str;
		try {
			str = jedis.get(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: setValue
	 * @Description: des
	 *
	 * @param prefix
	 * @param key
	 * @param value
	 * @return
	 */
	public String setValue(String prefix, String key, String value) {
		return this.setValue(prefix + "#" + key, value);
	}

	/**
	 * 
	 * @Title: setValue
	 * @Description: 设置key-value缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public String setValue(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String str;
		try {
			str = jedis.set(key, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: setValueByExpireTime
	 * @Description: des
	 *
	 * @param prefix
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public String setValueByExpireTime(String prefix, String key, String value, int seconds) {
		return this.setValueByExpireTime(prefix + "#" + key, value, seconds);

	}

	/**
	 * 
	 * @Title: setex
	 * @Description: 设置有效期的key-value缓存
	 *
	 * @param key
	 * @param value
	 * @param seconds
	 *            单位:秒
	 * @return
	 */
	public String setValueByExpireTime(String key, String value, int seconds) {
		Jedis jedis = jedisPool.getResource();
		String str;
		try {
			str = jedis.setex(key, seconds, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: delValue
	 * @Description: 删除缓存
	 *
	 * @param prefix
	 * @param key
	 */
	public void delValue(String prefix, String key) {
		this.delValue(prefix + "#" + key);
	}

	/**
	 * 
	 * @Title: delValue
	 * @Description: des
	 *
	 * @param key
	 */
	public void delValue(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.del(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 获取缓存剩余存活时间
	 * 
	 * @Title: getExpire
	 * @Description: des
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public Long getExpire(String prefix, String key) {
		Jedis jedis = jedisPool.getResource();
		Long ttl;
		try {
			ttl = jedis.ttl(prefix + "#" + key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ttl;
	}

	/**
	 * 
	 * @Title: getKeys
	 * @Description: deg使用的,查找所有以prefix+"#"+qry开头的key集合
	 *
	 * @param prefix
	 * @param qry
	 * @return
	 */
	public Set<String> getKeys(String prefix, String qry) {
		Jedis jedis = jedisPool.getResource();
		Set<String> set;
		try {
			set = jedis.keys(prefix + "#" + (null == qry ? "" : qry) + "*");
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return set;
	}

	/**
	 * 
	 * @Title: llen
	 * @Description: 查询list长度
	 *
	 * @param key
	 * @return 返回list的长度
	 */
	public synchronized Long llen(String key) {
		Jedis jedis = jedisPool.getResource();
		Long len;
		try {
			len = jedis.llen(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (null == len) {
			len = 0l;
		}
		return len;
	}

	/**
	 * 
	 * @Title: lpush
	 * @Description: list左侧放入缓存
	 *
	 * @param key
	 * @param value
	 * @return push后的list长度
	 */
	public synchronized Long lpush(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long len;
		try {
			len = jedis.lpush(key, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (null == len) {
			len = 0l;
		}
		return len;
	}

	/**
	 * 
	 * @Title: rpush
	 * @Description: list右侧放入缓存
	 *
	 * @param key
	 * @param value
	 * @return push后的list长度
	 */
	public synchronized Long rpush(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long len;
		try {
			len = jedis.rpush(key, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (null == len) {
			len = 0l;
		}
		return len;
	}

	/**
	 * 
	 * @Title: lpop
	 * @Description: 获取list最左侧的元素
	 *
	 * @param key
	 * @return key对应的list最左侧的元素
	 */
	public synchronized String lpop(String key) {
		Jedis jedis = jedisPool.getResource();
		String str;
		try {
			str = jedis.lpop(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: rpop
	 * @Description: 获取list最右侧的元素
	 *
	 * @param key
	 * @return key对应的list最右侧的元素
	 */
	public synchronized String rpop(String key) {
		Jedis jedis = jedisPool.getResource();

		String str;
		try {
			str = jedis.rpop(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: incr
	 * @Description: +1操作
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public Long incr(String prefix, String key) {
		return this.incr(prefix + "#" + key);
	}

	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long value;
		try {
			value = jedis.incr(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return value;
	}
}
