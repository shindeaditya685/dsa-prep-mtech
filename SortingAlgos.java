import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
    static int[] selectionSort(int[] nums) {
        int n = nums.length;
        
        for (int i = 0;i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        
        return nums;
    }
    
    static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
        
        return nums;
    }
    
    static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[ j + 1] = key;
        }
        
        return nums;
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        int[] nums = {13, 46, 24, 52, 20, 9};
        
        
        int[] result1 = selectionSort(nums);
        int[] result2 = bubbleSort(nums);
        int[] result3 = insertionSort(nums);
        printArray(result3);
	}
}
