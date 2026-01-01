package GraphAlgos;

import java.util.*;

public class DijkstraAlgo {

    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static class Pair {
        int nodeVal, dist;
        Pair(int val, int dist) {
            this.nodeVal = val;
            this.dist = dist;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static void shortestPathDijkstra(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.nodeVal]) continue;
            vis[curr.nodeVal] = true;

            for (Edge e : graph[curr.nodeVal]) {
                int newDist = curr.dist + e.wt;
                if (newDist < dist[e.dest]) {
                    dist[e.dest] = newDist;
                    pq.offer(new Pair(e.dest, newDist));
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        shortestPathDijkstra(graph);
    }
}
