import java.util.*;

public class BearandBigBrother991A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chaitany = sc.nextInt();
        int micro = sc.nextInt();
        int year = 0;
        while (chaitany <= micro) {
            chaitany *= 3;
            micro *= 2;
            year++;
        }
        System.out.println(year);
    }
}
