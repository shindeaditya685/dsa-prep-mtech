import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static void printName(String name, int n) {
        if (n == 0) return;
        System.out.print(name + " ");
        printName(name, n - 1);
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String name = "Aditya";
		int n = 3;
		
		printName(name, n);

	}
}
