package com.guava3s.common;

/**
 * @author micolen
 * @version 1.0
 * @ClassName ServiceFilter
 * @date 2021/11/27 19:22
 */
public class ServiceFilter {

    /**
     * 索引检查
     *
     * @param index
     * @return
     */
    public static Integer detectionIndex(String index) {
        Integer newIndex;
        try {
            if ((newIndex = Integer.parseInt(index)) <= 0) {
                newIndex = 1;
            }
        } catch (IllegalArgumentException e) {
            newIndex = 1;
        }
        return newIndex;
    }
}
