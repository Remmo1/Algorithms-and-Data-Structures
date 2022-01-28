package zadanie2;

import zadanie1.*;

import java.util.ArrayList;
import java.util.Arrays;

public class BST<T> {
    private final Graph<T> graph;
    private final int[] distance;
    private final Graph.Node<T>[] predecessors;
    private final ArrayList<Graph.Node<T>> queue;

    @SuppressWarnings("unchecked")
    public BST(Graph<T> graph, int amountOfVertices) {
        this.graph = graph;
        distance = new int[amountOfVertices];
        predecessors = new Graph.Node[amountOfVertices];
        queue = new ArrayList<>();
    }


    public void BFSfind(T value) {
        BFSfind(new Graph.Node<>(value));
    }

    private void BFSfind(Graph.Node<T> vertex) {

        // algorytm dla macierzy nieskierowanej
        if (graph instanceof UndirectedGraphOnAdjacencyMatrix) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((UndirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();
            byte[][] matrix = ((UndirectedGraphOnAdjacencyMatrix<T>) graph).getMatrix();

            // wzięcie węzła ze wszystkich
            for (Graph.Node<T> tNode : vertices) {
                if (vertex.getValue() == tNode.getValue()) {
                    vertex = tNode;
                    break;
                }
            }

            // jeśli go nie ma to wychodzimy
            if (!vertices.contains(vertex))
                return;

            // założenia początkowe
            vertex.setColor((byte) 1);
            distance[vertices.indexOf(vertex)] = 0;
            queue.add(vertex);

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(distance, 0);
            Arrays.fill(predecessors, null);

            // algorytm
            while (!queue.isEmpty()) {
                Graph.Node<T> u = queue.remove(0);
                results();
                System.out.println();

                int i = vertices.indexOf(u);
                for (int j = 0; j < vertices.size(); j++) {

                    // sąsiedztwo u
                    if (matrix[i][j] == 1) {

                        Graph.Node<T> v = vertices.get(j);

                        // jeśli kolor jest biały
                        if (v.getColor() == 0) {
                            v.setColor((byte) 1);
                            distance[vertices.indexOf(v)] = distance[vertices.indexOf(u)] + 1;
                            predecessors[vertices.indexOf(v)] = u;
                            queue.add(v);
                        }

                    }

                }


                u.setColor((byte) 2);
            }

            System.out.println();

        }


        // algorytm dla macierzy skierowanej
        if (graph instanceof DirectedGraphOnAdjacencyMatrix) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((DirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();
            byte[][] matrix = ((DirectedGraphOnAdjacencyMatrix<T>) graph).getMatrix();

            // wzięcie węzła ze wszystkich
            for (Graph.Node<T> tNode : vertices) {
                if (vertex.getValue() == tNode.getValue()) {
                    vertex = tNode;
                    break;
                }
            }

            // jeśli go nie ma to wychodzimy
            if (!vertices.contains(vertex))
                return;

            // założenia początkowe
            vertex.setColor((byte) 1);
            distance[vertices.indexOf(vertex)] = 0;
            queue.add(vertex);

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(distance, 0);
            Arrays.fill(predecessors, null);

            // algorytm
            while (!queue.isEmpty()) {
                Graph.Node<T> u = queue.remove(0);
                results();
                System.out.println();

                int i = vertices.indexOf(u);
                for (int j = 0; j < vertices.size(); j++) {

                    // sąsiedztwo u
                    if (matrix[i][j] == 1) {

                        Graph.Node<T> v = vertices.get(j);

                        // jeśli kolor jest biały
                        if (v.getColor() == 0) {
                            v.setColor((byte) 1);
                            distance[vertices.indexOf(v)] = distance[vertices.indexOf(u)] + 1;
                            predecessors[vertices.indexOf(v)] = u;
                            queue.add(v);
                        }

                    }

                }


                u.setColor((byte) 2);
            }

            System.out.println();

        }



        // algorytm dla listy nieskierowanej
        if (graph instanceof UndirectedGraphOnAdjacencyList) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((UndirectedGraphOnAdjacencyList<T>) graph).getVertices();
            ArrayList<ArrayList<Graph.Node<T>>> list = ((UndirectedGraphOnAdjacencyList<T>) graph).getList();

            // wzięcie węzła ze wszystkich
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == vertex.getValue()) {
                    vertex = list.get(i).get(0);
                    break;
                }
            }

            // jeśli go nie ma to wychodzimy
            if (!vertices.contains(vertex))
                return;

            // założenia początkowe
            vertex.setColor((byte) 1);
            distance[vertices.indexOf(vertex)] = 0;
            queue.add(vertex);

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(distance, 0);
            Arrays.fill(predecessors, null);

            // algorytm
            while (!queue.isEmpty()) {
                Graph.Node<T> u = queue.remove(0);
                ArrayList<Graph.Node<T>> actualList = list.get(vertices.indexOf(u));
                results();
                System.out.println();

                for (int j = 1; j < actualList.size(); j++) {
                    Graph.Node<T> v = actualList.get(j);

                    if (v.getColor() == 0) {
                        v.setColor((byte) 1);
                        distance[vertices.indexOf(v)] = distance[vertices.indexOf(u)] + 1;
                        predecessors[vertices.indexOf(v)] = u;
                        queue.add(v);
                    }
                }

                u.setColor((byte) 2);
            }



            System.out.println();



        }


