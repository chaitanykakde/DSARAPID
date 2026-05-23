import java.util.*;

public class Dragons230A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        boolean result = true;
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            ans.add(new int[] { in, sc.nextInt() });
        }
        Collections.sort(ans, (a, b) -> {
            // primary sort by accending
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            // secondary sort
            return b[0] - a[0];

        });

        for (int arr[] : ans) {
            if (arr[0] < s) {
                s = s + arr[1];
            } else {
                result = false;
            }
        }
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
