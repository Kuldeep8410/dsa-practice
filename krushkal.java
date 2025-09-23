import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, c;
        public Edge(int s, int d, int c) {
            this.src = s;
            this.dest = d;
            this.c = c;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.c - e2.c;
        }
    }

    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]); // path compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) return;

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalMst(ArrayList<Edge> edges, int v) {
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; i < edges.size() && count < v - 1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.c;
                count++;
            }
        }
        System.out.println("MST cost = " + mstCost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        init();
        kruskalMst(edges, v);
    }
}