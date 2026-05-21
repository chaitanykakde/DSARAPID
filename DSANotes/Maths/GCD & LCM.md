# COMPLETE NOTES : GCD AND LCM IN JAVA

# Greatest Common Divisor & Least Common Multiple

---

# =========================================================

# 1. WHAT IS GCD?

# =========================================================

GCD means:

```txt
Greatest Common Divisor
```

Also called:

```txt
HCF (Highest Common Factor)
```

It is:

```txt
The largest number that divides both numbers
```

---

# EXAMPLE

```txt
a = 12
b = 18
```

Divisors of 12:

```txt
1,2,3,4,6,12
```

Divisors of 18:

```txt
1,2,3,6,9,18
```

Common divisors:

```txt
1,2,3,6
```

Largest common divisor:

```txt
6
```

Therefore:

```txt
GCD(12,18) = 6
```

---

# =========================================================

# 2. WHAT IS LCM?

# =========================================================

LCM means:

```txt
Least Common Multiple
```

It is:

```txt
The smallest number divisible by both numbers
```

---

# EXAMPLE

```txt
a = 12
b = 18
```

Multiples of 12:

```txt
12,24,36,48...
```

Multiples of 18:

```txt
18,36,54...
```

First common multiple:

```txt
36
```

Therefore:

```txt
LCM(12,18) = 36
```

---

# =========================================================

# 3. MOST IMPORTANT RELATION

# =========================================================

Very famous mathematical relation:

GCD(a,b)\times LCM(a,b)=a\times b

This formula is the foundation of most LCM implementations.

---

# EXAMPLE

```txt
a = 12
b = 18
```

GCD:

```txt
6
```

LCM:

```txt
36
```

Now:

```txt
6 × 36 = 216
12 × 18 = 216
```

Correct.

---

# =========================================================

# 4. EUCLIDEAN ALGORITHM (MOST IMPORTANT)

# =========================================================

Efficient algorithm to calculate GCD.

Main formula:

\gcd(a,b)=\gcd(b,a\bmod b)

---

# WHY THIS WORKS

Suppose:

```txt
a = 18
b = 12
```

Then:

```txt
18 % 12 = 6
```

Now:

```txt
gcd(18,12)
=
gcd(12,6)
```

Again:

```txt
12 % 6 = 0
```

Now:

```txt
gcd(6,0)=6
```

Answer:

```txt
6
```

---

# =========================================================

# 5. YOUR RECURSIVE GCD + LCM CODE

# =========================================================

```java
class GCD {

    public static void main(String[] args) {

        System.out.println("GCD : " + gcd(5,10));

        System.out.println("LCM : " + lcm(5,10));
    }

    /*
     Euclidean Algorithm
    */
    static int gcd(int a, int b){

        /*
         Base condition

         When b becomes 0,
         answer is stored in a
        */
        if(b == 0){
            return a;
        }

        /*
         Recursive call

         gcd(a,b)
         becomes
         gcd(b,a%b)
        */
        return gcd(b, a % b);
    }

    /*
     LCM formula:

     LCM(a,b) = (a*b)/GCD(a,b)
    */
    static int lcm(int a, int b){

        return (a * b) / gcd(a,b);
    }
}
```

---

# =========================================================

# 6. RECURSION FLOW OF GCD

# =========================================================

Suppose:

```txt
gcd(18,12)
```

Step 1:

```txt
gcd(12,6)
```

because:

```txt
18 % 12 = 6
```

---

Step 2:

```txt
gcd(6,0)
```

because:

```txt
12 % 6 = 0
```

---

Step 3:

```txt
return 6
```

---

# =========================================================

# 7. ITERATIVE GCD VERSION

# =========================================================

Same algorithm without recursion.

```java
static int gcd(int a, int b){

    while(b != 0){

        int rem = a % b;

        a = b;

        b = rem;
    }

    return a;
}
```

---

# DRY RUN

```txt
a = 18
b = 12
```

---

Iteration 1:

```txt
rem = 18 % 12 = 6

a = 12
b = 6
```

---

Iteration 2:

```txt
rem = 12 % 6 = 0

a = 6
b = 0
```

Loop stops.

Return:

```txt
6
```

---

# =========================================================

# 8. TIME COMPLEXITY OF GCD

# =========================================================

