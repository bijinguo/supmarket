package com.bi.supmarket.controller;

import com.bi.supmarket.entity.Product;
import com.bi.supmarket.service.ProductService;
import com.bi.supmarket.utils.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bi.supmarket.controller.BaseController.SUCCESS;

@RestController
@RequestMapping("product")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("hot")
    public JsonResult<List<Product>> getHot(){
        List<Product> hots = productService.getHot();
        return new JsonResult<List<Product>>(SUCCESS, hots);

    }
    @GetMapping("{id}/get")
    public JsonResult<Product> showById(@PathVariable("id")Integer id){

        Product byId = productService.getById(id);
        return new JsonResult<Product>(SUCCESS,byId);

    }






}
