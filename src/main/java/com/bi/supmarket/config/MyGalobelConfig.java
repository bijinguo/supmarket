package com.bi.supmarket.config;

import com.bi.supmarket.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyGalobelConfig implements WebMvcConfigurer {




    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        HandlerInterceptor loginInterceptor=new LoginInterceptor();

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
      interceptorRegistration.addPathPatterns("/**");
        List<String > lists=new ArrayList<>();
        lists.add("/bootstrap3/**");
        lists.add("/css/**");
        lists.add("/images/**");
        lists.add("/js/**");
        lists.add("/web/**");
// 注册和登录控制器
       lists.add("/user/login");
       lists.add("/user/reg");
lists.add("/address/**");
       lists.add("/district/**");
    lists.add("/product/**");
    lists.add("/cart/**");

        interceptorRegistration.excludePathPatterns(lists);




    }


}
