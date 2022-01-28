package Z1;

public class IntegerToStringExecutor implements IExecutor<Integer, String> {
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void execute(Integer elem) {
        stringBuilder.append(elem).append("; ");
    }

    @Override
    public String getResult() {
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
