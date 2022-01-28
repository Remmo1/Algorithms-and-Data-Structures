package com.company;

public class BinaryHeapForNodes {

    private final Node[] array;
    private final int capacity;
    private int actualSize;

    public BinaryHeapForNodes(int capcity) {
        array = new Node[capcity];
        this.capacity = capcity;
        actualSize = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i) + 1; }
    private int right(int i) { return (2 * i) + 2; }

    public Node getMin() {
        return array[0];
    }

    public void insert(int k, String s) {
        if (actualSize == capacity) {
            System.out.println("Nie można już nic dodać");
            return;
        }

        actualSize++;
        int i = actualSize - 1;
        array[i] = new Node(s, k);

        while (i != 0 && array[parent(i)].frequency > array[i].frequency) {
            Node h = array[parent(i)];
            array[parent(i)] = array[i];
            array[i] = h;

            i = parent(i);
        }
    }

    public void insertNode(Node node) {
        if (actualSize == capacity) {
            System.out.println("Nie można już nic dodać");
            return;
        }

        actualSize++;
        int i = actualSize - 1;
        array[i] = node;

        while (i != 0 && array[parent(i)].frequency > array[i].frequency) {
            Node h = array[parent(i)];
            array[parent(i)] = array[i];
            array[i] = h;

            i = parent(i);
        }
    }

    public void decreaseKey(int i, int value) {
        array[i].frequency = value;

        while (i != 0 && array[parent(i)].frequency > array[i].frequency) {
            Node h = array[parent(i)];
            array[parent(i)] = array[i];
            array[i] = h;

            i = parent(i);
        }

    }

    public Node extractMin() {
        if (actualSize <= 0) {
            System.out.println("Błąd");
            return null;
        }

        if (actualSize == 1) {
            actualSize--;
            return array[0];
        }

        Node root = array[0];
        array[0] = array[actualSize - 1];
        actualSize--;
        minHeapify(0);

        return root;
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    private void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < actualSize && array[l].frequency < array[i].frequency)
            smallest = l;

        if (r < actualSize && array[r].frequency < array[smallest].frequency)
            smallest = r;

        if (smallest != i) {
            Node h = array[smallest];
            array[smallest] = array[i];
            array[i] = h;

            minHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        BinaryHeapForNodes binaryHeap = new BinaryHeapForNodes(11);

        binaryHeap.insert(3,"a");
        binaryHeap.insert(2,"a");
        binaryHeap.deleteKey(1);

        binaryHeap.insert(7,"a");
        binaryHeap.insert(1,"a");
        binaryHeap.insert(4,"a");

        System.out.println(binaryHeap.extractMin());
        System.out.println(binaryHeap.getMin());
    }

}
