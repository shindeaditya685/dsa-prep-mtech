import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    static void freqs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        int maxFreq = -1;
        int minFreq = -1;
        int maxElement = -1;
        int minElement = -1;
        boolean firstEntry = true;
        
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            
            if (firstEntry) {
                maxFreq = freq;
                minFreq = freq;
                maxElement = element;
                minElement = element;
                firstEntry = false;
            } else {
                if (freq > maxFreq) {
                    maxFreq = freq;
                    maxElement = element;
                } 
                
                if (freq < minElement) {
                    minFreq = freq;
                    minElement = element;
                }
            }
        }
        
         System.out.println("Highest frequency element: " + maxElement + " (appears " + maxFreq + " times)");
        System.out.println("Lowest frequency element: " + minElement + " (appears " + minFreq + " times)");
        
        
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] nums = {20, 15, 20, 20, 20};
		
        freqs(nums);
	}
}
