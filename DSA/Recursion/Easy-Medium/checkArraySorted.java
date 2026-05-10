import java.util.*;
class Main{
    public static void main(String[] args) {
        int a[]={1,2,3,4,45};
        boolean status=checkSorted(a);
        System.err.println(status);
    }

    static boolean checkSorted(int[] a){
        return helper(a,0);
    }
    static boolean helper(int a[],int index){
        if(a.length-1==index){
            return true;
        }
        return (a[index]<=a[index+1] )&& helper(a, index+1);
    }
}