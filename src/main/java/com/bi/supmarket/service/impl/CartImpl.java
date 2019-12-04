package com.bi.supmarket.service.impl;

import com.bi.supmarket.entity.Cart;
import com.bi.supmarket.mapper.CartMapper;
import com.bi.supmarket.mapper.ProductMapper;
import com.bi.supmarket.service.CartService;
import com.bi.supmarket.service.ProductService;
import com.bi.supmarket.service.ex.*;
import com.bi.supmarket.vo.CartVo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.certpath.CertId;

import java.util.Date;
import java.util.List;

@Service
public class CartImpl implements CartService {

    @Autowired
    ProductService productService;
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartVo> showCartOrder(Integer[] ids,Integer uid) {
        if (uid==null){
            throw new UserNotFoundException("用户登录失效");
        }

        List<CartVo> list = cartMapper.findByCids(ids);
        if (list==null){
            throw new CartNotFounException("订单购物车失效！");
        }
        return list;

    }

    @Override
    public void reduceNum(Integer cid, Integer num, Integer uid, String username)throws  CartNotFounException, AccessDeniedException{
        Cart result = findBycid(cid);
        if (result==null){
            throw new CartNotFounException("购物车已失效！");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("用户修改权限异常，请重新登录");

        }
        Integer nNum=result.getNum()-num;
        if (nNum<=0){
            deleByCid(cid);
            return;
        }
      changeNum(cid,nNum,username, new Date());



    }

    @Override
    public void delByCid(Integer cid,  Integer uid)throws CartNotFounException,AccessDeniedException {

        Cart cart = findBycid(cid);
        if (cart==null)throw new CartNotFounException("购物车记录不存在");
        if (!cart.getUid().equals(uid)){
            throw new AccessDeniedException("用户登录失效");
        }



        deleByCid(cid);

    }




    @Override
    public List<CartVo> getCartList(Integer uid) {


        return findCartList(uid);
    }

    @Override
    public void addNum(Integer cid, Integer num, Integer uid, String username)throws CartNotFounException,AccessDeniedException {


        Cart bycid = findBycid(cid);
        if (bycid==null){
            throw new CartNotFounException("购物车添加异常");
        }
        if(!bycid.getUid().equals(uid)){
            throw new AccessDeniedException("非当前用户，权限异常！");

        }
        Integer oldNum = bycid.getNum();
       Integer newNum= oldNum+num;
       changeNum(cid, newNum, username, new Date());



    }






    @Override
    public void creatCart(Integer num, Integer uid, Integer pid, String username) throws UpdateException, InsertException {

        Cart cart = getByUidAndPid(uid, pid);
        if (cart==null){
            Cart c=new Cart();
            c.setUid(uid);
            c.setPid(pid);
            c.setNum(num);
            Long price = productService.getById(pid).getPrice();
            c.setPrice(price);
            Date now=new Date();
            c.setCreatedTime(now);
            c.setCreatedUser(username);
            c.setModifiedTime(now);
            c.setModifiedUser(username);


        saveCart(c);
            return;
        }

            Integer cid=cart.getCid();
            Integer newNum = cart.getNum() + num;


           changeNum(cid,newNum,username,new Date());



    }
private Cart findBycid(Integer cid)throws CartNotFounException, AccessDeniedException {

        if (cid==null){
            throw new CartNotFounException("购物车操作异常！请重新登录");
        }

        return cartMapper.findBycid(cid);
}


//
    private void saveCart(Cart cart) throws InsertException{
        Integer integer = cartMapper.saveCart(cart);
        if (!integer.equals(1)){
            throw new InsertException("保存购物车商品失败！");

        }
    };
//    Cart getByUidAndPid(@Param("uid")Integer uid,@Param("pid")Integer pid);
   private void changeNum(Integer cid,Integer num,String username, Date modifiedTime)throws  UpdateException{

       if (num<0){
           throw new IllegalArgumentException("商品参数有问题！");
       }

       Integer integer = cartMapper.changeNum(cid, num, username, modifiedTime);
       if (integer!=1){
           throw new UpdateException("购物车添加异常！");
       }


   }
    private Cart getByUidAndPid(Integer uid,Integer pid){

       return cartMapper.getByUidAndPid(uid, pid);
    }


//
//
//    Cart findBycid(Integer cid);




    List<CartVo> findCartList(Integer uid){
       return cartMapper.findCartList(uid);


    };
private void deleByCid(Integer cid){
    Integer integer = cartMapper.deleteByCid(cid);
    if (!integer.equals(1)){
        throw new UpdateException("更新失败！");


    }
}







}
