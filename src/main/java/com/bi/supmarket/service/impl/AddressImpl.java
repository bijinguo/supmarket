package com.bi.supmarket.service.impl;

import com.bi.supmarket.entity.Address;
import com.bi.supmarket.entity.District;
import com.bi.supmarket.mapper.AddressMapper;
import com.bi.supmarket.service.AddressService;
import com.bi.supmarket.service.DistrictService;
import com.bi.supmarket.service.ex.*;
import com.bi.supmarket.vo.CartVo;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedEntityGraph;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
@Service
public class AddressImpl implements AddressService {
    public  static final Integer ADDRESS_LIMIT_MAX=5;
    @Autowired
    AddressMapper mapper;
    @Autowired
    DistrictService districtService;

    @Override
    public List<Address> showAddress(Integer uid) {

        List<Address> addressList = mapper.findByUid(uid);
        for (Address a:addressList){
            a.setZip(null);
            a.setTel(null);
            a.setModifiedTime(null);
            a.setModifiedUser(null);
            a.setCreatedUser(null);
            a.setCreatedTime(null);
        }

        return addressList;
    }


    @Override
    public void createdAddress(Integer uid,String username,Address address) {
        List<Address> addresses = mapper.findByUid(uid);
        if (addresses.size()>ADDRESS_LIMIT_MAX){
            throw new AddressCountLimitException("用户地址超限，不能大于5条");

        }

        if (address==null){
            throw new  RuntimeException("没有输入地址，请重新输入！");

        }
        address.setUid(uid);
        /*
        * 补全默认地址，根据收货地址条数进行判断*/
        int isDefault=addresses.size()==0 ? 1:0;
        address.setIsDefault(isDefault);
        //补齐其他信息，存入数据库
        String provinceName = getNameByCode(address.getProvinceCode().toString());
        String cityName=getNameByCode(address.getCityCode().toString());
        String areaName=getNameByCode(address.getAreaCode().toString());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);
        Date now=new Date();

        address.setCreatedUser(username);
        address.setCreatedTime(now);
        address.setModifiedUser(username);
        address.setModifiedTime(now);
      saveAddress(address);


    }

    @Override
    @Transactional
    public void delByAid(Integer aid,Integer uid,String username) {
        Address addr = findByAid(aid);
        if (addr==null) {
            throw new AddressNotFoundException("地址异常，可能已删除");
        }
        if (!addr.getUid().equals(uid)){
            throw new AccessDeniedException("删除地址异常，访问权限不足");

        }
        deleteByAid(aid);
        if (addr.getIsDefault()!=1){
            return;
        }
        Integer count = getCountByUid(uid);

        if (count==0){
            return;
        }


        Address address = findAddrLastModified(uid);
       updateDefault(address.getAid(), username,new Date());


    }

    @Override
    @Transactional
    public void setDefault(Integer aid,Integer uid, String name, Date modified) throws AddressNotFoundException, AccessDeniedException, UpdateException {

        Address ad = findByAid(aid);
        if (ad==null){
            throw new AddressNotFoundException("地址数据不存在");
        }
        if (!ad.getUid().equals(uid))throw new AccessDeniedException("访问权限不足");
        setAllDefaultNone(uid);
        updateDefault(aid, name,new Date());


    }

    private void setAllDefaultNone(Integer uid) {
       mapper.setNone(uid);
//        if (row!=1)throw new UpdateException("更改用户信息异常");



    }

    public void updateDefault(Integer aid, String name,Date modifed) throws AddressNotFoundException, AccessDeniedException, UpdateException {

        Integer row = mapper.updateIsDefault(aid, name, modifed);
        if (row!=1){
            throw new UpdateException("设置默认地址异常");
        }


    }

    private Address findAddrLastModified(Integer uid) {


        Address a = mapper.findLastModi(uid);


        return a;
    }

    private Integer getCountByUid(Integer uid) {

        Integer count = mapper.countByUid(uid);
        return count;
    }

    private void deleteByAid(Integer aid) {
        Integer integer = mapper.deleteUseAiD(aid);
        if (!integer.equals(1)){
            throw new DeleteException("删除异常");
        }


    }

    private Address findByAid(Integer aid) {

        return mapper.getByAid(aid);
    }

    private void saveAddress(Address address) {
        Integer row = mapper.saveAddress(address);
        if (!row.equals(1)){
            throw new UpdateException("用户添加地址失败");
        }
    }

    private String getNameByCode(String code) {
        District district = districtService.getByCode(code);
        return district==null? "":district.getName();
    }
}
