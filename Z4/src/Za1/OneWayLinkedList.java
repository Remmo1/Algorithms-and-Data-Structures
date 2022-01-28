package Za1;

public class OneWayLinkedList<E> {

    // węzeł:

    public static class Element<E> {
        E value;
        Element<E> next;

        public Element(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }



    // pierwszy
    private Element<E> first;
    private int size;

    public OneWayLinkedList() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // operacja o złożoności O(1)
    public int Size() {
        return size;
    }

    public E get(int pos) {
        if (isEmpty() || pos < 0) {
            throw new IndexOutOfBoundsException("index: " + pos);
        }

        int currentPos = pos;
        Element<E> actElem = first;

        while (currentPos > 0) {
            if (actElem == null) {
                throw new IndexOutOfBoundsException("index: " + pos);
            }

            currentPos--;
            actElem = actElem.next;
        }

        return actElem.value;
    }


    public E set(int pos, E e) {
        if (isEmpty() || pos < 0) {
            throw new IndexOutOfBoundsException("index: " + pos);
        }

        int currentPos = pos;
        Element<E> actElem = first;

        while(currentPos > 0) {
            if (actElem == null) {
                throw new IndexOutOfBoundsException("index: " + pos);
            }

            currentPos--;
            actElem = actElem.next;
        }

        E retValue = actElem.value;
        actElem.value = e;
        return retValue;
    }



    // metody pomocnicze:
    private static class ElementPair<E> {
        private final Element<E> previous;
        private final Element<E> current;

        public ElementPair(Element<E> previous, Element<E> current) {
            this.previous = previous;
            this.current = current;
        }
    }

    // biorę dwa elementy, ten na indeksie i ten przed nim
    private ElementPair<E> getElementWithPrevious(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }

        Element<E> previousElement = null;
        Element<E> currentElement = first;
        int currentIndex = index;

        while(currentIndex > 0) {
            if (currentElement == null) {
                throw new IndexOutOfBoundsException("index: " + index);
            }

            previousElement = currentElement;
            currentElement = currentElement.next;
            currentIndex--;
        }
        return new ElementPair<>(previousElement, currentElement);
    }



    // reszta metod:

    public void insert(int pos, E e) {

        // dodanie do pustej:
        if (pos == 0 && first == null) {
            first = new Element<>(e);
            size++;
            return;
        }

        ElementPair<E> pair = getElementWithPrevious(pos);
        Element<E> previousElement = pair.previous;
        Element<E> elementAtIndex = pair.current;

        // dodanie na początek:
        if (previousElement == null) {
            first = new Element<>(e);
            first.next = elementAtIndex;
            size++;
            return;
        }

        // w pozostałym miejscu:
        Element<E> newELem = new Element<>(e);
        newELem.next = elementAtIndex;
        previousElement.next = newELem;
        size++;
    }

    public void addEnd(E e) {
        Element<E> actElem = first;

        if (Size() == 0) {
            first = new Element<>(e);
            size++;
            return;
        }

        if (Size() == 1) {
            first.next = new Element<>(e);
            size++;
            return;
        }

        int counter = 0;

        while (counter < size - 1) {
            actElem = actElem.next;
            counter++;
        }

        size++;
        actElem.next = new Element<>(e);
    }


    boolean contains(E e) {
        Element<E> actElem = first;

        while (actElem != null) {
            if (actElem.value == e)
                break;
            actElem = actElem.next;
        }
        return actElem != null;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public E deletePos(int pos) {
        if (isEmpty() || pos < 0) {
            throw new IndexOutOfBoundsException("index: " + pos);
        }

        ElementPair<E> pair = getElementWithPrevious(pos);
        Element<E> previousElement = pair.previous;
        Element<E> elementToDelete = pair.current;
        E removedELement = elementToDelete.value;

        // wyrzucenie pierwszego:
        if (previousElement == null) {
            first = elementToDelete.next;
            size--;
            return removedELement;
        }

        previousElement.next = elementToDelete.next;
        size--;
        return removedELement;
    }

    public boolean delete(E e) {
        if (Size() == 0) {
            return false;
        }

        if (Size() == 1) {
            first = null;
            size--;
            return true;
        }

        Element<E> actElem = first;
        int counter = 0;

        while (counter < size-1) {
            if (actElem.next.value == e) {
                size--;
                actElem.next = actElem.next.next;
                return true;
            }

            actElem = actElem.next;
            counter++;
        }

        if (actElem.value == e) {
            size--;
            return true;
        }

        return false;
    }

    public E deleteElem(Element<E> e) {
        if (Size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        if (Size() == 1) {
            E retVal = first.value;
            first = null;
            size--;
            return retVal;
        }

        Element<E> actElem = first;
        if (e.value == actElem.value) {
            size--;
            E retVal = actElem.value;
            first = actElem.next;
            return retVal;
        }

        int counter = 0;

        while (counter < size-1) {
            if (actElem.next.value == e.value) {
                size--;
                E retVal = actElem.next.value;
                actElem.next = actElem.next.next;
                return retVal;
            }

            actElem = actElem.next;
            counter++;
        }

        if (actElem.value == e.value) {
            size--;
            return actElem.value;
        }

        return null;
    }

    public void wyswietlListe() {
        if (size == 0) {
            System.out.println("lista jest pusta");
        }

        Element<E> actElem = first;
        int counter = 0;

        while (counter < size) {
            System.out.println(actElem.toString());
            actElem = actElem.next;
            counter++;
        }
    }
}
