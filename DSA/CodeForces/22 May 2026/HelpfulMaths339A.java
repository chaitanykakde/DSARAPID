import java.util.*;

public class HelpfulMaths339A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[s.length() - (s.length() / 2)];
        int j = 0;
        for (int i = 0; i < s.length(); i += 2) {
            arr[j] = s.charAt(i) - '0';
            j++;
        }
        Arrays.sort(arr);
        // String ans = "";
        // for (int i = 0; i < arr.length; i++) {
        // ans += arr[i];
        // if (arr.length > 1 && i != arr.length - 1) {
        // ans += '+';
        // }
        // }
        // System.out.println(ans);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            ans.append(arr[i]);

            if (i != arr.length - 1) {
                ans.append("+");
            }
        }
        System.out.println(ans);

    }

}
