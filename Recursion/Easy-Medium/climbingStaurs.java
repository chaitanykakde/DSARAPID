import java.util.*;
class climbingStaurs{
    public static void main(String args[]){
        int n=44;
         int dp[]=new int[n+1];
          System.out.println(letsClimb(n,dp));
         
    }
    public static int  letsClimb(int n,int[] arr){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(n>0){
        if(arr[n]>0){
            return arr[n];
        }else{
         arr[n]+=letsClimb(n-1,arr);
         arr[n]+=letsClimb(n-2,arr);
      
        }
       
        }

        return arr[n];
        
    }
}