import java.util.*;
class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Node {
    int level, profit, weight;
    double bound;

    public Node(int level, int profit, int weight, double bound) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.bound = bound;
    }
}

public class KnapsackBranchAndBound {
    static int knapsack(int W, int[] wt, int[] val, int n) {
        Arrays.sort(wt);
        Arrays.sort(val);
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Double.compare(b.bound, a.bound));
        queue.add(new Node(-1, 0, 0, 0.0));

        int maxProfit = 0;

        while (!queue.isEmpty()) {
            Node u = queue.poll();

            if (u.level == -1) {
                queue.add(new Node(0, 0, 0, 0));
            }

            if (u.level == n - 1) {
                continue;
            }

            int nextLevel = u.level + 1;

            int nextWeight = u.weight + wt[nextLevel];
            int nextProfit = u.profit + val[nextLevel];

            if (nextWeight <= W && nextProfit > maxProfit) {
                maxProfit = nextProfit;
            }

            double bound = calculateBound(nextProfit, nextWeight, W, wt, val, n);

            if (bound > maxProfit) {
                queue.add(new Node(nextLevel, nextProfit, nextWeight, bound));
            }

            queue.add(new Node(nextLevel, u.profit, u.weight, bound));
        }

        return maxProfit;
    }

    static double calculateBound(int totalProfit, int totalWeight, int W, int[] wt, int[] val, int n) {
        if (totalWeight >= W) {
            return 0;
        }

        double bound = totalProfit;

        int remainingWeight = W - totalWeight;
        int i = 0;
        while (i < n && remainingWeight >= wt[i]) {
            bound += val[i];
            remainingWeight -= wt[i];
            i++;
        }

        if (i < n) {
            bound += (double) remainingWeight / wt[i] * val[i];
        }

        return bound;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of items:");
        int n = scanner.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            val[i] = scanner.nextInt();
        }

        System.out.println("Enter the capacity of the knapsack:");
        int W = scanner.nextInt();

        int maxProfit = knapsack(W, wt, val, n);
        System.out.println("Maximum profit: " + maxProfit);
    }
}