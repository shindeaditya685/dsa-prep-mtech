import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        
        int[][] dp = new int[n+1][W+1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                // Option 1: Don't take the item
                int notTake = dp[i - 1][w];
                
                // Option 2: Take the item
                int take = 0;
                
                if (wt[i - 1] <= w) {
                    take = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                }
                
                // Choose maximum value
                dp[i][w] = Math.max(take, notTake);
                
            }
        }
        
        return dp[n][W];
    } 
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] wt = {1, 3, 4, 5};
		int[] val = {1, 4, 5, 7};
		
		int W = 7;
		
		System.out.println("Maximum Value: " + knapsack(wt, val, W));

	}
}
