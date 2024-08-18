class PrimeNumbers{

    /**
     * Q. given a number, generate all prime numbers from 1 to n.
     * 
     * TC : O(N*log(logN)  ~=  N)
     * SC : O(N)
     */
    public static void seive(int n){

        boolean[] isPrime = new boolean[n+1];

        for(int i = 2 ; i<=n ; i++){
            isPrime[i] = true;
        }

        for(int i=2 ; i*i<=n ; i++){
            
            if(isPrime[i]){ 
                for(int j = i*i ; j<=n ; j=j+i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0 ; i<=n ; i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }

    /**
     * Q. given a number n , return all prime factors of n.
     * 
     * approach 1 : use seieve method to get all primes till n then iterate over them and check for divisiblity.
     *              tc : O(nlog(logn))
     *              sc : O(n)
     *              optimization --> iterate only till sqrt(n). --> tc : O(sqrt(n)log(log(sqrt(n)))) ~= O(sqrt(n))
     *                                                              sc : O(sqrt(n))
     * 
     * approach 2 :  TC : O(sqrt(n) + log_2(n)) = O(sqrt(n))  (log_2(n) comes in worst case when the number is a power of 2)
     *               SC : O(1)
     */
    public static void primeFactors(int n)
    {
        while (n%2==0)
        {
            Systemystem.out.print(2 + " ");
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                System.out.print(i + " ");
                n /= i;
            }
        }
        if (n > 2)
            System.out.print(n);
    }

    /*
     * Q. given q queries , in every query we get a number in range [2,n], return the prime factors.
     * Ex: n=100
     *     q=3 : 24 - 2*2*2*3
     *           100 - 2*2*5*5
     *           18 - 2*3*3
     * 
     * do some preprocessing
     * TC : O(nlog(log(n)) + qlog(n))
     * SC : O(n)
     * 
     */
    
    public static void primeFactors(int n){

        for(int i=2 ; i*i<=n ; i++){
            while(n%i == 0){
                System.out.println(i);
                n = n/i;
            }
        }

        if(n>1) System.out.println(n);
    }
    
    public static void main(String[] args){
        // seive(100);
        primeFactors(160);
    }
}