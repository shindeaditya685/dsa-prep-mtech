import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static void printNumberReverse(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNumberReverse(n - 1);
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 4;
		printNumberReverse(n);
	}
}
