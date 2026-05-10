# Increasing Numbers — Proper Revision Notes

# Problem Statement

Given a number `n`, generate all numbers of length `n` such that:

# Digits are strictly increasing

Meaning:

```
1 < 2 < 5
```

is valid.

But:

```
1 2 2   ❌3 2 1   ❌5 5     ❌
```

are invalid.

---

# Example

## Input

```
n = 2
```

## Output

```
12 13 14 15 16 17 18 1923 24 25 26 27 28 2934 35 36 37 38 3945 46 47 48 4956 57 58 5967 68 6978 7989
```

---

# Important Understanding

We need numbers where:

# Every next digit is bigger than previous digit

Examples:

| Number | Valid or Not | Reason        |
| ------ | ------------ | ------------- |
| 12     | ✅            | 1 < 2         |
| 47     | ✅            | 4 < 7         |
| 89     | ✅            | 8 < 9         |
| 21     | ❌            | decreasing    |
| 33     | ❌            | equal digits  |
| 455    | ❌            | 5 is repeated |

---

# Code

```
import java.util.*;

class IncreasingNumbers {

    public static void main(String[] args) {
        System.out.println(increasingNumbers(2));
    }

    public static ArrayList<Integer> increasingNumbers(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        // Special case
        if (n == 1) {

            for (int i = 0; i <= 9; i++) {
                list.add(i);
            }

            return list;
        }

        dfs(1, 0, n, list);

        return list;
    }

    private static void dfs(int start,
                            int num,
                            int len,
                            ArrayList<Integer> list) {

        // Base case
        if (len == 0) {
            list.add(num);
            return;
        }

        for (int i = start; i <= 9; i++) {

            int curr = 10 * num + i;

            dfs(i + 1, curr, len - 1, list);
        }
    }
}
```

---

# Main Idea

This problem uses:

# Recursion + Backtracking

We build numbers:

# One digit at a time

---

# Special Case — `n == 1`

This is VERY IMPORTANT.

Code:

```
if(n == 1)
```

Why handled separately?

Because:

# Every single digit number is automatically increasing

Examples:

```
0123...9
```

All are valid because there is only ONE digit.

So output becomes:

```
[0,1,2,3,4,5,6,7,8,9]
```

---

# Understanding DFS Function

## Function

```
dfs(start, num, len, list)
```

---

# Parameter Meaning

|Parameter|Meaning|
|---|---|
|`start`|smallest digit we can use now|
|`num`|number formed till now|
|`len`|how many digits still needed|
|`list`|stores final answers|

---

# Understanding Each Parameter Properly

---

# 1. `start`

Suppose:

```
start = 4
```

Then loop runs:

```
4 5 6 7 8 9
```

Why?

Because next digit must be bigger.

---

# 2. `num`

Current formed number.

Example:

```
num = 13
```

means:

```
we already formed 13
```

Now next digit will be attached.

---

# 3. `len`

How many digits are still remaining.

Example:

```
len = 2
```

means:

```
still need 2 more digits
```

---

# Most Important Line

```
int curr = 10 * num + i;
```

This appends a digit.

---

# How Appending Works

Suppose:

```
num = 12i = 5
```

Then:

12×10+5=12512\times10+5=12512×10+5=125

So:

```
125 gets formed
```

---

# Why Multiply by 10?

Because:

```
12 × 10 = 120
```

This shifts digits left.

Then:

```
120 + 5 = 125
```

---

# MOST IMPORTANT CONCEPT

# Why `i + 1` ?

Code:

```
dfs(i + 1, curr, len - 1, list);
```

Suppose current chosen digit is:

```
i = 3
```

Next recursive call becomes:

```
dfs(4, curr, ...)
```

Meaning:

Next digit can only be:

```
4 5 6 7 8 9
```

So automatically:

|Possible|Allowed?|
|---|---|
|34|✅|
|35|✅|
|39|✅|
|33|❌|
|32|❌|

This is HOW recursion guarantees increasing digits.

---

# Complete Dry Run

# Example

```
n = 2
```

Initial call:

```
dfs(1, 0, 2, list)
```

---

# Meaning of Initial Call

| Variable | Value |
| -------- | ----- |
| start    | 1     |
| num      | 0     |
| len      | 2     |

Meaning:

- start choosing digits from 1
- no number formed yet
- need total 2 digits

---

# First Loop

Loop runs:

```
i = 1
```

Create current number:

0×10+1=10\times10+1=10×10+1=1

Now call:

```
dfs(2, 1, 1, list)
```

---

# New State

|Variable|Value|
|---|---|
|start|2|
|num|1|
|len|1|

Meaning:

- current number = 1
- one more digit needed
- next digit must start from 2

---

# Second Level

Loop runs:

```
2 3 4 5 6 7 8 9
```

---

# Case 1

Choose:

```
i = 2
```

Form number:

1×10+2=121\times10+2=121×10+2=12

Call:

```
dfs(3, 12, 0, list)
```

---

# Base Case Reached

Now:

```
len = 0
```

Meaning:

# Required digits completed

So:

```
list.add(12)
```

Store answer.

---

# Then Backtracking Happens

Control goes back.

Now loop continues:

```
131415...19
```

Then recursion returns again.

---

# Next Main Branch

Now first loop chooses:

```
i = 2
```

Then recursion generates:

```
23 24 25 26 27 28 29
```

---

# Then

```
3 → 34 35 36 37 38 394 → 45 46 47 48 49...8 → 89
```

---

# Complete Recursive Tree

```
dfs(1,0,2)├──1│   ├──12│   ├──13│   ├──14│   └──19│├──2│   ├──23│   ├──24│   └──29│├──3│   ├──34│   └──39│...│└──8    └──89
```

---

# Base Case

```
if(len == 0)
```

Meaning:

# Number is fully formed

Store it in answer.

---

# Important Observation

The algorithm NEVER creates invalid numbers.

It never generates:

```
213354
```

Why?

Because recursion only moves forward using:

```
i + 1
```

---

# Backtracking Concept

After one path finishes:

```
12 completed
```

Recursion returns back.

Then explores:

```
131415
```

This returning + exploring other paths is called:

# Backtracking

---

# Time Complexity

We choose digits from:

```
1 to 9
```

Total combinations:

```
C(9,n)
```

Very efficient.

---

# Space Complexity

Maximum recursion depth:

```
O(n)
```

because recursion goes at most `n` levels deep.

---

# Important Interview Understanding

This problem is actually:

# Combination Generation

We are choosing digits in sorted order.

Example:

For `n = 2`

Choose 2 digits from:

```
1 2 3 4 5 6 7 8 9
```

Possible combinations:

```
121314...89
```

Exactly same concept.

---

# Pattern Recognition

If question says:

- increasing sequence
- strictly increasing digits
- choose elements in order
- generate combinations

Think:

# Recursion + Backtracking

---

# Final Core Logic

The ENTIRE solution depends on:

```
dfs(i + 1, curr, len - 1, list);
```

because:

|Part|Purpose|
|---|---|
|`i + 1`|ensures next digit is bigger|
|`curr`|updated number|
|`len - 1`|one digit used|
