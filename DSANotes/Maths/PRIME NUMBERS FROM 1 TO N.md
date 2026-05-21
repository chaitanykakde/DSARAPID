# COMPLETE NOTES : SIEVE OF ERATOSTHENES

# Prime Numbers from 1 → n

---

# PROGRAM NAME

Recommended names:

```txt
SieveOfEratosthenes.java
```

OR

```txt
PrimeNumbersUsingSieve.java
```

OR

```txt
PrimeSieve.java
```

Most standard name:

```txt
SieveOfEratosthenes
```

---

# =========================================================

# 1. WHAT IS A PRIME NUMBER?

# =========================================================

A prime number is a number having:

```txt
Exactly 2 divisors
```

Those divisors are:

```txt
1 and itself
```

Examples:

|Number|Prime?|
|---|---|
|2|Yes|
|3|Yes|
|4|No|
|5|Yes|
|6|No|

---

# WHY IS 4 NOT PRIME?

Divisors of 4:

```txt
1,2,4
```

Total divisors:

```txt
3 divisors
```

So not prime.

---

# WHY IS 1 NOT PRIME?

Divisors of 1:

```txt
1
```

Only one divisor.

Prime requires exactly:

```txt
2 divisors
```

So 1 is NOT prime.

---

# =========================================================

# 2. NORMAL PRIME CHECKING

# =========================================================

To check if ONE number is prime:

```java
static boolean isPrime(int n){

    if(n < 2){
        return false;
    }

    for(int i = 2; i * i <= n; i++){

        if(n % i == 0){
            return false;
        }
    }

    return true;
}
```

---

# TIME COMPLEXITY

Loop runs till:

√n

So complexity:

```txt
O(√n)
```

Good for:

- one number
    
- few queries
    

Bad for:

- all numbers from 1 → n
    

---

# =========================================================

# 3. PROBLEM WITH NORMAL APPROACH

# =========================================================

Suppose:

```txt
Find all primes from 1 → 1,000,000
```

If we check each number separately:

```txt
n × √n
```

Complexity becomes:

```txt
O(n√n)
```

Too slow for large constraints.

---

# =========================================================

# 4. SIEVE OF ERATOSTHENES

# =========================================================

This is an optimized algorithm for finding ALL primes from:

```txt
1 → n
```

efficiently.

---

# MAIN IDEA

Instead of checking every number separately:

We remove composite numbers using multiples.

---

# MOST IMPORTANT OBSERVATION

If a number has a smaller divisor:

```txt
It cannot be prime
```

Example:

```txt
8 divisible by 2
→ not prime

15 divisible by 3
→ not prime
```

So:

- primes survive
    
- composites get removed
    

---

# =========================================================

# 5. COMPLETE JAVA CODE

# =========================================================

```java
import java.util.*;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        int n = 50;

        /*
         prime[i] stores whether i is prime or not

         true  -> prime
         false -> non-prime
        */

        boolean[] prime = new boolean[n + 1];

        /*
         Initially assume all numbers are prime
        */
        Arrays.fill(prime, true);

        /*
         0 and 1 are not prime
        */
        prime[0] = false;
        prime[1] = false;

        /*
         Traverse numbers from 2 → n
        */
        for(int i = 2; i <= n; i++){

            /*
             If already marked non-prime,
             skip processing
            */
            if(!prime[i]){
                continue;
            }

            /*
             Mark all multiples of i as non-prime

             Start from i*i
            */
            for(int j = i * i; j <= n; j += i){

                prime[j] = false;
            }
        }

        /*
         Print all prime numbers
        */
        for(int i = 2; i <= n; i++){

            if(prime[i]){
                System.out.print(i + " ");
            }
        }
    }
}
```

---

# =========================================================

# 6. UNDERSTANDING THE ARRAY

# =========================================================

```java
boolean[] prime = new boolean[n+1];
```

Meaning:

|Index|Meaning|
|---|---|
|prime[2]|Is 2 prime?|
|prime[5]|Is 5 prime?|
|prime[10]|Is 10 prime?|

---

# INITIAL STATE

```java
Arrays.fill(prime, true);
```

