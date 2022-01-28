package com.company;

public class Node {
    public final String sign;
    public int frequency;
    public Node left;
    public Node right;

    public Node(String sign, int frequency) {
        this.sign = sign;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return sign + " " + frequency;
    }
}
