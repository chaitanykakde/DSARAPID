import java.util.*;

public class GeorgeandAccommodation467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        while (t-- > 0) {
            int pth = sc.nextInt();
            int qth = sc.nextInt();
            if (qth - pth >= 2) {
                count++;
            }

        }
        System.out.println(count);
    }
}
