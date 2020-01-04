package com.curise.itshop.auth.dao;


import com.curise.itshop.common.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 〈用户Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
public interface UserDao {

    /**
     * 根据会员名查找用户
     * @param userName 用户名
     * @return 用户
     */
    User findByUserName(@Param("userName") String userName);
}
