package com.example.ssoshiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssoshiro.common.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper {
    Integer selectMessage(String uid);
}
