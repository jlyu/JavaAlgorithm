package MultiThread.Future;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") Start");

        final FutureData futrue = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(count, c);
            futrue.setRealData(realData);
        }).start();

        System.out.println("    request(" + count + ", " + c + ") End");
        return futrue;
    }
}
