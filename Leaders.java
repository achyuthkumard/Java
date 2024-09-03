class Leaderarray{
    void printLeaders(int arr[], int size){
        for (int i=0; i<=size; i++){
            int j;
            for(j =1; j<size; j++)
            {
                if (arr[i] <=arr[j])
                    break ;
            }if (j==size)
            System.out.println(arr[i]+ " ");
        } 
       
    }
    public static void main(String[]args){
        Leaderarray lead = new Leaderarray();
        int arr[] = new int[]{19,10,46,89,1,10};
        int n = arr.length;
        lead.printLeaders(arr, n);
    }
}