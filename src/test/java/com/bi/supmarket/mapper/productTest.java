package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class productTest {

    @Autowired
    ProductMapper productMapper;
    @Test
    public void t1(){

        List<Product> products = productMapper.findByPriority();
        for (Product p: products){
            System.out.println(p.toString());
        }


    }
    @Test
    public void T2(){

        Product p = productMapper.findById(10000007);
        System.out.println(p.toString());
    }



}
