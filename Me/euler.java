package Me;
public class euler {
    
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
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        int ans ;
        ans = eulerr(a);
        System.out.println(ans);
    
    }
}