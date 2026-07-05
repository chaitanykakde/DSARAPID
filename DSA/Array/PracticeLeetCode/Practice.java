
import java.util.*;

public class Practice {

    // 347. Top K Frequent Elements
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given an integer array nums and an integer k, return the k most frequent
    // elements. You may return the answer in any order.

    // Example 1:

    // Input: nums = [1,1,1,2,2,3], k = 2

    // Output: [1,2]

    // Example 2:

    // Input: nums = [1], k = 1

    // Output: [1]

    // Example 3:

    // Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

    // Output: [1,2]

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;

    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int i = 0;
        int maxLen = 0;
        int len = 0;
        for (i = 0; i < s.length(); i++) {

            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
                len--;

            }
            maxLen = Math.max(maxLen, len);
            set.add(s.charAt(i));
            len++;

        }
        return maxLen;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        for (i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            int maxFreq = 0;
            int totalCount = 0;
            for (int x : map.values()) {
                maxFreq = Math.max(maxFreq, x);
                totalCount += x;
            }
            if (totalCount - maxFreq <= k) {
                maxLen = Math.max(maxLen, totalCount);
            } else {
                int freq = map.get(s.charAt(j));
                freq--;
                if (freq == 0) {
                    map.remove(s.charAt(j));
                } else {
                    map.put(s.charAt(j), freq);
                }
                j++;
            }
        }
        return maxLen;
    }

    public int subarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int cunt = 0;
        for (i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while(sum>k){
                sum-=nums[j];
                j++;
            }
            if(sum==k){
                cunt++;
            }
            
        }
        return cunt;
    }

    public static void main(String[] args) {

    }

}
