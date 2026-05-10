# Pow(x, n) — Complete Revision Notes

------------------------------------------------------------
PROBLEM
------------------------------------------------------------

Implement:

x^n

Meaning:

x raised to power n

Examples:

2^5  = 32
2^3  = 8
2^-2 = 0.25
2^0  = 1

------------------------------------------------------------
IMPORTANT UNDERSTANDING
------------------------------------------------------------

When exponent is INTEGER:

Power means repeated multiplication.

Example:

2^5 = 2 × 2 × 2 × 2 × 2

------------------------------------------------------------
BRUTE FORCE APPROACH
------------------------------------------------------------

Loop n times and multiply.

Example:

double ans = 1;

for(int i=0; i<n; i++){
    ans = ans * x;
}

------------------------------------------------------------
WHY BRUTE FORCE IS BAD
------------------------------------------------------------

If:

n = 1000000000

Then:

1 billion multiplications needed.

Time Complexity:

O(n)

Too slow.

------------------------------------------------------------
OPTIMIZED APPROACH
------------------------------------------------------------

Use:

BINARY EXPONENTIATION

Also called:

1. Fast Power
2. Exponentiation by Squaring

------------------------------------------------------------
CORE MATHEMATICAL OBSERVATION
------------------------------------------------------------

EVEN POWER:

x^n = (x²)^(n/2)

Example:

2^8 = (2²)^4
    = 4^4

------------------------------------------------------------

ODD POWER:

x^n = x × (x²)^((n-1)/2)

Example:

2^5 = 2 × (2²)^2
    = 2 × 4²

------------------------------------------------------------
MOST IMPORTANT IDEA
------------------------------------------------------------

At every step:

1. Square the base
2. Divide power by 2

This drastically reduces operations.

------------------------------------------------------------
RECURSIVE CODE
------------------------------------------------------------

class Solution {

    public double myPow(double x, int n) {
        return myPow1(x, (long)n);
    }

    public static double myPow1(double x, long n) {

        // BASE CASE
        if(n == 0){
            return 1;
        }

        // NEGATIVE POWER
        if(n < 0){
            return myPow1(1/x, -n);
        }

        // EVEN POWER
        if(n % 2 == 0){
            return myPow1(x*x, n/2);
        }

        // ODD POWER
        return x * myPow1(x*x, (n-1)/2);
    }
}

------------------------------------------------------------
WHY LONG IS USED
------------------------------------------------------------

Very important.

If:

n = Integer.MIN_VALUE

Then:

-n causes overflow.

So we convert int to long.

------------------------------------------------------------
BASE CASE
------------------------------------------------------------

if(n == 0){
    return 1;
}

Because mathematically:

x^0 = 1

------------------------------------------------------------
NEGATIVE POWER CASE
------------------------------------------------------------

if(n < 0){
    return myPow1(1/x, -n);
}

Uses formula:

x^(-n) = 1 / (x^n)

Example:

2^-3 = 1/(2^3)
     = 1/8
     = 0.125

------------------------------------------------------------
EVEN POWER CASE
------------------------------------------------------------

if(n % 2 == 0){
    return myPow1(x*x, n/2);
}

Uses formula:

x^n = (x²)^(n/2)

Example:

2^8
→ 4^4
→ 16^2
→ 256^1

Even case DOES NOT build answer.

It only REDUCES problem size.

------------------------------------------------------------
ODD POWER CASE
------------------------------------------------------------

return x * myPow1(x*x, (n-1)/2);

Uses formula:

x^n = x × (x²)^((n-1)/2)

Example:

2^5
= 2 × (2²)^2
= 2 × 4²

Odd case BUILDS answer.

Because odd powers leave one extra x.

------------------------------------------------------------
MOST IMPORTANT RECURSION UNDERSTANDING
------------------------------------------------------------

Recursion has TWO phases:

1. Going DOWN
2. Coming UP (Backtracking)

------------------------------------------------------------
GOING DOWN
------------------------------------------------------------

Recursive calls are created.

Example:

myPow1(2,5)

→ 2 * myPow1(4,2)

        ↓

    myPow1(4,2)

    → myPow1(16,1)

            ↓

        myPow1(16,1)

        → 16 * myPow1(256,0)

                    ↓

            myPow1(256,0)

            → 1

------------------------------------------------------------
IMPORTANT
------------------------------------------------------------

NO multiplication happens while going down.

Recursive calls only wait for answers.

------------------------------------------------------------
COMING UP (BACKTRACKING)
------------------------------------------------------------

Now stack starts returning.

myPow1(256,0)
returns 1

------------------------------------------------------------

Then:

16 * 1 = 16

So:

myPow1(16,1)
returns 16

------------------------------------------------------------

Then:

myPow1(4,2)
returns 16

(No multiplication because EVEN case)

------------------------------------------------------------

Then:

2 * 16 = 32

Final Answer:

32

------------------------------------------------------------
MOST IMPORTANT INSIGHT
------------------------------------------------------------

This line:

return x * myPow1(...)

DOES NOT immediately multiply.

It means:

