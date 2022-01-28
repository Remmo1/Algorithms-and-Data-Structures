package Za2;

import java.util.Comparator;
import java.util.List;

public class InsertSortWithCounter<T> {
    private final Comparator<T> comparator;
    private int counterComparing;
    private int counterRewriting;
    private boolean flag;

    public InsertSortWithCounter(Comparator<T> comparator) {
        this.comparator = comparator;
        this.counterComparing = 0;
        this.counterRewriting = 0;
        flag = false;
    }

    public List<T> sort(List<T> list) {

        for (int i = 0; i < list.size(); i++) {
            T actElem = list.get(i);
            T temp;
            int j;

            for  (j = i; j > 0 && comparator.compare(actElem, temp = list.get(j-1)) < 0 ; --j) {
                counterComparing++;
                list.set(j, temp);
                counterRewriting++;
            }

            list.set(j, actElem);
            counterRewriting++;
            counterComparing++;

        }

        return list;
    }

    public void results() {
        System.out.println("Ilość porównań: " + counterComparing);
        System.out.println("Ilość przepisań: " + counterRewriting);
        System.out.println("Ilość zamian: " + counterRewriting/3);
    }
}
