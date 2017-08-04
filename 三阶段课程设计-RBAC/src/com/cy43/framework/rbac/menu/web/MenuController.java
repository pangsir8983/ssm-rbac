package com.cy43.framework.rbac.menu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.commons.web.BaseController;
import com.cy43.framework.rbac.menu.model.Menu;
import com.cy43.framework.rbac.menu.service.MenuService;

@Controller
@RequestMapping("/sys/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("treeNodeList", this.menuService.getTreeNode());
		return "jsp/menu/index";
	}

	@GetMapping("/add")
	public String add(String type,Model model){
		if("child".equals(type)){
			//1.查询父节点信息
			model.addAttribute("parentNodeList", this.menuService.getParentNodeList());
		}
		model.addAttribute("type", type);
		return "jsp/menu/add";
	}

	@PostMapping("/add")
	@ResponseBody
	public void add(Menu menu) throws IOException{
		this.response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = this.response.getWriter();
		try {
			this.menuService.add(menu);
			out.write("<script>alert('新建节点成功');window.parent.location.reload();</script>");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			out.write("<script>alert('"+ex.getMessage()+"');</script>");
		}

		out.flush();
		out.close();
	}

	@GetMapping("/show")
	public String show(Integer id,String type,Model model){
		if("child".equals(type)){
			//1.查询父节点信息
			model.addAttribute("parentNodeList", this.menuService.getParentNodeList());
		}
		model.addAttribute("type", type);
		model.addAttribute("menu", this.menuService.load(id));

		return "jsp/menu/show";
	}
	@PutMapping("/update")
	@ResponseBody
	public void update(Menu menu) throws IOException{
		this.response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = this.response.getWriter();
		try {
			this.menuService.update(menu);
			out.write("<script>alert('修改节点成功');window.parent.location.reload();</script>");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			out.write("<script>alert('"+ex.getMessage()+"');</script>");
		}

		out.flush();
		out.close();
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public Map<String,String> delete(String type,int menu_id){

		Map<String, String> map = new HashMap<String, String>();
		try {
			this.menuService.delete(type, menu_id);
			map.put("flag", "success");
			map.put("message", "删除节点信息成功");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			map.put("message", ex.getMessage());
		}
		return map;
	}


}
