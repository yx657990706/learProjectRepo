package com.leo.nas.common.conf;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: 读取application.yml中的属性,设置redis连接
 *
 * @author yinxiong
 * @date 2018-04-26 21:17:25
 */
@Configuration  
@EnableAutoConfiguration  
//继承CachingConfigurerSupport，为了自定义生成KEY的策略。可以不继承。
public class JedisPoolConnectionConfig extends CachingConfigurerSupport {
	private Logger log = LoggerFactory.getLogger(JedisPoolConnectionConfig.class);

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.pool.jedis.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.pool.jedis.max-wait}")
	private long maxWaitMillis;


	@Bean
	public JedisPool redisPoolFactory() {
		log.info("JedisPool注入成功！！");
		log.info("redis地址：" + host + ":" + port);
		// 建立连接池配置参数
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);// 设置最大连接数
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis); // 设置最大阻塞时间，记住是毫秒数milliseconds

		// 创建连接池
		// JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,password);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);

		return jedisPool;
	}
	
	/**
     * 自定义key.
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key
     */
    @Override
    public KeyGenerator keyGenerator() {
    	log.info("RedisCacheConfig.keyGenerator()");
       return new KeyGenerator() {
           @Override
           public Object generate(Object o, Method method, Object... objects){           
              StringBuilder sb = new StringBuilder();
              sb.append(o.getClass().getName());
              sb.append(method.getName());
              for (Object obj : objects) {
                  sb.append(obj.toString());
              }
              log.info("keyGenerator=" + sb.toString());
              return sb.toString();
           }
       };
    }
 
}
