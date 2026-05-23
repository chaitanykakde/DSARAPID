import java.util.*;

public class Tram116A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int passengers = 0;
        int max = 0;
        while (n-- > 0) {
            max = Math.max(passengers, max);
            passengers -= sc.nextInt();
            passengers += sc.nextInt();

        }
        System.out.println(max);
    }
}
