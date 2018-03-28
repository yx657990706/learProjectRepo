package citic.dxzp.ct.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.dxzp.ct.service.Ct_yjmdInterfaceService;

@Controller
@RequestMapping("/afpn/yjmd")
public class Ct_yjmdInterfaceController extends AmlBaseController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2714381631193101130L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Ct_yjmdInterfaceService ct_yjmdInterfaceService;
	
	/**
	 * 名单文件查询
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/queryInterface", method = {RequestMethod.POST})
	public void performGetCt_yjmd_fielList(Model model, HttpServletRequest request, HttpServletResponse response) {
		String xmlData = "";
		PrintWriter w = null;
		ServletInputStream sis = null;
		try {
			response.setCharacterEncoding("GB18030");//设置响应编码为GB18030，否则网关转码会失败
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
			xmlData = new String(xmldatebyte, "GB18030");
			logger.info("请求报文："+xmlData);
			//java HTMLdecode解码处理中文--用soap解析时不用转换
			//			String data = StringEscapeUtils.unescapeHtml4(xmlData);
			//数据处理
			String rData = ct_yjmdInterfaceService.messageReceived(xmlData);
			logger.info("响应报文："+rData);
			//反馈数据
			w.write(rData);
			w.flush();
		} catch (Exception e) {
			logger.error("接口访问出错：" + e.getMessage(),e);
		} finally {
			if (sis != null) {
				try {
					sis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (w != null) {
				w.close();
			}
		}
	}
	
}
