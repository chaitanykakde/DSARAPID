
import java.util.*;

public class Cinema200A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int people = sc.nextInt();
        int[][] a = new int[n][m];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i <= people; i++) {
            int xW = sc.nextInt();
            int yW = sc.nextInt();

            if (itsAvailable(a, xW, yW)) {
                a[xW - 1][yW - 1] = i;
                ans.add(new int[] { xW, yW });
            } else {

                int ansMin[] = getMinManhattenRoomsOptimized(a, xW, yW, n, m);
                a[ansMin[0] - 1][ansMin[1] - 1] = i;
                ans.add(ansMin);

            }

        }
        // now display the list of rooms
        display(ans);
    }

    private static void display(List<int[]> ans) {
        for (int[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
    }

    private static int[] getMinManhattenRoomsOptimized(int[][] a, int xW, int yW, int n, int m) {
        int ans[] = new int[2];
        int d = 1;
        boolean result = false;
        while (!result) {
            // traverse all possiblities of the -dx to dx
            int start = -(d);
            for (int i = start; i <= d; i++) {

                // find dy using this formuala
                int dy = d - Math.abs(i);
                // check if dy is zero if it zero then onlyone pair can be genragted okay
                if (dy == 0) {
                    if (isValidated(a, xW, yW, i, dy, n, m)) {
                        ans[0] = xW + i;
                        ans[1] = yW + dy;
                        return ans;
                    }
                } else {
                    if (isValidated(a, xW, yW, i, -dy, n, m)) {
                        ans[0] = xW + i;
                        ans[1] = yW + (-dy);
                        return ans;
                    }
                    if (isValidated(a, xW, yW, i, dy, n, m)) {
                        ans[0] = xW + i;
                        ans[1] = yW + dy;
                        return ans;
                    }
                }
            }
            d++;
        }
        return ans;
    }

    
    private static boolean isValidated(int[][] a, int xW, int yW, int i, int dy, int n, int m) {
        if (xW + i - 1 >= 0 && xW + i - 1 < n && yW + dy - 1 >= 0 && yW + dy - 1 < m) {
            if (a[xW + i - 1][yW + dy - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean itsAvailable(int[][] a, int xW, int yW) {
        if (a[xW - 1][yW - 1] == 0) {
            return true;
        } else {
            return false;
        }
    }
}
