package com.cy43.framework.rbac.user.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.commons.web.BaseController;
import com.cy43.framework.rbac.role.service.RoleService;
import com.cy43.framework.rbac.user.model.User;
import com.cy43.framework.rbac.user.service.UserService;

@Controller
@RequestMapping("/sys/user")
@SuppressWarnings("static-method")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@GetMapping("/find")
	public String find(Pager pager,Model model){
		model.addAttribute("pager", this.userService.find(pager));
		return "jsp/user/find";
	}


	@GetMapping("/password")
	public String password(){
		return "jsp/password";
	}
	@PostMapping("/password")
	public String password(String password,Model model){
		try {
			User user = (User) this.session.getAttribute("session_user");
			this.userService.updatePassword(password,user.getUser_id());
			model.addAttribute("message", "下次登录请使用新密码");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}

	@PostMapping("/password/valid")
	@ResponseBody
	public Map<String,String> validPassword(String old_password){

		Map<String, String> map = new HashMap<String, String>();

		try {
			User user = (User) this.session.getAttribute("session_user");
			this.userService.validPassword(user.getUser_id(), old_password);
			map.put("flag", "success");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			map.put("message", ex.getMessage());
		}

		return map;
	}

	//跳转到添加页面
	@GetMapping("/add")
	public String add(){
		return "jsp/user/add";
	}
	//表单处理数据,保存到数据库当中
	@PostMapping("/add")
	public String add(User user,Model model){
		try {
			this.userService.add(user);
			model.addAttribute("message", "新建系统用户成功");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}
	@GetMapping("/update/{user_id}")//占位符传递数据
	public String update(@PathVariable("user_id") int user_id,Model model){
		model.addAttribute("user", this.userService.load(user_id));
		return "jsp/user/update";
	}
	@PutMapping("/update")
	public String update(User user,Model model){
		try {
			this.userService.update(user);
			model.addAttribute("message", "更新系统用户成功");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}

	@DeleteMapping("/delete/{user_id}")
	@ResponseBody
	public Map<String,String> deleteUser(@PathVariable int user_id){
		Map<String, String> map = new HashMap<String, String>();
		try {
			this.userService.deleteUser(user_id);
			map.put("flag","success");//{"flag":"success"}
		} catch (ServiceException ex) {
			map.put("message",ex.getMessage());//{"message":""}
		}
		return map;
	}



	@GetMapping("/validAccount")
	@ResponseBody
	public Map<String,String> validAccount(String account){

		Map<String, String> map = new HashMap<String, String>();
		try {
			this.userService.validAccount(account);
			map.put("flag","success");//{"flag":"success"}
		} catch (ServiceException ex) {
			map.put("message",ex.getMessage());//{"message":""}
		}
		return map;
	}

	@GetMapping("/role")
	public String updateUserRole(int user_id,Model model){
		//1.获取该用户的信息
		model.addAttribute("user", this.userService.load(user_id));
		//2.获取角色可用列表
		model.addAttribute("roleList", this.roleService.getEnabledRoleList());
		return "jsp/user/role";
	}
	@PatchMapping("/role")
	public String updateUserRole(int user_id,int fk_role_id,Model model){
		try {
			this.userService.updateUserRole(user_id, fk_role_id);
			model.addAttribute("message", "分配角色成功");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}

	@GetMapping("/photo")
	public String updatePhoto(int user_id,Model model){
		model.addAttribute("user", this.userService.load(user_id));
		return "jsp/user/photo";
	}
	@PostMapping("/photo")
	public String updatePhoto(int user_id,MultipartFile myfile,Model model) throws IllegalStateException, IOException{
		try {
			//1.获取上传文件的名称
			String fileName = myfile.getOriginalFilename();
			//2.判断文件名称是否存在
			if(!fileName.isEmpty()) {
				//3.获取上传服务器的绝对路径
				String path = this.request.getServletContext().getRealPath("/attr/user/");
				//4.建立联系
				File folder = new File(path);
				//5.判断该文件是否存在,不存在则创建文件夹
				if(!folder.exists()){
					folder.mkdirs();
				}
				//6.获取文件名称的后缀名
				String ext = FilenameUtils.getExtension(fileName);
				//7.创建上传文件的新的名称,保证名称不重复
				//String newFileName = UUID.randomUUID().toString()+"."+ext;
				String newFileName = new Date().getTime()+"_"+new Random().nextInt(100000)+"."+ext;
				//8.完成上传
				myfile.transferTo(new File(path+File.separator+newFileName));
				//9.调用更新头像信息
				this.userService.updateUserPhoto(user_id, newFileName);
			}
			model.addAttribute("message", "上传头像成功");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}
}
