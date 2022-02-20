package com.guava3s.api.service;

import com.guava3s.bean.CarItemDO;
import com.guava3s.bean.PageDO;

import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName CarService
 * @date 2021/11/26 14:46
 */
public interface CarService {

    /**
     * 通过用户id从redis中获取一页内容的购物项
     *
     * @param uid   用户账号
     * @param index 当前页数索引
     * @return
     */
    PageDO<CarItemDO> listCarItemByLimit(String uid, String index);

    /**
     * 通过用户id获取所有购物项
     *
     * @param uid
     * @return
     */
    List<CarItemDO> listCarItem(String uid);

    /**
     * 获取目标用户的购物车中的商品总个数
     *
     * @param username 用户账号
     * @return
     */
    int getCarItemCountFromCar(String username);

    /**
     * 获取目标用户的购物车中金额总数
     *
     * @param username 用户账号
     * @return
     */
    double getTotalCarItemAmount(String username);

    /**
     * 添加一项购物项,并返回一个购物车信息
     *
     * @param username 用户账号
     * @param bookId   添加的项的项目名
     */
    void insertCarItem(String username, String bookId);


    /**
     * 移除该用户所有购物项以及购物车
     *
     * @param username 用户账号
     */
    void removeAllCarItem(String username);





}
