package zadanie1;

import java.util.ArrayList;
import java.util.HashSet;

public class SetForestPathCompress <T> {

    public class Node<T> {
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

    public Node<T> makeSet(T value) {
        Node<T> x = new Node<>(value);
        x.parent = x;

        // linijka 27 potrzebna tylko i wyłącznie do rysowania
        table.add(x);

        return x;
    }

    public Node<T> findSet(Node<T> x) {
        if (x != x.parent)
            x.parent = findSet(x.parent);
        return x.parent;
    }

    public void union(Node<T> x, Node<T> y) {
        findSet(x).parent = findSet(y);
    }


    private ArrayList<Node<T>> table = new ArrayList<>();
    public void draw() {

        // znalezienie reprezentantów
        HashSet<Node<T>> representative = new HashSet<>();

        for (Node<T> tNode : table) {
            representative.add(findSet(tNode));
        }

        // znalezienie ścieżek do reprezentanta dla każdego węzła
        ArrayList<ArrayList<Node<T>>> paths = new ArrayList<>();

        for (int i = 0; i < table.size(); i++) {
            paths.add(new ArrayList<>());
        }

        for (int i = 0; i < table.size(); i++) {
            Node<T> actual = table.get(i);

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
        int amountOfSpaces = 1;
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
