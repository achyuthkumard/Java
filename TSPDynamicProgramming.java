import java.util.Scanner;

public class TSPDynamicProgramming {

    static int tsp(int[][] graph, int n, int start) {
        // Array to store the state of each subproblem
        int[][] dp = new int[n][(1 << n)];
        
        // Initialize dp array with -1
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        // Base case: If all cities have been visited
        if ((1 << n) - 1 == start) {
            return graph[start][0];
        }

        // Recursive DP function to solve TSP
        return tspUtil(graph, n, start, 0, dp);
    }

    static int tspUtil(int[][] graph, int n, int start, int mask, int[][] dp) {
        // If this subproblem has already been solved, return the result from the dp array
        if (dp[start][mask] != -1) {
            return dp[start][mask];
        }

        // Initialize result for this subproblem
        int minCost = Integer.MAX_VALUE;

        // Try all cities as next steps
        for (int city = 0; city < n; city++) {
            // If the city has not been visited
            if ((mask & (1 << city)) == 0) {
                int newMask = mask | (1 << city);
                int cost = graph[start][city] + tspUtil(graph, n, city, newMask, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        // Save the result in dp array
        dp[start][mask] = minCost;

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();
        
        // Create graph
        int[][] graph = new int[n][n];
        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Start from city 0
        int startCity = 0;
        
        // Calculate the minimum cost
        int minCost = tsp(graph, n, startCity);
        System.out.println("Minimum cost of traversal: " + minCost);

        scanner.close();
    }
}
