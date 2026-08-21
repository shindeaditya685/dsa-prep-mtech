import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
       
    static int factorial2(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        
        return fact;
    }
    
    
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        
        return n * factorial(n - 1);
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 5;
		int result = factorial(n);
		System.out.print(result);

	}
}
