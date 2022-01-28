package Z2;

import Z1.BST;
import Z1.IntegerToStringExecutor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

    public static void menu() {
        System.out.println("================ Drzewo BST liczby całkowite =================================");
        System.out.println("========        [1] Wstawienie do drzewa                            ==========");
        System.out.println("========        [2] Wyświetlenie inorder                            ==========");
        System.out.println("========        [3] Wyświetlenie preorder                           ==========");
        System.out.println("========        [4] Wyświetlenie postorder                          ==========");
        System.out.println("========        [5] Szukaj węzła po kluczu                          ==========");
        System.out.println("========        [6] Znajdź minimum i maksimum                       ==========");
        System.out.println("========        [7] Pokaż wysokość, ilość węzłów oraz liści         ==========");
        System.out.println("========        [8] Wyświetl klucze poziomami                       ==========");
        System.out.println("========        [9] Wyznacz poprzednika i następnika                ==========");
        System.out.println("========        [10] Usuń węzeł                                     ==========");
        System.out.println("========        [11] Wysokość i liczba węzłów dla każdego poddrzewa ==========");
        System.out.println("========        [12] Rysuj drzewo                                   ==========");
        System.out.println("========        [0] Wyjście                                         ==========");
    }


    public static int PodajNaturalna() {

        Scanner sc = new Scanner(System.in);
        int w;

        while(true) {

            try {
                w = sc.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Podaj liczbę a nie ciąg znaków: ");
                sc.next();
            }
        }
        return Math.abs(w);
    }


    public static void main(String[] args) {

        BST<Integer> bst = new BST<>(Integer::compareTo);
        boolean exit = false;

        IntegerToStringExecutor executorInOrder = new IntegerToStringExecutor();
        IntegerToStringExecutor executorPreOrder = new IntegerToStringExecutor();
        IntegerToStringExecutor executorPostOrder = new IntegerToStringExecutor();

        do {

            menu();

            switch (PodajNaturalna()) {
                case 1 -> {
                    System.out.print("Podaj liczbę: ");
                    bst.insert(PodajNaturalna());
                }

                case 2 -> {
                    bst.inOrderWalk(executorInOrder);
                    System.out.println(executorInOrder.getResult());
                }

                case 3 -> {
                    bst.preOrderWalk(executorPreOrder);
                    System.out.println(executorPreOrder.getResult());
                }

                case 4 -> {
                    bst.postOrderWalk(executorPostOrder);
                    System.out.println(executorPostOrder.getResult());
                }

                case 5 -> {
                    System.out.print("Podaj klucz: ");
                    System.out.println(bst.find(PodajNaturalna()));
                }

                case 6 -> {
                    System.out.println("Maksimum: " + bst.getMax());
                    System.out.println("Minimum: " + bst.getMin());
                }

                case 7 -> {
                    IntegerToStringExecutor executor = new IntegerToStringExecutor();
                    System.out.println("Wysokość: " + bst.height());
                    System.out.println("Ilość węzłów: " + bst.amountOfNodes(executor));
                    System.out.println("Ilość liści: " + bst.amountOfLeaves());
                }

                case 8 -> bst.showKeysLevels();

                case 9 -> {
                    System.out.print("Podaj klucz: ");
                    int a = PodajNaturalna();
                    System.out.println("Poprzednik: " + bst.predecessor(a));
                    System.out.println("Następnik: " + bst.successor(a));
                }

                case 10 -> {
                    System.out.print("Podaj klucz: ");
                    bst.delete(PodajNaturalna());
                }

                case 11 -> bst.heightAndAmountOfNodesForEveryNode();


                case 12 -> bst.draw();



                case 0 -> exit = true;
            }


        } while (!exit);
    }
}
