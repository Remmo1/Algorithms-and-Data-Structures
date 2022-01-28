package com.company.Z1;

public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue() throws EmptyQueueException;
    void enqueue(T element) throws FullQueueException;
    int size();
    T first() throws EmptyQueueException;
    T top() throws EmptyQueueException;
    T get(int index) throws EmptyQueueException;
}
