package com.bi.supmarket.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
public class Cart extends BaseEntity {

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;

    public Cart() {
    }
}
