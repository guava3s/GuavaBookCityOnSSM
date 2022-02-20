package com.guava3s.encryption;

import com.guava3s.common.Const;

/**
 * @author micolen
 * @version 1.0
 * @ClassName DateSecurity
 * @date 2021/12/2 21:27
 */
public class DateSecurity {

    /**
     * 对齐函数，校正账号长度
     * eg:
     * 将账号为 123456 转化为 00000123456
     *
     * @param userId
     * @return
     */
    public static String aligningCode(String userId) {
        if (userId.length() < Const.LENGTH_ID) {
            StringBuffer sb = new StringBuffer(userId);
            for (int i = 0; i < Const.LENGTH_ID - userId.length(); i++) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }
        return userId;
    }
}
