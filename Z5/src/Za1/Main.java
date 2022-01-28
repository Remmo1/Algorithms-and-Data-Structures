package Za1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void Show(List<Osoba> list) {
        for (Osoba o :
                list) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Osoba o1 = new Osoba("Nowak", "Kamil", "2000.05.02");
        Osoba o2 = new Osoba("Kowalski", "Jan", "1995.06.13");
        Osoba o3 = new Osoba("Nowak", "Marek", "1999.08.20");
        Osoba o4 = new Osoba("Blicharski", "Andrzek", "2001.07.16");
        Osoba o5 = new Osoba("Nowak", "Kamil", "1970.11.25");

        List<Osoba> people = new ArrayList<>();
        people.add(o1);
        people.add(o2);
        people.add(o3);
        people.add(o4);
        people.add(o5);

        Show(people);

        // 1a
        System.out.println("======================= 1a ==========================");

        BubbleSort<Osoba> bubbleSort = new BubbleSort<>(Comparator.comparing(Osoba::getSurN));
        InsertSort<Osoba> insertSort = new InsertSort<>(Comparator.comparing(Osoba::getName));
        SelectSort<Osoba> selectSort = new SelectSort<>(Comparator.comparing(Osoba::getDateOfBirth));

        bubbleSort.sort(people);
        Show(people);

        insertSort.sort(people);
        Show(people);

        selectSort.sort(people);
        Show(people);

        // 1b
        System.out.println("======================= 1b ==========================");

        compoundComparator<Osoba> compoundComparator = new compoundComparator<>();
        compoundComparator.addComparator(Comparator.comparing(Osoba::getSurN));
        compoundComparator.addComparator(Comparator.comparing(Osoba::getName));
        compoundComparator.addComparator(Comparator.comparing(Osoba::getDateOfBirth));

        BubbleSort<Osoba> bubbleSort2 = new BubbleSort<>(compoundComparator);
        bubbleSort2.sort(people);
        Show(people);

        //1c
        System.out.println("======================= 1c ==========================");
        InsertSort<Osoba> insertSort2 = new InsertSort<>((o11, o21) -> {
            if (o11.getSurN().compareTo(o21.getSurN()) == 0) {
                if (o11.getName().compareTo(o21.getName()) == 0)
                    return o11.getDateOfBirth().compareTo(o21.getDateOfBirth());

                return o11.getName().compareTo(o21.getName());
            }

            return o11.getSurN().compareTo(o21.getSurN());
        });

        insertSort2.sort(people);
        Show(people);





    }
}
