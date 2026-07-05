import java.util.*;

public class ArraysQuestion {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean state = false;
        for (int x : nums) {
            if (map.containsKey(x)) {
                int freq = map.get(x);
                freq++;
                if (freq >= 2) {
                    state = true;
                    break;
                } else {
                    map.put(x, freq);
                }
            } else {
                map.put(x, 1);
            }
        }

        return state;

    }

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        s = new String(s1);
        t = new String(s2);
        return s.equals(t);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int x : map.keySet()) {
            pq.add(x);
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.peek();
            pq.poll();
        }
        return topK;
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append("#" + s.length() + s);

        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

        }
        return list;

    }

    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int ans[] = new int[nums.length];
        int count = 0;
        boolean zero = false;
        for (int x : nums) {
            if (x != 0) {
                sum *= x;
            } else {
                count++;
                zero = true;
            }
        }

        if (count > 1) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero == true) {
                if (nums[i] == 0) {
                    ans[i] = sum;
                } else {
                    ans[i] = 0;
                }
            } else {
                ans[i] = sum / nums[i];

            }
        }
        return ans;

    }

    public boolean checkInclusion(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        int len = s1.length();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            sb.append(s2.charAt(i));
            if (i - j + 1 == len) {
                String s = sb.toString();
                char[] subArr = s.toCharArray();
                Arrays.sort(subArr);
                set.add(new String(subArr));
                sb.deleteCharAt(0);
                j++;
            }
        }

        char[] subArr = s1.toCharArray();
        Arrays.sort(subArr);
        s1 = new String(subArr);
        if (set.contains(s1)) {
            return true;
        } else {
            return false;
        }

    }

    // 3 sum MEDIUM
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> setNum = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (setNum.contains(-(nums[i] + nums[j]))) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-(nums[i] + nums[j]));
                    Collections.sort(list);
                    if (!set.contains(list)) {
                        ans.add(list);
                        set.add(list);
                    }
                }
                setNum.add(nums[j]);
            }
        }
        return ans;
    }

    // 3 sum OPTIMAL
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return ans;
    }

    // 18. 4Sum
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given an array nums of n integers, return an array of all the unique
    // quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    // 0 <= a, b, c, d < n
    // a, b, c, and d are distinct.
    // nums[a] + nums[b] + nums[c] + nums[d] == target
    // You may return the answer in any order.

    // Example 1:

    // Input: nums = [1,0,-1,0,-2,2], target = 0
    // Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1;
                int k = n - 1;

                while (l < k) {

                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum > target) {
                        k--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.addAll(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                        ans.add(list);
                        l++;
                        k--;
                        while (l < k && nums[k] == nums[k + 1])
                            k--;
                        while (l < k && nums[l] == nums[l - 1])
                            l++;

                    }

                }

            }
        }

        return ans;
    }

    // 11. Container With Most Water
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given an integer array height of length n. There are n vertical lines
    // drawn such that the two endpoints of the ith line are (i, 0) and (i,
    // height[i]).

    // Find two lines that together with the x-axis form a container, such that the
    // container contains the most water.

    // Return the maximum amount of water a container can store.

    // Notice that you may not slant the container

    public static int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
            suffixMax[n - i - 1] = Math.max(suffixMax[n - i], height[n - i - 1]);
        }

        // System.out.println(Arrays.toString(prefixMax));
        // System.out.println(Arrays.toString(suffixMax));

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int minVal = Math.min(prefixMax[left], suffixMax[right]);
            int currWaterLimit = minVal * (right - left);
            max = Math.max(currWaterLimit, max);
            if (prefixMax[left] >= suffixMax[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;

    }

    public static int maxAreaOptimal(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;

        // System.out.println(Arrays.toString(prefixMax));
        // System.out.println(Arrays.toString(suffixMax));

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int minVal = Math.min(height[left], height[right]);
            int currWaterLimit = minVal * (right - left);
            max = Math.max(currWaterLimit, max);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;

    }

    // Given n non-negative integers representing an elevation map where the width
    // of each bar is 1, compute how much water it can trap after raining.

    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] > height[i] && suffix[i] > height[i]) {
                int water = Math.min(prefix[i], suffix[i]) - height[i];
                sum += water;
            }
        }
        return sum;
    }

    public int trapOptimal(int[] height) {
        int sum = 0;
        int n = height.length;
        int leftMax = 0, rightMax = 0, left = 0, right = n - 1;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    sum += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    sum += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }

        }

        return sum;
    }

    static class Pair {
        int i;
        int j;
        int len;

        public Pair(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }

    }

    public static boolean isValid(int[] tFreq, int[] sFreq) {
        int size = 128;
        for (int i = 0; i < size; i++) {
            if (sFreq[i] >= tFreq[i])
                continue;
            else
                return false;
        }
        // System.out.println("True Window");
        return true;
    }

    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int tLen = t.length();
        int size = 128;
        int[] tFreq = new int[size];
        int[] sFreq = new int[size];

        Pair p = new Pair(-1, -1, Integer.MAX_VALUE);

        // count frequencies of the first window of len t
        if (tLen > 0 && n >= tLen) {
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                tFreq[c]++;
            }

        } else {
            // return direclty if there is no need of process next beocsue t is null or 0
            return sb.toString();
        }

        // count the frequescies of the first size satisfying window from the s of len t
        for (int i = 0; i < tLen; i++) {
            char c = s.charAt(i);
            sFreq[c]++;
        }

        // now start the full iterations to conver the all windows
        int left = 0;
        int right = tLen - 1;
        while (right < n) {
            if (isValid(tFreq, sFreq)) {
                // if any winodw is valid then check for its length and compare with already
                // present len
                // find length
                int currLen = right - left + 1;

                if (currLen < p.len) {
                    p.len = currLen;
                    p.i = left;
                    p.j = right;

                }
                char currLeftchar = s.charAt(left);
                sFreq[currLeftchar]--;
                left++;

            } else {
                right++;
                if (right < n) {
                    char currRightchar = s.charAt(right);
                    sFreq[currRightchar]++;
                }

            }
        }

        // System.out.println(p.i+". "+p.j+". "+p.len);
        if (p.len > 0 && p.i != -1) {
            for (int i = p.i; i <= p.j; i++) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    // 239. Sliding Window Maximum
    // Hard
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given an array of integers nums, there is a sliding window of size k
    // which is moving from the very left of the array to the very right. You can
    // only see the k numbers in the window. Each time the sliding window moves
    // right by one position.

    // Return the max sliding window

    static class PairWindow {
        int val;
        int index;

        public PairWindow(int val, int index) {
            this.val = val;
            this.index = index;
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int noOfPossibleWindows = len - k + 1;
        int ans[] = new int[noOfPossibleWindows];
        int ansindex = 0;

        int left = 0;
        int right = 0;

        // create a max heap to have an max elelemt on a to O(1) read
        PriorityQueue<PairWindow> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.val - a.val;
        });
        while (right < len && ansindex<noOfPossibleWindows) {
            // complete the winodw if right is smaller to form an window
            while (right - left + 1 < k) {
                maxHeap.add(new PairWindow(nums[right], right));
                right++;
            }

            //check for any invalid elements can be at max position and remove them 
            while(maxHeap.peek().index<left){
                maxHeap.poll();
            }

            // now store the max element from the current window
            int max = maxHeap.peek().val;
            ans[ansindex] = max;
            ansindex++;
            //maxHeap.remove(nums[left]);
            left++;
        }

        return ans;

    }

    public static void main(String[] args) {

        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));

    }

}
