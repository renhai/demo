package com.sankuai.meituan.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 5922385157987923193L;

	private int capacity;  
	
	public LRUCache(int capacity) {
		// 调用LinkedHashMap的构造器，传入以下参数
		super(16, 0.75f, true);
		// 传入指定的缓存最大容量
		this.capacity = capacity;
	}

	// 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//		System.out.println(eldest.getKey() + "=" + eldest.getValue());
		return size() > capacity;
	}
}
