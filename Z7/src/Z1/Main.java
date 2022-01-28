package Z1;

import Z2.HeapSort;

import java.util.Random;

public class Main {

    // algorytmy:
    private static QuickSort quickSort = new QuickSort();
    private static MergeSort mergeSort = new MergeSort();

    // metody pomocnicze:
    public static void Show(int[][] data) {

        int a = 8;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();

            if (i == 3)
                a = 1024;
            else
                a *= 4;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // dane główne
        int[][] data = new int[5][];

        data[0] = new int[8];
        data[1] = new int[32];
        data[2] = new int[128];
        data[3] = new int[512];
        data[4] = new int[1024];


        // kopia do tablic żeby każdy algorytm liczył to samo
        int[][] dataQuick = new int[5][];
        dataQuick[0] = new int[8];
        dataQuick[1] = new int[32];
        dataQuick[2] = new int[128];
        dataQuick[3] = new int[512];
        dataQuick[4] = new int[1024];

        int[][] dataMerge = new int[5][];
        dataMerge[0] = new int[8];
        dataMerge[1] = new int[32];
        dataMerge[2] = new int[128];
        dataMerge[3] = new int[512];
        dataMerge[4] = new int[1024];



        // ========================= Zadanie 1 =================================
        System.out.println("================= Zadanie 1 ===================");

        // zbiór losowy:
        System.out.println("================= zbiór losowy ===================");
        Random r = new Random();
        int h;
        int maximum = 2500;

        int a = 8;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a; j++) {
                h = r.nextInt(maximum);
                data[i][j] = h;
                dataQuick[i][j] = h;
                dataMerge[i][j] = h;
            }

            if (i == 3)
                a = 1024;
            else
                a *= 4;
        }

        Show(data);

        System.out.println("quickSort:");

        for (int i = 0; i < 5; i++) {
            quickSort.sort(dataQuick[i]);
            quickSort.results();
            System.out.println();
        }

        System.out.println("mergeSort:");

        for (int i = 0; i < 5; i++) {
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            mergeSort.results();
            System.out.println();
        }



        // zbiór odwrotny:
        System.out.println("================= zbiór odwrotny ===================");

        int j = 0;
        for (int i = data[0].length; i > 0; i--) {
            data[0][j] = i;
            dataQuick[0][j] = i;
            dataMerge[0][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[1].length; i > 0; i--) {
            data[1][j] = i;
            dataQuick[1][j] = i;
            dataMerge[1][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[2].length; i > 0; i--) {
            data[2][j] = i;
            dataQuick[2][j] = i;
            dataMerge[2][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[3].length; i > 0; i--) {
            data[3][j] = i;
            dataQuick[3][j] = i;
            dataMerge[3][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[4].length; i > 0; i--) {
            data[4][j] = i;
            dataQuick[4][j] = i;
            dataMerge[4][j] = i;
            j++;
        }

        // sortowanie


        Show(data);
        System.out.println("quickSort:");
        quickSort.clear();
        mergeSort.clear();

        for (int i = 0; i < 5; i++) {
            quickSort.sort(dataQuick[i]);
            quickSort.results();
            System.out.println();
        }

        System.out.println("mergeSort:");

        for (int i = 0; i < 5; i++) {
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            mergeSort.results();
            System.out.println();
        }



        // zbiór posortowany:
        System.out.println("================= zbiór posortowany ===================");

        j = 0;
        for (int i = 0; i < data[0].length; i++) {
            data[0][j] = i;
            dataQuick[0][j] = i;
            dataMerge[0][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[1].length; i++) {
            data[1][j] = i;
            dataQuick[1][j] = i;
            dataMerge[1][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[2].length; i++) {
            data[2][j] = i;
            dataQuick[2][j] = i;
            dataMerge[2][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[3].length; i++) {
            data[3][j] = i;
            dataQuick[3][j] = i;
            dataMerge[3][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[4].length; i++) {
            data[4][j] = i;
            dataQuick[4][j] = i;
            dataMerge[4][j] = i;
            j++;
        }

        // sortowanie


        Show(data);
        System.out.println("quickSort:");
        quickSort.clear();
        mergeSort.clear();

        for (int i = 0; i < 5; i++) {
            quickSort.sort(dataQuick[i]);
            quickSort.results();
            System.out.println();
        }

        System.out.println("mergeSort:");

        for (int i = 0; i < 5; i++) {
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            mergeSort.results();
            System.out.println();
        }
        
    }
}
