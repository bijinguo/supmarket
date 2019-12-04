package com.bi.supmarket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderItem extends BaseEntity {
//    id INT AUTO_INCREMENT COMMENT 'id',
//    oid INT COMMENT '订单id',
//    pid INT COMMENT '商品id',
//    num INT COMMENT '商品数量',
//    price BIGINT COMMENT '商品单价',
//    image VARCHAR(100) COMMENT '商品图片路径',
//    title VARCHAR(100) COMMENT '商品标题',
    private Integer id;

    private Integer oid  ;
    private Integer pid  ;
    private Integer num ;
    private Long  price;
    private String  image;
    private String  title;











}
