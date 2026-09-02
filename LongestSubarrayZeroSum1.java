import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int longestSubarrayZeroSum1(int[] nums, int n) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            if (sum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
    
    static int longestSubarrayZeroSum2(int[] nums, int n) {
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == 0) {
                    int length = j - i + 1;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        
        return maxLength;
    }
    
    static int longestSubarrayZeroSum3(int[] nums, int n) {
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        
        int maxLength = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + nums[i];
            
            if (firstSeen.containsKey(prefixSum)) {
                int length = i - firstSeen.get(prefixSum);
                
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                firstSeen.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {9, -3, 3, -1, 6, -5};
		int n = nums.length;
		
		int result = longestSubarrayZeroSum2(nums, n);
		System.out.println(result);

	}
}
