
========================================
COMBINATORICS NOTES — PART 1 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. What is Combinatorics?
2. Factorial
3. Combination (nCr)
4. Permutation (nPr)
5. Pascal Triangle
6. Pascal Triangle Value
7. Deep nCr Intuition
8. Important CP Observations

========================================
1. WHAT IS COMBINATORICS?
========================================

Combinatorics is:
# counting mathematics

Main goal:
# count possibilities efficiently

Used in:
- CP
- probability
- DP
- graph theory
- counting problems
- distributions
- arrangements

VERY important CP topic.

========================================
2. FACTORIAL
========================================

========================================
DEFINITION
========================================

n!

=
1 × 2 × 3 × 4 ... × n

----------------------------------------
EXAMPLES
----------------------------------------

5!

=
1×2×3×4×5

=
120

----------------------------------------

4!

=
24

----------------------------------------

0!

=
1

VERY important.

========================================
WHY FACTORIAL IMPORTANT?
========================================

Factorial represents:
# total arrangements

----------------------------------------
EXAMPLE
----------------------------------------

3 people:

A B C

Possible arrangements:

ABC
ACB
BAC
BCA
CAB
CBA

Total:
6

=
3!

========================================
CODE
========================================

static long factIterative(long n,
                          long m) {

    long ans = 1;

    if (n == 0 || n == 1) {
        return ans;
    }

    for (int i = 1; i <= n; i++) {

        ans = (ans * i) % m;
    }

    return ans;
}

========================================
WHY MOD USED?
========================================

Factorials become HUGE extremely fast.

Example:

20!

already enormous.

Modulo prevents:
- overflow
- huge numbers

VERY important in CP.

========================================
3. COMBINATION (nCr)
========================================

========================================
MEANING
========================================

Choose:
r objects

from:
n objects

Order:
# does NOT matter

========================================
FORMULA
========================================

nCr

=
n! / (r!(n-r)!)

========================================
EXAMPLE
========================================

5C2

=
5! / (2!×3!)

=
120 / (2×6)

=
10

========================================
DEEP INTUITION
========================================

Suppose selecting:
2 students

from:
A B C D E

----------------------------------------
ALL POSSIBLE SELECTIONS
----------------------------------------

AB
AC
AD
AE
BC
BD
BE
CD
CE
DE

Total:
10

========================================
MOST IMPORTANT INTUITION
========================================

Combination means:
# group selection only

NOT arrangement.

----------------------------------------
VERY IMPORTANT
----------------------------------------

AB and BA:
same combination.

Because:
same group selected.

========================================
WHY DIVIDE BY r! ?
========================================

Suppose:
5!

counts ALL arrangements.

For every chosen group:
internal arrangements repeat.

Example:

AB
BA

same combination.

Need remove duplicates.

----------------------------------------
SO:
----------------------------------------

divide by:
r!

VERY important intuition.

========================================
4. PERMUTATION (nPr)
========================================

========================================
MEANING
========================================

Arrange:
r positions

from:
n objects

Order:
# matters

========================================
FORMULA
========================================

nPr

=
n! / (n-r)!

========================================
EXAMPLE
========================================

5P2

=
5! / 3!

=
120 / 6

=
20

========================================
WHY THIS FORMULA?
========================================

Suppose:

5 chairs.

Need fill:
2 positions.

----------------------------------------
FIRST POSITION
----------------------------------------

5 choices

----------------------------------------
SECOND POSITION
----------------------------------------

4 choices

----------------------------------------
TOTAL
----------------------------------------

5 × 4

=
20

Correct.

========================================
MOST IMPORTANT DIFFERENCE
========================================

----------------------------------------
COMBINATION
----------------------------------------

AB = BA

Order ignored.

----------------------------------------
PERMUTATION
----------------------------------------

AB ≠ BA

Order matters.

========================================
IMPORTANT RELATION
========================================

nPr
=
nCr × r!

----------------------------------------
WHY?
----------------------------------------

Step 1:
Choose group:
nCr

Step 2:
Arrange chosen group:
r!

VERY important relation.

========================================
5. PASCAL TRIANGLE
========================================

VERY important combinatorics structure.

========================================
CODE
========================================

