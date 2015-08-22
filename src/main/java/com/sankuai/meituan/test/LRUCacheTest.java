package com.sankuai.meituan.test;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;

public class LRUCacheTest {

	public static void main(String[] args) {
		ConcurrentLinkedHashMap<Integer, Integer> map = new ConcurrentLinkedHashMap.Builder<Integer, Integer>()
				.maximumWeightedCapacity(2).weigher(Weighers.singleton())
				.build();
		map.put(1, 1);  
		map.put(2, 2);  
		map.put(3, 3);  
		System.out.println(map);
		System.out.println(map.get(1));  
		System.out.println(map.get(2)); 
		map.put(4, 4);
		System.out.println(map);
		
		System.out.println("---------------------------");
		
		LRUCache<Integer, Integer> map2 = new LRUCache<Integer, Integer>(2);
		map2.put(1, 1);  
		map2.put(2, 2);  
		map2.put(3, 3);  
		System.out.println(map2);
		System.out.println(map2.get(1));  
		System.out.println(map2.get(2)); 
		map2.put(4, 4);
		System.out.println(map2);
	}

}
