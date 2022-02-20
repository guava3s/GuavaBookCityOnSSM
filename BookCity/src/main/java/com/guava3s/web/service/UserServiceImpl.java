package com.guava3s.web.service;

import com.guava3s.bean.UserDO;
import com.guava3s.encryption.MD5Util;
import com.guava3s.api.mapper.UserMapper;
import com.guava3s.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author micolen
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2021/11/16 19:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO login(String id, String password) {
        String strongerPassword = MD5Util.digest(password);
        return userMapper.getUserByIdAndPassword(id, strongerPassword);
    }

    @Override
    public int register(UserDO user) {
        UserDO user1 = userMapper.getUserById(user.getUsername());
        if (user1 == null) {
            user.setPassword(MD5Util.digest(user.getPassword()));
            return userMapper.insertDefaultUser(user);
        } else {
            return 0;
        }
    }

    @Override
    public void logout(String id) {
        userMapper.updateUserStateById(id, "__OffLine");
    }

}
