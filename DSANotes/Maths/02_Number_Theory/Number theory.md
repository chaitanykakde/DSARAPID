
========================================
NUMBER THEORY NOTES — PART 1 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. What is Number Theory?
2. GCD (Greatest Common Divisor)
3. Euclidean Algorithm
4. LCM using GCD
5. GCD of Array
6. Remove One Element to Maximize GCD
7. Prime Numbers
8. Prime Checking Optimization
9. Sieve of Eratosthenes

========================================
1. WHAT IS NUMBER THEORY?
========================================

Number Theory is:
# mathematics related to integers

Used heavily in:
- CP
- cryptography
- modular arithmetic
- combinatorics
- hashing
- optimization

VERY important branch of CP math.

========================================
2. GCD (GREATEST COMMON DIVISOR)
========================================

GCD means:
# largest number dividing both numbers

----------------------------------------
EXAMPLE
----------------------------------------

12 factors:
1 2 3 4 6 12

18 factors:
1 2 3 6 9 18

Common:
1 2 3 6

Largest:
6

So:

GCD(12,18)=6

========================================
3. EUCLIDEAN ALGORITHM
========================================

CODE:

public static int gcd(int a, int b) {

    if (b == 0) {
        return a;
    }

    return gcd(b, a % b);
}

========================================
MOST IMPORTANT INTUITION
========================================

BIGGEST observation:

GCD(a,b)
=
GCD(b,a%b)

VERY important theorem.

----------------------------------------
WHY?
----------------------------------------

Suppose:

a = 18
b = 12

18 = 12×1 + 6

Now:

Any common divisor of:
18 and 12

must also divide:
6

Because:

18 - 12 = 6

So:

GCD(18,12)
=
GCD(12,6)

----------------------------------------
CONTINUE
----------------------------------------

GCD(12,6)

12 % 6 = 0

So:

GCD(6,0)=6

DONE.

========================================
IMPORTANT OBSERVATION
========================================

Each step:
# reduces problem size

That is why Euclidean Algorithm is:
VERY fast.

Time Complexity:

O(log(min(a,b)))

========================================
4. LCM USING GCD
========================================

CODE:

static int lcm(int a, int b) {

    return (a * b) / gcd(a, b);
}

========================================
FORMULA
========================================

LCM(a,b) × GCD(a,b)
=
a × b

VERY important relation.

----------------------------------------
WHY THIS WORKS
----------------------------------------

Suppose:

a = 12
b = 18

Prime factors:

12 = 2² × 3

18 = 2 × 3²

----------------------------------------
GCD TAKES:
----------------------------------------

minimum powers

=
2 × 3

=
6

----------------------------------------
LCM TAKES:
----------------------------------------

maximum powers

=
2² × 3²

=
36

----------------------------------------
NOW:
----------------------------------------

6 × 36
=
216

12 × 18
=
216

Correct.

========================================
5. GCD OF ARRAY
========================================

CODE:

public static int findArrayGCD(int[] nums) {

    int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {

        ans = gcd(ans, nums[i]);
    }

    return ans;
}

========================================
CORE INTUITION
========================================

GCD is:
# associative

Meaning:

GCD(a,b,c)
=
GCD(GCD(a,b),c)

So process sequentially.

----------------------------------------
EXAMPLE
----------------------------------------

[12,18,24]

STEP 1

GCD(12,18)=6

STEP 2

GCD(6,24)=6

DONE.

========================================
6. FIND GCD OF MIN/MAX ONLY
========================================

LEETCODE 1979

CODE:

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

========================================
IMPORTANT OBSERVATION
========================================

Problem specifically asks:

# GCD of smallest and largest element

NOT whole array gcd.

So:
- find min
- find max
- compute gcd

========================================
7. REMOVE ONE ELEMENT TO MAXIMIZE GCD
========================================

VERY IMPORTANT PREFIX/SUFFIX GCD PROBLEM.

========================================
PROBLEM
========================================

