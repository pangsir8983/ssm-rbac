package com.cy43.framework.cms.content.service;

import java.util.List;
import java.util.Map;
import com.cy43.framework.cms.content.model.Content;
import com.cy43.framework.commons.model.Pager;

public interface ContentService {

	Pager find(Pager pager,int type);

	void add(Content content);

	List<Content> listNewContent(int type_id);
	List<Map<String,Object>> getChartContentType();
}
