import java.util.*;

public class BasicDP {

    // fibbonacci series using tabulation iterative solution with 0(1) space
    public static int fiboTabulationOptimized(int n) {
        int sprev = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = sprev + prev;
            sprev = prev;
            prev = curr;
        }
        return prev;
    }

    // fibbonacci series using tabulation iterative solution with O(N) space
    public static int fiboTabulation(int n) {
        // base case
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // the tis recurance relation only executes on the ith value is >=2
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // returning result
        return dp[n];
    }

    // fibbonacci series using dp. using o(n) spce and o(n) recursion stack
    public static int fibo(int n, int[] dp) {
        // base case
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        // checking if already computed and returning it
        if (dp[n] != -1) {
            System.out.println("Reused :" + n + ": " + dp[n]);
            return dp[n];
        }
        // storing and returning result
        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }

    // 70. Climbing Stairs
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int sum = 0;
        sum += climbStairs(n - 1);
        sum += climbStairs(n - 2);
        return sum;
    }

    // 70. Climbing Stairs optimized
    public static int climbStairs(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1)
            return dp[n];
        int sum = 0;
        sum += climbStairs(n - 1, dp);
        sum += climbStairs(n - 2, dp);
        return dp[n] = sum;
    }

    // 70 Climbing Stairs using tabulation
    // public static int climbStairsTabulation(int n, int[] dp) {
    // if (n == 0) {
    // return 1;
    // }
    // if (n < 0) {
    // return 0;
    // }
    // int prev=0;
    // dp[1]=

    // if (dp[n] != -1)
    // return dp[n];
    // int sum = 0;
    // sum += climbStairs(n - 1,dp);
    // sum += climbStairs(n - 2,dp);
    // return dp[n] = sum;
    // }

    // Frog Jump
    public static int frogJump(int[] heights) {
        int dp[] = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return frogJump(heights, heights.length - 1, dp);
    }

    public static int frogJump(int[] heights, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
        int secondStep = Integer.MAX_VALUE;
        int firstStep = frogJump(heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);
        if (index > 1)
            secondStep = frogJump(heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);

        return dp[index] = Math.min(firstStep, secondStep);
    }

    // frog jump with k steps
    public static int frogJumpWithK(int[] heights, int k) {

        int dp[] = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return frogJumpWithK(heights, heights.length - 1, dp, k);
    }

    public static int frogJumpWithK(int[] heights, int index, int[] dp, int k) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
        int minEnergy = Integer.MAX_VALUE;
        int step = 0;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                step = frogJumpWithK(heights, index - i, dp, k) + Math.abs(heights[index] - heights[index - i]);
            }
            minEnergy = Math.min(step, minEnergy);
        }

        return dp[index] = minEnergy;
    }

    // 198. House Robber

    public static int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1, dp);
    }

    public static int rob(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return nums[index];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int pick = (index - 2 >= 0) ? rob(nums, index - 2, dp) + nums[index] : nums[index];

        int nonPick = rob(nums, index - 1, dp) + 0;
        return dp[index] = Math.max(pick, nonPick);
    }

    // 213. House Robber II

    public static int rob1(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int dp1[] = new int[nums.length + 1];
        Arrays.fill(dp1, -1);
        int nums1[] = new int[nums.length - 1];
        int nums2[] = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                nums1[i - 1] = nums[i];
            if (i != nums.length - 1)
                nums2[i] = nums[i];
        }
        return Math.max(rob1(nums1, nums1.length - 1, dp), rob1(nums2, nums2.length - 1, dp1));
    }

    public static int rob1(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return nums[index];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int pick = (index - 2 >= 0) ? rob1(nums, index - 2, dp) + nums[index] : nums[index];

        int nonPick = rob1(nums, index - 1, dp) + 0;
        return dp[index] = Math.max(pick, nonPick);
    }

    public static void main(String[] args) {
        // fibbonaaci series
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // System.out.println(fibo(n, dp));
        // System.out.println(fiboTabulation(n));
        // System.out.println(fiboTabulationOptimized(n));

        // System.out.println(climbStairs(n));
        int arr[] = { 1, 2, 3 };

        // System.out.println(frogJumpWithK(arr, 3));
        System.out.println(rob1(arr));

    }
}
