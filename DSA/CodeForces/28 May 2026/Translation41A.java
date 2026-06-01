import java.util.*;

public class Translation41A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = new StringBuilder(sc.next()).reverse().toString();
        // System.out.println("s" + s);
        // System.out.println("s1" + s1);
        if (s1.equals(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
