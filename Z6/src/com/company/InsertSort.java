package com.company;


public class InsertSort {

    private int counterComparing;
    private int counterRewriting;

    public InsertSort() {
        this.counterComparing = 0;
        this.counterRewriting = 0;
    }

    public int[] sort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            int actElem = list[i];
            int j;

            for  (j = i; j > 0 && (actElem < list[j-1])  ; --j) {
                counterComparing++;
                list[j] = list[j-1];
                counterRewriting++;
            }

            list[j] = actElem;
            counterRewriting++;
            counterComparing++;

        }

        return list;
    }

    public void results() {
        System.out.println("Ilość porównań: " + counterComparing);
        System.out.println("Ilość przepisań: " + counterRewriting);
        System.out.println("Ilość zamian: " + counterRewriting/3);
    }

    public void clear() {
        this.counterComparing = 0;
        this.counterRewriting = 0;
    }
}
