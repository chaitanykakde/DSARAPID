// Write a recursive function for given n and a to determine x:
//       n = a ^ x 
//       a = 2, 3, 4
//       (2 ^ -31) <= n <= (2 ^ 31) - 1

import java.util.*;

class FindX{

    public static void main(String args[]){
           int n=10;
           int a=3;
           System.out.println(power(n,a,0));


    }
    static int power(int n,int a,int step){
        if(n<=0) return -1;
        if(n==1) return step;
        if(n%a!=0) return -1;
         return power(n/a,a,step+1);
    }

}