Remove exactly one element so remaining array GCD becomes maximum.

========================================
CORE INTUITION
========================================

Naive:
remove every element
recompute gcd

Complexity:
O(n²)

Too slow.

----------------------------------------
OPTIMIZATION IDEA
----------------------------------------

Precompute:
- prefix gcd
- suffix gcd

========================================
PREFIX GCD
========================================

prefix[i]
=
gcd from:
0 → i

----------------------------------------
EXAMPLE
----------------------------------------

Array:

12 18 24 30

Prefix:

12
6
6
6

========================================
SUFFIX GCD
========================================

suffix[i]
=
gcd from:
i → n-1

----------------------------------------
EXAMPLE
----------------------------------------

30
6
6
30

========================================
MOST IMPORTANT OBSERVATION
========================================

Suppose removing:
index i

Then remaining gcd becomes:

gcd(prefix[i-1],suffix[i+1])

Because:
- left side gcd already known
- right side gcd already known

----------------------------------------
TIME COMPLEXITY
----------------------------------------

O(n)

VERY important optimization pattern.

========================================
8. PRIME NUMBERS
========================================

Prime:
# exactly two divisors

- 1
- itself

Examples:
2 3 5 7 11

----------------------------------------
NOT PRIME
----------------------------------------

4:
1 2 4

More than 2 divisors.

========================================
9. PRIME CHECKING
========================================

CODE:

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

========================================
MOST IMPORTANT PRIME OBSERVATION
========================================

Factors occur in:
# pairs

----------------------------------------
EXAMPLE
----------------------------------------

36

1 × 36
2 × 18
3 × 12
4 × 9
6 × 6

After sqrt(n):
pairs repeat.

----------------------------------------
HUGE CONCLUSION
----------------------------------------

To check divisibility:
only check till:

sqrt(n)

NOT till n.

========================================
WHY?
========================================

If factor larger than sqrt(n) exists:
smaller paired factor already checked earlier.

VERY important optimization.

----------------------------------------
TIME COMPLEXITY
----------------------------------------

O(√n)

========================================
10. SIEVE OF ERATOSTHENES
========================================

VERY VERY IMPORTANT ALGORITHM.

Used everywhere in CP.

========================================
PROBLEM
========================================

Find all primes:
1 → n

========================================
CODE
========================================

static void primeFrom1TON(int n) {

    boolean[] prime = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {

        prime[i] = true;
    }

    for (int i = 2; i * i <= n; i++) {

        if (!prime[i]) {

            continue;
        }

        for (int j = i * i; j <= n; j += i) {

            prime[j] = false;
        }
    }

    for (int i = 2; i <= n; i++) {

        if (prime[i]) {

            System.out.print(i + " ");
        }
    }
}

========================================
MOST IMPORTANT INTUITION
========================================

Instead of checking every number individually:
# eliminate multiples

----------------------------------------
EXAMPLE
----------------------------------------

Start:

2 3 4 5 6 7 8 9 10

----------------------------------------
STEP 1
----------------------------------------

2 is prime.

Remove multiples:
4 6 8 10

----------------------------------------
STEP 2
----------------------------------------

3 still prime.

Remove:
6 9

----------------------------------------
CONTINUE
----------------------------------------

Remaining numbers:
prime.

========================================
WHY START FROM i*i ?
========================================

Smaller multiples already processed earlier.

Example:

For i=5

5×2 already removed by 2
5×3 already removed by 3

So start from:
5×5

VERY important optimization.

========================================
TIME COMPLEXITY
========================================

Approximately:

O(n log log n)

VERY fast.

========================================
MOST IMPORTANT TAKEAWAYS
========================================

1. GCD uses remainder reduction
2. Euclidean Algorithm extremely fast
3. LCM linked to GCD
4. GCD associative
5. Prefix/Suffix GCD powerful optimization
6. Prime factors occur in pairs
7. Prime check only till sqrt(n)
8. Sieve generates primes efficiently
9. Number theory heavily uses observations
10. Most optimizations come from factor properties

