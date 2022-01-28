package com.company.Z3;

import com.company.Z1.EmptyQueueException;
import com.company.Z2.EmptyStackException;
import com.company.Z2.FullStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackOnTwoQueuesTest {

    StackOnTwoQueues<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new StackOnTwoQueues<>(4);
    }

    @Test
    public void isThrowingEmptyStackError() {
        assertThrows(
                EmptyStackException.class,
                () -> stack.pop()
        );

        assertThrows(
                EmptyStackException.class,
                () -> stack.top()
        );
    }

    @Test
    public void isThrowingFullStackError() throws FullStackException {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertThrows(
                FullStackException.class,
                () -> stack.push(5)
        );
    }

    @Test
    public void isPopAndPushWorking() throws FullStackException, EmptyStackException, EmptyQueueException {

        stack.push(1);
        stack.push(2);
        stack.push(3);


        int a = stack.pop();
        assertEquals(a,3);

        int b = stack.pop();
        assertEquals(b, 2);

        int c = stack.pop();
        assertEquals(c, 1);
    }

}