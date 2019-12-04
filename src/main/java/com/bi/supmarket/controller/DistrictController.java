package com.bi.supmarket.controller;

import com.bi.supmarket.entity.District;
import com.bi.supmarket.service.DistrictService;
import com.bi.supmarket.utils.JsonResult;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("district")
public class DistrictController extends BaseController {
    @Autowired
    DistrictService districtService;

    @GetMapping
    public JsonResult<List<District>> doShow(String parent){

        List<District> districts=districtService.getAll(parent);
        return  new JsonResult<List<District>>(SUCCESS,districts);
    }

}
