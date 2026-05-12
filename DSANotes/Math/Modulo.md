/*
========================================================
                MODULO ARITHMETIC NOTES
========================================================

Modulo arithmetic is one of the MOST IMPORTANT topics
in Competitive Programming.

Almost every:
- Math problem
- DP problem
- Combinatorics problem
- Binary Exponentiation problem
- Graph counting problem

uses modulo.

========================================================
1) WHAT IS MODULO ?
========================================================

a % m

means:

REMAINDER after dividing a by m


Example:

17 % 5

17 = 5*3 + 2

Remainder = 2

So:

17 % 5 = 2


========================================================
2) WHY MODULO IS USED IN CP ?
========================================================

Because numbers become HUGE.

Example:

2^100000

cannot fit in:
- int
- long
- even BigInteger becomes too slow sometimes

So problem says:

"Return answer modulo 1e9+7"

Meaning:

Only return remainder.


========================================================
3) WHY 1e9+7 ?
========================================================

1e9+7 = 1000000007

Reasons:
- Prime number
- Large enough
- Fits inside int range
- Good mathematical properties

Usually:

MOD = 1000000007


========================================================
4) MOST IMPORTANT MODULO PROPERTIES
========================================================


--------------------------------------------------------
ADDITION PROPERTY
--------------------------------------------------------

(a + b) % MOD
=
((a % MOD) + (b % MOD)) % MOD


Example:

(17 + 19) % 5

36 % 5 = 1

Now using property:

17 % 5 = 2
19 % 5 = 4

(2 + 4) % 5
= 6 % 5
= 1

Same answer.


--------------------------------------------------------
SUBTRACTION PROPERTY
--------------------------------------------------------

(a - b) % MOD
=
((a % MOD) - (b % MOD) + MOD) % MOD


Why +MOD ?

Because subtraction may become negative.


Example:

(2 - 5) % 7

= -3

But modulo answer should be positive.

So:

(2 - 5 + 7) % 7
=
4


--------------------------------------------------------
MULTIPLICATION PROPERTY
--------------------------------------------------------

(a * b) % MOD
=
((a % MOD) * (b % MOD)) % MOD


THIS IS THE MOST IMPORTANT PROPERTY.


Example:

(17 * 19) % 5

323 % 5 = 3


Now using modulo early:

17 % 5 = 2
19 % 5 = 4

(2 * 4) % 5
=
8 % 5
=
3

Same answer.


========================================================
5) WHY WE APPLY MOD AFTER EVERY MULTIPLICATION
========================================================

Because multiplication grows VERY FAST.


Example:

long x = 1000000000000L;

x*x

=
10^24


But long max limit:

~9*10^18


So overflow happens BEFORE modulo.


WRONG:

x*x % MOD


because:
x*x already overflowed.


CORRECT:

(x % MOD * x % MOD) % MOD


========================================================
6) GOLDEN RULE OF MODULO
========================================================

Whenever you see:

    *

inside modulo problems,

brain should automatically think:

    % MOD


========================================================
7) SAFE MODULO PATTERNS
========================================================


--------------------------------------------------------
SAFE ADDITION
--------------------------------------------------------

long ans = (a + b) % MOD;


--------------------------------------------------------
SAFE SUBTRACTION
--------------------------------------------------------

long ans = (a - b + MOD) % MOD;


--------------------------------------------------------
SAFE MULTIPLICATION
--------------------------------------------------------

long ans = (a * b) % MOD;


--------------------------------------------------------
SAFE MULTIPLE MULTIPLICATION
--------------------------------------------------------

long ans = (((a % MOD) * (b % MOD)) % MOD * c) % MOD;


========================================================
8) WHAT IS OVERFLOW ?
========================================================

Overflow means:

value becomes bigger than datatype limit.


--------------------------------------------------------
INT RANGE
--------------------------------------------------------

-2^31 to 2^31-1

=
-2147483648 to 2147483647


--------------------------------------------------------
LONG RANGE
--------------------------------------------------------

~ -9*10^18 to 9*10^18


If value exceeds this:

Java wraps value incorrectly.


========================================================
9) WHY WE USE long IN MODULO PROBLEMS
========================================================

Because:

int * int

can overflow.


Example:

100000 * 100000

=
10^10

which exceeds int.


So use:

long


========================================================
10) BINARY EXPONENTIATION
========================================================

Used to compute:

a^b

VERY FAST.


--------------------------------------------------------
NORMAL POWER
--------------------------------------------------------

O(n)


--------------------------------------------------------
BINARY EXPONENTIATION
--------------------------------------------------------

O(log n)


========================================================
11) BINARY EXPONENTIATION IDEA
========================================================

Example:

2^10

Instead of:

2*2*2*2*2*2...

We use:

2^10
=
(2^2)^5
=
4^5


Exponent keeps reducing by HALF.


========================================================
12) BINARY EXPONENTIATION FORMULAS
========================================================


--------------------------------------------------------
EVEN POWER
--------------------------------------------------------

x^n = (x*x)^(n/2)


Example:

2^8
=
(2*2)^4
=
4^4


--------------------------------------------------------
ODD POWER
--------------------------------------------------------

x^n = x*(x*x)^((n-1)/2)


Example:

2^9
=
2*(2*2)^4
=
2*4^4


========================================================
13) CORRECT MODULAR BINARY EXPONENTIATION
========================================================
*/

class BinaryExponentiation {

    static long MOD = 1000000007;

    public static long power(long x, long n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // EVEN POWER
        if (n % 2 == 0) {

            /*
            IMPORTANT:

            (x*x) can become huge.

            So immediately apply modulo.
            */

            return power((x * x) % MOD, n / 2);
        }

        /*
        ODD POWER

        VERY IMPORTANT:

        x * recursiveAnswer can overflow.

        So apply modulo after multiplication.
        */

        return (x % MOD * power((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
}


/*
========================================================
14) ITERATIVE BINARY EXPONENTIATION
========================================================

This is the MOST USED version in CP.

Why?

- Faster
- No recursion overhead
- No stack risk

========================================================
*/

class IterativePower {

    static long MOD = 1000000007;

    public static long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            /*
            If current bit is set
            */

            if ((exp & 1) == 1) {

                result = (result * base) % MOD;
            }

            /*
            Square the base
            */

            base = (base * base) % MOD;

            /*
            Divide exponent by 2
            */

            exp >>= 1;
        }

        return result;
    }
}


/*
========================================================
15) WHEN NOT TO USE MODULO
========================================================

Modulo changes ACTUAL value.

So don't use modulo when:

- Comparing actual values
- Sorting
- Min/max actual number
- Inequality logic


--------------------------------------------------------
WRONG EXAMPLE
--------------------------------------------------------

if ((a % MOD) > (b % MOD))

This DOES NOT mean:

a > b


Example:

100 % 7 = 2
5 % 7 = 5

2 < 5

But:

100 > 5


========================================================
16) VERY IMPORTANT CP HABITS
========================================================

RULE 1:
Use long for modulo multiplication.


RULE 2:
After every multiplication:
apply % MOD.


RULE 3:
In power problems:
always use binary exponentiation.


RULE 4:
If problem says:
"return answer modulo MOD"

then almost entire computation should happen under modulo.


RULE 5:
Never allow huge multiplication without modulo.


========================================================
	1) MOST IMPORTANT FINAL MINDSET
========================================================

In modulo problems:

You are NOT working with actual numbers anymore.

You are working with:

REMAINDERS.

Everything gets continuously compressed using modulo.

========================================================
*/