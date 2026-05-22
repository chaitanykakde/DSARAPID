import java.util.*;

public class Bit282A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0;
        while (t-- > 0) {
            String s = sc.next();
            if (s.charAt(0) == '+' || s.charAt(s.length() - 1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
    }
}
