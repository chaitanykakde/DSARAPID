import java.util.*;
class Main{
    public static void main(String[] args) {
        int [] a={4,3,2,1,43,3,43,34,43,34,3};
        bubbleSort(a,a.length-1,0);
        System.err.println(Arrays.toString(a));
    }
    static void bubbleSort(int arr[],int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubbleSort(arr, r, c+1);
        }else{
            bubbleSort(arr, r-1, 0);
        }
    }
}