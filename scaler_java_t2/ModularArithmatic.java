class ModularArithmatic{

    /**
     * Q. given 7 balls of gold color , but only one of them is made of gold. if you count at A and wind back and forth while counting (A,B,C,D,E,F,G,F,E,....) then 1000th ball is golden. find it.
     * 
     * after every set of A,B,C,D,E,F,G,F,E,D,C,B the pattern will repeat. so we need to take modulo with 12.
     * 
     * ans is D.
     */

    /**
     * Q. given a array representing a large prime number p.
     *    return the result (p^2 - 1)%24 . (length of array <= 10^5)
     * 
     * calculating the square wont be possible.
     * 
     * (p^2 -1)%24 = (p+1)(p-1)%24
     *             = (p+1)%24 * (p-1)%24
     * 
     * p+1 and p-1 are even numbers and also every second even number is a multiple of 4. hence (p+1)(p-1)%8 = 0
     * out of every 3 consecutive numbers , one number is always divisible by 3. p is not that number. hence (p+1)(p-1) is also divisible by 3.
     * 
     * ans = 0.
     */

    /**
     * AMAZON
     * Q. given 2 numbers n and m . n>m . find the count of numbers A>0 such that n%A = m%A.
     * Ex: n=10 , m=4
     *     1 - 10%1 == 4%1 
     *     2 - 10%2 == 4%2
     *     3 - 10%3 == 3%3
     *     4        !=
     *     5        !=
     *     6        ==
     *     7        !=
     *     8        !=
     *     9        !=
     *     10       !=
     *     11       !=   .... always != after this.
     * ans = 4.
     * 
     * brute force - check for all numbers from 0 to n-1.
     * 
     * optimized : n%a = m%a --> n%a - m%a = 0
     *                       --> n%a - m%a + a = a
     *                       --> (n%a - m%a + a)%a = a%a
     *                       --> (n-m)%a = 0
     *                       --> (n-m) is multiple of a
     *                       --> need to find all factors of the number : TC : O(sqrt(m))
     * 
     * try to solve using wheel also.
     */

    /**
     * AMAZON , MICROSOFT
     * Q. given an array and a number M. count the number of pairs i,j such that (A[i]+A[j])%M = 0. (i,j) is same as (j,i).
     * Ex: A : 4,7,6,5,5,3 : (0,3) (0,4) (1,3) (1,4) (2,5) : ans = 5
     * 
     * brute force - TC : O(N^2)
     * 
     */

    /*
     * Q. given an array of size n , return true if there exists a subarray with sum divisible by n.
     *    i.e. sum[L-R]%n = 0
     * 
     * ans = true. you will always find atleast 1 sub-array whose sum is divisible by n.
     */

    /**
     * Q. given an array representing a number A and another number N . return A%N.
     * 
     * |A| <= 10^5
     * 0<=A[i]<=9
     * 1<=N<=10^9
     * 
     * Ex: {1,2,3,8,9} , N=100 : A%N = 89
     */

    static int modAdd(int a, int b, int m) {
        return ((a % m) + (b % m)) % m;
    }

    static int modMult(int a, int b, int m) {
        return ((a % m) * (b % m)) % m;
    }

    public static int largeNumModulo(int[] num, int mod) {
        int pv = 1;
        int ans = 0;

        for (int i = num.length - 1; i >= 0; i--) {
            int val = modMult(pv, num[i], mod);
            ans = modAdd(ans, val, mod);
            pv = modMult(pv, 10, mod);
        }

        return ans;
    }

    public static void main(String[] args){

    }
}

/**
 * things wrap around due to modular arithmatic
 * 
 * wheel maths
 * 
 * (a+b)%m = (a%m + b%m)%m
 * (a*b)%m = (a%m * b%m)%m
 * (a-b)%m = (a%m - b%m + m)%m
 * 
 * explore (a/b)%m if intrested in cp.
 * 
 * we can prove all divisiblity tests by modular arithmatics
 */