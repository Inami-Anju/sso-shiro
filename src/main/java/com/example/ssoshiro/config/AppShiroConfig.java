package com.example.ssoshiro.config;

import com.example.ssoshiro.realm.MyShiroRealm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author saki
 */
@Configuration
public class AppShiroConfig {
    @Autowired
    MyShiroRealm myShiroRealm;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //bean.setFilters(null);不能这么干，因为有默认的,而且这一步是关键的，他配置了filter信息，与tomcat结合
        bean.setLoginUrl("/login.html");//当此用户是一个非认证用户,需要先登陆进行认证
        Map<String, String> map=new LinkedHashMap<>();//必须有序
       // map.put("/static/**", "anon");//anon表示允许匿名访问，但static这部不好使，后来发现springboot默认把所有的静态资源都映射到static目录了
        map.put("/image/**", "anon");//img
        map.put("/css/**", "anon");//css
        map.put("/js/**", "anon");//js
        map.put("/index", "anon");//注意不是.html
        map.put("/", "anon");
        map.put("/login","anon");
        //bean.setLoginUrl("/login.html");
        map.put("/**", "authc");//必须授权才能访问
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        return securityManager;
    }



}
