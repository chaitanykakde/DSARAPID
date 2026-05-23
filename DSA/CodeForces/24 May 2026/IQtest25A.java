import java.util.*;

public class IQtest25A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddC = 0;
        int evenC = 0;
        int oddIndex = -1;
        int evenIndex = -1;
        for (int i = 0; i < n; i++) {
            int nth = sc.nextInt();
            if (nth % 2 == 0) {
                evenC++;
                evenIndex = i + 1;
            } else {
                oddC++;
                oddIndex = i + 1;
            }
        }
        System.out.println((evenC == 1) ? evenIndex : oddIndex);
    }
}
