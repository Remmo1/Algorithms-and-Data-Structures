package Za1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class compoundComparator<T> implements Comparator<T> {

    private final List<Object> comparators = new ArrayList<>();

    public void addComparator(Comparator<T> comparator) {
        comparators.add(comparator);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compare(T left, T right) {
        int result = 0;
        for (Object o :
                comparators) {
            Comparator<T> comp = (Comparator<T>) o;
            result = comp.compare(left, right);

            if(result != 0)
                break;
        }

        return result;
    }
}
