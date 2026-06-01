import java.util.*;

public class BingoCandies2208 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n * n; i++) {
                int c = sc.nextInt();
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean result = true;
            for (int x : map.values()) {
                if (x > (n * (n - 1))) {
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
}
