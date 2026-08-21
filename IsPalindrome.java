import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static boolean isPalidrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    
    static boolean isPalidrome2(String str, int left, int right) {
        if (left >= right) return true;
        
        if (str.charAt(left) != str.charAt(right)) return false;
        
        return isPalidrome2(str, left+1, right-1);
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String str = "ABA";
		int left = 0;
		int right = str.length() - 1;
		boolean result = isPalidrome2(str, left, right);
		System.out.println(result);
		

	}
}
