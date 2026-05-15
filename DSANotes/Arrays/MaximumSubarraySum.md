/*
====================================================================
========================= KADANE'S ALGORITHM ========================
===================== MAXIMUM SUBARRAY SUM ==========================
====================================================================

Question:
Given an integer array,
find the contiguous subarray having the maximum sum.

--------------------------------------------------------------------
EXAMPLE
--------------------------------------------------------------------

arr = [-2,1,-3,4,-1,2,1,-5,4]

Possible best subarray:

[4,-1,2,1]

Sum:
4 + (-1) + 2 + 1 = 6

Answer:
6


====================================================================
========================== CORE INTUITION ===========================
====================================================================

At every index we make ONE decision:

Should I:
1. Continue previous subarray ?
OR
2. Start a brand new subarray from current element ?

This is the ENTIRE Kadane's Algorithm.


====================================================================
====================== MOST IMPORTANT IDEA ==========================
====================================================================

If previous sum is helping,
continue it.

If previous sum is hurting,
discard it and start fresh.


====================================================================
===================== MATHEMATICAL DECISION =========================
====================================================================

At every index:

sum =
MAX(
    current element alone,
    current element + previous sum
)

Code:

sum = Math.max(arr[i], arr[i] + sum);

Meaning:

Either:
start new subarray

OR

extend previous subarray.


====================================================================
====================== VERY IMPORTANT INTUITION =====================
====================================================================

Negative cumulative sum is dangerous.

Because:

Adding a negative running sum
will only decrease future answers.

So if running sum becomes bad,
restart from current element.


====================================================================
======================== VISUAL UNDERSTANDING =======================
====================================================================

Imagine carrying a bag of numbers.

If bag weight becomes negative,
throw it away and start fresh.

Because carrying negative weight
can never help maximize future sum.


====================================================================
========================= COMPLETE FLOW =============================
====================================================================

arr = [-2,1,-3,4,-1,2,1,-5,4]


====================================================================
===================== INITIALIZATION ================================
====================================================================

max = arr[0] = -2
sum = arr[0] = -2

IMPORTANT:
We initialize with arr[0]
instead of 0.

This handles:
ALL NEGATIVE ARRAYS correctly.


====================================================================
========================= ITERATION =================================
====================================================================

------------------------------------------------
INDEX 1
------------------------------------------------

arr[i] = 1

OPTION 1:
Start new subarray:
1

OPTION 2:
Continue old subarray:
1 + (-2) = -1

Choose maximum:
1

sum = 1

max = max(-2,1)
    = 1


------------------------------------------------
INDEX 2
------------------------------------------------

arr[i] = -3

OPTION 1:
-3

OPTION 2:
-3 + 1 = -2

Choose:
-2

sum = -2

max = max(1,-2)
    = 1


------------------------------------------------
INDEX 3
------------------------------------------------

arr[i] = 4

OPTION 1:
4

OPTION 2:
4 + (-2) = 2

Choose:
4

IMPORTANT:
Previous sum was hurting us,
so we START NEW subarray here.

sum = 4

max = 4


------------------------------------------------
INDEX 4
------------------------------------------------

arr[i] = -1

OPTION 1:
-1

OPTION 2:
-1 + 4 = 3

Choose:
3

sum = 3

max = 4


------------------------------------------------
INDEX 5
------------------------------------------------

arr[i] = 2

OPTION 1:
2

OPTION 2:
2 + 3 = 5

Choose:
5

sum = 5

max = 5


------------------------------------------------
INDEX 6
------------------------------------------------

arr[i] = 1

OPTION 1:
1

OPTION 2:
1 + 5 = 6

Choose:
6

sum = 6

max = 6


------------------------------------------------
INDEX 7
------------------------------------------------

arr[i] = -5

OPTION 1:
-5

OPTION 2:
-5 + 6 = 1

Choose:
1

sum = 1

max = 6


------------------------------------------------
INDEX 8
------------------------------------------------

arr[i] = 4

OPTION 1:
4

OPTION 2:
4 + 1 = 5

Choose:
5

sum = 5

max = 6


FINAL ANSWER:
6


====================================================================
======================== DRY RUN TABLE ==============================
====================================================================

----------------------------------------------------------------------------
INDEX       VALUE       CURRENT SUM DECISION           SUM         MAX
----------------------------------------------------------------------------
0           -2          initial                        -2          -2
1            1          max(1,1-2)                    1            1
2           -3          max(-3,-3+1)                 -2           1
3            4          max(4,4-2)                    4            4
4           -1          max(-1,-1+4)                  3            4
5            2          max(2,2+3)                    5            5
6            1          max(1,1+5)                    6            6
7           -5          max(-5,-5+6)                  1            6
8            4          max(4,4+1)                    5            6
----------------------------------------------------------------------------


====================================================================
======================== WHY THIS WORKS =============================
====================================================================

At every position,
we maintain:

"Maximum subarray sum ending at current index"

NOT global answer directly.

Then global maximum is updated continuously.


====================================================================
==================== DEEPER UNDERSTANDING ===========================
====================================================================

Suppose current running sum is:

-100

Future element:
50

If we continue:

50 + (-100)
= -50

Terrible.

Better to restart from 50 itself.

This is the heart of Kadane.


====================================================================
====================== IMPORTANT OBSERVATION ========================
====================================================================

Kadane is a:
DP (Dynamic Programming) optimization.

Because:

Current answer depends on previous answer.

Formula:

dp[i] =
max(
    arr[i],
    arr[i] + dp[i-1]
)


But instead of array,
we optimize space using variables.


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
======================== BRUTE FORCE ================================
====================================================================

Brute force:

Generate all subarrays
and calculate sums.

Total:
O(n²) or O(n³)

Kadane reduces it to:
O(n)


====================================================================
===================== ALL NEGATIVE ARRAY CASE =======================
====================================================================

Example:

[-5,-2,-8]

Correct answer:
-2

If we initialize with 0,
answer becomes wrong.

That is why:

max = arr[0]
sum = arr[0]

VERY IMPORTANT.


====================================================================
========================= COMMON MISTAKES ===========================
====================================================================

1. Initializing sum = 0

Fails for all negative arrays.


------------------------------------------------

2. Forgetting global max update

sum stores current window only,
not final answer.


------------------------------------------------

3. Thinking Kadane stores whole subarray

Basic Kadane stores only SUM.

Tracking indexes is separate extension.


------------------------------------------------

4. Resetting sum to 0 blindly

Modern Kadane is cleaner:

sum = max(arr[i], arr[i] + sum)


====================================================================
======================== MEMORY TRICK ===============================
====================================================================

Think:

"Carry previous subarray only if it helps."

OR

"If previous baggage is negative,
drop it immediately."


====================================================================
====================== FINAL UNDERSTANDING ==========================
====================================================================

At every index:

Either:
1. Start new subarray
OR
2. Extend previous subarray

Choose whichever gives larger sum.

Track best answer globally.

This greedy + DP idea creates:
Kadane's Algorithm.

Optimal Complexity:
Time  -> O(n)
Space -> O(1)

====================================================================
*/