
import java.util.Scanner;
public class BinarySearch { 
	int binarySearch(int arr[], int l, int r, int x) { 
		if (r>=l) { 
			int mid = l + (r - l)/2; 
			if (arr[mid] == x) 
				return mid; 
			if (arr[mid] > x) 
				return binarySearch(arr, l, mid-1, x); 
			return binarySearch(arr, mid+1, r, x); 
		} 
		return -1; 
	}  
	public static void main (String[]args) { 
		Scanner input = new Scanner(System.in);
		BinarySearch ob = new BinarySearch(); 
		System.out.print("Enter the size of the array -");
		int size = input.nextInt();
		int arr[] = new int [size]; 
		for(int i =0;i<size;i++){
			System.out.print("Enter the value of the element - ");
			arr[i]= input.nextInt();
		}
		System.out.print("The array is: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		int n = arr.length; 
		System.out.print("\nEnter the element to find in the array - ");
		int x = input.nextInt();
		int result = ob.binarySearch(arr,0,n-1,x); 
		if (result == -1) 
			System.out.println("Element not present"); 
		else
			System.out.println("Element found at index " + result); 
		input.close();
	} 
}

