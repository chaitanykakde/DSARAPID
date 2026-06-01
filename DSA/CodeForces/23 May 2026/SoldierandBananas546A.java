import java.util.*;

public class SoldierandBananas546A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();
        int totalcost = 0;

        // Using summation formula:

        // 1+2+3+⋯+w=
        // 
        // K*w(w+1)/2. WE CAN APPLY TJIS FORMAUL ASWELL

        // ​

        for (int i = 1; i <= w; i++) {
            totalcost += k * i;
        }
        if (totalcost - n <= 0) {
            System.out.println(0);
        } else {
            System.out.println(totalcost - n);

        }

    }
}
