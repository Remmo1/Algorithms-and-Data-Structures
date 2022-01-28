package Za2;

import java.util.Comparator;
import java.util.List;

public class BubbleSortWithCounter<T> {

    private final Comparator<T> comparator;
    private int counterChanges;
    private int counterComparing;

    public BubbleSortWithCounter(Comparator <T> comparator) {

        this.comparator = comparator;
        this.counterChanges = 0;
        this.counterComparing = 0;
    }

    private void swap(List<T> list, int left, int right) {
        if (left != right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right,temp);
        }
    }

    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < (size - i); j++) {
                int right = j + 1;
                if (comparator.compare(list.get(j), list.get(right)) > 0) {
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

}
