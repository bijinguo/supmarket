package com.bi.supmarket.service;

import com.bi.supmarket.entity.District;

import java.util.List;

public interface DistrictService {
   List<District> getAll(String parent);


    District getByCode(String code);
}