Euclidean Algorithm complexity:

O(\log(\min(a,b)))

VERY FAST.

---

# WHY LOGARITHMIC?

Because modulo operation reduces numbers rapidly.

Example:

```txt
gcd(1000000,2)
```

finishes in very few steps.

---

# =========================================================

# 9. SPACE COMPLEXITY

# =========================================================

Recursive version:

```txt
O(log n)
```

because recursion stack used.

---

Iterative version:

```txt
O(1)
```

No recursion stack.

---

# =========================================================

# 10. BUILT-IN GCD FUNCTION IN JAVA

# =========================================================

Java does NOT provide:

```java
Math.gcd()
```

But built-in GCD exists in:

```txt
BigInteger class
```

---

# IMPORT

```java
import java.math.BigInteger;
```

---

# BUILT-IN GCD CODE

```java
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        int a = 12;
        int b = 18;

        /*
         Convert int → BigInteger
        */

        BigInteger A = BigInteger.valueOf(a);

        BigInteger B = BigInteger.valueOf(b);

        /*
         Built-in gcd function
        */

        BigInteger ans = A.gcd(B);

        System.out.println(ans);
    }
}
```

Output:

```txt
6
```

---

# SHORT VERSION

```java
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        int gcd =
            BigInteger.valueOf(12)
            .gcd(BigInteger.valueOf(18))
            .intValue();

        System.out.println(gcd);
    }
}
```

---

# =========================================================

# 11. IS BUILT-IN LCM AVAILABLE?

# =========================================================

NO.

Java has:

- ❌ no `Math.lcm()`
    
- ❌ no `BigInteger.lcm()`
    

So LCM is implemented manually.

---

# =========================================================

# 12. SAFER LCM IMPLEMENTATION

# =========================================================

This can overflow:

```java
(a*b)
```

For large numbers.

---

# SAFER VERSION

```java
static long lcm(long a, long b){

    return (a / gcd(a,b)) * b;
}
```

Division first reduces overflow chances.

---

# COMPLETE SAFE VERSION

```java
class Main {

    static long gcd(long a, long b){

        while(b != 0){

            long rem = a % b;

            a = b;

            b = rem;
        }

        return a;
    }

    static long lcm(long a, long b){

        return (a / gcd(a,b)) * b;
    }

    public static void main(String[] args) {

        System.out.println(gcd(12,18));

        System.out.println(lcm(12,18));
    }
}
```

---

# =========================================================

# 13. BRUTE FORCE GCD (BAD APPROACH)

# =========================================================

```java
static int gcd(int a, int b){

    int ans = 1;

    for(int i = 1; i <= Math.min(a,b); i++){

        if(a%i==0 && b%i==0){

            ans = i;
        }
    }

    return ans;
}
```

---

# TIME COMPLEXITY

```txt
O(min(a,b))
```

Too slow for large inputs.

---

# Euclidean Algorithm is MUCH faster.

---

# =========================================================

# 14. IMPORTANT INTERVIEW OBSERVATIONS

# =========================================================

If:

```txt
GCD(a,b)=1
```

Then numbers are:

```txt
Co-prime
```

Example:

```txt
8 and 15
```

Only common divisor:

```txt
1
```

---

# =========================================================

# 15. WHERE GCD & LCM ARE USED

# =========================================================

Very important in:

- Fractions
    
- Ratio simplification
    
- Number theory
    
- Competitive programming
    
- Cryptography
    
- Modular arithmetic
    
- Scheduling problems
    
- Cyclic problems
    

---

# =========================================================

# 16. FINAL COMPARISON

# =========================================================

|Concept|Meaning|
|---|---|
|GCD|Largest common divisor|
|LCM|Smallest common multiple|

---

|Algorithm|Complexity|
|---|---|
|Brute Force GCD|O(min(a,b))|
|Euclidean GCD|O(log(min(a,b)))|

---

|Java Built-in|Available?|
|---|---|
|Math.gcd()|❌|
|BigInteger.gcd()|✅|
|Math.lcm()|❌|

---

# =========================================================

# 17. MOST IMPORTANT TAKEAWAY

# =========================================================

The key mathematical insight:

```txt
Common divisors do not change
after modulo operation
```

That is why:

\gcd(a,b)=\gcd(b,a\bmod b)

works so efficiently.