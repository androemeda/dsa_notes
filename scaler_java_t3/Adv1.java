class Adv1{

    static int mod = 1000000007;

    public static int diceCombinationsHelper(int sum , Integer[] dp){
        if(sum < 0) return 0;
        if(sum == 0) return 1;
        if(dp[sum] != null) return dp[sum];
        int option1 = diceCombinationsHelper(sum-1 , dp);
        int option2 = diceCombinationsHelper(sum-2 , dp);
        int option3 = diceCombinationsHelper(sum-3 , dp);
        int option4 = diceCombinationsHelper(sum-4 , dp);
        int option5 = diceCombinationsHelper(sum-5 , dp);
        int option6 = diceCombinationsHelper(sum-6 , dp);
        return dp[sum] = option1+option2+option3+option4+option5+option6;
    }

    public static int diceCombinations(int n){
        Integer[] dp = new Integer[n+1];
        return diceCombinationsHelper(n , dp);
    }

    public static int coinCombinations1Helper(int sum , int[] values , Integer[] dp){
        if(sum < 0) return 0;
        if(sum == 0) return 1;
        if(dp[sum] != null) return dp[sum];
        long ans = 0;
        for(int i=0 ; i<values.length ; i++){
            ans += coinCombinations1Helper(sum-values[i] , values , dp);
            ans %= mod;
        }
        return dp[sum] = (int)ans;
    }

    public static int coinCombinations1(int n , int x , int[] values){
        Integer[] dp = new Integer[x+1];
        return coinCombinations1Helper(x , values , dp);
    }

    /**
     * Q. given an array , find and print a subset having sum equal to target. if doesnt exist , print empty string.
     *    TC : O(N*target)
     * 
     * recover method
     */
    // public static void printSubset(int[] array , int target){
    //     System.out.print("");
    //     for(int i=0 ; i<array.length ; i++){
    //         if(printSubsetHelper(array , i , target)){
    //             System.out.print(array[i]+" ");
    //             break;
    //         }
    //     }
    // }

    /**
     *    https://atcoder.jp/contests/dp/tasks/dp_f
     * 
     * Q. You are given strings s and t. Find one longest string that is a subsequence of both s and t.
     */
    public static String printLCS(String s , String t){
        
    }

    public static void main(String[] args){
        // System.out.println(diceCombinations(4));
        System.out.println(coinCombinations1(3 , 9 , new int[] {2,3,5}));
    }
}

/* 
import java.util.*;

// class Main{
//     static int mod = 1000000007;

//     public static int coinCombinations2Helper(int sum , int[] values , int index , Integer[][] dp){
//         if(sum < 0) return 0;
//         if(sum == 0) return 1;
//         if(index == values.length) return 0;
//         if(dp[sum][index] != null) return dp[sum][index];
//         int option1 = coinCombinations2Helper(sum-values[index] , values , index , dp);
//         int option2 = coinCombinations2Helper(sum , values , index+1 , dp);
//         return dp[sum][index] = (option1+option2)%mod;
//     }

//     public static  int coinCombinations2(int n , int sum , int[] values){
//         Integer[][] dp = new Integer[sum+1][n+1];
//         return coinCombinations2Helper(sum , values , 0 , dp);
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt() , x = sc.nextInt();
//         int[] values = new int[n];
//         for(int i=0 ; i<n ; i++){
//             values[i] = sc.nextInt();
//         }
//         System.out.println(coinCombinations2(n , x , values));
//     }
// }


// class  Main{

//     static int mod = 1000000007;

//     static int[][] dp = new int[2][1000001];

//     public static int coinCombinations2(int sum , int[] values){
//         for(int i=values.length ; i>=0 ; i--){
//             for(int j=0 ; j<=sum ; j++){
//                 if(j == 0) {
//                     dp[i%2][j] = 1;
//                     continue;
//                 }
//                 if(i == values.length){
//                     dp[i%2][j] = 0;
//                     continue;
//                 }

//                 //lets skip this.
//                 int ans1 = dp[(i+1)%2][j];

//                 //take this atleast once.
//                 int ans2 = (j-values[i] >= 0) ? dp[i%2][j-values[i]] : 0;

//                 dp[i%2][j] = (ans1+ans2)%mod;
//             }
//         }
//         return dp[0][sum];
//     }

//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt() , x = sc.nextInt();
//         int[] values = new int[n];
//         for(int i=0 ; i<n ; i++){
//             values[i] = sc.nextInt();
//         }
//         System.out.println(coinCombinations2(x , values));
//     }

// }


import java.util.*;

class Main {

    public static int helper(String A , int i , String B , int j , Integer[][] dp , StringBuilder sb){
        
        if(i<0 || j<0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(A.charAt(i) == B.charAt(j)){
            dp[i][j] = 1 + helper(A , i-1 , B , j-1 , dp , sb);
            sb.append(B.charAt(j));
        }
        else{
            int option1 = helper(A , i-1 , B , j , dp , sb);
            int option2 = helper(A , i , B , j-1 , dp , sb);
            dp[i][j] = Math.max(option1 , option2);
        }

        return dp[i][j];
    }

    public static void longestCommonSubsequence(String A, String B) {
        Integer[][] dp = new Integer[A.length()][B.length()];
        StringBuilder sb = new StringBuilder("");
        helper(A , A.length()-1 , B , B.length()-1 , dp , sb);
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        longestCommonSubsequence(s , t);
    }
}
 */