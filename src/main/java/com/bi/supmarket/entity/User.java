package com.bi.supmarket.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class User extends BaseEntity {

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private Integer isDelete;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;


}