========================================
END OF NUMBER THEORY NOTES — PART 1 🔥


========================================
========================================
NUMBER THEORY NOTES — PART 2 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Divisor Count Formula
2. Prime Factorization
3. Smallest Prime Factor (SPF)
4. Fast Prime Factorization
5. Sum of Divisors
6. Geometric Progression Formula
7. Sorted Divisors
8. Important Number Theory Observations
9. CP Recognition Patterns

========================================
1. DIVISORS OF A NUMBER
========================================

Divisors:
# numbers dividing perfectly

----------------------------------------
EXAMPLE
----------------------------------------

12 divisors:

1 2 3 4 6 12

Count:
6

========================================
2. PRIME FACTORIZATION
========================================

MOST IMPORTANT NUMBER THEORY IDEA.

Every number can be written uniquely as:

# product of primes

----------------------------------------
EXAMPLE
----------------------------------------

360

=
2³ × 3² × 5¹

VERY important representation.

========================================
WHY PRIME FACTORIZATION IMPORTANT?
========================================

Many formulas depend on:
- powers of primes
- unique prime representation

Used in:
- divisor count
- gcd/lcm
- modular arithmetic
- combinatorics

VERY important.

========================================
3. DIVISOR COUNT FORMULA
========================================

CODE:

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

========================================
MOST IMPORTANT FORMULA
========================================

If:

n =
p₁^a × p₂^b × p₃^c

Then:

Divisor Count:

(a+1)(b+1)(c+1)

========================================
WHY THIS WORKS
========================================

Suppose:

12 =
2² × 3¹

----------------------------------------
TO BUILD DIVISOR:
----------------------------------------

For prime:
2

Possible powers:
- 2⁰
- 2¹
- 2²

Total:
3 choices

----------------------------------------
FOR PRIME:
3

Possible powers:
- 3⁰
- 3¹

Total:
2 choices

----------------------------------------
TOTAL DIVISORS
----------------------------------------

3 × 2
=
6

Correct.

========================================
ACTUAL DIVISORS
========================================

2^x × 3^y

Possible:

1
2
4
3
6
12

Total:
6

DONE.

========================================
IMPORTANT OBSERVATION
========================================

Every divisor is formed by:
# choosing powers independently

That creates multiplication rule.

========================================
WHY IF(n > 1)?
========================================

Sometimes one prime factor remains.

----------------------------------------
EXAMPLE
----------------------------------------

n = 14

Loop checks:
2

Remaining:
7

7 is prime itself.

So:
power = 1

Contribution:
(1+1)=2

Needed separately.

VERY important edge case.

========================================
4. SMALLEST PRIME FACTOR (SPF)
========================================

VERY important CP optimization.

========================================
MAIN IDEA
========================================

For every number:
store:
# smallest prime dividing it

========================================
EXAMPLE
========================================

SPF Array:

2 -> 2
3 -> 3
4 -> 2
5 -> 5
6 -> 2
7 -> 7
8 -> 2
9 -> 3

========================================
WHY IMPORTANT?
========================================

Allows:
# ultra-fast factorization

========================================
CODE
========================================

int[] spf = new int[n + 1];

for (int i = 0; i <= n; i++) {

    spf[i] = i;
}

========================================
INITIALIZATION INTUITION
========================================

Initially assume:
every number prime.

So:
smallest factor of itself.

========================================
MARKING PROCESS
========================================

If:

spf[i] == i

Means:
still prime.

Now mark multiples.

----------------------------------------
EXAMPLE
----------------------------------------

For:
i = 2

Mark:

4 6 8 10

with SPF:
2

========================================
VERY IMPORTANT CHECK
========================================

if (spf[j] == j)

----------------------------------------
WHY?
----------------------------------------

Do NOT overwrite smaller factor.

Example:

12

Already marked:
2

Later:
3 also divides.

But SPF must stay:
2

VERY important.

