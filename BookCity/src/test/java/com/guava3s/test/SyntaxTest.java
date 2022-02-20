package com.guava3s.test;

import org.junit.Test;

/**
 * @author micolen
 * @version 1.0
 * @ClassName SyntaxTest
 * @date 2021/12/19 12:09
 */
public class SyntaxTest {

    @Test
    public void test() {

        try {
            int a = 1;

            if (a == 1) {
                System.out.println(a);
                return;
            }
        } finally {
            System.out.println("执行finally语句");
        }
        /*
        最终输出：
            1
            执行finally语句
         */


    }
}
