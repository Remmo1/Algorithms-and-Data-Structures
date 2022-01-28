package com.company;

import java.util.Random;

public class Main {

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
        int[][] dataBubble = new int[5][];
        dataBubble[0] = new int[8];
        dataBubble[1] = new int[32];
        dataBubble[2] = new int[128];
        dataBubble[3] = new int[512];
        dataBubble[4] = new int[1024];

        int[][] dataSelect = new int[5][];
        dataSelect[0] = new int[8];
        dataSelect[1] = new int[32];
        dataSelect[2] = new int[128];
        dataSelect[3] = new int[512];
        dataSelect[4] = new int[1024];

        int[][] dataInsert = new int[5][];
        dataInsert[0] = new int[8];
        dataInsert[1] = new int[32];
        dataInsert[2] = new int[128];
        dataInsert[3] = new int[512];
        dataInsert[4] = new int[1024];

        BubbleSort bubbleSort = new BubbleSort();
        InsertSort insertSort = new InsertSort();
        SelectSort selectSort = new SelectSort();


        // zbiór losowy:
        System.out.println("================= zbiór losowy ===================");
        Random r = new Random();
        int h;
        int maximum = 9;

        int a = 8;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < a; j++) {
                h = r.nextInt(maximum);
                data[i][j] = h;
                dataBubble[i][j] = h;
                dataSelect[i][j] = h;
                dataInsert[i][j] = h;
            }

            if (i == 3)
                a = 1024;
            else
                a *= 4;
        }

        Show(data);

        System.out.println("BubbleSort:");

        for (int i = 0; i < 5; i++) {
            bubbleSort.sort(dataBubble[i]);
            bubbleSort.results();
            System.out.println();
        }

        System.out.println("InsertSort:");

        for (int i = 0; i < 5; i++) {
            insertSort.sort(dataInsert[i]);
            insertSort.results();
            System.out.println();
        }

        System.out.println("SelectSort:");

        for (int i = 0; i < 5; i++) {
            selectSort.sort(dataSelect[i]);
            selectSort.results();
            System.out.println();
        }





        // zbiór odwrotny:
        System.out.println("================= zbiór odwrotny ===================");

        int j = 0;
        for (int i = data[0].length; i > 0; i--) {
            data[0][j] = i;
            dataBubble[0][j] = i;
            dataInsert[0][j] = i;
            dataSelect[0][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[1].length; i > 0; i--) {
            data[1][j] = i;
            dataBubble[1][j] = i;
            dataInsert[1][j] = i;
            dataSelect[1][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[2].length; i > 0; i--) {
            data[2][j] = i;
            dataBubble[2][j] = i;
            dataInsert[2][j] = i;
            dataSelect[2][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[3].length; i > 0; i--) {
            data[3][j] = i;
            dataBubble[3][j] = i;
            dataInsert[3][j] = i;
            dataSelect[3][j] = i;
            j++;
        }
        j = 0;
        for (int i = data[4].length; i > 0; i--) {
            data[4][j] = i;
            dataBubble[4][j] = i;
            dataInsert[4][j] = i;
            dataSelect[4][j] = i;
            j++;
        }

        // sortowanie


        Show(data);
        System.out.println("BubbleSort:");
        bubbleSort.clear();
        insertSort.clear();
        selectSort.clear();

        for (int i = 0; i < 5; i++) {
            bubbleSort.sort(dataBubble[i]);
            bubbleSort.results();
            System.out.println();
        }

        System.out.println("InsertSort:");

        for (int i = 0; i < 5; i++) {
            insertSort.sort(dataInsert[i]);
            insertSort.results();
            System.out.println();
        }

        System.out.println("SelectSort:");

        for (int i = 0; i < 5; i++) {
            selectSort.sort(dataSelect[i]);
            selectSort.results();
            System.out.println();
        }



        // zbiór posortowany:
        System.out.println("================= zbiór posortowany ===================");

        j = 0;
        for (int i = 0; i < data[0].length; i++) {
            data[0][j] = i;
            dataBubble[0][j] = i;
            dataInsert[0][j] = i;
            dataSelect[0][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[1].length; i++) {
            data[1][j] = i;
            dataBubble[1][j] = i;
            dataInsert[1][j] = i;
            dataSelect[1][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[2].length; i++) {
            data[2][j] = i;
            dataBubble[2][j] = i;
            dataInsert[2][j] = i;
            dataSelect[2][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[3].length; i++) {
            data[3][j] = i;
            dataBubble[3][j] = i;
            dataInsert[3][j] = i;
            dataSelect[3][j] = i;
            j++;
        }
        j = 0;
        for (int i = 0; i < data[4].length; i++) {
            data[4][j] = i;
            dataBubble[4][j] = i;
            dataInsert[4][j] = i;
            dataSelect[4][j] = i;
            j++;
        }

        // sortowanie


        Show(data);
        System.out.println("BubbleSort:");
        bubbleSort.clear();
        insertSort.clear();
        selectSort.clear();

        for (int i = 0; i < 5; i++) {
            bubbleSort.sort(dataBubble[i]);
            bubbleSort.results();
            System.out.println();
        }

        System.out.println("InsertSort:");

        for (int i = 0; i < 5; i++) {
            insertSort.sort(dataInsert[i]);
            insertSort.results();
            System.out.println();
        }

        System.out.println("SelectSort:");

        for (int i = 0; i < 5; i++) {
            selectSort.sort(dataSelect[i]);
            selectSort.results();
            System.out.println();
        }

    }
}
