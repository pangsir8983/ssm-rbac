package com.cy43.framework.rbac.function.dao;

import com.cy43.framework.rbac.function.model.Function;
/**
 *
 * @author 胖先森
 *
 */
public interface FunctionDao {
	/**
	 * 方法描述:通过主键删除记录
	 * @param function_id
	 * @return
	 */
	int delete(Integer function_id);

	/**
	 * 方法描述: 新建功能信息
	 * @param function
	 * @return
	 */
	int add(Function function);

	/**
	 * 方法描述:通过主键获取记录
	 * @param function_id
	 * @return
	 */
	Function load(Integer function_id);

	/**
	 * 方法描述:更新功能记录
	 * @param function
	 * @return
	 */
	int update(Function function);
}