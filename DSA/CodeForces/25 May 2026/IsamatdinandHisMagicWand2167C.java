import java.util.*;

public class IsamatdinandHisMagicWand2167C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            boolean odd = false;
            boolean even = false;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] % 2 == 0) {
                    even = true;
                } else {
                    odd = true;
                }
            }

            if (even == odd) {
                Arrays.sort(arr);
            }

            // for (int i = 0; i < n - 1; i++) {
            // for (int j = i + 1; j < n; j++) {
            // if (arr[i] % 2 != arr[j] % 2 && arr[i] > arr[j]) {
            // swap(arr, i, j);
            // } else if (arr[i] > arr[j] && isNotLexalogical(arr, i, j)) {
            // swap(arr, i, j);
            // }
            // }
            // }

            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isNotLexalogical(int[] arr, int i, int j) {

        String num1 = Integer.toString(arr[i]);
        String num2 = Integer.toString(arr[j]);

        int index = 0;

        while (index < num1.length() && index < num2.length()) {

            if (num1.charAt(index) > num2.charAt(index)) {
                return true;
            }

            if (num1.charAt(index) < num2.charAt(index)) {
                return false;
            }

            index++;
        }

        return num1.length() > num2.length();
    }

    public static void sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && isNotLexalogical(arr, i, j)) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
