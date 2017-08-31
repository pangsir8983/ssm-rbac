package com.cy43.framework.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.cy43.framework.rbac.role.service.RoleService;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private RoleService roleService;

	@Override
	public boolean preHandle( HttpServletRequest request , HttpServletResponse response , Object handler )
			throws Exception {
		//1.这两个属性是固定不动的
		String pid = request.getParameter("pid");
		String rid = request.getParameter("rid");
		if(pid!=null&&rid!=null){
			HttpSession session = request.getSession();
			session.removeAttribute("role_menu_functions");
			session.setAttribute("role_menu_functions", this.roleService.getMenuFunctions(Integer.parseInt(rid), Integer.parseInt(pid)));
		}
		return true;
	}


}
