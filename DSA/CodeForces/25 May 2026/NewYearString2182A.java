import java.util.*;

public class NewYearString2182A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean s1 = false;
            boolean s2 = false;

            // starting window
            int j = 4;
            for (int i = 0; i < n; i++) {
                if (j + i <= n && "2026".equals(s.substring(i, j + i))) {
                    s1 = true;
                    break;
                }
                if (j + i <= n && "2025".equals(s.substring(i, j + i))) {
                    s2 = true;
                }
            }

            if (s1) {
                System.out.println(0);
            } else if (s2) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }
}
