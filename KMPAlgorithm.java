import java.util.*;
import java.lang.*;
import java.io.*;

class KMPAlgorithm {
    static boolean lpsAlgo(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        
        int[] lps = new int[m];
        
        // lps table generation
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(len) == pattern.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // KMP search
        i = 0;
        int j = 0;
        while (i < n) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            
            if (j == m) {
                return true;
            }
        }
        
        return false;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String text = "ABCADEFAGAHIJK";
        String pattern = "AHIJK";	
        
        boolean result = lpsAlgo(text, pattern);
        System.out.println(result);

	}
}
