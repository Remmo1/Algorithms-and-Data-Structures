package Za4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoWayLinkedListWithSentinelTest {
    TwoWayLinkedListWithSentinel<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new TwoWayLinkedListWithSentinel<>();
    }

    @Test
    public void areMethodsWorking() {
        assertTrue(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(list.indexOf(1), 1);
        assertTrue(list.contains(2));
    }

}