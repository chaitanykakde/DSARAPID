
class ModuloArithMaticFUll {

    // Binary exponentiation using recursion
    public static long power1(long a, long n, long m) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return power1((a * a) % m, n / 2, m);
        }
        return a * power1((a * a) % m, (n - 1) / 2, m);
    }

    // binary exponantiation using iterative
    public static long powerIterative(long a, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    // Fermat’s Little Theorem for finding the inverse
    // modular inverse
    // binary exponentiation
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
        System.out.println("N!" + fact(5, m));
        System.out.println("NCR:" + nCr(5, 2, m));
        System.out.println("NPR" + nPr(5, 2, m));

    }

}