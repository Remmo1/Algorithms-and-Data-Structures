package zadanie1;

public interface IExecutor<T> {
    void execute (T elem);
    T getResult();
}
