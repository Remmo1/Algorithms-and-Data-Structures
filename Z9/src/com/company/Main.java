package com.company;

public class Main {

    private final static int amountOfPairs = 7;
    private final static String[] data = new String[amountOfPairs];
    private final static double maxCapacity = 0.7;

    private static void clearTable() {
        for (int i = 0; i < amountOfPairs; i++) {
            data[i] = null;
        }
    }

    public static void main(String[] args) {

        
        String d1 = "A";
        String d2 = "B";
        String d3 = "O";
        String d4 = "C";
        String d5 = "P";
        String d6 = "Z";
        String d7 = "H";


        System.out.println("==================== Liniowe =====================");
        LineAdressing openAdressing = new LineAdressing(data, amountOfPairs, maxCapacity);

        openAdressing.put(d1, d1);
        openAdressing.put(d2, d2);
        openAdressing.put(d3, d3);
        openAdressing.put(d4, d4);
        openAdressing.put(d5, d5);
        openAdressing.put(d6, d6);
        openAdressing.put(d7, d7);

        openAdressing.dump();
        System.out.println("Czy klucz A jest w tablicy: " + openAdressing.containsKey("A"));
        System.out.println("Czy klucz L jest w tablicy: " + openAdressing.containsKey("L"));
        System.out.println("Size: " + openAdressing.size());
        System.out.println("Wartość dla klucza A: " + openAdressing.get("A"));
        clearTable();
        System.out.println();





        System.out.println("==================== Kwadratowe =====================");
        SquareAdressing squareAdressing = new SquareAdressing(data, amountOfPairs, maxCapacity);

        squareAdressing.put(d1, d1);
        squareAdressing.put(d2, d2);
        squareAdressing.put(d3, d3);
        squareAdressing.put(d4, d4);
        squareAdressing.put(d5, d5);
        squareAdressing.put(d6, d6);
        squareAdressing.put(d7, d7);

        squareAdressing.dump();
        System.out.println("Czy klucz A jest w tablicy: " + squareAdressing.containsKey("A"));
        System.out.println("Czy klucz L jest w tablicy: " + squareAdressing.containsKey("L"));
        System.out.println("Size: " + squareAdressing.size());
        System.out.println("Wartość dla klucza A: " + squareAdressing.get("A"));
        clearTable();
        System.out.println();





        System.out.println("==================== Podwójne =====================");
        DoubleAdressing doubleAdressing = new DoubleAdressing(data, amountOfPairs, maxCapacity);

        doubleAdressing.put(d1, d1);
        doubleAdressing.put(d2, d2);
        doubleAdressing.put(d3, d3);
        doubleAdressing.put(d4, d4);
        doubleAdressing.put(d5, d5);
        doubleAdressing.put(d6, d6);
        doubleAdressing.put(d7, d7);

        doubleAdressing.dump();
        System.out.println("Czy klucz A jest w tablicy: " + doubleAdressing.containsKey("A"));
        System.out.println("Czy klucz L jest w tablicy: " + doubleAdressing.containsKey("L"));
        System.out.println("Size: " + doubleAdressing.size());
        System.out.println("Wartość dla klucza A: " + doubleAdressing.get("A"));
        System.out.println();








    }
}
