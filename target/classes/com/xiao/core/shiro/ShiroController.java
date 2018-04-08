package com.xiao.core.shiro;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shiro")
@Scope("prototype")
public class ShiroController {

    //跳转到用户登录页面
    @RequestMapping("/goLogin")
    public ModelAndView goLogin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/user/login");
        return modelAndView;
    }

    //用户登录请求
    @RequestMapping("/doLogin")
    public ModelAndView doLogin(UserEntity userEntity){
        ModelAndView modelAndView=new ModelAndView();
        String loginName=userEntity.getLoginName();
        String password=userEntity.getPassword();
        //获取主题
        Subject subject=SecurityUtils.getSubject();

        //创建token
        UsernamePasswordToken token=new UsernamePasswordToken();
        token.setUsername(loginName);
        token.setPassword(password.toCharArray());

        //开始登录
        subject.login(token);

        //判断是否登录成功
        if(subject.isAuthenticated()){
            modelAndView.setViewName("/user/loginSuccess"); //登录成功
        }else{
            modelAndView.setViewName("/user/loginFailed");  //登录失败
        }
        return modelAndView;
    }

}
