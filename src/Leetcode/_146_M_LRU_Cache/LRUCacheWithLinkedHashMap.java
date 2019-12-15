package Leetcode._146_M_LRU_Cache;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {

    public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = 6802031150943192407L;
        private int capacity;

        LRULinkedHashMap(int capacity) {
            super(16, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > this.capacity;
        }
    }

    private LRULinkedHashMap<Integer, Integer> lruCache;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.lruCache = new LRULinkedHashMap(capacity);
    }

    public int get(int key) {
        return this.lruCache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.lruCache.put(key, value);
    }

    /////////////////////////////////////////////////////////////////////////
    public void unittest1() {
        LRUCacheWithLinkedHashMap cache = new LRUCacheWithLinkedHashMap( 2  );
        cache.put(1, 1);
        cache.put(2, 2);
        int r1 = cache.get(1);       // returns 1
        cache.put(3, 3);                                       // evicts key 2
        int r2 = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);                                       // evicts key 1
        int r3 = cache.get(1);       // returns -1 (not found)
        int r4 = cache.get(3);       // returns 3
        int r5 = cache.get(4);       // returns 4
        int[] arr = {r1, r2, r3, r4, r5}; //[1, -1, -1, 3, 4]
        System.out.println(Arrays.toString(arr));
    }
    public void unittest2() {
        LRUCacheWithLinkedHashMap cache = new LRUCacheWithLinkedHashMap( 2  );
        cache.put(2, 1);
        cache.put(2, 2);
        int r1 = cache.get(2);       // returns 2
        cache.put(1, 1);
        cache.put(4, 1);                                       // evicts key 2
        int r2 = cache.get(2);       // returns -1 (not found)

        int[] arr = {r1, r2}; //[2, -1 ]
        System.out.println(Arrays.toString(arr));
    }
    public void unittest3() {
        LRUCacheWithLinkedHashMap cache = new LRUCacheWithLinkedHashMap( 2  );
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 1);
        int r1 = cache.get(1);       // returns -1
        int r2 = cache.get(2);       // returns 3 (not found)

        int[] arr = {r1, r2}; //[-1, 3 ]
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        LRUCacheWithLinkedHashMap a = new LRUCacheWithLinkedHashMap(0);
        a.unittest1();
        a.unittest2();
        a.unittest3();
    }

}
