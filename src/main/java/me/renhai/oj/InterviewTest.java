package me.renhai.oj;

import java.util.List;

public class InterviewTest {

	public static void main(String[] args) {
        Integer m = 100;
        Integer n = 100;
        System.out.println(m == n);
        Integer i = 1000;
        Integer j = 1000;
        System.out.println(i == j);
        
        Integer x = 1001;
        Integer y = 1001;
        System.out.println(x == y);
        x = 1000;
        y = 1000;
        System.out.println(x == y);
        
        x = new Integer(100);
        y = new Integer(100);
        System.out.println(x == y);
        
        Integer q = new Integer(1);
        Integer p = 1;
        System.out.println(q == p);
	}
	
//	public static void fun(List<Integer> list) {
//		
//	}
//	
//	public static void fun(List<String> list) {
//		
//	}

}
