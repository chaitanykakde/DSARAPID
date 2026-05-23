import java.util.*;

public class Word59A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int upp = 0, low = 0;
        for (char ch : in.toCharArray()) {
            if (ch >= 97) {
                low++;

            } else {
                upp++;
            }
        }
        if (low == upp) {
            System.out.println(in.toLowerCase());
        } else if (upp < low) {
            System.out.println(in.toLowerCase());
        } else {
            System.out.println(in.toUpperCase());
        }
    }
}
