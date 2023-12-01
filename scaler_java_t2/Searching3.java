class Searching3{

    /**
     * given a number find the floor of sqrt(n).
     * Ex: n=25 ans=5  ,  n=20 ans=4  ,  n=110 ans=10
     * TC: O(logN)
     * SC: O(1)
     */
    public static int floorOfSqrtN(int n){
        int s=1;
        int e=n;
        int ans=-1;
        while(s<=e){
            int mid= s + ((e-s)/2);
            if(mid*mid==n) return mid;
            if(mid*mid>n) e=mid-1;
            if(mid*mid<n){
                ans = mid;
                s=mid+1;
            }
        }
        return ans;
    }

    /**
     * AMAZON
     * Q. MAX NO. OF STAIRS
     *    given n briks , count how many stairs can you create.
     * Ex: n=10 : 1,2,3,4 (bricks in each row) ans=4.
     * in last row we can have lesser number of bricks. all n-1 rows should follow the pattern strictly
     * Brute Force: keep adding 1+2+3... till you get n
     *              TC: O(sqrt(N)) ----HW: FIND HOW----
     * Better approach: O(logN)
     */
    public static int countOfStairs(int n){
        return 1;
    }

    /**
     * GOOGLE , AMAZON
     * Q. Nth MAGICAL NUMBER
     * given n , a and b
     * return the nth number which is either divisible by a or b or both.
     * Ex: n=5 , a=2 , b=3 : {2,3,4,6,8,9,10,12...} ans=8.
     */
    public static int divisibleByAandB(int n){
        return 1;
    }

    /**
     * Q. AGGRESIVE COWS
     * given a sorted array of positive integers
     * array represents positions of room where cows can be placed.
     * given a positive no. k which is the count of cows.
     * 2<=k<=n
     * return the max value of the minimum distance between any 2 cows.
     * Ex: A: [1 2 4 8 9]    k=3  ans=3 
     */
    public static int aggresiveCows(int[] A , int k){
        return 1;
    }

    public static void main(String[] n){
        System.out.println(floorOfSqrtN(102));
    }
}


// HINTS TO APPLY BS
// largest which is smaller than something,
// smallest which is greater than something,
// maximising the minimum,
// minimising the maximum
