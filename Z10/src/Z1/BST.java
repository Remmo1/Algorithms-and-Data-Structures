package Z1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST <T>{

    // węzeł
    static class Node<T> {
        T value;
        Node <T> left;
        Node <T> right;

        Node(T obj) {
            this.value = obj;
        }

        Node(T obj, Node <T> left, Node <T> right) {
            this.value = obj;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    // zmienne:
    private final Comparator<T> comparator;
    private Node <T> root;

    private int counterLeft;
    private int counterRight;
    private int counterNodes;
    private int leavesCounter;

    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }


    // szukanie
    private Node<T> search(T elem) {
        Node<T> node = root;
        int cmp;

        while (node != null && (cmp = comparator.compare(elem, node.value)) != 0) {
            node = cmp <0 ? node.left : node.right;
        }

        return node;
    }

    public T find (T elem) {
        Node <T> node = search(elem);
        return node == null ? null : node.value;
    }

    private boolean found = false;
    private boolean existsRec(Node node, int value) {

        if (node != null) {
            if ((int) node.value == value) {
                found = true;
            }


            if (value < (int) node.value)
                existsRec(node.left, value);

            else
                existsRec(node.right, value);
        }


       return found;

    }

    public boolean exists(int value) {

        found = false;
        return existsRec(root, value); // wywołanie metody rekurencyjnej (a)

    }



    // chodzenie
    private <R> void inOrderWalk(Node<T> node, IExecutor<T,R> executor) {
        if (node != null) {
            inOrderWalk(node.left, executor);
            executor.execute(node.value);
            counterNodes++;
            inOrderWalk(node.right, executor);
        }
    }

    public <R> void inOrderWalk (IExecutor<T,R> executor) {
        inOrderWalk(root, executor);
    }


    private <R> void preOrderWalk(Node<T> node, IExecutor<T,R> executor) {
        if (node != null) {
            executor.execute(node.value);
            preOrderWalk(node.left, executor);
            preOrderWalk(node.right, executor);
        }
    }

    public <R> void preOrderWalk(IExecutor<T,R> executor) {
        preOrderWalk(root, executor);
    }


    private <R> void postOrderWalk(Node<T> node, IExecutor<T,R> executor) {
        if (node != null) {
            postOrderWalk(node.left, executor);
            postOrderWalk(node.right,executor);
            executor.execute(node.value);
        }
    }

    public <R> void postOrderWalk(IExecutor<T,R> executor) {
        postOrderWalk(root, executor);
    }



    // minimum i maksimum
    private Node<T> getMin(Node<T> node) {
        assert (node != null);

        while (node.left != null) {
            node = node.left;
            counterLeft++;
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
            counterRight++;
        }

        return node;
    }

    public T getMax() {
        if (root == null)
            throw new NoSuchElementException();
        Node <T> node = getMax(root);
        return node.value;
    }

    // poprzednik
    public T predecessor(T value) {
        Node <T> node = predecessorNode(root, value);
        return node == null ? null : node.value;
    }

    private Node<T> predecessorNode(Node<T> node, T value) {
        if (node == null)
            throw new NoSuchElementException();

        int cmp = comparator.compare(value, node.value);

        if (cmp == 0) {
            if (node.left != null)
                return getMax(node.left);
            else
                return null;
        }

        else if(cmp > 0) {
            Node <T> retNode = predecessorNode(node.right, value);
            return retNode == null ? node : retNode;
        }

        else
            return predecessorNode(node.left, value);
    }



    // następnik
    private Node <T> successorNode(Node <T> node, T elem) {
        if (node == null)
            throw new NoSuchElementException();

        int cmp = comparator.compare(elem, node.value);

        if (cmp == 0) {
            if (node.right != null)
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
        return succNode == null ? null:succNode.value;
    }



    // dodawanie
    public void insert(T elem) {
        root = insert(root, elem);
    }

    private Node <T> insert(Node <T> node, T elem) {
        if (node == null) {
            node = new Node<>(elem);
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



    // usuwanie
    private Node<T> detachMin(Node<T> del, Node<T> node) {
        if (node.left != null)
            node.left = detachMin(node.left, del);

        else {
            del.value = node.value;
            node = node.right;
        }

        return node;
    }

    protected Node<T> delete(T elem, Node<T> node) {
        if (node == null)
            throw new NoSuchElementException();

        else {
            int cmp = comparator.compare(elem, node.value);

            if (cmp < 0)
                node.left = delete(elem, node.left);

            else  if (cmp > 0)
                node.right = delete(elem, node.right);

            else if (node.left != null && node.right != null)
                node.right = detachMin(node, node.right);

            else
                node = (node.left != null) ? node.left : node.right;
        }

        return node;
    }

    public void delete(T elem) {
        root = delete(elem, root);
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
    public<R> int amountOfNodes(IExecutor<T,R> executor) {
        return amountOfNodes(executor, root);
    }

    private <R> int amountOfNodes(IExecutor<T,R> executor, Node<T> node) {
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




    // ====================== zadanie 1b ===============
    public void showKeysLevels() {
        showKeysLevels(root);
        System.out.println();
    }

    private void showKeysLevels(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return;
        }


        ArrayList<T> queue = new ArrayList<>();
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

        for (Node<T> n :
                nodes) {
            queue.add(n.value);
        }

        int p = queue.size()-1;
        for (int i = 0; i < Math.pow(2, levelCounter); i++) {
            queue.remove(p-i);
        }

        int i = 1;
        int whenNewLine = 1;
        int powerConuter = 1;

        for (T integer :
                queue) {
            System.out.print(integer + " ");

            if (i == whenNewLine) {
                System.out.println();
                whenNewLine += Math.pow(2, powerConuter);
                powerConuter++;
            }

            i++;
        }

    }

    public void draw() {
        draw(root);
        System.out.println();
    }

    private void draw(Node<T> node) {
        if (node == null) {
            System.out.println("Puste drzewo");
            return;
        }


        ArrayList<T> queue = new ArrayList<>();
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

        for (Node<T> n :
                nodes) {
            queue.add(n.value);
        }

        int p = queue.size()-1;
        for (int i = 0; i < Math.pow(2, levelCounter); i++) {
            queue.remove(p-i);
        }

        int i = 1;
        int whenNewLine = 1;
        int powerConuter = 1;

        int amountOfSpaces = 40;
        int amountOfSlashes = 2;
        int oldAmountOfSlashes = 1;



        for (T integer :
                queue) {

            int a = 0;
            // wyświetlanie liczb ze spacjami
            if (powerConuter == 1) {
                for (int j = 0; j < amountOfSpaces / amountOfSlashes; j++) {
                    System.out.print(" ");
                }
                System.out.print(integer);
            }

            else {

                for (int k = 0; k < amountOfSpaces / (oldAmountOfSlashes+1); k++) {
                    System.out.print(" ");
                }
                a += 1;
                for (int j = 0; j < a; j++) {
                    System.out.print(" ");
                }

                if (integer == null)
                    System.out.print(0);
                else
                    System.out.print(integer);

            }

            if(i == queue.size())
                break;


            // wyświetlanie slashy
            if (i == whenNewLine) {
                System.out.println();

                int h = 1;
                for (int k = 1; k < (amountOfSlashes+1); k++) {

                    for (int j = 0; j < amountOfSpaces / (amountOfSlashes+1); j++) {
                        System.out.print(" ");
                    }

                    if (h == 1) {
                        System.out.print("/");
                        h = 0;
                    }

                    else {
                        System.out.print(" \\ ");
                        h = 1;
                    }

                }

                System.out.println();
                oldAmountOfSlashes = amountOfSlashes;
                amountOfSlashes += Math.pow(2, powerConuter);

                whenNewLine += Math.pow(2, powerConuter);
                powerConuter++;
            }

            i++;

        }

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

        IExecutor executor = new IExecutor() {
            final StringBuilder stringBuilder = new StringBuilder();


            @Override
            public void execute(Object elem) {
                stringBuilder.append(elem).append("; ");
            }

            @Override
            public String getResult() {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                return stringBuilder.toString();
            }
        };

        for (Node<T> n :
                nodes) {
            if (n.value != null) {
                System.out.print("Węzeł: " + n.value + " Wysokość poddrzewa (korzeń to poziom 1): " + height(n) + " Ilość węzłów z nim samym włącznie: " + amountOfNodes(executor, n));
                System.out.println();
            }

        }


    }

}
