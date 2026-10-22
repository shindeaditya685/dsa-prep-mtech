import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            
            merge(nums, start, mid, end);
        }
    }
    
    
    static void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[nums.length];
        
        while (i <= mid && j <= end) {
            if (nums[i] >= nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        
        
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        
        while(j <= end) {
            temp[k++] = nums[j++];
        }
        
        for (i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		
		int[] nums = {9, 1, 10, 2, 11, 3, 12, 4};
		
		mergeSort(nums, 0, nums.length - 1);
		
		System.out.println(Arrays.toString(nums));

	}
}
