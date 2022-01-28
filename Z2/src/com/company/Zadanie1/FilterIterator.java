package com.company.Zadanie1;

import java.util.Iterator;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {

    Iterator <T> iterator;
    Predicate <T> predicate;

    public FilterIterator(Iterator <T> iterator, Predicate <T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        T element;
        if (hasNext()) {
            element = iterator.next();
            if (predicate.test(element))
                return element;
        }
        return null;
    }
}
