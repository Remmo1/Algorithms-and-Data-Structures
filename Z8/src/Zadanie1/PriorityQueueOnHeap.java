package Zadanie1;

import java.util.Arrays;
import java.util.Random;

public class PriorityQueueOnHeap {

    private final int[] t;
    private int size;

    public PriorityQueueOnHeap(int Size) {
        t = new int[Size];
        Random r = new Random();
        int a;

        for (int i = 0; i < Size; i++) {
            a = r.nextInt(100);
            this.enqueue(a);
        }
        size = Size;
    }

    public void enqueue(int value) {
        t[size] = value;
        size++;
        swim(size - 1);
    }

    public void clear() {
        Arrays.fill(t, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return t.length == size;
    }

    public int first() {
        if (size == 0)
            return -1;
        return t[0];
    }

    public int dequeue()  {
        if (size == 0)
            return -1;

        int result = t[0];
        if (size > 1) {
            t[0] = t[size-1];
            sink(0);
        }

        t[size-1] = 0;
        size--;

        return result;
    }

    private void swap(int index1, int index2) {
        int temp = t[index1];
        t[index1] = t[index2];
        t[index2] = temp;
    }

    private void swim(int index) {
        int parent;
        while (index != 0 &&
                t[index] > t[ (index - 1) / 2 ] ) {
            parent = (index - 1) / 2;
            swap(index, parent);
            index = parent;
        }
    }

    private void sink(int index) {
        boolean isDone = false;
        int child;
        while (!isDone && (child = 2 * index + 1) < t.length) {
            if (child < t.length - 1 &&
                    t[child] < t[child + 1] )
                ++child;
            if ( t[index] < t[child])
                swap(index, child);
            else isDone = true;
        }
    }

    public void show() {
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
        System.out.println();
    }

    public void changePriority(int newPriority, int index) {
        if (index < 0)
            return;
        t[index] = newPriority;
        swim(index);
    }

    public int removeIndex(int index) {
        if (index < 0)
            return -1;

        int retValue = t[index];
        swap(index, size-1);

        t[size-1] = 0;
        size--;

        sink(index);
        return retValue;
    }
}
