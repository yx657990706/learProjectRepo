package citic.whpsb.wlcx.web;

/**
* <p>Br51_cxqqController.java</p>
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.whpsb.wlcx.domain.Br51_attach;
import citic.whpsb.wlcx.domain.Br51_cxqq;
import citic.whpsb.wlcx.service.Br51_cxqqService;

@Controller
@RequestMapping("/br51_cxqq")
public class Br51_cxqqController extends AmlBaseController{
/**
 * 
 */
private static final long serialVersionUID = 930710479688776701L;
private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br51_cxqqService br51_cxqqService;


/**
*  查询文书信息
* @param model
*/
@RequestMapping(value="/attach_list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqqAttachList(Model model,HttpServletRequest request,Page page,Br51_attach br51_attach) throws Exception{
try {
/**从session中获取查询对象*/ 
Br51_attach searchObj = getSearchObject(br51_attach, page, request); 
List<Br51_attach> br51_attachList = br51_cxqqService.getBr51_cxqqAttachList(searchObj);

model.addAttribute("br51_attachList", br51_attachList);
model.addAttribute("br51_cxqq", searchObj);
model.addAttribute("pageInfoStr", getPageInfoStr(page));
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}
return("/whpsb/cxqq/request_attach_list");
}


/**
*  查询请求信息
* @param model
*/
@RequestMapping(value="/list",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr51_cxqqList(Model model, HttpServletRequest request, Page page, Br51_cxqq br51_cxqq) throws Exception {
		try {
			//判断是否第一次查询
			if (br51_cxqq.getIsFirst().equals("1")) {
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1,-30);		
				br51_cxqq.setQrydt_start(start_dt);
				br51_cxqq.setQrydt_end(end_dt);
				br51_cxqq.setStatus("4");
			}
			//获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br51_cxqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			Br51_cxqq searchObj = getSearchObject(br51_cxqq, page, request);
			List<Br51_cxqq> br51_cxqqList = br51_cxqqService.getBr51_cxqqList(searchObj);
			
			model.addAttribute("party_class_cdMap", getSelectMap("G00006"));
			model.addAttribute("qrymodeMap", getSelectMap("G00024"));
			model.addAttribute("statusMap", getSelectMap("G00022"));
			model.addAttribute("br51_cxqqList", br51_cxqqList);
			model.addAttribute("br51_cxqq", searchObj);
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
 * @param br51_cxqq
 * @return
 * @throws Exception
 * 
 * @date 2016年9月2日 上午10:45:00
 */
@RequestMapping(value="/request_main",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr51_cxqqMain(Model model,Br51_cxqq br51_cxqq) throws Exception{
try {
/**从session中获取查询对象*/ 
model.addAttribute("br51_cxqq",br51_cxqq);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}
return("/whpsb/cxqq/request_main");
}

/**
*
* @param model
*/
@RequestMapping(value="/add",method=RequestMethod.GET)
@Token(setToken = true)
public String performAddBr51_cxqq(Model model)  throws Exception{
//
Br51_cxqq br51_cxqq = new Br51_cxqq();

model.addAttribute("br51_cxqq", br51_cxqq);
//
return("/br51_cxqq/add");
}
/**
*
* @param Br51_cxqq
*/
@RequestMapping(value="/add",method=RequestMethod.POST)
@Token(checkToken = true)
public String performaddBr51_cxqqDo(@ModelAttribute Br51_cxqq br51_cxqq)  throws Exception{
//
try {
int i = br51_cxqqService.insertBr51_cxqq(br51_cxqq);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br51_cxqq/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{msgseq}/modify",method=RequestMethod.GET)
public String performModifyBr51_cxqq(@PathVariable String msgseq,Model model)  throws Exception{
//
Br51_cxqq br51_cxqq = new Br51_cxqq();
br51_cxqq = br51_cxqqService.getBr51_cxqqDisp(msgseq);

model.addAttribute("br51_cxqq", br51_cxqq);
//
return("/br51_cxqq/modify");
}
/**
*
* @param model
*/
@RequestMapping(value="/{msgseq}/modify",method=RequestMethod.POST)
public String performModifyBr51_cxqqDo(@ModelAttribute Br51_cxqq br51_cxqq)  throws Exception{
//
try {
int i = br51_cxqqService.modifyBr51_cxqq(br51_cxqq);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("/redirect:br51_cxqq/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{msgseq}/delete",method=RequestMethod.POST)
public String performDeleteBr51_cxqqDo(Model model,String msgseq)  throws Exception{
//
try {
int i = br51_cxqqService.deleteBr51_cxqq(msgseq);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br51_cxqq/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/request_disp",method=RequestMethod.GET)
public String performGetBr51_cxqqDisp(Model model,String msgseq)  throws Exception{
//
Br51_cxqq br51_cxqq = new Br51_cxqq();
br51_cxqq = br51_cxqqService.getBr51_cxqqDisp(msgseq);

model.addAttribute("br51_cxqq", br51_cxqq);
//
return("/whpsb/cxqq/request_disp");
}
}
