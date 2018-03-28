package citic.cgb.task.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.cgb.task.domain.Button_task;
import citic.cgb.task.service.Button_taskService;

@Controller
@RequestMapping("/button_task")
public class Button_taskController extends AmlBaseController {
	
	@Autowired
	private Button_taskService server;
	
	private static final long serialVersionUID = 9068785960744663782L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 按钮任务监控主界面
	 * 
	 * @param model
	 * @param request
	 * @param button_task
	 * @return
	 * @author yinxiong
	 * @date 2017年7月24日 下午1:55:37
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetButton_taskList(Model model, HttpServletRequest request, @ModelAttribute Button_task button_task) {
		
		try {
			
			String msg = StringUtils.trimToEmpty(request.getParameter("msg"));
			//查询高法的bb13_sys_para配置
			Button_task sysGF = server.getBb11_data_taskByID(button_task);
			
			model.addAttribute("gfkg", sysGF.getVals());//02高法开关
			model.addAttribute("massege", msg);//错误消息
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return ("/cgb/task/button_task_list");
	}
	
	/**
	 * 01高法失败重算
	 * 
	 * @param model
	 * @param request
	 * @param button_task
	 * @return
	 * @author yinxiong
	 * @date 2017年7月24日 下午1:56:00
	 */
	@RequestMapping(value = "/GF_recal", method = RequestMethod.POST)
	public void performGFRecal(Model model, HttpServletRequest request, HttpServletResponse response, Button_task button_task) {
		
		try {
			if (server.doGFRecal()) {
				this.out(response, "01@true");//任务代号+执行结果
			} else {
				this.out(response, "01@false");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 02高法配置更新
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param button_task
	 * @author yinxiong
	 * @date 2017年7月24日 下午3:57:31
	 */
	@RequestMapping(value = "/GF_setpz", method = RequestMethod.POST)
	public void performGFSetPZ(Model model, HttpServletRequest request, HttpServletResponse response, Button_task button_task) {
		
		try {
			String val = StringUtils.trimToEmpty(request.getParameter("vals"));
			button_task.setVals(val);
			int i = server.updateBb13_sys_paraByID(button_task);
			if (i > 0) {
				this.out(response, "02@true");
			} else {
				this.out(response, "02@false");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
