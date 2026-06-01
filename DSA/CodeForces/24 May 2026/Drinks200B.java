import java.util.*;

public class Drinks200B {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double totalPercentage = 0;
        int n = sc.nextInt();
        int t = n;
        while (n-- > 0) {
            totalPercentage += sc.nextInt();
        }

        System.out.println(totalPercentage / t);
    }
}
