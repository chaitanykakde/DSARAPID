/*
====================================================================
==================== FIRST NEGATIVE IN EVERY WINDOW =================
====================================================================

Question:
Given an array and window size k,
find FIRST NEGATIVE number in every window of size k.

If no negative number exists in a window,
store 0.

--------------------------------------------------------------------
EXAMPLE
--------------------------------------------------------------------

arr = [12, -1, -7, 8, -15, 30, 16, 28]
k = 3

Windows:

[12, -1, -7]       -> -1
[-1, -7, 8]        -> -1
[-7, 8, -15]       -> -7
[8, -15, 30]       -> -15
[-15, 30, 16]      -> -15
[30, 16, 28]       -> 0

Answer:
[-1, -1, -7, -15, -15, 0]


====================================================================
========================== CORE INTUITION ===========================
====================================================================

We need ONLY:

"FIRST NEGATIVE element in current window"

NOT all negatives.

So the moment a negative element becomes useless
(goes outside window),
we remove it.

This is why DEQUE is perfect.

Deque stores:
INDEXES of useful negative numbers only.


====================================================================
====================== WHY STORE INDEXES ? ==========================
====================================================================

We store indexes instead of values because:

We must know whether an element is:
INSIDE or OUTSIDE current window.

Example:

Window size = 3

Current window:
indexes [2,3,4]

If negative index = 1

then:
1 is outside current window.

So remove it.


====================================================================
========================= MAIN IDEA =================================
====================================================================

Deque always stores:

"Negative elements of current window
in the SAME ORDER as array"

Therefore:

FIRST element of deque
= FIRST negative of current window.


====================================================================
====================== VERY IMPORTANT OBSERVATION ===================
====================================================================

Deque Front  ->
First negative of current window

Deque Back ->
Latest inserted negative


====================================================================
======================== COMPLETE FLOW ==============================
====================================================================

arr = [12, -1, -7, 8, -15, 30, 16, 28]
k = 3


====================================================================
===================== STEP 1 : PROCESS FIRST WINDOW =================
====================================================================

First window:
[12, -1, -7]

------------------------------------------------
i = 0
------------------------------------------------

arr[0] = 12

Not negative.

Deque:
[]

------------------------------------------------
i = 1
------------------------------------------------

arr[1] = -1

Negative.
Add index 1.

Deque:
[1]

------------------------------------------------
i = 2
------------------------------------------------

arr[2] = -7

Negative.
Add index 2.

Deque:
[1,2]


====================================================================
===================== ANSWER FOR FIRST WINDOW =======================
====================================================================

Deque front = 1

arr[1] = -1

Answer:
[-1]


====================================================================
====================== STEP 2 : SLIDE WINDOW ========================
====================================================================

Now start sliding window.

New element comes from RIGHT.
Old element exits from LEFT.


====================================================================
==================== WINDOW 2 -> [-1,-7,8] ==========================
====================================================================

Current i = 3

New window indexes:
[1,2,3]

------------------------------------------------
REMOVE OUTSIDE ELEMENTS
------------------------------------------------

Condition:
dq.peekFirst() <= i-k

i-k = 3-3 = 0

Deque front = 1

1 <= 0 ? NO

No removal.


------------------------------------------------
ADD CURRENT ELEMENT
------------------------------------------------

arr[3] = 8

Not negative.

Deque:
[1,2]


------------------------------------------------
GET ANSWER
------------------------------------------------

Deque front = 1

arr[1] = -1

Answer:
[-1,-1]


====================================================================
==================== WINDOW 3 -> [-7,8,-15] =========================
====================================================================

Current i = 4

Window indexes:
[2,3,4]

------------------------------------------------
REMOVE OUTSIDE ELEMENTS
------------------------------------------------

i-k = 4-3 = 1

Deque front = 1

1 <= 1

YES -> Remove index 1

Deque:
[2]


------------------------------------------------
ADD CURRENT ELEMENT
------------------------------------------------

arr[4] = -15

Negative.

Add index 4

Deque:
[2,4]


------------------------------------------------
GET ANSWER
------------------------------------------------

Deque front = 2

arr[2] = -7

Answer:
[-1,-1,-7]


====================================================================
==================== WINDOW 4 -> [8,-15,30] =========================
====================================================================

Current i = 5

Window indexes:
[3,4,5]

------------------------------------------------
REMOVE OUTSIDE ELEMENTS
------------------------------------------------

i-k = 5-3 = 2

Deque front = 2

2 <= 2

YES -> Remove

Deque:
[4]


------------------------------------------------
ADD CURRENT ELEMENT
------------------------------------------------

arr[5] = 30

Not negative.


------------------------------------------------
GET ANSWER
------------------------------------------------

Deque front = 4

arr[4] = -15

Answer:
[-1,-1,-7,-15]


====================================================================
====================== FINAL DEQUE UNDERSTANDING ====================
====================================================================

Deque contains ONLY:
Useful negative indexes.

Whenever a negative number goes outside window,
remove it immediately.

Therefore:
Deque front always stays valid.


====================================================================
========================= WHY THIS WORKS ============================
====================================================================

Because deque maintains:

1. Correct order of negatives
2. Only current window negatives

So first element of deque automatically becomes:
FIRST NEGATIVE OF CURRENT WINDOW.


====================================================================
======================== DRY RUN SUMMARY ============================
====================================================================

-------------------------------------------------------------
WINDOW              DEQUE(INDEXES)         ANSWER
-------------------------------------------------------------
[12,-1,-7]          [1,2]                  -1
[-1,-7,8]           [1,2]                  -1
[-7,8,-15]          [2,4]                  -7
[8,-15,30]          [4]                    -15
[-15,30,16]         [4]                    -15
[30,16,28]          []                     0
-------------------------------------------------------------


====================================================================
======================== TIME COMPLEXITY ============================
====================================================================

Each element:
1. Added once
2. Removed once

Total operations:
O(n)

VERY IMPORTANT:
Although while loop exists,
overall removals across entire algorithm are only O(n).


====================================================================
======================== SPACE COMPLEXITY ===========================
====================================================================

Deque stores at most k elements.

O(k)


====================================================================
===================== WHY BRUTE FORCE IS BAD ========================
====================================================================

Brute Force:

For every window,
scan all k elements again.

Time:
O(n*k)

If:
n = 100000
k = 50000

Very slow.


====================================================================
======================== SLIDING WINDOW INTUITION ===================
====================================================================

This is NOT normal sliding window only.

This is:
"Sliding Window + Data Structure Optimization"

Window moves continuously,
deque remembers useful data.


====================================================================
===================== IMPORTANT INTERVIEW POINT =====================
====================================================================

Question:
Why use deque ?

Answer:

Because deque allows:

1. Fast insertion from back
2. Fast removal from front
3. Maintaining order

Perfect for sliding window problems.


====================================================================
========================= COMMON MISTAKES ===========================
====================================================================

1. Storing VALUES instead of INDEXES

Wrong because:
Cannot identify out-of-window elements.


------------------------------------------------

2. Forgetting to remove old indexes

Then deque front may point to invalid element.


------------------------------------------------

3. Removing from back instead of front

Outdated elements are always at FRONT.


------------------------------------------------

4. Using stack instead of deque

Stack destroys order.
We need first negative in original order.


====================================================================
======================== MEMORY TRICK ===============================
====================================================================

Think:

Deque = Waiting line of negative numbers

Front person =
first negative currently visible in window.

If someone exits window,
remove them from line.

New negative comes ->
join back of line.


====================================================================
======================= FINAL UNDERSTANDING =========================
====================================================================

We slide the window through array.

Deque stores only useful negative indexes.

Front of deque always represents:
FIRST NEGATIVE element of current window.

This gives:
O(n) optimal solution.

====================================================================
*/