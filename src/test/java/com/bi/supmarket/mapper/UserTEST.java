package com.bi.supmarket.mapper;

import com.bi.supmarket.SupmarketApplication;
import com.bi.supmarket.entity.Address;
import com.bi.supmarket.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTEST {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;


    @Test
    public void testInfoCH(){
User user=new User();
        user.setUid(20);
        user.setUsername("java");
        user.setPhone("13232323");
        user.setEmail("1205@QQ.COM");
        user.setGender(1);

        user.setModifiedUser("admin");
        user.setModifiedTime(new Date());
        userMapper.updateInfo(user);

    }


    @Test
    public void t1(){
Address address=new Address();
address.setUid(11);
address.setIsDefault(1);
address.setAddress("天上人间");
address.setName("玛丽");

        Integer integer = addressMapper.saveAddress(address);
        System.out.println(integer);
    }







}
