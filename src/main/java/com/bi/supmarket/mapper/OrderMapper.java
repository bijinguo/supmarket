package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Order;
import com.bi.supmarket.entity.OrderItem;

public interface OrderMapper {

   Integer saveOrder(Order order);
   Integer saveOrderItem(OrderItem item);



}
