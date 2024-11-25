package Me;

import java.util.Scanner;

public class reminder {
    

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
