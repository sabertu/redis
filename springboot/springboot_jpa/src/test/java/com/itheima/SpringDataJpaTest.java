package com.itheima;
import com.itheima.domain.User;
import com.itheima.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@SpringBootTest(classes = SpringbootJpaApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDataJpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
