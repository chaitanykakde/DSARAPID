// Minimum and Maximum elements Using Recursion
// Last Updated : 24 Sep, 2025
// Given an array of integers arr[], find the minimum and maximum elements in the array using recursion only. The first element of the output represents the minimum value, and the second element represents the maximum value in the array.

// Examples:

// Input: arr[] = [1, 4, 3, -5, -4, 8, 6]
// Output: [-5, 8]
// Explanation: -5 is the minimum and 8 is the maximum element in the array

// Input: arr[] = [12, 3, 15, 7, 9]
// Output: [3, 15]
// Explanation: 3 is the minimum and 15 is the maximum element in the array

import java.util.*;

class MaxMinArray{
    public static void main(String args[]){
        int nums[]={1, 4, 3, -5, -4, 8, 6};
        List<Integer> ans=new ArrayList<>();
        ans=findMinMax(nums,nums.length-1);
        System.out.println(ans);
    }

    static void minmax(int nums[],int[] ans,int step){
        if(step==nums.length){
            System.out.println(Arrays.toString(ans));
            return;
        }
          if(nums[step]<ans[0]){
            ans[0]=nums[step];
          }
          if(nums[step]>ans[1]){
            ans[1]=nums[step];
          }
          minmax(nums,ans,step+1);
    }

    static List<Integer> findMinMax(int[] arr,int index){
        if(index==0){
         List<Integer> list=new ArrayList<>();
         list.add(arr[0]);
         list.add(arr[0]);
         return list;
        }
        //for the index grator than zero
        List<Integer> result=findMinMax(arr,index-1);
        
        // does lower min max is also max and min with current index or not
        //check min
        if(arr[index]<result.get(0)) result.set(0,arr[index]);
        //check max
        if(arr[index]>result.get(1)) result.set(1,arr[index]);

       return result;
    }
}