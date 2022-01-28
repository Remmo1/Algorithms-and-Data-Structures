package Zadanie2;

import java.util.function.Predicate;

public class LiczbyPierwsze implements Iterator1BINT {

    Iterator1BINT iterator;
    Predicate<Integer> predicate;

    public LiczbyPierwsze(Iterator1BINT iterator, Predicate<Integer> predicate) {
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
    public int currentItem() {
        int liczba = iterator.currentItem();
        if (predicate.test(liczba)) {
            return liczba;
        }
        return 0;
    }
}
