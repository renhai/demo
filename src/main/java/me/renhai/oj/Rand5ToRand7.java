package me.renhai.oj;

import java.util.Random;

public class Rand5ToRand7 {
	
	private static final Random random = new Random();

	public static void main(String[] args) {
		int count = 10000000;
		
		int[] stat = new int[7];
		for (int i = 0; i < count; i++) {
			stat[rand7()] ++;
		}
		
		for (int i = 0; i < stat.length; i++) {
			System.out.println(i + "-->" + stat[i]) ;
		}
	}

	private static int rand5() {
		return random.nextInt(5);
	}
	
	private static int rand7() {
		
//		while (true) {
//			int n = (rand5() % 2) * 4 + (rand5() % 2) * 2 + (rand5() % 2) * 1;
//			if (n == 0) {
//				continue;
//			}
//			return n - 1;
//		} 

//		return rand5() + rand5() % 3;
		
//		int s = 0;
//		for (int i = 0; i < 7; i++) {
//			s += rand5();
//		}
//		return s % 7;
		
		while (true) {
			int rand = 5 * rand5();
			rand = rand + rand5();
//			if (rand < 21) {
//				return rand % 7;
//			}
			if (rand < 7) {
				return rand;
			}
		}
		
	}
	
	private static int sum() {
//		int s = 0;
//		for (int i = 0; i < 7; i++) {
//			s += rand5();
//		}
//		return s;
		
		int rand = 5 * rand5();
		rand = rand + rand5();
		return rand;
	}
}
