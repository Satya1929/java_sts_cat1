package Me;
import java.util.*;

public class Sieve_trick {
    


public class Solution_simple_sieve {//brute force //O(n*rootn)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//input

        for (int i = 2; i <= n; i++)
            if (isPrime(i)) 
                System.out.print(i + " ");

    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
    
        for (int i = 2; i * i <= num; i++) 
            if (num % i == 0) return false;

        return true;
    }
}



public class Solution_segmented_sieve { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the range [L, R]
        int L = sc.nextInt();
        int R = sc.nextInt();
        
        // Iterate through the range and check for primes
        for (int i = L; i <= R; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        // Check for divisors up to √num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}



}
