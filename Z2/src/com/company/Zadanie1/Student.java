package com.company.Zadanie1;

public class Student {
    private final int nrI;
    private final String surN;
    private final String name;
    private float mark;

    public Student(int nrI, String surN, String name, float mark) {
        this.nrI = nrI;
        this.surN = surN;
        this.name = name;
        this.mark = mark;
    }

    public int getNrI() { return nrI; }
    public String getName() { return name; }
    public float getMark() { return mark; }
    public String getSurN() { return surN; }

    public void setMark(float mark) { this.mark = mark;}


    @Override
    public String toString() {
        return nrI + " " + surN + " " + name + " " + mark;
    }
}
