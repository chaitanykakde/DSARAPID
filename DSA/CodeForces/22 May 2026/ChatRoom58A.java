import java.util.*;

public class ChatRoom58A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char arr[] = { 'h', 'e', 'l', 'l', 'o' };
        int j = 0;
        for (char c : s.toCharArray()) {
            if (j < 5 && arr[j] == c) {
                j++;

            }
        }
        System.out.println((j == 5) ? "YES" : "NO");
    }
}
