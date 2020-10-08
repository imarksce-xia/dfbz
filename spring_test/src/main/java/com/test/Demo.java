package com.test;

import com.config.Application;
import com.controller.UserController;
import com.dao.BaseDao;
import com.entity.User;
import com.service.HelloService;
import com.service.UserService;
import com.utils.DbUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin iMarksce
 * @date 2020/10/6
 * @Description
 */

@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = "classpath:application.xml")
@ContextConfiguration(classes = Application.class)
public class Demo {

    @Autowired
    private UserController userController;

    @Test
    public void method(){
        userController.add();
    }

    @Test
    public void method2(){
        userController.update();
    }
}
