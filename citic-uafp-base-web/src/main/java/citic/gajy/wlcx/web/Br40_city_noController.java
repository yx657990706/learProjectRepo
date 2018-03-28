/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-08-24] 
* =============================================
*/

package citic.gajy.wlcx.web;

/**
* <p>Br40_city_noController.java</p>
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
import org.springframework.web.bind.annotation.RequestParam;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_city_no;
import citic.gajy.wlcx.service.Br40_city_noService;

@Controller
@RequestMapping("/br40_city_no")
public class Br40_city_noController extends AmlBaseController{
/**
	 * 
	 */
private static final long serialVersionUID = 4304351793682558440L;
private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br40_city_noService br40_city_noService;
/**
*
* @param model
*/
@RequestMapping(value="/list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr40_city_noList(Model model,HttpServletRequest request,Page page,Br40_city_no br40_city_no) throws Exception{
//
try {
/**从session中获取查询对象*/ 
String beginDate=br40_city_no.getLastts_start();
String endDate=br40_city_no.getLastts_end();
Br40_city_no searchObj = getSearchObject(br40_city_no, page, request); 
List<Br40_city_no> br40_city_noList = br40_city_noService.getBr40_city_noList(searchObj);
searchObj.setLastts_start(beginDate);
searchObj.setLastts_end(endDate);
model.addAttribute("br40_city_no",searchObj);
model.addAttribute("flagMap", getSelectMap("S00002"));
model.addAttribute("br40_city_noList", br40_city_noList);
model.addAttribute("br40_city_no", searchObj);
model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
 return("/errors/exception");
}

return("/gajy/resport/city_code_list");
}
/**
*
* @param model
*/
@RequestMapping(value="/add",method=RequestMethod.GET)
public String performAddBr40_city_no(Model model)  throws Exception{
Br40_city_no br40_city_no = new Br40_city_no();

model.addAttribute("organMap", getSelectMap("Dfhorgan"));
model.addAttribute("br40_city_no", br40_city_no);
//
return("/gajy/resport/city_code_add");
}
/**
*
* @param Br40_city_no
*/
@RequestMapping(value="/add",method=RequestMethod.POST)
public String performaddBr40_city_noDo(@ModelAttribute Br40_city_no br40_city_no,HttpServletRequest request)  throws Exception{
try {
  int count=br40_city_noService.getBr40_city_noCount(br40_city_no.getUniqueid());
  if(count<1){
	  int i = br40_city_noService.insertBr40_city_no(br40_city_no,request);
  }
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_city_no/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/modify",method=RequestMethod.GET)
public String performModifyBr40_city_no(@RequestParam String uniqueid,Model model)  throws Exception{
Br40_city_no br40_city_no = new Br40_city_no();
br40_city_no = br40_city_noService.getBr40_city_noDisp(uniqueid);
model.addAttribute("flagMap", getSelectMap("S00002"));
model.addAttribute("organMap", getSelectMap("Dfhorgan"));
model.addAttribute("br40_city_no", br40_city_no);
return("/gajy/resport/city_code_modify");
}
/**
*
* @param model
*/
@RequestMapping(value="/save_modify",method=RequestMethod.POST)
public String performModifyBr40_city_noDo(@ModelAttribute Br40_city_no br40_city_no,HttpServletRequest request)  throws Exception{
try {
	//获取当前用户
String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
br40_city_no.setLastts(DtUtils.getNowTime());
br40_city_no.setLastuser(loginname);
int i = br40_city_noService.modifyBr40_city_no(br40_city_no);
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}
return("redirect:/br40_city_no/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/delete",method=RequestMethod.POST)
public String performDeleteBr40_city_noDo(Model model,@PathVariable String uniqueid)  throws Exception{
try {
int i = br40_city_noService.deleteBr40_city_no(uniqueid);
}
catch (Exception e) {
	logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_city_no/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/disp",method=RequestMethod.GET)
public String performGetBr40_city_noDisp(Model model,String uniqueid)  throws Exception{
Br40_city_no br40_city_no = new Br40_city_no();
br40_city_no = br40_city_noService.getBr40_city_noDisp(uniqueid);

model.addAttribute("br40_city_no", br40_city_no);
return("/br40_city_no/disp");
}
}
