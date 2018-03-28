/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-24] 
* =============================================
*/

package citic.gajy.wlcx.web;

/**
* <p>Br40_acct_ruleController.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import java.util.*;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;	

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import citic.aml.base.AmlBaseController;
import citic.aml.base.CommonService;
import citic.aml.system.domain.Mc00_tast;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.service.Br40_acct_ruleService;
import citic.gajy.wlcx.domain.Br40_acct_rule;

@Controller
@RequestMapping("/br40_acct_rule")
public class Br40_acct_ruleController extends AmlBaseController{
/**
	 * 
	 */
private static final long serialVersionUID = 4219324127966337049L;

private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br40_acct_ruleService br40_acct_ruleService;
@Autowired
private CommonService   commonService;
/**
*
* @param model
*/
@RequestMapping(value="/list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr40_acct_ruleList(Model model,HttpServletRequest request,Page page,Br40_acct_rule br40_acct_rule) throws Exception{
try {
/**从session中获取查询对象*/ 
Br40_acct_rule searchObj = getSearchObject(br40_acct_rule, page, request); 
List<Br40_acct_rule> br40_acct_ruleList = br40_acct_ruleService.getBr40_acct_ruleList(searchObj);

model.addAttribute("flagMap", getSelectMap("S00002"));
model.addAttribute("br40_acct_rule", searchObj);
model.addAttribute("br40_acct_ruleList", br40_acct_ruleList);
model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}

//
		return ("/gajy/resport/bank_acc_rule_list");
}
/**
*
* @param model
*/
@RequestMapping(value="/add",method=RequestMethod.GET)
@Token(setToken = true)
public String performAddBr40_acct_rule(Model model)  throws Exception{
//
Br40_acct_rule br40_acct_rule = new Br40_acct_rule();

model.addAttribute("br40_acct_rule", br40_acct_rule);
//
return("/gajy/resport/bank_acc_add");
}
/**
*
* @param Br40_acct_rule
*/
@RequestMapping(value="/add",method=RequestMethod.POST)
public String performaddBr40_acct_ruleDo(@ModelAttribute Br40_acct_rule br40_acct_rule,HttpServletRequest request)  throws Exception{
try {
//查询是否有这条
int count=br40_acct_ruleService.getBr40_acct_ruleCount(br40_acct_rule.getUniqueid());
   if(count<1){
	   int i = br40_acct_ruleService.insertBr40_acct_rule(br40_acct_rule,request);
   }
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_acct_rule/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/modify",method=RequestMethod.GET)
public String performModifyBr40_acct_rule(@RequestParam String uniqueid,Model model)  throws Exception{
	
Br40_acct_rule br40_acct_rule = new Br40_acct_rule();

br40_acct_rule = br40_acct_ruleService.getBr40_acct_ruleDisp(uniqueid);

model.addAttribute("br40_acct_rule", br40_acct_rule);
model.addAttribute("flagMap", getSelectMap("S00002"));
return("/gajy/resport/bank_acc_modify");
}
/**
*
* @param model
*/
@RequestMapping(value="/save_modify",method=RequestMethod.POST)
public String performModifyBr40_acct_ruleDo(@ModelAttribute Br40_acct_rule br40_acct_rule,HttpServletRequest request)  throws Exception{
//
try {
//获取当前用户
String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
br40_acct_rule.setLastts(DtUtils.getNowTime());
br40_acct_rule.setLastuser(loginname);
int i = br40_acct_ruleService.modifyBr40_acct_rule(br40_acct_rule);
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_acct_rule/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/delete",method =RequestMethod.POST)
public String performDeleteBr40_acct_ruleDo(Model model,@PathVariable String uniqueid)  throws Exception{
try {
int i = br40_acct_ruleService.deleteBr40_acct_rule(uniqueid);
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_acct_rule/list");
}


/**
 * 上报规则    
 * bdhm // 1-网点登记表 2-账号规则表 3-城市代号	
 * @param model
 * @param type
 * @param request
 * @return
 * @throws Exception
 * 
 * @date 2016年9月18日 下午2:27:59
 */
	@RequestMapping(value = "/resport_rule", method = RequestMethod.POST)
	public String performDeleteBr40_acct_ruleResport(Model model, @RequestParam String type, HttpServletRequest request) throws Exception {
		String path = "/errors/exception";
		String tx_code = "";
		try {
			/* type 2 账号规则 (ZHGZ);3 城市代号(CSDH) */
			if (type.equals("2")) {
				tx_code = "ZHGZ";
			} else {
				tx_code = "CSDH";
			}
			
			List<Mc00_tast> mc00_tastList = br40_acct_ruleService.getBr40_acct_ruleByTx_code(tx_code);
			if (mc00_tastList.size() > 0) {
				if (type.equals("2")) {
					
					for (Mc00_tast mc00 : mc00_tastList) {
						Mc00_tast mc00_tast = new Mc00_tast();
						mc00_tast.setBdhm("2");
						mc00_tast.setSubtaskid(mc00.getTx_code());
						mc00_tast.setTasktype(mc00.getTasktype());
						commonService.insertMc21_task_fact3(mc00_tast, "JCSJ_" + mc00.getTasktype());
					}
					
					path = "redirect:/br40_acct_rule/list?isNewSearch=1";
				} else if (type.equals("3")) {
					
					for (Mc00_tast mc00 : mc00_tastList) {
						Mc00_tast mc00_tast = new Mc00_tast();
						mc00_tast.setBdhm("3");
						mc00_tast.setSubtaskid(mc00.getTx_code());
						mc00_tast.setTasktype(mc00.getTasktype());
						commonService.insertMc21_task_fact3(mc00_tast, "JCSJ_" + mc00.getTasktype());
					}
					path = "redirect:/br40_city_no/list?isNewSearch=1";
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}
	
}
