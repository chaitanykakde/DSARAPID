import java.util.*;

public class Dubstep208A {
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // String s = sc.next();
    // StringBuilder sb = new StringBuilder();
    // boolean flag = false;
    // for (int i = 0; i < s.length(); i++) {
    // if (sb.length() > 0 && flag == true && !s.startsWith("WUB", i)) {
    // sb.append(' ');
    // flag = false;
    // }

    // if (s.startsWith("WUB", i)) {
    // flag = true;
    // i = i + 2;
    // } else {
    // sb.append(s.charAt(i));
    // flag = false;
    // }

    // }
    // System.out.println(sb.toString());
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = s.replaceAll("(WUB)+", " ").trim();

        System.out.println(ans);
    }
}
