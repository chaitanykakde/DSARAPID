import java.util.*;

public class Suspension2158A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int players = sc.nextInt();
            int yellow = sc.nextInt();
            int red = sc.nextInt();

            // total players we can eliminate calcuate it
            int total = 0;
            if (red != 0) {
                total += red / 1;
            }
            if (yellow != 0) {
                total += yellow / 2;
            }
            // now check if players we are going to eliminate are exceeding the the no of
            // players N
            // if it then simplmy print the N
            // other wise print the total

            if (total > players) {
                System.out.println(players);
            } else {
                System.out.println(total);
            }
        }
    }
}
