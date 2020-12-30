package com.wangyi.mongodb;

import com.wangyi.mongodb.mongodb.dao.UserDao;
import com.wangyi.mongodb.mongodb.demo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Description:
 * @author: wy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

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
    public void saveUserTable(){
        User user = new User();
        user.setId((long)100);
        user.setPassword("1233231");
        user.setUserName("王五");
        userDao.saveUserTable(user);
    }

    @Test
    public void findUserByUserName() {
        User user = userDao.findUserByUserName("hollysys_");
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(new Long(100));
        user.setUserName("hollysys_0");
        user.setPassword("123456?");
        userDao.updateUser(user);

    }

    @Test
    public void deleteUser() {
        userDao.deleteUserById(new Long(101));
    }

    @Test
    public void findUserPagination() {
        Page<User> userPages = userDao.findUserPagination(1, 5,"id");
        userPages.forEach(u -> {
            System.out.println(u);
        });
    }
}