        // algorytm dla listy skierowanej
        if (graph instanceof DirectedGraphOnAdjancencyList) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((DirectedGraphOnAdjancencyList<T>) graph).getVertices();
            ArrayList<ArrayList<Graph.Node<T>>> list = ((DirectedGraphOnAdjancencyList<T>) graph).getList();

            // wzięcie węzła ze wszystkich
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == vertex.getValue()) {
                    vertex = list.get(i).get(0);
                    break;
                }
            }

            // jeśli go nie ma to wychodzimy
            if (!vertices.contains(vertex))
                return;

            // założenia początkowe
            vertex.setColor((byte) 1);
            distance[vertices.indexOf(vertex)] = 0;
            queue.add(vertex);

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(distance, 0);
            Arrays.fill(predecessors, null);

            // algorytm
            while (!queue.isEmpty()) {
                Graph.Node<T> u = queue.remove(0);
                ArrayList<Graph.Node<T>> actualList = list.get(vertices.indexOf(u));
                results();
                System.out.println();

                for (int j = 1; j < actualList.size(); j++) {
                    Graph.Node<T> v = actualList.get(j);

                    if (v.getColor() == 0) {
                        v.setColor((byte) 1);
                        distance[vertices.indexOf(v)] = distance[vertices.indexOf(u)] + 1;
                        predecessors[vertices.indexOf(v)] = u;
                        queue.add(v);
                    }
                }

                u.setColor((byte) 2);
            }



            System.out.println();



        }

    }

    // pokazuje drogę od węzła z wartością start do tego z wartością end
    public void showPath(T start, T end) {

        Graph.Node<T> startNode = new Graph.Node<>(start);
        Graph.Node<T> endNode = new Graph.Node<>(end);

        // macierz nieskierowana
        if (graph instanceof UndirectedGraphOnAdjacencyMatrix) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((UndirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();

            // wzięcie węzła startowego
            for (Graph.Node<T> tNode : vertices) {
                if (startNode.getValue() == tNode.getValue()) {
                    startNode = tNode;
                    break;
                }
            }

            // wzięcie węzła końcowego
            for (Graph.Node<T> tNode : vertices) {
                if (endNode.getValue() == tNode.getValue()) {
                    endNode = tNode;
                    break;
                }
            }

            // ten sam węzeł
            if (startNode == endNode) {
                System.out.print(startNode + " ");
                return;
            }

            if (predecessors[vertices.indexOf(endNode)] == null) {
                System.out.println("Brak ścieżki z " + start + " do " + end);
            }
            showPath(start, predecessors[vertices.indexOf(endNode)].getValue());
            System.out.print(endNode + " ");

        }

        // macierz skierowana
        if (graph instanceof  DirectedGraphOnAdjacencyMatrix) {

            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((DirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();

            // wzięcie węzła startowego
            for (Graph.Node<T> tNode : vertices) {
                if (startNode.getValue() == tNode.getValue()) {
                    startNode = tNode;
                    break;
                }
            }

            // wzięcie węzła końcowego
            for (Graph.Node<T> tNode : vertices) {
                if (endNode.getValue() == tNode.getValue()) {
                    endNode = tNode;
                    break;
                }
            }

            // ten sam węzeł
            if (startNode == endNode) {
                System.out.print(startNode + " ");
                return;
            }

            if (predecessors[vertices.indexOf(endNode)] == null) {
                System.out.println("Brak ścieżki z " + start + " do " + end);
            }
            showPath(start, predecessors[vertices.indexOf(endNode)].getValue());
            System.out.print(endNode + " ");
        }

        // lista nieskierowana
        if (graph instanceof  UndirectedGraphOnAdjacencyList) {
            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((UndirectedGraphOnAdjacencyList<T>) graph).getVertices();
            ArrayList<ArrayList<Graph.Node<T>>> list = ((UndirectedGraphOnAdjacencyList<T>) graph).getList();

            // wzięcie węzła startowego
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == startNode.getValue()) {
                    startNode = list.get(i).get(0);
                    break;
                }
            }

            // wzięcie węzła końcowego
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == endNode.getValue()) {
                    endNode = list.get(i).get(0);
                    break;
                }
            }

            // ten sam węzeł
            if (startNode == endNode) {
                System.out.print(startNode + " ");
                return;
            }

            if (predecessors[vertices.indexOf(endNode)] == null) {
                System.out.println("Brak ścieżki z " + start + " do " + end);
            }
            showPath(start, predecessors[vertices.indexOf(endNode)].getValue());
            System.out.print(endNode + " ");
        }

        // lista skierowana
        if (graph instanceof  DirectedGraphOnAdjancencyList) {
            // wzięcie danych
            ArrayList<Graph.Node<T>> vertices = ((DirectedGraphOnAdjancencyList<T>) graph).getVertices();
            ArrayList<ArrayList<Graph.Node<T>>> list = ((DirectedGraphOnAdjancencyList<T>) graph).getList();

            // wzięcie węzła startowego
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == startNode.getValue()) {
                    startNode = list.get(i).get(0);
                    break;
                }
            }

            // wzięcie węzła końcowego
            for (int i = 0; i < vertices.size(); i++) {
                if (list.get(i).get(0).getValue() == endNode.getValue()) {
                    endNode = list.get(i).get(0);
                    break;
                }
            }

            // ten sam węzeł
            if (startNode == endNode) {
                System.out.print(startNode + " ");
                return;
            }

            if (predecessors[vertices.indexOf(endNode)] == null) {
                System.out.println("Brak ścieżki z " + start + " do " + end);
            }
            showPath(start, predecessors[vertices.indexOf(endNode)].getValue());
            System.out.print(endNode + " ");
        }
    }

    public void results() {

        ArrayList<Graph.Node<T>> vertices = null;

        if (graph instanceof UndirectedGraphOnAdjacencyMatrix) {
            vertices = ((UndirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();
        }

        if (graph instanceof DirectedGraphOnAdjacencyMatrix) {
            vertices = ((DirectedGraphOnAdjacencyMatrix<T>) graph).getVertices();
        }

        if (graph instanceof  UndirectedGraphOnAdjacencyList) {
            vertices = ((UndirectedGraphOnAdjacencyList<T>) graph).getVertices();
        }

        if (graph instanceof DirectedGraphOnAdjancencyList) {
            vertices = ((DirectedGraphOnAdjancencyList<T>) graph).getVertices();
        }

        System.out.println();
        System.out.print("Wierzchołki: ");
        assert vertices != null;
        for (Graph.Node<T> v :
                vertices) {
            System.out.print(v.getValue() + " ");
        }
        System.out.println();
        System.out.print("Odległość:   ");
        for (Integer integer : distance) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.print("Poprzednik: ");
        for (Graph.Node<T> v :
                predecessors) {
            if (v == null)
                System.out.print(" brak ");
            else
                System.out.print(v.getValue() + " ");
        }


    }
}