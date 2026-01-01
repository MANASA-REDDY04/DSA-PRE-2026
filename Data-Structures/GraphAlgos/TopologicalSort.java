package GraphAlgos;
import GraphAlgos.CyclicDetection.Edge;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static void createGraph(ArrayList<Edge>[] graph){
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    static void topologicalSort(ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> st, int curr){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i).dest;
            if(!visited[neighbour])
                topologicalSort(graph,visited,st,neighbour);
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        boolean[] vis = new boolean[6];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        for(int i = 0; i < vis.length; i++){
            if(!vis[i])
                topologicalSort(graph,vis,st,i);
        }
        System.out.println(st.reversed());
    }
}
