package citic.gdjc.ckdj.web;

/**
* <p>Br50_cxqqController.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gdjc.ckdj.domain.Br50_cxqq;
import citic.gdjc.ckdj.domain.Br50_cxqq_back_acct;
import citic.gdjc.ckdj.domain.Br50_cxqq_back_trans;
import citic.gdjc.ckdj.domain.Br50_cxqq_mx;
import citic.gdjc.ckdj.service.Br50_cxqqService;

@Controller
@RequestMapping("/br50_cxqq")
public class Br50_cxqqController extends AmlBaseController{
/**
	 * 
	 */
	private static final long serialVersionUID = 4153806215508973243L;
private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br50_cxqqService br50_cxqqService;


/**
* 查询请求信息
* @param model
*/
@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
public String performGetBr50_cxqqList(Model model, HttpServletRequest request, Page page, Br50_cxqq br50_cxqq) throws Exception {
		try {
			//判断是否第一次查询
			if(br50_cxqq.getIsFirst().equals("1")){
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1,-30);
				br50_cxqq.setQrydt_start(DtUtils.toStrDate(start_dt));
				br50_cxqq.setQrydt_end(end_dt);
				br50_cxqq.setStatus("4");
			}
			//获取机构号
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br50_cxqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			 Br50_cxqq searchObj = getSearchObject(br50_cxqq, page, request);
			List<Br50_cxqq> br50_cxqqList = br50_cxqqService.getBr50_cxqqList(searchObj);
			model.addAttribute("statusMap", getSelectMap("G00022","2"));
			model.addAttribute("datasourceMap", getSelectMap("G00012"));
			model.addAttribute("organMap",getSelectMap("Dorgan") );
			model.addAttribute("br50_cxqqList", br50_cxqqList);
			model.addAttribute("br50_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gdjc/cxqq/request_list");
	}
	/**
	 * 查询账户反馈信息
	 * @param model
	 * @param request
	 * @param page
	 * @param br50_cxqq_back_acct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/response_account",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr50_cxqqListAccount(Model model,HttpServletRequest request,Page page,Br50_cxqq_back_acct br50_cxqq_back_acct) throws Exception{
	try {
		/** 从session中获取查询对象 */
		if(!StringUtils.isBlank(br50_cxqq_back_acct.getDocno_s())){
			//解决docno冲突
			br50_cxqq_back_acct.setDocno(br50_cxqq_back_acct.getDocno_s());
		}
		if(!StringUtils.isBlank(br50_cxqq_back_acct.getCaseno_s())){
			//解决caseno冲突
			br50_cxqq_back_acct.setCaseno(br50_cxqq_back_acct.getCaseno_s());
		}
		if(!StringUtils.isBlank(br50_cxqq_back_acct.getUniqueid_s())){
			//解决uniqueid冲突
			br50_cxqq_back_acct.setUniqueid(br50_cxqq_back_acct.getUniqueid_s());
		}
		Br50_cxqq_back_acct searchObj = getSearchObject(br50_cxqq_back_acct, page, request);
		List<Br50_cxqq_back_acct> br50_cxqqAccountList = br50_cxqqService.getBr50_cxqqListAccount(searchObj);
		model.addAttribute("cardstatusMap", getSelectMap("G00011"));
		model.addAttribute("datatypeMap", getSelectMap("G00014","3"));
		model.addAttribute("br50_cxqqAccountList", br50_cxqqAccountList);
		model.addAttribute("br50_cxqq_back_acct", searchObj);
		model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
	  } catch (Exception e) {
	   logger.error(e.getMessage(),e);
	   return ("/errors/exception");
			}
	   return ("/gdjc/cxfk/request_account_list");
		}

	/**
	 * 查询交易流水反馈信息
	 * @param model
	 * @param request
	 * @param page
	 * @param br50_cxqq_back_acct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/response_trans",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr50_cxqqListTrans(Model model,HttpServletRequest request,Page page,Br50_cxqq_back_trans br50_cxqq_back_trans) throws Exception{
	try {
		/** 从session中获取查询对象 */
		if(!StringUtils.isBlank(br50_cxqq_back_trans.getDocno_s())){
			//解决docno冲突
			br50_cxqq_back_trans.setDocno(br50_cxqq_back_trans.getDocno_s());
		}
		if(!StringUtils.isBlank(br50_cxqq_back_trans.getCaseno_s())){
			//解决caseno冲突
			br50_cxqq_back_trans.setCaseno(br50_cxqq_back_trans.getCaseno_s());
		}
		if(!StringUtils.isBlank(br50_cxqq_back_trans.getUniqueid_s())){
			//解决uniqueid冲突
			br50_cxqq_back_trans.setUniqueid(br50_cxqq_back_trans.getUniqueid_s());
		}
		String beginDate=br50_cxqq_back_trans.getTranstime_start();
		String endDate=br50_cxqq_back_trans.getTranstime_end();
		Br50_cxqq_back_trans searchObj = getSearchObject(br50_cxqq_back_trans, page, request);
		List<Br50_cxqq_back_trans> br50_cxqqAccountTransList = br50_cxqqService.getBr50_cxqqListAccountTransBack(searchObj);
		searchObj.setTranstime_start(beginDate);
		searchObj.setTranstime_end(endDate);
		model.addAttribute("br50_cxqq_back_trans", searchObj);
		model.addAttribute("statusMap", getSelectMap("G00022"));
		model.addAttribute("br50_cxqqAccountTransList", br50_cxqqAccountTransList);
		model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
		logger.error(e.getMessage(),e);
		return ("/errors/exception");
		}
	return ("/gdjc/cxfk/tran_back_list");
		}	

/**
 * 查询账户交易流水
 * @param model
 * @param request
 * @param page
 * @param br50_cxqq_back_acct
 * @return
 * @throws Exception
 */
@RequestMapping(value="/response_tran",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr50_cxqqListAccounttrans(Model model,HttpServletRequest request,Page page,Br50_cxqq_mx br50_cxqq_mx) throws Exception{
try {
			/** 从session中获取查询对象 */
			Br50_cxqq_mx searchObj = getSearchObject(br50_cxqq_mx, page, request);
			List<Br50_cxqq_mx> br50_cxqq_mxList = br50_cxqqService.getBr50_cxqqListAccountTrans(searchObj);
			model.addAttribute("statusMap", getSelectMap("G00017"));
			model.addAttribute("cxfkjgMap", getSelectMap("G00021"));
			model.addAttribute("br50_cxqq_mxList", br50_cxqq_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(page));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gdjc/cxqq/account_tran_list");
	}
}
