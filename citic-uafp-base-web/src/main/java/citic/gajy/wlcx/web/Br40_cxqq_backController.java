/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-23] 
 * =============================================
 */

package citic.gajy.wlcx.web;

/**
 * <p>Br40_cxqq_backController.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_excle;
import citic.gajy.wlcx.service.Br40_cxqq_backService;

@Controller
@RequestMapping("/br40_cxqq_back")
public class Br40_cxqq_backController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6817264043686722432L;
	/**
	 * 
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br40_cxqq_backService br40_cxqq_backService;

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backList(Model model, HttpServletRequest request, Page page, Br40_cxqq_back br40_cxqq_back) throws Exception {
		//
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back searchObj = getSearchObject(br40_cxqq_back, page, request);
			List<Br40_cxqq_back> br40_cxqq_backList = br40_cxqq_backService.getBr40_cxqq_backList(searchObj);

			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br40_cxqq_backList", br40_cxqq_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		//
		return ("/gajy/search/request_cg_fk_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr40_cxqq_back(Model model) throws Exception {
		//
		Br40_cxqq_back br40_cxqq_back = new Br40_cxqq_back();

		model.addAttribute("br40_cxqq_back", br40_cxqq_back);
		//
		return ("/br40_cxqq_back/add");
	}

	/**
	 *
	 * @param Br40_cxqq_back
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr40_cxqq_backDo(@ModelAttribute Br40_cxqq_back br40_cxqq_back) throws Exception {
		//
		try {
			int i = br40_cxqq_backService.insertBr40_cxqq_back(br40_cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq_back/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_back(@PathVariable String qqdbs, Model model) throws Exception {
		//
		Br40_cxqq_back br40_cxqq_back = new Br40_cxqq_back();
		br40_cxqq_back = br40_cxqq_backService.getBr40_cxqq_backDisp(qqdbs);

		model.addAttribute("br40_cxqq_back", br40_cxqq_back);
		//
		return ("/br40_cxqq_back/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.POST)
	public String performModifyBr40_cxqq_backDo(@ModelAttribute Br40_cxqq_back br40_cxqq_back) throws Exception {
		//
		try {
			int i = br40_cxqq_backService.modifyBr40_cxqq_back(br40_cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/redirect:br40_cxqq_back/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/delete", method = RequestMethod.POST)
	public String performDeleteBr40_cxqq_backDo(Model model, String qqdbs) throws Exception {
		//
		try {
			int i = br40_cxqq_backService.deleteBr40_cxqq_back(qqdbs);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq_back/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_backDisp(Model model, String qqdbs) throws Exception {
		//
		Br40_cxqq_back br40_cxqq_back = new Br40_cxqq_back();
		br40_cxqq_back = br40_cxqq_backService.getBr40_cxqq_backDisp(qqdbs);

		model.addAttribute("br40_cxqq_back", br40_cxqq_back);
		//
		return ("/br40_cxqq_back/disp");
	}
	
	/**
	 * Excle模板导出
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param br40_cxqq_back
	 * @throws Exception
	 */
	@RequestMapping(value = "/export", method = { RequestMethod.POST} )
	public void performDownload(Model model, HttpServletRequest request, HttpServletResponse response, Br40_cxqq_back br40_cxqq_back) throws Exception{
		try {
			//查询内容 01 账户信息；02 账户交易明细信息；03 账户和账户的交易明细信息；根据不同内容下载不同的模板
			String m_file_path = "";
			String cxnr = br40_cxqq_back.getCxnr();
            String tasktype = br40_cxqq_back.getTasktype();
            String rwlsh = br40_cxqq_back.getRwlsh();
            // 制作好的模板存放路径
			String root_9 = codeService.getCodeValue("Dpara", "9");//代码9已有文件分割符，代码1没有文件分割符
			String des_filename = tasktype+"_"+rwlsh+".xls";//文件名称
			if("01".equals(cxnr)){
				m_file_path = root_9+"excelTemplate/zhxx.xls";//常规查询账户信息模板
			}else if("02".equals(cxnr)){
				m_file_path = root_9+"excelTemplate/jymx.xls";//常规查询交易明细模板
			}else if("03".equals(cxnr)){
				m_file_path = root_9+"excelTemplate/zhxx_jymx.xls";//常规查询账户信息和交易明细模板
			}else{
				m_file_path = root_9+"excelTemplate/dt_jymx.xls";//动态查询交易明细模板
			}
			//下载
			this.downloadFile(response, des_filename, m_file_path,"1");
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
    }
	
	/**
	 * 请求信息处理（银行查询结果EXCLE导入）
	 * 
	 * @param model
	 * @param br40_cxqq_excle
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/importExcle", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr19_proj_org_attach(Model model, @ModelAttribute Br40_cxqq_excle br40_cxqq_excle) throws Exception {

		model.addAttribute("br40_cxqq_excle", br40_cxqq_excle);

		return ("/gajy/cxqqcl/excle_add");
	}

	/**
	 * 请求信息处理（银行查询结果EXCLE导入）
	 * 
	 * @param model
	 * @param br40_cxqq_excle
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/importExcle", method = RequestMethod.POST)
	@Token(setToken = true)
	public String performAddBr19_proj_org_attachDo(Model model, @ModelAttribute Br40_cxqq_excle br40_cxqq_excle, HttpServletRequest request) throws Exception {
		String returnStr = "/common/common_success";
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			br40_cxqq_excle.setCreate_user(loginname);

			String errMsg = br40_cxqq_backService.readExcle(br40_cxqq_excle);
    
			if("".equals(errMsg)){
				errMsg = "Excle导入成功！";
			}
			model.addAttribute("errMsg", errMsg);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return (returnStr);
	}
}
