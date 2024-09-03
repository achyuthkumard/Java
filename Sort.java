// You are using Java
import java.util.*;

class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        Collections.sort(numbers);
        System.out.println(numbers);
        
    }
}
