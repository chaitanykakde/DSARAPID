import java.util.*;

public class NextRound158A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int arr[] = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : arr) {
            if (x > 0 && x >= arr[k - 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

}
