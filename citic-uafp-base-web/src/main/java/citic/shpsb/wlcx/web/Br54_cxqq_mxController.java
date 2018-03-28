package citic.shpsb.wlcx.web;

/**
* <p>Br51_cxqq_mxController.java</p>
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.base.BaseController;
import citic.base.Page;
import citic.shpsb.wlcx.domain.Br54_cxqq_mx;
import citic.shpsb.wlcx.service.Br54_cxqq_mxService;

@Controller
@RequestMapping("/br54_cxqq_mx")
public class Br54_cxqq_mxController extends BaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962118818079623048L;
	/**
	 * 
	 */
private Logger logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br54_cxqq_mxService br54_cxqq_mxService;



/**
 *  查询请求明细信息
 * @param model
 * @param request
 * @param page
 * @param br54_cxqq_mx
 * @return
 * @throws Exception
 */
@RequestMapping(value="/request_mx_list",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr51_cxqqList(Model model, HttpServletRequest request, Page page, Br54_cxqq_mx br54_cxqq_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br54_cxqq_mx searchObj = getSearchObject(br54_cxqq_mx, page, request);
			List<Br54_cxqq_mx> br54_cxqqList = br54_cxqq_mxService.getBr54_cxqq_mxList(searchObj);
			model.addAttribute("party_class_cdMap", getSelectMap("G00006"));
			model.addAttribute("qrymodeMap", getSelectMap("G00024"));
			model.addAttribute("statusMap", getSelectMap("G00022"));
			model.addAttribute("br54_cxqqList", br54_cxqqList);
			model.addAttribute("br54_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/whpsb/cxqq/request_list");
	}

	
/**
 * 
 * @param model
 * @param request
 * @param page
 * @param br54_cxqq_mx
 * @return
 * @throws Exception
 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	 public String performGetBr51_cxqq_mxList(Model model,HttpServletRequest request, Page page, Br54_cxqq_mx br54_cxqq_mx)throws Exception {
		String path = "";
		String title = "";
		try {
			/**
			 * I:对私 C:对公
			 */
			/** 从session中获取查询对象 */
			Br54_cxqq_mx searchObj = getSearchObject(br54_cxqq_mx, page,request);
			List<Br54_cxqq_mx> br51_cxqq_mxList = br54_cxqq_mxService.getBr54_cxqq_mxList(searchObj);
			//单位个人  账户信息查询   开户资料查询
			if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxxcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxxcx")) { 
				title = "账户信息查询";
				path = "/shpsb/cxqq/request_zhxxcx_disp";
				// 单位个人  开户资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzlcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzlcx")) {
				title = "开户资料查询";
				path = "/shpsb/cxqq/request_zhxxcx_disp";
				// 单位个人  持有人资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyrcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyrcx")) {
				title = "持有人资料查询";
				path = "/shpsb/cxqq/request_zhcyrcx_disp";
				// 单位个人  	交易明细查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjymxcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymxcx")) {
				title = "交易明细查询";
				path = "/shpsb/cxqq/request_jymxcx_disp";
				//单位个人  操作日志查询
			}else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grczrzcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwczrzcx")) {
				title = "交易明细查询";
				path = "/shpsb/cxqq/request_jymxcx_disp";
				//单位个人   交易关联号查询
			}else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjyglhcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjyglhcx")) {
				title = "交易明细查询";
				path = "/shpsb/cxqq/request_jymxcx_disp";
				//单位个人  对端账号查询
			}else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grddzhcx")|| br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwddzhcx")) {
				title = "交易明细查询";
				path = "/shpsb/cxqq/request_jymxcx_disp";
			}
			model.addAttribute("cljgMap", getSelectMap("G00025"));
			model.addAttribute("party_class_cdMap", getSelectMap("G00023"));
			model.addAttribute("qrymodeMap", getSelectMap("G00024"));
			model.addAttribute("title", title);
			model.addAttribute("br51_cxqq_mxList", br51_cxqq_mxList);
			model.addAttribute("pageInfoStr",getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return (path);
	}

/**
*  查询请求单信息
* @param model
*/
/*@RequestMapping(value="/request_disp",method=RequestMethod.GET)
public String performGetBr51_cxqq_mxDisp(Model model,Br51_cxqq_mx br51_cxqq_mx)  throws Exception{
String path="/errors/exception";
if(br51_cxqq_mx.getQrymode()!=null && !"".equals(br51_cxqq_mx.getQrymode())){
  if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxx")|| br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxx")
	   || br51_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzl")|| br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzl")) {
	   path="/whpsb/cxqq/request_zhxx";
	}else if(br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyr")|| br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyr")){
		path="/whpsb/cxqq/request_zhcyr";	
	}else if(br51_cxqq_mx.getQrymode().equalsIgnoreCase("grjymx")|| br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymx")){
		path="/whpsb/cxqq/request_jymx";	
			}
  }else{
	  path="/errors/exception";
  }
  br54_cxqq_mx = br54_cxqq_mxService.getBr51_cxqq_mxDisp(br51_cxqq_mx.getBdhm());

model.addAttribute("br51_cxqq_mx", br51_cxqq_mx);
return(path);
}*/
}
