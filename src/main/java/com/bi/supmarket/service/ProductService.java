package com.bi.supmarket.service;

import com.bi.supmarket.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getHot();
    Product getById(Integer id);
}
