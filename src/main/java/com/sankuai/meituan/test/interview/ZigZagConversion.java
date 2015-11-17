package com.sankuai.meituan.test.interview;

/**
 * 
 * @author andy
 * 
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String res = new ZigZagConversion().convert("PAYPALISHIRING", 3);
		System.out.println(res);
	}
	
	/**
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * @param s
	 * @param numRows
	 * @return
	 */
    public String convert(String s, int numRows) {
    	StringBuilder[] strArr = new StringBuilder[numRows];
    	for (int i = 0; i < strArr.length; i++) {
			strArr[i] = new StringBuilder();
		}
    	for (int i = 0; i < s.length();) {
    		for (int j = 0; j < numRows && i < s.length(); j++) {
				strArr[j].append(s.charAt(i ++));
			}
    		for (int j = numRows - 2; j > 0 && i < s.length(); j --) {
				strArr[j].append(s.charAt(i ++));
    		}
		}
    	StringBuilder result = new StringBuilder();
    	for (int i = 0; i < strArr.length; i++) {
			result.append(strArr[i]);
		}
    	return result.toString();
    }

}
