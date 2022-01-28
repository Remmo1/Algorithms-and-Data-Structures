package com.company;


public class SelectSort{

    private int counterChanges;
    private int counterComparing;

    public SelectSort () {
        counterChanges = 0;
        counterComparing = 0;
    }

    private void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] =  temp;
        }
    }

    public int[] sort(int[] list) {
        int size = list.length;

        for (int i = 0; i < size-1; i++) {
            int smallest = i;

            for (int j = i+1; j < size; j++) {
                if (list[j] < list[smallest])
                    smallest = j;
                counterComparing++;
            }

            swap(list, smallest, i);
            counterChanges++;
        }

        return list;
    }

    public void results() {
        System.out.println("Ilość porównań: " + counterComparing);
        System.out.println("Ilość przepisań: " + counterChanges*3);
        System.out.println("Ilość zamian: " + counterChanges);
    }

    public void clear() {
        this.counterChanges = 0;
        this.counterComparing = 0;
    }
}
