package com.cy43.framework.commons.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"/","/index"})
	public String index(){
		return "jsp/login";
	}

}
