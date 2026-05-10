
# Count Good Numbers

## Core Observation

Indices are divided into:

```text
Even indices
Odd indices
```

Rules:

```text
Even index  -> even digits only
Odd index   -> prime digits only
```

---

# Choices Per Position

## Even Indices

Possible digits:

```text
0 2 4 6 8
```

Total choices:

```text
5
```

---

## Odd Indices

Possible digits:

```text
2 3 5 7
```

Total choices:

```text
4
```
![[Screenshot 2026-05-10 at 3.24.36 PM.png]]
---

# Key Reduction

Problem is NOT asking to generate numbers.

Problem is asking:

```text
How many total valid combinations exist?
```

Independent choices multiply.

So total count becomes:

5^{evenCount}\times4^{oddCount}

---

# Counting Even/Odd Positions

For length `n`:

## Even Positions

```text
(n + 1) / 2
```

because indexing starts from `0`.

---

## Odd Positions

```text
n / 2
```
![[Screenshot 2026-05-10 at 3.27.10 PM.png]]
---

# Final Formula

5^{(n+1)/2}\times4^{n/2}

---

# Main Difficulty

Exponent becomes extremely large.

Constraints:

n\le10^{15}

Normal power computation becomes impossible.

---

# Why Binary Exponentiation Is Needed

Naive multiplication:

O(n)

Too slow for huge exponents.

Binary exponentiation reduces complexity to:

O(\log n)

by halving exponent recursively.

---

# Why Modulo Is Needed

Actual value becomes astronomically huge.

Use modulo to:

- prevent overflow
    
- keep values bounded
    
- preserve valid remainder arithmetic
    

Modulo used:

10^9+7

because:

- prime number
    
- safe for modular arithmetic
    
- fits integer range
    

---

# Important Modulo Property

(a\times b)\bmod M=((a\bmod M)(b\bmod M))\bmod M

Allows reducing values during every multiplication.

---

# Why NOT Math.pow()

`Math.pow()`:

- uses `double`
    
- causes precision loss
    
- unsafe for huge powers
    
- unsuitable for modulo arithmetic
    

Binary exponentiation uses:

- integer arithmetic
    
- exact computation
    
- modulo-safe operations
    

---

# Recursive Power Logic

## Even Exponent

a^6=(a^3)^2

Only square recursive result.

---

## Odd Exponent

a^5=(a^2)^2\times a

Extra multiplication handles missing power.

---

# Recursive Flow Example

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

# Complexity

Time:

O(\log n)

Space (recursive stack):

O(\log n)

---

# Pattern Recognition

If problem contains:

- huge exponent
    
- modulo
    
- counting combinations
    
- power computation
    

think:

```text
Binary Exponentiation + Modular Arithmetic
```

---

# Common Mistakes

- using `Math.pow()`
    
- using `int` instead of `long`
    
- forgetting modulo after multiplication
    
- misunderstanding even/odd index count
    
- not handling odd exponent separately