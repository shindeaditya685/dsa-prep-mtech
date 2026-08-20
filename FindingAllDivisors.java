import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static ArrayList<Integer> allDivisiors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                int pair = n / i;
                if (pair != i) {
                    list.add(pair);
                }
            }
        }
        
        return list;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 15;
		ArrayList<Integer> result = allDivisiors(n);
		System.out.print(result);

	}
}
