package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//声明该类是一个spring boot的引导类
@SpringBootApplication
public class MySpringBootApplication {
    //main是java程序入口
    public static void main(String[] args) {
        //run方法 表示运行spring boot的引导类,run参数就是springboot引导类字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }
}
