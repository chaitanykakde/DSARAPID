import java.util.*;

public class Combinatorics {
    static long power(long a, long n, long mod) {

        long ans = 1;

        while (n > 0) {

            if ((n & 1) == 1) {

                ans = (ans * a) % mod;
            }

            a = (a * a) % mod;

            n >>= 1;
        }

        return ans;
    }

    // modular inverse
    static long modInverse(long a, long mod) {

        return power(a, mod - 2, mod);
    }

    // mod divison
    static long divide(long a, long b, long mod) {

        return (a * modInverse(b, mod)) % mod;
    }

    static long nCr(long n, long r, long m) {
        long neno = factIterative(n, m);
        long deno = (factIterative(r, m) * factIterative(n - r, m)) % m;
        long denoInverse = modInverse(deno, m);
        long result = (neno * denoInverse) % m;
        return result;
    }

    static long fact(long n, long m) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return (n * fact(n - 1, m)) % m;
    }

    static long factIterative(long n, long m) {
        long ans = 1;
        if (n == 0 || n == 1) {
            return ans;
        }
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % m;
        }
        return ans;
    }

    // 2. PERMUTATION (nPr) 🔥

    // Formula:

    // nPr=n!/(n−r)!
    // INTUITION :Arrange:only r positions.
    static long nPr(long n, long r, long m) {
        long nFact = factIterative(n, m);
        long rFact = factIterative(n - r, m);
        long modInRFact = modInverse(rFact, m);
        return (nFact * modInRFact) % m;

    }

    // withotu creating full pascals traingle get the vlaue of spcific row and col
    static long pascalsValue(long n, long r, long m) {
        // the current vlaue means the r-1, c-1. th rCc. like nCr
        long neno = fact(n, m);
        long deno = (fact(r, m) * fact(n - r, m)) % m;
        long inverse = modInverse(deno, m);

        return (neno * inverse) % m;
    }

    // pascals traingle
    static int[][] pascalsTriangle(int n) {
        int[][] ans = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
                }
            }
        }
        return ans;
    }

    // 2. DIRECT PROGRAM 🔥

    // Suppose:

    // distribute 5 candies among 3 kids

    static long starsAndBars(long n, long k, long m) {

        // (n+k-1)C(k-1)

        return nCr(n + k - 1, k - 1, m);
    }

    // The number of positive integer solutions is 6, calculated as (5-1)C(3-1) =
    // 4C2 = 6. 🔥
    // in case whare every student must get at least 1 candy

    static long positiveSolutions(long n, long k, long m) {

        return nCr(n - 1, k - 1, m);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // 7. LCM USING GCD

    // Using famous relation:

    // LCM(a,b)= a×b/GCD(a,b)
    static long lcm(long a, long b) {

        return (a * b) / gcd(a, b);
    }

    static long count(long n, long a, long b) {

        long divisibleByA = n / a;

        long divisibleByB = n / b;

        long overlap = n / lcm(a, b);

        return divisibleByA
                + divisibleByB
                - overlap;
    }

    static long countThree(long n) {

        long a = n / 2;

        long b = n / 3;

        long c = n / 5;

        long ab = n / lcm(2, 3);

        long bc = n / lcm(3, 5);

        long ac = n / lcm(2, 5);

        long abc = n / lcm(2, lcm(3, 5));

        return a + b + c
                - ab - bc - ac
                + abc;
    }

    public static void main(String[] args) {
        long m = 1000000007;
        // binary exponatiation
        // System.out.println("Result:" + power(10, 5, m));
        // binary exponatiation iterative
        // System.out.println("Result:" + powerIterative(10, 5));
        // long mod = 5;

        // System.out.println(modInverse(2, mod));

        long mod = 5;

        // System.out.println(divide(3, 2, mod));
        // System.out.println("N!" + fact(5, m));
        // System.out.println("NCR:" + nCr(5, 2, m));
        // System.out.println("NPR" + nPr(5, 2, m));
        int[][] ans = pascalsTriangle(6);
        for (int[] x : ans) {
            System.out.println(Arrays.toString(x));
        }
        // get the specific value form the pascals traingle
        System.out.println(pascalsValue(5, 2, m));

        // ditribute the 5 cadies among th 3 students using the stars and bars concept
        // okay
        System.out.println("5 Candies among 3 students no of ways:" + starsAndBars(5, 3, m));
        System.out.println("5 Candies among 3 students no of ways:" + positiveSolutions(5, 3, m));
        System.out.println("Count of Numbers divisible by 2 & 3 from 1 to 10 :" + count(10, 2, 3));
        System.out.println("Count of Numbers divisible by 2 & 3 & 5 from 1 to 100 :" + countThree(30));

    }
}
