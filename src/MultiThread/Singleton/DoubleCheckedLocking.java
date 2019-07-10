package MultiThread.Singleton;

public class DoubleCheckedLocking {
    // 这里加上 volatile 关键字很关键
    // 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
    private static volatile DoubleCheckedLocking instance = null;

    private DoubleCheckedLocking() {}

    public static DoubleCheckedLocking getInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
