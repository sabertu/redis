package com.itheima;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void testFindAll() throws JsonProcessingException {
        //1.先从redis中获得数据,数据的形式json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        //2.判断redis中是否存在数据
        if(null==userListJson){
            //3.不存在数据，从数据库查询
            List<User> userList = userRepository.findAll();
            //转换成json格式字符串
            ObjectMapper objectMapper=new ObjectMapper();
            userListJson=objectMapper.writeValueAsString(userList);
            //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("=========从数据库获取user对象=================");
        }else{
            System.out.println("=========从redis缓存获取user对象=================");
        }
        //4.将数据在控制台打印
        System.out.println(userListJson);
    }
}
