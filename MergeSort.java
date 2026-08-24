import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    
    static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }
        
        while (left <= mid) {
            temp.add(arr[left++]);
        }
        
        while (right <= high) {
            temp.add(arr[right++]);
        }
        
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    
    
    static void mergedrySort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        
        int mid = (low + high) / 2;
        
        mergeSort(arr, low, mid);
        
        mergeSort(arr, mid + 1, high);
        
        merge(arr, low, mid, high);
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {5, 2, 8, 4, 1};
		
		mergeSort(arr, 0, arr.length - 1);
		for (int num : arr) {
		    System.out.print(num + " ");
		}
		System.out.println();
		

	}
}


/*

Dry Run — Your Merge Sort on arr = {5, 2, 8, 4, 1}

Array indices: arr[0]=5, arr[1]=2, arr[2]=8, arr[3]=4, arr[4]=1

Call: mergeSort(arr, 0, 4)

Phase 1: Recursive Splitting (Divide)

Let's trace the recursion tree, showing each call's low, mid, high:

mergeSort(0, 4)  → mid = (0+4)/2 = 2
├── mergeSort(0, 2)  → mid = (0+2)/2 = 1
│   ├── mergeSort(0, 1)  → mid = (0+1)/2 = 0
│   │   ├── mergeSort(0, 0)  → low>=high, return (base case)
│   │   ├── mergeSort(1, 1)  → low>=high, return (base case)
│   │   └── merge(arr, 0, 0, 1)
│   ├── mergeSort(2, 2)  → low>=high, return (base case)
│   └── merge(arr, 0, 1, 2)
├── mergeSort(3, 4)  → mid = (3+4)/2 = 3
│   ├── mergeSort(3, 3)  → low>=high, return (base case)
│   ├── mergeSort(4, 4)  → low>=high, return (base case)
│   └── merge(arr, 3, 3, 4)
└── merge(arr, 0, 2, 4)

The recursion keeps splitting until every subarray is a single element (trivially sorted). Now let's trace each merge call in the order it actually executes — deepest/leftmost first.

Phase 2: Merging (Conquer/Combine)
Merge Call 1: merge(arr, 0, 0, 1) — merging arr[0..0] and arr[1..1]

Left subarray: [5] (index 0), Right subarray: [2] (index 1)

Step	left ptr	right ptr	Compare	Winner	temp[]
1	arr[0]=5	arr[1]=2	5 <= 2? No	right wins → 2	[2]

Right exhausted first. Leftover loop copies remaining left: arr[0]=5 → temp = [2, 5]

Copy back into arr[0..1]: arr = [2, 5, 8, 4, 1]

Merge Call 2: merge(arr, 0, 1, 2) — merging arr[0..1] and arr[2..2]

Left subarray: [2, 5] (indices 0-1), Right subarray: [8] (index 2)

Step	left ptr	right ptr	Compare	Winner	temp[]
1	arr[0]=2	arr[2]=8	2<=8? Yes	left wins → 2	[2]
2	arr[1]=5	arr[2]=8	5<=8? Yes	left wins → 5	[2,5]

Left exhausted. Leftover loop copies remaining right: arr[2]=8 → temp = [2, 5, 8]

Copy back into arr[0..2]: arr = [2, 5, 8, 4, 1]

(No visible change here since it was already in this order — but logically, this merge call is what "confirms" [2,5,8] as sorted for this range.)

Merge Call 3: merge(arr, 3, 3, 4) — merging arr[3..3] and arr[4..4]

Left subarray: [4] (index 3), Right subarray: [1] (index 4)

Step	left ptr	right ptr	Compare	Winner	temp[]
1	arr[3]=4	arr[4]=1	4<=1? No	right wins → 1	[1]

Right exhausted first. Leftover loop copies remaining left: arr[3]=4 → temp = [1, 4]

Copy back into arr[3..4]: arr = [2, 5, 8, 1, 4]

Merge Call 4 (Final): merge(arr, 0, 2, 4) — merging arr[0..2] and arr[3..4]

Left subarray: [2, 5, 8] (indices 0-2), Right subarray: [1, 4] (indices 3-4)

Step	left ptr value	right ptr value	Compare	Winner	temp[]
1	arr[0]=2	arr[3]=1	2<=1? No	right wins → 1	[1]
2	arr[0]=2	arr[4]=4	2<=4? Yes	left wins → 2	[1,2]
3	arr[1]=5	arr[4]=4	5<=4? No	right wins → 4	[1,2,4]

Right exhausted (right pointer passed index 4, high). Leftover loop copies remaining left: arr[1]=5, arr[2]=8 → temp = [1, 2, 4, 5, 8]

Copy back into arr[0..4]: arr = [1, 2, 4, 5, 8]

Final Result
arr = [1, 2, 4, 5, 8]

✅ Fully sorted, matching what your code would print: 1 2 4 5 8


*/
