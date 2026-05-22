import java.util.*;

public class Team271A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = 0;
        while (t-- > 0) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();
            if ((f1 + f2 + f3) >= 2) {
                n++;
            }
        }
        System.out.println(n);

    }
}
