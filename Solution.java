import java.util.*;

public class rought{
    
}

public int countPrimes(int n) { //simple sieve use
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




public class hi {
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


public class Solution {
    
    public static int gcdd(int a , int b)
    {
        if(a==0) return b ;         
        return gcdd(b%a , a) ;
    }   
    
    
    public static int eulerr(int n)
    {
        int count = 1 ;

        for(int i = 2 ; i < n ; i++)
            if(gcdd(i,n)==1) count++ ; 
        
        return count ; 
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        int ans ;
        ans = eulerr(a);
        System.out.println(ans);
    
    }
}



public class hello {
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            
            if (!map.containsKey(leftChar)) { //not a symmetric digit
                return false;
            } else if (map.get(leftChar) != rightChar) { // is symmetric , so check if it matches with right side
                return false;
            }
            left++;
            right--;
        }
        return true; //otherwise true
    }
    public static void main(String[] args) {
        String num = "609"; // Example input
        System.out.println(num + " is strobogrammatic: " + isStrobogrammatic(num));
    }
}




class GFG {

  // definition function
  static ArrayList<String> numdef(int n, int length) {
    ArrayList<String> result = new ArrayList<String>();
    if (n == 0){
      result.add("");
      return result;
    }
    if (n == 1) {
      result.add("1");
      result.add("0");
      result.add("8");
      return result;
    }

    ArrayList<String> middles = numdef(n - 2, length);

    for (String middle : middles) {
      if (n != length)
        result.add("0" + middle + "0");

      result.add("8" + middle + "8");
      result.add("1" + middle + "1");
      result.add("9" + middle + "6");
      result.add("6" + middle + "9");
    }

    return result;
  }

  // strobogrammatic function
  static ArrayList<String> strobogrammatic_num(int n) {
    ArrayList<String> result = numdef(n, n);
    return result;
  }

  // Driver Code
  public static void main(String[] args) {
    // Print all Strobogrammatic numbers for n = 2
    for (String num : strobogrammatic_num(2))
      System.out.print(num + " ");
  }
}

// This code is contributed by Oprix



public class Solution {


    // k is size of num[] and rem[].  Returns the smallest
    // number x such that:
    //  x % num[0] = rem[0], 
    //  x % num[1] = rem[1], 
    //  ..................
    //  x % num[k-2] = rem[k-1]
    // Assumption: Numbers in num[] are pairwise coprime 
    // (gcd for every pair is 1)
    
    public static int reminderth(int num[] , int rem[] , int k)
    {
        int x = 1 ;//starting posi
        
        while(true)
        {
            int j ;
            
            for(j = 0 ; j<=k-1 ; j++) //traverse both arrays
                if (x%num[j] != rem[j]) break;
            
            if(j==k) return x; //smallest number = answer
            
            x++ ;            
        }

    }
    
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt();
        int num[] = new int[k] ; 
        int rem[] = new int[k] ; 
        
        for(int i= 0 ; i<k ; i++)
            num[i] = sc.nextInt() ;        
        
        for(int i= 0 ; i<k ; i++)
            rem[i] = sc.nextInt() ;        
        
        int ans = reminderth(num , rem, k);
        System.out.println(ans) ;
        
    }
}


public class Solution {
    
    public static int  bulb(int a)
    {
        return (int)Math.sqrt(a);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in) ;
        
        int x = sc.nextInt() ;
        int ans = bulb(x);
        
        System.out.println(ans);
    
    
    }
}

// C++ program for the above approach
// #include<bits/stdc++.h>
// using namespace std;

// Function to minimum no. of apples
int minApples(int M,int K,int N,int S,int W,int E){
	// If we get all required apple from South
	if(M <= S * K) return M;

	// If we required trees at East and West
	else if(M <= S * K + E + W) return S * K + (M-S * K) * K;

	// If we doesn't have enough red apples
	else return -1;

}

// Driver Code
int main(){
	
	// No. of red apple for gift
	int M = 10;

	// No. of red apple in each tree
	int K = 15;

	// No. of tree in North
	int N = 0;
	// No. of tree in South
	int S = 1;
	// No. of tree in West
	int W = 0;
	// No. of tree in East
	int E = 0;

	// Function Call
	int ans = minApples(M,K,N,S,W,E);
	cout<<ans<<endl;

}


