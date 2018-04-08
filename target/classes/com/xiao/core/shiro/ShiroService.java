package com.xiao.core.shiro;

import java.util.ArrayList;
import java.util.HashSet;

public interface ShiroService {

    public UserEntity getUserEntity(String loginName,String password);

    public ArrayList<String> getUserRoles(String loginName);

    public HashSet<String> getUserPermission(String loginName);


}
