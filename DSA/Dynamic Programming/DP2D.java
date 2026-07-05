import java.util.*;

public class DP2D {

    // Ninja's training
    // Subscribe to TUF+

    // Hints
    // Company
    // A ninja has planned a n-day training schedule. Each day he has to perform one
    // of three activities - running, stealth training, or fighting practice. The
    // same activity cannot be done on two consecutive days and the ninja earns a
    // specific number of merit points, based on the activity and the given day.

    // Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and
    // matrix[i][2], represent the merit points associated with running, stealth and
    // fighting practice, on the (i+1)th day respectively. Return the maximum
    // possible merit points that the ninja can earn.

    // Example 1

    // Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]

    // Output: 210

    // Explanation:

    // Day 1: fighting practice = 70

    // Day 2: stealth training = 50

    // Day 3: fighting practice = 90

    // Total = 70 + 50 + 90 = 210

    // This gives the optimal points.
    public static int ninjaTraining(int[][] matrix) {
        int dp[][] = new int[matrix.length][4];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return ninjaTraining(matrix, matrix.length - 1, 3, dp);
    }

    public static int ninjaTraining(int[][] matrix, int day, int lastTask, int[][] dp) {
        // handle base case
        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != lastTask)
                    max = Math.max(matrix[day][i], max);
            }
            return max;
        }
        // check overlapping subproblems
        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }

        // now perform a task
        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (lastTask != i) {
                max = Math.max(max, ninjaTraining(matrix, day - 1, i, dp) + matrix[day][i]);
            }
        }
        return dp[day][lastTask] = max;
    }

    // 62. Unique Paths
    // There is a robot on an m x n grid. The robot is initially located at the
    // top-left corner (i.e., grid[0][0]). The robot tries to move to the
    // bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
    // either down or right at any point in time.

    // Given the two integers m and n, return the number of possible unique paths
    // that the robot can take to reach the bottom-right corner.

    // The test cases are generated so that the answer will be less than or equal to
    // 2 * 109.

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return uniquePaths(m - 1, n - 1, dp);
    }

    public static int uniquePaths(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }

        // check dp
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // apply all stuffs on index
        int count = 0;
        count += uniquePaths(m - 1, n, dp);
        count += uniquePaths(m, n - 1, dp);

        return dp[m][n] = count;
    }

    public static int uniquePathsTab(int m, int n) {

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                int count = 0;

                if (i == 0 && j == 0)
                    continue;

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];

                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;

            }
        }

        return dp[m - 1][n - 1];
    }

    // 63. Unique Paths II
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given an m x n integer array grid. There is a robot initially located
    // at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
    // bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
    // either down or right at any point in time.

    // An obstacle and space are marked as 1 or 0 respectively in grid. A path that
    // the robot takes cannot include any square that is an obstacle.

    // Return the number of possible unique paths that the robot can take to reach
    // the bottom-right corner.

    // The testcases are generated so that the answer will be less than or equal to
    // 2 * 109.

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return uniquePathsWithObstaclesTab(obstacleGrid, m, n);

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }

        // check dp
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // apply all stuffs on index
        int count = 0;
        count += uniquePathsWithObstacles(obstacleGrid, m - 1, n, dp);
        count += uniquePathsWithObstacles(obstacleGrid, m, n - 1, dp);

        return dp[m][n] = count;
    }

    public int uniquePathsWithObstaclesTab(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return uniquePathsWithObstaclesTab(obstacleGrid, m, n);

    }

    public static int uniquePathsWithObstaclesTab(int[][] obstacleGrid, int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    // apply all stuffs on index
                    int count = 0;
                    if (i > 0)
                        count += dp[i - 1][j];
                    if (j > 0)
                        count += dp[i][j - 1];

                    dp[i][j] = count;

                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 64. Minimum Path Sum
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given a m x n grid filled with non-negative numbers, find a path from top
    // left to bottom right, which minimizes the sum of all numbers along its path.

    // Note: You can only move either down or right at any point in time.
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return minPathSum(grid, m - 1, n - 1, dp);
    }

    public int minPathSum(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        // apply recursion and dp
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // apply recursion
        int up = minPathSum(grid, m, n - 1, dp);
        int left = minPathSum(grid, m - 1, n, dp);

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }

    public int minPathSumTab(int[][] grid, int m, int n, int[][] dp) {
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }
                int up = (int) 1e9;
                int left = (int) 1e9;
                if (j > 0)
                    up = dp[i][j - 1];
                if (i > 0)
                    left = dp[i - 1][j];

                dp[i][j] = grid[i][j] + Math.min(up, left);

            }
        }
        return dp[m - 1][n - 1];
    }

    // 120. Triangle
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given a triangle array, return the minimum path sum from top to bottom.

    // For each step, you may move to an adjacent number of the row below. More
    // formally, if you are on index i on the current row, you may move to either
    // index i or index i + 1 on the next row.

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = 0;
        int n = 0;
        int dpSize = triangle.size();
        int dp[][] = new int[dpSize][dpSize];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return minimumTotal(triangle, m, n, dp);

    }

    public int minimumTotal(List<List<Integer>> triangle, int m, int n, int dp[][]) {

        // base case here we can end at last row in the list just written the last item
        // value
        if (m == triangle.size() - 1) {
            return dp[m][n] = triangle.get(m).get(n);
        }

        // check for overallping subproblem already get solved
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // here now apply recursion to get the min value
        int down = minimumTotal(triangle, m + 1, n, dp);
        int downDaigonal = minimumTotal(triangle, m + 1, n + 1, dp);
        int curr = triangle.get(m).get(n);

        // store result in dp as well
        // while returning
        return dp[m][n] = curr + Math.min(down, downDaigonal);

    }

    public static void main(String[] args) {

        int[][] array = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };

        // System.out.println(ninjaTraining(array));
        System.out.println(uniquePaths(3, 7));

    }
}
