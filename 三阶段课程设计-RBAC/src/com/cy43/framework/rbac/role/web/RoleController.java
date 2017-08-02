package com.cy43.framework.rbac.role.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.rbac.role.model.Role;
import com.cy43.framework.rbac.role.service.RoleService;

@Controller
@RequestMapping("/sys/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("roleList", this.roleService.list());
		return "jsp/role/list";
	}

	@GetMapping("/add")
	public String add(){
		return "jsp/role/add";
	}
	@PostMapping("/add")
	public String add(Role role , Model model){
		try {
			this.roleService.add(role);
			model.addAttribute("message", "新建角色成功!");
		} catch (ServiceException ex) {
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}

	@GetMapping("/update/{role_id}")
	public String update(@PathVariable("role_id") int role_id,Model model){
		model.addAttribute("role", this.roleService.load(role_id));
		return "jsp/role/update";
	}

	@PutMapping("/update")
	public String update(Role role , Model model){
		try {
			this.roleService.update(role);
			model.addAttribute("message", "维护角色成功!");
		} catch (ServiceException ex) {
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}




	@GetMapping("/validRoleKey")
	@ResponseBody
	public Map<String,String> valid(String role_key){

		Map<String, String> map = new HashMap<String, String>();
		try {
			this.roleService.validRoleKey(role_key);
			map.put("flag", "success");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			map.put("message", ex.getMessage());
		}

		return map;
	}

}
