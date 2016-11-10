package me.renhai.oj;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

	public static void main(String[] args) {
//		System.out.println(new BullsAndCows().getHint("1807", "7820"));
//		System.out.println(new BullsAndCows().getHint("1234", "0111"));
		System.out.println(new BullsAndCows().getHint("1122", "1222"));
	}
	
	public String getHint(String secret, String guess) {
	    int bulls = 0;
	    int cows = 0;
	    Map<Character, Integer> secretMap = new HashMap<>();
	    for (Character c : secret.toCharArray()) {
			secretMap.put(c, secretMap.get(c) == null ? 1 : secretMap.get(c) + 1);
		}
	    for (int i = 0; i < guess.length(); i++) {
			char g = guess.charAt(i);
			int val = secretMap.get(g) == null ? 0 : secretMap.get(g);
			if (g == secret.charAt(i)) {
				bulls ++;
				if (val <= 0) {
					cows --;
				}
			} else if (val > 0) {
                cows ++;
			}
			secretMap.put(g, val - 1);
		}
	    return bulls + "A" + cows + "B";
	}

}
