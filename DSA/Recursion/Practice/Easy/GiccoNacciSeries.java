// Geek created a random series and given a name geek-onacci series. Given four integers A, B, C, N. A, B, C represents the first three numbers of geek-onacci series. Find the Nth number of the series. The nth number of geek-onacci series is a sum of the last th
// ree numbers (summation of N-1th, N-2th, and N-3th geek-onacci numbers)

// Input:
// 1. The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
// 2. The first line of each test case contains four space-separated integers A, B, C, and N.

// Output: For each test case, print Nth geek-onacci number

// Constraints:
// 1. 1 <= T <= 3
// 2. 1 <= A, B, C <= 100
// 3. 4 <= N <= 10

// Example:
// Input:
// 3
// 1 3 2 4
// 1 3 2 5
// 1 3 2 6

// Output:
// 6
// 11
// 19

import java.util.*;

class GiccoNacciSeries{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int n=sc.nextInt();
            int fib=0;

            for(int i=4;i<=n;i++){
                fib=a+b+c;
                a=b;
                b=c;
                c=fib;
                
            }
            System.out.println(fib);
            

        }
    }
}