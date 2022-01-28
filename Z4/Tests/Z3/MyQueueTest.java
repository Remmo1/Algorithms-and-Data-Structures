package Z3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue <Integer> myQueue;

    @BeforeEach
    public void setUp() {
        myQueue = new MyQueue<>();
    }

    @Test
    public void isThrowingExceptions() {
        assertThrows(
                EmptyQueueException.class,
                () -> myQueue.dequeue()
        );


        assertThrows(
                EmptyQueueException.class,
                () -> myQueue.first()
        );
    }

    @Test
    public void isEnqueueAndDequeueWorking() throws EmptyQueueException{
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        assertEquals(myQueue.first(), 1);
        assertEquals(myQueue.dequeue(), 1);
        assertEquals(myQueue.dequeue(), 2);
        assertEquals(myQueue.dequeue(), 3);
    }

    @Test
    public void isSizeWorking() throws EmptyQueueException {

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        assertEquals(3, myQueue.Size());

        myQueue.dequeue();
        myQueue.dequeue();
        assertEquals(1, myQueue.Size());
    }
}