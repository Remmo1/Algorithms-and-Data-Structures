package com.company;

import java.io.Serializable;

public class Student implements Serializable {
    private final int nr;
    private final String surN;
    private final String name;
    private double mark;

    public Student(int nr, String surN, String name, double mark) {
        this.nr = nr;
        this.surN = surN;
        this.name = name;
        this.mark = mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getName() { return name; }
    public double getMark() { return mark; }
    public int getNr() { return nr; }
    public String getSurN() { return surN; }

    @Override
    public String toString() {

        return nr + " " + name + " " + surN + " " + mark;
    }
}
