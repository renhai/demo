package com.sankuai.meituan.test;

import java.lang.reflect.Method;

public class NullRetryInterceptor {
	public void parse(Class clazz) throws Exception {
	      Method[] methods = clazz.getMethods();
	      for (Method method : methods) {
	         if (method.isAnnotationPresent(NullRetry.class)) {
	        	NullRetry nr = method.getAnnotation(NullRetry.class);
	            int maxAttempt = nr.maxAttempt();
	            Object instance = clazz.newInstance();
	            Object res = null;
            	for (int i = 0; i < maxAttempt; i ++) {
            		res = method.invoke(instance, "", "");
            		if (res != null) {
            			break;
            		} else {
            			System.out.println("retry " + (i + 1) + " time(s)");
            		}
            	}
	            if (res == null) {
	            	throw new Exception("result is null");
	            } else {
	            	System.out.println("result is " + res);
	            }
	            
	         }
	      }
	   }
	
}
