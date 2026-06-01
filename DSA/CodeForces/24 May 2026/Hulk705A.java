
import java.util.*;

public class Hulk705A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String hate = "I hate that ";
        String love = "I love that ";
        String hateLast = "I hate it";
        String loveLast = "I love it";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                sb.append((i % 2 == 0 ? loveLast : hateLast));
            } else {
                sb.append((i % 2 == 0 ? love : hate));
            }
        }
        System.out.println(sb.toString());
    }
}
