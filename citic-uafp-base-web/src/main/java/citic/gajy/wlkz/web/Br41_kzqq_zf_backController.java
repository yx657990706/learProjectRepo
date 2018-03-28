/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqq_zf_backController.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.StrUtils;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back_mx;
import citic.gajy.wlkz.service.Br41_kzqq_zf_backService;

@Controller
@RequestMapping("/br41_kzqq_zf_back")
public class Br41_kzqq_zf_backController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1599529714756041764L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqq_zf_backService br41_kzqq_zf_backService;

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zf_backList(Model model, HttpServletRequest request, Page page, Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_zf_back searchObj = getSearchObject(br41_kzqq_zf_back, page, request);
			List<Br41_kzqq_zf_back> br41_kzqq_zf_backList = br41_kzqq_zf_backService.getBr41_kzqq_zf_backList(searchObj);

			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br41_kzqq_zf_backList", br41_kzqq_zf_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/br41_kzqq_zf_back/list");
	}

	@RequestMapping(value = "/kzzf_fk_disp", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zf_fkList(Model model, Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_zf_back kzqq_zf_back = br41_kzqq_zf_backService.getBr41_kzqq_zf_fkDisp(br41_kzqq_zf_back);
			model.addAttribute("br41_kzqq_zf_back", kzqq_zf_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/kzzf_fk_disp");
	}
	
	/**
	 * 止付反馈信息
	 * @param model
	 * @param br41_kzqq_zf_back
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_zf_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetResponse_zf_main(Model model, HttpServletRequest request,Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
		try {
          String backurl=StrUtils.nullToString(request.getParameter("backurl"));
  		model.addAttribute("backurl", backurl);
			model.addAttribute("br41_kzqq_zf_back", br41_kzqq_zf_back);
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/response_zf_main");
	}
	
	/**
	 *  查询请求执行止付明细信息
	 * @param model
	 */
	@RequestMapping(value = "/zf_mx_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zf_back_mxList(Model model, HttpServletRequest request, Page page, Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			String startDate=br41_kzqq_zf_back_mx.getZfjssj_start();
			String  enddDate=br41_kzqq_zf_back_mx.getZfjssj_end();
			String startDate2=br41_kzqq_zf_back_mx.getZfkssj_start();
			String  enddDate2=br41_kzqq_zf_back_mx.getZfkssj_end();
			Br41_kzqq_zf_back_mx searchObj = getSearchObject(br41_kzqq_zf_back_mx, page, request);
			List<Br41_kzqq_zf_back_mx> br41_kzqq_zf_back_mxList = br41_kzqq_zf_backService.getBr41_kzqq_zf_back_mxList(searchObj);

			model.addAttribute("br41_kzqq_zf_back_mxList", br41_kzqq_zf_back_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_zf_back_mxList", br41_kzqq_zf_back_mxList);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			searchObj.setZfjssj_start(startDate);
			searchObj.setZfjssj_end(enddDate);
			searchObj.setZfkssj_start(startDate2);
			searchObj.setZfkssj_end(enddDate2);
			model.addAttribute("br41_kzqq_zf_back_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/mx/kzzf_fk_mx_list");
	}
	/**
	 *  查询请求反馈止付明细信息
	 * @param model
	 */
	@RequestMapping(value = "/zf_bzck_mx_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zf_back_mxBackList(Model model, HttpServletRequest request, Page page, Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			String startDate=br41_kzqq_zf_back_mx.getZfjssj_start();
			String  enddDate=br41_kzqq_zf_back_mx.getZfjssj_end();
			String startDate2=br41_kzqq_zf_back_mx.getZfkssj_start();
			String  enddDate2=br41_kzqq_zf_back_mx.getZfkssj_end();
			Br41_kzqq_zf_back_mx searchObj = getSearchObject(br41_kzqq_zf_back_mx, page, request);
			List<Br41_kzqq_zf_back_mx> br41_kzqq_zf_back_mxList = br41_kzqq_zf_backService.getBr41_kzqq_zf_back_mxList(searchObj);

			model.addAttribute("br41_kzqq_zf_back_mxList", br41_kzqq_zf_back_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_zf_back_mxList", br41_kzqq_zf_back_mxList);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			searchObj.setZfjssj_start(startDate);
			searchObj.setZfjssj_end(enddDate);
			searchObj.setZfkssj_start(startDate2);
			searchObj.setZfkssj_end(enddDate2);
			model.addAttribute("br41_kzqq_zf_back_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/kzzf_fk_mx_list");
	}
	/**
	 * 添加止付明细信息
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String performAddBr41_kzqq_zf_back(Model model,HttpServletRequest request,Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		model.addAttribute("zxjgMap", getSelectMap("B00099"));
		model.addAttribute("bzMap", getTaskTypeSelectMap("Dcrtpd",br41_kzqq_zf_back_mx.getTasktype()));
		model.addAttribute("br41_kzqq_zf_back_mx", br41_kzqq_zf_back_mx);
		return ("/gajy/search/mx/kzzf_mx_add");
	}

	/**
	 *  保存添加的明细信息
	 * @param Br41_kzqq_zf_back
	 */
	@RequestMapping(value = "/save_add", method = RequestMethod.POST)
	public String performaddBr41_kzqq_zf_backDo(@ModelAttribute Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		try {
			int count=br41_kzqq_zf_backService.getBr41_kzqq_zf_back_mxDisp(br41_kzqq_zf_back_mx);
			if(count<1){
				br41_kzqq_zf_backService.insertBr41_kzqq_zf_back_mx(br41_kzqq_zf_back_mx);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf_back/zf_mx_list";
	}

	/**
	 * 修改止付明细信息
	 * @param model
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq_zf_back(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx, Model model) throws Exception {
		try {
			Br41_kzqq_zf_back_mx 	searchObj=br41_kzqq_zf_backService.getBr41_kzqq_zf_back_mxDoDisp(br41_kzqq_zf_back_mx);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("bzMap", getTaskTypeSelectMap("Dcrtpd",br41_kzqq_zf_back_mx.getTasktype()));
			model.addAttribute("br41_kzqq_zf_back_mx", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/mx/kzzf_mx_modify");
	}

	/**
	 * 保存修改
	 * @param model
	 */
	@RequestMapping(value = "/save_modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqq_zf_backDo(Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		try {
			int i = br41_kzqq_zf_backService.modifyBr41_kzqq_zf_back_mx(br41_kzqq_zf_back_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf_back/zf_mx_list";
	}

	/**
	 *  删除单条数据  止付明细信息
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqq_zf_back_mxDo(HttpServletRequest request,Model model,Br41_kzqq_zf_back_mx br41_kzqq_zf_back_mx) throws Exception {
		try {
			String rwlsh=request.getParameter("rwlshs");
			String qqdbs=request.getParameter("qqdbss");
			String zh=request.getParameter("zhs");
			String zzhxh=request.getParameter("zzhxhs");
			String tasktype=request.getParameter("tasktypes");
			br41_kzqq_zf_back_mx.setRwlsh(rwlsh);     
			br41_kzqq_zf_back_mx.setZh(zh);
			br41_kzqq_zf_back_mx.setZzhxh(zzhxh);
			br41_kzqq_zf_back_mx.setTasktype(tasktype);
			br41_kzqq_zf_back_mx.setQqdbs(qqdbs);
			 br41_kzqq_zf_backService.deleteBr41_kzqq_zf_back_mx(br41_kzqq_zf_back_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf_back/zf_mx_list?isNewSearch=1&rwlsh="+br41_kzqq_zf_back_mx.getRwlsh()+"&qqdbs="+br41_kzqq_zf_back_mx.getQqdbs()+"&tasktype="+br41_kzqq_zf_back_mx.getTasktype();
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_zf_backDisp(Model model, String rwlsh) throws Exception {
		//
		Br41_kzqq_zf_back br41_kzqq_zf_back = new Br41_kzqq_zf_back();
		br41_kzqq_zf_back = br41_kzqq_zf_backService.getBr41_kzqq_zf_backDisp(rwlsh);

		model.addAttribute("br41_kzqq_zf_back", br41_kzqq_zf_back);
		//
		return ("/br41_kzqq_zf_back/disp");
	}
}
