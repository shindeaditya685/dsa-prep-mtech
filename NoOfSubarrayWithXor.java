import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int noOfSubarraywithKXor1(int[] nums, int k, int n) { 
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int xor = nums[i];
            
            if (xor == k) count++;
            
            for (int j = i + 1; j < n; j++) {
                xor = xor ^ nums[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    static int noOfSubarraywithKXor2(int[] nums, int k, int n) {
        Map<Integer, Integer> xorCount = new HashMap<>();
        xorCount.put(0, 1);
        
        int prefixXor = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            prefixXor = prefixXor ^ nums[i];
            int needed = prefixXor ^ k;
            
            if (xorCount.containsKey(needed)) {
                count = count + xorCount.get(needed);
            }
            
            xorCount.put(prefixXor, xorCount.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {4, 2, 2, 6, 4};
		int n = nums.length;
		
		int result = noOfSubarraywithKXor2(nums,6, n);
		System.out.println(result);

	}
}
