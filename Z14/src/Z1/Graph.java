package Z1;

public interface Graph<T> {

    class Node<T> {
        public T value;
        byte color;
        Node<T> parent;
        int rank;

        public Node(T value) {
            this.value = value;
            this.color = 0;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    class Edge<T> {

        public Node<T> node1;
        public Node<T> node2;
        public int wage;

        public Edge(Node<T> node1, Node<T> node2, int wage) {
            this.node1 = node1;
            this.node2 = node2;
            this.wage = wage;
        }

        @Override
        public String toString() {
            return "(" + node1.value.toString() + ", " + node2.value.toString() + ") " + wage;
        }
    }


    void addVertex(T value);
    void addEgde(T value1, T value2, int wage);
}
