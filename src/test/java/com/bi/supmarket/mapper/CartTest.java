package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTest {

    @Autowired
    CartMapper cartMapper;

    @Test
    public void t11(){


        Cart cart=new Cart();
        cart.setPrice(Long.valueOf(1123));
        cart.setNum(1);
        cart.setPid(Integer.valueOf(10000002));
        cart.setUid(20);
        cart.setCreatedUser("java");

        Integer integer = cartMapper.saveCart(cart);
        System.out.println(integer);


    }


}
