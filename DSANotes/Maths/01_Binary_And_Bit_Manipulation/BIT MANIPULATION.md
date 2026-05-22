========================================
BIT MANIPULATION NOTES — PART 1 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Binary Basics
2. Decimal ↔ Binary
3. MSB / LSB / Set Bits
4. Power of 2
5. Subsets Using Binary
6. Count Bits DP
7. Core Bit Operations
8. XOR Properties

========================================
1. WHY BINARY EXISTS
========================================

Computers internally understand:
- ON
- OFF

Represented as:
- 1
- 0

So computers use:
# Binary Number System

----------------------------------------
DECIMAL vs BINARY
----------------------------------------

1  -> 1
2  -> 10
3  -> 11
4  -> 100
5  -> 101

----------------------------------------
IMPORTANT INTUITION
----------------------------------------

Binary is:
# powers of 2 representation

Example:

13 = 8 + 4 + 1

Binary:
1101

Because:

1×8 + 1×4 + 0×2 + 1×1

========================================
2. DECIMAL TO BINARY
========================================

CODE:

public static String DecimalToBinary(int n) {

    String s = "";

    while (n > 0) {

        int rem = n % 2;

        s = rem + s;

        n = n / 2;
    }

    return s;
}

----------------------------------------
CORE INTUITION
----------------------------------------

Binary is:
# Base 2

So:
- divide by 2 repeatedly
- collect remainders

Remainders become binary digits.

----------------------------------------
DRY RUN
----------------------------------------

Convert:
13 -> Binary

STEP 1

13 % 2 = 1

Binary:
1

n = 6

----------------

STEP 2

6 % 2 = 0

Binary:
01

n = 3

----------------

STEP 3

3 % 2 = 1

Binary:
101

n = 1

----------------

STEP 4

1 % 2 = 1

Binary:
1101

DONE.

----------------------------------------
BUILT IN METHOD
----------------------------------------

Integer.toBinaryString(n)

========================================
3. BINARY TO DECIMAL
========================================

CODE:

public static int BinaryToDecimal(String s) {

    int sum = 0;

    int pow = 0;

    for (int i = s.length() - 1; i >= 0; i--) {

        int bit = s.charAt(i) - '0';

        sum += bit * Math.pow(2, pow);

        pow++;
    }

    return sum;
}

----------------------------------------
CORE INTUITION
----------------------------------------

Each binary position stores:
# power of 2 contribution

Example:

1101

1×8 + 1×4 + 0×2 + 1×1

= 13

----------------------------------------
BUILT IN METHOD
----------------------------------------

Integer.parseInt(s,2)

========================================
4. MSB / LSB / SET BITS
========================================

CODE:

System.out.println("MSB:" + s.charAt(0));

System.out.println("LSB:" + s.charAt(s.length() - 1));

System.out.println(
Integer.bitCount(Integer.parseInt(s, 2))
);

----------------------------------------
MSB
----------------------------------------

Most Significant Bit

Leftmost bit.

Highest power contribution.

Example:

1101

MSB = 1

----------------------------------------
LSB
----------------------------------------

Least Significant Bit

Rightmost bit.

Lowest power contribution.

Example:

1101

LSB = 1

----------------------------------------
SET BITS
----------------------------------------

Bits having value:
1

Example:

1101

Set Bits:
3

----------------------------------------
IMPORTANT USES
----------------------------------------

Used in:
- DP
- subsets
- masks
- optimization
- parity
- bit tricks

========================================
5. POWER OF 2
========================================

VISUAL METHOD:

Integer.bitCount(x) == 1

----------------------------------------
INTUITION
----------------------------------------

Power of 2 numbers always have:
# exactly one set bit

Examples:

1  -> 1
2  -> 10
4  -> 100
8  -> 1000

----------------------------------------
EFFICIENT METHOD
----------------------------------------

(x & (x-1)) == 0

----------------------------------------
DEEP INTUITION
----------------------------------------

Example:

8 = 1000
7 = 0111

AND:

1000
0111
----
0000

Result:
0

