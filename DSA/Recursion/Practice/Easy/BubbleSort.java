// Recursive Bubble Sort
// Last Updated : 26 Jul, 2025
// Background : 
// Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
// Example: 
// First Pass: 
// ( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1. 
// ( 1 5 4 2 8 ) --> ( 1 4 5 2 8 ), Swap since 5 > 4 
// ( 1 4 5 2 8 ) --> ( 1 4 2 5 8 ), Swap since 5 > 2 
// ( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
// Second Pass: 
// ( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ) 
// ( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
// Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
// Third Pass: 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 ) 
// ( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )


import java.util.*;
class BubbleSort{
    public static void main(String ar[]){
        int[] nums={5,4,3,2,1};
        goodBubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void bubblesort(int nums[],int len){
        if(len==1){
            return;

        }
        for(int i=0;i<len-1;i++){
            int count=0;
            if(nums[i]>nums[i+1]){
                nums[i]=nums[i]^nums[i+1];
                nums[i+1]=nums[i]^nums[i+1];
                nums[i]=nums[i]^nums[i+1];
                count++;
            }
            if(count==0){
                return;
            }
        }
        bubblesort(nums,len-1);
    }

    static void goodBubbleSort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
             sort(nums,i);
        }
    }
    static void sort(int[] nums,int i){
        if(i==0){
            return;
        }
        sort(nums,i-1);
        if(nums[i]<nums[i-1]){
              nums[i]=nums[i]^nums[i-1];
                nums[i-1]=nums[i]^nums[i-1];
                nums[i]=nums[i]^nums[i-1];
        }
    }
}