# COMPLETE NOTES : DIVISOR COUNTING TECHNIQUES

# Single Number vs All Numbers (1 → n)

---

# 1. WHAT IS A DIVISOR?

A divisor of a number `n` is a number that divides `n` completely.

Meaning:

```java
n % divisor == 0
```

Example:

```txt
n = 12

Divisors:
1, 2, 3, 4, 6, 12
```

Count of divisors:

```txt
6
```

---

# 2. PROBLEM TYPES

There are TWO major types of divisor problems:

|Problem Type|Example|
|---|---|
|Single Number|Find divisors of 36|
|Multiple Numbers|Find divisor counts for all numbers 1 → n|

The optimal approach changes completely depending on the problem.

---

# =========================================================

# APPROACH 1 : SINGLE NUMBER DIVISOR COUNTING

# =========================================================

# IDEA

Instead of checking all numbers from:

```txt
1 → n
```

we use an important mathematical property:

# DIVISORS COME IN PAIRS

Example:

```txt
36

1 × 36
2 × 18
3 × 12
4 × 9
6 × 6
```

Observe carefully:

After square root, pairs start repeating.

So we only need to check till:

√n

---

# MATHEMATICAL CONDITION

Instead of:

```java
i <= n
```

we use:

```java
i * i <= n
```

Because:

```txt
i² ≤ n
```

Taking square root:

```txt
i ≤ √n
```

---

# JAVA CODE (COUNT DIVISORS OF SINGLE NUMBER)

```java
public class Main {

    static int getDivisorsCount(int n){

        int count = 0;

        // Loop only till sqrt(n)
        for(int i = 1; i * i <= n; i++){

            // If i divides n
            if(n % i == 0){

                // Count divisor i
                count++;

                /*
                 If pair divisor is different,
                 count it also.

                 Example:
                 2 divides 12

                 Pair is:
                 12 / 2 = 6

                 So count:
                 2 and 6
                */

                if(i != n / i){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 12;

        System.out.println(getDivisorsCount(n));
    }
}
```

---

# DRY RUN

```txt
n = 12
```

Loop:

```txt
i = 1 → √12
```

√12 ≈ 3.46

So loop runs:

```txt
1, 2, 3
```

---

# i = 1

```txt
12 % 1 == 0
```

Pair:

```txt
12 / 1 = 12
```

Count:

```txt
1 and 12
```

count = 2

---

# i = 2

```txt
12 % 2 == 0
```

Pair:

```txt
12 / 2 = 6
```

count = 4

---

# i = 3

```txt
12 % 3 == 0
```

Pair:

```txt
12 / 3 = 4
```

count = 6

Final Answer:

```txt
6 divisors
```

---

# IMPORTANT SPECIAL CASE

Example:

```txt
n = 36
```

At:

```txt
i = 6
```

Pair:

```txt
36 / 6 = 6
```

Same divisor.

Without condition:

```java
if(i != n/i)
```

we would count 6 twice.

So this condition prevents duplicate counting.

---

# TIME COMPLEXITY OF SINGLE NUMBER APPROACH

Loop condition:

```java
i * i <= n
```

means:

```txt
i ≤ √n
```

So loop runs:

```txt
√n times
```

Each iteration performs constant operations:

```txt
O(1)
```

Therefore:

```txt
Total Complexity:

O(√n)
```

---

# SPACE COMPLEXITY

```txt
O(1)
```

No extra array used.

---

# WHEN TO USE THIS APPROACH?

Best for:

✔ Single query  
✔ Few numbers  
✔ Small constraints  
✔ Interview questions

---

# =========================================================

# WHAT IF WE USE THIS FOR ALL NUMBERS 1 → n ?

# =========================================================

Suppose:

```java
for(int x = 1; x <= n; x++){

    getDivisorsCount(x);
}
```

Now each number costs:

```txt
√x
```

Total work:

```txt
√1 + √2 + √3 + ... + √n
```

This approximately behaves like:

```txt
O(n√n)
```

---

# WHY O(n√n)?

Because most values near end are close to:

```txt
√n
```

Example:

```txt
n = 100
```

Most square roots near end are around:

```txt
10
```

So rough intuition:

```txt
100 × 10
```

=

```txt
1000
```

Hence:

```txt
O(n√n)
```

---

# =========================================================

# APPROACH 2 : SIEVE DIVISOR COUNTING

# =========================================================

This approach is used when we need:

```txt
Divisor counts for ALL numbers from 1 → n
```

