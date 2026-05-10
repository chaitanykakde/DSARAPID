import java.util.*;

class BinarySearch{
    public static void main(String args[]){
        int arr[]={1,2,3,4,45,5,5};
        System.out.println(search(arr,333));
    }
    static int search(int arr[],int target){
        return binarySearch(arr,target,0,arr.length-1);
    }
    static int binarySearch(int arr[],int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(target==arr[mid]){
            return mid;
        }
        if(target>arr[mid]){
            return binarySearch(arr,target,mid+1,end);
        }else{
            return binarySearch(arr,target,start,mid-1);
        }
        
    }
}