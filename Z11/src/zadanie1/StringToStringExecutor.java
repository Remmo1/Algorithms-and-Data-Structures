package zadanie1;

public class StringToStringExecutor  {
    StringBuilder stringBuilder = new StringBuilder();

    public void execute(String elem) {
        stringBuilder.append(elem).append("; ");
    }

    public String getResult() {
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        return stringBuilder.toString();
    }
}

