package com.xiao.common.shiro;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.xiao.core.shiro.ShiroService;
import com.xiao.core.shiro.UserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 用户自定义的权限验证继承了AuthorizingRealm，这个类继承了身份验证，身份授权，以及suject信息的缓存的实现
 *
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    /**
     * 身份认证：从subject.login(token) 中获取的身份信息，再和数据库中的信息进行比较
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName=token.getPrincipal()==null?null:token.getPrincipal().toString(); //用户名
        System.out.println("密码："+token.getCredentials());
        Object password=token.getCredentials()==null?null:token.getCredentials();  //密码

        if((loginName==null)||(password==null)){
            System.out.println("用户名/密码输入错误！");
            //抛出身份验证异常
            throw new AuthorizationException("身份验证异常");
        }
        String passwordStr=new String((char[])password);
        //从用户表中获取数据
        UserEntity userEntity=shiroService.getUserEntity(loginName,passwordStr);
        if(userEntity==null){
            System.out.println("用户名/密码输入错误！");
            //抛出未知的账户异常
            throw new UnknownAccountException("身份验证异常");
        }

      /*
        //设置用户锁定，锁定的用户将不能登录
      if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userEntity.getLoginName(), //用户名
                userEntity.getPassword(), //密码
                //ByteSource.Util.bytes(userEntity.getCredentialsSalt()),//salt=username+salt
                null,
                getName()  //realm name
        );


        return authenticationInfo;
    }

    /**
     * 用户授权：通过用户名查询用户的角色在查询出用户的权限，供前台shiro标签使用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String loginName=(String)principals.getPrimaryPrincipal(); //用户名
        //根据用户名获取用户的角色
        ArrayList<String> roles=shiroService.getUserRoles(loginName);
        authorizationInfo.addStringPermissions(roles);
        //根据角色获取用户的权限码
        HashSet<String> permissions=shiroService.getUserPermission(loginName);
        authorizationInfo.setObjectPermissions((HashSet)permissions);
        return authorizationInfo;
    }


}
