import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int[] findMissingRepeating(int[] nums) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        int repeating = 0;
        
        for (int num : nums) {
            set.add(num);
            if (set.contains(num)) {
                repeating = num;
            }
        }
        
        int missing = 0;
        
        int counter = 1;
        
        for (int num : set) {
            if (!set.contains(counter)) {
                missing = counter;
                break;
            }
            counter++;
        }
        
        return new int[]{repeating, missing};
        
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {3, 5, 4, 1, 1};
		
		int[] result = findMissingRepeating(nums);
		
		System.out.println(result[0] + " " + result[1]);
		

	}
}