Initially assume:

```txt
Every number is prime
```

Later we remove composites.

---

# =========================================================

# 7. CORE LOGIC

# =========================================================

Main loop:

```java
for(int i = 2; i <= n; i++)
```

`i` represents current prime candidate.

---

# THIS IS IMPORTANT

```java
if(!prime[i]) continue;
```

Meaning:

```txt
If already marked non-prime,
skip it
```

Example:

```txt
4 already removed by 2
```

So no need to process again.

---

# =========================================================

# 8. MOST IMPORTANT LINE

# =========================================================

```java
for(int j = i * i; j <= n; j += i)
```

This visits:

```txt
Multiples of i
```

Example:

If:

```txt
i = 3
```

Then:

```txt
9,12,15,18...
```

All divisible by 3.

So all are non-prime.

---

# WHY:

```java
j += i
```

Because:

- multiples increase by i
    

Example:

For:

```txt
i = 5
```

Multiples:

```txt
5,10,15,20,25...
```

Difference always 5.

---

# =========================================================

# 9. WHY START FROM i*i ?

# =========================================================

VERY IMPORTANT OPTIMIZATION.

Suppose:

```txt
i = 5
```

Multiples:

```txt
10,15,20,25...
```

BUT:

```txt
10 already marked by 2
15 already marked by 3
20 already marked by 2
```

So smaller multiples already processed.

First NEW multiple:

```txt
25
```

which equals:

```txt
5 × 5
```

Therefore start from:

```java
i * i
```

This drastically reduces operations.

---

# =========================================================

# 10. DRY RUN

# =========================================================

Suppose:

```txt
n = 10
```

Initial:

|Number|Prime?|
|---|---|
|2|T|
|3|T|
|4|T|
|5|T|
|6|T|
|7|T|
|8|T|
|9|T|
|10|T|

---

# i = 2

Mark multiples:

```txt
4,6,8,10
```

---

# i = 3

Mark:

```txt
9
```

---

# i = 4

Already false.

Skip.

---

# FINAL PRIME NUMBERS

```txt
2,3,5,7
```

---

# =========================================================

# 11. TIME COMPLEXITY

# =========================================================

Complexity:

O(n\log\log n)

VERY FAST.

---

# WHY NOT O(n²)?

Because:

- we only process primes
    
- many numbers skipped
    
- multiples shrink rapidly
    

---

# IMPORTANT MATHEMATICAL IDEA

Operations roughly behave like:

```txt
n/2 + n/3 + n/5 + n/7 ...
```

(primes only)

This grows approximately like:

```txt
log log n
```

Therefore:

```txt
O(n log log n)
```

---

# =========================================================

# 12. SPACE COMPLEXITY

# =========================================================

We use array:

```java
boolean[] prime
```

Size:

```txt
n+1
```

So:

```txt
O(n)
```

---

# =========================================================

# 13. COMPARISON

# =========================================================

|Method|Purpose|Complexity|
|---|---|---|
|Normal Prime Check|One number|O(√n)|
|Repeated Prime Check|All numbers|O(n√n)|
|Sieve of Eratosthenes|All numbers|O(n log log n)|

---

# =========================================================

# 14. WHEN TO USE SIEVE?

# =========================================================

Use sieve when:

- many prime queries
    
- primes from 1 → n
    
- competitive programming
    
- preprocessing
    

---

# =========================================================

# 15. MOST IMPORTANT CONCEPTUAL UNDERSTANDING

# =========================================================

The sieve works because:

```txt
Every composite number
has a smaller prime factor
```

So while processing primes:

- composites automatically get removed
    
- only primes survive
    

That is the entire mathematical foundation of the algorithm.

---

# =========================================================

# 16. FINAL TAKEAWAY

# =========================================================

# SINGLE NUMBER

Use:

```txt
O(√n)
```

prime checking.

---

# ALL NUMBERS

Use:

```txt
Sieve of Eratosthenes
```

with:

```txt
O(n log log n)
```

complexity.

---

# BIGGEST LESSON

Optimization comes from:

- avoiding repeated work
    
- using mathematical observations
    
- preprocessing intelligently