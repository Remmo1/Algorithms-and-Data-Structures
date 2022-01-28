package zadanie1;

import java.util.ArrayList;

public class UndirectedGraphOnAdjacencyMatrix<T> implements Graph<T> {

    byte[][] matrix;
    ArrayList<Node<T>> vertices;
    ArrayList<Edge<T>> edges;

    public void repair() {

        if (vertices.isEmpty() && edges.isEmpty()) {
            return;
        }

        // utworzenie macierzy sąsiedztwa
        matrix = new byte[vertices.size()][vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                Edge<T> help = new Edge<>(vertices.get(i), vertices.get(j));

                for (Edge<T> e :
                        edges) {
                    if (e.node1.value == help.node1.value && e.node2.value == help.node2.value ||
                            e.node2.value == help.node1.value && e.node1.value == help.node2.value) {
                        matrix[i][j] = 1;
                        break;
                    }
                }
            }
        }
    }

    public UndirectedGraphOnAdjacencyMatrix(ArrayList<Node<T>> vertices, ArrayList<Edge<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;

        repair();
    }

    @Override
    public void addVertex(T value) {
        Node<T> vertex = new Node<>(value);
        vertices.add(vertex);
        repair();

    }

    @Override
    public void addEgde(T value1, T value2) {
        Node<T> vertex1 = new Node<>(value1);
        Node<T> vertex2 = new Node<>(value2);
        Edge<T> edge = new Edge<>(vertex1, vertex2);

        edges.add(edge);
        repair();

    }

    public void showMatrix() {
        System.out.println();
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public ArrayList<Node<T>> getVertices() { return vertices; }
    public byte[][] getMatrix() { return matrix; }
}
