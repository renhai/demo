package com.sankuai.meituan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertTest {

    private static String configLocation = "classpath:applicationContext-jdbc.xml";  
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);  
	
    
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql = "insert into collect(title, info, vtype) values(?,?,?)";
//		List<Object[]> list = new ArrayList<Object[]>();
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			String title = RandomStringUtils.randomAlphanumeric(100);
			String info = RandomStringUtils.randomAlphanumeric(1024);
			int vtype = random.nextInt(5);
//			list.add(one);
			int result = jdbcTemplate.update(sql, title, info, vtype);
			System.out.println(result);
		}
//		System.out.println("begin insert....");
//		jdbcTemplate.batchUpdate(sql, list);
//		System.out.println("end");
	}

}
