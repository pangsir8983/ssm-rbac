package com.cy43.framework.commons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cy43.framework.cms.content.service.ContentService;
import com.cy43.framework.rbac.menu.service.MenuService;
import com.cy43.framework.rbac.user.model.User;

@Controller
@RequestMapping("/sys")
public class MainController extends BaseController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private ContentService contentService;

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

	@GetMapping("/content")
	public String content(Model model){

		model.addAttribute("teacherContentList", this.contentService.listNewContent(1));
		model.addAttribute("peixunContentList", this.contentService.listNewContent(2));
		model.addAttribute("studentContentList", this.contentService.listNewContent(3));
		model.addAttribute("classContentList", this.contentService.listNewContent(4));
		model.addAttribute("baomingContentList", this.contentService.listNewContent(5));


		return "jsp/content";
	}

}
