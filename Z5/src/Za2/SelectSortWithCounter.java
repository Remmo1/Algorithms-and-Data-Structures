package Za2;

import java.util.Comparator;
import java.util.List;

public class SelectSortWithCounter<T> {

    private final Comparator<T> comparator;
    private int counterChanges;
    private int counterComparing;

    public SelectSortWithCounter (Comparator<T> comparator) {
        this.comparator = comparator;
        counterChanges = 0;
        counterComparing = 0;
    }

    private void swap(List<T> list, int left, int right) {
        if (left != right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 0; i < size-1; i++) {
            int smallest = i;

            for (int j = i+1; j < size; j++) {
                if (comparator.compare(list.get(j), list.get(smallest)) < 0)
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
}
