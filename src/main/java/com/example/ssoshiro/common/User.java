package com.example.ssoshiro.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain=true)	//链式结构
//@Component   //不加这个注解也没有问题
public class User {
    private String username;
    private String password;
}
