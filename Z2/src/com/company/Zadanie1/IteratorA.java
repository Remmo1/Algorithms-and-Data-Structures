package com.company.Zadanie1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorA<T> implements Iterator<T> {

    private final T[] students;
    private int position;

    public IteratorA(T[] array) {
        this.students = array;
    }

    @Override
    public boolean hasNext() {
        return position < students.length;
    }

    @Override
    public T next() {
        if (hasNext())
            return students[position++];
        else
            throw new NoSuchElementException();
    }
}
