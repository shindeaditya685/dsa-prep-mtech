import java.util.*;
import java.lang.*;
import java.io.*;

class MinMax
{
    static class Pair {
        int min;
        int max;
        
        
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    static Pair findMinMax(int[] arr, int low, int high) {
        // Case 1; Only one element
        if (low == high) {
            return new Pair(arr[low], arr[low]);
        }
        
        // Case 2: Two elements
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                return new Pair(arr[low], arr[high]);
            } else {
                return new Pair(arr[high], arr[low]);
            }
        }
        
        // Divide
        int mid = low + (high - low) / 2;
        
        Pair left = findMinMax(arr, low, mid);
        Pair right = findMinMax(arr, mid + 1, high);
        
        // Combine
        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);
        
        return new Pair(min, max);
        
        
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {5, 2, 8, 1, 9, 3, 7};
		
		Pair result = findMinMax(arr, 0, arr.length - 1);
		
		System.out.println("Maximum: " + result.min);
		System.out.println("Minimum: " + result.max);
		
		
		

	}
}
