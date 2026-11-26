import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int fibTopDown(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }
    
    static int recur(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        } 
        
        if (dp[n] != -1) {
            return dp[n];
        }
        
        dp[n] = recur(n-1, dp) + recur(n-2, dp);
        
        return dp[n];
    }
    
    static int fibBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int n = 5;
		
		int result1 = fibTopDown(n);
		int result2 = fibBottomUp(n);
		System.out.println("Using Top-Down Approach: " + result1);
		System.out.println("Using Bottom-Up Approach: " + result2);

	}
}
