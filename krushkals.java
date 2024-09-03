
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class KruskalAlgorithm {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 9));
        edges.add(new Edge(0, 3, 3));
        edges.add(new Edge(1, 2,4));
        edges.add(new Edge(1, 3, 10));
        edges.add(new Edge(1, 4, 9));
        edges.add(new Edge(2, 4, 2));
        edges.add(new Edge(3, 4, 1));
        kruskalMST(edges);
    }
    public static void kruskalMST(List<Edge> edges) {
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));
        int vertices = edges.size(); 
        int[] parent = new int[vertices];
        List<Edge> mst = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
        for (Edge edge : edges) {
            int root1 = find(parent, edge.getSource());
            int root2 = find(parent, edge.getDestination());
            if (root1 != root2) {
                mst.add(edge);
                union(parent, root1, root2);
            }
        }
        printMST(mst);
    }
    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }
    private static void union(int[] parent, int root1, int root2) {
        parent[root2] = root1;
    }
    private static void printMST(List<Edge> mst) {
        System.out.println("Edge   Weight");
        for (Edge edge : mst) {
            System.out.println(edge.getSource() + " - " + edge.getDestination() + "    " + edge.getWeight());
        }
    }
    static class Edge {
        private final int source;
        private final int destination;
        private final int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public int getSource() {
            return source;
        }
        public int getDestination() {
            return destination;
        }
        public int getWeight() {
            return weight;
        }
    }
}
