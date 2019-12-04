package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Cart;
import com.bi.supmarket.vo.CartVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CartMapper {
    Integer saveCart(Cart cart);
    Cart getByUidAndPid(@Param("uid")Integer uid,@Param("pid")Integer pid);
    Integer changeNum(@Param("cid")Integer cid,@Param("num")Integer num,@Param("username")String username,@Param("modifiedTime") Date modifiedTime);
    Integer deleteByCid(Integer cid);//根据cid删除购物车的一条记录


    Cart findBycid(Integer cid);
    List<CartVo> findCartList(Integer uid);

    List<CartVo> findByCids(Integer[] cids);


}
