package com.bi.supmarket.service.impl;

import com.bi.supmarket.entity.User;
import com.bi.supmarket.mapper.UserMapper;
import com.bi.supmarket.service.UserService;
import com.bi.supmarket.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void register(User user) throws UsernameDuplicateException {
        String username = user.getUsername();
        User user1 = userMapper.findByUsername(username);
        if (user1!=null){
            throw new UsernameDuplicateException("用户名已存在");
        }
        String password = user.getPassword();
        String salt = UUID.randomUUID().toString();
        String newword=getUUIDPassword(password,salt);
        user.setSalt(salt);
        user.setPassword(newword);
        user.setIsDelete(0);
        user.setCreatedUser(username);
        Date now=new Date();
        user.setCreatedTime(now);
        user.setModifiedTime(now);
        user.setModifiedUser(username);

        Integer rows = userMapper.addnew(user);
        if (!rows.equals(1)) throw new InsertException("用户注册异常");


    }

    @Override
    public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        User u = userMapper.findByUsername(username);
        if ( u==null){
            throw new UserNotFoundException("用户不存在");
        }
        if (u.getIsDelete().equals(1)) throw new UserNotFoundException("登录异常！用户名不存在");
        String salt=u.getSalt();
        String password1 = getUUIDPassword(password, salt);

        if (!password1.equals(u.getPassword())){
            throw new PasswordNotMatchException("密码不正确");
        }
        //        // 将盐值设为null
        u.setSalt(null);
        // 将密码设为null
        u.setPassword(null);
        // 将isDelete设为null
        u.setIsDelete(null);
        // 返回user
        return u;
    }

    private String getUUIDPassword(String password, String salt) {

        String s = salt+password+salt;
        for (int i = 0; i < 3; i++) {
            s=DigestUtils.md5DigestAsHex(s.getBytes());

        }

            return s;
    }

    @Override
    public User getUserByuid(Integer uid) throws UserNotFoundException {
        if (uid==null)throw new UserNotFoundException("用户信息已失效，请重新登录");
        User user= userMapper.findByUid(uid);
        if (user==null) throw new UserNotFoundException("用户没有登录，请重新登录");
        return user;
    }

//    @Override
//    public User getUserByUsername(String username) throws UserNotFoundException, PasswordNotMatchException {
//        User user = userMapper.findByUsername(username);
//
//
//
//
//        return null;
//    }
/*
* 页面传值有user(包含email,phone,gender,username)需要再设定uid,modifiedUser,modifiedTime,
* */
    @Override
    public void changeInfo(Integer uid,String username,User user) throws UserNotFoundException,UpdateException {
        User user1 = getUserByuid(uid);
        if (user1==null){
            throw new UserNotFoundException("用户不存在");
        }
        if (user1.getIsDelete().equals(1)) throw new UserNotFoundException("用户信息异常,已注销");
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer integer = userMapper.updateInfo(user);
        if (!integer.equals(1)){
            throw new UpdateException("更新用户信息异常");
        }


    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String modifiedUser) throws UserNotFoundException,UpdateException {
        User user = userMapper.findByUid(uid);
        if (user==null)throw new UserNotFoundException("用户不存在");
        if (user.getIsDelete().equals(1)) throw new UserNotFoundException("修改头像异常，用户数据不存在");
        Integer integer = userMapper.updateAvatar(uid, avatar, modifiedUser, new Date());
        if (!integer.equals(1)) throw new UpdateException("修改头像失败");


    }

    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword, String modifiedUser) throws UserNotFoundException, PasswordNotMatchException, UpdateException {

        User user = userMapper.findByUid(uid);
        if (user==null)throw new UserNotFoundException("用户不存在");
        if (user.getIsDelete().equals(1)) throw new UserNotFoundException("修改密码异常，用户数据不存在");
        String salt = user.getSalt();
        String password = user.getPassword();
        String word=getUUIDPassword(oldPassword, salt);
        if (! word.equals(password)) throw new PasswordNotMatchException("原密码不正确，请重新输入");


        String pwd=getUUIDPassword(newPassword, salt);
        Integer row= userMapper.updatePassword(uid, pwd, modifiedUser, new Date());
        if (!row.equals(1))throw new UpdateException("修改密码异常");



    }
}
