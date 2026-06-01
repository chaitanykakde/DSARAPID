import java.util.*;

public class DivisiblePermutation2188A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            List<Integer> ans = new ArrayList<>();
            int n = sc.nextInt();
            int e = n;
            int s = 1;
            while (n > 0) {
                if (n > 0) {
                    ans.add(e);
                    e--;
                    n--;
                }
                if (n > 0) {
                    ans.add(s);
                    s++;
                    n--;
                }
            }
            Collections.reverse(ans);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
