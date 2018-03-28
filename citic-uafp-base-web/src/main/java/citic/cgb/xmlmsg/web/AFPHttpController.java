package citic.cgb.xmlmsg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.cgb.xmlmsg.service.impl.AFPService;


/**
 * 通用xml报文入口
 * <br>从AFP004接口开始整合系统标识AFPN的xml报文，AFPN系统标识只是应用于AFP002接口
 * <br>从AFP004接口开始，之后所有的xml报文通过本类根据6位交易码进行分发处理
 * <br>新的系统标识为AFPM
 * 
 * @author yinxiong
 * @date 2017年4月21日 下午7:11:59
 */
@Controller
@RequestMapping("/afpm")
public class AFPHttpController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8377459813794928449L;
	
	@Autowired
    private ApplicationContext context;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String ENCODING = "GB18030";//设置响应编码为GB18030
	private String TRADE_START_TAG = "<gateway:tradeCode>";//网关通用报文头定义的交易码开始标签 
	private String TRADE_END_TAG = "</gateway:tradeCode>";//网关通用报文头定义的交易码结束标签
	

	@RequestMapping(value = "/serviceInterface", method = RequestMethod.POST)
	public void performCreateCgb_face_data(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String xmlData = "";
		PrintWriter w = null;
		ServletInputStream sis = null;
		try {
			response.setCharacterEncoding(ENCODING);//设置响应编码为GB18030，否则网关转码会失败
			w = response.getWriter();
			sis = request.getInputStream();//读取http请求流
			int size = request.getContentLength();
			byte[] buffer = new byte[size];//用于缓存每次读取的数据
			byte[] xmldatebyte = new byte[size];//用于存放结果的数组
			int count = 0;
			int rbyte = 0;
			while (count < size) {
				rbyte = sis.read(buffer);//每次读取存放在rbyte中
				for (int i = 0; i < rbyte; i++) {
					xmldatebyte[count + i] = buffer[i];
				}
				count += rbyte;
			}
			//获取请求XML信息
			xmlData = new String(xmldatebyte, ENCODING);
			logger.info("请求报文：" + xmlData);
			//解析出交易码，选取处理的实现类
			String tradeCode = StringUtils.substringBetween(xmlData, TRADE_START_TAG, TRADE_END_TAG);
			logger.info("请求接口：" + tradeCode);
			AFPService service = (AFPService)context.getBean(tradeCode.toLowerCase());
			//数据处理
			 String rData = service.messageReceived(xmlData);
			logger.info("响应报文：" + rData);
			//反馈数据
			w.write(rData);
			w.flush();
		} catch (Exception e) {
			logger.error("接口访问出错：" + e.getMessage(), e);
		} finally {
			try {
				if (w != null) {
					w.close();
				}
				if (sis != null) {
					sis.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}


	
	
	
	
	
	
}
