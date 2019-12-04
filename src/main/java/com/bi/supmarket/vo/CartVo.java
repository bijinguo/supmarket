package com.bi.supmarket.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CartVo {

    private Integer cid;
    private Integer pid;
    private String image;
    private String title;
    private Long realPrice; // 商品表中真实价格
    private Long price; // 添加购物车时的商品价格
    private Integer num;




}
