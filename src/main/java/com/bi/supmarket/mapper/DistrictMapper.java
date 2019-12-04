package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.District;

import java.util.List;

/*
* 省市区域持久层接口
* */
    public interface DistrictMapper {

/*根据parent查子区域

* */

List<District> findByParent(String parent);


        /*
        * 根据地区编号查区域*/
        District findByCode(String code);

    }
