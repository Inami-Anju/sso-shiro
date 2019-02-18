package com.example.ssoshiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssoshiro.common.User;
import com.example.ssoshiro.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsoShiroApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        User user=new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(user);
        User userDB = (User) userMapper.selectOne(queryWrapper);
        System.out.println(userDB);
    }

}
