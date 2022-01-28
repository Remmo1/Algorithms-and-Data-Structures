package com.company.Z2;

import com.company.Z1.EmptyQueueException;

public interface IStack<T> {
    boolean isEmpty();
    // boolean isFull(); nie potrzebne do stosu nieograniczonego
    T pop() throws EmptyStackException, EmptyQueueException;
    void push(T elem) throws FullStackException;
    int size();
    T top() throws EmptyStackException, EmptyQueueException;
}
