package com.bi.supmarket.mapper;

import com.bi.supmarket.entity.Address;

import java.util.Date;
import java.util.List;

/**
 * 收货地址对应的持久层接口
 */
public interface AddressMapper {
	
	/**
	 * 增加新的收货地址
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer saveAddress(Address address);

	/**
	 * 根据uid查询用户收货地址条数
	 * @param uid 用户id
	 * @return 用户收货地址条数
	 */
	Integer countByUid(Integer uid);


	List<Address> findByUid(Integer uid);

    Integer deleteUseAiD(Integer aid);
    Address getByAid(Integer aid);

	Address findLastModi(Integer uid);

	Integer updateIsDefault(Integer aid, String username, Date modifiedTime);
	Integer setNone(Integer uid);
}
