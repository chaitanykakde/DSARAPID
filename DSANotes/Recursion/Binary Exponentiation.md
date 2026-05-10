# Binary Exponentiation

## Core Idea

Instead of multiplying `a` exactly `n` times:

```text
a × a × a × a ...
```

reduce the exponent by half recursively.

Uses:

a^n = (a^{n/2})^2

This reduces complexity from:

O(n) \rightarrow O(\log n)

---

# When To Use

Use Binary Exponentiation when:

- exponent is very large
    
- modulo is involved
    
- normal multiplication becomes too slow
    
- exact integer computation is needed
    
- `Math.pow()` may overflow or lose precision
    

Common in:

- modular arithmetic
    
- competitive programming
    
- cryptography
    
- combinatorics
    
- matrix exponentiation
    

---

# What Problem It Solves

Efficiently computes:

a^n

or:

a^n \bmod M

without generating gigantic numbers.

---

# Recursive Flow

Recursive call:

```text
pow(a,n/2)
```

returns smaller subproblem answer.

That returned value is reused instead of recomputing.

---

# Even Power Handling

If exponent is EVEN:

a^6 = (a^3)^2

Steps:

```text
result = pow(a,n/2)
result = result × result
```

No extra multiplication needed.

---

# Odd Power Handling

If exponent is ODD:

a^5 = (a^2)^2 \times a

Steps:

```text
result = pow(a,n/2)
result = result × result
result = result × a
```

Extra `× a` handles missing power.

---

# Base Case

```text
a^0 = 1
```

Recursive stopping condition.

---

# Why Modulo Is Applied

Without modulo:

```text
numbers become extremely huge
```

Use:

(a\times b)\bmod M=((a\bmod M)(b\bmod M))\bmod M

to keep values bounded during every multiplication.

---

# Why NOT Math.pow()

`Math.pow()`:

- uses `double`
    
- causes precision loss
    
- unsafe for huge powers
    
- cannot reliably handle modulo arithmetic
    

Binary exponentiation:

- uses integer arithmetic
    
- exact computation
    
- safe with modulo
    
- logarithmic complexity
    

---

# Complexity

Time:

O(\log n)

because exponent halves each recursion.

Space (recursive):

O(\log n)

due to recursion stack.

---

# Recursive Example

Find:

5^6

Flow:

```text
5^6
↓
5^3
↓
5^1
↓
5^0
```

Return phase:

```text
5^0 = 1

5^1 = 1×1×5 = 5

5^3 = 5×5×5 = 125

5^6 = 125×125 = 15625
```

---

# Core Pattern Recognition

If problem contains:

- huge exponent
    
- modulo
    
- power calculation
    
- time limit issues
    

think:

```text
Binary Exponentiation
```

---

# Common Mistakes

- using `Math.pow()`
    
- forgetting modulo after multiplication
    
- using `int` instead of `long`
    
- not handling odd exponent separately
    
- recomputing subproblems repeatedly
    

---

# Minimal Template

```java
pow(a,n):
    if n==0 return 1

    result = pow(a,n/2)

    result = result * result

    if n is odd:
        result = result * a

    return result




