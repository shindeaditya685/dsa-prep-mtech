import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int longestSubarray1(int[] nums, int target) {
        int n = nums.length;
        int maxLength = 0;
        
        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                int currentSum = 0;
                
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }
                
                if (currentSum == target) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }
        
        return maxLength;
    }
    
    static int longestSubarray2(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int sum = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            sum = sum + arr[right];
            
            while (sum > k) {
                sum = sum - arr[left];
                left++;
            }
            
            if (sum == k) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            }
        }
        
        return maxLen;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {10, 5, 2, 7, 1, 9};
		
		int result = longestSubarray2(nums, 15);
		System.out.println(result);

	}
}
