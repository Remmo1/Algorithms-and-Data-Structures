package zadanie2;


import java.util.ArrayList;
import java.util.Comparator;

public class BTree<T> {

    private class Node<R> {
        int n;
        R[] keys;
        boolean isLeaf;

        Node<R>[] children;

        public Node() {
            n = 0;
            isLeaf = true;

            keys = (R[]) new Object[(2*t)-1];
            children= new Node[2*t];

        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < (2 * t) - 1; i++) {
                stringBuilder.append(keys[i]).append(" ");
            }

            return stringBuilder.toString();
        }
    }

    private final int t;
    private Node<T> root;
    private final Comparator<T> comparator;



    public BTree(Comparator<T> comparator) {
        t = 2;
        root = new Node<>();
        this.comparator = comparator;
    }

    private void BTreeSplitCHild(Node<T> x, int i, Node<T> y) {
        Node<T> z = new Node<>();
        z.isLeaf = y.isLeaf;
        z.n = t-1;

        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j+t];
        }

        if (!y.isLeaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j+t];
            }
        }

        y.n = t - 1;

        for (int j = x.n + 1; j >= i + 1; j--) {
            x.children[j+1] = x.children[j];
        }

        x.children[i+1] = z;

        for (int j = x.n; j >= i; j--) {
            x.keys[j+1] = x.keys[j];
        }

        x.keys[i] = y.keys[t-1];
        x.n = x.n + 1;


        for (int j = 1; j <= t; j++) {
            y.keys[j] = null;
        }



    }

    private void TreeInsertNotFull(Node <T> x, T k) {
        int i = x.n-1;

        if (x.isLeaf) {
            while(i >= 0 && comparator.compare(k, x.keys[i]) < 0 ) {
                x.keys[i+1] = x.keys[i];
                i--;
            }

            x.keys[i+1] = k;
            x.n = x.n + 1;
        }

        else {
            while (i >= 0 && comparator.compare(k, x.keys[i]) < 0 ) {
                i--;
            }

            i++;

            if (x.children[i].n == (2*t)-1) {
                BTreeSplitCHild(x,i,x.children[i]);

                if (comparator.compare(k, x.keys[i]) > 0)
                    i++;
            }

            TreeInsertNotFull(x.children[i], k);

        }
    }


    public void BTreeInsert(T k) {

        Node <T> r = root;

        if (r.n == (2*t) - 1) {
            Node <T> s = new Node<>();
            root = s;
            s.isLeaf = false;
            s.n = 0;
            s.children[0] = r;
            BTreeSplitCHild(s,0,r);
            TreeInsertNotFull(s,k);


        }
        else
            TreeInsertNotFull(r, k);
    }

    public T find(T value) {
        return BTreeSearch(root, value);
    }

    private T BTreeSearch(Node<T> x, T k) {
        int i = 0;

        while (i < x.n && comparator.compare(k, x.keys[i]) > 0) {
            i++;
        }

        if (i != x.n && k == x.keys[i]) {
            return x.keys[i];
        }

        if (x.isLeaf) {
            return null;
        }

        else {
            return BTreeSearch(x.children[i], k);
        }
    }


    private boolean isSomethingForTable(T[] t) {
        boolean isSomething = true;
        for (T value : t) {
            if (value == null)
                isSomething = false;
            else
                return true;
        }

        return isSomething;
    }


    // minimum i maksimum
    public T minimum() {
        return minimum(root);
    }

    private T minimum(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return null;
        }

        if (!isSomethingForTable((T[]) node.children)) {
            return node.keys[0];
        }

        T possible;

        while (true) {
            possible = node.keys[0];
            node = node.children[0];

            if (node == null) {
                return possible;
            }
        }
    }

    public T maksimum() {
        return maksimum(root);
    }

    private T maksimum(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return null;
        }

        if (!isSomethingForTable((T[]) node.children)) {
            for (int i = node.n - 1;  i >= 0; i++) {
                if (node.keys[i] != null) {
                    return node.keys[i];
                }
            }
        }

        T possible = null;

        while (true) {
            for (int i = node.n - 1;  i >= 0; i--) {
                if (node.keys[i] != null) {
                    possible = node.keys[i];
                    break;
                }
            }

            if (!isSomethingForTable((T[]) node.children)) {
                return possible;
            }

            for (int i = (2*t)-1;  i >= 0; i--) {
                if (node.children[i] != null) {
                    node = node.children[i];
                    break;
                }
            }



        }
    }

    // poprzednik i następnik
    public T predecessor(T value) {
        return predecessor(root, value);
    }

    private T predecessor(Node<T> node, T value) {

        if (node == null) {
            System.out.println("Puste drzewo");
            return null;
        }

        if (find(value) == null) {
            System.out.println("Nie ma takiego elementu w drzewie");
            return null;
        }

        if (!isSomethingForTable((T[]) node.children)) {
            for (int i = 0; i < (2 * t) - 1; i++) {
                if (comparator.compare(node.keys[i], value) >= 0) {
                    if (i-1 >= 0)
                        return node.keys[i-1];
                    else
                        return node.keys[i];
                }
            }

            return node.keys[(2*t)-2];
        }

        for (int i = 0; i < (2 * t) - 1; i++) {
            if (comparator.compare(node.keys[i], value) >= 0) {
                return predecessor(node.children[i],value);
            }
        }


        return null;
    }


    public T sucessor(T value) {
        return sucessor(root, value);
    }

    private T sucessor(Node<T> node, T value) {

        if (node == null) {
            System.out.println("Puste drzewo");
            return null;
        }

        if (find(value) == null) {
            System.out.println("Nie ma takiego elementu w drzewie");
            return null;
        }

        if (!isSomethingForTable((T[]) node.children)) {
            for (int i = 0; i < (2 * t) - 1; i++) {
                if (comparator.compare(node.keys[i], value) > 0) {
                    if ((i+1) < ((2*t) - 1))
                        return node.keys[i+1];
                    else
                        return node.keys[i];
                }
            }

            return node.keys[(2*t)-2];
        }

        for (int i = 0; i < (2 * t) - 1; i++) {
            if (comparator.compare(node.keys[i], value) >= 0) {
                return sucessor(node.children[i],value);
            }
        }


        return null;
    }


    // wyświetlanie

    public void showKeysLevels() {
        showKeysLevels(root);
        System.out.println();
    }

    private void showKeysLevels(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return;
        }


        ArrayList<Node<T>> nodes = new ArrayList<>();
        int levelCounter = 1;
        int nullCounter = 0;
        int whichNodeNow = 1;
        boolean exit = false;

        while (true) {

            if (levelCounter == 1) {
                nodes.add(node);

                if (!isSomethingForTable((T[]) node.children))
                    break;

                else {
                    for (int i = 0; i < (2 * t); i++) {
                        nodes.add(node.children[i]);
                    }
                }
            }

            levelCounter++;

            for (int i = 0; i < Math.pow(2*t, (levelCounter-1)); i++) {
                node = nodes.get(whichNodeNow+i);

                if (node != null) {
                    if (!isSomethingForTable((T[]) node.children)) {
                        nullCounter++;
                    }

                    nodes.add(node.children[i]);

                }

                else
                    nullCounter++;


            }

            if (nullCounter == Math.pow(2*t,levelCounter-1)) {
                exit = true;
            }

            if (exit)
                break;
            else {
                nullCounter = 0;
                whichNodeNow += Math.pow(2*t, (levelCounter-1));
            }
        }


        int i = 1;
        int whenNewLine = 1;
        int powerConuter = 1;

        System.out.println();
        for (Node<T> n :
                nodes) {
            if (n == null)
                break;

            System.out.print(n + " ");

            if (i == whenNewLine) {
                System.out.println();
                whenNewLine += Math.pow(2*t, powerConuter);
                powerConuter++;
            }

            i++;
        }

        System.out.println();
    }
}
