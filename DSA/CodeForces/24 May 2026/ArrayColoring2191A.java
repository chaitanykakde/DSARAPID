import java.util.*;

public class ArrayColoring2191A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Character> map = new HashMap<>();
            char c = 'R';
            boolean status = true;
            int arr[]=new int[n];
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();

                // now lets check for 2 cases if a is 1 or a is n
                // if a is 1 then we need to check for the next
                // if a is the n then we need to check for the prev
                if (a == 1) {
                    char next = map.getOrDefault(a + 1, (c == 'R') ? 'B' : 'R');
                    if (c != next) {
                        map.put(a, c);

                    } else {
                        status = false;
                        break;
                    }
                } else if (a == n) {
                    char prev = map.getOrDefault(a - 1, (c == 'R') ? 'B' : 'R');
                    if (c != prev) {
                        map.put(a, c);
                    } else {
                        status = false;
                        break;
                    }
                } else {
                    char next = map.getOrDefault(a + 1, (c == 'R') ? 'B' : 'R');
                    char prev = map.getOrDefault(a - 1, (c == 'R') ? 'B' : 'R');
                    if (c != prev && c != next) {
                        map.put(a, c);
                    } else {
                        status = false;
                        break;
                    }
                }

                c = (c == 'R') ? 'B' : 'R';

            }
            if (status) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}   
