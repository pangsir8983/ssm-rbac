package com.cy43.framework.rbac.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.rbac.user.service.UserService;

@Controller
@RequestMapping("/sys/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/find")
	public String find(Pager pager,Model model){
		model.addAttribute("pager", this.userService.find(pager));
		return "jsp/user/find";
	}
}
