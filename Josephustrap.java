import java.io.*;
class Josephustrap {

    static int josephus( int n, int k){
        if (n==1)
        return 1;
        else
        return (josephus(n-1,k)+k-1) % n+1;
    }
    public static void main(String []args){
       // Scanner sc = new Scanner(System.in);
        int n = 5;
        int k = 2;
        System.out.println(josephus(n,k));
        
    }
    
}
    

