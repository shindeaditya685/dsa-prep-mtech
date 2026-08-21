import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    static void fibonacci1(int n) {
        int s0 = 0;
        int s1 = 1;
        
        System.out.print(s0 + " " + s1 + " ");
       
        for (int i = 2; i <= n; i++) {
            int s3 = s0 + s1;
            System.out.print(s3 + " ");
            s0 = s1;
            s1 = s3;
            
        }
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 5;
		
		int result = fibonacci(n);
	
		fibonacci1(n);

	}
}
