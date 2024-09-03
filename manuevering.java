import java.util.*;
class Manuevering{
    static int noofpaths(int m, int n){
        if(m==0||n==0)
        return 1;
        return noofpaths(m-1,n)+noofpaths(m,n-1);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(noofpaths(a,b));
    }
}