"Wait for recursive answer first,
then multiply with x."

------------------------------------------------------------
EVEN VS ODD CASES
------------------------------------------------------------

EVEN CASE:

Only reduces problem.

Example:

2^8
→ 4^4
→ 16^2
→ 256^1

No extra multiplication added.

------------------------------------------------------------

ODD CASE:

Actually builds answer.

Example:

2^5
= 2 × 4²

Extra x contributes to final answer.

------------------------------------------------------------
DRY RUN — TEST CASE 1
------------------------------------------------------------

Input:

x = 2
n = 5

Expected:

32

------------------------------------------------------------

myPow1(2,5)

→ 2 * myPow1(4,2)

        ↓

    myPow1(4,2)

    → myPow1(16,1)

            ↓

        myPow1(16,1)

        → 16 * myPow1(256,0)

                    ↓

            return 1

------------------------------------------------------------

BACKTRACKING:

16 * 1 = 16

2 * 16 = 32

Answer = 32

------------------------------------------------------------
DRY RUN — TEST CASE 2
------------------------------------------------------------

Input:

x = 2
n = 8

Expected:

256

------------------------------------------------------------

myPow1(2,8)

→ myPow1(4,4)

    → myPow1(16,2)

        → myPow1(256,1)

            → 256 * myPow1(65536,0)

                    → 1

------------------------------------------------------------

BACKTRACKING:

256 * 1 = 256

Answer = 256

------------------------------------------------------------
DRY RUN — TEST CASE 3
------------------------------------------------------------

Input:

x = 2
n = -2

Expected:

0.25

------------------------------------------------------------

NEGATIVE CASE:

2^-2
= (1/2)^2

Now recursion becomes:

myPow1(0.5,2)

→ myPow1(0.25,1)

    → 0.25 * myPow1(0.0625,0)

            → 1

------------------------------------------------------------

BACKTRACKING:

0.25 * 1 = 0.25

Answer = 0.25

------------------------------------------------------------
TIME COMPLEXITY
------------------------------------------------------------

At every step:

power becomes half.

Example:

1024
512
256
128
64
32
16
8
4
2
1

So complexity:

O(log n)

------------------------------------------------------------
SPACE COMPLEXITY
------------------------------------------------------------

Recursive stack depth:

O(log n)

------------------------------------------------------------
MOST IMPORTANT INTERVIEW POINTS
------------------------------------------------------------

1. Even powers only reduce problem.
2. Odd powers actually build answer.
3. Multiplication happens during BACKTRACKING.
4. Recursive calls WAIT for answers.
5. Power halves every step.
6. Use long to avoid overflow.

------------------------------------------------------------
PATTERN RECOGNITION
------------------------------------------------------------

If question involves:

1. very large powers
2. modular exponentiation
3. repeated squaring
4. x^n

Think:

BINARY EXPONENTIATION

------------------------------------------------------------
FINAL CORE UNDERSTANDING
------------------------------------------------------------

Binary exponentiation works because:

1. Even powers can be compressed:
   x^n = (x²)^(n/2)

2. Odd powers leave one extra x:
   x^n = x × (x²)^((n-1)/2)

3. Every recursive step halves power.

That reduces complexity from:

O(n)

to:

O(log n)


class Solution {

    public double myPow(double x, int n) {

        long power = n;

        return myPow1(x, power);
    }

    public static double myPow1(double x, long n) {

        if(n == 0){
            return 1;
        }

        if(n < 0){
            return myPow1(1 / x, -n);
        }

        if(n % 2 == 0){
            return myPow1(x * x, n / 2);
        }

        return x * myPow1(x * x, (n - 1) / 2);
    }
}



WHY WE USED LONG INSTEAD OF INT

Problem happens with:

Integer.MIN_VALUE

Value:

-2147483648

Now suppose:

int n = Integer.MIN_VALUE;

and we do:

-n

Expected:

2147483648

BUT int range is only:

-2147483648 to 2147483647

So:

2147483648 is OUTSIDE int range.

Overflow happens.

--------------------------------------------------

ACTUAL INTERNAL BEHAVIOR

int n = Integer.MIN_VALUE;

System.out.println(-n);

Output:

-2147483648

STILL NEGATIVE.

Because internally integers use:
Two's Complement Binary Representation.

There is no positive equivalent available
inside int range for MIN_VALUE.

--------------------------------------------------

WHY THIS IS DANGEROUS

Our recursion does:

myPow1(1/x, -n)

But if:

-n

is STILL NEGATIVE because of overflow,
then recursion becomes incorrect.

Can cause:
1. Infinite recursion
2. Wrong answers

--------------------------------------------------

SOLUTION

Convert int -> long FIRST.

long power = n;

Now long range is huge, so:

-power

works safely.

--------------------------------------------------

NEGATIVE POWER LOGIC

Formula:

x^(-n) = 1 / (x^n)

Example:

2^-3
= 1/(2^3)
= 1/8
= 0.125

So algorithm does:

1. invert x
2. make power positive

Example:

myPow(2, -3)

becomes:

myPow(0.5, 3)