----------------------------------------
WHY THIS WORKS
----------------------------------------

Subtracting 1:
- flips rightmost set bit
- makes all right bits 1

Example:

1000
0111

No common set bits remain.

========================================
6. SUBSETS USING BINARY
========================================

CODE:

for(int i=0;i<(1<<n);i++){

    for(int j=0;j<n;j++){

        if((i & (1<<j)) != 0){

            // include element
        }
    }
}

----------------------------------------
MOST IMPORTANT BITMASKING IDEA
----------------------------------------

Each bit represents:
# whether element selected or not

----------------------------------------
EXAMPLE
----------------------------------------

ABC

n = 3

Total subsets:

2^3 = 8

Masks:

000 -> {}
001 -> {C}
010 -> {B}
011 -> {BC}
100 -> {A}
101 -> {AC}
110 -> {AB}
111 -> {ABC}

----------------------------------------
WHY 2^n ?
----------------------------------------

Every element has:
- take
- not take

2 choices.

For n elements:

2 × 2 × 2 ...

= 2^n

----------------------------------------
IMPORTANT CHECK
----------------------------------------

(i & (1<<j))

Checks whether:
# jth bit is ON

Meaning:
# include element

========================================
7. COUNT BITS DP
========================================

CODE:

arr[i] = arr[i >> 1] + (i & 1);

----------------------------------------
CORE INTUITION
----------------------------------------

Right shift:

i >> 1

removes last bit.

----------------------------------------
EXAMPLE
----------------------------------------

13:

1101

13 >> 1:

110

= 6

----------------------------------------
OBSERVATION
----------------------------------------

Set bits in:

13

=

set bits in:
6

+

last bit of 13

----------------------------------------
LAST BIT
----------------------------------------

(i & 1)

Returns:
- 1 if odd
- 0 if even

Because:
# LSB decides parity

----------------------------------------
FINAL FORMULA
----------------------------------------

countBits(i)
=
countBits(i/2)
+
lastBit

VERY important DP observation.

========================================
8. CORE BIT OPERATIONS
========================================

----------------------------------------
GET ith BIT
----------------------------------------

((n & (1<<i)) >> i)

INTUITION:

1<<i creates mask.

Example:

i = 2

0001 << 2

0100

AND operation keeps only ith bit.

----------------------------------------
SET ith BIT
----------------------------------------

n | (1<<i)

Forces ith bit to:
1

----------------------------------------
REMOVE ith BIT
----------------------------------------

n & ~(1<<i)

Creates:
0 at ith position

AND removes it.

----------------------------------------
TOGGLE ith BIT
----------------------------------------

n ^ (1<<i)

XOR:
- flips bit if 1
- keeps same if 0

----------------------------------------
EVEN / ODD
----------------------------------------

(n & 1)

LSB determines parity.

0 -> Even
1 -> Odd

----------------------------------------
MULTIPLY BY 2
----------------------------------------

n << 1

Every left shift:
×2

----------------------------------------
DIVIDE BY 2
----------------------------------------

n >> 1

Every right shift:
÷2

----------------------------------------
REMOVE RIGHTMOST SET BIT
----------------------------------------

n & (n-1)

VERY famous trick.

----------------------------------------
EXTRACT RIGHTMOST SET BIT
----------------------------------------

n & (-n)

Keeps only lowest set bit.

VERY important in advanced bit tricks.

========================================
9. XOR IDENTITIES
========================================

a ^ a = 0

a ^ 0 = a

a ^ b = b ^ a

(a ^ b) ^ c = a ^ (b ^ c)

----------------------------------------
WHY XOR IMPORTANT?
----------------------------------------

Used in:
- unique element problems
- swapping
- subsets
- prefix XOR
- trie XOR problems
- bitmask DP

VERY important in CP.

========================================
10. SWAP WITHOUT TEMP
========================================

CODE:

a = a ^ b;
b = a ^ b;
a = a ^ b;

----------------------------------------
INTUITION
----------------------------------------

XOR stores difference information.

Properties:

a ^ b ^ b = a

Because:
b ^ b = 0

So original values recoverable.

