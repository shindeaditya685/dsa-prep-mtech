import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int[] findFloorCeil(int[] nums, int x) {
        int ceilVal = findCeil(nums, x);
        int floorVal = findFloor(nums, x);
        
        return new int[]{ceilVal, floorVal};
    }
    
    
    static int findCeil(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] >= x) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    static int findFloor(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] <= x) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {3, 4, 4, 7, 8, 10};
		int x = 5;
		
		int[] result = findFloorCeil(nums, x);
		
		System.out.print(result[1] + " " + result[0]);

	}
}
