package Zadanie1;

public class Main {

    public static void main(String[] args) {
        PriorityQueueOnHeap queue = new PriorityQueueOnHeap(5);

        queue.show();

        queue.clear();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Size: " + queue.size());
        System.out.println("First: " + queue.first());
        queue.show();

        queue.dequeue();
        queue.dequeue();
        System.out.println("Size: " + queue.size());
        queue.show();

        queue.enqueue(4);
        queue.enqueue(5);

        queue.changePriority(7, 4); // to jest trójka
        queue.show();

        queue.removeIndex(0);                       // usunięcie korzenia, tutaj siódemki
        System.out.println("Size: " + queue.size());
        queue.show();
    }
}
