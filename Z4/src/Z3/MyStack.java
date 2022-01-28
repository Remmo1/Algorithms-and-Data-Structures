package Z3;

import Za1.OneWayLinkedList;

public class MyStack<T> {

    private final OneWayLinkedList<T> oneWayLinkedList;

    public MyStack() {
        oneWayLinkedList = new OneWayLinkedList<>();
    }

    public boolean isEmpty() {
        return oneWayLinkedList.isEmpty();
    }

    public void push(T elem) {
        oneWayLinkedList.insert(oneWayLinkedList.Size(), elem);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        T retVal = oneWayLinkedList.deletePos(oneWayLinkedList.Size()-1);
        return retVal;
    }

    public int Size() {
        return oneWayLinkedList.Size();
    }

    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        T retVal = oneWayLinkedList.get(oneWayLinkedList.Size()-1);
        return retVal;
    }
}
