// TOP DOWN APPROACH

class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        int n = arr.length;

        // 0 = not visited
        // 1 = true
        // 2 = false
        int[][] dp = new int[n][k + 1];

        return recur(arr, k, n - 1, dp);
    }

    public boolean recur(int[] arr, int k, int index, int[][] dp) {

        // Target achieved
        if (k == 0) {
            return true;
        }

        // No elements left
        if (index == 0) {
            return k == arr[0];
        }

        // Already calculated
        if (dp[index][k] != 0) {
            return dp[index][k] == 1;
        }

        // Pick
        boolean pick = false;

        if (arr[index] <= k) {
            pick = recur(arr, k - arr[index], index - 1, dp);

            if (pick) {
                dp[index][k] = 1;
                return true;
            }
        }

        // Don't pick
        boolean noPick = recur(arr, k, index - 1, dp);

        dp[index][k] = noPick ? 1 : 2;

        return noPick;
    }
}

// BOTTOM UP APPROACH
class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        int n = arr.length;

        // 0 = not visited
        // 1 = true
        // 2 = false
        int[][] dp = new int[n][k + 1];

        // Sum 0 is always possible
        for (int index = 0; index < n; index++) {
            dp[index][0] = 1;
        }

        // Using only arr[0]
        for (int target = 1; target <= k; target++) {
            if (target == arr[0]) {
                dp[0][target] = 1;
            } else {
                dp[0][target] = 2;
            }
        }

        // Fill DP table
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {

                // Don't pick
                int noPick = dp[index - 1][target];

                // Pick
                int pick = 2;

                if (arr[index] <= target) {
                    pick = dp[index - 1][target - arr[index]];
                }

                // Pick OR don't pick
                if (pick == 1 || noPick == 1) {
                    dp[index][target] = 1;
                } else {
                    dp[index][target] = 2;
                }
            }
        }

        return dp[n - 1][k] == 1;
    }
}
