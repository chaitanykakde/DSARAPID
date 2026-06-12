import java.util.*;

public class SmellestRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<Queue<Integer>> list = new ArrayList<>();
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {

            int n = sc.nextInt();
            minSize = Math.min(n, minSize);
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                q.add(sc.nextInt());
            }
            list.add(q);
        }

        // now we have the all the aarray in the queues and jsut need to maintain the
        // answer
        int[] ans = new int[] { -1, -1 };

        boolean isEmpty = false;
        // nwo start iterating on the till the any of the q finishes
        while (!isEmpty) {
            // now find the min and max from current stack elements
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                // we can nwo access the first element form each array
                if (!list.get(j).isEmpty()) {
                    min = Math.min(min, list.get(j).peek());
                    max = Math.max(max, list.get(j).peek());
                } else {
                    isEmpty = true;
                    break;
                }

            }
            if (isEmpty) {
                break;
            }

            // now we have the min and max elements form the all K queues
            if (ans[0] == -1 || ans[1] - ans[0] > max - min) {
                ans[0] = min;
                ans[1] = max;
            }
            // now answe rupdated now agagin remove the smalles elelmetn form the queue
            // make sure to remove only one smallest eleemtn many array can caintian it
            for (int j = 0; j < k; j++) {
                // we can nwo access the first element form each array

                if (list.get(j).peek() == min) {
                    list.get(j).poll();
                    break;
                }

            }
            // now agaign make the max and min ready for inext iteration
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        // disaply the answers
        System.out.println(Arrays.toString(ans));

    }
}
