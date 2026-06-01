import java.util.*;

public class AbovetheClouds2121B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<Character, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            String s = sc.next();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean result = false;
            for (int x : map.values()) {
                if (x >= 2) {
                    result = true;
                    break;
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
