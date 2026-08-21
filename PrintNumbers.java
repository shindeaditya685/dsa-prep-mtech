import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static void printNumbers(int n, int counter) {
        if (n == 0) return;
        System.out.println(counter);
        counter++;
        printNumbers(n - 1, counter);
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 4;
		int counter = 1;
		printNumbers(n, counter);
	}
}
