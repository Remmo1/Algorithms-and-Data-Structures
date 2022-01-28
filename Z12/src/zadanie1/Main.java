package zadanie1;

public class Main {
    public static void main(String[] args) {

        // tablica bez kompresji i równoważenia
        System.out.println("=============== Tablica bez kompresij i równoważenia =============");
        SetOnTable<Integer> setOnTable = new SetOnTable<>(8);

        // stworzenie ośmiu zbiorów rozłącznych
        // 1,2,3,4,5,6,7,8
        for (int i = 0; i < 8; i++) {
            setOnTable.makeSet(i+1);
        }

        // połączenie ich w pary
        // 1,2      3,4     5,6     7,8
        for (int i = 0; i < 8; i = i + 2) {
            setOnTable.union(i+1, i+2);
        }

        // połączenie zbiorów 1,2,3,4,5,6 w jeden duży zbiór
        setOnTable.union(1, 3);
        setOnTable.union(1, 5);

        System.out.println("Reprezentant zbioru z 1: " + setOnTable.findSet(1));
        System.out.println("Reprezentant zbioru z 3: " + setOnTable.findSet(3));
        System.out.println("Reprezentant zbioru z 7: " + setOnTable.findSet(7));
        setOnTable.draw();
        System.out.println();


        // tablica z kompresją ścieżek
        System.out.println("\n=============== Tablica z kompresją ścieżek =============");
        SetOnTablePathCompress<Integer> setOnTablePathCompress = new SetOnTablePathCompress<>(8);

        for (int i = 0; i < 8; i++) {
            setOnTablePathCompress.makeSet(i+1);
        }

        for (int i = 0; i < 8; i = i + 2) {
            setOnTablePathCompress.union(i+1, i+2);
        }


        setOnTablePathCompress.union(1, 3);
        setOnTablePathCompress.union(1, 5);

        System.out.println("Reprezentant zbioru z 1: " + setOnTablePathCompress.findSet(1));
        System.out.println("Reprezentant zbioru z 3: " + setOnTablePathCompress.findSet(3));
        System.out.println("Reprezentant zbioru z 7: " + setOnTablePathCompress.findSet(7));
        setOnTablePathCompress.draw();
        System.out.println();

        // las z kompresją ścieżek
        /*
        zmienione liczby dla lasów,
        teraz osiem zbiorów to
        0,1,2,3,4,5,6,7
         */
        System.out.println("\n=============== Las z kompresją ścieżek =============");
        SetForestPathCompress<Integer> setForestPathCompress = new SetForestPathCompress<>();
        SetForestPathCompress<Integer>.Node<Integer>[] t = new SetForestPathCompress.Node[8];
        for (int i = 0; i < 8; i++) {
            t[i] = setForestPathCompress.makeSet(i);
        }

        for (int i = 0; i < 8; i = i + 2) {
            setForestPathCompress.union(t[i], t[i+1]);
        }

        setForestPathCompress.union(t[0], t[2]);
        setForestPathCompress.union(t[0], t[4]);

        System.out.println("Reprezentant zbioru z 1: " + setForestPathCompress.findSet(t[1]).value);
        System.out.println("Reprezentant zbioru z 3: " + setForestPathCompress.findSet(t[3]).value);
        System.out.println("Reprezentant zbioru z 6: " + setForestPathCompress.findSet(t[6]).value);
        setForestPathCompress.draw();
        System.out.println();




        // las z równoważeniem wysokości (rangi) i kompresją ścieżek
        System.out.println("\n=============== Las z kompresją ścieżek i rangami =============");
        SetForestWithRanks<Integer> setForestWithRanks = new SetForestWithRanks<>();
        SetForestWithRanks<Integer>.Node<Integer>[] t2 = new SetForestWithRanks.Node[8];

        for (int i = 0; i < 8; i++) {
            t2[i] = setForestWithRanks.makeSet(i);
        }

        for (int i = 0; i < 8; i = i + 2) {
            setForestWithRanks.union(t2[i], t2[i+1]);
        }

        setForestWithRanks.union(t2[0], t2[2]);
        setForestWithRanks.union(t2[0], t2[4]);

        System.out.println("Reprezentant zbioru z 1: " + setForestWithRanks.findSet(t2[1]).value);
        System.out.println("Reprezentant zbioru z 3: " + setForestWithRanks.findSet(t2[3]).value);
        System.out.println("Reprezentant zbioru z 6: " + setForestWithRanks.findSet(t2[6]).value);
        setForestWithRanks.draw();

    }
}
