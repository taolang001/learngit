package com.curise.itshop.auth.dao;


import com.curise.itshop.common.entity.Role;

import java.util.List;

/**
 * 〈角色Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
public interface RoleDao {

    /**
     * 根据用户id查找角色列表
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> findByUserId(Integer userId);
}
