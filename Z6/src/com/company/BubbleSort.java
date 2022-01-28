package com.company;

public class BubbleSort {

    private int counterChanges;
    private int counterComparing;

    public BubbleSort() {
        this.counterChanges = 0;
        this.counterComparing = 0;
    }

    private void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = (int) list[left];
            list[left] =  list[right];
            list[right] = temp;
        }
    }

    public int[] sort(int[] list) {
        int size = list.length;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < (size - i); j++) {
                int right = j + 1;
                if (list[j] > list[right]) {
                    swap(list, j, right);
                    counterChanges++;
                }
                counterComparing++;
            }
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
