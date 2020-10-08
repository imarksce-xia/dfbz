package com.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author admin iMarksce
 * @date 2020/10/6
 * @Description
 */
//@Service
//@Scope("prototype")
public class HelloService {

    @PostConstruct
    public void method() {
        System.out.println("初始化了！");
    }

    public void say() {
        System.out.println("hello word");
    }

    @PreDestroy
    public void method2() {
        System.out.println("销毁了！");
    }

}
