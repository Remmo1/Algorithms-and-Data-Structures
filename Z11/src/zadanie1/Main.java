package zadanie1;

public class Main {
    public static void main(String[] args) {
        RBTree<Integer> treeRB = new RBTree<>(Integer::compareTo);

        treeRB.rbInsert(50);
        treeRB.rbInsert(45);
        treeRB.rbInsert(60);
        treeRB.rbInsert(30);
        treeRB.rbInsert(47);
        treeRB.rbInsert(55);
        treeRB.rbInsert(80);
        treeRB.rbInsert(20);
        treeRB.rbInsert(43);
        treeRB.rbInsert(46);
        treeRB.rbInsert(48);

        // przykłady z wykładu
        treeRB.rbInsert(35);
        treeRB.rbInsert(49);
        treeRB.rbInsert(37);

        // symetryczny do insert(37)
        treeRB.rbInsert(25);
        treeRB.rbInsert(22);

        System.out.println("Klucz o wartości 35: " + treeRB.find(35));
        System.out.print("Klucz o wartości 100:");
        if (treeRB.find(100) == null)
            System.out.println(" brak");

        StringToStringExecutor inOrder = new StringToStringExecutor();
        StringToStringExecutor postOrder = new StringToStringExecutor();
        StringToStringExecutor preOrder = new StringToStringExecutor();

        treeRB.preOrderWalk(preOrder);
        System.out.println("pre-order: " + preOrder.getResult());

        treeRB.inOrderWalk(inOrder);
        System.out.println("in-order: " + inOrder.getResult());

        treeRB.postOrderWalk(postOrder);
        System.out.println("post-order: " + postOrder.getResult());
        System.out.println();

        treeRB.showKeysLevels();

        treeRB.heightAndAmountOfNodesForEveryNode();


        System.out.println();
        RBTree<Integer> rbTree2 = new RBTree<>(Integer::compareTo);
        rbTree2.rbInsert(45);
        rbTree2.rbInsert(30);
        rbTree2.rbInsert(50);
        rbTree2.rbInsert(20);
        rbTree2.rbInsert(43);
        rbTree2.rbInsert(47);
        rbTree2.rbInsert(60);
        rbTree2.rbInsert(35);
        rbTree2.rbInsert(46);
        rbTree2.rbInsert(48);
        rbTree2.rbInsert(53);
        rbTree2.rbInsert(80);
        rbTree2.rbInsert(52);
        rbTree2.rbInsert(55);

        rbTree2.showKeysLevels();

        // przykłady z wykładu
        rbTree2.delete(50);
        rbTree2.delete(43);
        rbTree2.delete(35);

        rbTree2.showKeysLevels();


    }

}
