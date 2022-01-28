package Z1;

import java.util.ArrayList;

public class PrimAlgortihm {

    ArrayList<Graph.Node<String>> vertices;
    ArrayList<Graph.Edge<String>> edges;
    private final int[] distance;
    private final UndirectedGraphOnAdjacencyList<String> graph;

    public PrimAlgortihm(ArrayList<Graph.Node<String>> vertices, ArrayList<Graph.Edge<String>> edges) {
        this.vertices = vertices;
        this.edges = edges;
        distance = new int[vertices.size()];
        graph = new UndirectedGraphOnAdjacencyList<>(vertices, edges);
    }


    public UndirectedGraphOnAdjacencyList<String> PrimMst() {

        Graph.Node<String> s = vertices.get(0);
        ArrayList<ArrayList<Graph.Node<String>>> list = graph.getList();


        for (ArrayList<Graph.Node<String>> nodes : list) {
            Graph.Node<String> v = nodes.get(0);
            distance[vertices.indexOf(v)] = 1000000;
        }

        distance[vertices.indexOf(s)] = 0;


        ArrayList<Graph.Node<String>> vertices2 = new ArrayList<>();


        UndirectedGraphOnAdjacencyList<String> A = new UndirectedGraphOnAdjacencyList<>(vertices, edges);

        int j = 1;

        while (vertices2.size() < vertices.size()) {

            Graph.Node<String> u = null;
            int minimum = 100000;

            for (int i = 0; i < distance.length; i++) {
                Graph.Node<String> v = vertices.get(i);
                if (!vertices2.contains(v) && distance[vertices.indexOf(v)] < minimum) {
                    u = v;
                    minimum = distance[vertices.indexOf(u)];
                }
            }

            // u to znalezione minimum
            vertices2.add(u);

            for (Graph.Node<String> node :
                    vertices) {
                if (!vertices2.contains(node)) {
                    Graph.Edge<String> edge = graph.takeEdge(u,node);
                    if (edge != null) {
                        if (edge.wage < distance[vertices.indexOf(node)]) {
                            distance[vertices.indexOf(node)] = Math.min(distance[vertices.indexOf(node)], edge.wage);
                            node.parent = u;
                            System.out.println("Krok " + j + " " + graph.takeEdge(node, node.parent));
                        }

                    }

                }
            }

            j++;

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

        PrimAlgortihm primAlgortihm = new PrimAlgortihm(vertices, edges);
        UndirectedGraphOnAdjacencyList<String> graphOnAdjacencyList = primAlgortihm.PrimMst();

        // krawędź (a, b) "zniknie" z drzewa po dodaniu krawędzi (b, e)
        // dlatego w MST nie ma już krawędzi (a, b)

        System.out.println("Minimalne drzewo rozpinające: ");
        for (int i = 1; i < vertices.size(); i++) {
            Graph.Node<String> node = graphOnAdjacencyList.vertices.get(i);
            System.out.println(graphOnAdjacencyList.takeEdge(node, node.parent));
        }

    }
}
