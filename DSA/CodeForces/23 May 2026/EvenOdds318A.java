import java.util.*;

public class EvenOdds318A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long ans = 0;
        long limit;
        if (n % 2 == 0) {
            limit = n / 2;
        } else {
            limit = n / 2 + 1;
        }
        if (k <= limit) {
            ans = k + k - 1;
        } else if (k > limit) {

            if ((k - (n - k)) % 2 == 0) {
                ans = k - (n - k);
            } else {
                ans = k - (n + 1 - k);
            }

        }
        System.out.println(ans);
    }
}
