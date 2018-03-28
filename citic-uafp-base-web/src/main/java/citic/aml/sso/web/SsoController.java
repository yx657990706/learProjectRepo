/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年8月20日 下午9:02:37
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.CommonService;
import citic.aml.sso.service.SsoService;
import citic.aml.system.domain.Mp02_user;
import citic.aml.system.domain.OnlineUser;
import citic.aml.system.service.Mp02_userService1;
import citic.aml.system.service.UserService;
import citic.base.BaseController;
import citic.base.utils.DtUtils;
import citic.base.utils.MD5;

/**
 * @author gaojianxin
 *
 */
@Controller
public class SsoController extends BaseController {
	private static final long serialVersionUID = -4957085542452095159L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CommonService commonService;
	@Autowired
	private SsoService ssoService;
	@Autowired
	private Mp02_userService1 mp02_userService1;
	@Autowired
	private UserService userService;
	/**
	 * 通过单点登录系统登录
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cas_login", method = { RequestMethod.GET, RequestMethod.POST })
	public String logginUser(HttpServletRequest request, HttpSession session, Mp02_user mp02_user, Model model,
			BindingResult result) throws Exception {

		/*
		 * 1.以admin开头的用户，不用去和柜面系统交互，在系统内进行校验 2.其他用户，和柜面系统通讯，非A0001，A0002
		 * 时【即柜面校验通过】， 2.1判断他在本系统中是否存在，不存在，向库中插入一条记录，并提示用户找管理员分配权限，不让登录
		 * 2.2存在。正常登陆
		 */
		logger.debug("单点登录.....");
		String loginname = mp02_user.getLoginname().trim();
		boolean flag = false;// 登录成功标及处理流程标识
		String errMsg = "";// 登录错误信息
		if (StringUtils.isEmpty(loginname)) {// 输入为空白字符,登录失败.
			logger.debug("单点登录失败.....");
			return "/pub/login";
		}
		Mp02_user validUser = null;
		boolean isLocalUser = StringUtils.startsWith(loginname, "admin");//本地校验用户
		if (isLocalUser) {
			flag = true;
		} else {
			validUser = ssoService.trans(mp02_user);// 与网关通讯
			if ("A0001".equals(validUser.getMsgcode())) {
				errMsg = "需要修改密码！";
			} else if ("A0002".equals(validUser.getMsgcode())) {
				errMsg = "用户名或密码错误！";
			} else {
				flag = true;
			}
		}
		if (flag) {
			// 本地系统登录，登录前首先清空session，及缓存
			if (session.getAttribute("loginname") != null) {
				session.removeAttribute("loginname");
			}
			commonService.clearUserOrgan(loginname);
			commonService.clearUser(loginname);
			commonService.clearUserPost(loginname);
			Mp02_user dbUser = commonService.getMp02_userDisp(loginname);//正常状态的用户
			MD5 md = new MD5();
			String password = md.toDigest(mp02_user.getPassword());
			if(isLocalUser){
				if (!StringUtils.equalsIgnoreCase(dbUser.getLoginname(), loginname)) {
					errMsg = "用户不存在或者被禁用！";
					flag = false;
				}
				// 密码检查
				if (!password.equals(dbUser.getPassword())) {
					errMsg = "密码不正确！";
					flag = false;
				}
			}else{
				// 用户名检查
				if (!StringUtils.equalsIgnoreCase(dbUser.getLoginname(), loginname)) {
					Mp02_user dbUser2 = userService.getMp02_userDispByLoginName(loginname);//所有状态的用户
					if (!StringUtils.equalsIgnoreCase(dbUser2.getLoginname(), loginname)) {// 在本地系统同步用户
						validUser.setPassword(password);
						validUser.setLoginname(mp02_user.getLoginname());
						validUser.setFlag("0");// 禁用
						validUser.setIsbuildin("0");
						validUser.setLastts(DtUtils.getNowTime());// 最后修改时间
						userService.insertValidM002_user(validUser);
					}
					errMsg = "请联系管理员分配权限！";
					flag = false;
				}
			}
		}
		if (flag) {// 登录成功
			session.setAttribute("loginname", loginname);// 设置session
			// 设置登录用户信息
			OnlineUser onlineUser = new OnlineUser();
			onlineUser.setLoginname(loginname);
			onlineUser.setRealname(commonService.getMp02_userDisp(loginname).getRealname());
			onlineUser.setIp(request.getRemoteAddr());
			session.setAttribute("onlineUser", onlineUser);
			return "redirect:/index";
		} else {// 登录失败
			model.addAttribute("errorMsg", errMsg);
			mp02_user.setLoginname("");
			model.addAttribute("mp02_user", mp02_user);
			logger.debug("单点登录失败......");
			return "/pub/login";
		}
	}

	@RequestMapping(value = "/cas_loginOut", method = RequestMethod.GET)
	public String logginOut(HttpSession session) throws Exception {

		try {
			if (session.getAttribute("loginname") != null) {
				session.removeAttribute("loginname");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			session.invalidate();
		}

		return "redirect:/cas_login";
	}

}
