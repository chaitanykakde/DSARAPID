/*
======================== TRAPPING RAIN WATER ========================

Question:
Given an array where each element represents building height,
find how much rain water can be trapped between buildings.

Example:
arr = [1,2,3,9,0,0,0,7]

Visualization:

                |
                |9
                |
                |
                |
        |       |       |
    |   |       |       |7
|   |   |       |       |
--------------------------------
1   2   3   9   0   0   0   7

Water trapped at indexes:
index 4 -> 7 units
index 5 -> 7 units
index 6 -> 7 units

Total = 21


====================================================================
===================== CORE INTUITION OF PROBLEM =====================
====================================================================

Water above any building depends ONLY on:

1. Tallest building on LEFT
2. Tallest building on RIGHT

Because water needs boundaries from BOTH sides.

So at every index:

waterStored =
MIN(leftMax, rightMax) - currentHeight

WHY MIN ?

Because water can only rise till the SHORTER wall.

Example:

left wall = 10
right wall = 4

Water cannot stay till height 10.
It will overflow from right side at height 4.

So:
water level = MIN(10,4) = 4


====================================================================
========================= APPROACH 1 ================================
==================== PREFIX + SUFFIX ARRAYS =========================
====================================================================

CODE:
maxWater1()

--------------------------------------------------------------------
INTUITION
--------------------------------------------------------------------

Instead of calculating leftMax and rightMax repeatedly for every index,
precompute them.

We create:

prefix[i] = maximum height from LEFT till i
suffix[i] = maximum height from RIGHT till i

Then for every index:
water = MIN(prefix[i], suffix[i]) - arr[i]

This makes lookup O(1).


--------------------------------------------------------------------
STEP-BY-STEP FLOW
--------------------------------------------------------------------

arr = [1,2,3,9,0,0,0,7]

------------------------------------------------
STEP 1 -> BUILD PREFIX MAX ARRAY
------------------------------------------------

prefix[0] = 1

prefix[i] = max(arr[i], prefix[i-1])

prefix becomes:

index:   0 1 2 3 4 5 6 7
arr:     1 2 3 9 0 0 0 7
prefix:  1 2 3 9 9 9 9 9

Meaning:
At every index,
what is tallest building seen from LEFT side.


------------------------------------------------
STEP 2 -> BUILD SUFFIX MAX ARRAY
------------------------------------------------

suffix[n-1] = arr[n-1]

suffix[i] = max(arr[i], suffix[i+1])

suffix becomes:

index:   0 1 2 3 4 5 6 7
arr:     1 2 3 9 0 0 0 7
suffix:  9 9 9 9 7 7 7 7

Meaning:
At every index,
what is tallest building seen from RIGHT side.


------------------------------------------------
STEP 3 -> CALCULATE WATER
------------------------------------------------

Formula:
water = MIN(prefix[i], suffix[i]) - arr[i]

------------------------------------------------
INDEX 4
------------------------------------------------

prefix[4] = 9
suffix[4] = 7
arr[4] = 0

water = MIN(9,7) - 0
       = 7

------------------------------------------------
INDEX 5
------------------------------------------------

water = MIN(9,7) - 0
       = 7

------------------------------------------------
INDEX 6
------------------------------------------------

water = MIN(9,7) - 0
       = 7

Total = 21


--------------------------------------------------------------------
WHY THIS APPROACH WORKS
--------------------------------------------------------------------

For every index we already know:

1. Best left boundary
2. Best right boundary

So water calculation becomes direct.


--------------------------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------------------------

Building prefix array  -> O(n)
Building suffix array  -> O(n)
Calculating answer     -> O(n)

Total:
O(n)


--------------------------------------------------------------------
SPACE COMPLEXITY
--------------------------------------------------------------------

prefix array -> O(n)
suffix array -> O(n)

Total:
O(n)


--------------------------------------------------------------------
IMPORTANT OBSERVATION
--------------------------------------------------------------------

This approach is EASY TO UNDERSTAND
but uses extra memory.

Best for:
- Interviews explanation
- First learning
- Clear visualization


====================================================================
========================= APPROACH 2 ================================
========================== TWO POINTERS =============================
====================================================================

CODE:
maxWater2()

--------------------------------------------------------------------
MOST IMPORTANT INTUITION
--------------------------------------------------------------------

In Approach 1,
we realized:

water depends on:
MIN(leftMax, rightMax)

Now observe carefully:

If left side height <= right side height,
then LEFT side is guaranteed to have a valid right boundary.

Meaning:
we can safely process LEFT side immediately.

Similarly:

If right side height < left side height,
we process RIGHT side.

This removes need of prefix/suffix arrays.


====================================================================
====================== GOLDEN TWO POINTER IDEA ======================
====================================================================

WHICHEVER SIDE IS SMALLER
CAN BE PROCESSED SAFELY.

Because opposite side already has a taller wall.


====================================================================
======================== DETAILED FLOW ==============================
====================================================================

arr = [1,2,3,9,0,0,0,7]

Initial:

l = 0
r = 7

leftMax = 0
rightMax = 0
total = 0


------------------------------------------------
STEP 1
------------------------------------------------

arr[l] = 1
arr[r] = 7

Since:
1 <= 7

Process LEFT side.

leftMax = max(0,1) = 1

No water trapped.

Move l++

------------------------------------------------
STEP 2
------------------------------------------------

arr[l] = 2
arr[r] = 7

2 <= 7

Process LEFT.

leftMax = 2

No water.

Move l++

------------------------------------------------
STEP 3
------------------------------------------------

arr[l] = 3
arr[r] = 7

3 <= 7

Process LEFT.

leftMax = 3

Move l++

------------------------------------------------
STEP 4
------------------------------------------------

arr[l] = 9
arr[r] = 7

Now:
9 > 7

Process RIGHT side.

rightMax = 7

Move r--

------------------------------------------------
STEP 5
------------------------------------------------

arr[l] = 9
arr[r] = 0

9 > 0

Process RIGHT.

rightMax = 7

Water trapped:
7 - 0 = 7

total = 7

Move r--

------------------------------------------------
STEP 6
------------------------------------------------

Again right side 0

Water = 7

total = 14

------------------------------------------------
STEP 7
------------------------------------------------

Again right side 0

Water = 7

total = 21

DONE.


====================================================================
================ WHY TWO POINTER APPROACH WORKS =====================
====================================================================

KEY LOGIC:

If arr[l] <= arr[r]

Then right side definitely contains a wall
greater than or equal to arr[l].

So water on left depends ONLY on leftMax.

Similarly:

If arr[r] < arr[l]

Then left side definitely contains a wall
greater than arr[r].

So water on right depends ONLY on rightMax.


====================================================================
===================== VERY IMPORTANT INTERVIEW LINE =================
====================================================================

"We process the smaller side because the opposite side is guaranteed
to provide a valid boundary."


====================================================================
======================== TIME COMPLEXITY ============================
====================================================================

Each pointer moves once.

O(n)


====================================================================
======================== SPACE COMPLEXITY ===========================
====================================================================

No extra arrays used.

O(1)


====================================================================
====================== APPROACH COMPARISON ==========================
====================================================================

-------------------------------------------------------------
APPROACH            TIME        SPACE        DIFFICULTY
-------------------------------------------------------------
Prefix/Suffix       O(n)        O(n)         Easy
Two Pointers        O(n)        O(1)         Medium
-------------------------------------------------------------


====================================================================
====================== COMMON MISTAKES ==============================
====================================================================

1. Forgetting MIN(leftMax, rightMax)

Using MAX is wrong.

Water is limited by shorter wall.


2. Negative water

Always:
water = boundary - height

Boundary must be bigger.


3. Wrong two pointer logic

DO NOT process bigger side first.

Always process SMALLER side.


4. Updating pointer before calculation

First calculate water,
then move pointer.


====================================================================
====================== MEMORY TRICK ================================
====================================================================

Think of valleys between mountains.

Water level at a point depends on:
"Shortest strongest wall around it"

OR

"Water is trapped by the weaker boundary."


====================================================================
===================== FINAL UNDERSTANDING ===========================
====================================================================

APPROACH 1:
Store leftMax and rightMax for every index.

APPROACH 2:
Realize we only need one side at a time,
so use two pointers and process smaller side.

This converts:
Space O(n) -> O(1)

without changing time complexity.

====================================================================
*/