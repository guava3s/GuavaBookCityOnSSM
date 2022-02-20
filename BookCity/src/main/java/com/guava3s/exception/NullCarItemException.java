package com.guava3s.exception;

/**
 * @author micolen
 * @version 1.0
 * @ClassName NullCarItemException
 * @date 2021/12/18 15:13
 */
public class NullCarItemException extends RuntimeException {

    public NullCarItemException() {
        super("The CarItem List is Empty");
    }
}
