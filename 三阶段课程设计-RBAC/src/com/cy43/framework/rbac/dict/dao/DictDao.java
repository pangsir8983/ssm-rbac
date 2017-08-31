package com.cy43.framework.rbac.dict.dao;

import java.util.List;
import java.util.Map;
import com.cy43.framework.rbac.dict.model.Dict;

public interface DictDao {
	int delete(String id);

	int add(Dict dict);

	Dict load(String id);

	int update(Dict dict);

	List<Dict> list();

	List<String> getDictType();
	List<Map<String,String>> getValueLabelByType(String type);
}