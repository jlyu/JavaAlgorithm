package MultiThread.Singleton;

//@ThreadSave
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {}

    // 考虑到可能存在多线程访问 getInstance 方法，
    // 这里需要加上 synchronized 关键字做互斥处理，确保实例是唯一的
    // 但是这样性能并不好，也是因为 synchronized 关键字，每次进入都要加锁，释放锁
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
