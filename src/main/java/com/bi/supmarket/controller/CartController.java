package com.bi.supmarket.controller;

import com.bi.supmarket.entity.Cart;
import com.bi.supmarket.service.CartService;
import com.bi.supmarket.utils.JsonResult;
import com.bi.supmarket.vo.CartVo;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController extends BaseController {
    @Autowired
    CartService cartService;
    @GetMapping("/")
    public JsonResult<List<CartVo>> getList(HttpSession session ){

        List<CartVo> cartList = cartService.getCartList(getUidFromSession(session));
        JsonResult<List<CartVo>> js=new JsonResult<>();
        js.setData(cartList);js.setState(SUCCESS);
        return js;

    }
    @PostMapping("create_cart")
    public JsonResult<Void> createCat(HttpSession session,Integer pid,Integer num){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromsession(session);




        cartService.creatCart(num,uid,pid,username);



    return new JsonResult<>(SUCCESS);


    }
    @PostMapping("add_num")
    public JsonResult<Void> addNum(HttpSession session,Integer cid ,Integer num){
        String username= getUsernameFromsession(session);
        Integer uid = getUidFromSession(session);
        cartService.addNum(cid, num, uid, username);
        return new JsonResult<>(SUCCESS);




    }



    @PostMapping("{cid}/delete")
    public JsonResult<Void> delete(HttpSession session, @PathVariable("cid") Integer cid ){
        String username= getUsernameFromsession(session);
        Integer uid = getUidFromSession(session);
        cartService.delByCid(cid,uid);
        return new JsonResult<>(SUCCESS);




    }


    @PostMapping("reduce_num")
    public JsonResult<Void> reduceNum(HttpSession session,Integer cid,Integer num){
        String username= getUsernameFromsession(session);
        Integer uid = getUidFromSession(session);
        cartService.reduceNum(cid, num, uid, username);
        return new JsonResult<>(SUCCESS);



    }

    @GetMapping("showAll/getCids")
    public JsonResult< List<CartVo>> createCat(HttpSession session,Integer ...cids){
        Integer uid = getUidFromSession(session);



        List<CartVo> lists = cartService.showCartOrder(cids,uid);


        return new JsonResult< List<CartVo>>(SUCCESS,lists);


    }



}
