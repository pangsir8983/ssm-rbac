package com.cy43.framework.commons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cy43.framework.rbac.menu.service.MenuService;
import com.cy43.framework.rbac.user.model.User;

@Controller
@RequestMapping("/sys")
public class MainController extends BaseController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/main")
	public String main(Model model){
		//获取登录的用户信息
		User user = (User) this.session.getAttribute("session_user");
		Integer role_id = user.getFk_role_id();
		if(role_id!=null){
			model.addAttribute("childMenus", this.menuService.getChildMenusByRoleId(role_id));
			model.addAttribute("parentMenus", this.menuService.getParentMenusByRoleId(role_id));
		}
		return "jsp/main";
	}

}
