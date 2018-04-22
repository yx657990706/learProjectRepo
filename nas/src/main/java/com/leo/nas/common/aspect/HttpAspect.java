package com.leo.nas.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@Description: 自定义切点在指定方法前后执行一些方法
 *
 * @author yinxiong
 * @date 2018-04-22 23:17:03
 */
@Slf4j
@Aspect
@Component
public class HttpAspect {

	//定义切点 
	//@Pointcut("execution(public * com.leo.nas.coin.controller.*.*(..))")//controller包下的任意类的任意方法
	@Pointcut("execution(public * com.leo.nas.coin.controller.CoinController.outputCoinInfo5*(..))")//以outputCoinInfo5开头的指定方法
	public void httpPointcut() {
	}

	//切点前执行
	@Before("httpPointcut()")
	public void doBefore(JoinPoint joinPoint) {
		log.info("=======>>{}<<======", "before");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// url
		log.info("url={}", request.getRequestURL());
		// method
		log.info("method={}", request.getMethod());
		// ip
		log.info("ip={}", request.getRemoteAddr());
		// 类方法
		log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		// 参数
		log.info("args={}", joinPoint.getArgs());

	}

	//切点后执行
	@After("httpPointcut()")
	public void doAfter() {
		log.info("=======>>{}<<======", "after");
	}
	
	//在after注解后执行
	@AfterReturning(pointcut="httpPointcut()",returning="object")
	public void doAfterReturning(Object object) {
		log.info("=======>>{}<<======", "afterReturning");
		//打印响应结果
		log.info("response={}", object==null?"null":object.toString());
	}
}
