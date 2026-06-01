import java.util.*;

public class PizzaTime2156A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int hao = 0;
            int m1 = 0;
            while (N > 0) {
                if (N <= 2) {
                    N = 0;
                } else if (N >= 3) {
                    m1 = N / 3;
                    hao += m1;
                    N = N - (m1 * 2);
                    m1 = 0;

                }
            }
            System.out.println(hao);
        }
    }
}
