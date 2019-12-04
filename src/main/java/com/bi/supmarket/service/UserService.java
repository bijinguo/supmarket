package com.bi.supmarket.service;

import com.bi.supmarket.entity.User;
import com.bi.supmarket.service.ex.PasswordNotMatchException;
import com.bi.supmarket.service.ex.UpdateException;
import com.bi.supmarket.service.ex.UserNotFoundException;
import com.bi.supmarket.service.ex.UsernameDuplicateException;

import java.util.Date;

public interface UserService {
    void register(User user) throws UsernameDuplicateException;
    User getUserByuid(Integer uid) throws UserNotFoundException;
//    User getUserByUsername(String username) throws UserNotFoundException, PasswordNotMatchException;
    void changePassword(Integer uid,String oldPassword, String newPassword, String modifiedUser) throws UserNotFoundException,PasswordNotMatchException
            , UpdateException;

    User login(String username,String password) throws UserNotFoundException,PasswordNotMatchException;
    void changeInfo(Integer uid,String username,User user);
    void changeAvatar(Integer uid,String avatar,String modifiedUser);

}
