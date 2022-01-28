package zadanie1;

public interface Graph<T> {

    class Node<T> {
        T value;
        byte color;

        public Node(T value) {
            this.value = value;
            this.color = 0;
        }

        public T getValue() { return value; }
        public byte getColor() { return color; }

        public void setColor(byte color) { this.color = color; }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    class Edge<T> {

        Node<T> node1;
        Node<T> node2;

        public Edge(Node<T> node1, Node<T> node2) {
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public String toString() {
            return "(" + node1.value.toString() + ", " + node2.value.toString() + ")";
        }
    }

    void addVertex(T value);
    void addEgde(T value1, T value2);
}
