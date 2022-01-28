package Zadanie2;

public class Main {

    public static void Show(Iterator1BINT iterator) {
        while (!iterator.isDone()) {
            int a = iterator.currentItem();
            if (a != 0)
                System.out.print(a + " ");
            iterator.next();
        }
    }

    public static boolean Pierwsza(int liczba) {
        if (liczba < 2)
            return false;
        for (int i = 2; i*i <= liczba; i++) {
            if (liczba % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==========1==============");
        Show(new Generator(10,52));
        System.out.println();

        System.out.println("==========2==============");
        Show(new LiczbyPierwsze(
                new Generator(1, 50),
                Main::Pierwsza
        ));
        System.out.println();
    }
}
