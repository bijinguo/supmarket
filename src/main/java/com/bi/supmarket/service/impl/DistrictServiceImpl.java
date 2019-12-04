package com.bi.supmarket.service.impl;

import com.bi.supmarket.entity.Address;
import com.bi.supmarket.entity.District;
import com.bi.supmarket.mapper.DistrictMapper;
import com.bi.supmarket.service.AddressService;
import com.bi.supmarket.service.DistrictService;
import com.bi.supmarket.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictMapper mapper;

    @Override
    public List<District> getAll(String parent) {
        List<District> districtList = mapper.findByParent(parent);


        return districtList;
    }

    @Override
    public District getByCode(String code) {
        District di = mapper.findByCode(code);
        return di;
    }

}