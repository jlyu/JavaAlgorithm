package Leetcode._146_M_LRU_Cache;


import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
                    it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4


https://leetcode-cn.com/problems/lru-cache
 */
public class LRUCache {

    public class Element {
        int key;
        int val;
        Element(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }

    private int capacity;
    private HashMap<Integer,Element> cache;
    private LinkedList<Element> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            // update list
            for (int i = 0; i < this.list.size(); i++) {
                if (key == this.list.get(i).key) {
                    Element ele = this.list.get(i);
                    this.list.remove(i);
                    this.list.add(ele);
                    break;
                }
            }
            return this.cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Element elm = this.cache.get(key);
            elm.val = value;
            // update list
            for (int i = 0; i < this.list.size(); i++) {
                if (key == this.list.get(i).key) {
                    Element ele = this.list.get(i);
                    this.list.remove(i);
                    this.list.add(ele);
                    break;
                }
            }
            return;
        }

        if (cache.size() >= this.capacity) {
            Element ele = this.list.getFirst();
            this.list.removeFirst();
            this.cache.remove(ele.key);
        }

        Element newElm = new Element(key, value);
        this.cache.put(key, newElm);
        this.list.add(newElm);
    }

    public void unittest1() {
        LRUCache cache = new LRUCache( 2  );
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
        LRUCache cache = new LRUCache( 2  );
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
        LRUCache cache = new LRUCache( 2  );
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
        LRUCache a = new LRUCache(0);
        a.unittest1();
        a.unittest2();
        a.unittest3();
    }
}