========================================
MOST IMPORTANT TAKEAWAYS
========================================

1. Binary = powers of 2
2. Bitmask = selection representation
3. XOR useful for reversible operations
4. Shifts = fast multiply/divide by 2
5. Power of 2 numbers contain one set bit
6. Subsets can be generated using masks
7. DP + bits often combine together
8. Bit tricks reduce complexity massively

========================================

========================================
BIT MANIPULATION NOTES — PART 2 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Range Bitwise AND
2. Min Flips Problem
3. XOR Deep Intuition
4. Rightmost Set Bit Tricks
5. Prefix XOR Thinking
6. Important Bitmask Patterns
7. Advanced Bit Observations
8. CP Recognition Patterns

========================================
1. RANGE BITWISE AND
========================================

QUESTION:

Given:
left and right

Find:

left & (left+1) & ... & right

----------------------------------------
CODE
----------------------------------------

public static int rangeBitwiseAnd(int left, int right) {

    int shifts = 0;

    while (left != right) {

        left = left >> 1;

        right = right >> 1;

        shifts++;
    }

    int ans = left << shifts;

    return ans;
}

========================================
CORE INTUITION
========================================

AND operation keeps:
# only common stable bits

If any bit changes in range:
that bit eventually becomes:
0

----------------------------------------
EXAMPLE
----------------------------------------

5 -> 101
6 -> 110
7 -> 111

AND:

101
110
111
---
100

Answer:
4

----------------------------------------
WHY?
----------------------------------------

Last bits vary.

Changing bits eventually become:
0 in AND.

Only stable common prefix survives.

----------------------------------------
IMPORTANT OBSERVATION
----------------------------------------

Bitwise AND of range:
# preserves common left prefix only

Everything changing becomes:
0

========================================
WHY SHIFTING WORKS
========================================

We keep removing:
# unstable right bits

until:
left == right

Meaning:
# common prefix found

----------------------------------------
EXAMPLE
----------------------------------------

5 = 101
7 = 111

SHIFT 1:

10
11

Not equal.

SHIFT 2:

1
1

Equal.

Common prefix:
1

Now restore shifts:

1 << 2

100

= 4

DONE.

========================================
2. MIN FLIPS PROBLEM
========================================

QUESTION:

Minimum flips needed so that:

(a OR b) == c

========================================
CODE
========================================

public static int minFlips(int a, int b, int c) {

    int flips = 0;

    while (a > 0 || b > 0 || c > 0) {

        int aBit = a & 1;

        int bBit = b & 1;

        int cBit = c & 1;

        if (cBit == 1) {

            if (aBit == 0 && bBit == 0) {

                flips++;
            }

        } else {

            flips = flips + aBit + bBit;
        }

        a >>= 1;
        b >>= 1;
        c >>= 1;
    }

    return flips;
}

========================================
MOST IMPORTANT INTUITION
========================================

We solve:
# one bit at a time

Because:
bitwise operations independent per bit.

----------------------------------------
CASE 1
----------------------------------------

cBit = 1

Need:

aBit OR bBit = 1

Problem only when:

0 OR 0 = 0

Need one flip.

----------------------------------------
CASE 2
----------------------------------------

cBit = 0

Need:

aBit OR bBit = 0

Meaning:
both bits must become:
0

----------------------------------------
SUBCASES
----------------------------------------

1 OR 1

Need:
2 flips

----------------

1 OR 0

Need:
1 flip

----------------

0 OR 1

Need:
1 flip

----------------------------------------
IMPORTANT OBSERVATION
----------------------------------------

When cBit = 0:

Number of flips directly equals:

aBit + bBit

Because:
1 contributes one required flip.

========================================
3. XOR DEEP INTUITION
========================================

========================================
XOR RULES
========================================

0 ^ 0 = 0

1 ^ 1 = 0

0 ^ 1 = 1

1 ^ 0 = 1

----------------------------------------
MOST IMPORTANT INTUITION
----------------------------------------

XOR tells:
# whether bits differ

Same:
0

Different:
1

