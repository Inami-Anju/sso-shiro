package com.example.ssoshiro.common;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain=true)	//链式结构
//@Component   //不加这个注解也没有问题
@TableName
public class User {
    @TableId
    private Long id;
    private String username;
    private String password;
    private Integer permission;
}
