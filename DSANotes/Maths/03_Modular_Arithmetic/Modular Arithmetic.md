
========================================
MODULAR ARITHMETIC NOTES — PART 1 🔥
========================================

TOPICS COVERED:
1. Why Modular Arithmetic?
2. Binary Exponentiation
3. Recursive Binary Exponentiation
4. Iterative Binary Exponentiation
5. Bit Logic Behind Exponentiation
6. Fermat’s Little Theorem
7. Modular Inverse
8. Modular Division
9. Important CP Observations

========================================
1. WHY MODULAR ARITHMETIC?
========================================

In CP:
numbers become HUGE.

Example:

2^100000

Impossible to store normally.

So we use:

# modulo

Usually:

10^9 + 7

----------------------------------------
WHY 10^9+7 ?
----------------------------------------

Because:
- prime number
- large enough
- avoids overflow often
- useful for modular inverse

VERY important CP constant.

========================================
2. MODULO PROPERTIES
========================================

----------------------------------------
ADDITION
----------------------------------------

(a+b)%m

=
((a%m)+(b%m))%m

----------------------------------------
MULTIPLICATION
----------------------------------------

(a*b)%m

=
((a%m)*(b%m))%m

----------------------------------------
SUBTRACTION
----------------------------------------

(a-b)%m

=
((a%m)-(b%m)+m)%m

----------------------------------------
IMPORTANT
----------------------------------------

Modulo preserves:
- addition
- multiplication

VERY important in CP.

========================================
3. BINARY EXPONENTIATION
========================================

VERY VERY IMPORTANT algorithm.

Used everywhere in CP.

========================================
PROBLEM
========================================

Find:

a^n

FAST.

----------------------------------------
NAIVE
----------------------------------------

Multiply:
n times

Complexity:
O(n)

Too slow for huge powers.

========================================
CORE IDEA
========================================

Use:
# binary representation of exponent

----------------------------------------
IMPORTANT OBSERVATION
----------------------------------------

Example:

2^10

=
(2^5)^2

----------------------------------------
ANOTHER OBSERVATION
----------------------------------------

2^11

=
2 × (2^5)^2

This allows:
# divide exponent by 2 repeatedly

Huge optimization.

========================================
4. RECURSIVE BINARY EXPONENTIATION
========================================

CODE:

public static long power1(long a, long n, long m) {

    if (n == 0) {
        return 1;
    }

    if (n % 2 == 0) {

        return power1((a * a) % m,
                      n / 2,
                      m);
    }

    return a *
           power1((a * a) % m,
                  (n - 1) / 2,
                  m);
}

========================================
MOST IMPORTANT INTUITION
========================================

If exponent even:

a^10

=
(a²)^5

----------------------------------------
IF ODD
----------------------------------------

a^11

=
a × (a²)^5

----------------------------------------
WHY FASTER?
----------------------------------------

Exponent reduces by:
# half every step

Complexity:

O(log n)

VERY important optimization.

========================================
5. ITERATIVE BINARY EXPONENTIATION
========================================

CODE:

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

========================================
MOST IMPORTANT INTUITION
========================================

Exponent processed:
# bit-by-bit

========================================
EXAMPLE
========================================

Compute:

2^13

----------------------------------------
13 IN BINARY
----------------------------------------

1101

Meaning:

13
=
8 + 4 + 1

So:

2^13

=
2^8 × 2^4 × 2^1

========================================
HOW ALGORITHM WORKS
========================================

Initially:

a = 2
n = 13
ans = 1

----------------------------------------
STEP 1
----------------------------------------

13 odd.

Take current power.

ans = 1×2 = 2

Square base:

a = 4

Shift exponent:

13 >> 1

=
6

----------------------------------------
STEP 2
----------------------------------------

6 even.

Do not multiply.

Square base:

16

Shift:

3

----------------------------------------
STEP 3
----------------------------------------

3 odd.

Multiply:

2 × 16

=
32

Square base:

256

Shift:

1

----------------------------------------
STEP 4
----------------------------------------

1 odd.

Multiply:

32 × 256

=
8192

DONE.

========================================
WHY (n & 1)?
========================================

Checks:
# last binary bit

----------------------------------------
IMPORTANT
----------------------------------------

Odd numbers:
LSB = 1

Even numbers:
LSB = 0

========================================
WHY n >> 1 ?
========================================

Right shift:
# divide by 2

Moves to next binary bit.

========================================
TIME COMPLEXITY
========================================

O(log n)

VERY important algorithm.

========================================
6. MODULAR BINARY EXPONENTIATION
========================================

CODE:

