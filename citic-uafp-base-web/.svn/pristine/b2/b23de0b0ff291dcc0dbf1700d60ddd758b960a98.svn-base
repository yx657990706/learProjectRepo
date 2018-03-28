package citic.whpsb.wlcx.web;

/**
* <p>Br51_cxqq_backController.java</p>
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

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.whpsb.wlcx.domain.Br51_cxqq_back;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_acct;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_card;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_msg;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_party;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_trans;
import citic.whpsb.wlcx.service.Br51_cxqq_backService;

@Controller
@RequestMapping("/br51_cxqq_back")
public class Br51_cxqq_backController extends AmlBaseController{
/**
	 * 
	 */
	private static final long serialVersionUID = 1666761519866835473L;
private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br51_cxqq_backService br51_cxqq_backService;
/**
*  查询反馈信息
* @param model
*/
@RequestMapping(value="/response_list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqq_backList(Model model,HttpServletRequest request,Page page,Br51_cxqq_back br51_cxqq_back) throws Exception{
try {
//判断是否第一次查询
if (br51_cxqq_back.getIsFirst().equals("1")) {
String end_dt = DtUtils.getNowDate();
String start_dt = DtUtils.add(end_dt, 1,-30);		
br51_cxqq_back.setQrydt_start(start_dt);
br51_cxqq_back.setQrydt_end(end_dt);
br51_cxqq_back.setCljg("0");//默认先查询成功的
}
			
String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
String organstr = commonService.getMp02_OrganList(loginname);
br51_cxqq_back.setOrgkey_disp(organstr.trim());	
/**从session中获取查询对象*/ 
Br51_cxqq_back searchObj = getSearchObject(br51_cxqq_back, page, request); 
List<Br51_cxqq_back> br51_cxqq_backList = br51_cxqq_backService.getBr51_cxqq_backList(searchObj);
model.addAttribute("party_class_cdMap", getSelectMap("G00023"));
model.addAttribute("qrymodeMap", getSelectMap("G00024"));
model.addAttribute("cljgMap", getSelectMap("G00025"));
model.addAttribute("statusMap", getSelectMap("G00029"));
model.addAttribute("br51_cxqq_backList", br51_cxqq_backList);
model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
model.addAttribute("br51_cxqq_back",searchObj);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}

return("/whpsb/cxqqfk/response_list");
}

/**
*查询反馈文件
*
* @param model
*/
@RequestMapping(value="/response_ws_list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqq_back_msgList(Model model,HttpServletRequest request,Page page,Br51_cxqq_back_msg br51_cxqq_back_msg) throws Exception{
//
try {
/**从session中获取查询对象*/ 
String beginDate= br51_cxqq_back_msg.getCreate_dt_start();
String endDate= br51_cxqq_back_msg.getCreate_dt_end();
Br51_cxqq_back_msg searchObj = getSearchObject( br51_cxqq_back_msg, page, request); 
List<Br51_cxqq_back_msg> br51_cxqq_back_msgList = br51_cxqq_backService.getBr51_cxqq_back_msgList(searchObj);
searchObj.setCreate_dt_start(beginDate);
searchObj.setCreate_dt_end(endDate);
model.addAttribute("statusMap", getSelectMap("G00027"));
model.addAttribute("br51_cxqq_back_msgList", br51_cxqq_back_msgList);
model.addAttribute("pageInfoStr", getPageInfoStr(page));
model.addAttribute("br51_cxqq_back_msg",searchObj);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}

return("/whpsb/cxqqfk/response_ws_list");
}