========================================
VERY IMPORTANT XOR IDENTITIES
========================================

a ^ a = 0

a ^ 0 = a

a ^ b = b ^ a

(a ^ b) ^ c = a ^ (b ^ c)

========================================
WHY a ^ a = 0 ?
========================================

Same bits cancel out.

Example:

1010
1010
----
0000

========================================
WHY XOR USEFUL?
========================================

Because repeated same values:
# disappear

Used in:
- unique element
- prefix xor
- xor subarrays
- maximum xor
- tries

VERY important in CP.

========================================
4. RIGHTMOST SET BIT TRICKS
========================================

========================================
REMOVE RIGHTMOST SET BIT
========================================

n & (n-1)

----------------------------------------
EXAMPLE
----------------------------------------

12 = 1100

11 = 1011

AND:

1100
1011
----
1000

Removed lowest set bit.

----------------------------------------
WHY?
----------------------------------------

Subtracting 1:
- flips lowest set bit
- turns right bits into 1

AND removes that bit.

========================================
EXTRACT RIGHTMOST SET BIT
========================================

n & (-n)

----------------------------------------
EXAMPLE
----------------------------------------

12 = 1100

-12 in binary two's complement:

0100

AND:

1100
0100
----
0100

Result:
4

----------------------------------------
IMPORTANT USES
----------------------------------------

Used in:
- Fenwick Tree
- bitmask DP
- lowbit operations

VERY important trick.

========================================
5. PREFIX XOR THINKING
========================================

MOST IMPORTANT OBSERVATION:

Prefix XOR behaves like:
# prefix sum

----------------------------------------
FORMULA
----------------------------------------

If:

prefix[i] =
xor from 0 to i

Then:

L to R xor =

prefix[R] ^ prefix[L-1]

----------------------------------------
WHY?
----------------------------------------

Repeated common parts cancel.

Because:

a ^ a = 0

----------------------------------------
EXAMPLE
----------------------------------------

Array:

2 3 5

Prefix XOR:

2
2^3 = 1
1^5 = 4

Now XOR from index 1 to 2:

prefix[2] ^ prefix[0]

4 ^ 2

= 6

Correct:
3 ^ 5 = 6

========================================
6. IMPORTANT BITMASK PATTERNS
========================================

----------------------------------------
CHECK ith BIT
----------------------------------------

(n & (1<<i))

----------------------------------------
SET ith BIT
----------------------------------------

n | (1<<i)

----------------------------------------
REMOVE ith BIT
----------------------------------------

n & ~(1<<i)

----------------------------------------
TOGGLE ith BIT
----------------------------------------

n ^ (1<<i)

----------------------------------------
ALL BITS ON TILL n
----------------------------------------

(1<<n)-1

Example:

n = 4

0001 << 4

10000

-1

1111

========================================
7. IMPORTANT CP OBSERVATIONS
========================================

----------------------------------------
POWER OF 2
----------------------------------------

Only one set bit.

----------------------------------------
ODD / EVEN
----------------------------------------

LSB decides parity.

----------------------------------------
LEFT SHIFT
----------------------------------------

×2

----------------------------------------
RIGHT SHIFT
----------------------------------------

÷2

----------------------------------------
BITMASK
----------------------------------------

Represents:
# subset selection state

VERY important in:
- DP
- recursion
- graph problems

========================================
8. COMMON CP QUESTION TYPES
========================================

----------------------------------------
XOR QUESTIONS
----------------------------------------

- unique number
- xor range
- maximum xor
- xor subarray

----------------------------------------
BITMASK QUESTIONS
----------------------------------------

- subsets
- DP states
- traveling salesman
- masks

----------------------------------------
BIT TRICK QUESTIONS
----------------------------------------

- power of 2
- count bits
- parity
- flipping bits

----------------------------------------
RANGE BIT QUESTIONS
----------------------------------------

- AND
- OR
- XOR ranges

========================================
9. MOST IMPORTANT FINAL INTUITIONS
========================================

