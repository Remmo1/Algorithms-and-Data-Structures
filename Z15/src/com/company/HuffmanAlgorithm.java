package com.company;

public class HuffmanAlgorithm {
    private final String[] signs;
    private final int[] keys;
    private final BinaryHeapForNodes binaryHeapForNodes;

    public HuffmanAlgorithm(String[] signs, int[] keys) {
        this.signs = signs;
        this.keys = keys;
        binaryHeapForNodes = new BinaryHeapForNodes(keys.length);
    }

    public Node makeTree() {
        for (int i = 0; i < keys.length; i++) {
            binaryHeapForNodes.insert(keys[i], signs[i]);
        }

        for (int i = 0; i < keys.length-1; i++) {
            Node z = new Node("", 0);

            Node x = binaryHeapForNodes.extractMin();

            Node y = binaryHeapForNodes.extractMin();

            z.left = x;
            z.right = y;

            z.frequency = x.frequency + y.frequency;

            binaryHeapForNodes.insertNode(z);
        }

        return binaryHeapForNodes.extractMin();

    }


    public void showCoding(Node root, String result) {
        if (root.left == null && root.right == null && !root.sign.isBlank()) {
            System.out.println(root.sign + " " + result);

            return;
        }

        assert root.left != null;
        showCoding(root.left, result + "0");
        showCoding(root.right, result + "1");
    }




    public static void main(String[] agrs) {
        String[] signs = {"a","b","c","d","e","f","g","h"};
        int[] keys = {55, 5, 13, 9, 35, 23,15,45};

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm(signs, keys);
        Node result = huffmanAlgorithm.makeTree();
        huffmanAlgorithm.showCoding(result, "");
    }

}
