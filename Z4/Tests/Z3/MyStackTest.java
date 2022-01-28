package Z3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<Integer> myStack;

    @BeforeEach
    public void setUp() {
        myStack = new MyStack<>();
    }

    @Test
    public void isThrowingExceptions() {
        assertThrows(
                EmptyStackException.class,
                () -> myStack.pop()
        );

        assertThrows(
                EmptyStackException.class,
                () -> myStack.top()
        );
    }

    @Test
    public void isPushingAndPopingWorking() throws EmptyStackException {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        assertEquals(myStack.top(), 3);
        assertEquals(myStack.pop(), 3);
        assertEquals(myStack.pop(), 2);
        assertEquals(myStack.pop(), 1);
    }

    @Test
    public void isSizeWorking() throws EmptyStackException {
        assertEquals(0, myStack.Size());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.Size());

        myStack.pop();
        myStack.pop();
        assertEquals(1, myStack.Size());

    }

}