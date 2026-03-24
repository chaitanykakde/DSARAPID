import java.util.*;
class Main{
    public static void main(String[] args) {
        
         int count=countZeroes(10000);
         System.err.println(count);
    }
    static int countZeroes(int n){
           return helper( n,0);
    }
    static  int helper(int n,int count){
        if(n==0){
            return count;
        }
        if(n%10==0){
            return helper(n/10, count+1);
        }
        return helper(n/10, count);
    }
}