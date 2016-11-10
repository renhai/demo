package me.renhai.oj;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 * 0.1 < 1.1 < 1.2 < 1.12 < 13.37
 * @author andy
 *
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
//		System.out.println("2".compareTo("12"));
//		System.out.println(Integer.valueOf(2).compareTo(Integer.valueOf(12)));
//		System.out.println(Integer.valueOf("0.12.12".replace(".", "")));
//		System.out.println("12.0000".replaceAll("\\.0+$", ""));
		
		System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
		System.out.println(new CompareVersionNumbers().compareVersion("1.1", "1.0"));
		System.out.println(new CompareVersionNumbers().compareVersion("0.1", "1.0"));
		System.out.println(new CompareVersionNumbers().compareVersion("0.1", "0.12"));
		System.out.println(new CompareVersionNumbers().compareVersion("0.1", "0.1"));
		System.out.println(new CompareVersionNumbers().compareVersion("0.9.9.9.9.9.9.9.9.9.9.9.9", "1.0"));
	}
	
	//"0.9.9.9.9.9.9.9.9.9.9.9.9", "1.0"
	//"1.9.0" "1.991"
	//"1.0", "1"
	//"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0", 
	//"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	int maxlen = Math.max(v1.length, v2.length);
    	for (int i = 0; i < maxlen; i++) {
    		Integer value1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
    		Integer value2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
			if (value1.equals(value2)) {
				continue;
			} else {
				return value1.compareTo(value2);
			}
		}
    	return 0;
    }

}
