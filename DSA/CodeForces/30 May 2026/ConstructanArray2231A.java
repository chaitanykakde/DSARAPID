import java.util.*;

public class ConstructanArray2231A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i < n * 2; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}