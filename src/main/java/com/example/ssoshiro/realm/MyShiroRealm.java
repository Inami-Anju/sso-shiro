package com.example.ssoshiro.realm;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssoshiro.common.User;
import com.example.ssoshiro.dao.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户角色
        Set<String> roleSet=new HashSet<>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //获取用户权限
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);
         return info;
    }
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        QueryWrapper<User> wrapper=new QueryWrapper();

        //userMapper.selectOne();
        String password=String.valueOf(token.getPassword());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickname", username);
        String paw=password+username;
        System.out.println(paw);
        String pawDES=paw;
        User user=new User().setPassword(password).setUsername(username);

        return new SimpleAuthenticationInfo(user, password, getName());

    }
}
