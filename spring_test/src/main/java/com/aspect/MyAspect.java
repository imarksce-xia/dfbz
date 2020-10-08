package com.aspect;

import com.controller.UserController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author admin iMarksce
 * @date 2020/10/8
 * @Description
 */
@Aspect
@Component
public class MyAspect {

    Logger log= LoggerFactory.getLogger(UserController.class);

    @Around("execution(* com..service.*.add*(..))")
    public Object around(ProceedingJoinPoint around) throws Throwable {         //环绕通知
        Object proceed = around.proceed();          //执行目标方法
        log.info("添加");
        return proceed;                             //将目标方法的返回值返回
    }

    @Around("execution(* com..service.*.update*(..))")
    public Object around2(ProceedingJoinPoint around) throws Throwable {         //环绕通知
        Object proceed = around.proceed();          //执行目标方法
        log.info("修改了");
        return proceed;                             //将目标方法的返回值返回
    }

}
