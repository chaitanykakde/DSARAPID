import java.util.*;

public class LeetCode632 {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = new int[] { -1, -1 };
        int bestRange = Integer.MAX_VALUE;
        int[] ptr = new int[nums.size()];
        int k = nums.size();
        boolean isEmpty = false;
        // nwo start iterating on the till the any of the q finishes
        while (!isEmpty) {
            // now find the min and max from current stack elements
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                // we can nwo access the first element form each array
                if (nums.get(j).size() - 1 >= ptr[j]) {
                    min = Math.min(min, nums.get(j).get(ptr[j]));
                    max = Math.max(max, nums.get(j).get(ptr[j]));
                } else {
                    isEmpty = true;
                    break;
                }

            }
            if (isEmpty) {
                break;
            }

            // now we have the min and max elements form the all K queues
            if (bestRange > max - min) {
                ans[0] = min;
                ans[1] = max;
                bestRange = max - min;
            }
            // now answe rupdated now agagin remove the smalles elelmetn form the queue
            // make sure to remove only one smallest eleemtn many array can caintian it
            for (int j = 0; j < k; j++) {
                // we can nwo access the first element form each array

                if (nums.get(j).get(ptr[j]) == min) {
                    ptr[j]++;
                    break;
                }

            }
            // now agaign make the max and min ready for inext iteration
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        // disaply the answers
        return ans;
    }
}
