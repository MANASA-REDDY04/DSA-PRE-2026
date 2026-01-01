package GraphAlgos;

import java.util.ArrayList;

public class CyclicDetection {
    static class Edge{
        int src;
        int dest;
        boolean dir;
        Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph){
//        graph[0].add(new Edge(0,2));
//        graph[1].add(new Edge(1,0));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,0));

//        graph[0].add(new Edge(0,1));
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,4));
//        graph[4].add(new Edge(4,2));

//        graph[0].add(new Edge(0,1));
//        graph[0].add(new Edge(0,4));
//        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,2));
////        graph[1].add(new Edge(1,4));
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,2));
//        graph[4].add(new Edge(4,0));
////        graph[4].add(new Edge(4,1));
//        graph[4].add(new Edge(4,5));
//        graph[5].add(new Edge(5,4));

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 4));
        graph[4].add(new Edge(4, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

    }
    static boolean isCyclicDFSDirected(ArrayList<Edge>[] graph, boolean[] vis, boolean[] recStack,int curr){
        vis[curr] = true;
        recStack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i).dest;
            if(!vis[neighbour]){
                if(isCyclicDFSDirected(graph,vis,recStack,neighbour))
                    return true;
            }
            else if(recStack[neighbour]) return true;
        }
        recStack[curr] = false;
        return false;
    }

    static boolean isCyclicDFSUnDirected(ArrayList<Edge>[] graph, boolean[] vis, int curr,int parent){
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i).dest;
            if (!vis[neighbour]) {
                if (isCyclicDFSUnDirected(graph, vis, neighbour, curr)) {
                    return true;
                }
            }
            else if(neighbour != parent) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        for(int i = 0; i < 6; i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        boolean[] vis = new boolean[6];
        boolean[] resStack = new boolean[6];
        for(int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
//                boolean isCyclic = isCyclicDFSDirected(graph, vis, resStack, i);
                boolean isCyclic = isCyclicDFSUnDirected(graph,vis,i,-1);
                if (isCyclic) {
                    System.out.println("Cyclic");
                    break;
                }
            }
        }
    }
}
