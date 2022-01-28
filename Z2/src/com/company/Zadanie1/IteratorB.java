package com.company.Zadanie1;

import java.util.NoSuchElementException;

public class IteratorB<T> implements Iterator1B<T>{

    private final T[] students;
    private int position;

    public IteratorB(T[] array) {
        this.students = array;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public void next() {
        if (!isDone())
            position++;
        else
            throw new NoSuchElementException();
    }

    @Override
    public boolean isDone() {
        return position <= students.length;
    }

    @Override
    public T currentItem() {
        if (!isDone())
            return students[position];
        else
            throw new NoSuchElementException();
    }
}
