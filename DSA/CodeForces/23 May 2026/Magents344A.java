import java.util.*;

public class Magents344A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        t--;
        String prev = sc.next();
        int gCount = 1;
        while (t-- > 0) {
            String curr = sc.next();
            if (prev.charAt(1) == curr.charAt(0)) {
                gCount++;

            }
            prev = curr;
        }
        System.out.println(gCount);
    }
}
