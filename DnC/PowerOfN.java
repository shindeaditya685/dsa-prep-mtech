import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static long power(long x, int n) {
        if (n == 0) {
            return 1;
        }
      
        
        long half = power(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		long x = 2;
		int n = 10;
		
		System.out.println(power(x, n));

	}
}
