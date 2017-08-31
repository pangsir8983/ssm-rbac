package com.cy43.framework.rbac.dict.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.rbac.dict.dao.DictDao;
import com.cy43.framework.rbac.dict.model.Dict;
import com.cy43.framework.rbac.dict.service.DictService;
@Service
public class DictServiceImpl implements DictService {
	@Autowired
	private DictDao dictDao;

	@Override
	public List<Dict> list() {
		return this.dictDao.list();
	}

	@Override
	public List<String> getDictType() {
		return this.dictDao.getDictType();
	}

	@Override
	public List<Map<String, String>> getValueLabelByType( String type ) {
		return this.dictDao.getValueLabelByType(type);
	}

}
