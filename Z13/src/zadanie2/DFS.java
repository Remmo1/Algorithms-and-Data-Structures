package zadanie2;

import zadanie1.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS<T> {
    private final Graph<T> graph;
    private final int amountOfVertices;
    private final Graph.Node<T>[] predecessors;

    private final int[] t;
    private final int[] f;
    private int globalTime;

    @SuppressWarnings("unchecked")
    public DFS(Graph<T> graph, int amountOfVertices) {
        this.graph = graph;
        this.amountOfVertices = amountOfVertices;
        predecessors = new Graph.Node[amountOfVertices];

        t = new int[amountOfVertices];
        f = new int[amountOfVertices];
        globalTime = 0;
    }

    public void DFSfind(T value) {
        DFSfind(new Graph.Node<>(value));
    }

    private void DFSvisitMatrix(Graph.Node<T> u, ArrayList<Graph.Node<T>> vertices, byte[][] matrix) {
        u.setColor((byte) 1);
        globalTime++;
        t[vertices.indexOf(u)] = globalTime;

        int i = vertices.indexOf(u);
        for (int j = 0; j < vertices.size(); j++) {
            if (matrix[i][j] == 1) {

                Graph.Node<T> v = vertices.get(j);
                results();
                System.out.println();

                if (v.getColor() == 0) {
                    predecessors[j] = u;
                    DFSvisitMatrix(v, vertices, matrix);
                }

            }
        }

        results();
        System.out.println();

        u.setColor((byte) 2);
        globalTime++;
        f[vertices.indexOf(u)] = globalTime;

    }


    private void DFSVisitList(Graph.Node<T> u,ArrayList<Graph.Node<T>> vertices, ArrayList<ArrayList<Graph.Node<T>>> list) {

        u.setColor((byte) 1);
        globalTime++;
        t[vertices.indexOf(u)] = globalTime;

        int i = vertices.indexOf(u);
        for (int j = 1; j < list.get(i).size(); j++) {
                Graph.Node<T> v = list.get(i).get(j);

                results();
                System.out.println();

                if (v.getColor() == 0) {
                    predecessors[vertices.indexOf(v)] = u;
                    DFSVisitList(v, vertices, list);
                }
        }

        results();
        System.out.println();

        u.setColor((byte) 2);
        globalTime++;
        f[vertices.indexOf(u)] = globalTime;
    }


    private void DFSfind(Graph.Node<T> vertex) {

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

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(predecessors, null);
            Arrays.fill(t, 0);
            Arrays.fill(f, 0);
            globalTime = 0;

            // algorytm
            for (Graph.Node<T> u :
                    vertices) {
                if (u.getColor() == 0)
                    DFSvisitMatrix(u, vertices, matrix);
            }


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

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(predecessors, null);
            Arrays.fill(t, 0);
            Arrays.fill(f, 0);
            globalTime = 0;

            // algorytm
            for (Graph.Node<T> u :
                    vertices) {
                if (u.getColor() == 0)
                    DFSvisitMatrix(u, vertices, matrix);
            }


        }







        // algorytm dla listy

        // lista nieskierowana
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

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(predecessors, null);

            // algorytm
            for (Graph.Node<T> u :
                    vertices) {
                if (u.getColor() == 0)
                    DFSVisitList(u, vertices, list);
            }

            System.out.println();

        }

        // lista skierowana
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

            for (Graph.Node<T> v :
                    vertices) {
                v.setColor((byte) 0);
            }

            Arrays.fill(predecessors, null);

            // algorytm
            for (Graph.Node<T> u :
                    vertices) {
                if (u.getColor() == 0)
                    DFSVisitList(u, vertices, list);
            }

            System.out.println();

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
        System.out.print("Wierzchołki:    ");
        assert vertices != null;
        for (Graph.Node<T> v :
                vertices) {
            System.out.print(v.getValue() + " ");
        }
        System.out.println();
        System.out.print("Czas przyjścia: ");
        for (Integer integer : t) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.print("Czas wyjścia:   ");
        for (Integer integer : f) {
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

