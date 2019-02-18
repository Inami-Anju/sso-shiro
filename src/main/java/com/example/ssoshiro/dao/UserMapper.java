package com.example.ssoshiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssoshiro.common.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 *
 *
 * ************************************************************
 * 这里必须指定泛型，否则无法绑定
 *
 * ************************************************************
 *
 *
 */
public interface UserMapper extends BaseMapper<User> {
    Integer selectMessage(String uid);
}
