package com.example.ssoshiro.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Accessors(chain=true)	//链式结构
//@Component   //不加这个注解也没有问题
@TableName("user")
public class User implements Serializable {
    @TableId(type= IdType.AUTO)	//主键自增
    private Long id;
    private String username;
    private String password;
    private Integer permission;
}
