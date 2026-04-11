// Recursive Insertion Sort
// Last Updated : 23 Jul, 2025
// Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
// Below is an iterative algorithm for insertion sort
// Algorithm 

// // Sort an arr[] of size n
// insertionSort(arr, n) 
//     Loop from i = 1 to n-1.
//        a) Pick element arr[i] and insert
//           it into sorted sequence arr[0..i-1] 


import java.util.*;
class InsertionSort{
    public static void main(String ar[]){
        int[] nums={5,3,4};
        trueInsertionSort(nums,nums.length);
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

    static void goodInsertionSort(int[] nums){
        for(int i=1;i<nums.length;i++){
             sort(nums,i);
        }
    }
    static void sort(int[] nums,int i){
        if(i==0){
            return;
        }
      
        if(nums[i]<nums[i-1]){
              nums[i]=nums[i]^nums[i-1];
                nums[i-1]=nums[i]^nums[i-1];
                nums[i]=nums[i]^nums[i-1];
        }else{
            return;
        }
          System.out.println(Arrays.toString(nums));
          sort(nums,i-1);
    }

    static void trueInsertionSort(int nums[],int len){
        if(len<=1){
            return;
        }
        trueInsertionSort(nums,len-1);
        int j=len-2;
        int last=nums[j+1];
        
        while(j>=0 && last < nums[j]){
            nums[j+1]=nums[j];
            j--;
        }
        nums[j+1]=last;
    }
}