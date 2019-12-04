package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.District;
import com.bi.supmarket.service.CartService;
import com.bi.supmarket.service.ex.ServiceException;
import com.sun.xml.internal.stream.StaxErrorReporter;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.rowset.serial.SerialException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddresT {
@Autowired
AddressMapper addressMapper;
@Autowired
    CartService cartService;
    @Autowired
    DistrictMapper mapper;

    @Test
    public void taddr(){
        List<District> lists = mapper.findByParent("220000");

        for (District ds:lists) {
            System.out.println(ds.toString());

        }


    }
    @Test
    public void tadd(){
       try {
           cartService.creatCart(10, 20, 10000003, "java");
       }catch (ServiceException e){
           System.err.println(e.getClass().getName());
           System.err.println(e.getMessage());
       }



    }

    @Test
    public void t2(){
        Integer I = addressMapper.updateIsDefault(4, "邓小平", new Date());
        System.out.println(I);


    }

    @Test
    public void t3(){
        Integer i = addressMapper.deleteUseAiD(3);
        System.out.println(i);

    }


}
