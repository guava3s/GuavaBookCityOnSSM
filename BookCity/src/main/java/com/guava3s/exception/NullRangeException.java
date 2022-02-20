package com.guava3s.exception;

/**
 * @author micolen
 * @version 1.0
 * @ClassName NullRangeException
 * @date 2021/12/18 17:12
 */
public class NullRangeException extends NullPointerException {

    public NullRangeException() {
        super("赋值的范围为空异常，无需担心，这是在控制范围内的自定义异常");
    }
}