========================================
5. FAST PRIME FACTORIZATION
========================================

CODE:

while (numFactorize != 1) {

    ans.add(spf[numFactorize]);

    numFactorize =
    numFactorize / spf[numFactorize];
}

========================================
MOST IMPORTANT INTUITION
========================================

SPF instantly gives:
# next prime factor

----------------------------------------
EXAMPLE
----------------------------------------

60

SPF[60]=2

60/2=30

SPF[30]=2

30/2=15

SPF[15]=3

15/3=5

SPF[5]=5

DONE.

Factors:

2 2 3 5

========================================
TIME COMPLEXITY
========================================

Very fast.

Approximately:
O(log n)

========================================
6. SUM OF DIVISORS
========================================

QUESTION:

Find sum of all divisors.

----------------------------------------
EXAMPLE
----------------------------------------

12 divisors:

1 2 3 4 6 12

Sum:
28

========================================
NORMAL METHOD
========================================

Generate contribution separately.

========================================
MOST IMPORTANT INTUITION
========================================

Every prime contributes:
# geometric progression

----------------------------------------
EXAMPLE
----------------------------------------

12 =
2² × 3¹

Contribution from:
2

1 + 2 + 4

Contribution from:
3

1 + 3

----------------------------------------
FINAL SUM
----------------------------------------

(1+2+4)(1+3)

=
7 × 4

=
28

Correct.

========================================
WHY MULTIPLY?
========================================

Because every divisor formed using:
# independent prime power choices

Same logic as divisor count.

========================================
7. GEOMETRIC PROGRESSION FORMULA
========================================

Instead of:

1 + p + p² + p³ ...

Use formula directly.

========================================
FORMULA
========================================

1 + p + p² + ... + p^k

=

(p^(k+1)-1)/(p-1)

========================================
CODE
========================================

contribution +=
(Math.pow(i, power + 1) - 1)
/
(i - 1);

========================================
WHY THIS FORMULA WORKS
========================================

Classic geometric progression formula.

----------------------------------------
EXAMPLE
----------------------------------------

1 + 2 + 4

Formula:

(2³ -1)/(2-1)

=
7

Correct.

========================================
8. SORTED DIVISORS
========================================

CODE:

for (int i = 1; i * i <= n; i++) {

    if (n % i == 0) {

        ans.add(i);

        if (i != n / i) {

            ans.add(n / i);
        }
    }
}

========================================
MOST IMPORTANT OBSERVATION
========================================

Divisors occur in:
# pairs

----------------------------------------
EXAMPLE
----------------------------------------

36

1 × 36
2 × 18
3 × 12
4 × 9
6 × 6

Only check till:
sqrt(n)

VERY important optimization.

========================================
WHY i != n/i ?
========================================

Avoid duplicate square root.

Example:

36

6 × 6

Add only once.

========================================
TIME COMPLEXITY
========================================

O(√n)

VERY efficient.

========================================
9. IMPORTANT NUMBER THEORY OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

Prime factorization uniquely defines number.

----------------------------------------
OBSERVATION 2
----------------------------------------

Most divisor formulas come from:
# prime powers

----------------------------------------
OBSERVATION 3
----------------------------------------

Factors occur in:
pairs

----------------------------------------
OBSERVATION 4
----------------------------------------

sqrt(n) optimization appears everywhere.

----------------------------------------
OBSERVATION 5
----------------------------------------

SPF transforms slow factorization into fast factorization.

========================================
10. COMMON CP RECOGNITION
========================================

WHEN TO THINK PRIME FACTORIZATION?
----------------------------------------

- divisors
- gcd/lcm
- multiplicative formulas
- factor properties

----------------------------------------
WHEN TO THINK SPF?
----------------------------------------

- repeated factorization
- multiple queries
- preprocessing

----------------------------------------
WHEN TO THINK SIEVE?
----------------------------------------

- many prime queries
- all primes till n
- factor preprocessing

----------------------------------------
WHEN TO THINK sqrt(n)?
----------------------------------------

