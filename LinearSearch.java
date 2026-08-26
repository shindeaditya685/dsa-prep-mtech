import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        
        return -1;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        int[] nums = {1, 2, 3, 5, 10, 7, 12};
        int key = 7;
        int result = linearSearch(nums, key);
        System.out.println(key + " is present at index: " + (result+1));
	}
}
