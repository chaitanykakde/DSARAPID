import java.util.*;
import javax.swing.text.Position;
class Main{
    public static void main(String[] args) {
        int arr[]={4,5,6,1,2,3};
        int key=RBS(arr,55);
        System.err.println(key);
    }

    static int RBS(int[] arr,int target){
        int e=arr.length-1;
        int s=0;
        return binarySearch(arr,target,s,e);
    }

    static int binarySearch(int[] a,int target,int start,int end){
        if(start>=end) return -1;
        int mid=start+(end-start)/2;
        if(a[mid]==target) return mid;
        if(a[start]<=a[mid]){
        if(target>=a[start]&& target < a[mid]){
               return binarySearch(a, target, start, mid-1);
        }else{
            return binarySearch(a, target, mid+1, end);
        }
        }
        if(target >= a[mid] && target <=a[end]){
            return binarySearch(a, target, mid+1, end);            
        }
         return binarySearch(a, target, start, mid-1);
    }
}