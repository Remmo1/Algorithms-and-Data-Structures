package Zadanie2;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int amountOfTests = 10;
    private static final int numberToRandom = 1000000;

    private static int []t;
    private static final int size = 100000;

    public static void fillTableWithRandomsWithoutRepeats() {
        ArrayList<Integer> repeat = new ArrayList<>();
        Random r = new Random();
        int a;

        for (int i = 0; i < size; i++) {
            a = r.nextInt(numberToRandom);

            while (repeat.contains(a)) {
                a = r.nextInt(numberToRandom);
            }

            repeat.add(a);
            t[i] = a;

        }
    }

    public static void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(t[i]);
        }
    }

    public static int lineSearching(int searched) {
        int amountOfComparing = 0;

        for (int i = 0; i < size; i++) {
            amountOfComparing++;
            if (t[i] == searched)
                return amountOfComparing;

        }
        return amountOfComparing;
    }

    public static int binarySearch(int searched) {
        int amountOfComparing = 0;

        int left = 0;
        int right = t.length-1;
        int middle;

        while (left <= right) {

            middle = (left + right) / 2;
            amountOfComparing++;

            if (searched == t[middle])
                return amountOfComparing;

            if (searched < t[middle])
                right = middle - 1;

            else
                left = middle + 1;
        }

        return amountOfComparing;
    }



    private static boolean containsOnTable(int a) {
        for (int i = 0; i < size; i++) {
            if (t[i] == a)
                return true;
        }
        return false;
    }

    private static int chooseToSearch() {
        Random r = new Random();
        int a = r.nextInt(size);

        return t[a];
    }

    private static int chooseNumberThatIsNotInTable() {
        for (int i = 0; i < size; i++) {
            if (!containsOnTable(i))
                return i;
        }

        return 0;
    }






    public static void main(String[] args) {
        t = new int[size];
        HeapSort heapSort = new HeapSort();
        long avrLineOK = 0, avrBinaryOk = 0, avrLineNotOk = 0, avrBinaryNotOk = 0;
        int p;

        // trafione
        for (int i = 0; i < amountOfTests; i++) {
            fillTableWithRandomsWithoutRepeats();
            p = lineSearching(chooseToSearch());

            System.out.print("Ilość porównań liniowych: " + p);
            avrLineOK += p;

            heapSort.sort(t);
            p = binarySearch(chooseToSearch());
            System.out.println(" Ilość porównań binarnych: " + binarySearch(chooseToSearch()));
            avrBinaryOk += p;
        }

        System.out.println();
        System.out.println("============== porównania trafione =====================");
        System.out.println("Wyszukiwanie liniowe: " + avrLineOK/amountOfTests);
        System.out.println("Wyszukiwanie binarne: " + avrBinaryOk/amountOfTests);
        System.out.println("=========================================================");
        System.out.println();

        // chybione
        for (int i = 0; i < amountOfTests; i++) {
            fillTableWithRandomsWithoutRepeats();
            p = lineSearching(chooseNumberThatIsNotInTable());

            System.out.print("Ilość porównań liniowych: " + p);
            avrLineNotOk += p;

            heapSort.sort(t);
            p = binarySearch(chooseNumberThatIsNotInTable());
            System.out.println(" Ilość porównań binarnych: " + p);
            avrBinaryNotOk += p;
        }


        System.out.println();
        System.out.println("============== porównania chybione =====================");
        System.out.println("Wyszukiwanie liniowe: " + avrLineNotOk/amountOfTests);
        System.out.println("Wyszukiwanie binarne: " + avrBinaryNotOk/amountOfTests);
        System.out.println("=========================================================");
        System.out.println();

        System.out.println();
        System.out.println("============== łączna średnia ilość porównań =====================");
        System.out.println("Wyszukiwanie liniowe: " + (avrLineOK + avrLineNotOk)/amountOfTests);
        System.out.println("Wyszukiwanie binarne: " + (avrBinaryOk + avrBinaryNotOk)/amountOfTests);
        System.out.println("=========================================================");
        System.out.println();





    }
}
