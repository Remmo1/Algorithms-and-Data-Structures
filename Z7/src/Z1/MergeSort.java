package Z1;

public class MergeSort {

    private int counterChanges;
    private int counterComparing;

    void merge(int arr[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                counterComparing++;
                arr[k] = L[i];
                counterChanges++;
                i++;
            }
            else {
                arr[k] = M[j];
                counterChanges++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            counterComparing++;
            arr[k] = L[i];
            counterChanges++;
            i++;
            k++;
        }

        while (j < n2) {
            counterComparing++;
            arr[k] = M[j];
            counterChanges++;
            j++;
            k++;
        }
    }

    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
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