10. Bit operations work independently per bit
11. XOR represents difference
12. AND keeps common stable bits
13. OR spreads 1s
14. Bitmasks represent subset states
15. Shifts manipulate powers of 2
16. Repeated XOR cancels values
17. Many CP optimizations rely on bit tricks

========================================
BIT MANIPULATION MASTERY GOAL
========================================

When seeing any question:

Immediately think:
- Can bits represent state?
- Can XOR cancel things?
- Can mask store subset?
- Can shifting optimize?
- Can AND/OR simplify logic?

THAT is real bit manipulation thinking.

========================================


========================================
BIT MANIPULATION NOTES — PART 3 🔥
========================================

ADVANCED INTUITION + CP THINKING

TOPICS COVERED:
1. XOR Prefix Pattern
2. Single Number Problems
3. Missing Number Logic
4. Maximum XOR Thinking
5. Binary Trie Intuition
6. Bitmask DP Foundation
7. Submask Enumeration
8. Common CP Patterns
9. Recognition Tricks
10. Important Mistakes

========================================
1. PREFIX XOR PATTERN
========================================

MOST IMPORTANT OBSERVATION:

XOR behaves similar to:
# Prefix Sum

Because:

a ^ a = 0

So repeated parts cancel.

----------------------------------------
FORMULA
----------------------------------------

prefix[i] =
xor from 0 to i

Then:

xor(L → R)

=

prefix[R] ^ prefix[L-1]

----------------------------------------
WHY THIS WORKS
----------------------------------------

Common prefix cancels.

Example:

Array:

2 3 5 6

Prefix XOR:

2
2^3 = 1
1^5 = 4
4^6 = 2

Now find XOR from index:
1 →3

prefix[3] ^ prefix[0]

2 ^ 2

= 0

Actual:

3 ^ 5 ^ 6

= 0

Correct.

----------------------------------------
IMPORTANT USES
----------------------------------------

Used in:
- XOR subarrays
- parity problems
- range xor queries
- hashing tricks

VERY important.

========================================
2. SINGLE NUMBER PROBLEM
========================================

QUESTION:

Every element appears twice.
One element appears once.

Find unique element.

----------------------------------------
CODE
----------------------------------------

int ans = 0;

for(int x : nums){

    ans ^= x;
}

return ans;

========================================
CORE INTUITION
========================================

Same numbers cancel.

Because:

a ^ a = 0

Example:

2 ^ 3 ^ 2 ^ 5 ^ 3

↓

2^2 cancels

3^3 cancels

Remaining:

5

DONE.

----------------------------------------
MOST IMPORTANT IDEA
----------------------------------------

XOR is:
# cancellation operator

VERY important mindset.

========================================
3. MISSING NUMBER
========================================

QUESTION:

Numbers:
0 → n

One missing.

Find it.

----------------------------------------
CODE
----------------------------------------

int xor = 0;

for(int i=0;i<=n;i++){

    xor ^= i;
}

for(int x : nums){

    xor ^= x;
}

return xor;

========================================
INTUITION
========================================

All matching numbers cancel.

Missing number survives.

----------------------------------------
EXAMPLE
----------------------------------------

Expected:

0 1 2 3 4

Array:

0 1 3 4

XOR all:

0^1^2^3^4^0^1^3^4

Everything cancels except:

2

DONE.

========================================
4. MAXIMUM XOR THINKING
========================================

MOST IMPORTANT XOR PROPERTY:

XOR becomes large when:
# left bits differ

----------------------------------------
EXAMPLE
----------------------------------------

1010
0101
----
1111

Huge XOR.

----------------------------------------
IMPORTANT OBSERVATION
----------------------------------------

To maximize XOR:
# maximize leftmost differing bits

VERY important in:
- maximum xor pair
- trie xor problems

========================================
5. BINARY TRIE INTUITION
========================================

ADVANCED CP TOPIC

Used for:
- maximum xor pair
- xor queries
- online xor problems

----------------------------------------
MAIN IDEA
----------------------------------------

Store numbers bit-by-bit.

Each level:
- 0 branch
- 1 branch

Like binary tree.

----------------------------------------
MAX XOR INTUITION
----------------------------------------

