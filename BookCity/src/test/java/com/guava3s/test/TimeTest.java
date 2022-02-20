package com.guava3s.test;

import com.guava3s.encryption.DateSecurity;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author micolen
 * @version 1.0
 * @ClassName com.guava3s.test.TimeTest
 * @date 2021/12/2 21:07
 */
public class TimeTest {

    @Test
    public void test() {
        System.out.println(new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println(date);


        System.out.println(DateSecurity.aligningCode("1223456"));
    }
}
