package zadanie1;

import java.util.ArrayList;
import java.util.HashSet;

public class SetOnTable<T> {

    private final Node<T>[] table;
    private int actualPosition;
    private final int maxAmountOfSets;

    private static class Node<T> {
        Node<T> parent;
        T value;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value: " + value + " " + "parent: " + parent.value;
       }
    }

    public SetOnTable(int maxAmountOfSets) {
        table = new Node[maxAmountOfSets];
        this.maxAmountOfSets = maxAmountOfSets;
        actualPosition = 0;
    }

    public void makeSet(T value) {
        if (actualPosition >= maxAmountOfSets) {
            System.out.println("Nie można dodać więcej zbiorów");
            return;
        }

        Node<T> x = new Node<>(value);
        x.parent = x;
        table[actualPosition] = x;
        actualPosition++;
    }

    public T findSet(int value) {
        if (value - 1 >= maxAmountOfSets)
            return null;
        return findSet(table[value - 1]).value;
    }

    private Node<T> findNode(int index) {
        if (index - 1 >= maxAmountOfSets)
            return null;
        return findSet(table[index - 1]);
    }

    private Node<T> findSet(Node<T> x) {
        if (x != x.parent)
            return findSet(x.parent);
        return x.parent;
    }

    public void union(int index1, int index2) {
        union(findNode(index1), findNode(index2));
    }

    private void union(Node<T> x, Node<T> y) {
        x.parent = y;
    }

    public void draw() {

        // znalezienie reprezentantów
        HashSet<Node<T>> representative = new HashSet<>();

        for (Node<T> tNode : table) {
            representative.add(findSet(tNode));
        }

        // znalezienie ścieżek do reprezentanta dla każdego węzła
        ArrayList<ArrayList<Node<T>>> paths = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            paths.add(new ArrayList<>());
        }

        for (int i = 0; i < table.length; i++) {
            Node <T> actual = table[i];

            while (actual.parent != actual) {
                paths.get(i).add(actual);
                actual = actual.parent;
            }

            paths.get(i).add(actual);
        }

        // wyrzucenie reprezentantów z listy ścieżek
        paths.removeIf(nodes -> nodes.size() == 1);

        // wyrówanie dłuości ścieżek
        int maximal = 0;
        for (ArrayList<Node<T>> nodes : paths) {
            if (nodes.size() > maximal) {
                maximal = nodes.size();
            }
        }

        for (int i = 0; i < paths.size(); i++) {

            if (paths.get(i).size() < maximal) {
                ArrayList<Node<T>> help = new ArrayList<>();
                for (int j = 0; j < maximal; j++) {
                    help.add(new Node<>(null));
                }

                int c = maximal-1;
                for (int j = paths.get(i).size()-1; j >= 0; j--) {
                    help.set(c, paths.get(i).get(j));
                    c--;
                }

                paths.set(i, help);
            }




        }




        // rysowanie
        System.out.println("============ Rysunek ============");

        int j = 0;
        int amountOfSpaces = 10;
        for (int i = 0; i < (maximal); i++) {

            // najpierw reprezentanci
            if (i == 0) {
                T actual = paths.get(0).get(paths.get(0).size() - 1).value;
                System.out.print("                  " + actual);

                for (ArrayList<Node<T>> path :
                        paths) {
                    if (path.get(maximal-1).value != actual) {
                        System.out.print("                  " + path.get(maximal-1).value);
                    }

                    actual = path.get(maximal-1).value;
                    j = maximal-1;
                }
            }

            else {
                System.out.println();
                j--;
                Node<T> actual = paths.get(0).get(j);
                System.out.print("              " + actual.value);


                for (ArrayList<Node<T>> path :
                        paths) {
                    // element zbioru wskazujący na tego samego reprezentatna co porzednik
                    if (path.get(j).value != null &&
                            path.get(j) != actual &&
                                findSet(path.get(j)) == findSet(actual)) {
                        for (int k = 0; k < amountOfSpaces; k++) {
                            System.out.print(" ");
                        }
                        System.out.print( path.get(j).value);
                    }

                    // element zbioru wskazujący na innego reprezentanta niż poprzednik
                    if (path.get(j).value != null &&
                            path.get(j) != actual &&
                                findSet(path.get(j)) != findSet(actual)) {
                        System.out.print("            " + path.get(j).value);
                    }

                    actual = path.get(j);
                }

                amountOfSpaces /= 2;

            }


        }

        System.out.println("\n========================");



    }

}
