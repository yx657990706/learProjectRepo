/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-02-29]
 * =============================================
 */

package citic.dxzp.ct.web;

/**
 * <p>
 * Cgb_risk_caseController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.StrUtils;
import citic.dxzp.ct.domain.Ct_yjmd;
import citic.dxzp.ct.domain.Ct_yjmd_private;
import citic.dxzp.ct.domain.Ct_yjmd_public;
import citic.dxzp.ct.service.Ct_yjmdService;

@Controller
@RequestMapping("/ct_md")
public class Ct_yjmdController extends AmlBaseController {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079093006505025959L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Ct_yjmdService ct_yjmdService;
	
	/**
	 * 名单文件查询
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/file_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCt_yjmd_fielList(Model model, HttpServletRequest request, Page page, Ct_yjmd ct_yjmd) throws Exception {
		
		try {
			Ct_yjmd searchObj = getSearchObject(ct_yjmd, page, request);
			List<Ct_yjmd> ct_yjmd_fileList = ct_yjmdService.getCt_yjmd_fileList(searchObj);
			model.addAttribute("ct_yjmdList", ct_yjmd_fileList);
			// 设置查询对象
			model.addAttribute("ct_yjmd", searchObj);
			model.addAttribute("md_typeMap", getSelectMap("G00004"));
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		return ("/dxzp/ct/load_list");
	}
	
	/**
	 * 名单文件上传
	 * @param request
	 * @param ct_yjmd
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String performFile_upload(HttpServletRequest request, Ct_yjmd ct_yjmd) throws Exception {
		
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			ct_yjmd.setCreate_user(loginname);
			ct_yjmdService.uploadMdFile(ct_yjmd);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		return ("redirect:/ct_md/file_list?isNewSearch=1");
	}
     
	
	/**
	 * 查询个人银监黑名单
	 * @param model
	 * @param request
	 * @param page
	 * @param ct_yjmd_private
	 * @return
	 * @throws Exception
	 * 
	 * @date 2016年10月21日 下午8:40:39
	 */
	@RequestMapping(value = "/privatelist", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCt_yjmdPrivateList(Model model, HttpServletRequest request, Page page, Ct_yjmd_private ct_yjmd_private) throws Exception {
		try {
		   Ct_yjmd_private searchObj = getSearchObject(ct_yjmd_private, page, request);
			List<Ct_yjmd_private> ct_yjmd_privateList = ct_yjmdService.getCt_yjmd_privateList(searchObj);
		    model.addAttribute("ct_yjmd_privateList", ct_yjmd_privateList);
		    model.addAttribute("cert_typeMap", getSelectMap("G00007"));
			// 设置查询对象
			model.addAttribute("ct_yimd_private", searchObj);
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		return ("/dxzp/ct/ct_yjmd_private_list");
	}
	
	
	/**
	 * 查询单位银监黑名单
	 * @param model
	 * @param request
	 * @param page
	 * @param ct_yjmd_private
	 * @return
	 * @throws Exception
	 * 
	 * @date 2016年10月21日 下午8:40:01
	 */
	@RequestMapping(value = "/publiclist", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCt_yjmdPublicList(Model model, HttpServletRequest request, Page page, Ct_yjmd_public ct_yjmd_public) throws Exception {
		try {
			Ct_yjmd_public searchObj = getSearchObject(ct_yjmd_public, page, request);
			List<Ct_yjmd_public> ct_yjmd_publicList = ct_yjmdService.getCt_yjmd_publicList(searchObj);
		    model.addAttribute("ct_yjmd_publicList", ct_yjmd_publicList);
			// 设置查询对象
			model.addAttribute("ct_yjmd_public", searchObj);
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		return ("/dxzp/ct/ct_yjmd_public_list");
	}
	
}
