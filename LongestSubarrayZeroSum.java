import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int longestSubarrayZeroSum1(int[] arr) {
        int maxLen = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sum == 0) {
                maxLen = i + 1;
            } else if (sumIndexMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        
        return maxLen;
    }
    
    static int longestSubarrayZeroSum2(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            if (sum == 0) {
                maxLen = i + 1;
            } else {
               if (map.containsKey(sum)) {
                   maxLen = Math.max(maxLen, i - map.get(sum));
               } else {
                   map.put(sum, i);
               }
            }
        }
        return maxLen;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {9, -3, 3, -1, 6, -5};
		
		int result = longestSubarrayZeroSum2(nums);
		System.out.println(result);

	}
}
