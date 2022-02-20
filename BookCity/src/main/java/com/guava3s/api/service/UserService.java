package com.guava3s.api.service;

import com.guava3s.bean.UserDO;

/**
 * @author micolen
 * @version 1.0
 * @ClassName UserService
 * @date 2021/11/16 19:16
 */
public interface UserService {


    /**
     * 登录
     *
     * @param id     用户名
     * @param passwd 密码
     * @return 存在的user对象
     */
    UserDO login(String id, String passwd);

    /**
     * 注册
     *
     * @param user
     * @return 1 ：注册成功，0：注册失败
     */
    int register(UserDO user);

    /**
     * 登出账号
     *
     * @param id
     */
    void logout(String id);


}
