package com.bi.supmarket.controller;

import com.bi.supmarket.controller.ex.FileEmptyException;
import com.bi.supmarket.controller.ex.FileSizeException;
import com.bi.supmarket.controller.ex.FileStateException;
import com.bi.supmarket.controller.ex.FileTypeException;
import com.bi.supmarket.entity.User;
import com.bi.supmarket.service.UserService;
import com.bi.supmarket.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    private static final long AVATAR_MAX_SIZE=1*1024*1024;
    private static final List<String> AVATAR_TYPES=new ArrayList<>();
     static {
         AVATAR_TYPES.add("image/jpeg");
         AVATAR_TYPES.add("image/jpg");
         AVATAR_TYPES.add("image/png");

     }

    @Autowired
    private UserService userService;
    @PostMapping("reg")
    public JsonResult<Void> regUser(User user){

        userService.register(user);


        return new JsonResult(SUCCESS);


    }


    @PostMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){


        User user = userService.login(username, password);
        session.setAttribute(SESSION_USERNAME, user.getUsername());
        session.setAttribute(SESSION_UID, user.getUid());

        return new JsonResult<User>(SUCCESS,user);


    }
    @GetMapping("getInfo")
    public JsonResult<User> getInfo(HttpSession session){
        Integer uid = getUidFromSession(session);
        User u = userService.getUserByuid(uid);
        return new JsonResult<User>(SUCCESS,u);
    }

    @PostMapping("changeInfo")
    public JsonResult<Void> changeInfo(HttpSession session,User user){
        Integer uid = Integer.valueOf(session.getAttribute(SESSION_UID).toString());
        String username = session.getAttribute(SESSION_USERNAME).toString();


        userService.changeInfo(uid, username,user);
        return new JsonResult<>(SUCCESS);


    }
    @PostMapping("changePassword")
    public JsonResult<Void> changePWD(HttpSession session,@RequestParam("old_password") String oldPassword,@RequestParam("new_password") String newPassword){

        Integer uid = Integer.valueOf(session.getAttribute(SESSION_UID).toString());
        String username = session.getAttribute(SESSION_USERNAME).toString();
        userService.changePassword(uid,oldPassword,newPassword,username);

        return new JsonResult<Void>(SUCCESS);

    }
    @PostMapping("upload")
    public JsonResult<String> changeAvatar(HttpSession session, HttpServletRequest request, @RequestParam("file")MultipartFile file){

        if (file.isEmpty())throw new FileEmptyException("文件上传不能为空");
        long size = file.getSize();
        if (size>AVATAR_MAX_SIZE) throw new FileSizeException("文件上传异常，文件大小超限");
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)) throw new FileTypeException("文件上传异常，文件类型不正确，允许文件类型有："+AVATAR_TYPES);
        String originalFilename = file.getOriginalFilename();//获得文件名
        System.out.println(originalFilename);

        int index = originalFilename.indexOf(".");
        String fileSuffix="";
        if (index!=-1){
             fileSuffix = originalFilename.substring(index);
        }
        String fileName = UUID.randomUUID().toString() + fileSuffix;
        //生成目标路径
        ServletContext servletContext = request.getServletContext();
        String digestPath = servletContext.getRealPath("upload");
        System.out.println(digestPath);



        File parent=new File(digestPath);
        if (!parent.exists()){
            parent.mkdirs();
        }
        File dest=new File(parent, fileName);
        System.out.println(dest.toString());



        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileStateException("文件上传异常"+e.getMessage());
        }
        String avatar="/upload/"+fileName;
        System.out.println(avatar);


        Integer uid=getUidFromSession(request.getSession());
        String username = getUsernameFromsession(request.getSession());
        userService.changeAvatar(uid,avatar ,username);

        JsonResult<String> js=new JsonResult<>();
        js.setState(SUCCESS);
        js.setData(avatar);
        return js;
    }
















}
