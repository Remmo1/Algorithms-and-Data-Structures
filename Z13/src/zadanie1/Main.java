package zadanie1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        /*
        tworzenie grafów nieskierowanych
         */
        System.out.println("\n================= Grafy nieskierowane ====================\n");

        // nieskierowany macierz sąsiedztwa
        System.out.println("\n---------------- Macierz sąsiedztwa -------------------");
        UndirectedGraphOnAdjacencyMatrix<Integer> undirectedGraphOnAdjacencyMatrix = new UndirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        // dodajemy wierzchołki
        undirectedGraphOnAdjacencyMatrix.addVertex(1);
        undirectedGraphOnAdjacencyMatrix.addVertex(2);
        undirectedGraphOnAdjacencyMatrix.addVertex(3);
        undirectedGraphOnAdjacencyMatrix.addVertex(4);
        undirectedGraphOnAdjacencyMatrix.addVertex(5);

        undirectedGraphOnAdjacencyMatrix.showMatrix();

        // dodajemy krawędzie
        undirectedGraphOnAdjacencyMatrix.addEgde(1,2);
        undirectedGraphOnAdjacencyMatrix.showMatrix();

        undirectedGraphOnAdjacencyMatrix.addEgde(2,3);
        undirectedGraphOnAdjacencyMatrix.addEgde(2,5);
        undirectedGraphOnAdjacencyMatrix.addEgde(3,5);
        undirectedGraphOnAdjacencyMatrix.addEgde(4,5);

        undirectedGraphOnAdjacencyMatrix.showMatrix();



        // nieskierowany lista sąsiedztwa

        System.out.println("\n---------------- Lista sąsiedztwa -------------------");
        UndirectedGraphOnAdjacencyList<Integer> undirectedGraphOnAdjacencyList = new UndirectedGraphOnAdjacencyList<>();

        // dodajemy wierzchołki
        undirectedGraphOnAdjacencyList.addVertex(1);
        undirectedGraphOnAdjacencyList.addVertex(2);
        undirectedGraphOnAdjacencyList.addVertex(3);
        undirectedGraphOnAdjacencyList.addVertex(4);
        undirectedGraphOnAdjacencyList.addVertex(5);

        // pusta lista krawędzi
        undirectedGraphOnAdjacencyList.showList();

        // dodajemy krawędzie
        undirectedGraphOnAdjacencyList.addEgde(1,2);
        undirectedGraphOnAdjacencyList.showList();

        undirectedGraphOnAdjacencyList.addEgde(2,3);
        undirectedGraphOnAdjacencyList.addEgde(2,5);
        undirectedGraphOnAdjacencyList.addEgde(3,5);
        undirectedGraphOnAdjacencyList.addEgde(4,5);

        undirectedGraphOnAdjacencyList.showList();



        /*
        tworzenie grafów skierowanych
         */
        System.out.println("\n================= Grafy skierowane ====================\n");

        // skierowany macierz sąsiedztwa
        System.out.println("\n---------------- Macierz sąsiedztwa -------------------");
        DirectedGraphOnAdjacencyMatrix<Integer> directedGraphOnAdjacencyMatrix = new DirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        // dodajemy wierzchołki
        directedGraphOnAdjacencyMatrix.addVertex(1);
        directedGraphOnAdjacencyMatrix.addVertex(2);
        directedGraphOnAdjacencyMatrix.addVertex(3);
        directedGraphOnAdjacencyMatrix.addVertex(4);
        directedGraphOnAdjacencyMatrix.addVertex(5);

        directedGraphOnAdjacencyMatrix.showMatrix();

        // dodajemy krawędzie
        directedGraphOnAdjacencyMatrix.addEgde(1,2);
        directedGraphOnAdjacencyMatrix.showMatrix();

        directedGraphOnAdjacencyMatrix.addEgde(2,3);
        directedGraphOnAdjacencyMatrix.addEgde(2,5);
        directedGraphOnAdjacencyMatrix.addEgde(3,5);
        directedGraphOnAdjacencyMatrix.addEgde(4,5);

        directedGraphOnAdjacencyMatrix.showMatrix();

        System.out.println("\n---------------- Lista sąsiedztwa -------------------");
        DirectedGraphOnAdjancencyList<Integer> directedGraphOnAdjancencyList = new DirectedGraphOnAdjancencyList<>();

        // dodajemy wierzchołki
        directedGraphOnAdjancencyList.addVertex(1);
        directedGraphOnAdjancencyList.addVertex(2);
        directedGraphOnAdjancencyList.addVertex(3);
        directedGraphOnAdjancencyList.addVertex(4);
        directedGraphOnAdjancencyList.addVertex(5);

        // pusta lista krawędzi, będą same spacje
        directedGraphOnAdjancencyList.showList();

        // dodajemy krawędzie
        directedGraphOnAdjancencyList.addEgde(1,2);
        directedGraphOnAdjancencyList.showList();

        directedGraphOnAdjancencyList.addEgde(2,3);
        directedGraphOnAdjancencyList.addEgde(2,5);
        directedGraphOnAdjancencyList.addEgde(3,5);
        directedGraphOnAdjancencyList.addEgde(4,5);

        directedGraphOnAdjancencyList.showList();

    }
}
