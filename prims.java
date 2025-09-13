import java.util.*;

public class prims {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src= src;
            this.dest= dest;
            this.wt= wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 3));

        graph[1].add(new Edge(1, 2, 2));
        graph[1].add(new Edge(1, 3, 5));
        graph[1].add(new Edge(1, 4, 6));

        graph[2].add(new Edge(2, 3, 8));
        graph[2].add(new Edge(2, 4, 7));

        graph[3].add(new Edge(3, 4, 9));
        graph[3].add(new Edge(3, 5, 10));


    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }

    }
    public static void primsmst(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalcost=0; //MST cost //final weight of minimum mst we can use arraylist to store the edges
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost += curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        System.out.println("final min cost of mst is " + finalcost);
    }

    public static void main(String[] args){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[6];
        createGraph(graph);
        primsmst(graph);
    }
}
