package me.renhai.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    private Map<Integer, Entry> cache = new HashMap<>();
    private PriorityQueue<Entry> heap;
    private int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        heap = new PriorityQueue<Entry>(new Comparator<Entry>() {
            public int compare(Entry e1, Entry e2) {
                if (e1.freq != e2.freq) {
                    return Integer.compare(e1.freq, e2.freq);
                } else {
                    return Long.compare(e1.time, e2.time);
                }
            }
        });
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Entry curr = cache.get(key);
        heap.remove(curr);
        
        curr.time = System.nanoTime();
        curr.freq ++;
        
        heap.offer(curr);
        return curr.value;
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Entry curr = cache.get(key);
            heap.remove(curr);

            curr.time = System.nanoTime();
            curr.freq ++;
            curr.value = value;
            
            heap.offer(curr);
        } else {
        	if (cache.size() == capacity) {
        		Entry evict = heap.poll();
        		cache.remove(evict.key);
        	}
            Entry entry = new Entry(key, value);
            cache.put(key, entry);
            heap.offer(entry);
//            System.out.println(heap);
        }
    }
    
    public static void main(String[] args) {
    	LFUCache obj = new LFUCache(2);
    	obj.set(1, 1);
    	obj.set(2, 2);
    	System.out.println(obj.get(1));
    	obj.set(3, 3);
    	System.out.println(obj.get(2));
    	System.out.println(obj.get(3));
    	obj.set(4, 4);
    	System.out.println(obj.get(1));
    	System.out.println(obj.get(3));
    	System.out.println(obj.get(4));

	}
}

class Entry {
    int key;
    int value;
    int freq;
    long time;
    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
        this.time = System.nanoTime();
        this.freq = 1;
    }
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + ", freq=" + freq + ", time=" + time + "]";
	}
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */