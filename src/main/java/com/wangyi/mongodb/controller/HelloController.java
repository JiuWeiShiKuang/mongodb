package com.wangyi.mongodb.controller;

import com.wangyi.mongodb.mongodb.dao.UserDao;
import com.wangyi.mongodb.mongodb.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    @ResponseBody
    public List getHello() {
        Page<User> userPages = userDao.findUserPagination(1, 5,"id");
        return userPages.getContent();
    }
}
