package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
@Mapper标记该类是一个mybatis的mapper接口，
可以被spring boot自动扫描到spring上下文中
 */
@Mapper
public interface UserMapper {
   public List<User> queryUserList();
}
