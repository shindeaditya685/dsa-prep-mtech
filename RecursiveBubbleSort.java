import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static void bubbleSort(int[] arr, int n) {
        if (n == 1) return;
        
        boolean didSwap = false;
        
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                didSwap = true;
            }
        }
        
        if (!didSwap) return;
        
        bubbleSort(arr, n - 1);
        
    }
    
    static void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {13, 46, 24, 52, 20, 9};
		int n = arr.length;
		
		printArray(arr, "Array before sorting: ");
		
		bubbleSort(arr, n);
		
		printArray(arr, "Array after sorting: ");

	}
}