static int[][] pascalsTriangle(int n) {

    int[][] ans =
    new int[n + 1][n + 1];

    for (int i = 0; i <= n; i++) {

        for (int j = 0; j <= i; j++) {

            if (j == 0 || j == i) {

                ans[i][j] = 1;

            } else {

                ans[i][j] =
                ans[i - 1][j - 1]
                +
                ans[i - 1][j];
            }
        }
    }

    return ans;
}

========================================
GENERATED TRIANGLE
========================================

1

1 1

1 2 1

1 3 3 1

1 4 6 4 1

1 5 10 10 5 1

========================================
MOST IMPORTANT OBSERVATION
========================================

Every inner value:

=
sum of:
two values above it

----------------------------------------
EXAMPLE
----------------------------------------

6

comes from:

3 + 3

========================================
CORE FORMULA
========================================

nCr

=
(n-1)C(r-1)
+
(n-1)Cr

VERY important recurrence.

========================================
WHY THIS WORKS?
========================================

Suppose:
building groups of size:
r

from:
n elements.

----------------------------------------
CASE 1
----------------------------------------

Take current element.

Need:
r-1 more

Ways:

(n-1)C(r-1)

----------------------------------------
CASE 2
----------------------------------------

Do NOT take current element.

Need:
r elements still.

Ways:

(n-1)Cr

----------------------------------------
TOTAL
----------------------------------------

Add both cases.

VERY important combinatorics logic.

========================================
6. PASCAL TRIANGLE VALUE
========================================

========================================
GOAL
========================================

Find specific:
nCr

without generating full triangle.

========================================
CODE
========================================

static long pascalsValue(long n,
                         long r,
                         long m) {

    long neno =
    fact(n, m);

    long deno =
    (fact(r, m)
    *
    fact(n-r, m))
    % m;

    long inverse =
    modInverse(deno, m);

    return
    (neno * inverse) % m;
}

========================================
MOST IMPORTANT OBSERVATION
========================================

Every Pascal Triangle value:
# directly equals nCr

----------------------------------------
EXAMPLE
----------------------------------------

5th row:

1 5 10 10 5 1

These are:

5C0
5C1
5C2
5C3
5C4
5C5

VERY important connection.

========================================
7. IMPORTANT CP OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

Factorial:
counts arrangements.

----------------------------------------
OBSERVATION 2
----------------------------------------

Combination:
selection only.

----------------------------------------
OBSERVATION 3
----------------------------------------

Permutation:
arrangement.

----------------------------------------
OBSERVATION 4
----------------------------------------

Pascal triangle stores:
all nCr values.

----------------------------------------
OBSERVATION 5
----------------------------------------

Many counting problems secretly reduce to:
nCr.

========================================
8. COMMON CP RECOGNITION
========================================

WHEN TO THINK nCr?
----------------------------------------

- choose groups
- selection
- subsets
- paths
- distributions

----------------------------------------
WHEN TO THINK nPr?
----------------------------------------

- arrangements
- positions
- rankings
- order matters

----------------------------------------
WHEN TO THINK PASCAL TRIANGLE?
----------------------------------------

- recursive combinations
- DP counting
- combinatorics recurrence

========================================
9. COMMON MISTAKES
========================================

----------------------------------------
MISTAKE 1
----------------------------------------

Confusing:
combination and permutation.

Always ask:
# does order matter?

----------------------------------------
MISTAKE 2
----------------------------------------

Direct division under modulo.

Need:
mod inverse.

----------------------------------------
MISTAKE 3
----------------------------------------

Generating full Pascal triangle unnecessarily.

Sometimes direct nCr enough.

========================================
10. MOST IMPORTANT FINAL INTUITION
========================================

Combinatorics is fundamentally:
# counting structured choices

Main ideas:
- choose
- arrange
- distribute
- count carefully

Most hard CP counting problems reduce to:
- combinations
- permutations
- recurrence relations

========================================
END OF COMBINATORICS NOTES — PART 1 🔥
========================================

