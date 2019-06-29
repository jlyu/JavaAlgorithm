package jav;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentHashMap {
    static class Table {
        private int i;
        public Table(int i) {
            this.i = i;
        }
        public int getI() {
            return i;
        }
        public void setI(int i) {
            this.i = i;
        }
    }

    private final static Map<String, Table> map = new ConcurrentHashMap<>();
    private static final String KEY = "key";

    public static void increase1(String key) {
        Table oldTable = map.get(key);
        int value = oldTable.getI();
        oldTable.setI(value + 1);
        map.put(key, oldTable);
    }

    public static void increase2(String key) {
        Table oldTable;
        Table newTable = new Table(0);
        while (true) {
            oldTable = map.get(KEY);
            newTable.setI(oldTable.getI() + 1);
            if (map.replace(KEY, oldTable, newTable)) break;
        }
    }

    public static int getTableValue(String key) {
        return map.get(key).getI();
    }

    public static void main(String[] args) {
        map.put(KEY, new Table(0));
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int callTime = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(callTime);
        for (int i = 0; i < callTime; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    increase1(KEY);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        //测试结果：使用 increase1 的话，调用次数是不停变动的，存在并发错误。而用 increase2 的话，恒定都是 1000.
        System.out.println("call times：" + getTableValue(KEY));
    }
}




