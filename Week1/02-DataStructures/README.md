# Week 1 — Data Structures & Algorithms (Mandatory)

| # | Exercise | Folder | Run |
|---|----------|--------|-----|
| 2 | E-commerce Platform Search | `EcommerceSearch/` | `javac *.java && java ProductSearch` |
| 7 | Financial Forecasting | `FinancialForecasting/` | `javac *.java && java FinancialForecast` |

### Exercise 2 — Search (Big O)
Implements **linear search** `O(n)` on an unsorted array and **binary search** `O(log n)`
on a name-sorted array. Binary search is preferred for a large, frequently searched catalog
because the one-time `O(n log n)` sort is amortized across many fast lookups.

### Exercise 7 — Recursion
`futureValue(P, r, n) = futureValue(P, r, n-1) * (1 + r)` with base case `n == 0`.
Time/stack `O(n)`. A **memoized** variant caches per-year results so repeated queries
run in `O(1)` after the first computation.