- divisor checking
- prime checking
- factor generation

========================================
11. MOST IMPORTANT FINAL INTUITION
========================================

Number Theory is mostly:
# observations about factor structure

The biggest patterns are:

1. Prime factorization
2. Divisor pairing
3. Multiplicative behavior
4. sqrt(n) optimization
5. Preprocessing with sieve/SPF

========================================
END OF NUMBER THEORY NOTES — PART 2 🔥

========================================

========================================
NUMBER THEORY NOTES — PART 3 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Prefix/Suffix GCD Deep Thinking
2. Associative Property
3. Number Theory Optimization Patterns
4. Complexity Analysis
5. Important CP Observations
6. Prime Patterns
7. Divisor Patterns
8. Recognition Tricks
9. Common Mistakes
10. Real CP Number Theory Thinking

========================================
1. PREFIX GCD DEEP THINKING
========================================

VERY important CP optimization pattern.

========================================
PROBLEM
========================================

Remove one element to maximize:
# GCD of remaining array

========================================
NAIVE APPROACH
========================================

For every index:
- remove element
- recompute gcd

Complexity:

O(n²)

Too slow.

========================================
OPTIMIZED IDEA
========================================

Precompute:
- prefix gcd
- suffix gcd

========================================
PREFIX GCD
========================================

prefix[i]

=
gcd from:
0 → i

----------------------------------------
EXAMPLE
----------------------------------------

Array:

12 18 24 30

Prefix:

12
6
6
6

========================================
SUFFIX GCD
========================================

suffix[i]

=
gcd from:
i → n-1

----------------------------------------
EXAMPLE
----------------------------------------

Suffix:

6
6
6
30

========================================
MOST IMPORTANT INTUITION
========================================

Suppose removing:
index i

Need gcd of:
- left side
- right side

Already known using:
- prefix
- suffix

----------------------------------------
FORMULA
----------------------------------------

gcd(prefix[i-1],suffix[i+1])

========================================
WHY THIS WORKS
========================================

GCD is:
# associative

Meaning:

gcd(a,b,c,d)

can be grouped in any order.

So:
left gcd and right gcd can combine directly.

========================================
TIME COMPLEXITY
========================================

Building:
prefix + suffix

=
O(n)

Each query:
O(1)

Total:
O(n)

VERY important optimization pattern.

========================================
2. ASSOCIATIVE PROPERTY
========================================

VERY important mathematical property.

========================================
FORMULA
========================================

gcd(a,b,c)

=
gcd(gcd(a,b),c)

========================================
WHY IMPORTANT?
========================================

Allows:
- sequential processing
- prefix computation
- suffix computation
- segment trees

VERY important in CP.

========================================
3. NUMBER THEORY OPTIMIZATION PATTERNS
========================================

MOST IMPORTANT OBSERVATION:

Most number theory optimizations come from:
# mathematical patterns

NOT brute force.

========================================
COMMON PATTERNS
========================================

----------------------------------------
PATTERN 1
----------------------------------------

Factors occur in:
pairs

Leads to:
sqrt(n) optimization

----------------------------------------
PATTERN 2
----------------------------------------

Prime factorization uniquely represents number.

Leads to:
divisor formulas

----------------------------------------
PATTERN 3
----------------------------------------

Preprocessing helps repeated queries.

Leads to:
sieve
SPF

----------------------------------------
PATTERN 4
----------------------------------------

Associativity enables prefix/suffix.

Leads to:
fast gcd processing

========================================
4. IMPORTANT COMPLEXITIES
========================================

----------------------------------------
GCD
----------------------------------------

O(log n)

VERY fast.

----------------------------------------
PRIME CHECK
----------------------------------------

O(√n)

----------------------------------------
SIEVE
----------------------------------------

O(n log log n)

----------------------------------------
DIVISOR ENUMERATION
----------------------------------------

O(√n)

----------------------------------------
SPF FACTORIZATION
----------------------------------------

