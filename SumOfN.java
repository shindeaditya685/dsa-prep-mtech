import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    static int sumOfN(int n, int sum) {
        if ( n == 0) return sum;
        sum += n;
        return sumOfN(n - 1, sum);
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        int n = 6;
        int sum = 0;
        
        int result = sumOfN(n, sum);
        System.out.print(result);
        
	}
}
