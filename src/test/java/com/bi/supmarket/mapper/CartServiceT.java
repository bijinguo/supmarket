package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.District;
import com.bi.supmarket.service.CartService;
import com.bi.supmarket.service.ex.ServiceException;
import com.bi.supmarket.vo.CartVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceT {

    @Autowired
    CartMapper cartMapper;


    @Test
    public void taddr(){


        List<CartVo> cartList = cartMapper.findCartList(6);
        for (CartVo v:cartList) {
            System.err.println(v.toString());
        }



    }
//    @Test
//    public void tdd(){
//       try {
//           cartMapper.deleteByCid()
//       }catch (ServiceException e){
//           System.err.println(e.getClass().getName());
//           System.err.println(e.getMessage());
//       }
//



//
//    @Test
//    public void t2(){
//        Integer I = addressMapper.updateIsDefault(4, "邓小平", new Date());
//        System.out.println(I);
//
//
//    }
//
    @Test
    public void t3(){
        Integer i = cartMapper.changeNum(11, 2, "bi", new Date());
        System.out.println(i);

    }
}


