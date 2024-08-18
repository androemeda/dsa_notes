class GCD{

    public static int gcd1(int a , int b){
        // tc = o(n)
        a = Math.abs(a);
        b = Math.abs(b);
        if(a == 0 || b == 0) return a+b;
        for(int i=Math.min(a , b) ; i>=1 ; i--){
            if(a%i == 0 && b%i == 0) return i;
        }
        return 1;
    }

    public static int gcd2(int a , int b){
        // tc = o(n) but better than gcd1
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(b == 0) return a;
        return gcd2(b , a-b);
    }

    public static int gcd3(int a , int b){
        // tc = o(logn)
        if(b == 0) return a;
        return gcd3(b , a%b);
    }

    /*
     * Q. given an array, return true if there exists a sub-sequence with gcd=1 .
     * Ex: A = {46 , 34 , 49 , 81} : true
     * Ex: A = {14 , 21 , 28 , 7} : false
     * 
     * find gcd of complete array. if it is 1 then true , else false.
     * 
     * tc : o(nlogn)
     */

    /**
     * Q. given an array , calculate gcd of factorials of all values.
     * Ex: A = {4 , 3 , 6 , 7} : gcd(4! , 3! , 6! , 7!)
     * 
     * factorial of smallest number.
     */

    /**
     * Q. given health of n players .
     *    if player i attackes player j
     *       if(h[i] >= h[j]) player j dies
     *       else h[j] = h[j]-h[i]
     * find the minimum possible health of the winner.
     * 
     * Ex: [10 , 12 , 4] : ans = 2
     * 
     * player with minimum health should start attacking.
     * 
     * ans = gcd of the array
     * 
     * tc = o(nlogn)
     */

    public static void main(String[] args){
        System.out.println(gcd1(30 , 54));
        System.out.println(gcd2(30 , 54));
        System.out.println(gcd3(30 , 54));
    }
}

/*
 * GCD can never be -ve
 * gcd(a , 1) = 1
 * gcd(a , 0) = |a|
 * gcd(0 , 0) = not defined
 * gcd(a,b,c) = gcd(gcd(a,b),c)
 * gcd(a,b) = gcd(b , a-b) ****
 * gcd(a,b) = gcd(b , a%b) ****
 */