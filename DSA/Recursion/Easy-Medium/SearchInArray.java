
import java.lang.reflect.Array;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        int a[]={1,2,4,4,5};
        // boolean status=searchElement(a,555);
        // System.err.println(status);
        
        ArrayList<Integer> list=searchElement(a, 4);
        System.err.print(list);
    }
    static ArrayList<Integer>  searchElement(int[] a,int target){
         ArrayList<Integer> list =new ArrayList<>();
        return helperList2(a,0,target);
    }
    static boolean  helper(int a[],int index,int target){
        if(a.length==index){
            return false;
        }
        // if(a[index]==target){
        //     return index;
        // }
        // return helper(a, index+1, target);

        return (a[index]==target) || helper(a, index+1, target);
    }

    static boolean  helperLast(int a[],int index,int target){
        if(a.length==-1){
            return false;
        }
        // if(a[index]==target){
        //     return index;
        // }
        // return helper(a, index+1, target);

        return (a[index]==target) || helper(a, index-1, target);
    }

    static  ArrayList<Integer> helperList(int a[],int index,int target,ArrayList<Integer> list){
        if(a.length==index){
            return list;
        }
        if(a[index]==target){
            list.add(index);
        }
        return helperList(a, index+1, target, list);
    }

     static  ArrayList<Integer> helperList2(int a[],int index,int target){
        ArrayList<Integer> list=new ArrayList<>();
        if(a.length==index){
            return list;
        }
        if(a[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelow=helperList2(a, index+1, target);
        list.addAll(ansFromBelow);
        return list;
    }
}