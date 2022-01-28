package Za1;

import java.util.Comparator;
import java.util.List;

public class SelectSort<T> {

    private final Comparator<T> comparator;

    public SelectSort (Comparator<T> comparator) {
        this.comparator = comparator;
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

            for (int j = i+1; j < size; j++)
                if (comparator.compare(list.get(j), list.get(smallest)) < 0)
                    smallest = j;
            swap(list, smallest, i);
        }

        return list;
    }

}
