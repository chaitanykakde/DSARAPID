import java.util.*;

public class Twins160A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int suffix[] = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = arr[i] + suffix[i + 1];
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum <= suffix[i]) {
                sum += arr[i];
                count++;
            }
        }
        System.out.println(count);

    }
}
