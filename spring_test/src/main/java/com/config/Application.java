package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
@Configuration
@ComponentScan(value = "com")
@PropertySource(value = "db.properties")
@EnableAspectJAutoProxy
public class Application {
}
