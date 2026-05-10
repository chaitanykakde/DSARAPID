import java.util.*;

class XOR{
    public static void main(String args[]){
        int[] nums={0,1,2,3};
        // findSingle(nums);
        // swapWithoutTemp(10,20);
        missingNum(nums);
    }

    static void findSingle(int[] nums){
        int num=0;
        for(int x:nums){
             num^=x;
        }
        System.out.println(num);
    }

    static void swapWithoutTemp(int a,int b){
        System.out.println("Before Swapping: a->"+a+"  b->"+b);
        a=a^b;
        b=a^b;
        a=a^b;
        
        System.out.println("After Swapping: a->"+a+"  b->"+b);

    }

    static void missingNum(int nums[]){
        int x=0;
        for(int i=0;i<=nums.length;i++){
              x^=i;
        }
        for(int g:nums){
            x^=g;
        }
        System.out.println("Missing:"+x);
    }
}