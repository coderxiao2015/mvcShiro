package com.xiao.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/*测试shiro的身份验证*/
public class ShiroIdentify {

    /**
     * 通过ini文件配置方式进行登录验证
     */
    @Test
    public void test()
    {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:resource/shiro/shiro.ini");

        //获取SecurityManager 实例
        SecurityManager securityManager=factory.getInstance();

        //将实例存放到SecutityUtils
        SecurityUtils.setSecurityManager(securityManager);

        //获取用户登录的主题
        Subject subject=SecurityUtils.getSubject();

        //创建用户登录的身份（token）
        UsernamePasswordToken token=new UsernamePasswordToken("zhan1","123");

        //通过主题进行登录验证
        try {
            //4、登录，即身份验证
            subject.login(token);
            //判断用户是否已经登录
            System.out.println("用户登录："+subject.isAuthenticated());
        } catch (AuthenticationException e) {
            //5、身份验证失败 ，这是一个大异常，还分为用户名异常和密码异常，但是密码异常一般不做提示，防止暴力破解
            System.out.println("认证失败！");
        }
    }

    /**
     * 通过realm方式进行验证
     * 准备工作 添加数据源
     */

}