========================================
COMBINATORICS NOTES — PART 2 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Stars and Bars
2. Positive Integer Solutions
3. Distribution Problems
4. Deep Stars and Bars Intuition
5. Inclusion Exclusion Principle
6. Overlapping Counting
7. Inclusion Exclusion for 2 Sets
8. Inclusion Exclusion for 3 Sets
9. LCM Connection
10. Important CP Observations

========================================
1. STARS AND BARS
========================================

VERY important combinatorics topic.

Used in:
- distributions
- integer solutions
- grouping problems

========================================
MAIN IDEA
========================================

Distribute:
n identical objects

among:
k groups

========================================
CLASSIC PROBLEM
========================================

Distribute:
5 candies

among:
3 students

========================================
MOST IMPORTANT INTUITION
========================================

Candies are:
# identical

Only distribution matters.

----------------------------------------
EXAMPLE
----------------------------------------

2 candies to A
1 candy to B
2 candies to C

Distribution:

2 1 2

========================================
2. STARS AND BARS VISUALIZATION
========================================

Represent candies using:
# stars

Represent separators using:
# bars

----------------------------------------
EXAMPLE
----------------------------------------

5 candies:

*****

Need:
3 students

Need:
2 separators

Example arrangement:

**|*|**

Meaning:

Student1:
2

Student2:
1

Student3:
2

========================================
MOST IMPORTANT OBSERVATION
========================================

Total objects:

5 stars
+
2 bars

=
7 positions

Need choose:
2 positions for bars.

========================================
FORMULA
========================================

(n+k-1)C(k-1)

VERY important formula.

========================================
3. STARS AND BARS CODE
========================================

CODE:

static long starsAndBars(long n,
                         long k,
                         long m) {

    return nCr(n + k - 1,
               k - 1,
               m);
}

========================================
DEEP INTUITION
========================================

Suppose:

5 candies
3 students

----------------------------------------
TOTAL POSITIONS
----------------------------------------

5 stars
+
2 bars

=
7

----------------------------------------
CHOOSE BAR POSITIONS
----------------------------------------

7C2

=
21

DONE.

========================================
WHY NOT 5C3 ?
========================================

VERY important confusion.

----------------------------------------
5C3 means:
----------------------------------------

Choose:
3 objects from 5

NOT:
distribution.

----------------------------------------
REAL CHOICE HERE
----------------------------------------

Choosing:
# separator positions

NOT candies.

VERY important intuition.

========================================
4. POSITIVE INTEGER SOLUTIONS
========================================

========================================
PROBLEM
========================================

Every student must get:
# at least 1 candy

========================================
EXAMPLE
========================================

x₁+x₂+x₃=5

where:

xᵢ >0

========================================
MOST IMPORTANT IDEA
========================================

Give:
1 candy to everyone first.

----------------------------------------
AFTER GIVING
----------------------------------------

Remaining candies:

5-3

=
2

Now distribute normally.

========================================
FORMULA
========================================

(n-1)C(k-1)

========================================
CODE
========================================

static long positiveSolutions(long n,
                              long k,
                              long m) {

    return nCr(n - 1,
               k - 1,
               m);
}

========================================
EXAMPLE
========================================

5 candies
3 students

----------------------------------------
FORMULA
----------------------------------------

4C2

=
6

========================================
ACTUAL SOLUTIONS
========================================

1 1 3
1 2 2
1 3 1
2 1 2
2 2 1
3 1 1

Total:
6

========================================
5. IMPORTANT STARS AND BARS OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

Objects:
identical

Groups:
distinct

----------------------------------------
OBSERVATION 2
----------------------------------------

Bars represent:
group boundaries

----------------------------------------
OBSERVATION 3
----------------------------------------

Distribution problems often become:
separator placement problems

VERY important transformation skill.

========================================
6. INCLUSION EXCLUSION PRINCIPLE
========================================

VERY important counting technique.

========================================
MAIN PROBLEM
========================================

When multiple groups:
# overlap

normal addition:
fails.

========================================
CLASSIC EXAMPLE
========================================

Count numbers from:
1 →10

divisible by:
2 OR 3

========================================
DIVISIBLE BY 2
========================================

2 4 6 8 10

Count:
5

========================================
DIVISIBLE BY 3
========================================

3 6 9

Count:
3

----------------------------------------
NAIVE ADDITION
----------------------------------------

