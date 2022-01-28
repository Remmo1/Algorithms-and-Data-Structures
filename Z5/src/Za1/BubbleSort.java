package Za1;

import java.util.Comparator;
import java.util.List;

public class BubbleSort <T> {

    private final Comparator<T> comparator;

    public BubbleSort(Comparator <T> comparator) {
        this.comparator = comparator;
    }

    private void swap(List<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right,temp);
    }

    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < (size - i); j++) {
                int right = j + 1;
                if (comparator.compare(list.get(j), list.get(right)) > 0) {
                    swap(list, j, right);
                }
            }
        }

        return list;
    }
}
