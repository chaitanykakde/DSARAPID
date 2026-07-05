import java.util.*;

public class SubsequencesDP {

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        int[][] dp = new int[n][k + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return subsetSumToKTab(n, k, arr);
    }

    // tabulation
    public static boolean subsetSumToKTab(int n, int k, int arr[]) {
        // Write your code here.
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;

        }

        // write loops for changign parameters
        for (int index = 1; index < n; index++) {

            for (int target = 1; target <= k; target++) {

                // recurrance
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if (arr[index] <= target) {
                    take = dp[index - 1][target - arr[index]];
                }
                dp[index][target] = notTake || take;

            }
        }

        for (boolean[] x : dp) {
            System.out.println(Arrays.toString(x));
        }
        return dp[n - 1][k];

    }

    public static boolean subsetSumToK1(int index, int target, int[] arr, int[][] dp) {
        // base case
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == arr[index];
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        // recurrance
        boolean notTake = subsetSumToK1(index - 1, target, arr, dp);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToK1(index - 1, target - arr[index], arr, dp);
        }
        dp[index][target] = ((notTake || take) ? 1 : 0);
        return dp[index][target] == 1;
    }

    // 416. Partition Equal Subset Sum
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given an integer array nums, return true if you can partition the array into
    // two subsets such that the sum of the elements in both subsets is equal or
    // false otherwise.

    // Example 1:

    // Input: nums = [1,5,11,5]
    // Output: true
    // Explanation: The array can be partitioned as [1, 5, 5] and [11].
    // Example 2:

    // Input: nums = [1,2,3,5]
    // Output: false
    // Explanation: The array cannot be partitioned into equal sum subsets.

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int x : nums) {
            sum += x;

        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[nums.length][sum / 2 + 1];
        // for (int[] x : dp) {
        // Arrays.fill(x, -1);
        // }
        return canPartitionTab(nums.length - 1, sum / 2, nums, dp);
    }

    public boolean canPartition(int index, int target, int nums[], int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == nums[index];
        }
        // check if already computed
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        /// write the recurance now

        boolean notTake = canPartition(index - 1, target, nums, dp);
        boolean take = false;
        if (nums[index] <= target) {
            take = canPartition(index - 1, target - nums[index], nums, dp);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return dp[index][target] == 1;

    }

    public boolean canPartitionTab(int index, int target, int nums[], int[][] dp) {
        for (int i = 0; i <= index; i++) {
            dp[i][0] = 1;
        }
        // if (target == 0) {
        // return true;
        // }
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for (int ind = 1; ind <= index; ind++) {
            for (int tar = 1; tar <= target; tar++) {

                boolean notTake = dp[ind - 1][tar] == 1;
                boolean take = false;
                if (nums[ind] <= tar) {
                    take = dp[ind - 1][tar - nums[ind]] == 1;
                }
                dp[ind][tar] = (take || notTake) ? 1 : 0;

            }

        }
        return dp[index][target] == 1;

    }

    public static int minSubsetSumDifference(int[] nums, int n) {
        // Write your code here.

        int sum = 0;
        for (int x : nums) {
            sum += x;

        }

        int[][] dp = new int[nums.length][sum + 1];

        minSubsetSumDifference(nums.length - 1, sum, nums, dp);
        int minDiif = (int) 1e9;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n - 1][s1] == 1) {
                minDiif = Math.min(minDiif, Math.abs((sum - s1) - s1));
            }

        }
        return minDiif;

    }

    public static boolean minSubsetSumDifference(int index, int target, int nums[], int[][] dp) {
        for (int i = 0; i <= index; i++) {
            dp[i][0] = 1;
        }
        // if (target == 0) {
        // return true;
        // }
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for (int ind = 1; ind <= index; ind++) {
            for (int tar = 1; tar <= target; tar++) {

                boolean notTake = dp[ind - 1][tar] == 1;
                boolean take = false;
                if (nums[ind] <= tar) {
                    take = dp[ind - 1][tar - nums[ind]] == 1;
                }
                dp[ind][tar] = (take || notTake) ? 1 : 0;

            }

        }
        return dp[index][target] == 1;

    }

    // Problem statement
    // You are given an array 'arr' of size 'n' containing positive integers and a
    // target sum 'k'.

    // Find the number of ways of selecting the elements from the array such that
    // the sum of chosen elements is equal to the target 'k'.

    // Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

    // Example:
    // Input: 'arr' = [1, 1, 4, 5]

    // Output: 3

    // Explanation: The possible ways are:
    // [1, 4]
    // [1, 4]
    // [5]
    // Hence the output will be 3. Please note that both 1 present in 'arr' are
    // treated differently.

    public static int findWays(int num[], int tar) {
        // Write your code here.
        int dp[][] = new int[num.length][tar + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return findWays(num.length - 1, tar, num, dp);
    }

    public static int findWays(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (nums[index] == 0 && target == 0) {
                return 2;
            } else if (nums[index] == target || target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // check already computed
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // apply recurrance
        int noPick = findWays(index - 1, target, nums, dp);
        int pick = 0;
        if (nums[index] <= target) {
            pick = findWays(index - 1, target - nums[index], nums, dp);
        }

        return dp[index][target] = (noPick + pick) % ((int) 1e9 + 7);
    }

    public static int findWaysTab(int index, int target, int[] nums, int[][] dp) {

        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }
        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;
        for (int ind = 1; ind <= index; ind++) {
            for (int tar = 0; tar <= target; tar++) {

                int noPick = dp[ind - 1][tar];
                int pick = 0;
                if (nums[ind] <= tar) {
                    pick = dp[ind - 1][tar - nums[ind]];
                }

                dp[ind][tar] = (noPick + pick) % ((int) 1e9 + 7);
            }
        }

        // if (index == 0) {
        // if (nums[index] == 0 && target == 0) {
        // return 2;
        // } else if (nums[index] == target || target == 0) {
        // return 1;
        // } else {
        // return 0;
        // }
        // }

        // check already computed
        // if (dp[index][target] != -1) {
        // return dp[index][target];
        // }

        // apply recurrance
        // int noPick = findWays(index - 1, target, nums, dp);
        // int pick = 0;
        // if (nums[index] <= target) {
        // pick = findWays(index - 1, target - nums[index], nums, dp);
        // }

        // return dp[index][target] = (noPick + pick) % ((int) 1e9 + 7);
        return dp[index][target];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(subsetSumToK(arr.length, 5, arr));

    }
}
