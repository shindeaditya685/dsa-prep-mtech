import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int[] largestNumbers(int[] arr) {
        int n = arr.length;
        if (n < 2) return new int[]{arr[0], -1};
        
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                secondLarge = large;
                large = arr[i];
            } else if (arr[i] > secondLarge && arr[i] != large) {
                secondLarge = arr[i];
            }
        }
        
        return new int[]{large, secondLarge};
        
    }
    
    
    
    static int[] smallesNumbers(int[] arr) {
        int n = arr.length;
        if (n < 2) return new int[]{arr[0], -1};
        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        
        return new int[]{smallest, secondSmallest};
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {1, 3, 24, 45, 9, 10, 78};
		
// 		int[] result = largestNumbers(arr);
        int[] result = smallesNumbers(arr);
		
		System.out.println("smaller number: " + result[0] +"\n second smaller number: " + result[1]);

	}
}
