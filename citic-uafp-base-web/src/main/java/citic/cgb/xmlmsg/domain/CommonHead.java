package citic.cgb.xmlmsg.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;
/**
 * 网关通用报文头的DTO
 * <br>驼峰型数据，仅用于承载数据
 * 
 * @author yinxiong
 * @date 2016年11月1日 下午7:55:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommonHead extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808493227198010793L;
	

	/**versionNo 版本号 标识当前数据包的格式版本，目前该版本号为1，默认填“1”*/
	private String versionNo = "";
	
	/**1-toEncrypt 密押标识 表示数据报文是否压缩格式，目前不使用，默认填“0”*/
	private String toEncrypt = "";
	
	/**6-commCode 通讯代码 请求填“500001" 响应填“510001”*/
	private String commCode = "";
	
	/**1-commType 通讯类型 0--同步请求(等待接收方返回业务处理结果)；1--异步请求(接收方不返回结果,由网关返回给请求方通讯回执)*/
	private String commType = "";
	
	/**4-receiverId 接收方标识*/
	private String receiverId = "";
	
	/**4-senderId 发起方标识*/
	private String senderId = "";
	
	/**22-senderSN 发起方流水*/
	private String senderSN = "";
	
	/**8-senderDate 发起方日期*/
	private String senderDate = "";
	
	/**6-senderTime 发起方时间*/
	private String senderTime = "";
	
	/**6-tradeCode 交易代码 柜员签到交易(990001)， 查询柜员信息交易(990002) 银监黑名单（AFP002）*/
	private String tradeCode = "";
	
	/**2-gwErrorCode 网关错误标识 网关用于表示是否处理过程发生错误。发起方填空01 ---- 成功 00 ---- 错误-----*/
	private String gwErrorCode = "";
	
	/**7-gwErrorMessage 网关错误代码 用于表示具体错误内容的七位的半角字符串，发起方填空*/
	private String gwErrorMessage = "";
	
	/**1-gwEncoding U:UTF-8 g:GBK G或空:GB18030*/
	private String gwEncoding = "";
	
	/**1-resendFlag 重发标志 Y：重发 其他：非重发*/
	private String resendFlag = "";
	
	/**6-reserved1 保留位 空格填充*/
	private String reserved1 = "";
}
