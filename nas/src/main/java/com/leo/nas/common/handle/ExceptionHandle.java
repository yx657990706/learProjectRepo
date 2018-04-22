package com.leo.nas.common.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.nas.common.enums.ResltEnum;
import com.leo.nas.common.exception.MyException;
import com.leo.nas.common.model.Result;
import com.leo.nas.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@Description: 自定义异常处理(统一异常处理)
 *
 * @author yinxiong
 * @date 2018-04-22 23:36:17
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof MyException) {
			MyException myException = (MyException) e;
			log.error("[自定义异常{}]{}",myException.getCode(),e.getMessage());
			return ResultUtil.error(myException.getCode(),myException.getMessage());
		}else {
			//日志记录异常信息,便于排查问题
			log.error("[系统异常{}]{}",ResltEnum.ERROR_UNKOWN.getCode(),e.getMessage(),e);
			return ResultUtil.error(ResltEnum.ERROR_UNKOWN.getCode(),ResltEnum.ERROR_UNKOWN.getMsg());
		}
	}
}
