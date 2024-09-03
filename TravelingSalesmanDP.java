import java.util.Scanner;

public class TravelingSalesmanDP {
    static int[][] adjacencyMatrix;
    static int[][] dp;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        n = scanner.nextInt();
        
        adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        dp = new int[n][1 << n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }

        int startCity = 0; 
        int minCost = tsp(startCity, 1 << startCity);
        System.out.println("Minimum Cost: " + minCost);

        System.out.println("Path:");
        printPath(startCity, 1 << startCity);
    }

    static int tsp(int currentCity, int mask) {
        if (mask == (1 << n) - 1) {
            return adjacencyMatrix[currentCity][0]; 
        }
        if (dp[currentCity][mask] != -1) {
            return dp[currentCity][mask];
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if ((mask & (1 << nextCity)) == 0) {
                int cost = adjacencyMatrix[currentCity][nextCity] + tsp(nextCity, mask | (1 << nextCity));
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[currentCity][mask] = minCost;
    }

    static void printPath(int currentCity, int mask) {
        System.out.print(currentCity + " -> ");
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if ((mask & (1 << nextCity)) == 0 && dp[currentCity][mask] == adjacencyMatrix[currentCity][nextCity] + dp[nextCity][mask | (1 << nextCity)]) {
                printPath(nextCity, mask | (1 << nextCity));
                return;
            }
        }
        System.out.println(0);
    }
}