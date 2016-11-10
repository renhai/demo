package me.renhai.oj;

public class TwoArrayIntersection {

	public static void main(String[] args) {
		//求两个数组的交集
		int[] a = {1,2,4,5};
		int[] b = {2,4,5,6,7};
		
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] == b[j]) {
				System.out.println(a[i]);
				i++;
				j++;
			} else {
				j++;
			}
		}
	}
	
	

}
