package com.cy43.framework.commons.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baidu.ueditor.ActionEnter;

@Controller
public class UEditorConfigController {
	@SuppressWarnings("static-method")
	@RequestMapping(value="/editorConfig")
	public void config(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try{
			request.setCharacterEncoding( "UTF-8" );
			response.setHeader("Content-Type" , "text/html");
			String rootPath = request.getServletContext().getRealPath( "/" );
			out = response.getWriter();
			out.write( new ActionEnter( request, rootPath ).exec() );
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("百度UEditor编辑初始化失败");
		}finally {
			if(out!=null){
				out.close();
			}
		}
	}
}
