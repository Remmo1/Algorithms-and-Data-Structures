package zadanie1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class RBTree<T> {

    // węzeł
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        byte color;

        Node(T obj) {
            this.value = obj;
        }

        @Override
        public String toString() {
            if (value == null && color == 0)
                return "nil";
            assert value != null;
            return  value + " " + (color == 1?"r":"b");
        }
    }

    // zmienne:
    private final Comparator<T> comparator;
    private Node<T> root;
    private final Node<T> nil;
    private final ArrayList<Node<T>> stack;

    private int counterNodes;
    private int leavesCounter;

    // konstruktor
    public RBTree(Comparator<T> comparator) {
        this.comparator = comparator;
        nil = new Node<>(null);
        nil.color = 0;

        root = nil;
        stack = new ArrayList<>();

        counterNodes = 0;
        leavesCounter = 0;
    }

    // wstawianie

    private Node<T> insert(Node<T> node, T elem) {
        if (node == nil) {
            node = new Node<>(elem);
            node.left = nil;
            node.right = nil;

            return node;
        }

        else {
            int cmp = comparator.compare(elem, node.value);

            if (cmp < 0)
                node.left = insert(node.left, elem);

            else if (cmp > 0)
                node.right = insert(node.right, elem);

            else
                throw new NoSuchElementException(elem.toString());
        }

        return node;
    }



    // rotacje
    private void leftRotate(Node<T> s) {

        stack.clear();
        Node<T> z = root;

        while (z.value != s.value) {
            stack.add(z);

            if (comparator.compare(z.value, s.value) < 0)
                z = z.right;
            else
                z = z.left;
        }

        Node<T> x = z;
        Node<T> y;

        y = x.right;

        if (y.left != nil) {
            x.right = y.left;
        }

        if (!stack.isEmpty())
            z = stack.get(stack.size()-1);
        else
            z = nil;

        if (z == nil) {
            root = y;
        }

        else if (x == z.left) {
            z.left = y;
            x.right = nil;
        }

        else {
            z.right = y;
        }


        y.left = x;
    }

    private void rightRotate(Node<T> s) {

        stack.clear();
        Node<T> z = root;

        while (z.value != s.value) {
            stack.add(z);

            if (comparator.compare(z.value, s.value) < 0)
                z = z.right;
            else
                z = z.left;
        }

        Node<T> x;
        Node<T> y;

        x = z;
        y = x.left;

        if (y.right != nil) {
            x.left = y.right;
        }

        if (!stack.isEmpty())
            z = stack.get(stack.size()-1);
        else
            z = nil;

        if (z == nil) {
            root = y;
        }

        else if (x == z.right) {
            z.right = y;
            x.left = nil;
        }

        else
            z.left = y;

        y.right = x;
        z = y;
    }


    // wstawianie



    public void rbInsert(T value) {
        rbInsert(root, value);
    }


    private void rbInsert(Node<T> x, T value) {

        stack.clear();

        if (root == nil) {
            root = new Node<>(value);
            root.left = nil;
            root.right = nil;

            return;
        }

        x = insert(root, value);

        Node<T> z = root;

        while (z.value != value) {
            stack.add(z);

            if (comparator.compare(z.value, value) < 0)
                z = z.right;
            else
                z = z.left;
        }

        x = z;
        x.color = 1;

        Node<T> y = nil;
        y.color = 0;

        Node<T> grandpa;

        if (!stack.isEmpty())
            z = stack.remove(stack.size()-1);
        else
            z = nil;

        if (!stack.isEmpty()) {
            grandpa = stack.remove(stack.size()-1);
        }
        else {
            grandpa = nil;
        }


        // główna pętla
        while (x != root && z.color == 1) {


            if (z == grandpa.left) {

                y = grandpa.right;
                if (y == null) {
                    y = new Node<>(null);
                    y.color = 0;
                }

                if (y.color == 1) {         // przypadek 1
                    z.color = 0;
                    y.color = 0;
                    grandpa.color = 1;
                    x = grandpa;
                }

                else {
                    if (x == z.right) {     // przypadek 2
                        leftRotate(z);

                        x.color = 0;
                        grandpa.color = 1;
                        rightRotate(grandpa);
                    }

                    else {              // przypadek 3
                        z.color = 0;
                        grandpa.color = 1;
                        rightRotate(grandpa);
                    }


                }

            }





            else {
                y = grandpa.left;

                if (y.color == 1) {     // przypadek 1 symetryczny
                    z.color = 0;
                    y.color = 0;
                    grandpa.color = 1;
                    x = grandpa;
                }

                else {

                    if (x == z.left) {     // przypadek 2
                        rightRotate(z);

                        x.color = 0;
                        grandpa.color = 1;
                        leftRotate(grandpa);
                    }

                    else {              // przypadek 3
                        z.color = 0;
                        grandpa.color = 1;
                        leftRotate(grandpa);
                    }
                }
            }


            if (!stack.isEmpty()) {
                z = stack.remove(stack.size()-1);

                if (!stack.isEmpty()) {
                    grandpa = stack.remove(stack.size()-1);
                }
                else {
                    grandpa = nil;
                }

            }
            else {
                z = nil;
                grandpa = nil;
            }



        }

        root.color = 0;


    }


    // szukanie
    private Node<T> search(T elem) {
        Node<T> node = root;
        int cmp;

        while (node != nil && (cmp = comparator.compare(elem, node.value)) != 0) {
            node = cmp <0 ? node.left : node.right;
        }

        return node;
    }

    public T find (T elem) {
        Node<T> node = search(elem);
        return node == nil ? nil.value : node.value;
    }


    // chodzenie
    private void inOrderWalk(Node<T> node, StringToStringExecutor executor) {
        if (node != nil) {
            inOrderWalk(node.left, executor);
            executor.execute(node.toString());
            counterNodes++;
            inOrderWalk(node.right, executor);
        }
    }

    public void inOrderWalk (StringToStringExecutor executor) {
        inOrderWalk(root, executor);
    }


    private void preOrderWalk(Node<T> node, StringToStringExecutor executor) {
        if (node != nil) {
            executor.execute(node.toString());
            preOrderWalk(node.left, executor);
            preOrderWalk(node.right, executor);
        }
    }

    public void preOrderWalk(StringToStringExecutor executor) {
        preOrderWalk(root, executor);
    }


    private void postOrderWalk(Node<T> node, StringToStringExecutor executor) {
        if (node != nil) {
            postOrderWalk(node.left, executor);
            postOrderWalk(node.right,executor);
            executor.execute(node.toString());
        }
    }

    public void postOrderWalk(StringToStringExecutor executor) {
        postOrderWalk(root, executor);
    }



    // wyświetlanie poziomami
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
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);

                if (node.left == null && node.right == null)
                    break;
            }

            levelCounter++;
            for (int i = 0; i < Math.pow(2, (levelCounter-1)); i++) {
                node = nodes.get(whichNodeNow+i);

                if (node != null) {
                    if (node.left == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.left);
                    }

                    if (node.right == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.right);
                    }
                }


            }

            if (nullCounter == Math.pow(2,levelCounter)) {
                exit = true;
            }

            if (exit)
                break;
            else {
                nullCounter = 0;
                whichNodeNow += Math.pow(2, (levelCounter-1));
            }
        }


        int i = 1;
        int whenNewLine = 1;
        int powerConuter = 1;

        for (Node<T> n :
                nodes) {
            System.out.print(n.toString() + " ");

            if (i == whenNewLine) {
                System.out.println();
                whenNewLine += Math.pow(2, powerConuter);
                powerConuter++;
            }

            i++;
        }

    }





    // wysokość
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return 0;
        }

        ArrayList<Node<T>> nodes = new ArrayList<>();
        int levelCounter = 1;
        int nullCounter = 0;
        int whichNodeNow = 1;
        boolean exit = false;

        while (true) {

            if (levelCounter == 1) {
                nodes.add(node);
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);

                if (node.left == null && node.right == null)
                    break;
            }

            levelCounter++;
            for (int i = 0; i < Math.pow(2, (levelCounter-1)); i++) {
                node = nodes.get(whichNodeNow+i);

                if (node != null) {
                    if (node.left == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.left);
                    }

                    if (node.right == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.right);
                    }
                }


            }

            if (nullCounter == Math.pow(2,levelCounter)) {
                exit = true;
            }

            if (exit)
                break;
            else {
                nullCounter = 0;
                whichNodeNow += Math.pow(2, (levelCounter-1));
            }
        }

        return levelCounter;
    }

    // ilość węzłów
    public<R> int amountOfNodes(StringToStringExecutor executor) {
        return amountOfNodes(executor, root);
    }

    private <R> int amountOfNodes(StringToStringExecutor executor, Node<T> node) {
        counterNodes = 0;
        inOrderWalk(node, executor);

        return counterNodes;
    }

    // ilość liści

    public int amountOfLeaves() {
        leavesCounter = 0;
        return amountOfLeaves(root);
    }

    private int amountOfLeaves(Node<T> node) {
        if (node != null && node.left == null && node.right == null) {
            leavesCounter++;
        }

        if (node != null) {
            amountOfLeaves(node.left);
            amountOfLeaves(node.right);
        }

        return leavesCounter;
    }


    public void heightAndAmountOfNodesForEveryNode() {
        heightAndAmountOfNodesForEveryNode(root);
    }

    private void heightAndAmountOfNodesForEveryNode(Node<T> node) {
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
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);

                if (node.left == null && node.right == null)
                    break;
            }

            levelCounter++;
            for (int i = 0; i < Math.pow(2, (levelCounter-1)); i++) {
                node = nodes.get(whichNodeNow+i);

                if (node != null) {
                    if (node.left == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.left);
                    }

                    if (node.right == null) {
                        nullCounter++;
                        nodes.add(new Node<>(null));
                    }
                    else {
                        nodes.add(node.right);
                    }
                }


            }

            if (nullCounter == Math.pow(2,levelCounter)) {
                exit = true;
            }

            if (exit)
                break;
            else {
                nullCounter = 0;
                whichNodeNow += Math.pow(2, (levelCounter-1));
            }
        }

        int p = nodes.size()-1;
        for (int i = 0; i < Math.pow(2, levelCounter); i++) {
            nodes.remove(p-i);
        }

        StringToStringExecutor executor = new StringToStringExecutor();

        for (Node<T> n :
                nodes) {
            if (n.value != null) {
                System.out.print("Węzeł: " + n.value + " Wysokość poddrzewa (korzeń to poziom 1): " + (height(n)-1) + " Ilość węzłów z nim samym włącznie: " + amountOfNodes(executor, n));
                System.out.println();
                System.out.print("Węzeł: " + n.value + " Wysokość lewego poddrzewa : " + (height(n.left)) + " Wysokość prawego poddrzewa : " + (height(n.right)) + " Ilość węzłów z nim samym włącznie dla lewego: " + amountOfNodes(executor, n.left ) + " Ilość węzłów z nim samym włącznie dla prawego: " + amountOfNodes(executor, n.right));
                System.out.println();
            }

        }


    }


    ///======================= usuwanie * ===================================

    // minimum i maksimum
    private Node<T> getMin(Node<T> node) {
        assert (node != nil);

        while (node.left != nil) {
            node = node.left;
        }
        return node;
    }

    public T getMin() {
        if (root == null)
            throw new NoSuchElementException();
        Node <T> node = getMin(root);
        return node.value;
    }

    private Node<T> getMax(Node<T> node) {
        assert (node != null);

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public T getMax() {
        if (root == null)
            throw new NoSuchElementException();
        Node <T> node = getMax(root);
        return node.value;
    }

    // następnik
    private Node <T> successorNode(Node <T> node, T elem) {
        if (node == nil)
            throw new NoSuchElementException();

        int cmp = comparator.compare(elem, node.value);

        if (cmp == 0) {
            if (node.right != nil)
                return getMin(node.right);
            else
                return null;
        }

        else if(cmp < 0) {
            Node <T> retNode = successorNode(node.left, elem);
            return retNode == null ? node : retNode;
        }

        else
            return successorNode(node.right, elem);

    }

    public T successor (T elem) {
        Node<T> succNode = successorNode(root,elem);
        return succNode == nil ? null:succNode.value;
    }

    public T delete(T value) {
        Node <T> ret = delete(root, value);
        return ret.value;
    }

    private Node<T> delete(Node<T> node, T value) {

        stack.clear();

        if (root == nil) {
            return null;
        }

        Node <T> z = search(value);
        Node <T> y;
        Node <T> x;

        if (z.left == nil || z.right == nil) {
            y = z;
        }
        else {
            T h = successor(z.value);
            y = search(h);
        }

        if (y.left != nil)
            x = y.left;

        else
            x = y.right;

        Node <T> parentY = nil;
        Node<T> actual = root;

        while (actual.value != y.value) {
            stack.add(actual);

            if (comparator.compare(actual.value, y.value) < 0)
                actual = actual.right;
            else
                actual = actual.left;
        }

        if (!stack.isEmpty()) {
            parentY = stack.remove(stack.size()-1);
        }


        if (parentY == nil) {
            root = x;


            if (y == parentY.left)
                parentY.left = x;
            else
                parentY.right = x;
        }

        if (y != z) {
            T keyZ = z.value;
            z.value = y.value;
            y.value = keyZ;
        }

        if (y.color == 0) {
            RBDeleteFixUp(root, x);
        }

        Node<T> retVal = y;

        // y pusty:
        if (y.left == nil && y.right == nil) {
            if (parentY.left == y)
                parentY.left = nil;
            else if (parentY.right == y)
                parentY.right = nil;
        }

        else {
            // y lewe dziecko
            if (y == parentY.left && y.left != nil)
                parentY.left = y.left;
            if (y == parentY.left && y.right != nil)
                parentY.left = y.right;

            // y prawe dziecko
            if (y == parentY.right && y.left != nil)
                parentY.right = y.left;
            if (y == parentY.right && y.right != nil)
                parentY.right = y.right;

            // usunięcie y
            if (parentY.left == y)
                parentY.left = nil;
            else if (parentY.right == y)
                parentY.right = nil;
        }


        return retVal;
    }

    private void RBDeleteFixUp(Node<T> node, Node<T> x) {
        stack.clear();

        while (node.value != x.value) {
            stack.add(node);

            if (comparator.compare(node.value, x.value) < 0)
                node = node.right;
            else
                node = node.left;
        }

        x = node;

        Node <T> w;
        Node <T> parentX;
        Node <T> grandpaX;

        if (!stack.isEmpty()) {
            parentX = stack.remove(stack.size() - 1);

            if (!stack.isEmpty())
                grandpaX = stack.remove(stack.size() - 1);
            else
                grandpaX = nil;
        }

        else {
            parentX = nil;
            grandpaX = nil;
        }


        while (x != root && x.color == 0) {

            if (x == parentX.left) {
                w = parentX.right;

                if (w.color == 1) {         // przypadek1
                    w.color = 0;
                    parentX.color = 1;
                    leftRotate(parentX);
                    w = parentX.right;
                }

                if (w.left.color == 0 && w.right.color == 0) {  // przypadek2
                    w.color = 1;

                    x = parentX;
                    parentX = grandpaX;
                    if (!stack.isEmpty())
                        grandpaX = stack.remove(stack.size()-1);
                    else
                        grandpaX = nil;
                }

                else if (w.right.color == 0) {          // przypadek 3
                    w.left.color = 0;
                    w.color = 0;
                    rightRotate(w);
                    w = parentX.right;
                }

                w.color = parentX.color;        // przypadek 4
                parentX.color = 0;              // przypadek 4
                w.right.color = 0;              // przypadek 4
                leftRotate(parentX);            // przypadek 4
                x = root;


            }

            else {
                w = parentX.left;

                if (w.color == 1) {         // przypadek1
                    w.color = 0;
                    parentX.color = 1;
                    rightRotate(parentX);
                    w = parentX.left;
                }

                if (w.right.color == 0 && w.left.color == 0) {  // przypadek2
                    w.color = 1;

                    x = parentX;
                    parentX = grandpaX;
                    if (!stack.isEmpty())
                        grandpaX = stack.remove(stack.size()-1);
                    else
                        grandpaX = nil;
                }

                else if (w.left.color == 0) {          // przypadek 3
                    w.right.color = 0;
                    w.color = 0;
                    leftRotate(w);
                    w = parentX.left;
                }

                w.color = parentX.color;        // przypadek 4
                parentX.color = 0;              // przypadek 4
                w.left.color = 0;              // przypadek 4
                rightRotate(parentX);            // przypadek 4
                x = root;

            }



            x.color = 0;


        }
    }






}
