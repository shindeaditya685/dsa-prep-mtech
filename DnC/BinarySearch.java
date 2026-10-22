import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int target = 7;
		
		int result = binarySearch(nums, target);
		
		System.out.println("present at index: " + result);

	}
}
