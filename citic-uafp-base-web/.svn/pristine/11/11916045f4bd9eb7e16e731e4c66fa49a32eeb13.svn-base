/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-04-12]
 * =============================================
 */

package citic.cgb.face.web;

/**
 * <p>
 * Cgb_face_dataController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import citic.base.utils.DtUtils;
import citic.base.utils.FileUtils;
import citic.base.utils.StrUtils;
import citic.cgb.face.domain.Cgb_face_data;
import citic.cgb.face.domain.Cgb_face_img;
import citic.cgb.face.service.Cgb_face_dataService;

@Controller
@RequestMapping("/cgb_face_data")
public class Cgb_face_dataController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4762407548324197634L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Cgb_face_dataService cgb_face_dataService;
	private String IMGPATH="webtemp"+File.separatorChar+"checkface";//人脸识别图片上传路径
	
	/**
	 * @param model
	 *  名单新增
	 */
	@RequestMapping(value = "/add_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataList(Model model, HttpServletRequest request, Page page, Cgb_face_data cgb_face_data) throws Exception {
		try {
			page.setPageSize(8);//每页8条数据
			/** 从session中获取查询对象 */
			page.setPageSize(8);
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataList(searchObj);
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
			searchObj.getPage().setPageSize(8);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/add_list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddCgb_face_data(Model model) throws Exception {
		Cgb_face_data cgb_face_data = new Cgb_face_data();
		model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
		model.addAttribute("busi_typeMap", getSelectMap("DG0001"));
		model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
		model.addAttribute("busi_wayMap", getSelectMap("G00046"));
		model.addAttribute("risk_typeMap", getSelectMap("G00045","0"));
		model.addAttribute("assist_card_typeMap", getSelectMap("G00043"));
		model.addAttribute("cgb_face_data", cgb_face_data);
		return ("/checkface/add");
	}
	
	/**
	 * @param Cgb_face_data
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddCgb_face_dataDo(HttpServletRequest request,Cgb_face_data cgb_face_data) throws Exception {
		try {
			String rootPath = codeService.getCodeValue("Dpara", "1");
			String relativePath = "";//文件相对路径
			String orgname = "";//原始文件名
			String filename="";//新的文件名
		    // 获取用户登录名
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			cgb_face_data.setAdd_user_id(loginname);
			cgb_face_data.setAdd_time(DtUtils.getNowTime());
			cgb_face_data.setSuspect_img_id(UUID.randomUUID().toString().replaceAll("-", ""));//嫌疑人图像ID
			cgb_face_data.setVictim_img_id(UUID.randomUUID().toString().replaceAll("-", ""));//受害人图像ID
			cgb_face_data.setData_source("1");//名单来源
			cgb_face_data.setFirmly_flag("0");
			cgb_face_data.setMd_channel("AFPM");//手工添加的默认AFPM
			cgb_face_data.setRm_flag("0");
			//时间处理8位转10位
			String busitime = cgb_face_data.getBusi_time().trim();
			String validity = cgb_face_data.getVictim_card_validity().trim();
			if(!StringUtils.isBlank(busitime)&&busitime.length()==8){
				String date1 = DtUtils.toStrDate(busitime);
				cgb_face_data.setBusi_time(date1);
			}
			if(!StringUtils.isBlank(validity)&&validity.length()==8){
				String date2 = DtUtils.toStrDate(validity);
				cgb_face_data.setVictim_card_validity(date2);
			}
			cgb_face_dataService.insertCgb_face_data(cgb_face_data);
			//存放嫌疑人图像
			if(cgb_face_data.getFile_suspect_path()!=null&&cgb_face_data.getFile_suspect_path().getSize()>0){
				Cgb_face_img  cgb_face_img=new Cgb_face_img();
				orgname = cgb_face_data.getFile_suspect_path().getOriginalFilename();
				filename=cgb_face_data.getSuspect_img_id()+orgname.substring(orgname.length()-4);
				relativePath = IMGPATH+File.separatorChar+filename;
				cgb_face_img.setImg_path(relativePath);	
				cgb_face_img.setImg_type("1");//1：嫌疑人图像 2：受害人联网核查图像 3：辅助证件图像
				cgb_face_img.setImg_id(cgb_face_data.getSuspect_img_id());
				cgb_face_img.setImg_name(filename);
				FileUtils.uploadFile(cgb_face_data.getFile_suspect_path().getInputStream(), rootPath+File.separatorChar+IMGPATH, filename);
				 cgb_face_dataService.insertCgb_face_dataImgList(cgb_face_img);
			}
			//存放受害人图像
			if(cgb_face_data.getFile_victim_path()!=null&&cgb_face_data.getFile_victim_path().getSize()>0){
				Cgb_face_img  cgb_face_img=new Cgb_face_img();
				orgname = cgb_face_data.getFile_victim_path().getOriginalFilename();
				filename=cgb_face_data.getVictim_img_id()+orgname.substring(orgname.length()-4);
				relativePath = IMGPATH+File.separatorChar+filename;
				cgb_face_img.setImg_path(relativePath);	
				cgb_face_img.setImg_type("2");
				cgb_face_img.setImg_id(cgb_face_data.getVictim_img_id());
				cgb_face_img.setImg_name(filename);
				FileUtils.uploadFile(cgb_face_data.getFile_victim_path().getInputStream(), rootPath+File.separatorChar+IMGPATH, filename);
				cgb_face_dataService.insertCgb_face_dataImgList(cgb_face_img);
			}
//			//辅助证件图像【人工时，不用添加辅助信息】
//			if(cgb_face_data.getFile_assist_path()!=null&&cgb_face_data.getFile_assist_path().getSize()>0){
//				Cgb_face_img  cgb_face_img=new Cgb_face_img();
//				String id = UUID.randomUUID().toString().replaceAll("-", "");
//				orgname = cgb_face_data.getFile_assist_path().getOriginalFilename();
//				filename = id+orgname.substring(orgname.length()-4);
//				relativePath = IMGPATH+File.separatorChar+filename;
//				cgb_face_img.setImg_path(relativePath);	
//				cgb_face_img.setImg_type("3");
//				cgb_face_img.setImg_id(id);//辅助证件图像ID
//				cgb_face_img.setImg_name(filename);
//				FileUtils.uploadFile(cgb_face_data.getFile_assist_path().getInputStream(), rootPath+File.separatorChar+IMGPATH, filename);
//				cgb_face_dataService.insertCgb_face_dataImgList(cgb_face_img);
//			}
//	        // 添加辅助证件信息
//			cgb_face_dataService.insertCgb_face_dataAssist(cgb_face_data);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/cgb_face_data/add");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{suspect_img_id}/modify", method = RequestMethod.GET)
	public String performModifyCgb_face_data(@PathVariable String suspect_img_id, Model model){
		try {
			Cgb_face_data cgb_face_data = new Cgb_face_data();
			cgb_face_data = cgb_face_dataService.getCgb_face_dataDisp(suspect_img_id);
			model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
			model.addAttribute("busi_typeMap", getSelectMap("DG0001"));
			model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
			model.addAttribute("busi_wayMap", getSelectMap("G00046"));
			model.addAttribute("risk_typeMap", getSelectMap("G00045","0"));
			model.addAttribute("assist_card_typeMap", getSelectMap("G00043"));
			model.addAttribute("cgb_face_data", cgb_face_data);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/modify");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String performModifyCgb_face_dataDo(HttpServletRequest request,@ModelAttribute Cgb_face_data cgb_face_data) {
		try {
			 // 获取用户登录名
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			cgb_face_data.setModify_user_id(loginname);
			//时间处理8位转10位
			String busitime = cgb_face_data.getBusi_time().trim();
			String validity = cgb_face_data.getVictim_card_validity().trim();
			if(!StringUtils.isBlank(busitime)&&busitime.length()==8){
				String date1 = DtUtils.toStrDate(busitime);
				cgb_face_data.setBusi_time(date1);
			}
			if(!StringUtils.isBlank(validity)&&validity.length()==8){
				String date2 = DtUtils.toStrDate(validity);
				cgb_face_data.setVictim_card_validity(date2);
			}
			cgb_face_dataService.modifyCgb_face_data(cgb_face_data);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/common/common_close");
	}
	
	/**
	 * 人工新增认定
	 * @param cgb_risk_case
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月26日 上午10:15:33
	 */
	@RequestMapping(value = "/person_add", method = RequestMethod.POST)
	public String performModifyCgb_risk_caseDo(@ModelAttribute Cgb_face_data cgb_face_data,  HttpServletRequest request) throws Exception {
		
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String[] keys = request.getParameterValues("keys");
			cgb_face_data.setCommit_user(loginname);
			//执行
			cgb_face_dataService.personAddCgb_face_group(cgb_face_data,keys);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		
		return ("redirect:/cgb_face_data/add_list?isNewSearch=1");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{suspect_img_id}/delete", method = RequestMethod.POST)
	public String performDeleteCgb_face_dataDo(@PathVariable String suspect_img_id) {
		try {
			cgb_face_dataService.deleteCgb_face_data(suspect_img_id);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/cgb_face_data/add_list");
	}
	
	@RequestMapping(value = "/check_delete", method = RequestMethod.POST)
	public String performCheckDeleteCgb_face_dataDo(@ModelAttribute Cgb_face_data cgb_face_data) {
		try {
			cgb_face_dataService.deleteCgb_face_dataByCheck(cgb_face_data);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/cgb_face_data/group_query_list?bzw=1&group_id="+cgb_face_data.getGroup_id());
	}
	/**
	 * 名单审核列表
	 * @param model
	 * @param request
	 * @param page
	 * @param cgb_face_data
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月21日 上午9:56:44
	 */
	@RequestMapping(value = "/check_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataCheckList(Model model, HttpServletRequest request, Page page, @ModelAttribute Cgb_face_data cgb_face_data) throws Exception {
		try {
			cgb_face_data.setCheck_result("1");//审核结果 1:待审核 2：审核通过 3：审核未通过
			/** 从session中获取查询对象 */
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataCheckList(searchObj);
			
			model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
//			model.addAttribute("busi_typeMap", getSelectMap("DG0001"));//业务办理类型不同渠道数据不同
			model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
//			model.addAttribute("busi_wayMap", getSelectMap("G00046"));
			model.addAttribute("risk_typeMap", getSelectMap("G00045","0"));
			model.addAttribute("md_channelMap", getSelectMap("G00050","1"));
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/check_list");
	}
	
	
	/**
	 * 审核操作(外层)
	 * @param model
	 * @param cgb_face_data
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月24日 上午10:22:21
	 */
	@RequestMapping(value = "/check_do_outer", method = RequestMethod.POST)
	public String performGetCgb_face_dataGroupCheckDoOuter(Model model,  HttpServletRequest request,@ModelAttribute Cgb_face_data cgb_face_data) throws Exception {
		try {
			 // 获取用户登录名
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			cgb_face_data.setCheck_user_id(loginname);
			cgb_face_dataService.checkDo(cgb_face_data);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/cgb_face_data/check_list");
	}

	@RequestMapping(value = "/check_do_inner", method = RequestMethod.POST)
	public String performGetCgb_face_dataGroupCheckDoInner(Model model,  HttpServletRequest request,@ModelAttribute Cgb_face_data cgb_face_data) throws Exception {
		try {
			 // 获取用户登录名
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			cgb_face_data.setCheck_user_id(loginname);
			cgb_face_dataService.checkDo(cgb_face_data);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/common/common_close");
	}
	/**
	 * @param model
	 *  名单查询
	 */
	@RequestMapping(value = "/query_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataQueryList(Model model, HttpServletRequest request, Page page, Cgb_face_data cgb_face_data) throws Exception {
		try {
			cgb_face_data.setCheck_result_disp("'2','3'");//审核结果 1:待审核 2：审核通过 3：审核未通过
			/** 从session中获取查询对象 */
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataQueryList(searchObj);
			model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
//			model.addAttribute("busi_typeMap", getSelectMap("DG0001"));//业务办理类型不同渠道数据不同
			model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
//			model.addAttribute("busi_wayMap", getSelectMap("G00046"));
			model.addAttribute("risk_typeMap", getSelectMap("G00045"));
			model.addAttribute("check_resultMap", getSelectMap("G00048","1"));
			model.addAttribute("md_channelMap", getSelectMap("G00050","1"));
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/query_list");
	}
	
	/**
	 * 组数据查询
	 * @param model
	 * @param cgb_face_data
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月27日 下午4:06:47
	 */
	@RequestMapping(value = "/group_query_list", method = RequestMethod.GET)
	public String performGetCgb_face_dataGroupQueryList(Model model, @ModelAttribute Cgb_face_data cgb_face_data) throws Exception {
		String forward = "/checkface/group_query";
		try {
			String bzw = cgb_face_data.getBzw();
			if("1".equals(bzw)){
				forward = "/checkface/group_check";
			}else if("2".equals(bzw)){
				forward = "/checkface/group_query";
			}else if("3".equals(bzw)){
				forward = "/checkface/group_remove";
			}else{
				forward = "/checkface/group_remove_check";
			}
			List<Cgb_face_data> list_old = cgb_face_dataService.getCgb_face_dataGroupList(cgb_face_data,bzw);
			Cgb_face_data face_data = new Cgb_face_data();
			List<Cgb_face_data> list =null;
			if(list_old.size()>1){
				face_data = list_old.get(0);//1.待审核图片信息
				list = list_old.subList(1, list_old.size());//2.相似图片信息
			}else if(list_old.size()==1){
				face_data = list_old.get(0);
				list = null;
			}
			Cgb_face_data _data = new Cgb_face_data();
			model.addAttribute("cgb_face_data", _data);
			model.addAttribute("face_data", face_data);
			model.addAttribute("cgb_face_dataList", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return (forward);
	}
	/**
	 * @param model
	 *    导出excle
	 */
	@RequestMapping(value = "/export_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataExcelList(Model model, HttpServletRequest request, Page page, Cgb_face_data cgb_face_data) throws Exception {
		try {
			cgb_face_data.setCheck_result_disp("'2','3'");//审核结果 1:待审核 2：审核通过 3：审核未通过
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			//设置导出限制
			page.setCount(false);
			String size = codeService.getCodeValue("Dpara", "10");
			page.setPageSize(Integer.parseInt(size));
			searchObj.setPage(page);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataQueryList(searchObj);
	
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/export_list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{suspect_img_id}/disp", method = RequestMethod.GET)
	public String performGetCgb_face_dataDisp(Model model, String suspect_img_id) throws Exception {
		Cgb_face_data cgb_face_data = new Cgb_face_data();
		cgb_face_data = cgb_face_dataService.getCgb_face_dataDisp(suspect_img_id);
		model.addAttribute("cgb_face_data", cgb_face_data);
		return ("/cgb_face_data/disp");
	}
	
	/**
	 * 名单出库
	 * @param model
	 * @param request
	 * @param page
	 * @param cgb_face_data
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年6月27日 下午4:35:07
	 */
	@RequestMapping(value = "/remove_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataRemoveList(Model model, HttpServletRequest request, Page page, Cgb_face_data cgb_face_data) throws Exception {
		try {
			cgb_face_data.setCheck_result_disp("'2'");//审核结果 1:待审核 2：审核通过 3：审核未通过
			cgb_face_data.setRm_flag_disp("'0','3'");//0:未出库 1:待出库 2:出库通过 3:出库不通过
			/** 从session中获取查询对象 */
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataQueryList(searchObj);
			model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
			model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
//			model.addAttribute("busi_wayMap", getSelectMap("G00046"));
			model.addAttribute("risk_typeMap", getSelectMap("G00045","0"));
			model.addAttribute("md_channelMap", getSelectMap("G00050","1"));
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/remove_list");
	}
	
	/**
	 * 名单出库审核
	 * @param model
	 * @param request
	 * @param page
	 * @param cgb_face_data
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年6月27日 下午4:39:21
	 */
	@RequestMapping(value = "/remove_check_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_face_dataRemoveCheckList(Model model, HttpServletRequest request, Page page, Cgb_face_data cgb_face_data) throws Exception {
		try {
			cgb_face_data.setCheck_result_disp("'2'");//审核结果 1:待审核 2：审核通过 3：审核未通过
			cgb_face_data.setRm_flag_disp("'1'");//0:未出库 1:待出库 2:出库通过 3:出库不通过
			/** 从session中获取查询对象 */
			Cgb_face_data searchObj = getSearchObject(cgb_face_data, page, request);
			List<Cgb_face_data> cgb_face_dataList = cgb_face_dataService.getCgb_face_dataQueryList(searchObj);
			model.addAttribute("busi_websiteMap", getSelectMap("Dorgan"));
			model.addAttribute("victim_card_typeMap", getSelectMap("G00044"));
//			model.addAttribute("busi_wayMap", getSelectMap("G00046"));
			model.addAttribute("risk_typeMap", getSelectMap("G00045","0"));
			model.addAttribute("md_channelMap", getSelectMap("G00050","1"));
			model.addAttribute("cgb_face_dataList", cgb_face_dataList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/checkface/remove_check_list");
	}
	
	@RequestMapping(value = "/remove_check_inner", method = RequestMethod.POST)
	public String performGetCgb_face_dataGroupRemoveCheckInner(Model model,  HttpServletRequest request,@ModelAttribute Cgb_face_data cgb_face_data) throws Exception {
		try {
			 // 获取用户登录名
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			if(StringUtils.equals("C", cgb_face_data.getBzw())){//出库
				cgb_face_data.setRm_user_id(loginname);
				cgb_face_dataService.RemoveDo(cgb_face_data);
			}else{
				cgb_face_data.setRm_check_user_id(loginname);
				cgb_face_dataService.RemoveCheckDo(cgb_face_data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/common/common_close");
	}
}
