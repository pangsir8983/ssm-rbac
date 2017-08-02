package com.cy43.framework.commons.web;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.cy43.framework.commons.util.DateHelper;

public class BaseController {

	protected Logger logger = Logger.getLogger(BaseController.class);

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
	@Autowired
	protected ServletContext application;

	@SuppressWarnings("static-method")
	@InitBinder
	public void date(WebDataBinder dataBinder){
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
			@Override
			public void setAsText( String text ) throws IllegalArgumentException {
				System.out.println(text);
				this.setValue(DateHelper.parseDate(text));
			}
		});
	}

}
