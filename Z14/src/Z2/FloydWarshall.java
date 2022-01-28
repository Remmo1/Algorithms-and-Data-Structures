package Z2;

import Z1.Graph;

import java.util.ArrayList;

public class FloydWarshall {

    private final ArrayList<Graph.Node<String>> vertices;
    private final ArrayList<Graph.Edge<String>> edges;
    private final DirectedGraphOnAdjacencyList<String> graph;
    private final int[] distance;

    public FloydWarshall(ArrayList<Graph.Node<String>> vertices, ArrayList<Graph.Edge<String>> edges) {
        this.vertices = vertices;
        this.edges = edges;
        distance = new int[vertices.size()];
        graph = new DirectedGraphOnAdjacencyList<>(vertices, edges);
    }

    public int[][] ssspAlgorithm() {
        // tworzenie macierzy sąsiedztwa
        int n = vertices.size();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Graph.Node<String> v1 = vertices.get(i);
                Graph.Node<String> v2 = vertices.get(j);

                if (v1 == v2) {
                    matrix[i][i] = 0;
                }

                else {
                    Graph.Edge<String> e = graph.takeEdge(v1,v2);

                    if (e != null)
                        matrix[i][j] = e.wage;

                    else
                        matrix[i][j] = 1000000;
                }

            }
        }

        System.out.println();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if( ( matrix [ i ][ k ] == 1000000 ) || ( matrix [ k ][ j ] == 1000000 ) )
                        continue;

                    int w  = matrix [ i ][ k ] + matrix [ k ][ j ];
                    if( matrix [ i ][ j ] > w ) matrix [ i ][ j ] = w;
                }
            }
        }


        return matrix;
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


        FloydWarshall floydWarshall = new FloydWarshall(vertices, edges);
        int[][]t = floydWarshall.ssspAlgorithm();
        String[][] results = new String[t.length][t.length];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] == 1000000)
                    results[i][j] = "∞";
                else
                    results[i][j] = Integer.toString(t[i][j]);
            }
        }

        System.out.print("                ");
        for (Graph.Node<String> vertex : vertices) {
            System.out.print(vertex + " ");
        }

        System.out.print("\nOdległość od a: ");
        for (String j : results[0]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od b: ");
        for (String j : results[1]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od c: ");
        for (String j : results[2]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od d: ");
        for (String j : results[3]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od e: ");
        for (String j : results[4]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od f: ");
        for (String j : results[5]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od g: ");
        for (String j : results[6]) { System.out.print(j + " "); }
        System.out.print("\nOdległość od h: ");
        for (String j : results[7]) { System.out.print(j + " "); }
    }
}
