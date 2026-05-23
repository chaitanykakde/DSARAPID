import java.util.*;

public class BoyorGirlA236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // HashSet<Character> set = new HashSet<>();
        String s = sc.next();
        // for (int i = 0; i < s.length(); i++) {
        // set.add(s.charAt(i));
        // }

        // // if (set.size() % 2 == 0) {
        // // System.out.println("CHAT WITH HER!");
        // // } else {
        // // System.out.println("IGNORE HIM!");
        // // }

        // using bit count

        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            int bitPos = 'a' - (s.charAt(i) - '0');
            mask |= (1 << bitPos);

        }
        int count = Integer.bitCount(mask);
        if (count % 2 == 0) {
            System.out.println("CHAT WITH HER!");

        } else {
            System.out.println("IGNORE HIM!");

        }
    }
}