5+3

=
8

WRONG.

========================================
WHY WRONG?
========================================

Because:
6 counted twice.

----------------------------------------
ONCE IN:
----------------------------------------

divisible by 2

----------------------------------------
AGAIN IN:
----------------------------------------

divisible by 3

========================================
MOST IMPORTANT INTUITION
========================================

Overlap causes:
# overcounting

========================================
7. INCLUSION EXCLUSION FORMULA
========================================

For 2 sets:

A∪B

=
A+B-AB

========================================
WHY SUBTRACT?
========================================

Intersection counted twice.

Need remove duplicate count once.

========================================
EXAMPLE
========================================

Count:
1→10

divisible by:
2 OR 3

----------------------------------------
DIVISIBLE BY 2
----------------------------------------

10/2

=
5

----------------------------------------
DIVISIBLE BY 3
----------------------------------------

10/3

=
3

----------------------------------------
OVERLAP
----------------------------------------

LCM(2,3)=6

10/6

=
1

----------------------------------------
FINAL
----------------------------------------

5+3-1

=
7

Correct.

========================================
8. WHY LCM USED?
========================================

MOST IMPORTANT OBSERVATION.

----------------------------------------
INTERSECTION MEANS:
----------------------------------------

Divisible by BOTH.

----------------------------------------
NUMBERS DIVISIBLE BY BOTH:
----------------------------------------

Common multiples.

Generated by:
# LCM

VERY important observation.

========================================
9. INCLUSION EXCLUSION FOR 3 SETS
========================================

========================================
FORMULA
========================================

A+B+C
-AB-BC-AC
+ABC

========================================
WHY +ABC AGAIN?
========================================

VERY important intuition.

----------------------------------------
Suppose element belongs to:
----------------------------------------

ALL THREE sets.

----------------------------------------
INITIAL ADDITION
----------------------------------------

+3 times

----------------------------------------
PAIR SUBTRACTIONS
----------------------------------------

-3 times

Total:
0

But should appear:
1 time.

So:
add once again.

========================================
THIS CREATES:
========================================

Alternating signs.

========================================
10. THREE SET EXAMPLE
========================================

Count numbers:
1→100

divisible by:
2 OR 3 OR 5

========================================
INDIVIDUALS
========================================

100/2 =50

100/3 =33

100/5 =20

========================================
PAIR INTERSECTIONS
========================================

100/6 =16

100/10 =10

100/15 =6

========================================
TRIPLE INTERSECTION
========================================

100/30 =3

========================================
FINAL
========================================

50+33+20
-16-10-6
+3

=
74

========================================
11. INCLUSION EXCLUSION CODE
========================================

CODE:

static long count(long n,
                  long a,
                  long b) {

    long divisibleByA = n / a;

    long divisibleByB = n / b;

    long overlap =
    n / lcm(a, b);

    return divisibleByA
           + divisibleByB
           - overlap;
}

========================================
THREE SET CODE
========================================

static long countThree(long n) {

    long a = n / 2;

    long b = n / 3;

    long c = n / 5;

    long ab = n / lcm(2, 3);

    long bc = n / lcm(3, 5);

    long ac = n / lcm(2, 5);

    long abc =
    n / lcm(2,
        lcm(3, 5));

    return a+b+c
           -ab-bc-ac
           +abc;
}

========================================
12. IMPORTANT CP OBSERVATIONS
========================================

----------------------------------------
OBSERVATION 1
----------------------------------------

OR conditions often indicate:
Inclusion Exclusion.

----------------------------------------
OBSERVATION 2
----------------------------------------

Distribution problems often indicate:
Stars and Bars.

----------------------------------------
OBSERVATION 3
----------------------------------------

Overlaps require:
subtraction.

----------------------------------------
OBSERVATION 4
----------------------------------------

Triple overlaps require:
adding back again.

========================================
13. COMMON CP RECOGNITION
========================================

WHEN TO THINK STARS AND BARS?
----------------------------------------

- distribute objects
- integer solutions
- partitions
- grouping

----------------------------------------
WHEN TO THINK IEP?
----------------------------------------

- OR conditions
- overlap counting
- at least one
- forbidden conditions

