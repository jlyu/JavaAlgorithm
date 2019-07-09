package MultiThread.ActiveObject;

public class MakeStringRequest extends MethodRequest<String> {

    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, FutureResult<String> futrue, int count, char fillchar) {
        super(servant, futrue);
        this.count = count;
        this.fillchar = fillchar;
    }

    @Override
    public void execute() {
        Result<String> result = servant.makeString(count, fillchar);
        future.setResult(result);
    }
}
