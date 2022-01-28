package zadanie2;


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
    }


    private final Comparator<T> comparator;
    private Node <T> root;

    // lab 12
    private int amountOfComparing;
    public int getAmountOfComparing() { return amountOfComparing; }

    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
        amountOfComparing = 0;
    }



    // czyszczenie
    public void clear() {
        root = null;
    }


    // szukanie
    private Node<T> search(T elem) {
        Node<T> node = root;
        int cmp;

        while (node != null && (cmp = comparator.compare(elem, node.value)) != 0) {
            amountOfComparing++;
            node = cmp <0 ? node.left : node.right;
        }

        return node;
    }

    public T find (T elem) {
        amountOfComparing = 0;
        Node <T> node = search(elem);
        return node == null ? null : node.value;
    }



    /*
    // chodzenie
    private <R> void inOrderWalk(Node<T> node, IExecutor<T,R> executor) {
        if (node != null) {
            inOrderWalk(node.left, executor);
            executor.execute(node.value);
            inOrderWalk(node.right, executor);
        }
    }

    public <R> void inOrderWalk (IExecutor<T,R> executor) {
        inOrderWalk(root, executor);
    }


     */

    // minimum i maksimum
    private Node<T> getMin(Node<T> node) {
        assert (node != null);

        while (node.left != null) {
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

}

