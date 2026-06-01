import java.util.*;

public class AlternatingSeries2131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if (i == n && n % 2 == 0) {
                    System.out.print(2 + " ");

                } else if (i % 2 == 0) {
                    System.out.print(3 + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
    }
}
