import java.util.*;   
class Combination {  
   static int fact(int number) {  
      int f = 1;  
      int j = 1;  
      while(j <= number) {  
         f = f * j;  
         j++;  
      }  
      return f;  
   }  
   public static void main(String args[]) {  
         List<Integer> numbers = new ArrayList<Integer>();  
        
      numbers.add(2);  
      numbers.add(10);  
      numbers.add(9);  
      numbers.add(54);  
      numbers.add(18);  
        
      int n = numbers.size();  
      int r = 4;  
      int result;  
        
      result = fact(n) / (fact(r) * fact(n-r));  
      System.out.println("The combination value for the numbers list is: " + result);  
   }  
}  