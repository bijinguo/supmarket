package com.bi.supmarket.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product extends BaseEntity {

    private Integer id ;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num ;
    private String image;
    private Integer status;
    private Integer priority;

    public Product() {
    }









}
