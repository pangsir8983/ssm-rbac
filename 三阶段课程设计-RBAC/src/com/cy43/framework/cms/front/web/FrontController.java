package com.cy43.framework.cms.front.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cy43.framework.cms.content.service.ContentService;

@Controller
public class FrontController {

	@Autowired
	private ContentService contentService;

	@GetMapping({"front/index"})
	public String index(Model model){
		model.addAttribute("bannerList", this.contentService.listNewContent(6));
		return "front/index";

	}
}
