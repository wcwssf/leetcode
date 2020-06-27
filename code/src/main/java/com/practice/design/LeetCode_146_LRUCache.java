package com.practice.design;

import java.util.LinkedHashMap;

/**
 * @author: wang wei chao
 * @description: TODO
 * @date: 2020/6/16 10:20 下午
 * @version: 1.0.0
 */
public class LeetCode_146_LRUCache {

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lruCache = new LRUCache(capacity);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    static class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new LinkedHashMap<>(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer val = map.get(key);
            if (val == null) {
                return -1;
            }
            return val;
        }

        public void put(int key, int value) {
            if (map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
//            if (map.size() > capacity) {
//                map.remove(map.keySet().iterator().next());
//            }
        }
    }
}
