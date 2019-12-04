package com.bi.supmarket.service;

import com.bi.supmarket.entity.Address;
import com.bi.supmarket.service.ex.AccessDeniedException;
import com.bi.supmarket.service.ex.AddressNotFoundException;
import com.bi.supmarket.service.ex.UpdateException;
import com.bi.supmarket.vo.CartVo;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;
import java.util.List;

public interface AddressService {

    List<Address> showAddress(Integer uid);

    void createdAddress(Integer uid, String username, Address address);

    void delByAid(Integer aid,Integer uid,String username);

    void setDefault(Integer aid,Integer uid, String name, Date modified)throws AddressNotFoundException, AccessDeniedException, UpdateException;
}
