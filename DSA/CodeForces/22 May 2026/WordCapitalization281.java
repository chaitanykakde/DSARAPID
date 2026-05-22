import java.util.*;

public class WordCapitalization281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = s;
        if (s.charAt(0) >= 97) {
            // System.out.println((char) (s.charAt(0) - 32));
            ans = ((char) (s.charAt(0) - 32)) + s.substring(1);

        }
        System.out.println(ans);
    }

}
