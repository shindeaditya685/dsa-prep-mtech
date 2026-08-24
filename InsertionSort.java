import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    
    
    static void insertionSort(int[] arr, int i, int n) {
        if (i == n) return;
        
        int j = i;
        
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }
        
        insertionSort(arr, i + 1, n);
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
		
		insertionSort(arr, 0, n);
		
		printArray(arr, "Array after sorting: ");

	}
}
