package Z2;


import Z1.MergeSort;

import java.util.Random;

public class Main2 {


    private static final QuickSort quickSort = new QuickSort();
    private static final MergeSort mergeSort = new MergeSort();
    private static final HeapSort heapSort = new HeapSort();


    public static void main(String[] args) {

        // dane główne
        int[][] data = new int[3][];

        data[0] = new int[10000];
        data[1] = new int[100000];
        data[2] = new int[1000000];


        // kopia do tablic żeby każdy algorytm liczył to samo
        int[][] dataQuick = new int[3][];
        dataQuick[0] = new int[10000];
        dataQuick[1] = new int[100000];
        dataQuick[2] = new int[1000000];

        int[][] dataMerge = new int[3][];
        dataMerge[0] = new int[10000];
        dataMerge[1] = new int[100000];
        dataMerge[2] = new int[1000000];

        int[][] dataHeap = new int[3][];
        dataHeap[0] = new int[10000];
        dataHeap[1] = new int[100000];
        dataHeap[2] = new int[1000000];



        // ========================= Zadanie 2 =================================
        System.out.println("================= Zadanie 2 ===================");

        long milisActualTime;
        long executionTime;

        // zbiór losowy:
        System.out.println("================= zbiór losowy ===================");
        Random r = new Random();
        int h;
        int maximum = 2500;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < data[i].length; j++) {
                h = r.nextInt(maximum);
                data[i][j] = h;
                dataQuick[i][j] = h;
                dataMerge[i][j] = h;
                dataHeap[i][j] = h;
            }
        }

        // sortowanie:

        System.out.println("quickSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            quickSort.quickSort(dataQuick[i], 0, dataQuick[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();


        System.out.println("mergeSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }

        System.out.println();


        System.out.println("heapSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            heapSort.sort(dataHeap[i]);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();




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

        // sortowanie:

        System.out.println("quickSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            quickSort.quickSort(dataQuick[i], 0, dataQuick[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();


        System.out.println("mergeSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();


        System.out.println("heapSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            heapSort.sort(dataHeap[i]);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();






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

        // sortowanie:

        System.out.println("quickSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            quickSort.quickSort(dataQuick[i], 0, dataQuick[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();


        System.out.println("mergeSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            mergeSort.mergeSort(dataMerge[i], 0, dataMerge[i].length - 1);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();


        System.out.println("heapSort:");
        for (int i = 0; i < 3; i++) {
            milisActualTime = System.currentTimeMillis();
            heapSort.sort(dataHeap[i]);
            executionTime = System.currentTimeMillis() - milisActualTime;
            System.out.println("Czas trwania algorytmu dla " + data[i].length + " elementów: " + executionTime);
        }
        System.out.println();

    }


}
