import java.util.*;

class Codechef {
    static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // Returns a new reversed array (non‑destructive)
    static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[n - 1 - i];
        }
        return ans;
    }

    // Reverses in‑place using two pointers
    static int[] reverseArray2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    // Recursive in‑place reversal with proper base case and swap
    static int[] reverseArray3(int[] nums, int left, int right) {
        if (left >= right) return nums;          // base case
        // swap
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        // recurse with next indices
        return reverseArray3(nums, left + 1, right - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // Result1: new reversed array
        int[] result1 = reverseArray(nums);
        System.out.print("result1 (copy): ");
        printArray(result1);   // prints 5 4 3 2 1

        // Result2: in‑place reverse – nums becomes reversed
        int[] result2 = reverseArray2(nums);
        System.out.print("result2 (in‑place): ");
        printArray(result2);   // prints 5 4 3 2 1 (same as nums)

        // Result3: recursive reverse – this will reverse nums again back to original
        int[] result3 = reverseArray3(nums, 0, nums.length - 1);
        System.out.print("result3 (recursive, now back to original): ");
        printArray(result3);   // prints 1 2 3 4 5
    }
}
