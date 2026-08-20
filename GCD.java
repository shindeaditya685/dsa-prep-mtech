import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static int GCD1(int n1, int n2) {
        int gcd = 1;
        
        for (int i = 1; i < Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        
        return gcd;
    }
    
    static int GCD2(int n1, int n2) {
        int gcd = 1;
        
        for (int i = Math.min(n1, n2); i > 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        
        return gcd;
    }
    
    static int GCD3(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return n1 > 0 ? n1 : n2;
        } else if (n1 > n2) {
            return GCD3(n1-n2, n2);
        } else {
            return GCD3(n1, n2-n1);
        }
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n1 = 20;
		int n2 = 15;
		
		int result = GCD2(n1, n2);
		System.out.print(result);
		

	}
}
