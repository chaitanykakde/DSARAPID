import java.util.*;
class Main{
    public static void main(String[] args) {
        int[] a={4,3,3,43,434,343,54,545,45454,5454,3434,3434,545,2,1};
        selectionSort(a,a.length,0,0);
        System.out.println(Arrays.toString(a));
    }
    static void selectionSort(int a[],int r,int c,int s){
        if(r==0){
            return;
        }
        if(c<r){
            if(a[c]>=a[s]){
                selectionSort(a, r,c+1,c);
            }else{
                selectionSort(a, r,c+1,s);
            }
            
        }else{
            int temp=a[r-1];
            a[r-1]=a[s];
            a[s]=temp;

            selectionSort(a, r-1, 0, 0);
        }

    }
}