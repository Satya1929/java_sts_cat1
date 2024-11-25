import java.util.*;

public class Sieve {

    // Simple Sieve to find primes up to 'limit' and store them in 'prime'
    static void simple_sieve(int limit, ArrayList<Integer> prime) {
        ArrayList<Boolean> mark = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            mark.add(false);
        }
        for (int p = 2; p * p <= limit; p++) {
            if (!mark.get(p)) {
                prime.add(p);
                for (int i = p * p; i < limit; i += p) {
                    mark.set(i, true);
                }
            }
        }
    }

    // Segmented Sieve to find primes in the range [low, high]
    static void segmented_sieve(int low, int high) {

        //generate the killers who will cut others as composite
        int limit = (int) Math.sqrt(high) + 1;
        ArrayList<Integer> prime = new ArrayList<>();
        simple_sieve(limit, prime);

        //create array to store whi killed who left using L-R
        ArrayList<Boolean> mark = new ArrayList<>(high - low + 1);
        for (int i = 0; i < high - low + 1; i++) {
            mark.add(false);
        }

        //new is starting point
        for (int p : prime) {

            //new is starting point = firstmultiple or p*p
            int first_multiple = (low / p) * p;
            if (first_multiple < low) {
                first_multiple += p;
            }
            int start = Math.max(p * p, first_multiple);
            
            for (int i = start; i <= high; i += p) {
                mark.set(i - low, true);
            }
        }
        // Print the primes in the range [low, high]
        for (int i = low; i <= high; ++i) {
            if (!mark.get(i - low) && i >= 2) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        int low = 10; // Example: lower bound
        int high = 50; // Example: upper bound
        segmented_sieve(low, high);
    }
}
