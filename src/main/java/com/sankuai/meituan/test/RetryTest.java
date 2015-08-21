package com.sankuai.meituan.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;


@Configuration
@EnableRetry
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan
public class RetryTest {
//	@Bean
//    public Service1 service() {
//        return new Service1();
//    }

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RetryTest.class);
        final Service1 service1 = applicationContext.getBean(Service1.class);
        service1.service();
        applicationContext.close();
    }
}
