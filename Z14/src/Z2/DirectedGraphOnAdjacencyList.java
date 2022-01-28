package Z2;
import Z1.Graph;

import java.util.ArrayList;

public class DirectedGraphOnAdjacencyList<T> implements Graph<T> {

    ArrayList<ArrayList<Node<T>>> list;
    ArrayList<Node<T>> vertices;
    ArrayList<Edge<T>> edges;
    int index;


    public DirectedGraphOnAdjacencyList(ArrayList<Node<T>> vertices, ArrayList<Edge<T>> edges) {

        list = new ArrayList<>();
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        index = 0;

        if (!vertices.isEmpty()) {
            int size = vertices.size();
            for (int i = 0; i < size; i++) {
                addVertex(vertices.get(i));
            }
        }

        if (!edges.isEmpty()) {
            int size = edges.size();
            for (int i = 0; i < size; i++) {
                addEdge(edges.get(i));
            }
        }
    }

    @Override
    public void addVertex(T value) {
        Node<T> vertex = new Node<>(value);

        vertices.add(vertex);
        list.add(new ArrayList<>());
        list.get(index).add(vertex);
        index++;

    }

    private void addVertex(Node<T> node) {
        vertices.add(node);
        list.add(new ArrayList<>());
        list.get(index).add(node);
        index++;
    }

    private Node<T> searchForNode(T value) {
        for (int i = 0; i < vertices.size(); i++) {
            if (list.get(i).get(0).value == value) {
                return list.get(i).get(0);
            }
        }

        return null;
    }


    @Override
    public void addEgde(T value1, T value2, int wage) {
        Node<T> vertex1 = searchForNode(value1);
        Node<T> vertex2 = searchForNode(value2);
        Edge<T> edge = new Edge<>(vertex1, vertex2, wage);

        edges.add(edge);
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value == edge.node1.value) {
                list.get(i).add(edge.node2);
            }
        }
    }

    private void addEdge(Edge<T> edge) {
        edges.add(edge);
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value == edge.node1.value) {
                list.get(i).add(edge.node2);
            }
        }
    }

    public Edge<T> takeEdge(Node<T> node1, Node<T> node2) {
        for (Edge<T> edge : edges) {
            if ((edge.node1 == node1 && edge.node2 == node2)) {
                return edge;
            }
        }

        return null;
    }

    public void showList() {
        System.out.println();
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (j == 0)
                    System.out.print(list.get(i).get(j) + " -> ");
                else
                    System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public ArrayList<Node<T>> getVertices() {
        return vertices;
    }

    public ArrayList<ArrayList<Node<T>>> getList() {
        return list;
    }
}


