package com.cy43.framework.cms.content.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.cms.content.dao.ContentDao;
import com.cy43.framework.cms.content.model.Content;
import com.cy43.framework.cms.content.service.ContentService;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.commons.model.Pager;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDao contentDao;

	@Override
	public Pager find( Pager pager , int type ) {
		pager.setDatas(this.contentDao.list(pager, type));
		pager.setTotalCount(this.contentDao.getTotalCount(pager, type));
		return pager;
	}

	@Override
	public void add( Content content ) {
		try {
			this.contentDao.add(content);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("发布内容失败");
		}
	}

	@Override
	public List<Content> listNewContent( int type_id ) {
		return this.contentDao.listNewContent(type_id);
	}

	@Override
	public List<Map<String, Object>> getChartContentType() {
		return this.contentDao.getChartContentType();
	}

}
