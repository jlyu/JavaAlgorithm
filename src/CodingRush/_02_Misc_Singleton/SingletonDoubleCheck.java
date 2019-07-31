package CodingRush._02_Misc_Singleton;

public class SingletonDoubleCheck {
    public static volatile SingletonDoubleCheck instance = null;

    private SingletonDoubleCheck() {}

    public static SingletonDoubleCheck getInstance() {
        if (instance != null) {
            synchronized(SingletonDoubleCheck.class) {
                if (instance != null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}