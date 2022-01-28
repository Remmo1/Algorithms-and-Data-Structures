package zadanie2;

import java.util.HashSet;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>(Integer::compareTo);
        RedBlackTree rbTree = new RedBlackTree();
        BTree<Integer> bTree = new BTree<>(Integer::compareTo);

        Integer[][] data = new Integer[4][];

        data[0] = new Integer[10];
        data[1] = new Integer[100];
        data[2] = new Integer[1000];
        data[3] = new Integer[10000];

        // ciąg losowy:
        System.out.println(" ======================= losowy ===========================");

        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        int a;

        // tych nie ma
        Integer[] notFound = new Integer[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < data[i].length; j++) {
                a = random.nextInt((data[i].length*10) + 1);
                hashSet.add(a);
            }

            while (hashSet.size() < data[i].length) {
                a = random.nextInt((data[i].length*10) + 1);
                hashSet.add(a);
            }

            a = random.nextInt((data[i].length*10) + 1);
            while (hashSet.contains(a)) {
                a = random.nextInt((data[i].length*10) + 1);
            }
            notFound[i] = a;


            data[i] = hashSet.toArray(new Integer[0]);
            hashSet.clear();
        }

        // te są w tablicy
        Integer[] found = new Integer[4];
        for (int i = 0; i < 4; i++) {
            a = random.nextInt(data[i].length);
            found[i] = data[i][a];
        }




        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < data[i].length; j++) {
                bst.insert(data[i][j]);
                rbTree.insert(data[i][j]);
                bTree.BTreeInsert(data[i][j]);
            }

            bst.find(found[i]);
            System.out.println("Bst trafiony: " + bst.getAmountOfComparing());

            rbTree.find(found[i]);
            System.out.println("RB trafiony: " + rbTree.getAmountOfComparing());

            bTree.find(found[i]);
            System.out.println("2-3-4Tree trafiony: " + bTree.getAmountOfComparing());

            System.out.println();

            bst.find(notFound[i]);
            System.out.println("Bst chybiony: " + bst.getAmountOfComparing());

            rbTree.find(notFound[i]);
            System.out.println("RB chybiony: " + rbTree.getAmountOfComparing());

            bTree.find(notFound[i]);
            System.out.println("2-3-4Tree chybiony: " + bTree.getAmountOfComparing());

            bst.clear();
            rbTree.clear();
            bTree.clear();

            System.out.println("==========================");

        }





        bst.clear();
        rbTree.clear();
        bTree.clear();

        // ciąg posortowany
        System.out.println(" ======================= posortowany ===========================");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < data[i].length; j++) {
                hashSet.add(j);
            }

            a = random.nextInt((data[i].length*10) + 1);
            while (hashSet.contains(a)) {
                a = random.nextInt((data[i].length*10) + 1);
            }
            notFound[i] = a;


            data[i] = hashSet.toArray(new Integer[0]);
            hashSet.clear();
        }

        // te są w tablicy
        for (int i = 0; i < 4; i++) {
            a = random.nextInt(data[i].length);
            found[i] = data[i][a];
        }




        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < data[i].length; j++) {
                bst.insert(data[i][j]);
                rbTree.insert(data[i][j]);
                bTree.BTreeInsert(data[i][j]);
            }

            bst.find(found[i]);
            System.out.println("Bst trafiony: " + bst.getAmountOfComparing());

            rbTree.find(found[i]);
            System.out.println("RB trafiony: " + rbTree.getAmountOfComparing());

            bTree.find(found[i]);
            System.out.println("2-3-4Tree trafiony: " + bTree.getAmountOfComparing());

            System.out.println();

            bst.find(notFound[i]);
            System.out.println("Bst chybiony: " + bst.getAmountOfComparing());

            rbTree.find(notFound[i]);
            System.out.println("RB chybiony: " + rbTree.getAmountOfComparing());

            bTree.find(notFound[i]);
            System.out.println("2-3-4Tree chybiony: " + bTree.getAmountOfComparing());

            bst.clear();
            bst.clear();
            bst.clear();

            System.out.println("==========================");

        }




    }

}
