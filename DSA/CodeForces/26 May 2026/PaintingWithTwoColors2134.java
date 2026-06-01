import java.util.*;

public class PaintingWithTwoColors2134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            int b = sc.nextInt();

            if (n == r && r == b) {
                System.out.println("YES");
            } else {
                if (r > b) {
                    if (n % 2 == r % 2 && r % 2 == b % 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else if (b > r) {
                    if (n % 2 == b % 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    if (n % 2 == b % 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }

        }
    }
}   
