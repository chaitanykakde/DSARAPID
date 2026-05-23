import java.util.*;

public class QueueattheSchool266B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        while (t-- > 0) {
            for (int i = 0; i < n - 1; i++) {
                if (ch[i] == 'B' && ch[i + 1] == 'G') {
                    ch[i] = 'G';
                    ch[i + 1] = 'B';
                    i++;
                }
            }
        }
        System.out.println(ch);

    }

}
