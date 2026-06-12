import java.util.*;

class NumberTheoryFull {

    // gcd of numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // 7. LCM USING GCD

    // Using famous relation:

    // LCM(a,b)= a×b/GCD(a,b)
    static int lcm(int a, int b) {

        return (a * b) / gcd(a, b);
    }

    // FIND GCD OF ARRAY
    // QUESTION

    // Given array:

    // [12,18,24]

    // Find:

    // GCD of complete array.
    // OUTPUT
    // 6
    // IMPORTANT OBSERVATION

    // GCD is:

    // associative.

    // Meaning:

    // GCD(a,b,c)=GCD(GCD(a,b),c)

    // SO WE CAN PROCESS SEQUENTIALLY

    public static int findArrayGCD(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = gcd(ans, nums[i]);
        }
        return ans;
    }

    // 1979. Find Greatest Common Divisor of Array
    public static int findGCD(int[] nums) {
        int small = nums[0];
        int larger = nums[0];
        for (int x : nums) {

            if (x < small) {
                small = x;
            }
            if (x > larger) {
                larger = x;
            }
        }
        return gcd(small, larger);
    }

    // REMOVE ONE ELEMENT TO MAXIMIZE GCD
    public static int maximizeGCD(int[] arr) {

        // build the prefix gcd
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = gcd(prefix[i - 1], arr[i]);
        }

        // build the suffix gcc
        int suffix[] = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], arr[i]);
        }
        int max = 0;
        int currentGCD = 0;
        // now try to reamving each num and see the max gcd maintaitn the max
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                currentGCD = suffix[i + 1];
            } else if (i == arr.length - 1) {
                currentGCD = prefix[i - 1];
            } else {
                currentGCD = gcd(prefix[i - 1], suffix[i + 1]);
            }
            max = Math.max(max, currentGCD);

        }
        return max;
    }

    // 5. HUGE PRIME OBSERVATION 🔥

    // Suppose:

    // n =36

    // Factors:

    // 1×36
    // 2×18
    // 3×12
    // 4×9
    // 6×6

    // Notice:

    // factors appear in PAIRS.
    // VERY IMPORTANT

    // After:

    // sqrt(n)

    // pairs repeat.

    // Example:

    // 2×18

    // already covers:

    // 18×2
    // HUGE CONCLUSION

    // To check divisibility:

    // only check till sqrt(n)

    // NOT till n.
    static boolean isPrime(int n) {

        if (n < 2) {

            return false;
        }

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }

    /*
     * NUMBER THEORY — PART 2
     * SIEVE OF ERATOSTHENES 🔥
     * 
     * This is:
     * 
     * one of the MOST IMPORTANT algorithms in CP.
     * 
     * Used EVERYWHERE:
     * 
     * prime generation
     * factorization
     * divisors
     * combinatorics
     * range queries
     * number theory
     * 
     * VERY VERY important.
     * 
     * PROBLEM
     * 
     * Suppose you want:
     * 
     * ALL primes from 1 → n
     * 
     * Example:
     * 
     * n =30
     * 
     * Output:
     * 
     * 2 3 5 7 11 13 17 19 23 29
     */
    static void primeFrom1TON(int n) {

        boolean[] prime = new boolean[n + 1];

        // initially assume all prime
        for (int i = 2; i <= n; i++) {

            prime[i] = true;
        }

        // sieve
        for (int i = 2; i * i <= n; i++) {

            // skip if already composite
            if (!prime[i]) {

                continue;
            }

            // mark multiples
            for (int j = i * i; j <= n; j += i) {

                prime[j] = false;
            }
        }

        // print primes
        for (int i = 2; i <= n; i++) {

            if (prime[i]) {

                System.out.print(i + " ");
            }
        }

    }

    // DIVISOR COUNT FORMULA
    public static int DivisorCount(int n) {
        int divcount = 1;
        for (int i = 2; i * i <= n; i++) {
            int power = 0;

            while (n % i == 0) {
                power++;
                n = n / i;
            }

            divcount *= (power + 1);
        }
        if (n > 1) {
            divcount *= 2;
        }
        return divcount;
    }

    public static ArrayList<Integer> smallestPrimeFractor(int n, int numFactorize) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] spf = new int[n + 1];
        // mark all as prime numbers first
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }
        // now mark the multiples of prime numbers to there eveyr respective position if
        // it divisble by that sallest number
        // do not mark agaign fro same number with bigger divisor it willl break the spf
        // logic
        for (int i = 2; i * i <= n; i++) {
            // if prime
            if (spf[i] == i) {
                // now mark by Ex: 2 to all its multiples till n
                for (int j = i * i; j <= n; j += i) {
                    // check if already marked or not
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        // prime factroize for given number numFractorize
        while (numFactorize != 1) {
            ans.add(spf[numFactorize]);
            numFactorize = numFactorize / spf[numFactorize];
        }

        return ans;

    }

    // sum of divisors of a number
    public static int sumOfDivisorsNormal(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            int power = 0;
            int contribution = 0;
            while (n % i == 0) {
                power++;
                n = n / i;
            }
            if (power > 0) {
                for (int j = 0; j <= power; j++) {
                    contribution += Math.pow(i, j);
                }
            }

            sum *= contribution;
        }

        // add contrubutiion of reamining prime number
        if (n > 1) {
            sum *= (n + 1);
        }

        return sum;
    }

    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    public static int sumOfDivisorsMathFormula(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            int power = 0;
            int contribution = 0;
            while (n % i == 0) {
                power++;
                n = n / i;
            }
            if (power > 0) {
                contribution += (Math.pow(i, power + 1) - 1) / (i - 1);
            }

            sum *= contribution;
        }

        // add contrubutiion of reamining prime number
        if (n > 1) {
            sum *= (n + 1);
        }

        return sum;
    }

    public static ArrayList<Integer> getSortedDivisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                if (i != n / i) {
                    ans.add(n / i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String args[]) {

        int arr[] = { 2, 5, 6, 9, 10 };

        // gcd
        // System.out.println(gcd(12, 18));
        // lcm
        // System.out.println(lcm(12, 18));
        // array gcd
        // System.out.println(findGCD(arr));
        // System.out.println("Prime Factors of the NO" + smallestPrimeFractor(100,
        // 99));
        // System.out.println("Divisor Count:" + DivisorCount(14));
        // System.out.println(sumOfDivisorsMathFormula(360));
        // System.out.println(getSortedDivisors(36));
        System.out.println(getGcd(30, 20));

    }

}