@RequestMapping(value="/response_main",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqqMain(Model model,Br51_cxqq_back br51_cxqq_back) throws Exception{
try {
/**从session中获取查询对象*/ 
model.addAttribute("br51_cxqq_back",br51_cxqq_back);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}
return("whpsb/cxqqfk/response_main");
}
/**
 * 查询反馈信息主表
 * @param model
 * @param request
 * @param page
 * @param br51_cxqq_mx
 * @return
 * @throws Exception
 * 
 * @date 2016年9月3日 下午1:16:39
 */
@RequestMapping(value="/main_list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqq_backMainList(Model model,HttpServletRequest request,Page page,Br51_cxqq_back br51_cxqq_back) throws Exception{
	String path="";
	String title="";
try {
	String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
	String organstr = commonService.getMp02_OrganList(loginname);
	br51_cxqq_back.setOrgkey_disp(organstr.trim());
	/**  I:对私 C:对公 
	 * 
	 *个人账号信息查询请求文件（grzhxxcx，xml格式）
	 *单位账号信息查询请求文件（dwzhxxcx，xml格式）
	 *个人开户资料查询请求文件（grkhzlcx，xml格式）
	 * 单位开户资料查询请求文件（dwkhzlcx，xml格式）
	 * 个人账（卡）号交易明细查询请求文件（grjymxcx，xml格式）
	 *单位账（卡）号交易明细查询请求文件（dwjymxcx，xml格式）
	 * 个人账户持有人资料查询请求文件（grzhcyrcx，xml格式）
	 * 单位账户持有人资料查询请求文件（dwzhcyrcx，xml格式）
	 */
/**从session中获取查询对象*/ 
	
	if(br51_cxqq_back.getBdhm()!=null && !"".equals(br51_cxqq_back.getBdhm())){
	String bdhm=br51_cxqq_back.getBdhm();
if(br51_cxqq_back.getQrymode().equalsIgnoreCase("grzhxx") || br51_cxqq_back.getQrymode().equalsIgnoreCase("dwzhxx")){// 单位个人 账户信息查询 开户资料查询
	Br51_cxqq_back searchObj = getSearchObject(br51_cxqq_back, page, request); 
	List<Br51_cxqq_back_acct> br51_cxqq_back_acctList = br51_cxqq_backService.getBr51_cxqq_back_acctList(searchObj);
	model.addAttribute("br51_cxqq_back_acctList", br51_cxqq_back_acctList);
	title="账户反馈信息查询";
	path="/whpsb/cxqqfk/response_zhxxcx_list";
	
}else if( br51_cxqq_back.getQrymode().equalsIgnoreCase("grkhzl")&& br51_cxqq_back.getParty_class_cd().equalsIgnoreCase("I") ){// 单位个人 开户资料查询
	Br51_cxqq_back_party br51_cxqq_back_party = br51_cxqq_backService.getBr51_cxqq_back_partyDisp(bdhm);
	
	model.addAttribute("br51_cxqq_back_party", br51_cxqq_back_party);
	title="个人开户资料反馈信息查询";
	path="/whpsb/cxqqfk/response_grkhzlcx_disp";
}else if(br51_cxqq_back.getQrymode().equalsIgnoreCase("dwkhzl") && br51_cxqq_back.getParty_class_cd().equalsIgnoreCase("C") ){
	Br51_cxqq_back_party br51_cxqq_back_party = br51_cxqq_backService.getBr51_cxqq_back_partyDisp(bdhm);
	
	model.addAttribute("br51_cxqq_back_party", br51_cxqq_back_party);
	title="单位开户资料反馈信息查询";
	path="/whpsb/cxqqfk/response_dwkhzlcx_disp";
}else if (br51_cxqq_back.getQrymode().equalsIgnoreCase("grzhcyr") || br51_cxqq_back.getQrymode().equalsIgnoreCase("dwzhcyr") ){//单位个人  持有人资料查询 
	Br51_cxqq_back_card br51_cxqq_back_card=br51_cxqq_backService.getBr51_cxqq_back_cardDisp(bdhm);
	model.addAttribute("br51_cxqq_back_card", br51_cxqq_back_card);
	title="持有人资料反馈信息查询";
	path="/whpsb/cxqqfk/response_zhcyrcx_disp";
}else if( br51_cxqq_back.getQrymode().equalsIgnoreCase("grjymx") || br51_cxqq_back.getQrymode().equalsIgnoreCase("dwjymx")){// 单位个人 交易明细查询
	Br51_cxqq_back searchObj = getSearchObject(br51_cxqq_back, page, request); 
	List<Br51_cxqq_back_trans> br51_cxqq_back_transList=br51_cxqq_backService.getBr51_cxqq_back_transList(searchObj);
	model.addAttribute("br51_cxqq_back_transList", br51_cxqq_back_transList);
	title="交易明细反馈信息查询";
	path="/whpsb/cxqqfk/response_jymxcx_list";
}
model.addAttribute("cljgMap", getSelectMap("G00025"));
model.addAttribute("debit_creditMap", getSelectMap("G00008"));
model.addAttribute("zhztMap", getSelectMap("G00026"));
model.addAttribute("title",title);
model.addAttribute("pageInfoStr", getPageInfoStr(page));
model.addAttribute("br51_cxqq_back",br51_cxqq_back);
	}
}catch (Exception e) {
  logger.error(e.getMessage(),e);
 return("/errors/exception");
}
return(path);
}


/**
*
* @param model
*/
@RequestMapping(value="/{ah}/disp",method=RequestMethod.GET)
public String performGetBr51_cxqq_backDisp(Model model,String ah)  throws Exception{
//
Br51_cxqq_back br51_cxqq_back = new Br51_cxqq_back();
br51_cxqq_back = br51_cxqq_backService.getBr51_cxqq_backDisp(ah);

model.addAttribute("br51_cxqq_back", br51_cxqq_back);
//
return("/br51_cxqq_back/disp");
}
}
