package com.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/12/23
 */
public class LRUCache {
	LinkedList<Integer> list;
	Map<Integer, Integer> cache;
	int capacity;

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 0); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.list);
		System.out.println(lRUCache.cache);
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.list);
		System.out.println(lRUCache.cache);
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.list);
		System.out.println(lRUCache.cache);
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.list = new LinkedList<>();
		this.cache = new HashMap<>();
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			list.remove((Integer) key);
			list.addFirst(key);
			return cache.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.put(key, value);
			list.remove((Integer) key);
			list.addFirst(key);
		} else {
			cache.put(key, value);
			list.addFirst(key);
			if (capacity > list.size()) {
				int leastRecentlyUsed = list.removeLast();
				cache.remove(leastRecentlyUsed);
			}
		}
	}
}


