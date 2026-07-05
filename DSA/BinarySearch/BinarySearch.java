
public class BinarySearch {

    // Given an array of integers nums which is sorted in ascending order, and an
    // integer target, write a function to search target in nums. If target exists,
    // then return its index. Otherwise, return -1.

    // You must write an algorithm with O(log n) runtime complexity.

    // Example 1:

    // Input: nums = [-1,0,3,5,9,12], target = 9
    // Output: 4
    // Explanation: 9 exists in nums and its index is 4
    // Example 2:

    // Input: nums = [-1,0,3,5,9,12], target = 2
    // Output: -1
    // Explanation: 2 does not exist in nums so return -1
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Given a sorted array arr[] (following 0-based indexing) and a number target,
    // find the lower bound of the target in this given array. The lower bound of a
    // number is defined as the smallest index in the sorted array where the element
    // is greater than or equal to the given number.

    // Note: If all the elements in the given array are smaller than the target, the
    // lower bound will be the length of the array.

    int lowerBound(int[] arr, int target) {
        // code here
        int lowerBound = arr.length;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                lowerBound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBound;

    }

    // Given a sorted array arr[] and a number target, the task is to find the upper
    // bound of the target in this given array.
    // The upper bound of a number is defined as the smallest index in the sorted
    // array where the element is greater than the given number.

    // Note: If all the elements in the given array are smaller than or equal to the
    // target, the upper bound will be the length of the array.

    // Examples :

    // Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
    // Output: 3
    // Explanation: 3 is the smallest index in arr[], at which element (arr[3] = 10)
    // is larger than 9.
    int upperBound(int[] arr, int target) {
        // code here
        int upperBound = arr.length;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                upperBound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return upperBound;

    }

    // Code
    // Test Result
    // Testcase
    // 35. Search Insert Position
    // Solved
    // Easy
    // Topics
    // premium lock icon
    // Companies
    // Given a sorted array of distinct integers and a target value, return the
    // index if the target is found. If not, return the index where it would be if
    // it were inserted in order.

    // You must write an algorithm with O(log n) runtime complexity.

    public int searchInsert(int[] arr, int target) {

        int lowerBound = arr.length;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                lowerBound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBound;
    }

    // Given a sorted array arr[] and an integer x, find the index (0-based) of the
    // largest element in arr[] that is less than or equal to x. This element is
    // called the floor of x. If such an element does not exist, return -1.

    // Note: In case of multiple occurrences of floor of x, return the index of the
    // last occurrence.

    // Examples

    // Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
    // Output: 1
    // Explanation: Largest number less than or equal to 5 is 2, whose index is 1.
    public int findFloor(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;

    }

    // Ceil in a Sorted Array
    // Difficulty: EasyAccuracy: 50.13%Submissions: 52K+Points: 2
    // Given a sorted array arr[] and an integer x, find the index (0-based) of the
    // smallest element in arr[] that is greater than or equal to x. This element is
    // called the ceil of x. If such an element does not exist, return -1.

    // Note: In case of multiple occurrences of ceil of x, return the index of the
    // first occurrence.

    // Examples

    // Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
    // Output: 2
    // Explanation: Smallest number greater than 5 is 8, whose index is 2.

    public int findCeil(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (start < arr.length) ? start : -1;
    }

    // 34. Find First and Last Position of Element in Sorted Array
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given an array of integers nums sorted in non-decreasing order, find the
    // starting and ending position of a given target value.

    // If target is not found in the array, return [-1, -1].

    // You must write an algorithm with O(log n) runtime complexity.

    // Example 1:

    // Input: nums = [5,7,7,8,8,10], target = 8
    // Output: [3,4]
    public int[] searchRange(int[] nums, int target) {
        int first = bsFirst(nums, target);
        int last = bsLast(nums, target);
        return new int[] { first, last };
    }

    public int bsFirst(int[] nums, int target) {
        int firstOcc = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                firstOcc = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstOcc;
    }

    public int bsLast(int[] nums, int target) {
        int lastOcc = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                lastOcc = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastOcc;
    }

    // Number of occurrence
    // Difficulty: EasyAccuracy: 59.34%Submissions: 409K+Points: 2Average Time: 20m
    // Given a sorted array, arr[] and a number target, you need to find the number
    // of occurrences of target in arr[].

    // Examples :

    // Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
    // Output: 4
    // Explanation: target = 2 occurs 4 times in the given array so the output is 4.
    int countFreq(int[] arr, int target) {
        // code here
        int[] ans = searchRange(arr, target);
        int ansf = ans[1] - ans[0] + 1;
        if (ans[0] == -1) {
            return 0;
        }
        return ansf;
    }
    // 33. Search in Rotated Sorted Array
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // There is an integer array nums sorted in ascending order (with distinct
    // values).

    // Prior to being passed to your function, nums is possibly left rotated at an
    // unknown index k (1 <= k < nums.length) such that the resulting array is
    // [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
    // (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
    // and become [4,5,6,7,0,1,2].

    // Given the array nums after the possible rotation and an integer target,
    // return the index of target if it is in nums, or -1 if it is not in nums.

    // You must write an algorithm with O(log n) runtime complexity.

    public int searchR(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // 81. Search in Rotated Sorted Array II
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // There is an integer array nums sorted in non-decreasing order (not
    // necessarily with distinct values).

    // Before being passed to your function, nums is rotated at an unknown pivot
    // index k (0 <= k < nums.length) such that the resulting array is [nums[k],
    // nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
    // example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become
    // [4,5,6,6,7,0,1,2,4,4].

    // Given the array nums after the rotation and an integer target, return true if
    // target is in nums, or false if it is not in nums.

    // You must decrease the overall operation steps as much as possible.

    // Example 1:

    // Input: nums = [2,5,6,0,0,1,2], target = 0
    // Output: true
    public boolean searchR2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // 153. Find Minimum in Rotated Sorted Array
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // Suppose an array of length n sorted in ascending order is rotated between 1
    // and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    // [4,5,6,7,0,1,2] if it was rotated 4 times.
    // [0,1,2,4,5,6,7] if it was rotated 7 times.
    // Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
    // in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    // Given the sorted rotated array nums of unique elements, return the minimum
    // element of this array.

    // You must write an algorithm that runs in O(log n) time.

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }
        }
        return min;
    }

    // Find Kth Rotation
    // Difficulty: EasyAccuracy: 23.16%Submissions: 364K+Points: 2Average Time: 20m
    // Given an increasing sorted rotated array arr[] of distinct integers. The
    // array is right-rotated k times. Find the value of k.
    // Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2
    // times it will look like this:
    // After 1st Rotation : [9, 2, 4, 6]
    // After 2nd Rotation : [6, 9, 2, 4]

    // Examples:

    // Input: arr[] = [5, 1, 2, 3, 4]
    // Output: 1
    // Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is
    // [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
    // Input: arr = [1, 2, 3, 4, 5]
    // Output: 0
    // Explanation: The given array is not rotated.
    public int findKRotation(int nums[]) {
        // Code here
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                if (min > nums[start]) {
                    min = nums[start];
                    minInd = start;
                }
                start = mid + 1;
            } else {
                if (min > nums[mid]) {
                    min = nums[mid];
                    minInd = mid;
                }
                end = mid - 1;
            }
        }
        return minInd;

    }

    // 540. Single Element in a Sorted Array
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // You are given a sorted array consisting of only integers where every element
    // appears exactly twice, except for one element which appears exactly once.

    // Return the single element that appears only once.

    // Your solution must run in O(log n) time and O(1) space.

    // Example 1:

    // Input: nums = [1,1,2,3,3,4,4,8,8]
    // Output: 2
    // Example 2:

    // Input: nums = [3,3,7,7,10,11,11]
    // Output: 10
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid - 1 >= 0 && nums[mid] == nums[mid - 1]) || (mid + 1 < nums.length && nums[mid] == nums[mid + 1])) {
                int operationIndex = (mid - 1 > 0 && nums[mid] == nums[mid - 1]) ? mid : -1;
                if (operationIndex == -1) {
                    operationIndex = mid + 1;
                }
                if (operationIndex % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }

    // 162. Find Peak Element
    // Solved
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // A peak element is an element that is strictly greater than its neighbors.

    // Given a 0-indexed integer array nums, find a peak element, and return its
    // index. If the array contains multiple peaks, return the index to any of the
    // peaks.

    // You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
    // always considered to be strictly greater than a neighbor that is outside the
    // array.

    // You must write an algorithm that runs in O(log n) time.

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] > nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] > nums[n - 2]) {
            return nums[n - 1];
        }

        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
