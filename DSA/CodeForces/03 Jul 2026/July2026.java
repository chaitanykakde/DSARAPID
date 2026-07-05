import java.math.BigInteger;
import java.util.*;

public class July2026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger n = new BigInteger(sc.next());
            boolean result = true;
            BigInteger a = n;
            BigInteger b = BigInteger.ZERO;
            BigInteger TWELVE = BigInteger.valueOf(12);

            while (a.compareTo(BigInteger.ZERO) >= 0) {
                if (isPalindrome(a) && b.mod(TWELVE).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println(a + " " + b);
                    result = false;
                    break;
                }
                a = a.subtract(TWELVE);
                b = b.add(TWELVE);
            }
            if (result) {
                System.out.println(-1);
            }
        }
    }

    public static boolean isPalindrome(BigInteger num) {
        String str = num.toString();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
