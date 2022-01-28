package Z3;

import Za1.OneWayLinkedList;

public class MyQueue<T> {

    private final OneWayLinkedList<T> oneWayLinkedList;

    public MyQueue() {
        oneWayLinkedList = new OneWayLinkedList<>();
    }

    public boolean isEmpty() {
        return oneWayLinkedList.isEmpty();
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        T retVal = oneWayLinkedList.deletePos(0);
        return retVal;
    }

    public void enqueue(T elem) {
        oneWayLinkedList.insert(oneWayLinkedList.Size(), elem);
    }

    public int Size() {
        return oneWayLinkedList.Size();
    }

    public T first() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        return oneWayLinkedList.get(0);
    }
}
