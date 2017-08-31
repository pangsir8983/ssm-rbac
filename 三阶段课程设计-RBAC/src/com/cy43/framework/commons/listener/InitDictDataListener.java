package com.cy43.framework.commons.listener;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.cy43.framework.rbac.dict.service.DictService;

public class InitDictDataListener implements ServletContextListener {


	@Override
	public void contextInitialized( ServletContextEvent sce ) {
		System.out.println("==============***开始***初始化数据=====================");
		ServletContext application  = sce.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
		//1.获取DictService接口的实现类
		DictService dictService = wac.getBean("dictServiceImpl", DictService.class);
		List<String> dictTypeList = dictService.getDictType();
		if(dictTypeList!=null){
			for(String type : dictTypeList){
				application.setAttribute(type, dictService.getValueLabelByType(type));
			}
		}

		System.out.println("==============***结束***初始化数据=====================");

	}


	@Override
	public void contextDestroyed( ServletContextEvent arg0 ) {
		// TODO Auto-generated method stub

	}

}
