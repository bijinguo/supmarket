package com.bi.supmarket.entity;

import com.bi.supmarket.controller.BaseController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order extends BaseEntity {
//    CREATE TABLE t_order_item(
//            id INT AUTO_INCREMENT COMMENT 'id',
//            oid INT COMMENT '订单id',
//            pid INT COMMENT '商品id',
//            num INT COMMENT '商品数量',
//            price BIGINT COMMENT '商品单价',
//            image VARCHAR(100) COMMENT '商品图片路径',
//    title VARCHAR(100) COMMENT '商品标题',
//    created_user VARCHAR(50) COMMENT '创建用户',
//    created_time DATETIME COMMENT '创建时间',
//    modified_user VARCHAR(50) COMMENT '最后修改用户',
//    modified_time DATETIME COMMENT '最后修改时间',
//    PRIMARY KEY (id)
//	)DEFAULT CHARSET=utf8;
    private Integer id;
    private Integer uid  ;
    private String recvName  ;
    private String recvPhone ;
    private String  recvProvince;
    private String  recvCity;
    private String  recvArea;
    private String  recvAddress;
    private Integer status ;//订单状态
    private Long price  ;
    private Date orderTime;
    private Date payTime;



}
