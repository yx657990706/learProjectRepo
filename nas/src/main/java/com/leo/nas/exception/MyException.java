package com.leo.nas.exception;

import com.leo.nas.enums.ResltEnum;

public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8686450718752547733L;

	/**
	 * 代码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String msg;

	/**
	 * 构造方法一
	 * 
	 * @param code
	 * @param msg
	 */
	public MyException(String code, String msg) {
		super(msg);
		this.code = code;
	}
	/**
	 * 构造方法二(传入枚举)
	 * @param resltEnum
	 */
	public MyException(ResltEnum resltEnum) {
		super(resltEnum.getMsg());
		this.code = resltEnum.getCode();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
