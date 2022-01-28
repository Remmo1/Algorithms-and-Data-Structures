package zadanie2;

public class Main2 {
    public static void main(String[] args) {

        BTree<Integer> tree = new BTree<>(Integer::compareTo);

        tree.BTreeInsert(1);
        tree.BTreeInsert(4);
        tree.BTreeInsert(5);
        tree.BTreeInsert(7);
        tree.BTreeInsert(2);
        tree.BTreeInsert(10);
        tree.BTreeInsert(3);

        tree.BTreeInsert(6);

        tree.showKeysLevels();

        System.out.println("Klucz o wartości 1: " + tree.find(1));
        System.out.println("Klucz o wartości 4: " + tree.find(4));
        System.out.println("Klucz o wartości 5: " + tree.find(5));
        System.out.println("Klucz o wartości 90: " + tree.find(90));
        System.out.println("Klucz o wartości 6: " + tree.find(6));
        System.out.println("Minimum: " + tree.minimum());
        System.out.println("Maksimum: " + tree.maksimum());
        System.out.println("Poprzednik 4: " + tree.predecessor(4));
        System.out.print("Poprzednik 1: ");
        if (tree.predecessor(1).equals(1)) {
            System.out.println("brak");
        }
        System.out.println("Następnik 2: " + tree.sucessor(2));

    }
}
