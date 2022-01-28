package Za1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneWayLinkedListTest {
    OneWayLinkedList <Integer> list;

    @BeforeEach
    public void setUp() {
        list = new OneWayLinkedList<>();
    }

    @Test
    public void isThrowingExceptionWhenGettingFromEmptyList() {
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(0)
        );

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(10)
        );
    }

    @Test
    public void isinsertingAndRemovingWorking() {
        list.insert(0, 1);

        assertEquals(1, list.get(0));

        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);

        int a = list.deletePos(3);
        assertEquals(a, 4);

        list.deletePos(2);
        list.deletePos(1);
        list.deletePos(0);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.deletePos(0)
        );

        list.addEnd(1);
        list.addEnd(2);

        assertEquals(list.get(0), 1);
        assertEquals(list.deletePos(1), 2);
        list.clear();
    }

    @Test
    public void isSizeWorking() {
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);
        assertEquals(4, list.Size());

        list.deletePos(0);
        list.deletePos(1);
        assertEquals(2, list.Size());

        list.clear();
        assertEquals(0, list.Size());
    }

    @Test
    public void isContainsWorking() {
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);

        assertTrue(list.contains(2));
        assertTrue(list.contains(4));
        assertTrue(list.contains(1));
        assertFalse(list.contains(5));
    }

    @Test
    public void isSettingAndDeletingWorking() {

        // boolean delete(E e)
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);

        list.set(1,10);
        assertEquals(list.get(1), 10);

        list.delete(10);
        assertEquals(list.get(1), 3);

        list.delete(4);
        assertEquals(list.get(list.Size()-1), 3);
        list.clear();


        //E delete(Element e)
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);

        int a = list.deleteElem(new OneWayLinkedList.Element(4));
        assertEquals(a, 4);
        assertEquals(list.Size(),3 );

        int b = list.deleteElem(new OneWayLinkedList.Element<>(2));
        assertEquals(b, 2);
    }

    @Test
    public void Show() {
        list.addEnd(1);
        list.wyswietlListe();
        System.out.println();

        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.wyswietlListe();
        System.out.println();

        list.delete(3);
        list.wyswietlListe();
        System.out.println();
    }


}