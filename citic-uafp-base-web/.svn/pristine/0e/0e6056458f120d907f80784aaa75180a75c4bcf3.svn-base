package citic.gajy.wlcx.web;

/**
* <p>Br40_branch_regController.java</p>
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

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.service.Br40_branch_regService;
import citic.gajy.wlcx.domain.Br40_branch_reg;

@Controller
@RequestMapping("/br40_branch_reg")
public class Br40_branch_regController extends AmlBaseController{
/**
	 * 
	 */
	private static final long serialVersionUID = -5361702940713888476L;
private Logger  logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private Br40_branch_regService br40_branch_regService;
/**
*
* @param model
*/
@RequestMapping(value="/list",method = { RequestMethod.GET, RequestMethod.POST })
public String performGetBr40_branch_regList(Model model,HttpServletRequest request,Page page,Br40_branch_reg br40_branch_reg) throws Exception{
  String beginDate=br40_branch_reg.getLastts_start();
  String endDate=br40_branch_reg.getLastts_end();
try {
/**从session中获取查询对象*/ 
Br40_branch_reg searchObj = getSearchObject(br40_branch_reg, page, request); 
List<Br40_branch_reg> br40_branch_regList = br40_branch_regService.getBr40_branch_regList(searchObj);
searchObj.setLastts_start(beginDate);
searchObj.setLastts_end(endDate);
model.addAttribute("outletstypeMap", getSelectMap("G00018"));
model.addAttribute("br40_branch_regList", br40_branch_regList);
model.addAttribute("pageInfoStr", getPageInfoStr(page));}
catch (Exception e) {
logger.error(e.getMessage(),e);
 return("/errors/exception");
}
return("gajy/resport/branch_list");
}
/**
*
* @param model
*/
@RequestMapping(value="/add",method=RequestMethod.GET)
@Token(setToken = true)
public String performAddBr40_branch_reg(Model model)  throws Exception{
//
Br40_branch_reg br40_branch_reg = new Br40_branch_reg();

model.addAttribute("br40_branch_reg", br40_branch_reg);
//
return("/br40_branch_reg/add");
}
/**
*
* @param Br40_branch_reg
*/
@RequestMapping(value="/add",method=RequestMethod.POST)
@Token(checkToken = true)
public String performaddBr40_branch_regDo(@ModelAttribute Br40_branch_reg br40_branch_reg)  throws Exception{
//
try {
int i = br40_branch_regService.insertBr40_branch_reg(br40_branch_reg);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_branch_reg/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/modify",method=RequestMethod.GET)
public String performModifyBr40_branch_reg(@PathVariable String uniqueid,Model model)  throws Exception{
//
Br40_branch_reg br40_branch_reg = new Br40_branch_reg();
br40_branch_reg = br40_branch_regService.getBr40_branch_regDisp(uniqueid);

model.addAttribute("br40_branch_reg", br40_branch_reg);
//
return("/br40_branch_reg/modify");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/modify",method=RequestMethod.POST)
public String performModifyBr40_branch_regDo(@ModelAttribute Br40_branch_reg br40_branch_reg)  throws Exception{
//
try {
int i = br40_branch_regService.modifyBr40_branch_reg(br40_branch_reg);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("/redirect:br40_branch_reg/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/delete",method=RequestMethod.POST)
public String performDeleteBr40_branch_regDo(Model model,String uniqueid)  throws Exception{
//
try {
int i = br40_branch_regService.deleteBr40_branch_reg(uniqueid);
}
catch (Exception e) {
logger.error(e.getMessage(),e);
return("/errors/exception");
}

return("redirect:/br40_branch_reg/list");
}
/**
*
* @param model
*/
@RequestMapping(value="/{uniqueid}/disp",method=RequestMethod.GET)
public String performGetBr40_branch_regDisp(Model model,String uniqueid)  throws Exception{
//
Br40_branch_reg br40_branch_reg = new Br40_branch_reg();
br40_branch_reg = br40_branch_regService.getBr40_branch_regDisp(uniqueid);

model.addAttribute("br40_branch_reg", br40_branch_reg);
//
return("/br40_branch_reg/disp");
}
}
