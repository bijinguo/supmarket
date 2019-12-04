package com.bi.supmarket.service.impl;

import com.bi.supmarket.entity.Product;
import com.bi.supmarket.mapper.ProductMapper;
import com.bi.supmarket.service.ProductService;
import com.bi.supmarket.service.ex.ProductNotFounException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Product getById(Integer id) {
        Product product = getProduct(id);

        if (product==null)throw new ProductNotFounException("商品显示异常，没有找到商品数据！");
        product.setPriority(null);
        product.setStatus(null);
        product.setCreatedTime(null);
        product.setCreatedUser(null);
        product.setModifiedTime(null);
        product.setModifiedUser(null);

        return product;
    }


    @Override
    public List<Product> getHot() {


        List<Product> pr = productMapper.findByPriority();

        return pr;
    }


    private Product getProduct(Integer id) {
        return productMapper.findById(id);
    }


}
