package Za4;

public class TwoWayLinkedListWithSentinel<T> {

    // węzeł
    private static class Node<T> {
        T Value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.Value = value;
        }

        public void insertAfter(Node<T> node) {
            node.next = this.next;
            node.prev = this;
            this.next = node;
            this.next.prev = node;
        }

        public void insertBefore(Node <T> node) {
            node.next = this;
            node.prev = this.prev;
            this.prev = node;
            this.prev.next = node;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }


    // lista
    private Node<T> sentinel;

    public TwoWayLinkedListWithSentinel() {
        sentinel = new Node<>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    private Node<T> getNode(int index) {
        Node <T> node = sentinel.next;
        int counter = 0;

        while (node != sentinel && counter < index) {
            node = node.next;
            counter++;
        }

        if (node == sentinel) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        return node;
    }

    private Node<T> getNode(T value) {
        Node<T> actNode = sentinel.next;
        int counter = 0;

        while (actNode != sentinel && !value.equals(actNode.Value)) {
            counter++;
            actNode = actNode.next;
        }

        if (actNode == sentinel)
            return null;
        return actNode;
    }



    // metody użytkownika:
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public void clear() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public int indexOf(T value) {
        Node<T> node = sentinel.next;
        int counter = 0;

        while(node != sentinel && !node.Value.equals(value)) {
            counter ++;
            node = node.next;
        }

        if (node == sentinel)
            return -1;
        return size()-counter;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        return node.Value;
    }

    public T set(int index, T value) {
        Node<T> node = getNode(index);
        T retVal = node.Value;
        node.Value = value;
        return retVal;
    }


    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);
        sentinel.insertAfter(newNode);
        return true;
    }

    public boolean add(int index, T value) {
        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            sentinel.insertAfter(newNode);
        }
        else {
            Node<T> node = getNode(index);
            node.insertAfter(newNode);
        }
        return true;
    }



    public T remove(int index) {
        Node<T> toRemove = getNode(index);
        toRemove.remove();
        return toRemove.Value;
    }

    public boolean remove(T value) {
        Node<T> toRemove = getNode(value);
        if (toRemove == null)
            return false;
        toRemove.remove();
        return true;
    }

    public int size() {
        Node<T> node = sentinel.next;
        int counter = 0;

        while(node != sentinel) {
            counter++;
            node = node.next;
        }

        return counter;
    }


    // 4a
    public boolean addNewListOnTheEnd(TwoWayLinkedListWithSentinel<T> newList) {
        Node<T> lastListI = getNode(size());
        Node<T> firstListII = newList.getNode(0);

        lastListI.next = firstListII;
        firstListII.prev = lastListI;


        Node<T> firstListI = getNode(0);

        firstListI.prev = newList.sentinel;

        return true;
    }


    // 4b
    public boolean addNewListOnTheIndex(int index, TwoWayLinkedListWithSentinel<T> newList) {
        Node<T> first = newList.getNode(0);
        Node<T> last = newList.getNode(newList.size());

        Node<T> thisBeforeYouWantToInsert = getNode(index);
        thisBeforeYouWantToInsert.insertBefore(last);

        Node<T> thisAfterYouWantToInsert = getNode(index-1);
        thisAfterYouWantToInsert.insertAfter(first);

        return true;
    }



}
