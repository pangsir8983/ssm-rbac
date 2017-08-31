package com.cy43.framework.cms.content.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cy43.framework.cms.content.model.Content;
import com.cy43.framework.commons.model.Pager;

public interface ContentDao {
	int delete(Integer cms_id);
	int add(Content content);
	Content load(Integer cms_id);
	int update(Content content);

	List<Content> list(@Param("pager") Pager pager,@Param("type") int type);
	int getTotalCount(@Param("pager") Pager pager,@Param("type") int type);

	List<Content> listNewContent(int type_id);

	List<Map<String,Object>> getChartContentType();
}