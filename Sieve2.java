import java.util.*;

 // just algorithm and not function to call
int Simple_sieve(int n)
{ // gives and array from elemnt 0 to n , where true = composite , false = prime

    if (n <= 1) {
        return 0;
    } // 0 and 1 are not prime , so ans = 0 integer (no prime number in the range)

    boolean allnum[] = new boolean[n + 1];

    for (int i = 2; i * i <= n; i++) // outer loop. optimized iteration so that i*i donot fall outside n (bigger than
                                     // n) in the inner loop
    {
        if (allnum[i] == false) // i.e not rejected yet (reject bcz of composite bcz of multiple of number less
                                // than this) (so it is prime till now)
        {
            // go ahead and marks it's mutiple as composite (= true)
            for (int j = i * i; j < n; j += i) // start j = 7*7(i*i) and increase j by 7(=i)
            {
                allnum[j] = true; // in final array true = composite , false = prime
            }
        }

    }

}

public int countPrimes(int n) { // simple sieve use

    if (n <= 1) {
        return 0;
    } // 0 and 1 are not prime, so ans = 0 (no prime number in the range)

    // Correct size of the array should be n, not n + 1 (as we want numbers strictly
    // less than n)
    boolean allnum[] = new boolean[n];

    // Use Sieve of Eratosthenes to mark non-prime numbers
    for (int i = 2; i * i < n; i++) // outer loop. Optimized iteration so that i * i doesn't exceed n
    {
        if (!allnum[i]) // i.e. not marked yet, so it is prime till now
        {
            // Mark multiples of i as composite
            for (int j = i * i; j < n; j += i) // start j from i * i and mark multiples of i
            {
                allnum[j] = true; // true means it's composite (not prime)
            }
        }
    }

    // Count the number of primes
    int count = 0;
    for (int i = 2; i < n; i++) // start from 2 because 0 and 1 are not prime
    {
        if (allnum[i] == false) {
            count++;
        }
    }

    return count; // return the count of prime numbers less than n
}


