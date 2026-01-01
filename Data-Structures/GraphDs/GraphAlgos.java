package GraphDs;

import java.util.ArrayList;

import static GraphDs.GraphDs.createGraph;
import static GraphDs.GraphDs.Edge;

public class GraphAlgos {
    static void allPathsToTarget(ArrayList<Edge> graph[], boolean[] visited, int curr, StringBuilder path, int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i).dest;
            if(!visited[neighbour]){
                int len = path.length();
                path.append(neighbour+" ");
                allPathsToTarget(graph, visited, neighbour, path, target);
                path.setLength(len);
            }
        }
        visited[curr] = false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        createGraph(graph);
        boolean[] visited = new boolean[7];
        allPathsToTarget(graph,visited,0,new StringBuilder("0 "),5);
    }
}
