import java.util.*;
import java.lang.*;
import java.io.*;


class Sorting {
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
    
    static void insertionSort(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            
            nums[j + 1] = key;
        }
    }
    
    static void selectionSort(int[] nums, int n) {
        int i = 0;
        
        while (i < n - 1) {
            int minIndex = i;
            int j = i + 1;
            
            while (j < n) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            i++;
            
        }
    }
}

class Codechef
{
    
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    Sorting sorting = new Sorting();
	    
		int[] nums = {12, 1, 13, 2, 14, 3, 15, 4, 16, 5};
		
		sorting.bubbleSort(nums, nums.length );
		System.out.println(Arrays.toString(nums));
		sorting.selectionSort(nums, nums.length);
		System.out.println(Arrays.toString(nums));
		sorting.insertionSort(nums, nums.length);
		
		System.out.println(Arrays.toString(nums));
	}
}
