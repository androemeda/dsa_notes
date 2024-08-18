import java.util.*;

class Adv4{

    // cses - Subarray Distinct Values
    public int subarrayDistinctValues(int[] arr , int k){

        HashMap<Integer , Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        map.put(arr[l] , 1);

        return  -1;

        // while(l <= r){
        //     if(map.size() <= k) return 0;
        // }
    }

    // cses - Subarray Sums II
    public static int subarraySumsII(int[] arr , int k){

        HashMap<Integer , Integer> map = new HashMap<>();

        int ans = 0;

        for(int i=1 ; i<arr.length ; i++){
            arr[i] += arr[i-1];
        }

        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == k){
                ans++;
            }
            if(map.containsKey(arr[i] - k)) ans += map.get(arr[i] - k);
            if(!map.containsKey(arr[i])) map.put(arr[i] , 0);
            map.put(arr[i] , map.get(arr[i])+1);
        }

        return ans;
    }

    // leetcode - 2364 - count number of bad pairs 

    // AtCoder - D- Distinct Trio : "https://atcoder.jp/contests/abc252/tasks/abc252_d"
    // in problems with i,j,k try fixing j
    public int distinctTrio(int[] arr){
        return 0;
    }

    // AtCoder - D - Another Sigma Problem : "https://atcoder.jp/contests/abc353/tasks/abc353_d"
    public int anotherSigmaProblem(int[] arr){
        
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() , k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        // System.out.println(subarrayDistinctValues(arr , k));
        System.out.println(subarraySumsII(arr , k));

    }
}