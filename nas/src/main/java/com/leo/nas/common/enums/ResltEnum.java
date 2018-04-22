package com.leo.nas.common.enums;

import lombok.Getter;

/**
 * 
 *@Description: 统一异常枚举
 *
 * @author yinxiong
 * @date 2018-04-22 23:39:51
 */
@Getter
public enum ResltEnum {
	
	ERROR_OK("0000","成功"),//正常响应
	ERROR_UNKOWN("-1","未知错误"),//未知错误
	ERROR_LOW("1001","ico资金太少,没法飞...."),//自定义错误1001 
	ERROR_HIGHT("1002","募集资金过多,涉嫌非法集资");//自定义错误1002
	
	private String code;
	private String msg;
	private ResltEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
