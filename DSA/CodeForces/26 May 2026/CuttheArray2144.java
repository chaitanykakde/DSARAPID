import java.util.*;

public class CuttheArray2144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            arr[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + sc.nextInt();
            }
            boolean result = false;
            for (int i = 1; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int s1 = arr[i - 1];
                    int s2 = arr[j - 1] - s1;
                    int s3 = arr[n - 1] - s2 - s1;

                    if (s1 % 3 == s2 % 3 && s2 % 3 == s3 % 3 && s3 % 3 == s1 % 3) {
                        result = true;
                        System.out.println(i + " " + j);
                        break;
                    } else if (s1 % 3 != s2 % 3 && s2 % 3 != s3 % 3 && s3 % 3 != s1 % 3) {
                        result = true;
                        System.out.println(i + " " + j);
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
            if (!result) {
                System.out.println(0 + " " + 0);
            }

        }
    }
}
