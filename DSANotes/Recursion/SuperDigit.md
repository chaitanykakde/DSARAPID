
# Super Digit — Notes

Problem:
Given string n and integer k,
repeat n exactly k times and find its super digit.

Example:
n = "9875"
k = 4

p = 9875987598759875

Super Digit Process:
9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5
= 116

1+1+6 = 8

Answer = 8


--------------------------------------------------
MAIN OBSERVATION / TRICK
--------------------------------------------------

We never actually create the huge repeated number.

Because:

superDigit(n × k)
=
superDigit(sumDigits(n) × k)

Example:

9875 repeated 4 times

Digit sum becomes:

(9+8+7+5) * 4
= 29 * 4
= 116

Then keep reducing digits.


--------------------------------------------------
APPROACH
--------------------------------------------------

STEP 1:
Find sum of digits of n

Example:
n = "9875"

9+8+7+5 = 29


STEP 2:
Multiply sum with k

29 * 4 = 116


STEP 3:
Recursively reduce digits until single digit remains

116
1+1+6 = 8

Answer = 8


--------------------------------------------------
WHY WE USED long INSTEAD OF int
--------------------------------------------------

int range:

-2147483648 to 2147483647

Hidden test cases can contain:
- very large n
- very large k

So:

sum * k

can exceed int range.

When int overflows,
Java wraps value into negative range internally.

Example:

2147483647 + 1
becomes
-2147483648


long has much larger range:

-2^63 to 2^63-1

So using long prevents overflow.


--------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------

O(N)

N = length of string n

Because:
- first traversal computes digit sum
- recursive digit reductions are very small


--------------------------------------------------
FINAL CODE
--------------------------------------------------

class SuperDigit {

    public static int superDigit(String n, int k) {

        long sum = 0;

        // Find digit sum of original string
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        // Multiply by k
        sum = sum * k;

        // Reduce to single digit
        return getDigit(Long.toString(sum));
    }

    public static int getDigit(String n) {

        // Base case
        if (n.length() == 1) {
            return Integer.parseInt(n);
        }

        long sum = 0;

        // Sum digits
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        // Recursive call
        return getDigit(Long.toString(sum));
    }
}