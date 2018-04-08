package com.xiao.core.shiro.dao;

import com.xiao.core.shiro.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;

@Repository
@Scope("prototype")
public interface ShiroDao {

    public UserEntity getUserEntity(String loginName, String password);

    public ArrayList<String> getUserRoles(String loginName);

    public HashSet<String> getUserPermission(String loginName);
}
