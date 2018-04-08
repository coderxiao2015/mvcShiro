package com.xiao.core.shiro;


import com.xiao.core.shiro.dao.ShiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
@Scope("prototype")
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroDao shiroDao;

    @Override
    public UserEntity getUserEntity(String loginName, String password) {
        return shiroDao.getUserEntity(loginName,password);
    }

    @Override
    public ArrayList<String> getUserRoles(String loginName) {
        return shiroDao.getUserRoles(loginName);
    }

    @Override
    public HashSet<String> getUserPermission(String loginName) {
        return shiroDao.getUserPermission(loginName);
    }
}
