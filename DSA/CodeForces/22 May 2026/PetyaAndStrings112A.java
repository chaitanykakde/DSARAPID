import java.util.*;

public class PetyaAndStrings112A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next().toLowerCase();
        String second = sc.next().toLowerCase();
        int result = 0;
        if (first.equals(second)) {
            System.out.println(result);
            return;
        }
        if (first.compareTo(second) < 0) {
            result = -1;
        } else {
            result = 1;
        }
        System.out.println(result);
    }
}
