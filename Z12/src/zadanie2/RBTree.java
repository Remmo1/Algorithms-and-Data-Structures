package zadanie2;

enum Color {
    Red, Black
}

class Node {
    public int data;
    public Node right;
    public Node left;
    public Node parent;
    public Color color;

    public Node(int data) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.data = data;
        this.color = Color.Red;
    }
}

class RedBlackTree {
    Node root;
    Node NIL;

    public RedBlackTree() {
        Node nilNode = new Node(0);
        nilNode.color = Color.Black;
        this.NIL = nilNode;
        this.root = this.NIL;

        amountOfComparing = 0;
    }

    private int amountOfComparing;

    // szukanie
    private Node search(int elem) {
        Node node = root;

        while (node != this.NIL && (elem != node.data)) {
            amountOfComparing++;
            if (elem < node.data)
                node = node.left;
            else
                node = node.right;
        }

        return node;
    }

    public int getAmountOfComparing() {
        return amountOfComparing;
    }

    public void clear() {
        this.root = this.NIL;
    }

    public int find (int elem) {
        amountOfComparing = 0;
        Node node = search(elem);
        return node == this.NIL ? this.NIL.data : node.data;
    }

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != this.NIL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == this.NIL) { //x is root
            this.root = y;
        }

        else if (x == x.parent.left) { //x is left child
            x.parent.left = y;
        }

        else { //x is right child
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if(y.right != this.NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == this.NIL) { //x is root
            this.root = y;
        }
        else if(x == x.parent.right) { //x is left child
            x.parent.right = y;
        }
        else { //x is right child
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insertFixup(Node z) {
        while(z.parent.color == Color.Red) {
            if(z.parent == z.parent.parent.left) { //z.parent is the left child

                Node y = z.parent.parent.right; //uncle of z

                if(y.color == Color.Red) { //case 1
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    z = z.parent.parent;
                }
                else { //case2 or case3
                    if(z == z.parent.right) { //case2
                        z = z.parent; //marked z.parent as new z
                        leftRotate(z);
                    }
                    //case3
                    z.parent.color = Color.Black; //made parent black
                    z.parent.parent.color = Color.Red; //made parent red
                    rightRotate(z.parent.parent);
                }
            }
            else { //z.parent is the right child
                Node y = z.parent.parent.left; //uncle of z

                if(y.color == Color.Red) {
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    z = z.parent.parent;
                }
                else {
                    if(z == z.parent.left) {
                        z = z.parent; //marked z.parent as new z
                        rightRotate(z);
                    }
                    z.parent.color = Color.Black; //made parent black
                    z.parent.parent.color = Color.Red; //made parent red
                    leftRotate(z.parent.parent);
                }
            }
        }
        this.root.color = Color.Black;
    }

    public void insert(int value) {
        Node node = new Node(value);
        insert(node);
    }

    private void insert(Node z) {
        Node y = this.NIL; //variable for the parent of the added node
        Node temp = this.root;

        while(temp != this.NIL) {
            y = temp;
            if(z.data < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
        }
        z.parent = y;

        if(y == this.NIL) { //newly added node is root
            this.root = z;
        }
        else if(z.data < y.data) //data of child is less than its parent, left child
            y.left = z;
        else
            y.right = z;

        z.right = this.NIL;
        z.left = this.NIL;

        insertFixup(z);
    }

    public void rbTransplant(Node u, Node v) {
        if(u.parent == this.NIL)
            this.root = v;
        else if(u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        v.parent = u.parent;
    }

    public Node minimum(Node x) {
        while(x.left != this.NIL)
            x = x.left;
        return x;
    }

    public void deleteFixup(Node x) {
        while(x != this.root && x.color == Color.Black) {
            if(x == x.parent.left) {
                Node w = x.parent.right;
                if(w.color == Color.Red) {
                    w.color = Color.Black;
                    x.parent.color = Color.Red;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == Color.Black && w.right.color == Color.Black) {
                    w.color = Color.Red;
                    x = x.parent;
                }
                else {
                    if(w.right.color == Color.Black) {
                        w.left.color = Color.Black;
                        w.color = Color.Red;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.Black;
                    w.right.color = Color.Black;
                    leftRotate(x.parent);
                    x = this.root;
                }
            }
            else {
                Node w = x.parent.left;
                if(w.color == Color.Red) {
                    w.color = Color.Black;
                    x.parent.color = Color.Red;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == Color.Black && w.left.color == Color.Black) {
                    w.color = Color.Red;
                    x = x.parent;
                }
                else {
                    if(w.left.color == Color.Black) {
                        w.right.color = Color.Black;
                        w.color = Color.Red;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.Black;
                    w.left.color = Color.Black;
                    rightRotate(x.parent);
                    x = this.root;
                }
            }
        }
        x.color = Color.Black;
    }

    public void rbDelete(Node z) {
        Node y = z;
        Node x;
        Color yOrignalColor = y.color;
        if(z.left == this.NIL) {
            x = z.right;
            rbTransplant(z, z.right);
        }
        else if(z.right == this.NIL) {
            x = z.left;
            rbTransplant(z, z.left);
        }
        else {
            y = minimum(z.right);
            yOrignalColor = y.color;
            x = y.right;
            if(y.parent == z) {
                x.parent = z;
            }
            else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if(yOrignalColor == Color.Black)
            deleteFixup(x);
    }

    public void inorder(Node n) {
        if(n != this.NIL) {
            inorder(n.left);
            System.out.println(n.data);
            inorder(n.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();

        rbTree.insert(1);
        rbTree.insert(2);
        rbTree.insert(3);
        rbTree.insert(4);

        rbTree.inorder(rbTree.root);
        rbTree.rbDelete(rbTree.root);

        System.out.println();
        rbTree.inorder(rbTree.root);

    }
}
