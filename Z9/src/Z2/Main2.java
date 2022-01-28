package Z2;

import com.company.DoubleAdressing;
import com.company.Hashing;
import com.company.LineAdressing;
import com.company.SquareAdressing;

import java.util.Arrays;
import java.util.Random;

public class Main2 {

    private final static double alfa = 0.9;         // współczynnik zapełnienia
    private final static int amountOfTests = 3;     // ilość testów
    private final static int amountOfData = 10001;  // maksymalny rozmiar tablicy
    private static int size = 0;                    // ilość elemntów

    private static final String[] t = new String[amountOfData];

    private static String searched;                 // klucz który jest w tablicy

    private static boolean containsForTable(String s) {
        for (String value : t) {
            if (value != null) {
                if (value.equals(s))
                    return true;
            }

        }
        return false;
    }

    private static void clearTable() {
        Arrays.fill(t, null);
        size = 0;
    }


    private static void fillTable(Hashing hashing) {
        Random r = new Random();
        int a,b,c,d,e,f,g;

        for (int i = 0; i < amountOfData * alfa; i++) {

            StringBuilder w = new StringBuilder();

            a = r.nextInt(26) + 65;
            b = r.nextInt(26) + 65;
            c = r.nextInt(26) + 65;
            d = r.nextInt(26) + 65;
            e = r.nextInt(26) + 65;
            f = r.nextInt(26) + 65;
            g = r.nextInt(26) + 65;

            w.append((char)a).append((char) b).append((char)c).append((char) d).append((char) e).append((char) f).append((char) g);

            if (size != 0) {
                while (containsForTable(w.toString())) {
                    a = r.nextInt(26) + 65;
                    b = r.nextInt(26) + 65;
                    c = r.nextInt(26) + 65;
                    d = r.nextInt(26) + 65;
                    e = r.nextInt(26) + 65;
                    f = r.nextInt(26) + 65;
                    g = r.nextInt(26) + 65;

                    w.append((char)a).append((char) b).append((char)c).append((char) d).append((char) e).append((char) f).append((char) g);
                }
            }

            hashing.put(w.toString(), w.toString());

            a = r.nextInt(10);
            if (size == a)
                searched = w.toString();
            size++;
        }

    }


    public static void main(String[] args) {

        int i = 0;

        double resultLineOk = 0;
        double resultLineNotOk = 0;

        double resultSquareOk = 0;
        double resultSquareNotOk = 0;

        double resultDoubleOK = 0;
        double resultDoubleNotOk = 0;

        while (i < amountOfTests) {


            // liniowe
            LineAdressing lineAdressing = new LineAdressing(t, amountOfData, alfa);
            fillTable(lineAdressing);

            double h = lineAdressing.alfaProportion(searched);  // searched jest w tablicy
            resultLineOk += h;

            h = lineAdressing.alfaProportion("Abcdef"); // tego w tablicy nie ma
            resultLineNotOk += h;

            clearTable();



            // kwadratowe
            SquareAdressing squareAdressing = new SquareAdressing(t, amountOfData, alfa);
            fillTable(squareAdressing);

            h = squareAdressing.alfaProportion(searched);
            resultSquareOk += h;

            h = squareAdressing.alfaProportion("Abcdef");
            resultSquareNotOk += h;

            clearTable();



            // podwójne
            DoubleAdressing doubleAdressing = new DoubleAdressing(t, amountOfData, alfa);
            fillTable(doubleAdressing);

            h = doubleAdressing.alfaProportion(searched);
            resultDoubleOK += h;

            h = doubleAdressing.alfaProportion("Abcdef");
            resultDoubleNotOk += h;

            clearTable();

            i++;
        }

        System.out.println("średnie wyniki: ");
        System.out.println("liniowe trafione: " + resultLineOk/amountOfTests);
        System.out.println("liniowe chybione: " + resultLineNotOk/amountOfTests);
        System.out.println("kwadratowe trafione: " + resultSquareOk/amountOfTests);
        System.out.println("kwadratowe chybione: " + resultSquareNotOk/amountOfTests);
        System.out.println("podwójne trafione: " + resultDoubleOK/amountOfTests);
        System.out.println("podwójne chybione: " + resultDoubleNotOk/amountOfTests);


    }
}
