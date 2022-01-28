package com.company.Zadanie1;

import java.util.function.Predicate;

public class FilterB<T> implements Iterator1B<T>{

    private final Iterator1B <T> iterator;
    private final Predicate <T> predicate;

    public FilterB(Iterator1B <T> iterator, Predicate <T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public void first() {
        iterator.first();
    }

    @Override
    public void next() {
        iterator.next();
    }

    @Override
    public boolean isDone() {
        return iterator.isDone();
    }

    @Override
    public T currentItem() {
        T element;
        if (!isDone()) {
            element = iterator.currentItem();
            if (predicate.test(element))
                return element;
        }
        return null;
    }
}
