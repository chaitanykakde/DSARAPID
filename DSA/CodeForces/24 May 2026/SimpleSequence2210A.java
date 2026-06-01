import java.util.*;

public class SimpleSequence2210A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = n; i >= 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
