package com.guava3s.test;

import com.guava3s.bean.UserDO;
import com.guava3s.api.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author micolen
 * @version 1.0
 * @ClassName com.guava3s.test.UpdateTest
 * @date 2021/11/20 17:31
 */

public class UpdateTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        int i = userMapper.insertDefaultUser(new UserDO(null, "1000", "1", "1", "__OffLine", null));
        System.out.println(i);
    }


}
