package zadanie1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UndirectedGraphOnAdjacencyList<T> implements Graph<T> {

    ArrayList<ArrayList<Node<T>>> list;
    ArrayList<Node<T>> vertices;
    ArrayList<Edge<T>> edges;
    int index;


    public UndirectedGraphOnAdjacencyList() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        list = new ArrayList<>();
        index = 0;
    }

    @Override
    public void addVertex(T value) {
        Node<T> vertex = new Node<>(value);

        vertices.add(vertex);
        list.add(new ArrayList<>());
        list.get(index).add(vertex);
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
    public void addEgde(T value1, T value2) {
        Node<T> vertex1 = searchForNode(value1);
        Node<T> vertex2 = searchForNode(value2);
        Edge<T> edge = new Edge<>(vertex1, vertex2);

        edges.add(edge);
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value == edge.node1.value) {
                list.get(i).add(edge.node2);
            }

            if (vertices.get(i).value == edge.node2.value){
                list.get(i).add(edge.node1);
            }
        }

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

    public ArrayList<Edge<T>> getEdges() { return edges; }
    public ArrayList<Node<T>> getVertices() { return vertices; }

    public ArrayList<ArrayList<Node<T>>> getList() {
        return list;
    }

}
