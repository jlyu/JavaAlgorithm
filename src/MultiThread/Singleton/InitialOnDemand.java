package MultiThread.Singleton;

public class InitialOnDemand {

    private static class InnerHolder { //嵌套内部静态类
        public static InitialOnDemand instance = new InitialOnDemand(); //类的初始化是线程安全的
    }

    private InitialOnDemand() {}

    public static InitialOnDemand getInstance() {
        return InnerHolder.instance;
    }
}
