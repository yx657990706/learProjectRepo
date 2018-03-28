/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqq_dj_backController.java</p>
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
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back;
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back_mx;
import citic.gajy.wlkz.service.Br41_kzqq_dj_backService;

@Controller
@RequestMapping("/br41_kzqq_dj_back")
public class Br41_kzqq_dj_backController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1465299389962140546L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqq_dj_backService br41_kzqq_dj_backService;
	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_dj_backList(Model model, HttpServletRequest request, Page page, Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_dj_back searchObj = getSearchObject(br41_kzqq_dj_back, page, request);
			List<Br41_kzqq_dj_back> br41_kzqq_dj_backList = br41_kzqq_dj_backService.getBr41_kzqq_dj_backList(searchObj);

			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br41_kzqq_dj_backList", br41_kzqq_dj_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/br41_kzqq_dj_back/list");
	}
	
	
     /**
      * 查询反馈详细信息
      * @param model
      * @param br41_kzqq_dj_back
      * @return
      * @throws Exception
      */
	@RequestMapping(value = "/kzdj_fk_disp",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_dj_fkDisp(Model model,Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_dj_back kzqq_dj_back = br41_kzqq_dj_backService.getBr41_kzqq_dj_fkList(br41_kzqq_dj_back);
			model.addAttribute("br41_kzqq_dj_back", kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/kzdj_fk_disp");
	}

	/**
     * 查询反馈明细信息
     * @param model
     * @param br41_kzqq_dj_back_mx
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/kzdj_fk_mx_list",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetKzdj_fk_mx_list(Model model,HttpServletRequest request,Page page,Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
			String startDate=br41_kzqq_dj_back_mx.getDjkssj_start();
			String endDate=br41_kzqq_dj_back_mx.getDjkssj_end();
			String startDate2=br41_kzqq_dj_back_mx.getDjjssj_start();
			String endDate2=br41_kzqq_dj_back_mx.getDjjssj_end();
			/** 从session中获取查询对象 */
			Br41_kzqq_dj_back_mx searchObj = getSearchObject(br41_kzqq_dj_back_mx, page, request);
			List<Br41_kzqq_dj_back_mx> br41_kzqq_dj_back_mxList = br41_kzqq_dj_backService.getKzdj_fk_mx_list(searchObj);
			model.addAttribute("br41_kzqq_dj_back_mxList",br41_kzqq_dj_back_mxList);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			searchObj.setDjkssj_start(startDate);
			searchObj.setDjkssj_end(endDate);
			searchObj.setDjjssj_start(startDate2);
			searchObj.setDjjssj_end(endDate2);
			model.addAttribute("br41_kzqq_dj_back_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/response_fk_mx_list");
	}

	/**
     * 查询反馈信息main
     * @param model
     * @param br41_kzqq_dj_back
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/kzdj_fk_main",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqqKzdj_fk_mx_main(Model model,HttpServletRequest request,Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
			   String backurl=StrUtils.nullToString(request.getParameter("backurl"));
	    		model.addAttribute("backurl", backurl);
			model.addAttribute("br41_kzqq_dj_back_mx", br41_kzqq_dj_back_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/kzdj_fk_main");
	}

	
	
	/**
     * 查询请求执行明细信息
     * @param model
     * @param br41_kzqq_dj_back_mx
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/dj_mx_list",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetKzdj_mx_list(Model model,HttpServletRequest request,Page page,Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			String startDate=br41_kzqq_dj_back_mx.getDjkssj_start();
			String endDate=br41_kzqq_dj_back_mx.getDjkssj_end();
			String startDate2=br41_kzqq_dj_back_mx.getDjjssj_start();
			String endDate2=br41_kzqq_dj_back_mx.getDjjssj_end();
			Br41_kzqq_dj_back_mx searchObj = getSearchObject(br41_kzqq_dj_back_mx, page, request);
			List<Br41_kzqq_dj_back_mx> br41_kzqq_dj_back_mxList = br41_kzqq_dj_backService.getKzdj_fk_mx_list(searchObj);
			model.addAttribute("br41_kzqq_dj_back_mxList",br41_kzqq_dj_back_mxList);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			searchObj.setDjkssj_start(startDate);
			searchObj.setDjkssj_end(endDate);
			searchObj.setDjjssj_start(startDate2);
			searchObj.setDjjssj_end(endDate2);
			model.addAttribute("br41_kzqq_dj_back_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/mx/kzdj_mx_list");
	}
	
	
	/**
	 * 添加冻结明细信息
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String performAddBr41_kzqq_dj_back(Model model,	Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		model.addAttribute("zxjgMap", getSelectMap("B00099"));
		model.addAttribute("bzMap", getTaskTypeSelectMap("Dcrtpd",br41_kzqq_dj_back_mx.getTasktype()));
		model.addAttribute("br41_kzqq_dj_back_mx", br41_kzqq_dj_back_mx);
		return ("/gajy/search/mx/kzdj_mx_add");
	}

	/**
	 *   添加凍結明細信息
	 * @param Br41_kzqq_dj_back_mx
	 */
	@RequestMapping(value = "/save_add", method = RequestMethod.POST)
	public String performaddBr41_kzqq_dj_backDo(@ModelAttribute Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
		int count=br41_kzqq_dj_backService.getBr41_kzqq_dj_back_mxCountDisp(br41_kzqq_dj_back_mx);
			if(count<1){
				br41_kzqq_dj_backService.insertBr41_kzqq_dj_back_mx(br41_kzqq_dj_back_mx);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_dj_back/dj_mx_list";
	}

	/**
	 * 修改明細信息
	 * @param model
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq_dj_back(Br41_kzqq_dj_back_mx  br41_kzqq_dj_back_mx, Model model) throws Exception {
		try {
			Br41_kzqq_dj_back_mx	kzqq_dj_back = br41_kzqq_dj_backService.getBr41_kzqq_dj_back_mxDisp(br41_kzqq_dj_back_mx);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("bzMap", getTaskTypeSelectMap("Dcrtpd",br41_kzqq_dj_back_mx.getTasktype()));
			model.addAttribute("br41_kzqq_dj_back_mx", kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");	
		
		}
		return ("/gajy/search/mx/kzdj_mx_modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/save_modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqq_dj_backDo( Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
			int i = br41_kzqq_dj_backService.modifyBr41_kzqq_dj_back_mx(br41_kzqq_dj_back_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_dj_back/dj_mx_list?isNewSearch=1&rwlsh="+br41_kzqq_dj_back_mx.getRwlsh()+
				"&qqdbs="+br41_kzqq_dj_back_mx.getQqdbs()+"&tasktype="+br41_kzqq_dj_back_mx.getTasktype();
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqq_dj_backDo(HttpServletRequest request,Br41_kzqq_dj_back_mx br41_kzqq_dj_back_mx) throws Exception {
		try {
			String rwlsh=request.getParameter("rwlshs");
			String qqdbs=request.getParameter("qqdbss");
			String zh=request.getParameter("zhs");
			String zzhxh=request.getParameter("zzhxhs");
			String tasktype=request.getParameter("tasktypes");
			br41_kzqq_dj_back_mx.setRwlsh(rwlsh);     
			br41_kzqq_dj_back_mx.setZh(zh);
			br41_kzqq_dj_back_mx.setZzhxh(zzhxh);
			br41_kzqq_dj_back_mx.setTasktype(tasktype);
			br41_kzqq_dj_back_mx.setQqdbs(qqdbs);
			int i = br41_kzqq_dj_backService.deleteBr41_kzqq_dj_back_mx(br41_kzqq_dj_back_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_dj_back/dj_mx_list?isNewSearch=1&rwlsh="+br41_kzqq_dj_back_mx.getRwlsh()+
				"&qqdbs="+br41_kzqq_dj_back_mx.getQqdbs()+"&tasktype="+br41_kzqq_dj_back_mx.getTasktype();
	}
}
