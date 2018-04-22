package com.leo.nas.common.model;

import lombok.Data;

@Data
public class Result {

	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 数据内容
	 */
	private Object data;

}
