import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{

    static boolean isArmstrong1(int n) {
        String numStr = String.valueOf(n);
        int digitCount = numStr.length();
        
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            sum += Math.pow(digit, digitCount);
        }
        
        return sum == n;
        
        /*
        Time Complexity: O(d) where d = number of digits — fine, but conversion to String and use of Math.pow (which internally uses floating point) adds overhead.
Space Complexity: O(d) — the string itself takes space proportional to digit count.
        */
    }    
    
    static boolean isArmstrong2(int n) {
        int original = n;
        int digitCount = 0;
        int temp = n;
        
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }
        
        temp = n;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            int power = 1;
            for (int i = 0; i < digitCount; i++) {
                power = power * digit;
            }
            
            sum = sum + power;
            temp = temp / 10;
        }
        
        return sum == original;
        
    }
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int num = 153;
		
		
        System.out.println(isArmstrong2(num));
	}
}

/*
6. Complexity Analysis Summary

String Conversion Approach

Time: O(d) — but with Math.pow() overhead and potential float precision risk
Space: O(d) — for the string

Pure Digit Manipulation (Optimal)

Time: O(d²) worst case (d digits × d-length manual power loop each) — but since d is always tiny (≤ ~10 for realistic constraints), this is extremely fast in absolute terms
Space: O(1) — no strings or arrays, just a few variables
*/
