package com.hcr.aspect;

import com.hcr.model.User;
import com.hcr.service.UserService;
import com.hcr.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

    private ApplicationContext ioc;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("classpath:application-spring.xml");
    }

    @Test
    public void test01() throws Exception {
        UserService userService = ioc.getBean(UserService.class);
        userService.add(new User(1,""));
    }

}
