import java.util.*;

public class The67thPermutationProblem2218C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int highLimit = 3 * n;
            int lower = 1;
            int startOfLarge = n + 1;
            for (int i = lower; i <= n; i++) {
                sb.append(i + " ");
                sb.append(startOfLarge + " ");
                if (startOfLarge + 1 == highLimit) {
                    sb.append(startOfLarge + 1);
                } else {
                    sb.append((startOfLarge + 1) + " ");
                }

                startOfLarge += 2;
            }
            System.out.println(sb.toString());
        }
    }
}
