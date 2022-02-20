package com.guava3s.api.mapper;


import com.guava3s.bean.UserDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author micolen
 * @version 1.0
 * @ClassName UserMapper
 * @date 2021/11/16 19:20
 */
public interface UserMapper {

    /**
     * 根据UID获取用户对象
     *
     * @param uid 用户账号
     * @return
     */
    UserDO getUserById(String uid);

    /**
     * 通过ID与Password获取User对象
     *
     * @param id
     * @param password
     * @return
     */
    UserDO getUserByIdAndPassword(@Param("id") String id, @Param("password") String password);

    /**
     * 添加一个User对象
     *
     * @param user
     * @return 执行个数
     */
    int insertDefaultUser(UserDO user);

    /**
     * 设置用户状态
     *
     * @param id
     * @param state
     */
    void updateUserStateById(@Param("id") String id, @Param("state") String state);


}
