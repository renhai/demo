package com.sankuai.meituan.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("applicationContext-jdbc.xml")
public class ConfigurationTest {

	public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
//        applicationContext.register(ConfigurationTest.class);
//        applicationContext.refresh();
        
    	MeituanService a = applicationContext.getBean(MeituanService.class);
    	a.getIdList();
    	applicationContext.close();
	}

}
