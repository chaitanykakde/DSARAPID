/*
========================================================
                POWER SUM
========================================================

PROBLEM:
--------------------------------------------------------

Given:

X = target number
N = power

Find number of ways such that:

X =
a^N + b^N + c^N + ...

where:
- all numbers are unique
- every number used at most once


========================================================
EXAMPLE
========================================================

X = 10
N = 2

Possible:

1^2 + 3^2
=
1 + 9
=
10

Only one valid way.

Answer = 1


========================================================
MOST IMPORTANT UNDERSTANDING
========================================================

At every number:

we have TWO choices.

--------------------------------------------------------
CHOICE 1
--------------------------------------------------------

Take current number


--------------------------------------------------------
CHOICE 2
--------------------------------------------------------

Skip current number


This becomes:

INCLUDE / EXCLUDE RECURSION


========================================================
RECURSION TREE THINKING
========================================================

Suppose:

current number = 2


                    2
                  /   \
               skip   take


--------------------------------------------------------
SKIP
--------------------------------------------------------

Ignore current number

Move to next number.


--------------------------------------------------------
TAKE
--------------------------------------------------------

Add current number's power to current sum

Move to next number.


========================================================
WHY THIS WORKS
========================================================

Recursion explores ALL possible combinations.

Every path in recursion tree represents
one possible subset selection.


========================================================
RECURSIVE STATE
========================================================

Function:

getCount(cur_Sum, x, power, cur_Num)


--------------------------------------------------------
cur_Sum
--------------------------------------------------------

Current accumulated sum.


--------------------------------------------------------
x
--------------------------------------------------------

Target value.


--------------------------------------------------------
power
--------------------------------------------------------

Required power.


--------------------------------------------------------
cur_Num
--------------------------------------------------------

Current number being considered.


========================================================
BASE CASES
========================================================

--------------------------------------------------------
CASE 1
--------------------------------------------------------

If sum exceeds target:

return 0


Why?

No valid solution possible anymore.


--------------------------------------------------------
CASE 2
--------------------------------------------------------

If sum becomes exactly target:

return 1


Why?

One valid combination found.


========================================================
VERY IMPORTANT PRUNING
========================================================

if(cur_Sum + powerSum > x)
    return 0;


This is called:

PRUNING


Meaning:

Stop exploring useless recursion paths early.


This makes recursion MUCH faster.


========================================================
WHY cur_Num+1 IN BOTH CALLS?
========================================================

Because every number can be used ONLY ONCE.

So after considering current number:

always move to next number.


========================================================
RECURSION FLOW EXAMPLE
========================================================

X = 10
N = 2


--------------------------------------------------------
START
--------------------------------------------------------

cur_Num = 1

powerSum = 1^2 = 1


--------------------------------------------------------
CHOICE 1
--------------------------------------------------------

Skip 1

sum remains 0


--------------------------------------------------------
CHOICE 2
--------------------------------------------------------

Take 1

sum becomes 1


Then recursion continues similarly
for next numbers.


========================================================
IMPORTANT PATTERN
========================================================

At every step:

Take current element
OR
Skip current element


This is one of the MOST IMPORTANT recursion patterns.


Appears in:
- Subset Sum
- Combination Sum
- Target Sum
- Partition problems
- Backtracking problems


========================================================
TIME COMPLEXITY
========================================================

Worst case:

O(2^n)

because every number creates:
- take branch
- skip branch


Pruning reduces practical recursion significantly.


========================================================
YOUR FINAL CODE
========================================================
*/

class Solution {

    public static int powerSum(int X, int N) {

        /*
        Start recursion with:

        current sum = 0
        target = X
        power = N
        current number = 1
        */

        return getCount(0, X, N, 1);
    }


    public static int getCount(int cur_Sum,
                               int x,
                               int power,
                               int cur_Num) {

        /*
        Current number raised to required power.
        */

        int powerSum =
                (int)Math.pow(cur_Num, power);

        /*
        Stores total valid ways from current state.
        */

        int count = 0;


        /*
        BASE CASE:

        Sum exceeded target.

        No valid solution possible.
        */

        if (cur_Sum + powerSum > x) {

            return 0;
        }


        /*
        BASE CASE:

        Exact target achieved.

        One valid combination found.
        */

        if (cur_Sum + powerSum == x) {

            return 1;
        }


        /*
        CHOICE 1:

        Skip current number.

        Sum remains same.

        Move to next number.
        */

        count +=
                getCount(cur_Sum,
                         x,
                         power,
                         cur_Num + 1);


        /*
        CHOICE 2:

        Take current number.

        Add its power to current sum.

        Move to next number.
        */

        count +=
                getCount(cur_Sum + powerSum,
                         x,
                         power,
                         cur_Num + 1);


        /*
        Return total valid ways.
        */

        return count;
    }
}


/*
========================================================
MOST IMPORTANT LEARNING FROM THIS PROBLEM
========================================================

This problem teaches:

1) Include / Exclude recursion
2) Recursive state design
3) Backtracking exploration
4) Recursive pruning
5) Decision tree thinking


========================================================
BIGGEST RECURSION LESSON
========================================================

At every step ask:

"What choices do I have right now?"


Here:

- Take current number
- Skip current number


That creates recursive branching.


========================================================
VERY IMPORTANT MINDSET
========================================================

Recursion problems are often:

CHOICE PROBLEMS.


You recursively explore every valid choice.

========================================================
*/