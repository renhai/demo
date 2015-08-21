package com.sankuai.meituan.test.interview;

public class PrintLingxing {
	public static void main(String[] args) {
		lingxing(9);
	}
    public static void lingxing(int n) {
        for (int i = 0; i < n; i++) {
            if (i <= n / 2) {
                for (int j = 0; j < n; j++) {
                    if (j >= (n - 1) / 2 - i && j <= (n - 1) / 2 + i) {
                        System.out.print("*");
                    } else {
                        System.out.print("i");
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (j >= i - (n - 1) / 2 && j < (n - 1) / 2 + n - i) {
                        System.out.print("*");
                    } else {
                        System.out.print("j");
                    }
                }
            }
            System.out.print("\n");
        }
    }
}


