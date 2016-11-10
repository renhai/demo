package me.renhai.oj;

public class ExcelSheetColumnSolution {

	public static void main(String[] args) {
		System.out.println((char)((int)'A' + 1));
		System.out.println((int)'a');
		System.out.println((int)'0');
    	StringBuilder sb = new StringBuilder();
    	sb.insert(0, 'A');
    	sb.insert(0, 'B');
    	System.out.println(sb.toString());
    	
    	System.out.println(new ExcelSheetColumnSolution().convertToTitle(52));
    	
    	System.out.println(new ExcelSheetColumnSolution().titleToNumber("AZ"));
    	
	}
	/**
	 * https://leetcode.com/problems/excel-sheet-column-title/
		1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	 * @param n
	 * @return
	 */
    public String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while (n > 0) {
    		n --;
			int y = n % 26;
			sb.insert(0, (char)('A' + y));
			n /= 26;
		}
    	return sb.toString();
    }
    
    /**
     * https://leetcode.com/problems/excel-sheet-column-number/
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
    	int res = 0;
    	for (int i = 0; i < s.length(); i++) {
//			res = res + (s.charAt(s.length() - i - 1) - 'A' + 1) * (int)Math.pow(26, i);
    		res = res * 26 + (s.charAt(i) - 'A' + 1);
		}
        return res;
    }

}
