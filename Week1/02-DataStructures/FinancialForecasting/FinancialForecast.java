import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 7: Financial Forecasting.
 *
 * Predicts a future value from a present value that grows at a fixed rate per period,
 * expressed RECURSIVELY:
 *
 *   futureValue(P, r, 0) = P                          (base case)
 *   futureValue(P, r, n) = futureValue(P, r, n-1) * (1 + r)   (recursive case)
 *
 * which is equivalent to the closed form  P * (1 + r)^n.
 *
 * Complexity:
 *   Naive recursion here is O(n) time / O(n) call-stack depth (one call per year).
 *   For repeated queries we add MEMOIZATION so previously computed years are reused,
 *   keeping repeated lookups at O(1) after the first pass.
 *
 * Run inside this folder:  javac *.java  &&  java FinancialForecast
 */
public class FinancialForecast {

    /** Plain recursion: future value after `years`, growing `rate` (e.g. 0.08 = 8%) per year. */
    static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) {                       // base case
            return presentValue;
        }
        return futureValue(presentValue, rate, years - 1) * (1 + rate); // recursive step
    }

    /** Memoized version: caches the growth factor per year to avoid recomputation. */
    static double futureValueMemo(double presentValue, double rate, int years,
                                  Map<Integer, Double> cache) {
        if (years == 0) {
            return presentValue;
        }
        if (cache.containsKey(years)) {
            return cache.get(years);
        }
        double result = futureValueMemo(presentValue, rate, years - 1, cache) * (1 + rate);
        cache.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // starting amount
        double rate = 0.08;           // 8% annual growth
        int years = 5;

        System.out.printf("Present value: %.2f, rate: %.0f%%, years: %d%n",
                presentValue, rate * 100, years);

        double fv = futureValue(presentValue, rate, years);
        System.out.printf("Recursive future value:  %.2f%n", fv);

        Map<Integer, Double> cache = new HashMap<>();
        double fvMemo = futureValueMemo(presentValue, rate, years, cache);
        System.out.printf("Memoized future value:   %.2f%n", fvMemo);

        System.out.println("\nYear-by-year projection:");
        for (int y = 0; y <= years; y++) {
            System.out.printf("  Year %d: %.2f%n", y, futureValue(presentValue, rate, y));
        }
    }
}
