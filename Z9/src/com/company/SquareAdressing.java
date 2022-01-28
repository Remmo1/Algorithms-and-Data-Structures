package com.company;

import java.util.NoSuchElementException;

public class SquareAdressing implements Hashing {

    private String[] data;
    private int size;
    private int maxSize;
    private final double wspolczynnik;
    private int maxCapacity;

    private int amountOfShots;
    private final int minSize;

    public SquareAdressing(String[] data, int maxSize, double wspolczynnik) {
        this.data = data;
        this.maxSize = maxSize;
        this.minSize = maxSize;

        size = 0;
        amountOfShots = 0;

        this.wspolczynnik = wspolczynnik;
        this.maxCapacity = (int) Math.round(wspolczynnik * maxSize);
    }

    private int myStringHashCode(String s) {
        int w = 0;

        if (s == null)
            return 0;

        for (int i = 0; i < s.length(); i++) {
            w = w + (s.charAt(i) * 9 / 7 + 4 * 3);
        }

        return w % minSize;
    }

    private boolean isPrimeNumber(int liczba) {
        if(liczba < 2) {
            return false;
        }

        for(int i = 2; i <= liczba/2; i++) {
            if(liczba % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int primeNumberGreaterThanMaxSize(int maxSize) {
        for (int i = maxSize+1; i < 3 * maxSize ; i++) {
            if (isPrimeNumber(i))
                return i;
        }

        return 0;
    }


    @Override
    public String get(String key) {
        if (isEmpty())
            throw new NoSuchElementException();

        int hash = myStringHashCode(key);
        hash %= maxSize;

        int counter = 0;
        int i = 1;

        while (counter < maxSize) {

            if (data[hash] != null) {
                if (data[hash].equals(key))
                    return data[hash];
            }

            hash += (i*i);
            i++;
            counter++;

            if (hash >= maxSize)
                hash %= maxSize;
        }

        return null;
    }

    @Override
    public void put(String key, String value) {

        int hash = myStringHashCode(key);
        hash = hash % maxSize;
        int i = 1;

        while(true) {
            if (data[hash] == null) {
                data[hash] = key;
                break;
            }
            hash += (i*i);
            i++;

            if (hash >= maxSize)
                hash %= maxSize;
        }

        size++;
        resize();
    }

    @Override
    public boolean containsKey(String key) {
        if (isEmpty())
            throw new NoSuchElementException();

        int hash = myStringHashCode(key);
        hash %= maxSize;

        int counter = 0;
        int i = 1;
        int j = hash;
        // int thisHash;

        while (counter < (0.5 + 1/(2 * Math.pow(1-wspolczynnik,2)))) {

            amountOfShots++;

            if (data[hash] != null) {
                if (data[hash].equals(key))
                    return true;
            }

            j += (i * i);
            i++;
            counter++;

            if (j >= maxSize)
                j %= maxSize;
        }

        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void resize() {
        if (size >= maxCapacity) {
            int h = primeNumberGreaterThanMaxSize(maxSize);
            String[] newTable = new String[h];

            if (maxSize >= 0) System.arraycopy(data, 0, newTable, 0, maxSize);

            data = newTable;
            maxSize = h;
            maxCapacity = (int) (maxSize * wspolczynnik);
        }
    }

    @Override
    public void dump() {
        for (String d :
                data) {
            if (d == null)
                System.out.print("null ");
            else
                System.out.print(d + " ");
        }
        System.out.println();
    }

    @Override
    public double alfaProportion(String searched) {
        containsKey(searched);
        return amountOfShots;
    }
}
