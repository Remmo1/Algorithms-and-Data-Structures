package com.company;

public interface Hashing {
    String get(String key);
    void put(String key, String value);
    boolean containsKey(String key);
    int size();
    boolean isEmpty();
    void resize();
    void dump();

    double alfaProportion(String searched);
}
