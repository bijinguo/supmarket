package com.bi.supmarket.controller;


import com.bi.supmarket.entity.Address;
import com.bi.supmarket.mapper.UserMapper;
import com.bi.supmarket.service.AddressService;
import com.bi.supmarket.service.UserService;
import com.bi.supmarket.service.ex.UserNotFoundException;
import com.bi.supmarket.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RequestMapping("address")
@RestController
public class AddressController extends BaseController {



    @Autowired
    AddressService addressService;

    @GetMapping("list")
    public JsonResult<List<Address>> listByUid(HttpSession session){
        Integer uid = getUidFromSession(session);

        System.out.println(uid);
        List<Address> addresses = addressService.showAddress(uid);
        System.out.println(addresses);

        return new JsonResult<List<Address>>(SUCCESS,addresses);

    }

        @PostMapping("createAddress")
    public JsonResult<Void> creatAddr(HttpSession session,Address address){

            Integer uid = getUidFromSession(session);

            String username=getUsernameFromsession(session);
            addressService.createdAddress(uid,username,address);




            return new JsonResult<>(SUCCESS);
        }
        @RequestMapping("{aid}/delete")
    public JsonResult<Void> delByUid(@PathVariable("aid") Integer aid,HttpSession session){
        Integer uid=getUidFromSession(session);
            String username=getUsernameFromsession(session);
        addressService.delByAid(aid,uid,username);
        return new JsonResult<>(SUCCESS);





        }
        @RequestMapping("{aid}/set_default")
     public JsonResult<Void> setDefaultADDR(@PathVariable("aid") Integer aid,HttpSession session){
            String username = getUsernameFromsession(session);
            Integer uid = getUidFromSession(session);
            if (username==null){
                throw new UserNotFoundException("用户信息失效，请重新登录");
            }

            addressService.setDefault(aid,uid, username,new Date());

        return new JsonResult<Void>(SUCCESS);
        }




}