Suppose current bit:
1

To maximize XOR:
need opposite bit:
0

Because:

1 ^ 0 = 1

So trie greedily searches:
# opposite bit first

VERY important advanced concept.

========================================
6. BITMASK DP FOUNDATION
========================================

MOST IMPORTANT IDEA:

Mask represents:
# subset state

----------------------------------------
EXAMPLE
----------------------------------------

Suppose:

4 cities

Mask:

1011

Means:

city:
0 visited
1 visited
3 visited

city:
2 not visited

----------------------------------------
IMPORTANT USES
----------------------------------------

Used in:
- Traveling Salesman
- subset DP
- assignment problems
- game DP

VERY important advanced CP area.

========================================
7. SUBMASK ENUMERATION
========================================

VERY famous CP trick.

----------------------------------------
CODE
----------------------------------------

for(int sub = mask;
    sub > 0;
    sub = (sub-1) & mask){

}

========================================
CORE INTUITION
========================================

Generates:
# all submasks efficiently

----------------------------------------
WHY IMPORTANT?
----------------------------------------

Many DP transitions need:
# all subsets of current set

This trick avoids:
O(2^n × 2^n)

Huge optimization.

========================================
8. COMMON BIT PATTERNS
========================================

----------------------------------------
POWER OF 2
----------------------------------------

(x & (x-1)) == 0

----------------------------------------
CHECK EVEN / ODD
----------------------------------------

(n & 1)

----------------------------------------
REMOVE LOWEST SET BIT
----------------------------------------

n & (n-1)

----------------------------------------
EXTRACT LOWEST SET BIT
----------------------------------------

n & (-n)

----------------------------------------
COUNT SET BITS
----------------------------------------

Integer.bitCount(n)

----------------------------------------
MULTIPLY BY 2
----------------------------------------

n << 1

----------------------------------------
DIVIDE BY 2
----------------------------------------

n >> 1

========================================
9. IMPORTANT CP RECOGNITION
========================================

WHEN TO THINK XOR?
----------------------------------------

- cancellation
- parity
- unique element
- opposite bits
- range xor

----------------------------------------
WHEN TO THINK BITMASK?
----------------------------------------

- subsets
- visited states
- combinations
- DP states

----------------------------------------
WHEN TO THINK SHIFTING?
----------------------------------------

- powers of 2
- binary operations
- fast multiplication/division

----------------------------------------
WHEN TO THINK AND?
----------------------------------------

- stable common bits
- masking
- filtering bits

----------------------------------------
WHEN TO THINK OR?
----------------------------------------

- forcing bits ON
- merging masks

========================================
10. IMPORTANT MISTAKES
========================================

----------------------------------------
MISTAKE 1
----------------------------------------

Forgetting:

1 << i

creates mask.

NOT actual ith bit directly.

----------------------------------------
MISTAKE 2
----------------------------------------

Using:

(n & (1<<i))

and expecting:
0 or 1

Actually returns:
0 or power of 2

Need:

((n & (1<<i)) >> i)

for exact bit value.

----------------------------------------
MISTAKE 3
----------------------------------------

Confusing:
left shift and right shift.

Left:
×2

Right:
÷2

----------------------------------------
MISTAKE 4
----------------------------------------

Forgetting operator precedence.

Always use brackets:

(n & (1<<i))

========================================
11. MOST IMPORTANT FINAL INTUITION
========================================

Bit Manipulation is mainly about:

# representing information compactly

AND

# exploiting binary properties

----------------------------------------
BITS CAN REPRESENT:
----------------------------------------

- subsets
- states
- parity
- paths
- flags
- permissions

VERY powerful abstraction.

========================================
12. REAL BIT MANIPULATION MASTERY
========================================

When seeing question ask:

1. Can binary represent state?
2. Can XOR cancel duplicates?
3. Can mask compress subsets?
4. Can shifting optimize?
5. Can bit tricks reduce complexity?
6. Can bits replace nested loops?

THAT is real CP bit thinking.

========================================
END OF BIT MANIPULATION NOTES 🔥
========================================