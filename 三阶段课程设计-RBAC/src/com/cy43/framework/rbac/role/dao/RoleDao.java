/**
 * RoleDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:34:31
 **/
package com.cy43.framework.rbac.role.dao;

import com.cy43.framework.rbac.role.model.Role;

public interface RoleDao {
    /**
     * sys_role
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-08-01 09:34:31
     * 
     **/
    int delete(Integer role_id);

    /**
     * sys_role
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-08-01 09:34:31
     * 
     **/
    int add(Role role);

    /**
     * sys_role
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-08-01 09:34:31
     * 
     **/
    Role load(Integer role_id);

    /**
     * sys_role
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2017-08-01 09:34:31
     * 
     **/
    int update(Role role);
}