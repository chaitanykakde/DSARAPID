// Sum triangle from array
// Last Updated : 16 Nov, 2022
// Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level. 
// Example :
 

// Input : A = {1, 2, 3, 4, 5}
// Output : [48]
//          [20, 28] 
//          [8, 12, 16] 
//          [3, 5, 7, 9] 
//          [1, 2, 3, 4, 5] 

// Explanation :
// Here,   [48]
//         [20, 28] -->(20 + 28 = 48)
//         [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
//         [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
//         [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)

import java.util.*;

class SumTriangleArray{
    public static void main(String args[]){
        int[] nums={1,2,3,4,5};
        sumEasy(nums);
        // List<int[]> list=new ArrayList<>();
        // list.add(nums);
        // sum(list,nums.length-1);
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.println(Arrays.toString(list.get(i)));
        // }
    }
    static void sum(List<int[]> list,int len){
        if(len==0){
            return;
        }
       int nums[]=new int[len];
       for(int i=0;i<len;i++){
          nums[i]=list.get(list.size()-1)[i]+list.get(list.size()-1)[i+1];
       }
       list.add(nums);
       sum(list,len-1);
    }

    static void sumEasy(int[] nums){
        if(nums.length==0){
            return;
        }
        int[] temp=new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            temp[i]=nums[i]+nums[i+1];
        }

        sumEasy(temp);

        System.out.println(Arrays.toString(nums));
    }
}