import java.util.*;

public class NearlyLuckyNumber110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean result = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == 7 || s.charAt(i) - '0' == 4) {
                count++;
            }
        }
        if (count == 4 || count == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
