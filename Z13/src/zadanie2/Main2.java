package zadanie2;

import zadanie1.DirectedGraphOnAdjacencyMatrix;
import zadanie1.DirectedGraphOnAdjancencyList;
import zadanie1.UndirectedGraphOnAdjacencyList;
import zadanie1.UndirectedGraphOnAdjacencyMatrix;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        // ================================ bst ========================================

        System.out.println("\n=============== BST ===================\n");
        // nieskierowana macierz
        System.out.println("\nMaicerz nieskierowana");
        UndirectedGraphOnAdjacencyMatrix<String> undirectedGraphOnAdjacencyMatrix = new UndirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        undirectedGraphOnAdjacencyMatrix.addVertex("r");
        undirectedGraphOnAdjacencyMatrix.addVertex("s");
        undirectedGraphOnAdjacencyMatrix.addVertex("t");
        undirectedGraphOnAdjacencyMatrix.addVertex("u");
        undirectedGraphOnAdjacencyMatrix.addVertex("v");
        undirectedGraphOnAdjacencyMatrix.addVertex("w");
        undirectedGraphOnAdjacencyMatrix.addVertex("x");
        undirectedGraphOnAdjacencyMatrix.addVertex("y");

        undirectedGraphOnAdjacencyMatrix.addEgde("r", "s");
        undirectedGraphOnAdjacencyMatrix.addEgde("r", "v");
        undirectedGraphOnAdjacencyMatrix.addEgde("s", "w");
        undirectedGraphOnAdjacencyMatrix.addEgde("w", "t");
        undirectedGraphOnAdjacencyMatrix.addEgde("w", "x");
        undirectedGraphOnAdjacencyMatrix.addEgde("t", "x");
        undirectedGraphOnAdjacencyMatrix.addEgde("t", "u");
        undirectedGraphOnAdjacencyMatrix.addEgde("x", "y");
        undirectedGraphOnAdjacencyMatrix.addEgde("u", "y");

        undirectedGraphOnAdjacencyMatrix.showMatrix();

        BST<String> bst = new BST<>(undirectedGraphOnAdjacencyMatrix, 8);
        bst.BFSfind("s");
        System.out.print("Droga z s do y: ");
        bst.showPath("s", "y");

        // skierowana macierz
        System.out.println("\nMacierz skierowana");
        DirectedGraphOnAdjacencyMatrix<String> directedGraphOnAdjacencyMatrix = new DirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        directedGraphOnAdjacencyMatrix.addVertex("r");
        directedGraphOnAdjacencyMatrix.addVertex("s");
        directedGraphOnAdjacencyMatrix.addVertex("t");
        directedGraphOnAdjacencyMatrix.addVertex("u");
        directedGraphOnAdjacencyMatrix.addVertex("v");
        directedGraphOnAdjacencyMatrix.addVertex("w");
        directedGraphOnAdjacencyMatrix.addVertex("x");
        directedGraphOnAdjacencyMatrix.addVertex("y");

        directedGraphOnAdjacencyMatrix.addEgde("r", "s");
        directedGraphOnAdjacencyMatrix.addEgde("r", "v");
        directedGraphOnAdjacencyMatrix.addEgde("s", "w");
        directedGraphOnAdjacencyMatrix.addEgde("w", "t");
        directedGraphOnAdjacencyMatrix.addEgde("w", "x");
        directedGraphOnAdjacencyMatrix.addEgde("t", "x");
        directedGraphOnAdjacencyMatrix.addEgde("t", "u");
        directedGraphOnAdjacencyMatrix.addEgde("x", "y");
        directedGraphOnAdjacencyMatrix.addEgde("u", "y");

        directedGraphOnAdjacencyMatrix.showMatrix();

        BST<String> bst2 = new BST<>(directedGraphOnAdjacencyMatrix, 8);
        bst2.BFSfind("s");
        System.out.print("Droga z s do y: ");
        bst2.showPath("s", "y");


        // nieskierowana lista
        System.out.println("\nNieskierowana lista");
        UndirectedGraphOnAdjacencyList<String> undirectedGraphOnAdjacencyList = new UndirectedGraphOnAdjacencyList<>();

        undirectedGraphOnAdjacencyList.addVertex("r");
        undirectedGraphOnAdjacencyList.addVertex("s");
        undirectedGraphOnAdjacencyList.addVertex("t");
        undirectedGraphOnAdjacencyList.addVertex("u");
        undirectedGraphOnAdjacencyList.addVertex("v");
        undirectedGraphOnAdjacencyList.addVertex("w");
        undirectedGraphOnAdjacencyList.addVertex("x");
        undirectedGraphOnAdjacencyList.addVertex("y");

        undirectedGraphOnAdjacencyList.addEgde("r", "s");
        undirectedGraphOnAdjacencyList.addEgde("r", "v");
        undirectedGraphOnAdjacencyList.addEgde("s", "w");
        undirectedGraphOnAdjacencyList.addEgde("w", "t");
        undirectedGraphOnAdjacencyList.addEgde("w", "x");
        undirectedGraphOnAdjacencyList.addEgde("t", "x");
        undirectedGraphOnAdjacencyList.addEgde("t", "u");
        undirectedGraphOnAdjacencyList.addEgde("x", "y");
        undirectedGraphOnAdjacencyList.addEgde("u", "y");

        undirectedGraphOnAdjacencyList.showList();

        BST<String> bst3 = new BST<>(undirectedGraphOnAdjacencyList, 8);
        bst3.BFSfind("s");
        System.out.print("Droga z s do y: ");
        bst3.showPath("s", "y");

        // skierowana lista
        System.out.println("\nSkierowana lista");
        DirectedGraphOnAdjancencyList<String> directedGraphOnAdjancencyList = new DirectedGraphOnAdjancencyList<>();

        directedGraphOnAdjancencyList.addVertex("r");
        directedGraphOnAdjancencyList.addVertex("s");
        directedGraphOnAdjancencyList.addVertex("t");
        directedGraphOnAdjancencyList.addVertex("u");
        directedGraphOnAdjancencyList.addVertex("v");
        directedGraphOnAdjancencyList.addVertex("w");
        directedGraphOnAdjancencyList.addVertex("x");
        directedGraphOnAdjancencyList.addVertex("y");

        directedGraphOnAdjancencyList.addEgde("r", "s");
        directedGraphOnAdjancencyList.addEgde("r", "v");
        directedGraphOnAdjancencyList.addEgde("s", "w");
        directedGraphOnAdjancencyList.addEgde("w", "t");
        directedGraphOnAdjancencyList.addEgde("w", "x");
        directedGraphOnAdjancencyList.addEgde("t", "x");
        directedGraphOnAdjancencyList.addEgde("t", "u");
        directedGraphOnAdjancencyList.addEgde("x", "y");
        directedGraphOnAdjancencyList.addEgde("u", "y");

        directedGraphOnAdjancencyList.showList();

        BST<String> bst4 = new BST<>(directedGraphOnAdjancencyList, 8);
        bst4.BFSfind("s");
        System.out.print("Droga z s do y: ");
        bst4.showPath("s", "y");



        // ============================== dfs =======================================
        System.out.println("\n\n\n=============== DFS ===================\n");

        // nieskierowana macierz
        UndirectedGraphOnAdjacencyMatrix<String> undirectedGraphOnAdjacencyMatrix2 = new UndirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        undirectedGraphOnAdjacencyMatrix2.addVertex("u");
        undirectedGraphOnAdjacencyMatrix2.addVertex("v");
        undirectedGraphOnAdjacencyMatrix2.addVertex("w");
        undirectedGraphOnAdjacencyMatrix2.addVertex("x");
        undirectedGraphOnAdjacencyMatrix2.addVertex("y");
        undirectedGraphOnAdjacencyMatrix2.addVertex("z");

        undirectedGraphOnAdjacencyMatrix2.addEgde("u", "v");
        undirectedGraphOnAdjacencyMatrix2.addEgde("u", "x");
        undirectedGraphOnAdjacencyMatrix2.addEgde("v", "y");
        undirectedGraphOnAdjacencyMatrix2.addEgde("w", "y");
        undirectedGraphOnAdjacencyMatrix2.addEgde("w", "z");
        undirectedGraphOnAdjacencyMatrix2.addEgde("x", "v");
        undirectedGraphOnAdjacencyMatrix2.addEgde("y", "x");
        undirectedGraphOnAdjacencyMatrix2.addEgde("z", "z");

        undirectedGraphOnAdjacencyMatrix2.showMatrix();

        DFS<String> dfs = new DFS<>(undirectedGraphOnAdjacencyMatrix2, 6);
        dfs.DFSfind("u");
        dfs.results();

        // skierowana macierz
        DirectedGraphOnAdjacencyMatrix<String> directedGraphOnAdjacencyMatrix2 = new DirectedGraphOnAdjacencyMatrix<>(new ArrayList<>(), new ArrayList<>());

        directedGraphOnAdjacencyMatrix2.addVertex("u");
        directedGraphOnAdjacencyMatrix2.addVertex("v");
        directedGraphOnAdjacencyMatrix2.addVertex("w");
        directedGraphOnAdjacencyMatrix2.addVertex("x");
        directedGraphOnAdjacencyMatrix2.addVertex("y");
        directedGraphOnAdjacencyMatrix2.addVertex("z");

        directedGraphOnAdjacencyMatrix2.addEgde("u", "v");
        directedGraphOnAdjacencyMatrix2.addEgde("u", "x");
        directedGraphOnAdjacencyMatrix2.addEgde("v", "y");
        directedGraphOnAdjacencyMatrix2.addEgde("w", "y");
        directedGraphOnAdjacencyMatrix2.addEgde("w", "z");
        directedGraphOnAdjacencyMatrix2.addEgde("x", "v");
        directedGraphOnAdjacencyMatrix2.addEgde("y", "x");
        directedGraphOnAdjacencyMatrix2.addEgde("z", "z");

        directedGraphOnAdjacencyMatrix2.showMatrix();

        DFS<String> dfs2 = new DFS<>(directedGraphOnAdjacencyMatrix2, 6);
        dfs2.DFSfind("u");


        // nieskierowana lista
        UndirectedGraphOnAdjacencyList<String> undirectedGraphOnAdjacencyList2 = new UndirectedGraphOnAdjacencyList<>();

        undirectedGraphOnAdjacencyList2.addVertex("u");
        undirectedGraphOnAdjacencyList2.addVertex("v");
        undirectedGraphOnAdjacencyList2.addVertex("w");
        undirectedGraphOnAdjacencyList2.addVertex("x");
        undirectedGraphOnAdjacencyList2.addVertex("y");
        undirectedGraphOnAdjacencyList2.addVertex("z");

        undirectedGraphOnAdjacencyList2.addEgde("u", "v");
        undirectedGraphOnAdjacencyList2.addEgde("u", "x");
        undirectedGraphOnAdjacencyList2.addEgde("v", "y");
        undirectedGraphOnAdjacencyList2.addEgde("w", "y");
        undirectedGraphOnAdjacencyList2.addEgde("w", "z");
        undirectedGraphOnAdjacencyList2.addEgde("x", "v");
        undirectedGraphOnAdjacencyList2.addEgde("y", "x");
        undirectedGraphOnAdjacencyList2.addEgde("z", "z");

        undirectedGraphOnAdjacencyList2.showList();

        DFS<String> dfs3 = new DFS<>(undirectedGraphOnAdjacencyList2, 6);
        dfs3.DFSfind("u");

        // skierowana lista
        DirectedGraphOnAdjancencyList<String> directedGraphOnAdjancencyList2 = new DirectedGraphOnAdjancencyList<>();

        directedGraphOnAdjancencyList2.addVertex("u");
        directedGraphOnAdjancencyList2.addVertex("v");
        directedGraphOnAdjancencyList2.addVertex("w");
        directedGraphOnAdjancencyList2.addVertex("x");
        directedGraphOnAdjancencyList2.addVertex("y");
        directedGraphOnAdjancencyList2.addVertex("z");

        directedGraphOnAdjancencyList2.addEgde("u", "v");
        directedGraphOnAdjancencyList2.addEgde("u", "x");
        directedGraphOnAdjancencyList2.addEgde("v", "y");
        directedGraphOnAdjancencyList2.addEgde("w", "y");
        directedGraphOnAdjancencyList2.addEgde("w", "z");
        directedGraphOnAdjancencyList2.addEgde("x", "v");
        directedGraphOnAdjancencyList2.addEgde("y", "x");
        directedGraphOnAdjancencyList2.addEgde("z", "z");

        directedGraphOnAdjancencyList2.showList();

        DFS<String> dfs4 = new DFS<>(directedGraphOnAdjancencyList2, 6);
        dfs4.DFSfind("u");
    }
}
