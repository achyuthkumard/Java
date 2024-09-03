import java.util.*;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        List<Item> items = new ArrayList<>();

        System.out.println("Enter the weights and values of the items:");
        for (int i = 0; i < n; i++) {
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            items.add(new Item(weight, value));
        }

        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        double maxProfit = knapsack(items, capacity);
        System.out.println("Max Profit: " + maxProfit);
    }

    public static double knapsack(List<Item> items, double capacity) {
        // Sort items by value per unit weight in descending order (Greedy choice)
        items.sort((a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        double totalValue = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += (capacity / item.weight) * item.value;
                break;
            }
        }

        return totalValue;
    }
}
