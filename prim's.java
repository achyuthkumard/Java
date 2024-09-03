import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class PrimAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 9, 0, 3, 0},
                {1, 0, 9, 10, 5},
                {0, 3, 0, 0, 7},
                {3, 4, 0, 0, 9},
                {0, 2, 7, 9, 0}
        };
        primMST(graph);
    }
    public static void primMST(int[][] graph) {
        int vertices = graph.length;
        int[] parent = new int[vertices];
        int[] key = new int[vertices];   
        boolean[] mstSet = new boolean[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(vertices, (a, b) -> Integer.compare(a.key, b.key));
        key[0] = 0;
        parent[0] = -1;
        priorityQueue.add(new Node(0, key[0]));
        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().vertex;
            mstSet[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                    priorityQueue.add(new Node(v, key[v]));
                }
            }
        }
        printMST(parent, graph);
    }
    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }
    static class Node {
        int vertex;
        int key;
        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }
}
