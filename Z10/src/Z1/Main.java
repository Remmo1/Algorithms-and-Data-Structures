package Z1;

public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>(Integer::compareTo);

        bst.insert(7);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
        bst.insert(6);
        bst.insert(11);

        IntegerToStringExecutor executorInOrder = new IntegerToStringExecutor();
        IntegerToStringExecutor executorPreOrder = new IntegerToStringExecutor();
        IntegerToStringExecutor executorPostOrder = new IntegerToStringExecutor();

        // in-order
        bst.inOrderWalk(executorInOrder);
        System.out.println("In-order: " + executorInOrder.getResult());

        // pre-order
        bst.preOrderWalk(executorPreOrder);
        System.out.println("Pre-order: " + executorPreOrder.getResult());

        // post-order
        bst.postOrderWalk(executorPostOrder);
        System.out.println("Post-order: " + executorPostOrder.getResult());

        System.out.println("Węzeł o kluczu równym 7: " + bst.find(7));
        System.out.println("Węzeł o kluczu równym 80: " + bst.find(80));
        System.out.println("Minimum: " + bst.getMin());
        System.out.println("Maksimum: " + bst.getMax());
        System.out.println("Wysokość drzewa (korzeń to poziom 1): " + bst.height());
        System.out.println("Ilość węzłów: " + bst.amountOfNodes(executorInOrder));
        System.out.println("Ilość liści: " + bst.amountOfLeaves());
        bst.heightAndAmountOfNodesForEveryNode();
    }
}
