package Za2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private final static int size = 1024;

    public static void randomData(List<Integer> list, int maximum) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maximum));
        }
    }

    public static void sortedList(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public static void reversedSortedList(List<Integer> list) {
        for (int i = size; i > 0; i--) {
            list.add(i);
        }
    }

    public static void show(List<Integer> list) {
        for (Integer i :
                list) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() ;


        //randomData(list, 100);
        //sortedList(list);
        reversedSortedList(list);
        show(list);

        /*
        BubbleSortWithCounter<Integer> bubbleSortWithCounter = new BubbleSortWithCounter<>(Integer::compareTo);
        bubbleSortWithCounter.sort(list);
        show(list);
        bubbleSortWithCounter.results();

        SelectSortWithCounter<Integer> selectSortWithCounter = new SelectSortWithCounter<>(Integer::compareTo);
        selectSortWithCounter.sort(list);
        show(list);
        selectSortWithCounter.results();

         */

        InsertSortWithCounter<Integer> integerInsertSortWithCounter = new InsertSortWithCounter<>(Integer::compareTo);
        integerInsertSortWithCounter.sort(list);
        show(list);
        integerInsertSortWithCounter.results();
    }
}
