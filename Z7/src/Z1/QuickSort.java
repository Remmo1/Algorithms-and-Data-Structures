package Z1;

import java.util.Random;

public class QuickSort {

    private final Random random;
    private int counterChanges;
    private int counterComparing;

    public QuickSort() {
        this.random = new Random();
    }

    public int[] sort(int[] list) {
        quicksort(list, 0, list.length);
        return list;
    }

    private void quicksort(int[] list, int startIndex, int endIndex) {

        if (endIndex - startIndex > 1) {

            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition );
            quicksort(list, partition + 1, endIndex);
        }
    }


    private int partition(int[] list, int nFrom, int nTo) {

        //jako element dzielący bierzemy losowy
        int rnd = nFrom+random.nextInt(nTo-nFrom);
        swap(list,nFrom,rnd);
        int value = list[nFrom];
        int idxBigger = nFrom+1, idxLower=nTo-1;

        do {
            while(idxBigger <= idxLower && list[idxBigger] <= value) {
                idxBigger++;
                counterComparing++;
            }

            while(list[idxLower] > value) {
                idxLower--;
                counterComparing++;
            }

            if(idxBigger < idxLower) {
                swap(list,idxBigger,idxLower);
                counterComparing++;
            }

        } while(idxBigger < idxLower);

        swap(list,idxLower,nFrom);
        return idxLower;
    }

    private void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            counterChanges++;
        }
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
