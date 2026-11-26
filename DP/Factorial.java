import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int factorialTopDown(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }
    
    static int recur(int n, int[] dp) {
        if (n == 1) {
            dp[n] = 1;
            return dp[n];
        }
        
        if (dp[n] != -1) {
            return dp[n];
        }
        
        dp[n] = n * recur(n - 1, dp);
        
        return dp[n];
    }
    
    static int factorialBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        return dp[n];
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 5;
		
		int result1 = factorialTopDown(n);
		int result2 = factorialBottomUp(n);
		System.out.println("Using Top-Down: " + result1);
		System.out.println("Using Bottom-Up: " + result2);

	}
}
