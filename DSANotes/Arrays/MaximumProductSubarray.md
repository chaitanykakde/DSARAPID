/*
====================================================================
===================== MAXIMUM PRODUCT SUBARRAY ======================
====================================================================

Question:
Given an integer array,
find the contiguous subarray having the maximum product.

--------------------------------------------------------------------
EXAMPLE
--------------------------------------------------------------------

nums = [2,3,-2,4]

Possible subarrays:

[2]           -> 2
[2,3]         -> 6
[2,3,-2]      -> -12
[3,-2,4]      -> -24
[4]           -> 4

Maximum product = 6


====================================================================
====================== WHY THIS QUESTION IS HARD ====================
====================================================================

This problem looks similar to:
Maximum Sum Subarray (Kadane)

BUT product behaves VERY differently.

Because:

1. Negative × Negative = Positive
2. Zero breaks product chain
3. Small negative can suddenly become huge positive

So normal Kadane logic does NOT work directly.


====================================================================
========================== CORE INTUITION ===========================
====================================================================

Negative numbers flip sign.

This means:

A bad negative product NOW
may become huge positive LATER.

That is the MOST IMPORTANT observation.


====================================================================
===================== KEY OBSERVATION ABOUT NEGATIVES ===============
====================================================================

If array contains:

EVEN number of negatives
-> final product becomes POSITIVE

ODD number of negatives
-> final product becomes NEGATIVE


Example:

[-1,-2,-3,-4]

Product:
24

Because:
4 negatives -> EVEN


Example:

[-1,-2,-3]

Product:
-6

Because:
3 negatives -> ODD


====================================================================
===================== MAIN TRICK OF THIS SOLUTION ===================
====================================================================

We scan from BOTH directions.

1. Prefix scan  -> Left to Right
2. Suffix scan  -> Right to Left

Why ?

Because if odd negatives exist,
we may need to remove:

1. Leftmost negative
OR
2. Rightmost negative

Scanning from both sides automatically handles both cases.


====================================================================
======================== VERY IMPORTANT IDEA ========================
====================================================================

Maximum product subarray after odd negatives is obtained by:

Either:
Removing prefix till first negative

OR

Removing suffix after last negative


Scanning both directions captures both possibilities.


====================================================================
========================= COMPLETE FLOW =============================
====================================================================

nums = [2,3,-2,4]


====================================================================
========================= INITIALIZATION ============================
====================================================================

max  = -∞
pref = 1
suff = 1


====================================================================
=========================== ITERATION ===============================
====================================================================

------------------------------------------------
i = 0
------------------------------------------------

PREFIX:

pref = 1 * nums[0]
     = 1 * 2
     = 2

SUFFIX:

suff = 1 * nums[3]
     = 1 * 4
     = 4

max = max(-∞, max(2,4))
    = 4


------------------------------------------------
i = 1
------------------------------------------------

PREFIX:

pref = 2 * 3
     = 6

SUFFIX:

suff = 4 * (-2)
     = -8

max = max(4, max(6,-8))
    = 6


------------------------------------------------
i = 2
------------------------------------------------

PREFIX:

pref = 6 * (-2)
     = -12

SUFFIX:

suff = -8 * 3
     = -24

max remains:
6


------------------------------------------------
i = 3
------------------------------------------------

PREFIX:

pref = -12 * 4
     = -48

SUFFIX:

suff = -24 * 2
     = -48

max = 6


FINAL ANSWER:
6


====================================================================
========================= ZERO HANDLING =============================
====================================================================

VERY IMPORTANT.

Zero destroys multiplication chain.

Example:

[2,3,0,4,5]

After zero:

previous product becomes useless.

So restart multiplication from 1.


That is why:

if(pref == 0)
    pref = 1;

if(suff == 0)
    suff = 1;


====================================================================
===================== WHY RESET TO 1 ? ==============================
====================================================================

Because:

Anything multiplied by 0
remains 0.

Without reset,
future products can never recover.


Example:

0 * 4 * 5 = 0

Wrong.

We want:
4 * 5 = 20

So restart after zero.


====================================================================
======================== VISUAL UNDERSTANDING =======================
====================================================================

Think of product chain like rope tension.

Zero cuts the rope.

After cut,
you must start a new rope.


====================================================================
==================== IMPORTANT NEGATIVE CASE ========================
====================================================================

nums = [-1,-2,-3]

Total product:
-6

But maximum subarray is:
[-2,-3]
= 6

How obtained ?

By removing LEFT negative.


Now:

nums = [-1,-2,-3,-4,-5]

Maximum product obtained by:
removing RIGHT negative.

Thus:
Need BOTH prefix and suffix scans.


====================================================================
======================== DRY RUN TABLE ==============================
====================================================================

nums = [2,3,-2,4]

----------------------------------------------------------------------------
i         pref calculation        pref        suff calculation       suff
----------------------------------------------------------------------------
0         1*2                     2           1*4                    4
1         2*3                     6           4*(-2)                -8
2         6*(-2)                 -12          -8*3                  -24
3         -12*4                 -48           -24*2                -48
----------------------------------------------------------------------------

Maximum = 6


====================================================================
======================== WHY THIS WORKS =============================
====================================================================

Prefix scan handles:
Removing suffix negatives

Suffix scan handles:
Removing prefix negatives

Together they cover all maximum possibilities.


====================================================================
====================== IMPORTANT OBSERVATION ========================
====================================================================

Unlike SUM problems:

Negative products can later become positive.

So we cannot simply discard negatives immediately.


This is why:
Maximum Product Subarray is harder than Kadane.


====================================================================
======================== TIME COMPLEXITY ============================
====================================================================

Single traversal.

O(n)


====================================================================
======================== SPACE COMPLEXITY ===========================
====================================================================

Only variables used.

O(1)


====================================================================
======================== COMMON MISTAKES ============================
====================================================================

1. Using normal Kadane logic

Does not work for products.


------------------------------------------------

2. Forgetting zero reset

Then future products stay zero forever.


------------------------------------------------

3. Ignoring suffix traversal

Prefix alone misses some cases.


------------------------------------------------

4. Initializing max = 0

Fails for all negative arrays.


Correct:
Integer.MIN_VALUE


====================================================================
===================== WHY PREFIX + SUFFIX WORKS =====================
====================================================================

If odd negatives exist,
one negative must be excluded.

Possible exclusions:

1. Left side negative
2. Right side negative

Prefix and suffix scans naturally check both.


====================================================================
======================== MEMORY TRICK ===============================
====================================================================

Think:

Negative numbers flip the world upside down.

So scan from BOTH directions
to catch every possible positive flip.


OR

"Odd negatives require removing one side."


====================================================================
====================== FINAL UNDERSTANDING ==========================
====================================================================

1. Product behavior is tricky due to negatives.
2. Zero breaks product chain.
3. Odd negatives require removing one side.
4. Prefix scan handles one possibility.
5. Suffix scan handles the other.
6. Maximum among all products is answer.

Optimal Complexity:
Time  -> O(n)
Space -> O(1)

====================================================================
*/