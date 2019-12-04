package com.bi.supmarket;

import com.bi.supmarket.entity.User;
import com.bi.supmarket.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupmarketApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() {

		User user=new User();
		user.setEmail("909090");//
		user.setUsername("我是谁");
		user.setPassword("1234");
		user.setGender(1);
		user.setIsDelete(1);
		System.err.println("BEFOR uid="+user.getUid());
		System.err.println(user.toString());
		Integer I = userMapper.addnew(user);
		System.err.println("AFTER uid="+user.getUid());
		System.out.println(I);
	}

}
