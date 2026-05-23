import java.util.*;

public class BeautifulYear271A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        while (!isBeatiful(++a))
            ;
        System.out.println(a);
    }

    private static boolean isBeatiful(int i) {
        String s = Integer.toString(i);
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

}
