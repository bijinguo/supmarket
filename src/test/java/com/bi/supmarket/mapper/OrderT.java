package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Order;
import com.bi.supmarket.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderT {
    @Autowired
    OrderMapper mapper;
    @Test
    public void t1(){
        Order order=new Order();
        order.setPrice(Long.valueOf(12345));
        order.setStatus(1);
        order.setUid(6);
        order.setRecvAddress("pane abbreviation");
        Integer integer = mapper.saveOrder(order);
        System.err.println("row="+integer);
        System.err.println("after:"+order.getId());

    }

    @Test
    public void saveOrderItem() {
        OrderItem item=new OrderItem();
        item.setPid(111);
        item.setOid(2);
        item.setPrice(2000L);
        Integer row=mapper.saveOrderItem(item);
        System.err.println("row="+row);
    }


}
