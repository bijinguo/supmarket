package com.bi.supmarket.controller;

import com.bi.supmarket.controller.ex.*;
import com.bi.supmarket.service.ex.*;
import com.bi.supmarket.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

public class BaseController {
    protected static final String SESSION_UID="uid";
    protected static final String SESSION_USERNAME="username";

    protected static final Integer SUCCESS=20;
    protected static final Integer ERROR_USERNAME_DUPLICATE=30;

//    对控制器的异常统一处理，封装响应信息
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    @ResponseBody
    public JsonResult<Void> handlerException(Throwable e){

        JsonResult<Void> jr = new JsonResult<>(e.getMessage());
        if (e instanceof UsernameDuplicateException){
            jr.setState(31);
        }else if (e instanceof PasswordNotMatchException){
            jr.setState(32);
        }else if(e instanceof AddressCountLimitException){
            jr.setState(33);
        }else if(e instanceof InsertException){
            jr.setState(40);
        }else if(e instanceof UpdateException){
            jr.setState(41);
        }else if (e instanceof FileEmptyException){
            jr.setState(50);
        }else if (e instanceof FileSizeException){
            jr.setState(51);
        }else if(e instanceof FileTypeException) {
            jr.setState(52);
        }else if(e instanceof FileStateException) {
            jr.setState(53);
        }else if(e instanceof FileIOException) {
            jr.setState(54);
        }


        return jr;



    }
/*
* 控制层直接得到username
* */

        public String getUsernameFromsession(HttpSession session){
            Object username = session.getAttribute(SESSION_USERNAME);
            if (username==null){
                throw new UserNotFoundException("用户登录失效，请重新登录");
            }
            return username.toString();

        }

/*
* 从session中拿到uid
* */

        public Integer getUidFromSession(HttpSession session){

            Object uid = session.getAttribute(SESSION_UID);

            if (uid==null){
                throw new UserNotFoundException("用户登录失效，请重新登录");
            }

            return Integer.valueOf(uid.toString());
        }




}
