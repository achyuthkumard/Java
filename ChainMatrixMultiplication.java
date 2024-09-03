public class ChainMatrixMultiplication 
    {

    public static int  chainMatrixMultiplication(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Iterate over the chain lengths
        for (int chainLength = 2; chainLength <= n; chainLength++) {
            for (int i = 0; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize with maximum value

                // Try different partition points
                for (int k = i; k < j; k++) {
                    // Calculate the cost of multiplying matrices from i to j through k
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    // Update if the current cost is smaller
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {5, 4, 6, 2, 7};
        int result = chainMatrixMultiplication(dimensions);
        System.out.println("Minimum cost of chain matrix multiplication: " + result);
    }
}


