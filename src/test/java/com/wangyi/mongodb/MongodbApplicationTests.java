package com.wangyi.mongodb;

import com.wangyi.mongodb.mongodb.dao.UserDao;
import com.wangyi.mongodb.mongodb.demo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void saveUser() {
        User user = new User();
        for (int i = 0; i < 100; i++) {
            user.setId((long) (100 + i));
            user.setUserName("hollysys_" + i);
            user.setPassword("123456a?");
            userDao.saveUser(user);
            System.out.println("insert:" + i);
        }
    }

    @Test
    void contextLoads() {
    }

}
