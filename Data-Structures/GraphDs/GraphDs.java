package GraphDs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDs {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    static void BFS(ArrayList<Edge> graph[], boolean[] visited, int start){
        if(graph.length == 0){
            System.out.println("No graph exists!");
            return;
        }
        Queue<Integer> traversal = new LinkedList<>();

        traversal.offer(start); // add root node
        while (!traversal.isEmpty()){
            int node = traversal.poll();
            if(visited[node] == false) {
                System.out.print(node+" ");
                visited[node] = true;
                for (int i = 0; i < graph[node].size(); i++) {
                    traversal.offer(graph[node].get(i).dest);
                }
            }
        }
    }
    static void DFS(ArrayList<Edge> graph[], boolean[] visited, int curr){
        System.out.print(curr+" ");
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i).dest;
            if(visited[neighbour] == false)
                DFS(graph,visited,neighbour);
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        createGraph(graph);
        System.out.println("Neighbours of 2: ");

        System.out.println("\nBFS Traversal: ");
//        System.out.println("\nDFS Traversal: ");
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                BFS(graph, visited, i);
//                  DFS(graph,visited,i);
            }
        }

    }
}
