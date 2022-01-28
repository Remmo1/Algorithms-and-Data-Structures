package Z2;

import Z1.Graph;


import java.util.ArrayList;

public class DijkstraSingleSourceSP {
    private final ArrayList<Graph.Node<String>> vertices;
    private final ArrayList<Graph.Edge<String>> edges;
    private final DirectedGraphOnAdjacencyList<String> graph;
    private final int[] distance;

    public DijkstraSingleSourceSP(ArrayList<Graph.Node<String>> vertices, ArrayList<Graph.Edge<String>> edges) {
        this.vertices = vertices;
        this.edges = edges;
        distance = new int[vertices.size()];
        graph = new DirectedGraphOnAdjacencyList<>(vertices, edges);
    }

    public int[] ssspAlgorithm(String key) {

        Graph.Node<String> s = null;
        for (Graph.Node<String> v :
                vertices) {
            if (v.value.equals(key)) {
                s = v;
                break;
            }
        }

        if (s == null) {
            return null;
        }


        ArrayList<ArrayList<Graph.Node<String>>> list = graph.getList();


        for (ArrayList<Graph.Node<String>> nodes : list) {
            Graph.Edge<String> edge = null;
            Graph.Node<String> v = nodes.get(0);

            if (nodes.contains(v)) {
                edge = graph.takeEdge(s, v);
            }

            if (edge != null) {
                distance[vertices.indexOf(v)] = edge.wage;
            } else {
                distance[vertices.indexOf(v)] = 1000000;
            }
        }

        distance[vertices.indexOf(s)] = 0;


        ArrayList<Graph.Node<String>> vertices2 = new ArrayList<>();
        vertices2.add(s);

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

            vertices2.add(u);

            for (Graph.Node<String> node :
                    vertices) {
                if (!vertices2.contains(node)) {
                    Graph.Edge<String> edge = graph.takeEdge(u,node);
                    if (edge != null)
                        distance[vertices.indexOf(node)] = Math.min(distance[vertices.indexOf(node)], distance[vertices.indexOf(u)] + edge.wage);
                }
            }



        }


        return distance;
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
        Graph.Edge<String> ad = new Graph.Edge<>(a,d,2);
        Graph.Edge<String> ae = new Graph.Edge<>(a,e,3);

        Graph.Edge<String> bc = new Graph.Edge<>(b,c,2);
        Graph.Edge<String> bh = new Graph.Edge<>(b,h,4);

        Graph.Edge<String> cf = new Graph.Edge<>(c,f,9);

        Graph.Edge<String> ea = new Graph.Edge<>(e,a,3);
        Graph.Edge<String> eb = new Graph.Edge<>(e,b,3);
        Graph.Edge<String> eg = new Graph.Edge<>(e,g,5);
        Graph.Edge<String> eh = new Graph.Edge<>(e,h,1);

        Graph.Edge<String> fb = new Graph.Edge<>(f,b,8);

        Graph.Edge<String> gd = new Graph.Edge<>(g,d,5);

        Graph.Edge<String> hf = new Graph.Edge<>(h,f,7);
        Graph.Edge<String> hg = new Graph.Edge<>(h,g,6);

        edges.add(ab);
        edges.add(ad);
        edges.add(ae);
        edges.add(bc);
        edges.add(bh);
        edges.add(cf);
        edges.add(ea);
        edges.add(eb);
        edges.add(eg);
        edges.add(eh);
        edges.add(fb);
        edges.add(gd);
        edges.add(hf);
        edges.add(hg);

        System.out.println("=============== Najkrótsza ścieżka z a ==============");
        DijkstraSingleSourceSP dijkstraSingleSourceSP = new DijkstraSingleSourceSP(vertices,edges);
        int[] t = dijkstraSingleSourceSP.ssspAlgorithm("a");

        System.out.print("                ");
        for (Graph.Node<String> vertex : vertices) {
            System.out.print(vertex + " ");
        }

        System.out.print("\nOdległość od a: ");
        for (int j : t) {
            System.out.print(j + " ");
        }

        System.out.println("\n\n\n=============== Najkrótsza ścieżka z e ==============");
        DijkstraSingleSourceSP dijkstraSingleSourceSP2 = new DijkstraSingleSourceSP(vertices,edges);
        int[] t2 = dijkstraSingleSourceSP2.ssspAlgorithm("e");

        System.out.print("                ");
        for (Graph.Node<String> vertex : vertices) {
            System.out.print(vertex + " ");
        }

        System.out.print("\nOdległość od e: ");
        for (int j : t2) {
            System.out.print(j + " ");
        }
    }
}
