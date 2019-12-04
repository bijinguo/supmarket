package com.bi.supmarket.service;

import com.bi.supmarket.entity.Cart;
import com.bi.supmarket.vo.CartVo;

import java.util.List;

public interface CartService {
    void creatCart(Integer num,Integer uid,Integer pid, String username);
    List<CartVo> getCartList(Integer uid);
    void addNum(Integer cid,Integer num,Integer uid,String username);
    void reduceNum(Integer cid,Integer num,Integer uid,String username);
    void delByCid(Integer cid,Integer uid);
    List<CartVo> showCartOrder(Integer[] ids,Integer uid);





}