========================================
14. MOST IMPORTANT FINAL INTUITION
========================================

Stars and Bars:
# transforms distributions into separator placement

Inclusion Exclusion:
# fixes overcounting caused by overlaps

These are:
# transformation techniques

VERY important in combinatorics CP problems.

========================================
END OF COMBINATORICS NOTES — PART 2 🔥
========================================


========================================
COMBINATORICS NOTES — PART 3 🔥
========================================

Based on Code File:
:contentReference[oaicite:0]{index=0}

TOPICS COVERED:
1. Deep Pascal Triangle Intuition
2. Why Pascal Recurrence Works
3. Distribution vs Selection
4. Combination Transformation Thinking
5. Inclusion Exclusion Deep Logic
6. Alternating Sign Intuition
7. Complexity Analysis
8. Important CP Recognition Patterns
9. Common Mistakes
10. Real Combinatorics Thinking

========================================
1. DEEP PASCAL TRIANGLE INTUITION
========================================

MOST IMPORTANT IDEA:

Every Pascal Triangle value:
# represents combinations

----------------------------------------
EXAMPLE
----------------------------------------

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

----------------------------------------
MEANING
----------------------------------------

4th row:

1 4 6 4 1

Actually means:

4C0
4C1
4C2
4C3
4C4

========================================
WHY TRIANGLE SHAPE?
========================================

Because every row:
has one extra position.

----------------------------------------
ROW 0
----------------------------------------

1 value

----------------------------------------
ROW 1
----------------------------------------

2 values

----------------------------------------
ROW 2
----------------------------------------

3 values

and so on.

========================================
2. WHY PASCAL RECURRENCE WORKS
========================================

MOST IMPORTANT FORMULA:

nCr

=
(n-1)C(r-1)
+
(n-1)Cr

========================================
DEEP INTUITION
========================================

Suppose:
need choose:
r elements

from:
n elements.

----------------------------------------
FOCUS ON:
----------------------------------------

current nth element.

Now only:
2 possibilities exist.

========================================
CASE 1
========================================

Take current element.

Then:
need:
r-1 more elements

from:
remaining n-1 elements.

Ways:

(n-1)C(r-1)

========================================
CASE 2
========================================

Do NOT take current element.

Still need:
r elements

from:
remaining n-1 elements.

Ways:

(n-1)Cr

========================================
TOTAL WAYS
========================================

Add both cases.

VERY important combinatorics logic.

========================================
3. DISTRIBUTION vs SELECTION
========================================

VERY important confusion in combinatorics.

========================================
SELECTION
========================================

Choose objects.

Usually:
nCr

----------------------------------------
EXAMPLE
----------------------------------------

Choose:
3 students from 10

=
10C3

========================================
DISTRIBUTION
========================================

Distribute objects among groups.

Usually:
Stars and Bars.

----------------------------------------
EXAMPLE
----------------------------------------

Distribute:
5 candies among 3 students.

NOT:
5C3

VERY important difference.

========================================
WHY NOT 5C3?
========================================

Because:
5C3 means:
# choosing objects

But distribution problem asks:
# where separators go

Completely different thinking.

========================================
4. STARS AND BARS DEEP THINKING
========================================

MOST IMPORTANT IDEA:

Distribution transforms into:
# separator placement

========================================
EXAMPLE
========================================

5 candies
3 students

----------------------------------------
STARS
----------------------------------------

*****

----------------------------------------
BARS
----------------------------------------

Need:
2 bars

Example:

**|*|**

Means:

2 1 2

========================================
REAL DECISION
========================================

Choosing:
# positions of bars

NOT candies.

VERY important transformation.

========================================
TOTAL POSITIONS
========================================

5 stars
+
2 bars

=
7 positions

Choose:
2 bar positions

=
7C2

========================================
5. POSITIVE SOLUTIONS DEEP INTUITION
========================================

Suppose:

x₁+x₂+x₃=5

where:

xᵢ >0

========================================
MOST IMPORTANT IDEA
========================================

Every variable must get:
# minimum 1

----------------------------------------
SO FIRST:
----------------------------------------

Give:
1 to everyone.

Used:
3 candies.

Remaining:
2 candies.

