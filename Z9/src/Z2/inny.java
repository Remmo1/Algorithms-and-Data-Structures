package Z2;

import com.company.Hashing;

import java.util.NoSuchElementException;

public class inny implements Hashing {

    private String[] data;
    private int size;
    private int maxSize;
    private final double wspolczynnik;
    private int maxCapacity;

    private final int minSize;
    private int amountOfShots = 0;

    public inny(String[] data, int maxSize, double wspolczynnik) {
        this.data = data;
        this.maxSize = maxSize;
        this.minSize = maxSize;

        size = 0;
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

        while (counter < maxSize) {

            if (data[hash] != null) {
                if (data[hash].equals(key))
                    return data[hash];
            }


            hash++;
            counter++;

            if (hash == maxSize)
                hash = 0;
        }

        return null;
    }

    @Override
    public void put(String key, String value) {

        int hash = myStringHashCode(key);
        hash = hash % maxSize;

        while(true) {
            if (data[hash] == null) {
                data[hash] = key;
                break;
            }
            hash++;

            if (hash == maxSize)
                hash = 0;
        }

        size++;
        resize();
    }

    @Override
    public boolean containsKey(String key) {
        if (isEmpty())
            throw new NoSuchElementException();

        amountOfShots = 0;

        if (size == 1) {
            int hash = myStringHashCode(key);
            amountOfShots++;

            if (data[hash] != null)
                return data[hash].equals(key);
            return false;
        }

        int hash = myStringHashCode(key);
        hash %= maxSize;

        int counter = 0;
        int i = hash;

        while (counter < maxSize) {

            amountOfShots++;

            if (data[i] != null) {
                if (data[i].equals(key))
                    return true;
            }

            else {
                return false;
            }


            i++;
            counter++;


            if (i == maxSize)
                i = 0;
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

