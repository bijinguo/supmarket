package com.bi.supmarket.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Address extends BaseEntity {
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private Integer provinceCode;
    private String cityName;
    private Integer cityCode;
    private String areaName;
    private Integer areaCode;
    private Integer zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAid().equals(address.getAid()) &&
                Objects.equals(getTel(), address.getTel()) &&
                Objects.equals(getTag(), address.getTag()) &&
                Objects.equals(getIsDefault(), address.getIsDefault());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAid());
    }
}
