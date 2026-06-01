import java.util.*;

public class MixMexMax2127 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // boolean doesFLipped = false;
        while (t-- > 0) {
            // boolean allstatus = true;
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

            }
            boolean result = true;
            int val = -1;
            for (int x : arr) {
                if (x == -1) {
                    continue;
                }
                if (x == 0) {
                    result = false;
                    break;

                }
                if (val == -1) {
                    val = x;
                } else if (val != x) {
                    result = false;
                    break;
                }

            }
            // if (!allstatus && n > 0) {
            // for (int i = 0; i < n - 2; i++) {

            // if (arr[i] == -1 && arr[i + 1] == -1 && arr[i + 2] == -1) {
            // arr[i] = arr[i + 1] = arr[i + 2] = 1;
            // doesFLipped = true;
            // }
            // // find mex
            // int mex = findMex(arr[i], arr[i + 1], arr[i + 2]);

            // int max = findMax(arr[i], arr[i + 1], arr[i + 2]);

            // ArrayList<Integer> minAns = new ArrayList<>();
            // for (int j = i; j <= i + 2; j++) {
            // if (arr[j] != -1) {
            // minAns.add(arr[j]);
            // }
            // }

            // int min = findMin(minAns);

            // if (mex != max - min) {
            // result = false;
            // break;
            // }
            // if (doesFLipped) {
            // arr[i] = arr[i + 1] = arr[i + 2] = -1;
            // doesFLipped = falses;
            // }

            // }
            // }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // private static int findMax(int i, int j, int k) {
    // return Math.max(i, Math.max(j, k));
    // }

    // private static int findMin(ArrayList<Integer> minAns) {
    // if (minAns.size() == 1) {
    // return minAns.get(0);
    // } else if (minAns.size() == 2) {
    // return Math.min(minAns.get(0), minAns.get(1));
    // } else {
    // if (minAns.size() > 0) {
    // return Math.min(minAns.get(0), Math.min(minAns.get(1), minAns.get(2)));
    // } else {
    // return -1;
    // }

    // }
    // }

    // private static int findMex(int i, int j, int k) {
    // int mex = 0;
    // while (true) {
    // if (i != mex && j != mex && k != mex) {
    // return mex;
    // } else {
    // mex++;
    // }
    // }
    // }
}