O(log n)

VERY important to remember in CP.

========================================
5. PRIME NUMBER OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

2 is:
# only even prime

----------------------------------------
OBSERVATION 2
----------------------------------------

All primes >2 are odd.

----------------------------------------
OBSERVATION 3
----------------------------------------

Prime factors completely define number.

----------------------------------------
OBSERVATION 4
----------------------------------------

Composite numbers always have:
factor ≤ sqrt(n)

VERY important theorem.

========================================
WHY FACTOR ≤ sqrt(n)?
========================================

Suppose:

both factors > sqrt(n)

Then:

their multiplication > n

Impossible.

So:
one factor must be ≤ sqrt(n)

This powers many optimizations.

========================================
6. DIVISOR PATTERNS
========================================

----------------------------------------
PERFECT SQUARES
----------------------------------------

Odd number of divisors.

----------------------------------------
WHY?
----------------------------------------

Because one divisor repeats.

Example:

36

1×36
2×18
3×12
4×9
6×6

6 repeats.

So:
odd divisor count.

----------------------------------------
NON PERFECT SQUARES
----------------------------------------

Even number of divisors.

Because all divisor pairs distinct.

========================================
7. SIEVE DEEP INTUITION
========================================

MOST IMPORTANT IDEA:

Instead of checking:
# whether number prime

directly,

we:
# eliminate composites

----------------------------------------
WHY SIEVE FAST?
----------------------------------------

Each composite marked by:
its prime divisors only.

Avoids repeated expensive checking.

========================================
8. SPF DEEP INTUITION
========================================

SPF stores:
# smallest prime factor

This creates:
# factorization shortcuts

----------------------------------------
EXAMPLE
----------------------------------------

60

Instead of testing:
2 3 4 5 ...

SPF instantly gives:

2

Then reduce:

30

Again:
2

Then:
15

Again:
3

VERY fast decomposition.

========================================
9. IMPORTANT CP RECOGNITION
========================================

WHEN TO THINK GCD?
----------------------------------------

- divisibility
- fractions
- pair reductions
- array operations

----------------------------------------
WHEN TO THINK PRIME FACTORIZATION?
----------------------------------------

- divisor formulas
- multiplicative properties
- gcd/lcm derivations

----------------------------------------
WHEN TO THINK SIEVE?
----------------------------------------

- many prime queries
- all primes till n
- repeated factorization

----------------------------------------
WHEN TO THINK PREFIX/SUFFIX?
----------------------------------------

- remove one element
- range gcd
- associative operations

========================================
10. COMMON MISTAKES
========================================

----------------------------------------
MISTAKE 1
----------------------------------------

Loop till:
n

instead of:
sqrt(n)

Causes TLE.

----------------------------------------
MISTAKE 2
----------------------------------------

Forgetting remaining prime factor:

if(n > 1)

VERY common bug.

----------------------------------------
MISTAKE 3
----------------------------------------

Overwriting SPF values.

Breaks smallest prime logic.

----------------------------------------
MISTAKE 4
----------------------------------------

Using:

(a*b)

before division in LCM

Can overflow.

Safer:

(a/gcd(a,b))*b

========================================
11. REAL NUMBER THEORY THINKING
========================================

The REAL skill is NOT formulas.

It is:
# identifying hidden mathematical structure

Ask:

- Can factorization help?
- Can divisors pair?
- Can gcd reduce problem?
- Can preprocessing help?
- Can sqrt optimization work?

THAT is real CP number theory thinking.

========================================
12. MOST IMPORTANT FINAL TAKEAWAYS
========================================

13. GCD reduces problems recursively
14. Prime factorization drives many formulas
15. Divisors occur in pairs
16. sqrt(n) optimization extremely important
17. Sieve/SPF are preprocessing powerhouses
18. Prefix/Suffix works due to associativity
19. Most CP number theory relies on observations
20. Mathematical structure > brute force

========================================
END OF NUMBER THEORY NOTES 🔥
========================================