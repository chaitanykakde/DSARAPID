import java.util.*;

public class Football96A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 1;
        boolean dangerous = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                if (count >= 7) {
                    dangerous = true;
                    break;
                }

            } else {
                count = 1;
            }
        }
        if (dangerous) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
