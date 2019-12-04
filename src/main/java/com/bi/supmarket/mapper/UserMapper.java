package com.bi.supmarket.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.bi.supmarket.entity.User;

/**
 * 用户功能的持久层接口
 */
public interface UserMapper {
	
	/**
	 * 用户注册的方法
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer addnew(User user);

	/**
	 * 更新密码
	 * @param uid 用户id
	 * @param password 新密码
	 * @param modifiedUser 最后修改用户
	 * @param modifiedTime 最后修改时间
	 * @return 受影响的行数
	 */
	Integer updatePassword(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);


	/**
	 * 用户上传头像
	 * @param uid 用户id
	 * @param avatar 头像路径
	 * @param modifiedUser 最后修改用户
	 * @param modifiedTime 最后修改时间
	 * @return
	 */
	Integer updateAvatar(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
	
	
	/**
	 * 更新用户信息
	 * 
	 * @param user 封装了用户信息的对象
	 * @return 受影响的行数
	 */
	Integer updateInfo(User user);
	
	
	
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return 封装了用户数据的实体类 或 没查到返回null
	 */
	User findByUsername(String username);
	
	
	/**
	 * 根据用户id查用户信息
	 * @param uid 用户id
	 * @return 封装了用户数据的User对象 或 null
	 */
	User findByUid(Integer uid);


}






