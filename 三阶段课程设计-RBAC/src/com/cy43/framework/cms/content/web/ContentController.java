package com.cy43.framework.cms.content.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cy43.framework.cms.content.model.Content;
import com.cy43.framework.cms.content.service.ContentService;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.commons.web.BaseController;

@Controller
@RequestMapping("/sys/content")
public class ContentController extends BaseController {

	@Autowired
	private ContentService contentService;

	@GetMapping("/{type}/find")
	public String find(Pager pager,@PathVariable int type,Model model){

		model.addAttribute("type", type);
		model.addAttribute("pager", this.contentService.find(pager, type));

		return "jsp/content/find";
	}

	@GetMapping("/add")
	public String add(int type_id,Model model){
		model.addAttribute("type", type_id);
		return "jsp/content/add";//该页面不加入任何样式
	}
	@PostMapping("/add")
	public String add(Content content,MultipartFile myfile , Model model) throws IllegalStateException, IOException{
		try {
			//1.获取服务端的绝对路径
			String path = this.request.getServletContext().getRealPath("/attr/content/");
			//2.建立联系并且判断该文件夹
			File folder = new File(path);
			if(!folder.exists()){
				folder.mkdirs();
			}
			String fileName = myfile.getOriginalFilename();
			if(!fileName.isEmpty()){
				//3.获取文件的后缀名称
				String ext = FilenameUtils.getExtension(fileName);
				//4.新的文件名称,需要保存到对象当中,存储到数据库当中
				String newFileName = new Date().getTime()+"_"+new Random().nextInt(10000)+"."+ext;
				//5.文件上传
				myfile.transferTo(new File(path+File.separator+newFileName));
				//6.保存新的文件名称
				content.setPhoto(newFileName);
			}

			this.contentService.add(content);
			model.addAttribute("message", "发布内容成功");
		} catch (ServiceException ex) {
			ex.printStackTrace();
			model.addAttribute("message", ex.getMessage());
		}
		return "jsp/message";
	}
	@GetMapping("/chart")
	@ResponseBody
	public List<Map<String,Object>> getChartContentType(){
		return this.contentService.getChartContentType();
	}

}