static long power(long a,
                  long n,
                  long mod) {

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

========================================
WHY MOD INSIDE LOOP?
========================================

Without modulo:
numbers overflow quickly.

Modulo keeps numbers small.

VERY important.

========================================
7. FERMAT’S LITTLE THEOREM
========================================

EXTREMELY important theorem.

========================================
THEOREM
========================================

If:
- p prime
- a not divisible by p

Then:

a^(p-1)

≡ 1 (mod p)

========================================
HUGE CONSEQUENCE
========================================

a^(p-2)

≡ a^(-1) (mod p)

Meaning:
# modular inverse

========================================
8. MODULAR INVERSE
========================================

CODE:

static long modInverse(long a,
                       long mod) {

    return power(a,
                 mod - 2,
                 mod);
}

========================================
MOST IMPORTANT INTUITION
========================================

Normal division:
not directly possible in modulo.

Instead:

a / b

becomes:

a × inverse(b)

========================================
MODULAR INVERSE MEANING
========================================

Inverse of:
b

means:

b × inverse(b)

≡ 1 (mod m)

========================================
EXAMPLE
========================================

Modulo:
5

Inverse of:
2

Need:

2 × x ≡ 1 (mod 5)

Try:

2×3 = 6

6 % 5 = 1

So inverse:
3

========================================
9. MODULAR DIVISION
========================================

CODE:

static long divide(long a,
                   long b,
                   long mod) {

    return
    (a * modInverse(b, mod)) % mod;
}

========================================
MOST IMPORTANT OBSERVATION
========================================

Modulo division:

a / b

becomes:

a × b^(-1)

VERY important in:
- combinatorics
- probability
- modular equations

========================================
10. IMPORTANT CP OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

Binary exponentiation appears:
EVERYWHERE.

----------------------------------------
OBSERVATION 2
----------------------------------------

Exponentiation often reduced using:
binary bits.

----------------------------------------
OBSERVATION 3
----------------------------------------

Modulo division requires:
modular inverse

----------------------------------------
OBSERVATION 4
----------------------------------------

Fermat inverse works only when:
mod prime

VERY important.

========================================
11. COMMON CP RECOGNITION
========================================

WHEN TO THINK BINARY EXPONENTIATION?
----------------------------------------

- huge powers
- modular powers
- repeated squaring
- fast exponentiation

----------------------------------------
WHEN TO THINK MODULAR INVERSE?
----------------------------------------

- modular division
- nCr modulo
- fractions in modulo

----------------------------------------
WHEN TO THINK FERMAT?
----------------------------------------

- mod prime
- inverse needed

========================================
12. MOST IMPORTANT FINAL INTUITION
========================================

Binary Exponentiation is:
# exploiting binary representation

Modular Arithmetic is:
# keeping huge numbers manageable

Modular Inverse is:
# replacing impossible division with multiplication

These three ideas form:
# core CP modular arithmetic foundation

========================================
END OF MODULAR ARITHMETIC NOTES — PART 1 🔥
========================================

========================================
MODULAR ARITHMETIC NOTES — PART 2 🔥
========================================

TOPICS COVERED:
1. Factorial under Modulo
2. nCr under Modulo
3. Why Normal Division Fails
4. Modular nCr Formula
5. nPr (Permutation)
6. Combination vs Permutation
7. Deep Combinatorics Intuition
8. Important CP Observations
9. Common Mistakes
10. Real CP Thinking

========================================
1. FACTORIAL
========================================

========================================
DEFINITION
========================================

n!

=
1 × 2 × 3 × 4 ... × n

----------------------------------------
EXAMPLES
----------------------------------------

5!

=
1×2×3×4×5

=
120

----------------------------------------

3!

=
6

----------------------------------------

0!

=
1

VERY important.

========================================
WHY 0! = 1 ?
========================================

Because:
# empty multiplication

must preserve identity.

Same as:
empty sum = 0

VERY important mathematical convention.

========================================
2. FACTORIAL UNDER MODULO
========================================

CODE:

static long factIterative(long n,
                          long m) {

    long ans = 1;

    if (n == 0 || n == 1) {
        return ans;
    }

    for (int i = 1; i <= n; i++) {

        ans = (ans * i) % m;
    }

    return ans;
}

========================================
WHY MOD EVERY STEP?
========================================

Factorials grow:
# EXTREMELY fast

Example:

20!

already huge.

Without modulo:
overflow occurs.

----------------------------------------
IMPORTANT OBSERVATION
----------------------------------------

Modulo multiplication property:

(a*b)%m

=
((a%m)*(b%m))%m

So taking modulo every step:
safe and correct.

========================================
3. COMBINATION (nCr)
========================================

========================================
MEANING
========================================

Choose:
r objects

from:
n objects

Order:
# does NOT matter

========================================
FORMULA
========================================

nCr
=
n! / (r!(n-r)!)

========================================
EXAMPLE
========================================

5C2

=
5! / (2!×3!)

=
120 / (2×6)

=
10

========================================
WHY THIS FORMULA?
========================================

Suppose selecting:
2 people from 5

Naively:
all arrangements counted.

But:

AB
BA

same combination.

Need remove duplicate arrangements.

That is why:
divide by:
r!

VERY important intuition.

========================================
4. WHY NORMAL DIVISION FAILS IN MODULO?
========================================

VERY VERY IMPORTANT.

========================================
WRONG THINKING
========================================

(a/b)%m

=
(a%m)/(b%m)

WRONG.

Modulo arithmetic does NOT preserve division normally.

========================================
EXAMPLE
========================================

(3/2)%5

Normal division:
1.5

Meaningless in modulo.

----------------------------------------
REAL SOLUTION
----------------------------------------

Use:
# modular inverse

========================================
MODULAR DIVISION
========================================

a / b

becomes:

a × inverse(b)

========================================
5. MODULAR nCr
========================================

CODE:

static long nCr(long n,
                long r,
                long m) {

    long neno =
    factIterative(n, m);

    long deno =
    (factIterative(r, m)
    *
    factIterative(n-r, m))
    % m;

    long denoInverse =
    modInverse(deno, m);

    long result =
    (neno * denoInverse)
    % m;

    return result;
}

========================================
MOST IMPORTANT FLOW
========================================

Normal formula:

n! / (r!(n-r)!)

----------------------------------------
IN MODULO
----------------------------------------

Cannot divide directly.

So:

n!

×

inverse(r!(n-r)!)

VERY important transformation.

========================================
STEP-BY-STEP INTUITION
========================================

Suppose:

5C2

----------------------------------------
NUMERATOR
----------------------------------------

5!

=
120

----------------------------------------
DENOMINATOR
----------------------------------------

2!×3!

=
12

----------------------------------------
NOW MODULO
----------------------------------------

Instead of:

120/12

Do:

120 × inverse(12)

VERY important modular trick.

========================================
6. PERMUTATION (nPr)
========================================

========================================
MEANING
========================================

Arrange:
r positions

from:
n objects

Order:
# matters

========================================
FORMULA
========================================

nPr

=
n! / (n-r)!

========================================
EXAMPLE
========================================

5P2

=
5! / 3!

=
120 / 6

=
20

========================================
WHY DIFFERENT FROM nCr?
========================================

Because:
# order matters

----------------------------------------
EXAMPLE
----------------------------------------

Suppose:

A B

In:
combination

AB and BA:
same

----------------------------------------
BUT IN PERMUTATION
----------------------------------------

AB
BA

different arrangements.

So:
more answers.

========================================
7. nPr CODE
========================================

CODE:

static long nPr(long n,
                long r,
                long m) {

    long nFact =
    factIterative(n, m);

    long rFact =
    factIterative(n-r, m);

    long modInRFact =
    modInverse(rFact, m);

    return
    (nFact * modInRFact) % m;
}

========================================
MOST IMPORTANT INTUITION
========================================

Need arrange:
only r positions.

----------------------------------------
EXAMPLE
----------------------------------------

5P2

Choose first position:
5 choices

Second:
4 choices

Total:

5×4

=
20

Same as formula.

========================================
8. COMBINATION vs PERMUTATION
========================================

----------------------------------------
COMBINATION
----------------------------------------

Order does NOT matter.

Example:

AB = BA

----------------------------------------
PERMUTATION
----------------------------------------

Order matters.

Example:

AB ≠ BA

========================================
IMPORTANT RELATION
========================================

nPr
=
nCr × r!

----------------------------------------
WHY?
----------------------------------------

nCr:
choose group

r!:
arrange chosen group

VERY important connection.

========================================
9. IMPORTANT CP OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

Modulo division always means:
modular inverse.

----------------------------------------
OBSERVATION 2
----------------------------------------

Factorials appear everywhere in:
combinatorics.

----------------------------------------
OBSERVATION 3
----------------------------------------

Permutation:
order matters

Combination:
order does not matter

----------------------------------------
OBSERVATION 4
----------------------------------------

nCr extremely common in:
- DP
- probability
- counting
- grids
- paths

========================================
10. COMMON MISTAKES
========================================

----------------------------------------
MISTAKE 1
----------------------------------------

Doing direct division under modulo.

WRONG.

Always use:
mod inverse.

----------------------------------------
MISTAKE 2
----------------------------------------

Forgetting modulo after multiplication.

Causes overflow.

----------------------------------------
MISTAKE 3
----------------------------------------

Using Fermat inverse when:
mod NOT prime.

Invalid.

----------------------------------------
MISTAKE 4
----------------------------------------

Confusing:
nCr and nPr

Order matters?
Check carefully.

========================================
11. REAL CP THINKING
========================================

When seeing huge combinatorics:

Ask:
- Is modulo involved?
- Is division happening?
- Need modular inverse?
- Order matters?
- Combination or permutation?

THAT is real modular arithmetic/combinatorics thinking.

========================================
12. MOST IMPORTANT FINAL TAKEAWAYS
========================================

13. Factorials grow extremely fast
14. Modulo prevents overflow
15. Division under modulo requires inverse
16. Fermat theorem gives fast inverse
17. nCr = selection
18. nPr = arrangement
19. Combination ignores order
20. Permutation respects order
21. Modular arithmetic + combinatorics deeply connected

========================================
END OF MODULAR ARITHMETIC NOTES 🔥
========================================