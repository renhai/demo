package com.sankuai.meituan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBTest {
    private static String configLocation = "classpath:applicationContext-jdbc.xml";  
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);  
	
    public static void main(String[] args) {
    	MeituanService a = ctx.getBean(MeituanService.class);
    	a.getIdList();
//    	a.insert();
	}
    


	public String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}

}
