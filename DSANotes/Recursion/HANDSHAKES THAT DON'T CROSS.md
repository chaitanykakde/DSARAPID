
/*
========================================================
        HANDSHAKES THAT DON'T CROSS
========================================================

PROBLEM:
--------------------------------------------------------

N people are sitting around a circular table.

Every person must shake hands with exactly ONE
other person.

Condition:
No two handshakes can cross each other.

Find total number of valid ways.

N is always even.


========================================================
EXAMPLE
========================================================

N = 2

1 ----- 2

Only one possible handshake.

Answer = 1


--------------------------------------------------------

N = 4

People:

1 2 3 4

VALID:
1-2 and 3-4

VALID:
1-4 and 2-3

INVALID:
1-3 and 2-4

because lines cross.


So answer = 2


========================================================
MOST IMPORTANT UNDERSTANDING
========================================================

This problem is NOT asking:

- simulate handshakes
- store lines
- detect crossings geometrically

That becomes very difficult.


Instead:

We recursively BUILD only valid structures.


========================================================
MAIN IDEA
========================================================

Fix FIRST person.

Then try pairing that person with every valid partner.

Once one handshake is fixed:

the circle splits into TWO independent regions.


Example:

1 paired with 4

1 2 3 4 5 6

Inside:
2 3

Outside:
5 6


Now:
- inside people can only shake inside
- outside people can only shake outside

Otherwise crossing occurs.


========================================================
MOST IMPORTANT RECURSIVE INSIGHT
========================================================

One handshake splits problem into:

- LEFT subproblem
- RIGHT subproblem

Both are SAME TYPE OF PROBLEM.

This is why recursion/DP works.


========================================================
DP DEFINITION
========================================================

dp[n]

=
number of valid non-crossing handshake arrangements
for n people.


========================================================
BASE CASES
========================================================

dp[0] = 1

Why?

Empty arrangement counts as ONE valid way.

This is extremely important in recursion.


--------------------------------------------------------

dp[2] = 1

Only one possible handshake.


========================================================
HOW WE BUILD BIGGER ANSWERS
========================================================

We compute:

dp[4]
dp[6]
dp[8]
...

using smaller already-known answers.


========================================================
HOW dp[4] IS COMPUTED
========================================================

People:

1 2 3 4


--------------------------------------------------------
CASE 1
--------------------------------------------------------

1 paired with 2

Inside:
0 people

Outside:
3 4

Ways:

dp[0] * dp[2]
=
1 * 1
=
1


--------------------------------------------------------
CASE 2
--------------------------------------------------------

1 paired with 4

Inside:
2 3

Outside:
0 people

Ways:

dp[2] * dp[0]
=
1 * 1
=
1


--------------------------------------------------------
TOTAL
--------------------------------------------------------

dp[4]
=
1 + 1
=
2


========================================================
HOW dp[6] IS COMPUTED
========================================================

People:

1 2 3 4 5 6


--------------------------------------------------------
CASE 1
--------------------------------------------------------

1 paired with 2

Inside:
0 people

Outside:
3 4 5 6

Ways:

dp[0] * dp[4]
=
1 * 2
=
2


--------------------------------------------------------
CASE 2
--------------------------------------------------------

1 paired with 4

Inside:
2 3

Outside:
5 6

Ways:

dp[2] * dp[2]
=
1 * 1
=
1


--------------------------------------------------------
CASE 3
--------------------------------------------------------

1 paired with 6

Inside:
2 3 4 5

Outside:
0 people

Ways:

dp[4] * dp[0]
=
2 * 1
=
2


--------------------------------------------------------
TOTAL
--------------------------------------------------------

dp[6]
=
2 + 1 + 2
=
5


========================================================
WHY MULTIPLICATION?
========================================================

Left side and right side are independent.

If:

left side has 2 ways
right side has 3 ways

Then total combinations:

2 * 3 = 6

because every left arrangement can combine
with every right arrangement.


========================================================
WHY SUMMATION?
========================================================

Each partner choice creates DIFFERENT valid structures.

So we ADD all possibilities.


========================================================
VERY IMPORTANT PATTERN
========================================================

Fix one choice
↓
problem splits
↓
leftWays * rightWays
↓
sum all possibilities


This pattern appears in:
- Catalan Numbers
- BST counting
- Parentheses generation
- Polygon triangulation
- Interval DP


========================================================
TIME COMPLEXITY
========================================================

Outer loop:
N/2 iterations

Inner loop:
N/2 iterations

Total:
O(N²)


========================================================
FINAL CODE
========================================================
*/

class Solution {

    public int countWays(int N) {

        /*
        dp[i]

        stores:
        number of valid handshake arrangements
        for i people.
        */

        int[] dp = new int[N + 1];

        /*
        BASE CASE:

        0 people means empty arrangement.

        Empty arrangement counts as ONE valid way.
        */

        dp[0] = 1;

        /*
        BASE CASE:

        2 people -> only one handshake possible.
        */

        dp[2] = 1;

        /*
        Build answers from smaller to bigger.

        We already know:
        dp[0]
        dp[2]

        So start from 4.
        */

        for (int people = 4; people <= N; people += 2) {

            /*
            Stores total ways for current people count.
            */

            int totalWays = 0;

            /*
            Fix first person.

            Try all possible partners:
            2,4,6...

            Only even jumps because:
            both left and right side must contain
            even number of people.
            */

            for (int partner = 2; partner <= people; partner += 2) {

                /*
                Number of people INSIDE handshake.

                Example:

                1 paired with 4

                inside:
                2,3

                total = 2
                */

                int leftPeople = partner - 2;

                /*
                Number of people OUTSIDE handshake.
                */

                int rightPeople = people - partner;

                /*
                Left side and right side independent.

                So:

                total combinations =
                leftWays * rightWays
                */

                totalWays +=
                        dp[leftPeople] * dp[rightPeople];
            }

            /*
            Store answer for current people count.
            */

            dp[people] = totalWays;
        }

        /*
        Final answer.
        */

        return dp[N];
    }
}


/*
========================================================
MOST IMPORTANT LEARNING FROM THIS PROBLEM
========================================================

This problem teaches:

1) Recursive decomposition
2) DP state building
3) Independent subproblem multiplication
4) Catalan-number structure
5) "Fix one element" recursion pattern


========================================================
BIGGEST MINDSET SHIFT
========================================================

Beginner Thinking:

"Generate all combinations and check crossings."


Advanced Thinking:

"Recursively build only valid structures."


That is the true beauty of this problem.

========================================================
*/