package com.sankuai.meituan.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.UUID;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;


public class AndyTest {

	public static void main(String[] args) {
		String foo = "45";
		String bar = "1234";
		int maxlength = Math.max(foo.length(), bar.length());
		int distance = StringUtils.getLevenshteinDistance(foo, bar);
		System.out.println(foo + "\t" + bar);
//		System.out.println(distance);
//		System.out.println(1 - (double)distance / (double)maxlength);
		
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
		
		System.out.println(UUID.randomUUID());
		
		Integer userId = 143134;
		System.out.println(Integer.toHexString(userId));
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		Date end = getMondayOfWeek(cal.getTime());
		System.out.println(end);

		String A = "啊全聚德烤鸭操作";
		String B = "望京全聚德地方操作";
		String commonString = ListUtils.longestCommonSubsequence(A, B);
		System.out.println(commonString);
		int lcs = commonString.length();
		int ld = StringUtils.getLevenshteinDistance(A, B);
//		S(A,B)=LCS(A,B)/(LD(A,B)+LCS(A,B))
//		http://www.cnblogs.com/grenet/archive/2010/06/04/1751147.html
		
		float sim = (float)lcs / (ld + lcs);
		System.out.println(sim);
		
		int processCount = Runtime.getRuntime().availableProcessors();
		System.out.println(processCount);
		
		
		Bike bike = new Bike.Builder().price(12).size(122).build();
		System.out.println(bike);
		
		/*
		File imageFile = new File("/Users/andy/Downloads/PicCheckCode1.jpg");  
		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping 
//		instance.setDatapath("/Users/andy/tesseract-ocr/");
//		System.setProperty("TESSDATA_PREFIX", "/Users/andy/tesseract-ocr/");
//		instance.setOcrEngineMode(TessOcrEngineMode.OEM_DEFAULT);
		instance.setLanguage("eng");
		
//		BufferedImage textImage = ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(panel.image, startX, startY, endX, endY));
		// 图片锐化,自己使用中影响识别率的主要因素是针式打印机字迹不连贯,所以锐化反而降低识别率
		// textImage = ImageHelper.convertImageToBinary(textImage);
		// 图片放大5倍,增强识别率(很多图片本身无法识别,放大5倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大5倍)
//		textImage = ImageHelper.getScaledInstance(textImage, endX * 5, endY * 5);
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		*/
		
		List<String> list = new ArrayList<String>();
		list.add("asdfa");	
		System.out.println(StringUtils.join(list, "&"));
		
		Multiset<Integer> set = HashMultiset.create();
		set.add(15);
		set.add(12);
		set.add(12);
		set.add(12);
		set.add(13);
		set.add(14);
		set.add(13);
		for (Integer type : Multisets.copyHighestCountFirst(set).elementSet()) {
		    System.out.println(type + ": " + set.count(type));
		}
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
		}
		
		System.out.println( 8 & 7);
		
    	System.out.println(RandomStringUtils.randomAlphanumeric(20));
    	
    	System.out.println(StringUtils.removeEnd("23,343,4,34,", ">"));
    	
    	System.out.println(StringUtils.replaceOnce("1211112223", "4", "*"));
    	
    	JSONObject json = new JSONObject();
    	Person ppp = new Person();
    	ppp.setId(3224);
    	json.put("p", ppp);
    	Person ddd = json.getObject("p", Person.class);
    	
    	ddd.setId(32432);
    	System.out.println(json.get("p"));
    	
    	System.out.println(NumberUtils.toInt(""));
    	System.out.println(Locale.ROOT);
    	
    	System.out.println(BooleanUtils.toBoolean(0));
    	
	}
	
    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
	
	
    public static Date getMondayOfWeek(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        return cal.getTime();  
    } 
	

}
