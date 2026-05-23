import java.util.*;

public class VanyaandFence677 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int w = 0;
        while (n-- > 0) {
            int f = sc.nextInt();
            if (f > h) {
                w += 2;
            } else {
                w += 1;
            }
        }
        System.out.println(w);
    }
}
