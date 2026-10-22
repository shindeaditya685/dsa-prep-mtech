import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    static void bubbleSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            
            if (!flag) {
                break;
            }
        }
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] nums = {12, 1, 13, 2, 14, 3, 15, 4, 16, 5};
		
		bubbleSort(nums, nums.length );
		
		System.out.println(Arrays.toString(nums));
	}
}
