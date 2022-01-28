package com.company;

import com.company.Z1.ArrayQueue;
import com.company.Z1.EmptyQueueException;
import com.company.Z1.FullQueueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    ArrayQueue<Integer> arrayQueue;

    @BeforeEach
    public void SetUp() {
        arrayQueue = new ArrayQueue<>(4);
    }

    @Test
    public void IsEmptyQueueExceptionWorking() {
        assertThrows(
                EmptyQueueException.class,
                () -> arrayQueue.dequeue()
        );
    }

    @Test
    public void IsFullQueueExceptionWorking() throws FullQueueException {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);

        assertThrows(
                FullQueueException.class,
                () -> arrayQueue.enqueue(5)
        );
    }

    @Test
    public void IsSizeWorking() throws FullQueueException, EmptyQueueException {
        assertEquals(0, arrayQueue.size());

        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        assertEquals(2, arrayQueue.size());

        arrayQueue.dequeue();
        assertEquals(1, arrayQueue.size());
    }

    @Test
    public void IsEnqueAndDequeWorking() throws FullQueueException, EmptyQueueException {
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        int a = arrayQueue.dequeue();
        assertEquals(a, 1);

        int b = arrayQueue.dequeue();
        assertEquals(b, 2);

    }
}