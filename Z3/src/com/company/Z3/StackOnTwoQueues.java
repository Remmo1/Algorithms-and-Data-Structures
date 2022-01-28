package com.company.Z3;

import com.company.Z1.ArrayQueue;
import com.company.Z1.EmptyQueueException;
import com.company.Z1.FullQueueException;
import com.company.Z1.IQueue;
import com.company.Z2.EmptyStackException;
import com.company.Z2.FullStackException;
import com.company.Z2.IStack;

public class StackOnTwoQueues<T> implements IStack<T> {

    private final IQueue<T> iQueue;
    private final IQueue <T> iQueue2;
    private int topIndex;

    public StackOnTwoQueues(int size) {
        iQueue = new ArrayQueue<>(1);
        iQueue2 = new ArrayQueue<>(size-1);
        topIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return iQueue.isEmpty();
    }

    public boolean isFull() {
        return iQueue2.isFull();
    }

    @Override
    public T pop() throws EmptyStackException, EmptyQueueException {
        if (isEmpty())
            throw new EmptyStackException();

        if (topIndex == 1) {
            try {
                return iQueue.dequeue();
            } catch (EmptyQueueException e) {
                e.printStackTrace();
            }
        }

        --topIndex;

        return iQueue2.get(topIndex);
    }



    @Override
    public void push(T elem) throws FullStackException {

        if (isFull())
            throw new FullStackException();

        if (topIndex == 0) {
            topIndex++;
            try {
                iQueue.enqueue(elem);
                return;
            } catch (FullQueueException e) {
                e.printStackTrace();
            }
        }

        topIndex++;

        try {
            iQueue2.enqueue(elem);
        } catch (FullQueueException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException, EmptyQueueException {
        if (isEmpty())
            throw new EmptyStackException();

        if (topIndex == 1) {
            try {
                return iQueue.dequeue();
            } catch (EmptyQueueException e) {
                e.printStackTrace();
            }
        }

        return iQueue2.dequeue();
    }
}
