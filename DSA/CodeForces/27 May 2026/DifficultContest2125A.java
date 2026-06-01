import java.util.*;

public class DifficultContest2125A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char[] ch = s.toCharArray();
            int j = 0;
            for (int i = 1; i < ch.length; i++) {
                while (j < ch.length && ch[j] == 'T') {
                    j++;
                }
                if (ch[i] == 'T' && j < ch.length && j < i) {
                    ch[i] = ch[j];
                    ch[j] = 'T';
                }
            }
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
