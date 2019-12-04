package com.bi.supmarket.mapper;

import com.bi.supmarket.vo.CartVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMappT {



     @Autowired
    CartMapper  mapper;

     @Test
    public void t2(){
         Integer [] ids={3,6,7};
         List<CartVo> carts = mapper.findByCids(ids);
         for (CartVo v:carts){
             System.err.println(v.toString());
         }

     }
}
