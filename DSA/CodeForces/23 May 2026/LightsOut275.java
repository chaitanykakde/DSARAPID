import java.util.*;

public class LightsOut275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int[][] orignal = new int[n][n];
        for (int arr[] : orignal) {
            Arrays.fill(arr, 1);
        }

        int[][] flips = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flips[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flips[i][j] % 2 != 0) {
                    flipTheBits(orignal, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(orignal[i][j]);
            }
            System.out.println();
        }

    }

    private static void flipTheBits(int[][] orignal, int i, int j) {
        // flip the current position
        orignal[i][j] = Math.abs(orignal[i][j] - 1);
        // flip for upper side
        if (i - 1 >= 0) {
            orignal[i - 1][j] = Math.abs(orignal[i - 1][j] - 1);
        }
        // flip the lower side
        if (i + 1 < 3) {
            orignal[i + 1][j] = Math.abs(orignal[i + 1][j] - 1);
        }
        // flit the left side
        if (j - 1 >= 0) {
            orignal[i][j - 1] = Math.abs(orignal[i][j - 1] - 1);
        }
        // flip the right side
        if (j + 1 < 3) {
            orignal[i][j + 1] = Math.abs(orignal[i][j + 1] - 1);
        }
    }
}
