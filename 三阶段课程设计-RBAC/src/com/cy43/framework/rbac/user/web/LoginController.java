package com.cy43.framework.rbac.user.web;

import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cy43.framework.commons.web.BaseController;
import com.cy43.framework.rbac.user.model.User;
import com.cy43.framework.rbac.user.service.UserService;
@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {
	protected Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login(){
		return "jsp/login";
	}
	@PostMapping("/login")
	public String login(String account,String password,RedirectAttributes ra){
		try {
			User user = this.userService.login(account, password);
			//获取客户端的IP地址和当前时间
			user.setIp(this.request.getRemoteAddr());
			user.setLogin_time(new Date());
			//更新用户信息
			this.userService.updateLogin(user);
			//保存到会话当中
			this.session.setAttribute("session_user", user);

			return "redirect:/sys/main";
		} catch (RuntimeException ex) {
			this.logger.debug(ex);//输出到日志框架
			ra.addFlashAttribute("message", ex.getMessage());
			return "redirect:/sys/login";
		}
	}
	@GetMapping("/logout")
	public String logout(){
		//手动销毁
		this.session.invalidate();
		return "redirect:/sys/login";
	}
}
