package Za1;

import java.util.Comparator;
import java.util.List;

public class InsertSort<T> {

    private final Comparator<T> comparator;

    public InsertSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> sort(List<T> list) {

        for (int i = 0; i < list.size(); i++) {
            T actElem = list.get(i);
            T temp;
            int j;

            for  (j = i; j > 0 && comparator.compare(actElem, temp = list.get(j-1)) < 0 ; --j) {
                list.set(j, temp);
            }

            list.set(j, actElem);
        }

        return list;
    }
}
