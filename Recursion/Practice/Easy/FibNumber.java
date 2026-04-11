// 509. Fibonacci Number
// Easy
// Topics
// premium lock icon
// Companies
// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

 

// Example 1:

// Input: n = 2
// Output: 1
// Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// Example 2:

// Input: n = 3
// Output: 2
// Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// Example 3:

// Input: n = 4
// Output: 3
// Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

// Constraints:

// 0 <= n <= 30

import java.util.*;
import java.math.*;

class FibNumber{
    public static void main(String args[]){
        int n=1000;
        BigInteger dp[]=new BigInteger[1001];
        System.out.println(fib(n,dp));
    }
    static BigInteger fib(int n,BigInteger[] dp){
        if(n==0){
            return BigInteger.ZERO;
        }
        if(n==1){
            return BigInteger.ONE;
        }
        //check if we already computed the value
        if(dp[n]!=null) return dp[n];
        
        //store the computed valvues for feture use
        //use add method becosue big Integer is of object type
        dp[n]= fib(n-1,dp).add(fib(n-2,dp));
        
        //retrun the fib number for n
        return dp[n];
    }
}