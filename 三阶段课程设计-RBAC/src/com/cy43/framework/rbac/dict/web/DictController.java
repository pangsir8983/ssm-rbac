package com.cy43.framework.rbac.dict.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cy43.framework.rbac.dict.service.DictService;
import com.cy43.framework.rbac.role.service.RoleService;

@Controller
@RequestMapping("/sys/dict")
public class DictController {

	@Autowired
	private DictService dictService;
	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public String list(Model model,int pid,int rid){
		model.addAttribute("dictList", this.dictService.list());

		//通过该值获取起对应的功能列表
		model.addAttribute("role_menu_functions", this.roleService.getMenuFunctions(rid, pid));
		model.addAttribute("pid", pid);
		model.addAttribute("rid", rid);

		return "jsp/dict/list";
	}
}
