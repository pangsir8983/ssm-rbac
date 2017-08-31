package com.cy43.framework.rbac.dict.service;

import java.util.List;
import java.util.Map;
import com.cy43.framework.rbac.dict.model.Dict;

public interface DictService {
	List<Dict> list();
	List<String> getDictType();
	List<Map<String,String>> getValueLabelByType(String type);
}
