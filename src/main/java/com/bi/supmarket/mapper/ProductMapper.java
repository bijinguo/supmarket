package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> findByPriority();
    Product findById(Integer id);



}
