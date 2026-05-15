/*
====================================================================
===================== UNION OF TWO SORTED ARRAYS ====================
====================================================================

Question:
Given TWO SORTED arrays,
return their UNION.

UNION means:
All unique elements from both arrays.

Result must also remain SORTED.


--------------------------------------------------------------------
EXAMPLE
--------------------------------------------------------------------

a = [1,2,2,3,4]
b = [2,3,5]

Union:
[1,2,3,4,5]


====================================================================
========================== CORE INTUITION ===========================
====================================================================

Both arrays are already SORTED.

This is the MOST IMPORTANT observation.

Because arrays are sorted,
we can process them together
just like MERGE SORT merging.


====================================================================
====================== MAIN TWO POINTER IDEA ========================
====================================================================

Use two pointers:

i -> traverses array a
j -> traverses array b

At every step:

1. Compare a[i] and b[j]
2. Insert smaller element
3. Move corresponding pointer

This guarantees:
sorted order automatically.


====================================================================
====================== WHY THIS WORKS ===============================
====================================================================

Since arrays are sorted:

Smaller element MUST appear first in union.

So:
we always process smaller value first.


====================================================================
======================= VERY IMPORTANT POINT ========================
====================================================================

Union contains UNIQUE elements only.

So before inserting:

Check whether current element
is already last inserted element.


Code:

if(set.isEmpty() || set.get(set.size()-1) != value)


This avoids duplicates.


====================================================================
====================== COMPLETE FLOW ================================
====================================================================

a = [1,2,2,3,4]
b = [2,3,5]


====================================================================
========================= INITIALIZATION ============================
====================================================================

i = 0
j = 0

result = []


====================================================================
========================== ITERATION ================================
====================================================================

------------------------------------------------
STEP 1
------------------------------------------------

a[i] = 1
b[j] = 2

1 < 2

Insert 1

result = [1]

Move i++


------------------------------------------------
STEP 2
------------------------------------------------

a[i] = 2
b[j] = 2

Equal elements.

Insert ONLY ONCE.

result = [1,2]

Move BOTH pointers.

i++
j++


------------------------------------------------
STEP 3
------------------------------------------------

a[i] = 2
b[j] = 3

2 < 3

BUT:
Last inserted already = 2

So SKIP insertion.

Move i++


------------------------------------------------
STEP 4
------------------------------------------------

a[i] = 3
b[j] = 3

Equal.

Insert once.

result = [1,2,3]

Move both.


------------------------------------------------
STEP 5
------------------------------------------------

a[i] = 4
b[j] = 5

4 < 5

Insert 4

result = [1,2,3,4]

Move i++


====================================================================
======================= MAIN LOOP ENDS ==============================
====================================================================

Array a finished.

But array b still has:
5


====================================================================
===================== PROCESS REMAINING ELEMENTS ====================
====================================================================

Insert remaining elements from b.

Insert 5

result = [1,2,3,4,5]


FINAL ANSWER:
[1,2,3,4,5]


====================================================================
========================= DRY RUN TABLE =============================
====================================================================

----------------------------------------------------------------------------
a[i]       b[j]       DECISION                    RESULT
----------------------------------------------------------------------------
1          2          add 1                       [1]
2          2          add once                    [1,2]
2          3          duplicate skip              [1,2]
3          3          add once                    [1,2,3]
4          5          add 4                       [1,2,3,4]
END                    add remaining 5            [1,2,3,4,5]
----------------------------------------------------------------------------


====================================================================
===================== WHY MOVE BOTH POINTERS ? ======================
====================================================================

When:
a[i] == b[j]

Both arrays contain same value.

Union needs only ONE copy.

So:
insert once
move both pointers.


====================================================================
======================== WHY CHECK LAST ELEMENT ? ===================
====================================================================

Arrays may contain duplicates.

Example:

a = [1,1,1,2]

Without duplicate check:

result:
[1,1,1,2]

WRONG.

Union must contain:
[1,2]


So before inserting:
compare with last inserted element.


====================================================================
===================== WHY ARRAYLIST WORKS HERE ======================
====================================================================

Result is built dynamically.

We don't know final size initially.

So ArrayList is convenient.


====================================================================
======================== TIME COMPLEXITY ============================
====================================================================

Each pointer moves at most once.

O(n + m)

where:
n = size of array a
m = size of array b


====================================================================
======================== SPACE COMPLEXITY ===========================
====================================================================

Ignoring output array:
O(1)

Including result:
O(n + m)


====================================================================
====================== WHY THIS IS OPTIMAL ==========================
====================================================================

Every element must be seen at least once.

So:
O(n + m) is best possible.


====================================================================
===================== RELATION WITH MERGE SORT ======================
====================================================================

This logic is VERY SIMILAR to:

Merge step of Merge Sort.

Difference:

Merge Sort keeps duplicates.

Union removes duplicates.


====================================================================
========================= COMMON MISTAKES ===========================
====================================================================

1. Forgetting duplicate check

Then union contains repeated values.


------------------------------------------------

2. Moving wrong pointer

If a[i] < b[j]
ONLY move i.

If b[j] < a[i]
ONLY move j.


------------------------------------------------

3. Forgetting remaining elements loops

After main loop,
one array may still contain elements.


------------------------------------------------

4. Using nested loops

Leads to:
O(n*m)

Very inefficient.


====================================================================
======================== MEMORY TRICK ===============================
====================================================================

Think of two sorted queues.

Always pick smaller front element.

If same element appears in both queues:
take it only once.


====================================================================
====================== FINAL UNDERSTANDING ==========================
====================================================================

1. Arrays are sorted.
2. Use two pointers.
3. Compare current elements.
4. Insert smaller element.
5. Skip duplicates using last inserted check.
6. Move pointers carefully.
7. Add remaining elements at end.

This creates:
Optimal O(n+m) union algorithm.

====================================================================
*/