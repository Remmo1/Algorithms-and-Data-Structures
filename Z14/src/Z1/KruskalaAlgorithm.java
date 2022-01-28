package Z1;

import java.util.ArrayList;
import java.util.Comparator;

public class KruskalaAlgorithm <T> {

    private final ArrayList<Graph.Node<T>> vertices;
    private final ArrayList<Graph.Edge<T>> edges;

    private void makeSet(Graph.Node<T> x) {
        x.parent = x;
        x.rank = 0;
    }

    private Graph.Node<T> findSet(Graph.Node<T> x) {
        if (x != x.parent)
            x.parent = findSet(x.parent);
        return x.parent;
    }

    private void Link(Graph.Node<T> x, Graph.Node<T> y) {
        if (x.rank > y.rank)
            y.parent = x;
        else {
            x.parent = y;

            if (x.rank == y.rank)
                y.rank++;
        }
    }

    private void Union(Graph.Node<T> x, Graph.Node<T> y) {
        Link(findSet(x), findSet(y));
    }


    public KruskalaAlgorithm(ArrayList<Graph.Node<T>> vertices, ArrayList<Graph.Edge<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public UndirectedGraphOnAdjacencyList<T> mstAlgorithm() {
        UndirectedGraphOnAdjacencyList<T> A = new UndirectedGraphOnAdjacencyList<>(new ArrayList<>(), new ArrayList<>());
        for (Graph.Node<T> u :
                vertices) {
            makeSet(u);
            A.addVertex(u.value);
        }

        edges.sort(Comparator.comparingInt(o -> o.wage));

        System.out.println("Tworzenie drzewa");
        int i = 1;
        for (Graph.Edge<T> edge :
                edges) {
            Graph.Node<T> u = edge.node1;
            Graph.Node<T> v = edge.node2;

            if (findSet(u) != findSet(v)) {
                Union(u, v);
                A.addEgde(edge.node1.value, edge.node2.value, edge.wage);
                System.out.println("Krok " + i + " " + edge);
                i++;
            }
        }


        return A;
    }


    public static void main(String[] args) {
        ArrayList<Graph.Node<String>> vertices = new ArrayList<>();
        ArrayList<Graph.Edge<String>> edges = new ArrayList<>();

        Graph.Node<String> a = new Graph.Node<>("a");
        Graph.Node<String> b = new Graph.Node<>("b");
        Graph.Node<String> c = new Graph.Node<>("c");
        Graph.Node<String> d = new Graph.Node<>("d");
        Graph.Node<String> e = new Graph.Node<>("e");
        Graph.Node<String> f = new Graph.Node<>("f");
        Graph.Node<String> g = new Graph.Node<>("g");
        Graph.Node<String> h = new Graph.Node<>("h");

        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);
        vertices.add(h);

        Graph.Edge<String> ab = new Graph.Edge<>(a,b,4);
        Graph.Edge<String> bc = new Graph.Edge<>(b,c,2);
        Graph.Edge<String> ad = new Graph.Edge<>(a,d,2);
        Graph.Edge<String> ae = new Graph.Edge<>(a,e,3);
        Graph.Edge<String> be = new Graph.Edge<>(b,e,3);
        Graph.Edge<String> bf = new Graph.Edge<>(b,f,8);
        Graph.Edge<String> cf = new Graph.Edge<>(c,f,9);
        Graph.Edge<String> dg = new Graph.Edge<>(d,g,5);
        Graph.Edge<String> eg = new Graph.Edge<>(e,g,5);
        Graph.Edge<String> eh = new Graph.Edge<>(e,h,1);
        Graph.Edge<String> gh = new Graph.Edge<>(g,h,6);
        Graph.Edge<String> bh = new Graph.Edge<>(b,h,4);
        Graph.Edge<String> hf = new Graph.Edge<>(h,f,7);

        edges.add(ab);
        edges.add(bc);
        edges.add(ad);
        edges.add(ae);
        edges.add(be);
        edges.add(cf);
        edges.add(bf);
        edges.add(dg);
        edges.add(eg);
        edges.add(eh);
        edges.add(gh);
        edges.add(bh);
        edges.add(hf);

        KruskalaAlgorithm<String> kruskalaAlgorithm = new KruskalaAlgorithm<>(vertices, edges);
        UndirectedGraphOnAdjacencyList<String> graphOnAdjacencyList = kruskalaAlgorithm.mstAlgorithm();

        System.out.println("Minimalne drzewo rozpinające: ");
        for (Graph.Edge<String> edge : graphOnAdjacencyList.edges) {
            System.out.println(edge.toString());
        }
    }
}