This is a preprocessing technique.

---

# MAIN IDEA

Instead of checking divisors for each number separately:

We distribute divisor information to multiples.

---

# OBSERVATION

If:

```txt
i divides j
```

then:

```txt
j is a multiple of i
```

Example:

```txt
2 divides:
2,4,6,8,10...
```

So for divisor `2`,  
all multiples of 2 gain one divisor.

---

# JAVA CODE

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int n = 10;

        // divisor count array
        int[] div = new int[n + 1];

        /*
         i represents divisor
        */
        for(int i = 1; i <= n; i++){

            /*
             Visit all multiples of i
            */
            for(int j = i; j <= n; j += i){

                // i divides j
                div[j]++;
            }
        }

        // Print divisor counts
        for(int i = 1; i <= n; i++){

            System.out.println(i + " -> " + div[i]);
        }
    }
}
```

---

# HOW THIS WORKS

Suppose:

```txt
n = 5
```

Initial array:

```txt
index : 0 1 2 3 4 5
value : 0 0 0 0 0 0
```

---

# i = 1

Visit multiples:

```txt
1 2 3 4 5
```

Because every number divisible by 1.

Array:

```txt
1 1 1 1 1
```

---

# i = 2

Visit:

```txt
2 4
```

Update:

```txt
1 2 1 2 1
```

---

# i = 3

Visit:

```txt
3
```

Update:

```txt
1 2 2 2 1
```

---

# i = 4

Visit:

```txt
4
```

Update:

```txt
1 2 2 3 1
```

---

# i = 5

Visit:

```txt
5
```

Final:

```txt
1 2 2 3 2
```

Meaning:

|Number|Divisor Count|
|---|---|
|1|1|
|2|2|
|3|2|
|4|3|
|5|2|

---

# MOST IMPORTANT LINE

```java
j += i
```

This means:

```txt
Visit multiples of i
```

Example:

If:

```txt
i = 3
```

Then:

```txt
3,6,9,12...
```

All divisible by 3.

---

# TIME COMPLEXITY OF SIEVE APPROACH

This is the MOST IMPORTANT PART.

Students often think:

```txt
Nested loops = O(n²)
```

But WRONG.

Because inner loop size changes.

---

# COUNT INNER LOOP ITERATIONS

When:

```txt
i = 1
```

Inner loop runs:

```txt
n times
```

---

When:

```txt
i = 2
```

Runs:

```txt
n/2 times
```

---

When:

```txt
i = 3
```

Runs:

```txt
n/3 times
```

---

When:

```txt
i = 4
```

Runs:

```txt
n/4 times
```

---

# TOTAL OPERATIONS

```txt
n + n/2 + n/3 + n/4 + ... + n/n
```

Take `n` common:

```txt
n(1 + 1/2 + 1/3 + 1/4 + ... + 1/n)
```

---

# HARMONIC SERIES

This series:

```txt
1 + 1/2 + 1/3 + ... + 1/n
```

grows approximately like:

```txt
log n
```

So total complexity:

```txt
O(n log n)
```

---

# VERY IMPORTANT UNDERSTANDING

The series itself becomes:

```txt
log n
```

BUT we already had `n` multiplied outside.

So:

```txt
n × log n
```

Hence:

```txt
O(n log n)
```

---

# SPACE COMPLEXITY

We use array:

```java
int[] div = new int[n+1];
```

So:

```txt
O(n)
```

---

# COMPARISON OF BOTH APPROACHES

|Feature|Single Number Method|Sieve Method|
|---|---|---|
|Purpose|One number|All numbers|
|Main Idea|Divisor pairs|Multiples traversal|
|Complexity|O(√n)|O(n log n)|
|Space|O(1)|O(n)|
|Best For|Single query|Bulk preprocessing|

---

# FINAL IMPORTANT COMPARISON

Suppose:

```txt
n = 1,000,000
```

Then:

|Function|Value|
|---|---|
|√n|1000|
|log n|~20|

So:

```txt
n log n
```

is MUCH faster than:

```txt
n√n
```

for processing all numbers.

---

# FINAL INTERVIEW/CP RULE

Use:

```txt
O(√n)
```

when solving for ONE number.

Use:

```txt
O(n log n)
```

when preprocessing ALL numbers.

---

# BIGGEST LESSON

Time complexity depends on:

```txt
TOTAL OPERATIONS
```

NOT:

- number of loops
    
- nested loops
    
- code appearance
    

Always count:

- how many times loops actually execute.