package CodingRush._02_Misc_Singleton;

public class SingletonInitOnDemand {
    private static class InnerClass {
        public static SingletonInitOnDemand instance = new SingletonInitOnDemand();
    }

    SingletonInitOnDemand() {}

    public static SingletonInitOnDemand getInstance() {
        return InnerClass.instance;
    }

}
