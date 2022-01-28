package com.company.Z2;

public class DynamicStack<T> implements IStack<T> {

    private T[] array;
    private int topIndex;
    private int actualSize;

    @SuppressWarnings("unchecked")
    public DynamicStack(int size) {
        array = (T[]) new Object[size];
        topIndex = 0;
        actualSize = size;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        T returnValue = array[--topIndex];

        if ( topIndex == 0.25 * actualSize ) {
            actualSize *= 0.5;
            array = (T[]) new Object[actualSize];
        }


        return returnValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void push(T element) {
        array[topIndex++] = element;

        if ( topIndex == 0.75 * actualSize) {
            actualSize *= 2;
            array = (T[]) new Object[actualSize];
        }
    }

    @Override
    public int size() {
        return topIndex;
    }

    public int MaxSize() {
        return actualSize;
    }

    @Override
    public T top() {
        return null;
    }
}
