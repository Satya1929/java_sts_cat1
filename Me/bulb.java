package Me;

import java.util.Scanner;

public class bulb {
    
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
