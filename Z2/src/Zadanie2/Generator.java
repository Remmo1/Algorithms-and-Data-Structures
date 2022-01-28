package Zadanie2;


import java.util.NoSuchElementException;

public class Generator implements Iterator1BINT {

    private final int start;
    private final int end;
    private int position;

    public Generator(int start, int end) {
        this.start = start;
        this.end = end;
        first();
    }

    @Override
    public void first() {
         position = start;
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
        return position > end;
    }

    @Override
    public int currentItem() {
        if (!isDone()) {
            return position;
        }
        return 0;
    }
}
