package com.leo.nas.common.utils;

import com.leo.nas.common.model.Result;

/**
 * 统一消息返回工具类
 * 
 * @author yinxiong
 *
 */
public class ResultUtil {
	
	/**
	 * 成功(有返回数据)
	 * 
	 * @param object
	 * @return
	 */
	public static Result success(Object object) {
		Result rs = new Result();
		rs.setCode("0000");
		rs.setMsg("成功");
		rs.setData(object);
		return rs;
	}

	/**
	 * 成功(无返回数据)
	 * 
	 * @return
	 */
	public static Result success() {
		return success(null);
	}

	/**
	 * 失败
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result error(String code, String msg) {
		Result rs = new Result();
		rs.setCode(code);
		rs.setMsg(msg);
		return rs;
	}
}
