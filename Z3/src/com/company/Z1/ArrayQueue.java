package com.company.Z1;

public class ArrayQueue<T> implements IQueue<T> {

    private final T[] array;
    private final int beginIndex;
    private int endIndex;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        array = (T[]) new Object[size];
        beginIndex = 0;
        endIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return beginIndex == endIndex;
    }

    @Override
    public boolean isFull() {
        return endIndex == array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        T retValue = array[beginIndex];
        if (endIndex - 1 >= 0) System.arraycopy(array, 1, array, 0, endIndex - 1);
        endIndex--;
        return retValue;
    }

    @Override
    public void enqueue(T element) throws FullQueueException {
        if (isFull())
            throw new FullQueueException();
        array[endIndex++] = element;
    }

    @Override
    public int size() {
        return endIndex;
    }

    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty())
            throw  new EmptyQueueException();
        return array[beginIndex];
    }

    public T top() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        return array[endIndex-1];
    }

    public T get(int index) throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        if (index > endIndex || index < 0)
            throw new IndexOutOfBoundsException();
        return array[index-1];
    }

}