Now distribute freely.

========================================
THIS CREATES FORMULA
========================================

(n-1)C(k-1)

VERY important.

========================================
6. INCLUSION EXCLUSION DEEP LOGIC
========================================

MOST IMPORTANT IDEA:

Overlaps create:
# duplicate counting

========================================
EXAMPLE
========================================

Count numbers:
1→10

divisible by:
2 OR 3

========================================
DIVISIBLE BY 2
========================================

2 4 6 8 10

Count:
5

========================================
DIVISIBLE BY 3
========================================

3 6 9

Count:
3

----------------------------------------
NAIVE TOTAL
----------------------------------------

8

WRONG.

========================================
WHY WRONG?
========================================

Because:
6 counted twice.

========================================
REAL FIX
========================================

Subtract overlap once.

----------------------------------------
FORMULA
----------------------------------------

A+B-AB

========================================
7. WHY ALTERNATING SIGNS?
========================================

VERY important deep intuition.

========================================
THREE SETS
========================================

A+B+C
-AB-BC-AC
+ABC

========================================
WHY +ABC AGAIN?
========================================

Suppose element belongs to:
all 3 sets.

----------------------------------------
INITIAL ADDITION
----------------------------------------

+3

----------------------------------------
PAIR SUBTRACTIONS
----------------------------------------

-3

Total:
0

But should appear:
1 time.

So:
add once again.

========================================
THIS CREATES:
========================================

Alternating signs.

VERY important.

========================================
8. WHY LCM IN INTERSECTION?
========================================

Intersection means:
# divisible by BOTH

Numbers divisible by both:
generated by:
LCM.

----------------------------------------
EXAMPLE
----------------------------------------

Divisible by:
2 and 3

Common multiples:

6 12 18 ...

Generated by:
LCM(2,3)=6

VERY important observation.

========================================
9. IMPORTANT COMPLEXITIES
========================================

----------------------------------------
FACTORIAL
----------------------------------------

O(n)

----------------------------------------
BINARY EXPONENTIATION
----------------------------------------

O(log n)

----------------------------------------
nCr
----------------------------------------

Depends on factorial preprocessing.

----------------------------------------
PASCAL TRIANGLE
----------------------------------------

O(n²)

----------------------------------------
INCLUSION EXCLUSION
----------------------------------------

Usually:
O(2^k)

for:
k sets.

========================================
10. IMPORTANT CP RECOGNITION
========================================

WHEN TO THINK nCr?
----------------------------------------

- choose groups
- subsets
- paths
- selections

----------------------------------------
WHEN TO THINK nPr?
----------------------------------------

- rankings
- arrangements
- order matters

----------------------------------------
WHEN TO THINK STARS AND BARS?
----------------------------------------

- distributions
- integer equations
- partitioning

----------------------------------------
WHEN TO THINK IEP?
----------------------------------------

- OR conditions
- overlaps
- at least one
- forbidden conditions

========================================
11. COMMON MISTAKES
========================================

----------------------------------------
MISTAKE 1
----------------------------------------

Confusing:
distribution and selection.

----------------------------------------
MISTAKE 2
----------------------------------------

Using:
5C3

for stars and bars problems.

Wrong interpretation.

----------------------------------------
MISTAKE 3
----------------------------------------

Forgetting:
order matters?

Decides:
nCr vs nPr

----------------------------------------
MISTAKE 4
----------------------------------------

Double counting overlaps in IEP.

========================================
12. REAL COMBINATORICS THINKING
========================================

The REAL skill is:
# transforming problems

Ask:

- Is this selection?
- Is this arrangement?
- Is this distribution?
- Are overlaps happening?
- Are objects identical?
- Does order matter?

THAT is real combinatorics thinking.

========================================
13. MOST IMPORTANT FINAL TAKEAWAYS
========================================

14. Combinatorics is structured counting
15. Pascal Triangle stores combinations
16. nCr = selection
17. nPr = arrangement
18. Stars and Bars = distribution transformation
19. IEP fixes overlap overcounting
20. Most hard counting problems reduce to transformations
21. Recognition is more important than formulas

========================================
END OF COMBINATORICS NOTES 🔥
========================================